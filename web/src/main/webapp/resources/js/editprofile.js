$(document).ready(function() {
    $("#submitButton").click(function() {
        var form = $('#editProfileForm');

            $.ajax({
                type : "POST",
                url : "/web/user/profile/edit",
                dataType : "json",
                data : form.serialize(),
                success : function() {
                        window.location.href = "/web/user/profile";
                }
            });

    });
});