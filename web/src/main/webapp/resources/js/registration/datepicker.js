/**
 * 
 */
$(document).ready(function() {
	var datepicker = $("#datepicker");
	var days = {
		min : 1,
		max : 31
	};
	var months = {
			1:"Jan",
			2:"Feb",
			3:"Mar",
			4:"Apr",
			5:"May",
			6:"Jun",
			7:"Jul",
			8:"Aug",
			9:"Sep",
			10:"Oct",
			11:"Nov",
			12:"Dec"
	};
	var years = {
		min : 1905,
		max : 2015
	};

	var daySelector = $("<select />", {
		id : "day"
	});
	var monthSelector = $("<select />", {
		id : "month"
	});
	var yearSelector = $("<select />", {
		id : "year"
	});
	
	function appendFirstOption(optionValue, selectorName) {
		$("<option />", {
			value : "",
			text : optionValue
		}).appendTo(selectorName);
	}

	appendFirstOption("Day", daySelector);
	appendFirstOption("Month", monthSelector);
	appendFirstOption("Year", yearSelector);

	for (var day = days.min; day <= days.max; day++) {
		$("<option />", {
			value : day,
			text : day
		}).appendTo(daySelector);
	}

	$.each(months, function(monthKey, monthValue) {
		$("<option />", {
			value : monthKey,
			text : monthValue
		}).appendTo(monthSelector);
	});

	for (var year = years.max; year >= years.min; year--) {
		$("<option />", {
			value : year,
			text : year
		}).appendTo(yearSelector);
	}

	daySelector.appendTo(datepicker);
	monthSelector.appendTo(datepicker);
	yearSelector.appendTo(datepicker);

});