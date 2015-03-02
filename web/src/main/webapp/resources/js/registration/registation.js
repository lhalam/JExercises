/**
 * 
 */
$(document).ready(function() {

	$("#datePicker").change(function() {
		setDate();
	});

	$("#submitButton").click(function(e) {
		var form = $('#registrationForm');
		var errorMessageHolder = $("#errorMessageHolder");
		var emailHolder = $("#email");
		var baseDir = $("#contextRootHolder").val();
		var postUrl = baseDir + "/user/registration";
		var redirectUrl = baseDir + "/user/profile";
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
						emailHolder.change(function() {
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
		birthDateHolder.valid();
	}

});
