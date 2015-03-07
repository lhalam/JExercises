/**
 * Created by Ihor Demkovych on 16.02.15.
 */
function actionButtonAdmin(baseDir, id) {
    return '<div class="btn-group btn-group-justified"> <button type="button" style="width:80%;" ' +
        'class="btn btn-danger btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> ' +
        'Action <span class="caret"></span> </button> <ul class="dropdown-menu" role="menu"> ' +
        '<li><a href="' + baseDir + '/test/' + id + '">Complete test</a></li>' +
        '<li><a href="' + baseDir + '/test/attempts/' + id + '">' +
            '<span class="glyphicon glyphicon-list-alt"></span> ' +
            'View attempts</a></li>' +
        '<li class="divider"></li>' +
        '<li><a href="' + baseDir + '/test/edit/' + id + '">' +
            '<span class="glyphicon glyphicon-pencil"></span>' +
            ' Edit</a></li>' +
        '<li><a id="delete">' +
            '<span class="glyphicon glyphicon-trash"></span>' +
            ' Delete</a></li>' +
        '</ul></div>';
}

function actionButtonUser(baseDir, id) {
    return  '<div><a href="' + baseDir + '/test/'
            + id + '" type="button" class="btn btn-success' +
            ' btn-xs dropdown-toggle" >Complete test</a></div>';
}

$(document).ready(function () {
    var baseDir = $("#hidden-attr").attr("data-basedir");
    var role = false;



    $.ajax({
        url: baseDir + "/testsgrid/role",
        type: 'post',
        dataType: 'json',
        data: '',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (responseData) {
                    if (responseData.toString() == "ROLE_ADMIN") {
                        role = true;
                    }
                    if (!role) {
                        $('#addtest').hide();
                    }

        }
    });

    var table = $('#testsGrid').DataTable({
        processing: true,
        serverSide: true,
        fnUpdate: false,
        ajax: {
            url: baseDir + "/testsgrid",
            type: 'POST',
            mimeType: 'application/json',
            contentType: 'application/json',
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
            }
        },
        columns: [
            {data: "id", sClass: "gridtable"},
            {data: "name"},
            {data: "description"},
            {data: "isPublic"},
            {
                data: null, bSortable: false,
                defaultContent: ""
            }

        ],
        "order": [[0, 'asc']],
        "columnDefs": [{
            "targets": -1,
            "createdCell": function (td, cellData, rowData, row, col) {
                if (role) {
                    $(td).html(actionButtonAdmin(baseDir, rowData.id));
                }
                if (!role) {
                    $(td).html(actionButtonUser(baseDir, rowData.id));
                }
            }
        },
            {
                "targets": 3,
                "data": "isPublic",
                "render": function (data, type, full, meta) {
                    var isPublic;
                    if (data) { isPublic = "Public"; }
                    if (!data) { isPublic = "Private"; }
                    return isPublic;
                }
            }
        ]
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

    $('#addtest').on('click', function() {
       window.location.href = baseDir + '/testcreating';
    });
});