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
             {"data": "isPublic", "bSortable": false }
             ]
     });
    $('#testgrid_wrapper').removeClass('dataTables_wrapper');
    $('#testgrid tbody').on('click', 'tr', function () {
        var urlid = $('td', this).eq(0).text();
        window.location=url+urlid;
    } );

} );
