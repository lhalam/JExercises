/**
 * Created by Ihor Demkovych on 16.02.15.
 */
var url = "/web/test/" ;
$(document).ready(function() {
    $('#testgrid').dataTable( {
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": "/web/testgrid",
            "type": "POST",
            "dataSrc": "testGridRows"
        },
        "columns": [
            { "data": "description" },
            { "data": "isPublic", "searchable": false },
            { "data": "id", "visible": false, "searchable": false }
        ]
    } );
} );
