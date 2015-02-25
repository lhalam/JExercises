$(document).ready(function() {
    $("#successAlert").hide();
    $("#submitButton").click(function() {
        var form = $('#editProfileForm');
            $.ajax({
                type : "POST",
                url : "/web/user/profile/edit",
                dataType : "json",
                data : form.serialize(),
                success : function() {
                    $("#successAlert").show();
                }
            });
    });
    $(".close").click(function(){
        $("#successAlert").hide();
    });
});