$(document).ready(function () {
    var postUrl = $("#hidden-attr").attr("data-post-url");
    $(".userpic").css({"background-image": "url('" + postUrl + "avatar')"});

    $("#submitButton").click(function () {
        var form = $('#editProfileForm');
        $.ajax({
            type: "POST",
            url: postUrl + "edit",
            dataType: "json",
            data: form.serialize(),
            success: function () {
                $("#successAlert").show();
            }
        });
    });
    $(".close").click(function () {
        $("#successAlert").hide();
    });
});