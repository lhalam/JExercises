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
