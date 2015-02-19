/**
 * 
 */
$(document).ready(function() {
	$("#submitButton").click(function(e) {
		var form = $('#registrationForm');
		if (form.valid()) {
			$.ajax({
				type : "POST",
				url : "/web/registration",
				dataType : "json",
				data : form.serialize(),
				success : function(data) {
					form.trigger("reset");
				}
			});
		}
	});

	$("#birthDate").focus(function() {
		this.type = "date";
	}).blur(function() {
		this.type = "text";
	});
});
