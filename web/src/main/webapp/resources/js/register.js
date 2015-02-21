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

	$("#birthDate").combodate({
		minYear : 1905,
		firstItem : "name"
	});
});
