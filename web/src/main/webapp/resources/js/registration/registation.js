/**
 * 
 */
$(document).ready(function() {
	var baseDir = $("#contextRootHolder").val();

	$("#submitButton").click(function(e) {
		var form = $('#registrationForm');
		var errorMessageHolder = $("#errorMessageHolder");
		var email = $("#email");
		var postUrl = baseDir + "/user/registration";
		var redirectUrl = baseDir + "/user/profile";
		setDate();
		if (form.valid()) {
			$.ajax({
				type : "POST",
				url : postUrl,
				dataType : "json",
				data : form.serialize(),
				success : function(data) {
					if (data.errors.length > 0) {
						var error = data.errors[0];
						errorMessageHolder.text(error);
						errorMessageHolder.show();
						email.change(function() {
							errorMessageHolder.hide();
						});
					} else {
						window.location.href = redirectUrl;
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
		$("#datePicker").change(function() {
			setDate();
			birthDateHolder.valid();
		})
	}

});
