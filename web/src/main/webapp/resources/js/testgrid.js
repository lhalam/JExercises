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
             {"data": "id",
              "visible": false },
             {"data": "description"},
             {"data": "isPublic"}
         ]
     });
    $('#testgrid tbody').on('click', 'tr', function () {
        var urlid = $('td', this).eq(0).text();
        window.location=url+urlid;
    } );
} );
