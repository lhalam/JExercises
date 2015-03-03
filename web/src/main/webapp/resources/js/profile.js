function load(path) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        url: path,
        success: function (json) {
            var regDate = new Date(json.registrationDate);
            var birthDate = new Date(json.birthDate);
            var roleUser = "User";
            var roleAdmin = "Admin";
            var role = roleUser;

            $('#userFirstName').append(json.firstName);
            $('#userLastName').append(json.lastName);
            $('#userRegistrationDate').append(regDate.getDate() + '/' +
                (regDate.getMonth() + 1) + '/' + regDate.getFullYear());
            if (json.birthDate != "") {
                $('#userDateOfBirth').append(birthDate.getDate() + '/' +
                    (birthDate.getMonth() + 1) + '/' + birthDate.getFullYear());
            } else {
                $('#userDateOfBirth').append('-');
            }
            if (json.role == "ROLE_ADMIN") {
                role = roleAdmin;
            }
            $('#userRole').append(role);
            $('#userEmail').append('<a href="mailto:' + json.email +
                '}">' + json.email + '</a>');

            $("#loadingIcon").hide();
            $("#profileForm").show();
        },
        error: function (data) {
            alert(data);
        }
    });
}

$(document).ready(function(){
        $("#profileForm").hide();
        var loadURL = $("#hidden-attr").attr("data-post-url");
        load(loadURL);
    }
);
