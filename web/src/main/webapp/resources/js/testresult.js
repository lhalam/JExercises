 /**
 * Created by Volodymyr Lishchynskiy on 25.02.15.
 */
$(document).ready(function() {
	$("#loadingIcon").show();
	$("#okbtn").hide();
	sendPost();
});

function sendPost() {
	$.ajax({
		url : location.pathname,
		type : 'post',
		dataType : 'json',
		data : '',
		contentType : 'application/json',
		mimeType : 'application/json',
		success : function(responseData) {
			var date = new Date(responseData.date);
			var test = responseData.testName;
			var user = responseData.firstName + ' ' +responseData.lastName;
			var correct = responseData.correctAnswersCount;
			var total = responseData.totalAnswersCount;
			$("#user").append(user);
			$("#test").append(test);
			$("#date").append(date.getDate()+'/'+(date.getMonth()+1)+'/'+date.getFullYear()); 
			$("#result").text('Test result is '+ correct + ' of ' +  total);			
			$("#okbtn").show();
			$("#loadingIcon").hide();			
			$("#testresult").dataTable({
				"dom": 'T<"clear">lfrtip',
				    "tableTools": {
		        	"sSwfPath" : "http://cdn.datatables.net/tabletools/2.2.2/swf/copy_csv_xls_pdf.swf",
		        	"aButtons": [		        	                
		        	                {
		        	                    "sExtends":    "collection",
		        	                    "sButtonText": "Save As",
		        	                    "aButtons":    [ "pdf", "xls" ]
		        	                }
		        	            ]
		        },				
				"bFilter" : false,
				"data" : responseData.answers,
				"columns" : [ {
					"data" : "questionName"
				}, {
					"data" : "isCorrect"
				}, ],				
				"createdRow": function( row, data, dataIndex ) {
				    if ( data['isCorrect'] == "Correct") {
				      $(row).addClass('success');
				    } else{
				    	$(row).addClass('danger');
				    }
				}				
			});
		}
	})
}
