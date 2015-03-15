/**
 * Created by Ihor Demkovych on 13.03.15.
 */

var dataTest = {
    testId: 0,
    testName: '0',
    testDescription: '0',
    isPublic: true
};

$(document).ready(function () {
    var baseDir = $("#hidden-attr").attr("data-basedir");
    $("#viewButtons").removeClass("hidden");
    $("#title").html('View current test');
    $("#create").addClass('hidden');
    $('#testName').removeClass('summernote');
    $('#testName').removeClass('form-control');
    $('#testDescription').removeClass('summernote');
    $('#testDescription').removeClass('form-control');
    $.ajax({
        url: location.pathname,
        type: 'POST',
        dataType: 'html',
        async: false,
        data: '',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (dataResponse) {
            dataTest = JSON.parse(dataResponse);
            document.getElementById('testName').innerHTML = dataTest.testName;
            document.getElementById('testDescription').innerHTML = dataTest.testDescription;
            $("#availability").removeClass("hidden");
            $("#check").addClass("hidden");
            if (dataTest.isPublic) {
                $("#availability").html('<strong>Test is public</strong>');
            }   else   {
                $("#availability").html('<strong>Test is private</strong>');
            }
        }
    });

    $('#all').hide();
    $('#add').hide();
    $('#select').hide();
    $('#save').hide();
    $('#allTable').hide();
    $('#edit').removeClass('hidden');
    $('#textToTables').hide();
    $('#testgrid_wrapper').removeClass('dataTables_wrapper');

    $('#selected').DataTable({
        processing: true,
        serverSide: true,
        dom: '<"top"l>rt<"bottom"ip><"clear">',
        ajax: {
            url: baseDir + "/tests/" + dataTest.testId + "/added",
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
                data: null, bSortable: false, className: "gridtable",
                defaultContent: "", searchable: false
            }
        ]
    });

    $('#viewEdit').on('click', function(){
       window.location.href = baseDir + "/tests/" + dataTest.testId + "/edit";
    });

    $('#viewGrid').on('click', function(){
       window.location.href = baseDir + "/testsgrid";
    });
});
