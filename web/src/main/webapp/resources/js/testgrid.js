/**
 * Created by Ihor Demkovych on 16.02.15.
 */

var dataRequest = {
        pageNumber:0,
        pageSize:10,
        searchKey:''
};

var numberOfPages = 10;

function paging(page_namber){
    var previouspage = page_namber;
    var currentpage = page_namber + 1;
    var nextpage = page_namber +2;
    $("#previouspage").show();
    if (previouspage < 1) {
        $("#previouspage").hide();
    };
    $("#nextpage").show();
    if (nextpage > numberOfPages-1) {
        $("#nextpage").hide();
    };
    $("#previouspage").val(previouspage.toString());
    $("#currentpage").val(currentpage.toString());
    $("#nextpage").val(nextpage.toString());
};

function sendPost(somedata) {
    $.ajax({
        url: "/testgrid",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(somedata),
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (dataResponse) {

            var i;
            var out = '<table class="table table-bordered">';
            out += '<tbody><tr id="testgrid" class="row">';
            out += '<td class="field-label col-md-10 active">';
            out += '<label><strong>Description</strong></label>';
            out += '</td><td class="col-md-2 active"><label>';
            out += '<strong>Availability</strong></label></td></tr>';

            for (i = 0; i < dataResponse.testGridRows.length; i++) {
                out += '<tr class="row"><td class="field-label ';
                out += 'col-md-10 "><p>';
                out += dataResponse.testGridRows[i].description;
                out += '</p></td><td class="col-md-2"><p>';
                out += dataResponse.testGridRows[i].isPublic;
                out += '</p></td></tr>';
            }
            out += '</tbody></table>';
            numberOfPages = dataResponse.pagesNumber;
            document.getElementById("testgrid").innerHTML = out;
        }
    });
};

$(document).ready(function() {
    sendPost(dataRequest);
    paging(dataRequest.pageNumber);
    $("#button5").click(function () {
        dataRequest.pageSize = 5;
        $("#button5").addClass("btn-primary");
        $("#button10").removeClass("btn-primary");
        $("#button25").removeClass("btn-primary");
        $("#button50").removeClass("btn-primary");
        dataRequest.pageNumber = 0;
        sendPost(dataRequest);
        paging(dataRequest.pageNumber);
    });
    $("#button25").click(function () {
        dataRequest.pageSize = 25;
        $("#button25").addClass("btn-primary");
        $("#button10").removeClass("btn-primary");
        $("#button5").removeClass("btn-primary");
        $("#button50").removeClass("btn-primary");
        dataRequest.pageNumber = 0;
        sendPost(dataRequest);
        paging(dataRequest.pageNumber);
    });
    $("#button50").click(function () {
        dataRequest.pageSize = 50;
        $("#button50").addClass("btn-primary");
        $("#button10").removeClass("btn-primary");
        $("#button25").removeClass("btn-primary");
        $("#button5").removeClass("btn-primary");
        dataRequest.pageNumber = 0;
        sendPost(dataRequest);
        paging(dataRequest.pageNumber);
    });
    $("#button10").click(function () {
        dataRequest.pageSize = 10;
        $("#button10").addClass("btn-primary");
        $("#button5").removeClass("btn-primary");
        $("#button25").removeClass("btn-primary");
        $("#button50").removeClass("btn-primary");
        dataRequest.pageNumber = 0;
        sendPost(dataRequest);
        paging(dataRequest.pageNumber);
    });
    $("#previouspage").click(function () {
        dataRequest.pageNumber -= 1;
        sendPost(dataRequest);
        paging(dataRequest.pageNumber);
    });
    $("#nextpage").click(function () {
        dataRequest.pageNumber += 1;
        sendPost(dataRequest);
        paging(dataRequest.pageNumber);
    });
    $("#firstpage").click(function () {
        dataRequest.pageNumber = 0;
        sendPost(dataRequest);
        paging(dataRequest.pageNumber);
    });
    $("#lastpage").click(function () {
        dataRequest.pageNumber = numberOfPages - 1;
        sendPost(dataRequest);
        paging(dataRequest.pageNumber);
    });
});
