/**
 * Created by Ihor Demkovych on 13.03.15.
 */
function actionButtonAdd() {
    return '<div class="btn-group btn-group-justified"><button type="button" style="width:80%;" ' +
        'class="btn btn-primary btn-xs dropdown-toggle" aria-expanded="false" id="add">' +
        '<span class="glyphicon glyphicon-plus-sign"></span> Add</button></div>';
}

function actionButtonRemove() {
    return '<div class="btn-group btn-group-justified"><button type="button" style="width:80%;" ' +
        'class="btn btn-danger btn-xs dropdown-toggle" aria-expanded="false" id="remove">' +
        '<span class="glyphicon glyphicon-minus-sign"></span> Remove</button></div>';
}

$(function () {
    $('.summernote').summernote({
        height: 100
    })
});

var dataTest = {
    testId: 0,
    testName: '0',
    testDescription: '0',
    isPublic: true
};

$(document).ready(function () {
    var baseDir = $("#hidden-attr").attr("data-basedir");
    $("#title").html('Edit current test');
    $("#create").addClass('hidden');

    $.ajax({
        url: location.pathname,
        type: 'POST',
        dataType: 'html',
        data: '',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (dataResponse) {
            var data = JSON.parse(dataResponse);
            dataTest.testId = data.testId;
            dataTest.isPublic = data.isPublic;
            dataTest.testName = data.testName;
            dataTest.testDescription = data.testDescription;
            $("#testName").code(dataTest.testName.toString());
            $("#testDescription").code(dataTest.testDescription.toString());
            if (dataTest.isPublic) {
                document.getElementById("public").checked = true;
            } else {
                document.getElementById("private").checked = true;
            }
        }
    });

    $('#allTable').hide();
    $('#edit').removeClass('hidden');
    $('#testgrid_wrapper').removeClass('dataTables_wrapper');

    $('#all').on('click', function () {
        $('#addTable').show();
        $('#selectedTable').hide();
    });

    $('#select').on('click', function () {
        $('#addTable').hide();
        $('#selectedTable').show();
    });

    $('#add').on('click', function(){
       window.location.href = baseDir + "/question/create/" + dataTest.testId ;
    });

    var table = $('#questionGrid').DataTable({
        processing: true,
        serverSide: true,
        ajax: {
            url: baseDir + "/tests/all",
            type: 'POST',
            mimeType: 'application/json',
            contentType: 'application/json',
            data: function (dataPost) {
                return JSON.stringify(dataPost);
            }
        },
        columns: [
            {data: "id", className: "gridtable", searchable: false},
            {data: "name", className: "dt-center"},
            {data: "description", className: "dt-center"},
            {
                data: null, bSortable: false, className: "dt-center",
                defaultContent: "", searchable: false
            }
        ],
        order: [[0, 'asc']],
        columnDefs: [{
            targets: -1,
            createdCell: function (td, cellData, rowData, row, col) {
                    $(td).html(actionButtonAdd(baseDir, rowData.id));
            }
        }]
    });

    var selectedTable = $('#selected').DataTable({
        processing: true,
        serverSide: true,
        ajax: {
            url: baseDir + "/tests/selected",
            type: 'POST',
            mimeType: 'application/json',
            contentType: 'application/json',
            data: function (dataPost) {
                return JSON.stringify(dataPost);
            }
        },
        columns: [
            {data: "id", className: "gridtable", searchable: false},
            {data: "name", className: "dt-center"},
            {data: "description", className: "dt-center"},
            {
                data: null, bSortable: false, className: "dt-center",
                defaultContent: "", searchable: false
            }
        ],
        columnDefs: [{
            targets: -1,
            createdCell: function (td, cellData, rowData, row, col) {
                $(td).html(actionButtonRemove(baseDir, rowData.id));
            }
        }]
    });

    $('#save').on('click',
        function () {
            dataTest.testName = $('#testName').code().toString();
            dataTest.testDescription = $('#testDescription').code().toString();
            dataTest.isPublic = true;
            if (document.getElementById("private").checked) {
                dataTest.isPublic = false;
            }
            $.ajax({
                url: baseDir + "/tests/update",
                type: 'POST',
                dataType: 'html',
                data: JSON.stringify(dataRequest),
                contentType: 'application/json',
                mimeType: 'application/json',
                success: function (data) {
                    window.location.href = baseDir + "/testsgrid";
                }
            });
        });

    $('#selected tbody').on('click', '#remove', function () {
        var data = selectedTable.row($(this).parents('tr')).data();
        $.ajax({
            url: baseDir + "/tests/" + dataTest.testId + "/remove",
            type: 'POST',
            dataType: 'html',
            data: data.id,
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function (dataResponse) {
                table.ajax.reload();
                selectedTable.ajax.reload();
            }
        });
    });

    $('#questionGrid tbody').on('click', '#add', function () {
        var data = table.row($(this).parents('tr')).data();
        $.ajax({
            url: baseDir + "/tests/" + dataTest.testId + "/add",
            type: 'POST',
            dataType: 'html',
            data: data.id,
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function (dataResponse) {
                table.ajax.reload();
                selectedTable.ajax.reload();
            }
        });
    });

});