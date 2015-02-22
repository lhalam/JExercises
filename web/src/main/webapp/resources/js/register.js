/**
 * 
 */
$(document).ready(function() {
	$("#submitButton").click(function(e) {
		var form = $('#registrationForm');
		if (form.valid()) {
			$.ajax({
				type : "POST",
				url : "/web/user/registration",
				dataType : "json",
				data : form.serialize(),
				success : function(data) {
					if (data.hasErrors) {
						//error handling;
					} else {
						window.location.href = "/web/login";
					}
				}
			});
		}
	});

	$("#birthDate").combodate({
		minYear : 1905,
		firstItem : "name"
	});
});
