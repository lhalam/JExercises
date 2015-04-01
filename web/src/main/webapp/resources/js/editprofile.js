$(document).ready(function () {
    var postUrl = $("#hidden-attr").attr("data-post-url");
    var baseDir = $("#hidden-attr").attr("data-basedir");
    $(".userpic").css({"background-image": "url('" + postUrl + "avatar')"});
    $("#deleteAvatar").click(function () {
        $("#avatar-hidden").attr("value", "delete");
        $(".userpic").css({"background-image": "url('" + baseDir + "/resources/images/no-avatar.png')"});
    });

    $("#editProfileForm")
        .validate(
        {
            ignore: ".ignore, :hidden, :disabled",
            rules: {
                "firstName": {
                    required: true
                },
                "lastName": {
                    required: true
                },
                "currentPassword": {
                    required: function (element) {
                        return $("#password").val().length > 0;
                    }
                },
                "matchingPassword": {
                    equalTo: "#password"
                },
                "day": {
                    dateValid: true
                },
                "month": {
                    dateValid: true
                },
                "year": {
                    dateValid: true
                }
            },
            messages: {
                "day": {
                    dateValid: "Date is invalid"
                },
                "month": {
                    dateValid: "Date is invalid"
                },
                "year": {
                    dateValid: "Date is invalid"

                }
            },
            submitHandler: function (form) {
                var editProfileData = {};
                var year = $("#year").val();
                var month = $("#month").val();
                var day = $("#day").val();
                editProfileData.firstName = $(
                    "#firstName").val();
                editProfileData.lastName = $(
                    "#lastName").val();
                editProfileData.password = $(
                    "#currentPassword").val();
                editProfileData.newPassword = $(
                    "#password").val();
                if(year) {
                    editProfileData.birthDate = new Date(year, month, day);
                }
                editProfileData.avatar = $("#avatar-hidden").val();
                editProfileData.role = $("#role").val();

                $("#dangerAlert").hide();
                $.ajax({
                    url: postUrl + "edit",
                    type: "POST",
                    data: JSON.stringify(editProfileData),
                    dataType: 'json',
                    contentType: "application/json",
                    success: function (response) {
                        if (response.errors.length > 0) {
                            var error = response.errors[0];
                            $('#errorMessage').text(error);
                            $('#dangerAlert').show();
                        } else {
                            window.location.href = postUrl + "?updated=true";
                        }
                    }
                })
            },
            highlight: function (element) {
                var feedbackElement = getFeedbackElement(element);
                highlightElement(feedbackElement);
                if (!isDateElement(element)) {
                    feedbackElement.addClass('glyphicon-remove');
                }
            },
            unhighlight: function (element) {
                var feedbackElement = getFeedbackElement(element);
                unhighlightElement(feedbackElement);
            },
            errorPlacement: function (error, element) {
                var feedbackElement = getFeedbackElement(element);
                var errorMessage = error.html();
                feedbackElement.attr('data-content', errorMessage);
                feedbackElement.popover({
                    trigger: 'manual',
                    content: errorMessage
                }).popover('show');
            }
        });

    function getFeedbackElement(element) {
        if (isDateElement(element)) {
            return $("#birthDateFeedback");
        }
        return $("#" + $(element).attr("id") + "Feedback");
    }

    function isDateElement(element) {
        var elementName = $(element).attr("name")
        return (elementName == "day" || elementName == "month" || elementName == "year")
    }

    function unhighlightElement(element) {
        element.closest('.form-group')
            .removeClass('has-error');
        element.removeClass('glyphicon-remove')
            .popover('hide');
    }

    function highlightElement(element) {
        element.closest('.form-group')
            .removeClass('has-success')
            .addClass('has-error');
    }

    $.validator.addMethod("dateValid", function () {
        var day = $("#day").val();
        var matchDay = new Date($("#year").val(), $("#month")
            .val(), day).getDate();
        if (day == matchDay) {
            return true;
        }
        return false;
    }, "Please enter а valid date.");

    $('#password').change(function () {
        if ($("#password").val() == '') {
            unhighlightElement($('#currentPasswordFeedback'));
        }
    });

    $("#dangerAlertClose").click(function () {
        $("#dangerAlert").hide();
    });
});

