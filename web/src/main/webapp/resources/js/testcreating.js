/**
 * Created by Ihor Demkovych on 07.03.15.
 */
function actionButtonAdd() {
    return '<div class="btn-group btn-group-justified"><button type="button" style="width:80%;" ' +
        'class="btn btn-primary btn-xs dropdown-toggle" aria-expanded="false" id="add">' +
        '<span class="glyphicon glyphicon-plus"></span> Add</button></div>';
}

function actionButtonRemove() {
    return '<div class="btn-group btn-group-justified"><button type="button" style="width:80%;" ' +
        'class="btn btn-danger btn-xs"> ' +
        '<span class="glyphicon glyphicon-minus"></span> Remove</button></div>';
}

var dataRequest = {
    testName : '0',
    testDescription : '0',
    isPublic : false,
    questionsId : []
};

$(document).ready(function () {
    var baseDir = $("#hidden-attr").attr("data-basedir");

    var table = $('#questionGrid').DataTable({
        processing: true,
        serverSide: true,
        fnUpdate: false,
        ajax: {
            url: baseDir + "/testcreating",
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

                for (var i = 1; i < 3; i++) {
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
            {
                data: null, bSortable: false,
                defaultContent: ""
            }

        ],
        "order": [[0, 'asc']],
        "columnDefs": [{
            "targets": -1,
            "createdCell": function (td, cellData, rowData, row, col) {
                    $(td).html(actionButtonAdd(baseDir, rowData.id))
            }
        }
        ]
    });

    $('#testgrid_wrapper').removeClass('dataTables_wrapper');

    $('#questionGrid tbody').on('click','#add', function(){

    });



    $('#save').on('click',
        function(event) {
            dataRequest.testName = $('#testName').code().toString();
            dataRequest.testDescription = $('#testDescription').code().toString();
            if (document.getElementById("private").checked) { dataRequest.isPublic = true; }
            $.ajax({
                url : baseDir + "/testcreating/save",
                type : 'POST',
                dataType : 'html',
                data : JSON.stringify(dataRequest),
                contentType : 'application/json',
                mimeType : 'application/json',
                success : function(data) {
                    window.location.href = baseDir + "/testsgrid";
                }

            });
        });
});

$(function() {
    $('.summernote').summernote({
        height : 100
    })
});