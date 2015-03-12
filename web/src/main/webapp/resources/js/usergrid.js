function actionButton(baseDir, id) {
    return '<div class="btn-group btn-group-justified"> <button type="button"" ' +
        'class="btn btn-danger btn-xs btn-shortened dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> ' +
        'Action <span class="caret"></span> </button> <ul class="dropdown-menu" role="menu"> ' +
        '<li><a href="' + baseDir + '/user/profile/' + id + '" target="_blank">' +
        '<span class="glyphicon glyphicon-eye-open"></span> View Profile</a></li>' +
        '<li><a href="' + baseDir + '/user/profile/' + id + '/edit" target="_blank">' +
        '<span class="glyphicon glyphicon-pencil"></span> Edit Profile</a></li> ' +
        '<li class="divider"></li>' +
        '<li><a href="' + baseDir + '/user/' + id +'/attempts" target="_blank">' +
        '<span class="glyphicon glyphicon-list-alt"></span> View Attempts</a></li>' +
        '</ul></div>';
}

$(document).ready(function () {
    var baseDir = $("#hidden-attr").attr("data-basedir");

    var dt = $('#users_table').DataTable({
        "processing": true,
        serverSide: true,
        ajax: {
            url: baseDir + '/user/find',
            type: 'POST',
            data: function (data) {
                return JSON.stringify(data);
            },
            dataType: 'json',
            contentType: "application/json"
        },
        "columns": [
            {
                "data": "id",
                "searchable": false,
                "className": "dt-center"
            },
            {
                "data": "firstName",
                "className": "dt-center"
            },
            {
                "data": "lastName",
                "className": "dt-center"
            },
            {
                "data": "email",
                "className": "dt-center"
            },
            {
                "data": "registrationDate",
                "searchable": false,
                "className": "dt-center"
            },
            {
                "data": "role",
                "searchable": false,
                "className": "dt-center"
            },
            {
                "searchable": false,
                "orderable": false,
                "data": null,
                "defaultContent": "",
                "className": "dt-center"
            }

        ],
        "order": [[4, 'desc']],
        "columnDefs": [{
            "targets": 6,
            "createdCell": function (td, cellData, rowData, row, col) {
                $(td).html(actionButton(baseDir, rowData.id));
            }
        },
            {
                "targets": 4,
                "data": "registrationDate",
                "render": function (data, type, full, meta) {
                    var regDate = new Date(data);
                    return regDate.getDate() + '/' +
                        (regDate.getMonth() + 1) + '/' + regDate.getFullYear();
                }
            },
            {
                "targets": 5,
                "data": "role",
                "render": function (data, type, full, meta) {
                    var role = "User";
                    if (data == "ROLE_ADMIN") {
                        role = "Admin";
                    }
                    return role;
                }
            }
        ]

    });
});
