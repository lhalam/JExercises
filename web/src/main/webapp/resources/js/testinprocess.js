var currentQuestion = 0;
var questionsQuantity;
var questionsListId;
var attemptId;

var dataRequest = {
    "attemptId": 0,
    "userAnswer": '0',
    "currentQuestionId": 0,
    "changeQuestionId": 0
};

$(document).ready(function () {
    buildPage();
    nextRequest();
    previousRequest();
    submitTest();
});

function buildPage() {
    $('#btnnext').show();
    $('#btnfinish').hide();
    $('#btnprev').hide();
    $.ajax({
        url: location.pathname,
        contentType: "application/json",
        type: 'POST',
        dataType: "json",
        success: function (dataResponse) {
            attemptId = dataResponse.attemptId;
            questionsQuantity = dataResponse.questionQuantity;
            questionsListId = dataResponse.questionListId;
            $('#question-description').html(dataResponse.questionDescription);
            $('#panel-title').html("Task " + ++currentQuestion + "/" + questionsQuantity + ": " + dataResponse.questionName);
        }
    });
}

function nextRequest() {
    $("#btnnext").click(function () {
        buildNextRequestData();
        representButton();
        sendRequestData();
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
        buildSubmitData();
        $.ajax({
            type: "POST",
            url: "/web/test/process/submit",
            dataType: 'html',
            data: JSON.stringify(dataRequest),
            contentType: "application/json; charset=utf-8",
            mimeType: 'application/json',
            success: function (data) {
                window.location.replace("/web/test/result/" + attemptId);
            },
            error: function () {
                alert("Error");
            }
        });

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
        url: "/web/test/process",
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
