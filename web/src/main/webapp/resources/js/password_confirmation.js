/**
 * 
 */
$(function() {
	$("#registrationSubmit").click(function(event) {
		if ($('#password').val() != $('#matchingPassword').val()) {
			alert("Password and Confirm Password don't match");
			event.preventDefault();
		}
	});
})
