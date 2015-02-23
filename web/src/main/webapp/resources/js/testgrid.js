/**
 * Created by Ihor Demkovych on 16.02.15.
 */

var dataRequest = {
        pageNumber:0,
        pageSize:10,
        searchKey:''
};

var numberOfPages = 1;

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
            if (dataResponse.testGridRows.length == 0)
            {
                $("#pagebar").hide();
                $("#button5").hide();
                $("#button10").hide();
                $("#button25").hide();
                $("#button50").hide();
                $("#show").hide();
                $("#noresults").show();
            }
            else {
                $("#noresults").hide();
                $("#pagebar").show();
                $("#button5").show();
                $("#button10").show();
                $("#button25").show();
                $("#button50").show();
                $("#show").show();
                out += '<tbody><tr id="testgrid" class="row">';
                out += '<td class="field-label col-md-10 active">';
                out += '<label><strong>Description</strong></label>';
                out += '</td><td class="col-md-2 active"><label>';
                out += '<strong>Availability</strong></label></td></tr>';
                for (i = 0; i < dataResponse.testGridRows.length; i++) {
                    out += '<tr class="row"><td class="field-label ';
                    out += 'col-md-10 "><p><a href="/test/';
                    out += dataResponse.testGridRows[i].id;
                    out += '">';
                    out += dataResponse.testGridRows[i].description;
                    out += '</a></p></td><td class="col-md-2"><p>';
                    if (dataResponse.testGridRows[i].isPublic) {
                        out += 'Public';
                    }
                    else{
                        out += 'Private';
                    };
                    out += '</p></td></tr>';
                }
                out += '</tbody>';
                numberOfPages = dataResponse.pagesNumber;
                $("#info").val("Results: "+dataResponse.elementsNumber.toString());
            }
            out += '</table>';
            document.getElementById("testgrid").innerHTML = out;
            $("#fieldsearch").val(dataRequest.searchKey);
            paging(dataRequest.pageNumber);
        }
    });
};

function paging(page_namber){
    var previouspage = page_namber;
    var currentpage = page_namber + 1;
    var nextpage = page_namber +2;
    $("#previouspage").show();
    if (previouspage<1) {
        $("#previouspage").hide();
    };
    $("#nextpage").show();
    if (nextpage>numberOfPages+1) {
        $("#nextpage").hide();
    };
    $("#previouspage").val(previouspage.toString());
    $("#currentpage").val(currentpage.toString());
    $("#nextpage").val(nextpage.toString());
};

$(document).ready(function() {
    sendPost(dataRequest);
    $("#searchfield").click(function () {
        dataRequest.searchKey = $("#fieldsearch").val();
        dataRequest.pageNumber = 0;
        sendPost(dataRequest);
    });
    $("#button5").click(function () {
        dataRequest.pageSize = 5;
        $("#button5").addClass("btn-primary");
        $("#button10").removeClass("btn-primary");
        $("#button25").removeClass("btn-primary");
        $("#button50").removeClass("btn-primary");
        dataRequest.pageNumber = 0;
        sendPost(dataRequest);
    });
    $("#button25").click(function () {
        dataRequest.pageSize = 25;
        $("#button25").addClass("btn-primary");
        $("#button10").removeClass("btn-primary");
        $("#button5").removeClass("btn-primary");
        $("#button50").removeClass("btn-primary");
        dataRequest.pageNumber = 0;
        sendPost(dataRequest);
    });
    $("#button50").click(function () {
        dataRequest.pageSize = 50;
        $("#button50").addClass("btn-primary");
        $("#button10").removeClass("btn-primary");
        $("#button25").removeClass("btn-primary");
        $("#button5").removeClass("btn-primary");
        dataRequest.pageNumber = 0;
        sendPost(dataRequest);
    });
    $("#button10").click(function () {
        dataRequest.pageSize = 10;
        $("#button10").addClass("btn-primary");
        $("#button5").removeClass("btn-primary");
        $("#button25").removeClass("btn-primary");
        $("#button50").removeClass("btn-primary");
        dataRequest.pageNumber = 0;
        sendPost(dataRequest);
    });
    $("#previouspage").click(function () {
        dataRequest.pageNumber -= 1;
        sendPost(dataRequest);
    });
    $("#nextpage").click(function () {
        dataRequest.pageNumber += 1;
        sendPost(dataRequest);
    });
    $("#firstpage").click(function () {
        dataRequest.pageNumber = 0;
        sendPost(dataRequest);
    });
    $("#lastpage").click(function () {
        dataRequest.pageNumber = numberOfPages;
        sendPost(dataRequest);
    });
});
