$(document).ready(function() {
	$.validator.setDefaults({ 
	    ignore: []
	});
	
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
	});
		
	var shortMonths = [ 4, 6, 9, 11 ];
	var february=2;
	
	$.validator.addMethod("checkDate", function(element) {
		return isValidDate(element);
	}, "Please, enter а valid date of birth")

	$.validator.addClassRules({
		dateRequired : {
			required : true,
			checkDate : true
		}
	});

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
			} else if ($.inArray(month, shortMonths)) {
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
