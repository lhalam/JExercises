function load() {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        url: "/user/profile",
        success: function (json) {
            var regDate = new Date(json.registrationDate);
            var birthDate = new Date(json.birthDate);
            var roleUser = "User";
            var roleAdmin = "Admin";
            var role = roleUser;

            $('#userFirstName').append(json.firstName);
            $('#userLastName').append(json.lastName);
            $('#userRegistrationDate').append(regDate.getDate() + '/' +
                regDate.getMonth() + '/' + regDate.getFullYear());
            if (json.birthDate != "") {
                $('#userBirthDate').append(birthDate.getDate() + '/' +
                    (birthDate.getMonth() + 1) + '/' + birthDate.getYear());
            } else {
                $('#userBirthDate').append('-');
            }
            if (json.role == "ROLE_ADMIN") {
                role = roleAdmin;
            }
            $('#userRole').append(role);
            $('#userEmail').append('<a href="mailto:' + json.email +
                '}">' + json.email + '</a>');
        },
        error: function (data) {
            alert(data);
        }
    });
}
