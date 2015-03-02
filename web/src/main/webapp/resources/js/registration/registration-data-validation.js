$(document).ready(
		function() {
			$("#registrationForm").validate(
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
							"birthDate" : {
								required : true,
								dateValid : true
							}
						},
						showErrors : function(errorMap, errorList) {
							$.each(this.validElements(), function(index,
									element) {
								var $element = $(element);
								$element.removeClass("error")
										.tooltip("destroy");
							});

							$.each(errorList, function(index, error) {
								var $element = $(error.element);
								$element.attr('data-original-title',
										error.message).tooltip({
									placement : "right"
								}).tooltip('fixTitle').addClass("error");
								if ($element.is("input[id='birthDate']")) {
									$element.tooltip({
										trigger : "focus"
									}).tooltip('show');
								} else {
									$element.tooltip();
								}
							});
						}
					});

			var shortMonths = [ "4", "6", "9", "11" ];
			var february = 2;

			$.validator.addMethod("dateValid", function(value) {
				return isValidDate(value);
			}, "Please, enter а valid date of birth.");

			function isValidDate(date) {
				var validDateFormat = /^[1-3]?[0-9]\/[1]?[0-9]\/([0-9]{4})$/;
				if (validDateFormat.test(date)) {
					var arr = date.split('/');
					var day = arr[0];
					var month = arr[1];
					var year = arr[2];
					if (month == february) {
						if (isLeapYear(year)) {
							return day <= 29;
						}
						return day <= 28;
					} else if ($.inArray(month, shortMonths) !== -1) {
						return day <= 30;
					}
					return true;
				}
				return false;
			}

			function isLeapYear(year) {
				return ((year % 4 == 0) && (year % 100 != 0))
						|| (year % 400 == 0);
			}

		});
