/**
 * Created by Ihor Demkovych on 16.02.15.
 */
function actionButton(baseDir, id, buttons) {
    var buttonList = '<div class="btn-group btn-group-justified"> <button type="button" style="width:80%;" ' +
        'class="btn btn-danger btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> ' +
        'Action <span class="caret"></span> </button> <ul class="dropdown-menu" role="menu"> ';
    if ($.inArray("START_TEST", buttons) != -1) {
        buttonList +=
            '<li><a href="' + baseDir + '/test/' + id + '">' +
            '<span class="glyphicon glyphicon-play-circle"></span>' +
            ' Start test</a></li>';
    }
    if ($.inArray("VIEW_TEST", buttons) != -1) {
        buttonList +=
            '<li><a href="' + baseDir + '/tests/' + id + '/view">' +
            '<span class="glyphicon glyphicon-search"></span>' +
            ' View test</a></li>';
    }
    if ($.inArray("VIEW_MY_ATTEMPTS", buttons) != -1) {
        buttonList += '<li><a href="' + baseDir + '/attempts/' + id + '">' +
        '<span class="glyphicon glyphicon-list-alt"></span> ' +
        'View my attempts</a></li>';
    }
    if ($.inArray("VIEW_ATTEMPTS", buttons) != -1) {
        buttonList += '<li><a href="' + baseDir + '/attempts/' + id + '">' +
        '<span class="glyphicon glyphicon-list-alt"></span> ' +
        'View attempts</a></li>';
    }
    if ($.inArray("EDIT", buttons) != -1) {
        buttonList += '<li class="divider"></li>' +
        '<li><a href="' + baseDir + '/tests/' + id + '/edit">' +
        '<span class="glyphicon glyphicon-pencil"></span>' +
        ' Edit</a></li>';
    }
    if ($.inArray("DELETE", buttons) != -1) {
        buttonList += '<li><a id="delete">' +
        '<span class="glyphicon glyphicon-trash"></span>' +
        ' Delete</a></li>' +
        '</ul></div>';
    }
    return buttonList;
}

$(document).ready(function () {
    var baseDir = $("#hidden-attr").attr("data-basedir");
    var buttons = {};
    var table = $('#testsGrid').DataTable({
        processing: true,
        serverSide: true,
        ajax: {
            url: baseDir + "/testsgrid",
            type: 'POST',
            mimeType: 'application/json',
            contentType: 'application/json',
            data: function (dataPost) {
                return JSON.stringify(dataPost);
            },
            dataSrc: function (dataResponse) {
                buttons = dataResponse.buttons;
                return dataResponse.data;
            }
        },
        columns: [
            {data: "id", className: "gridtable", searchable: false},
            {data: "name", className: "dt-center"},
            {data: "description", className: "dt-center"},
            {data: "isPublic", className: "dt-center", searchable: false},
            {
                data: null, className: "dt-center col-md-2", searchable: false,
                defaultContent: "", bSortable: false
            }

        ],
        "order": [[0, 'asc']],
        "columnDefs": [{
            "targets": -1,
            "createdCell": function (td, cellData, rowData, row, col) {
                $(td).html(actionButton(baseDir, rowData.id, buttons));
            }
        },
        {
            "targets": -2,
            "createdCell": function (td, cellData, rowData, row, col) {
                if($('#availability').is(':hidden')){
                    $(td).addClass('gridtable');
                }
            }
        }]
    });

    $('#testgrid_wrapper').removeClass('dataTables_wrapper');

    $('#testsGrid tbody').on('click', '#delete', function () {
        var data = table.row($(this).parents('tr')).data();
        $.ajax({
            type: "POST",
            url: baseDir + "/testsgrid/delete",
            data: JSON.stringify(data.id),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (dataResponse) {
                table.ajax.reload();
            }
        });
    });

    $('#addtest').on('click', function () {
        window.location.href = baseDir + '/tests/create';
    });
});