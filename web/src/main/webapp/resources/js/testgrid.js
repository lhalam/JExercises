/**
 * Created by Ihor Demkovych on 16.02.15.
 */
var searchParametersDto = {
    pagesize: 10,
    pagenumber: 0,
    searchKey: "",
    order: "desc",
    draw: 0
};
$(document).ready(function () {
    var table = $('#testgrid').dataTable({
        "processing": true,
        "serverSide": true,
        "ajax": {
            url: "/web/testgrid",
            type: 'POST',
            mimeType: 'application/json',
            contentType: 'application/json',
            processData: false, // important so the raw data makes it to the beforeSend handler
            beforeSend: function (jqXHR, settings) {
                var data = settings.data;
                searchParametersDto.draw = data.draw;
                searchParametersDto.pagenumber = data.start;
                searchParametersDto.pagesize = data.length;
                searchParametersDto.order = data.order[0].dir;
                searchParametersDto.searchKey = data.search.value;
                data = searchParametersDto;
                settings.data = JSON.stringify(data);
            },
            "dataSrc": "testGridRows"
        },
        "columns": [
            {"data": "id", "sClass": "gridtable"},
            {"data": "description"},
            {"data": "isPublic", "bSortable": false},
            {
                "data": "id",
                "bSortable": false,
                "render": function (data, type, full, meta) {
                    return '<button class="btn btn-primary" value="' +
                        data + '">View</button>'
                }
            },
            {
                "data": "id",
                "bSortable": false,
                "render": function (data, type, full, meta) {
                    return '<button class="btn btn-success" value="' +
                        data + '">View attempts</button>'
                }

            },
            {
                "data": "id",
                "bSortable": false,
                "render": function (data, type, full, meta) {
                    return '<button class="btn btn-warning" value="' +
                        data + '">Edit</button>';
                }
            },
            {
                "data": "id",
                "bSortable": false,
                "render": function (data, type, full, meta) {
                    return '<button class="btn btn-danger" value="' +
                        data + '"><span class="glyphicon glyphicon-trash">' +
                        '</span> Delete</a>';
                }
            }
        ]
    });
    $('#testgrid_wrapper').removeClass('dataTables_wrapper');
    $("#testgrid").on("click", ".btn-primary", function () {
        var id = $(this).val();
        alert("View " + id);
    });
    $("#testgrid").on("click", ".btn-success", function () {
        var id = $(this).val();
        alert("View attempt " + id);
    });
    $("#testgrid").on("click", ".btn-warning", function () {
        var id = $(this).val();
        alert("Edit " + id);
    });
    $("#testgrid").on("click", ".btn-danger", function () {
        var id = $(this).val();
        alert("Delete " + id);
    });
});
