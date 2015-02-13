/**
 * 
 */
// $(function() {
// $("#registrationSubmit").click(function(event) {
// if ($('#password').val() != $('#matchingPassword').val()) {
// alert("Password and Confirm Password don't match");
// event.preventDefault();
// }
// });
// })
$(document).ready(function() {
	$("#registrationForm").validate({
		rules : {
			"firstName" : {
				required : true
			},
			"lastName" : {
				required : true
			},
			"email" : {
				required : true,
				email : true
			},
			"password" : {
				required : true
			},
			"matchingPassword" : {
				required : true,
				equalTo: "#password"
			}
		}
	})
});
