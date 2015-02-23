$(document).ready(function() {
    $("#updateButton").click(function(e) {

            $.ajax({
                type : "POST",
                url : "/user/profile/edit",
                dataType : "json"
            });

    });
});