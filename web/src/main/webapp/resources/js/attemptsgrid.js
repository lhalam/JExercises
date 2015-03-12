function viewButton(baseDir, id, disabled) {
    return '<a href="' + baseDir + '/test/result/' + id + '" target="_blank"' +
        ' class="btn btn-success btn-xs btn-shortened"' + disabled + '>' +
        '<span class="glyphicon glyphicon-new-window"></span> View</a>';
}

$(document).ready(function () {
    var baseDir = $("#hidden-attr").attr("data-basedir");
    var postUrl = $("#hidden-attr").attr("data-post-url");
    var currentUser = $("#hidden-attr").attr("data-user");

    var dt = $('#attempts_table').DataTable({
        "processing": true,
        serverSide: true,
        ajax: {
            url: postUrl,
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
                "visible": false

            },
            {
                "data": "testName",
                "className": "dt-center"
            },
            {
                "data": "createdDate",
                "searchable": false,
                "className": "dt-center"
            },
            {
                "data": "result",
                "searchable": false,
                "orderable": false,
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
        "order": [[2, 'desc']],
        "columnDefs": [{
            "targets": 2,
            "data": "createdDate",
            "render": function (data, type, full, meta) {
                var date = new Date(data);
                return date.getDate() + '/' +
                    (date.getMonth() + 1) + '/' + date.getFullYear();
            }
        },
            {
            "targets": 4,
            "createdCell": function (td, cellData, rowData, row, col) {
                var disabled = "";
                var attemptId = rowData.id;

                if((rowData.result == '-') && (currentUser == "true")) {
                    disabled = "disabled";
                    attemptId = "";
                }
                $(td).html(viewButton(baseDir, attemptId, disabled));
            }
        }
        ]

    });
});
