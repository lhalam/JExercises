/**
 * Created by Ihor Demkovych on 07.03.15.
 */
function validator(element) {
    if ((($('#testName').code().length) == 0) || (($('#testDescription').code().length) == 0)) {
        $(element).popover({
            trigger: 'manual',
            content: 'Please, fill the fields',
            placement: 'top'
        }).popover('show');
        setTimeout(function () {
            $(element).popover('hide');
        }, 2000);
        return false;
    }
    return true;
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
    $("#create").on('click', function () {
        if (validator($(this))) {
            dataTest.testName = $('#testName').code().toString();
            dataTest.testDescription = $('#testDescription').code().toString();
            if (document.getElementById("private").checked) {
                dataTest.isPublic = false;
            }
            $.ajax({
                url: baseDir + "/tests/create",
                type: 'POST',
                dataType: 'html',
                data: JSON.stringify(dataTest),
                contentType: 'application/json',
                mimeType: 'application/json',
                async: false,
                success: function (testId) {
                    dataTest.testId = testId;
                }
            });
            if (!dataTest.isPublic) {
                $.ajax({
                    url: baseDir + "/public/link/generate",
                    type: 'POST',
                    dataType: 'html',
                    data: JSON.stringify(dataTest),
                    contentType: 'application/json',
                    mimeType: 'application/json',
                    async: false,
                    success: function (url) {
                    var linkData = {};
               		linkData.testId = dataTest.testId;
               		linkData.shortCode = url;
               		saveLink(linkData);
                    }
                });
            }
            window.location.href = baseDir + "/tests/" + dataTest.testId + "/edit";
        }
    });
 });
