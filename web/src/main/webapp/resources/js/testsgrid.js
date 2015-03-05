/**
 * Created by Ihor Demkovych on 16.02.15.
 */
$(document).ready(function () {
    var table = $('#testsGrid').DataTable({
        processing: true,
        serverSide: true,
        fnUpdate: false,
        ajax: {
            url: "/web/testsgrid",
            type: 'POST',
            mimeType: 'application/json',
            contentType: 'application/json',
            data: function (dataRequest) {
                return JSON.stringify(dataRequest);
            },
            dataSrc: "testGridRows"
        },
        columns: [
            {data: "id", sClass: "gridtable"},
            {data: "description"},
            {data: "isPublic", bSortable: false},
            {
                data: null, bSortable: false,
                defaultContent: '<button type="button" class="btn btn-danger pull-right" id="delete">' +
                '<span class="glyphicon glyphicon-trash"></span> Delete</button>' +
                '<a  type="button" class="btn btn-warning pull-right" id="edit">' +
                '<span class="glyphicon glyphicon-pencil"></span> Edit</a>' +
                '<button type="button" class="btn btn-success pull-right" id="attempts">' +
                '<span class="glyphicon glyphicon-list-alt"></span> Attempts</button>' +
                '<button type="button" class="btn btn-primary pull-right" id="test">' +
                '<span class="glyphicon glyphicon-eye-open"></span> Complete</button>'
            }
        ]
    });

    $('#testgrid_wrapper').removeClass('dataTables_wrapper');
    $('#testsGrid tbody').on('click', '#delete', function () {
        var data = table.row($(this).parents('tr')).data();
        $.ajax({
            type: "POST",
            url: "/web/test/delete",
            data: JSON.stringify(data.id),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (dataResponse) {
                table.ajax.reload();
            }
        });
    });

    $('#testsGrid tbody').on('click', '#edit', function () {
        var data = table.row($(this).parents('tr')).data();
        window.location.href = "/web/test/edit/"+data.id;
    })

    $('#testsGrid tbody').on('click', '#attempts', function () {
        var data = table.row($(this).parents('tr')).data();
        window.location.href = "/web/attempts/"+data.id;
    })

    $('#testsGrid tbody').on('click', '#test', function () {
        var data = table.row($(this).parents('tr')).data();
        window.location.href = "/web/test/"+data.id;
    })
});