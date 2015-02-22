/**
 * Created by Ihor Demkovych on 16.02.15.
 */
var dataRequest = {
        pageNumber:0,
        pageSize:10,
        searchKey:''
};

$(document).ready(function(){

    $("#button5").click(function() {
        dataRequest.pageSize=5;
    });
    $("#button25").click(function() {
        dataRequest.pageSize=25;
    });
    $("#button50").click(function() {
        dataRequest.pageSize=50;
    });
    $("#button10").click(function() {
        dataRequest.pageSize=10
    });

    $("#button").click(function(){
        $.ajax({
            url: "/testgrid",
            type: 'POST',
            dataType: 'json',
            data: JSON.stringify(dataRequest),
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function(dataResponse){

                var i;
                var out =  '<table class="table table-bordered">';
                    out += '<tbody><tr id="testgrid" class="row">';
                    out += '<td class="field-label col-md-10 active">';
                    out += '<label><strong>Description</strong></label>';
                    out += '</td><td class="col-md-2 active"><label>';
                    out += '<strong>Availability</strong></label></td></tr>';

                for(i = 0; i < dataResponse.testGridRows.length; i++) {
                    out += '<tr class="row"><td class="field-label ';
                    out += 'col-md-10 "><p>';
                    out += dataResponse.testGridRows[i].description;
                    out += '</p></td><td class="col-md-2"><p>';
                    out += dataResponse.testGridRows[i].isPublic;
                    out += '</p></td></tr>';
                }
                out += '</tbody></table>';
                document.getElementById("testgrid").innerHTML = out;

            }
        });
    });

});

