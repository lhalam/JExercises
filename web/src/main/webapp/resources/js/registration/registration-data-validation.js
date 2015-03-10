$(document).ready(function() {
    var baseDir = $("#contextRootHolder").val();
	var postUrl = baseDir + "/user/registration";
	var redirectUrl = baseDir + "/user/profile";

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
					  },
				  "day" : {
					  required : true,
					  dateValid : true
					  },
				  "month" : {
					  required : true,
					  dateValid : true
					  },
				  "year" : {
					  required : true,
					  dateValid : true
					  }
            },
            groups : {
            	birthDate : "day month year"
            },
            messages : {
            	"firstName" : {
            		required : "Please, enter your first name"
            			},
            	"lastName" : {
            		required : "Please, enter your last name"
						},
				"email" : {
					required : "Please, provide an email",
					email : "The email address is in the wrong format"
						},
				"password" : {
					required : "Please, provide a password"
						},
				"matchingPassword" : {
					required : "Please, confirm your password",
						},
				"day" : {
					required : "Please, select day",
					dateValid : "Date is invalid"
						},
				"month" : {
					required : "Please, select month",
					dateValid : "Date is invalid"
						},
				"year" : {
					required : "Please, select year",
					dateValid : "Date is invalid"
						}
             },
			 submitHandler : function(form) {
							 var registrationData = {};
							 registrationData.firstName = $("#firstName").val();
							 registrationData.lastName = $("#lastName").val();
							 registrationData.email = $("#email").val();
							 registrationData.password = $("#password").val();
							 registrationData.birthDate 
							   = new Date($("#year").val(), $("#month").val(), $("#day").val());
							$.ajax({
								url : postUrl,
								type : "POST",
								data : JSON.stringify(registrationData),
								dataType : 'json',
								contentType : "application/json",
								success : function(response) {
									if (response.errors.length > 0) {
										var error = response.errors[0];
										var emailHolder = $("#email");
										var alert = $("#alertSource div.alert").clone();
										var errorMessageHolder = $("#errorMessageHolder")
										var errorMessage = alert.find(".errorMessage");
										errorMessage.html(error);
										errorMessageHolder.html(alert);
										alert.show();
										emailHolder.change(function() {
											alert.hide();
											});
										} else {
											window.location.href = redirectUrl;
										}
									}
							});
            },
			highlight : function(element) {
				var feedbackElement = getFeedbackElement(element);
				if(isDateElement(element)){
					var dateElements=[$("#day"),$("#month"),$("#year")];
					$.each(dateElements,function(index,dateElement){
						highlightElement(dateElement);
					});
				}
				highlightElement(feedbackElement);
				feedbackElement.removeClass('glyphicon-ok')
						.addClass('glyphicon-remove');
			},
			unhighlight : function(element) {
				var feedbackElement = getFeedbackElement(element);
				if(isDateElement(element)){
					var dateElements=[$("#day"),$("#month"),$("#year")];
					$.each(dateElements,function(index,dateElement){
						unhighlightElement(dateElement);
					});
				}
				unhighlightElement(feedbackElement);
				feedbackElement.removeClass('glyphicon-remove')
						.addClass('glyphicon-ok')
						.popover('hide');
			},
			errorPlacement : function(error,element) {
				var feedbackElement=getFeedbackElement(element);
				var errorMessage=error.html();
				feedbackElement.attr('data-content',errorMessage);
				feedbackElement.popover({
						trigger : 'manual',
						content : errorMessage
					}).popover('show');
				}
			});
	
	function getFeedbackElement(element){
		if(isDateElement(element)){
			return $("#birthDateFeedback");
		}						
		return $("#"+ $(element).attr("id")+ "Feedback");
	}
	
	function isDateElement(element){
		var elementName=$(element).attr("name")
		return(elementName=="day"||elementName=="month"||elementName=="year")
	}
	
	function unhighlightElement(element){
	    element.closest('.form-group')
	    .removeClass('has-error')
		.addClass('has-success');
	}
	function highlightElement(element){
        element.closest('.form-group')
		.removeClass('has-success')
		.addClass('has-error');
	}
	
	$.validator.addMethod("dateValid", function() {
		var day = $("#day").val();
		var year = $("#year").val();
		var month = $("#month").val();
		if(year != null & month != null & day != null){
			var date=new Date(year, month, day);
			var matchingDay = date.getDate();
			return day == matchingDay;
		}
		return false;
	}, "Please, enter а valid date of birth.");
});

