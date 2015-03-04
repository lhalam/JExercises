$(document)
		.ready(
				function() {
					var baseDir = $("#contextRootHolder").val();
					var postUrl = baseDir + "/user/registration";
					var redirectUrl = baseDir + "/user/profile";

					$("#registrationForm")
							.validate(
									{
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
											registrationData.firstName = $(
													"#firstName").val();
											registrationData.lastName = $(
													"#lastName").val();
											registrationData.email = $("#email")
													.val();
											registrationData.password = $(
													"#password").val();
											registrationData.birthDate = new Date(
													$("#year").val(), $(
															"#month").val(), $(
															"#day").val());
											$
													.ajax({
														url : postUrl,
														type : "POST",
														data : JSON
																.stringify(registrationData),
														dataType : 'json',
														contentType : "application/json",
														success : function(
																response) {
															if (response.errors.length > 0) {
																var errorMessageHolder = $("#errorMessageHolder");
																var emailHolder = $("#email");
																var error = response.errors[0];
																errorMessageHolder
																		.text(error);
																errorMessageHolder
																		.show();
																emailHolder
																		.change(function() {
																			errorMessageHolder
																					.hide();
																		});
															} else {
																window.location.href = redirectUrl;
															}
														}
													})
										},
										showErrors : function(errorMap,
												errorList) {
											$
													.each(
															this
																	.validElements(),
															function(index,
																	element) {
																var $element = $(element);
																$element
																		.removeClass(
																				"error")
																		.tooltip(
																				"destroy");
															});

											$
													.each(
															errorList,
															function(index,
																	error) {
																var $element = $(error.element);
																$element
																		.attr(
																				"data-original-title",
																				error.message)
																		.tooltip(
																				{
																					placement : "right"
																				})
																		.tooltip(
																				"fixTitle")
																		.addClass(
																				"error");
																$element
																		.tooltip();
															});
										}
									});

					$.validator.addMethod("dateValid", function() {
						var day = $("#day").val();
						var matchDay = new Date($("#year").val(), $("#month")
								.val(), day).getDate();
						if (day == matchDay) {
							return true;
						}
						return false;
					}, "Please, enter а valid date of birth.");

				});
