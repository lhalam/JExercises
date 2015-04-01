var currentQuestion = 0;
var questionsQuantity;
var questionsListId;
var attemptId;
var baseDir;

var dataRequest = {
    "attemptId": 0,
    "userAnswer": '0',
    "currentQuestionId": 0,
    "changeQuestionId": 0
};

$(document).ready(function () {
    baseDir = $("#contextRootHolder").val();
    buildPage();
    nextRequest();
    previousRequest();
    submitTest();
    preventReload();
    tabHandler();
});

function buildPage() {
    representButton();
    $.ajax({
        url: location.pathname,
        contentType: "application/json",
        type: 'POST',
        dataType: "json",
        success: function (dataResponse) {
            attemptId = dataResponse.attemptId;
            questionsQuantity = dataResponse.questionQuantity;
            questionsListId = dataResponse.questionListId;
            if (questionsQuantity == 1) {
                $('#btnnext').hide();
                $('#btnfinish').show();
                $('#btnprev').hide();
            }
            $('#question-description').html(dataResponse.questionDescription);
            $('#panel-title').html("Task " + ++currentQuestion + "/" + questionsQuantity + ": " + dataResponse.questionName);
            $('#loadingIcon').hide();
        }
    });
}

function nextRequest() {
    $("#btnnext").click(function () {
        if (validateUserAnswer($(this))) {
            buildNextRequestData();
            representButton();
            sendRequestData();
        }
    })
}
function previousRequest() {
    $("#btnprev").click(function () {
        buildPreviousRequestData();
        representButton();
        sendRequestData();
    })
}

function submitTest() {
    $("#btnfinish").click(function () {
        if (validateUserAnswer($(this))) {
            window.onbeforeunload = null;
            buildSubmitData();
            $.ajax({
                type: "POST",
                url: baseDir+"/test/process/submit",
                dataType: 'html',
                data: JSON.stringify(dataRequest),
                contentType: "application/json; charset=utf-8",
                mimeType: 'application/json',
                success: function () {
                    window.location.replace(baseDir+"/test/result/" + attemptId);
                },
                error: function () {
                    alert("Error");
                }
            });
        }
    })
}

function buildNextRequestData() {
    dataRequest.attemptId = attemptId;
    dataRequest.userAnswer = $('#question-answer').val().toString();
    dataRequest.currentQuestionId = questionsListId[--currentQuestion];
    dataRequest.changeQuestionId = questionsListId[++currentQuestion];
}

function buildPreviousRequestData() {
    dataRequest.attemptId = attemptId;
    dataRequest.userAnswer = $('#question-answer').val().toString();
    dataRequest.currentQuestionId = questionsListId[--currentQuestion];
    dataRequest.changeQuestionId = questionsListId[--currentQuestion];
}

function buildSubmitData() {
    dataRequest.attemptId = attemptId;
    dataRequest.userAnswer = $('#question-answer').val().toString();
    dataRequest.currentQuestionId = questionsListId[--currentQuestion];
    dataRequest.changeQuestionId = questionsListId[currentQuestion];
}

function representButton() {
    if (currentQuestion == 0) {
        $('#btnnext').show();
        $('#btnfinish').hide();
        $('#btnprev').hide();
    } else if ((currentQuestion + 1) == questionsQuantity) {
        $('#btnnext').hide();
        $('#btnfinish').show();
        $('#btnprev').show();
    } else {
        $('#btnnext').show();
        $('#btnfinish').hide();
        $('#btnprev').show();
    }
}

function sendRequestData() {
    $.ajax({
        type: "POST",
        url: baseDir+"/test/process",
        data: JSON.stringify(dataRequest),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (dataResponse) {
            $('#question-description').html(dataResponse.questionDescription);
            $('#panel-title').html("Task " + ++currentQuestion + "/" + questionsQuantity + ": " + dataResponse.questionName);
            $('#question-answer').val(dataResponse.userAnswer);
        },
        error: function () {
            alert("Error");
        }
    });
}
function preventReload() {
    window.onbeforeunload = function (e) {
        var message = 'If you refresh or close page test will be lost. Are you sure?';
        if (!e) {
            e = window.event;
        }
        if (e) {
            e.returnValue = message;
        }
        return message;
    }
}

function validateUserAnswer(element) {
    if (($('#question-answer').val().length) == 0) {
        $(element).popover({
            trigger: 'manual',
            content: 'Please, input answer',
            placement: 'top'
        }).popover('show');
        $('.form-group').addClass('has-error');
        $(element).children().addClass('has-error-btn');
        setTimeout(function () {
            $(element).popover('hide');
            $('.form-group').removeClass('has-error');
            $(element).children().removeClass('has-error-btn');
        }, 2000);
        return false;
    }
    return true;
}

function tabHandler(){
    $("textarea").keydown(function(e) {
        if(e.keyCode === 9) {
            var start = this.selectionStart;
            var end = this.selectionEnd;
            var $this = $(this);
            var value = $this.val();
            $this.val(value.substring(0, start)
            + "  "
            + value.substring(end));
            this.selectionStart = this.selectionEnd = start + 2;
            e.preventDefault();
        }
    });
}