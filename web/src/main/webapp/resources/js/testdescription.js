var testid;
var baseDir;

function sendPost() {
    $.ajax({
            url: location.pathname,
            contentType: "application/json",
            type: 'POST',
            dataType: "json",
            success: function (dataResponse) {
                $('#test-description').html(dataResponse.description);
                $('#panel-title').html("Test №" + dataResponse.id + ": " + dataResponse.name);
                testid = dataResponse.id;
            }
        }
    );
}

$(document).ready(function () {
        baseDir = $("#contextRootHolder").val();
        sendPost();
        startTest();
    }
);

function startTest() {
    $("#btnsub").click(
        function () {
            $.ajax({
                    type: "POST",
                    url: baseDir+"/test/" + testid + "/start",
                    contentType: "application/json",
                    success: function () {
                        window.location.replace(baseDir+"/test/" + testid + "/process");
                    }
                }
            );
        }
    )
}

