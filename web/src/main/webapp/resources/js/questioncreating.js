/**
 * 
 */
var dataRequest = {
	questionName : '0',
	questionDescription : '0',
	expectedAnswer : '0',
	inputData : '0'
};

$(document).ready(
		function() {

			$("#submitButton").click(
					function(event) {
						dataRequest.questionName = $('#questionName').val()
								.toString();
						dataRequest.questionDescription = $(
								'#questionDescription').val().toString();
						dataRequest.expectedAnswer = $('#expectedAnswer').val()
								.toString();
						dataRequest.inputData = $('#inputData').val()
								.toString();
						$.ajax({
							url : "/web/questioncreating",
							type : 'POST',
							dataType : 'html',
							data : JSON.stringify(dataRequest),
							contentType : 'application/json',
							mimeType : 'application/json',
							success : function(data) {
								window.location.replace("/web/index");
							},
							error : function(jqXHR, status, err) {
								var errorMsg = "";
								errorMsg += status + "\n" + err;
								alert(errorMsg);
							},

						});
					});
		});
