/**
 * Created by Ihor Demkovych on 07.03.15.
 */

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
    $("#create").on('click', function() {
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
            success: function (testId) {
                window.location.href = baseDir + "/test/" + testId + "/edit";
            }
        });
    });
});
