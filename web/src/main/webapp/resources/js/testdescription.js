var testid;

function sendPost() {
    $.ajax({
            url: location.pathname,
            contentType: "application/json",
            type: 'POST',
            dataType: "json",
            success: function (dataResponse) {
                $('#test-description').append(dataResponse.description);
                $('#panel-title').append("Test №" + dataResponse.id + ": " + dataResponse.name);
                testid = dataResponse.id;
            }
        }
    );
}

$(document).ready(function () {
        sendPost();
        startTest();
    }
);

function startTest() {
    $("#btnsub").click(
        function () {
            $.ajax({
                    type: "POST",
                    url: "/web/test/" + testid + "/start",
                    contentType: "application/json",
                    success: function () {
                        window.location.replace("/web/test/" + testid + "/process");
                    }
                }
            );
        }
    )
}

