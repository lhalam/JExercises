/**
 * 
 */
$(document).ready(function() {
	var errorHolder = $("#errorMessageHolder");
	errorHolder.hide();
	$("#submitButton").click(function(e) {
		var form = $('#registrationForm');
		var email = $("#email");
		if (form.valid()) {
			$.ajax({
				type : "POST",
				url : "/web/user/registration",
				dataType : "json",
				data : form.serialize(),
				success : function(data) {
					if (data.hasErrors) {
						var error = data.errors[0];
						errorHolder.text(error);
						errorHolder.show();
						email.on("change", function() {
							errorHolder.hide();
						});
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
