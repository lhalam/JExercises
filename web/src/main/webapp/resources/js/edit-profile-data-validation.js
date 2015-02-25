$(document).ready(function() {
    $.validator.setDefaults({
        ignore: []
    });

    $("#editProfileForm").validate({
        rules : {
            "firstName" : {
                required : true
            },
            "lastName" : {
                required : true
            },
            "password" : {
                required : false
            },
            "matchingPassword" : {
                required : false,
                equalTo : "#password"
            }
        }
    });

});
