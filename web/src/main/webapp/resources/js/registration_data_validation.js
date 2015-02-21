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
				equalTo : "#password"
			}
		}
	})

});
