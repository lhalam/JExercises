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
    $("#title").html('View current test');
    $("#create").addClass('hidden');

    $.ajax({
        url: location.pathname,
        type: 'POST',
        dataType: 'application/json',
        async: false,
        data: '',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (dataResponse) {
            dataTest = JSON.parse(dataResponse);
            $("#testName").append("<p>" + dataTest.testName.toString() + "</p>");
            $("#testDescription").append("<p>"+dataTest.testDescription.toString()+"</p>");
            if (dataTest.isPublic) {
                document.getElementById("public").checked = true;
            } else {
                document.getElementById("private").checked = true;
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
});