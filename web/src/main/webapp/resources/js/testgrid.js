/**
 * Created by rphysicist on 16.02.15.
 */
$(document).ready(function() {

    $(".jqueryDataTable").dataTable( {
        "bProcessing": false,
        "bServerSide": false,
        "sAjaxSource": "./StudentDataServlet",
        "bJQueryUI": true,
        "aoColumns": [
            { "mData": "name" },
            { "mData": "mark" }

        ]
    } );
} );