/**
 * 
 */
$(document).ready(function() {
	var errorMessageHolder = $("#errorMessageHolder");
	errorMessageHolder.hide();

	$("#submitButton").click(function(e) {
		var form = $('#registrationForm');
		var email = $("#email");
		setDate();
		if (form.valid()) {
			$.ajax({
				type : "POST",
				url : "/web/user/registration",
				dataType : "json",
				data : form.serialize(),
				success : function(data) {
					if (data.hasErrors) {
						var error = data.errors[0];
						errorMessageHolder.text(error);
						errorMessageHolder.show();
						email.change(function() {
							errorMessageHolder.hide();
						});
					} else {
						window.location.href = "/web/user/profile";
					}
				}
			});
		}
	});

	function setDate() {
		var birthDateHolder = $("#birthDate");
		var day = $("#day").val();
		var month = $("#month").val();
		var year = $("#year").val();
		var birthDate = day + "/" + month + "/" + year;
		birthDateHolder.val(birthDate);
		$("#datepicker").change(function() {
			$("label[for='birthDate']").hide();
		})
	}

});
