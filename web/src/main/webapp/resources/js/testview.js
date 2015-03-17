/**
 * Created by Ihor Demkovych on 13.03.15.
 */

var dataTest = {
    testId: 0,
    testName: '0',
    testDescription: '0',
    isPublic: true,
    testUrl: '0'
};

$(document).ready(function () {
    var baseDir = $("#hidden-attr").attr("data-basedir");
    $("#viewButtons").removeClass("hidden");
    $("#border").addClass('gridtableborder');
    $("#title").html('View current test');
    $("#createBlock").addClass('hidden');
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
            $("#getAvailability").removeClass("hidden");
            $("#setAvailability").addClass("hidden");
            if (dataTest.isPublic) {
                $("#getAvailability").html('<strong>Availability:</strong><div class="form">Test is public</div>');
            } else {
                $("#getAvailability").html('<strong>Availability:</strong><div class="form">Test is private</div>' +
                '<br><strong>Public link:</strong><br><a href="http://' + window.location.host + baseDir +
                '/' + dataTest.testUrl + '">http://' + window.location.host + baseDir +
                '/' + dataTest.testUrl+'</a>');
            }
            $('#testName').addClass('form');
            $('#testDescription').addClass('form');
        }
    });

    $('#allQuestions').hide();
    $('#addNewQuestion').hide();
    $('#selectedQuestions').hide();
    $('#update').hide();
    $('#allQuestionsTable').hide();
    $('#tables').removeClass('hidden');
    $('#textToTables').hide();
    $('#testgrid_wrapper').removeClass('dataTables_wrapper');

    $('#selectedQuestionsGrid').DataTable({
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

    $('#viewEdit').on('click', function () {
        window.location.href = baseDir + "/tests/" + dataTest.testId + "/edit";
    });

    $('#viewGrid').on('click', function () {
        window.location.href = baseDir + "/testsgrid";
    });
});
