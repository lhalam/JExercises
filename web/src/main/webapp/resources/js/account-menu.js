$(document).ready(function() {
	var postUrl = $("#postUrl").val();

	$.ajax({
		type : "POST",
		url : postUrl,
		dataType : "json",
		success : function(data) {
			var username = data.firstName + " " + data.lastName;
			$("#menuUsername").text(username);
		}
	});
});
