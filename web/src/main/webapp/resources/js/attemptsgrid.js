function viewButton(baseDir, id) {
    return '<a href="#" class="btn btn-success btn-xs btn-block">' +
        '<span class="glyphicon glyphicon-new-window"></span> View</a>';
}

$(document).ready(function () {
    var baseDir = $("#hidden-attr").attr("data-basedir");

    var dt = $('#attempts_table').DataTable({
        "processing": true,
        serverSide: true,
        ajax: {
            url: baseDir + '/user/attempts',
            type: 'POST',
            data: function (data) {
                return JSON.stringify(data);
            },
            dataType: 'json',
            contentType: "application/json"
        },
        "columns": [
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
        "order": [[1, 'desc']],
        "columnDefs": [{
            "targets": 1,
            "data": "createdDate",
            "render": function (data, type, full, meta) {
                var date = new Date(data);
                return date.getDate() + '/' +
                    (date.getMonth() + 1) + '/' + date.getFullYear();
            }
        },
            {
            "targets": 3,
            "createdCell": function (td, cellData, rowData, row, col) {
                $(td).html(viewButton(baseDir, 0));
            }
        }
        ]

    });
});
