/**
 * Created by Ihor Demkovych on 16.02.15.
 */
var url = "/web/test/" ;
$(document).ready(function() {
     var table = $('#testgrid').dataTable({
         "processing": true,
         "serverSide": true,
         "ajax": {
             "url": "/web/testgrid",
             "type": "POST",
             "dataSrc": "testGridRows"
         },
         "columns": [
             {"data": "id", "sClass": "gridtable" },
             {"data": "description"},
             {"data": "isPublic", "bSortable": false},
             {
                 "data" : "id",
                 "bSortable": false,
                 "render": function (data, type, full, meta) {
                     return '<a class="btn btn-info" href="test/' +
                         data + '">View</a>';
                 }
             },
             {
                 "data" : "id",
                 "bSortable": false,
                 "render": function (data, type, full, meta) {
                     return '<a class="btn btn-warning" href="test/edit/' +
                         data + '">Edit</a>';
                 }
             },
             {
                 "data" : "id",
                 "bSortable": false,
                 "render": function (data, type, full, meta) {
                     return '<a class="btn btn-danger" href="test/delete/' +
                         data + '"><span class="glyphicon glyphicon-trash">' +
                         '</span> Delete</a>';
                 }
             }
             ]
     });
    $('#testgrid_wrapper').removeClass('dataTables_wrapper');
});
