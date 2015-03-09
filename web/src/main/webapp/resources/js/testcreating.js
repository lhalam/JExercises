/**
 * Created by Ihor Demkovych on 07.03.15.
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

var dataRequest = {
    testName: '0',
    testDescription: '0',
    isPublic: true,
    questionsId: []
};

var selectedData = [];

$(document).ready(function () {
    var baseDir = $("#hidden-attr").attr("data-basedir");

    $('#selectedTable').hide();

    var table = $('#questionGrid').DataTable({
        processing: true,
        serverSide: true,
        fnUpdate: false,
        ajax: {
            url: baseDir + "/testcreating",
            type: 'POST',
            mimeType: 'application/json',
            contentType: 'application/json',
            data: function (dataPost) {
                var columnOrderMap = {};
                var columnFilterMap = {};
                for (var i in dataPost.order) {
                    columnOrderMap[dataPost.columns[dataPost.order[i]['column']]['data']] =
                        dataPost.order[i]['dir'];
                }
                for (var i = 1; i < 3; i++) {
                    columnFilterMap[dataPost.columns[i]['data']] = dataPost.search['value'];
                }
                var customDataPost = {
                    "draw": dataPost.draw,
                    "pageNumber": (dataPost.start / dataPost.length),
                    "pageSize": dataPost.length,
                    "filterMap": columnFilterMap,
                    "orderByMap": columnOrderMap
                };
                return JSON.stringify(customDataPost);
            }
        },
        columns: [
            {data: "id", sClass: "gridtable"},
            {data: "name"},
            {data: "description"},
            {
                data: null, bSortable: false,
                defaultContent: ""
            }
        ],
        order: [[0, 'asc']],
        columnDefs: [{
            targets: -1,
            createdCell: function (td, cellData, rowData, row, col) {
                var idx = $.inArray( rowData.id , dataRequest.questionsId );
                if (idx === -1) {
                    $(td).html(actionButtonAdd(baseDir, rowData.id))
                }
                else {
                    $(td).html(actionButtonRemove());
                }
            }
        },
            {
                targets: 1,
                data: "name",
                render: function (data, type, full, meta) {
                    var name = data.substring(0, 20);
                    if (data.length > 20) {
                        name += "..."
                    }
                    return name;
                }
            },
            {
                targets: 2,
                data: "description",
                render: function (data, type, full, meta) {
                    var description = data.substring(0, 30);
                    if (data.length > 30) {
                        description += "..."
                    }
                    return description;
                }
            }
        ]
    });

    var selectedTable = $('#selected').DataTable({
        data: selectedData,
        columns: [
            {data: "id", sClass: "gridtable"},
            {data: "name"},
            {data: "description"},
            {
                data: null, bSortable: false,
                defaultContent: ""
            }
        ],
        columnDefs: [{
            targets: -1,
            createdCell: function (td, cellData, rowData, row, col) {
                    $(td).html(actionButtonRemove(baseDir, rowData.id));
            }
        },
            {
                targets: 1,
                data: "name",
                render: function (data, type, full, meta) {
                    var name = data.substring(0, 20);
                    if (data.length > 20) {
                        name += "..."
                    }
                    return name;
                }
            },
            {
                targets: 2,
                data: "description",
                render: function (data, type, full, meta) {
                    var description = data.substring(0, 30);
                    if (data.length > 30) {
                        description += "..."
                    }
                    return description;
                }
            }
        ],
        bRetrieve: true,
        bDestroy: true
    });

    $('#testgrid_wrapper').removeClass('dataTables_wrapper');

    $('#all').on('click', function () {
        $('#addTable').show();
        $('#selectedTable').hide();
    });

    $('#select').on('click', function () {
        $('#addTable').hide();
        $('#selectedTable').show();
    });

    $('#save').on('click',
        function () {
            dataRequest.testName = $('#testName').code().toString();
            dataRequest.testDescription = $('#testDescription').code().toString();
            if (document.getElementById("private").checked) {
                dataRequest.isPublic = false;
            }
            $.ajax({
                url: baseDir + "/testcreating/save",
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

    $('#questionGrid tbody').on('click', '#add', function () {
        var data = table.row($(this).parents('tr')).data();
        var selectedRow = {
            id: '0',
            name: '0',
            description: '0'
        };
        selectedRow.id = data.id;
        selectedRow.name = data.name;
        selectedRow.description = data.description;
        selectedData.push(selectedRow);
        selectedTable.clear();
        selectedTable.rows.add(selectedData).draw();
        dataRequest.questionsId.push(data.id);
        table.draw();
    });

    $('#selected tbody').on('click', '#remove', function () {
        var data = selectedTable.row($(this).parents('tr')).data();
        var idx = $.inArray( data.id, dataRequest.questionsId );
        selectedData.splice( idx, 1 );
        dataRequest.questionsId.splice( idx, 1);
        selectedTable.clear();
        selectedTable.rows.add(selectedData).draw();
        table.draw();
    });

    $('#questionGrid tbody').on('click', '#remove', function () {
        var data = table.row($(this).parents('tr')).data();
        var idx = $.inArray( data.id, dataRequest.questionsId );
        selectedData.splice( idx, 1 );
        dataRequest.questionsId.splice( idx, 1);
        selectedTable.clear();
        selectedTable.rows.add(selectedData).draw();
        table.draw();
    });

});

$(function () {
    $('.summernote').summernote({
        height: 100
    })
});