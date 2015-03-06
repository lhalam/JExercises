function actionButton(baseDir, id) {
    return '<div class="btn-group btn-group-justified"> <button type="button" style="width:80%;" ' +
        'class="btn btn-danger btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> ' +
        'Action <span class="caret"></span> </button> <ul class="dropdown-menu" role="menu"> ' +
        '<li><a href="' + baseDir + '/user/profile/' + id + '">View Profile</a></li>' +
        '<li><a href="' + baseDir + '/user/profile/' + id + '/edit">Edit Profile</a></li>' +
        '<li class="divider"></li>' +
        '<li><a href="' + baseDir + '/user/attempts/' + id + '">View Attempst</a></li>' +
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
            data: function (dataPost) {
                var columnOrderMap = {};
                var columnFilterMap = {};

                for (var i in dataPost.order) {
                    columnOrderMap[dataPost.columns[dataPost.order[i]['column']]['data']] =
                        dataPost.order[i]['dir'];
                }

                for (var i = 1; i < 4; i++) {
                    columnFilterMap[dataPost.columns[i]['data']] = dataPost.search['value'];
                }

                var customDataPost = {
                    "draw": dataPost.draw,
                    "pageNumber": (dataPost.start / dataPost.length),
                    "pageSize": dataPost.length,
                    "filterMap": columnFilterMap,
                    "orderByMap": columnOrderMap
                };
                return JSON.stringify(customDataPost);
            },
            dataType: 'json',
            contentType: "application/json"
        },
        "columns": [
            {"data": "id"},
            {"data": "firstName"},
            {"data": "lastName"},
            {"data": "email"},
            {"data": "registrationDate"},
            {"data": "role"},
            {
                "orderable": false,
                "data": null,
                "defaultContent": ""
            }

        ],
        "order": [[0, 'asc']],
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
