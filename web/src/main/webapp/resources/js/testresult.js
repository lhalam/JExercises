/**
 * 
 */

$(document).ready(function() {
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
			$("#user").text("User: " + responseData.firstName+"  " 
							+ responseData.lastName);
			$("#test").text("Test: " + responseData.testName);
			$("#date").text("Date: " + responseData.createdDate);
			$("#result").text("Test result is " + responseData.correctAnswersCount
							+ " of " + responseData.totalAnswersCount);

			$("#testresult").dataTable({
				"sDom": '<"clear">',
				"data" : responseData.answers,
				"columns" : [ 
				              {"data" : "questionName"},
				              {"data" : "correct"},
				            ]
			});
			if (responseData.role == "ROLE_ADMIN"){
				$('.private').hide();
				$('.userpublic').hide();
			} else {
				if (responseData.public){
					$('.admin').hide();
					$('.private').hide();
				} else {
					$('.admin').hide();
					$('.userpublicadmin').hide();
					$('.userpublic').hide();
				};
				
			};
		}
	})
}
