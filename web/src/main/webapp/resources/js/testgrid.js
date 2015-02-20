/**
 * Created by rphysicist on 16.02.15.
 */

$(document).ready(function(){
    $("#button").click(function(){
        $.ajax({
            url: "/testgrid",
            type: 'POST',
            dataType: 'json',
            data: '{"pageNumber":10,"pageSize":20,"searchKey":"hello"}',
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function(data) {
                alert(data);
            }
        });

    });
});
