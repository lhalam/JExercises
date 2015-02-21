/**
 * Created by rphysicist on 16.02.15.
 */

$(document).ready(function(){
    $("#button").click(function(){
        $.ajax({
            url: "/testgrid",
            type: 'POST',
            dataType: 'json',
            data: '{"pageNumber":0,"pageSize":10,"searchKey":"test"}',
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function(data) {
                document.getElementById("isPublic").innerHTML =
                    data.testGridRows[0].isPublic;
                document.getElementById("description").innerHTML =
                    data.testGridRows[0].description;
            }
        });
    });

});
