$(document).ready(function () {
    var basedir = $(".hidden-attribute").attr("basedir");
    $(".userpic").css({"background-image": "url('" + basedir + "/user/profile/avatar')"});

    $("#submitButton").click(function () {
        var form = $('#editProfileForm');
        $.ajax({
            type: "POST",
            url: basedir + "/user/profile/edit",
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