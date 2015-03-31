/**
 * 
 */
var assertDto = [];
var assert;
var table;
var focusFlag = false;
var currentContext;
var text;
var rowId;
var columnId;
var assertValidation;

function validator(element) {
	assertValidation = true;
	$("td").each(function(index) {
		if ($(this).text().length == 0) {
			assertValidation = false;
		}
	});
	if (((($('#questionName').code().length) == 0) || (($(
			'#questionDescription').code().length) == 0))
			|| (!assertValidation)) {
		$(element).popover({
			trigger : 'manual',
			content : 'Please, fill the fields',
			placement : 'top'
		}).popover('show');
		setTimeout(function() {
			$(element).popover('hide');
		}, 2000);
		return false;
	}
	return true;
};
var dataRequest = function(assertDTO) {
	this.questionName = '0', this.questionDescription = '0',
			this.assertDtoList = assertDTO
};

function Assert(expectedAnswer, inputData) {
	this.expectedAnswer = expectedAnswer;
	this.inputData = inputData
}

function clickOnTableCell(context) {
	if (!focusFlag) {
		rowId = table.cell(context).index().row;
		if (context.hasClass("sorting_1")) {
			columnId = 0;
		} else {
			columnId = 1;
		}
		text = context.text();
		context.text("");
		context.append("<input size='55' class='table-input-area'></input>");
		context.find(".table-input-area").val(text);
		context.find(".table-input-area").focus();
		focusFlag = true;
		$(".table-input-area").focusout(function() {
			text = context.find(".table-input-area").val();
			context.find(".table-input-area").hide();
			table.cell(rowId, columnId).data(text).draw;
			focusFlag = false;
		});
	}
}
$(document).ready(
		function() {
			var baseDir = $("#hidden-attr").attr("data-basedir");

			table = $('#assert').DataTable({
				"columnDefs" : [ {
					"width" : "50%",
					"targets" : 0
				} ]
			});
			$('#addRow').on('click', function() {
				table.row.add([ "", "" ]).draw();

				$('td').on('click', function() {
					clickOnTableCell($(this));
				})
			});
			$('td').on('click', function() {
				clickOnTableCell($(this));

			});
			$("#submitButton").click(
					function(event) {
						if (validator($(this))) {
							var str1, str2;
							$("td").each(function(index) {
								if (index % 2 == 0) {
									str1 = $(this).text();
								} else {
									str2 = $(this).text();
								}
								if (index % 2 == 1) {
									assertDto.push(new Assert(str1, str2));
								}
							});
							var dr = new dataRequest(assertDto);
							dr.questionName = $('#questionName').code()
									.toString();
							dr.questionDescription = $('#questionDescription')
									.code().toString();
							$.ajax({
								url : location.pathname,
								type : 'POST',
								dataType : 'html',
								data : JSON.stringify(dr),
								contentType : 'application/json',
								mimeType : 'application/json',
								success : function(data) {
									window.location.href = baseDir + "/tests/"
											+ data + "/edit";
								}

							});
						}
					});

		});
$(function() {
	$('.summernote').summernote({
		height : 100
	})
});
