/**
 * Created by Volodymyr Lishchynskiy on 25.02.15.
 */
$(document).ready(function() {
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
			$("#loadingIcon").hide();
			$("#okbtn").show();
			var date = new Date(responseData.date)
			$("#user").text(
					responseData.firstName + "  " + responseData.lastName);
			$("#test").text(responseData.testName);
			$("#date").text(
					date.getDate() + '/' + (date.getMonth() + 1) + '/'
							+ date.getFullYear());
			$("#result").text(
					"Test result is " + responseData.correctAnswersCount
							+ " of " + responseData.totalAnswersCount);
			$("#testresult").dataTable({
				"bFilter" : false,
				"data" : responseData.answers,
				"columns" : [ {
					"data" : "questionName"
				}, {
					"data" : "isCorrect"
				}, ]
			});
		}
	})
}
