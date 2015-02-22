/**
 * 
 */
$(document).ready(function() {
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
						email.popover({
							placement : "right",
							content : error
						}).popover("show");
						email.on("change", function() {
							email.popover("destroy");
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
