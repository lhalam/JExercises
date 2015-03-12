$(document).ready(function () {
    var postUrl = $("#hidden-attr").attr("data-post-url");
    $(".userpic").css({"background-image": "url('" + postUrl + "avatar')"});

    $("#editProfileForm")
        .validate(
        {
            ignore: ".ignore, :hidden, :disabled",
            rules : {
                "firstName" : {
                    required : true
                },
                "lastName" : {
                    required : true
                },
                "currentPassword" : {
                    required : true
                },
                "matchingPassword" : {
                    equalTo : "#password"
                },
                "day" : {
                    required : true,
                    dateValid : true
                },
                "month" : {
                    required : true,
                    dateValid : true
                },
                "year" : {
                    required : true,
                    dateValid : true
                }
            },
            messages : {
                "firstName" : {
                    required : "Please enter your First Name"
                },
                "lastName" : {
                    required : "Please enter your Last Name"
                },
                "day" : {
                    dateValid : "Date is invalid"
                },
                "month" : {
                    dateValid : "Date is invalid"
                },
                "year" : {
                    dateValid : "Date is invalid"

                }
            },
            submitHandler : function(form) {
                var editProfileData = {};
                editProfileData.firstName = $(
                    "#firstName").val();
                editProfileData.lastName = $(
                    "#lastName").val();
                editProfileData.password = $(
                    "#currentPassword").val();
                editProfileData.newPassword = $(
                    "#password").val();
                if($("#year").val()) {
                    editProfileData.birthDate = new Date(
                        $("#year").val(), $(
                            "#month").val(), $(
                            "#day").val());
                }
                editProfileData.avatar = $("#avatar-hidden").val();
                editProfileData.role = $("#role").val();

                $("#dangerAlert").hide();
                    $.ajax({
                        url : postUrl + "edit",
                        type : "POST",
                        data : JSON
                            .stringify(editProfileData),
                        dataType : 'json',
                        contentType : "application/json",
                        success : function(
                            response) {
                            if (response.errors.length > 0) {

                                var error = response.errors[0];
                                $('#errorMessage')
                                    .text(error);
                                $('#dangerAlert')
                                    .show();
                            } else {
                                window.location.href = postUrl + "?updated=true";
                            }
                        }
                    })
            },
            showErrors : function(errorMap,
                                  errorList) {
                $
                    .each(
                    this
                        .validElements(),
                    function(index,
                             element) {
                        var $element = $(element);
                        $element
                            .removeClass(
                            "error")
                            .tooltip(
                            "destroy");
                    });

                $
                    .each(
                    errorList,
                    function(index,
                             error) {
                        var $element = $(error.element);
                        $element
                            .attr(
                            "data-original-title",
                            error.message)
                            .tooltip(
                            {
                                placement : "right"
                            })
                            .tooltip(
                            "fixTitle")
                            .addClass(
                            "error");
                        $element
                            .tooltip();
                    });
            }
        });

    $.validator.addMethod("dateValid", function() {
        var day = $("#day").val();
        var matchDay = new Date($("#year").val(), $("#month")
            .val(), day).getDate();
        if (day == matchDay) {
            return true;
        }
        return false;
    }, "Please enter а valid date.");

    $("#dangerAlertClose").click(function () {
        $("#dangerAlert").hide();
    });
});

