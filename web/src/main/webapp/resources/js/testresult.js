/**
 * Created by Volodymyr Lishchynskiy on 25.02.15.
 */

$(document).ready(function() {
	$('.public').hide();
	$('.private').hide();
	$('.okbtn').hide();
	sendPost();
});

function sendPost() {
	$.ajax({
		url : "/web/testresult",
		type : 'post',
		dataType : 'json',
		data : '',
		contentType : 'application/json',
		mimeType : 'application/json',
		success : function(responseData) {
			
			if (responseData.public) {
				$("#result").text("Test result is " + responseData.correctAnswersCount
						+ " of " + responseData.totalAnswersCount);
				$("#testresult").dataTable({
					"bFilter" : false,
					"data" : responseData.answers,
					"columns" : [ 
					              {"data" : "questionName"},
					              {"data" : "isCorrect"},
					            ]
				});						
					
				$('.public').show();
				$('.okbtn;').show();
			}
			else {
				$('.private').show();
				$('.okbtn').show();

		}
		}
	})
}
