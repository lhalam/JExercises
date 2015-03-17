/**
 * 
 */
var dataRequest = function(assertDTO) {
	this.questionName = '0', this.questionDescription = '0',
			this.assertDtoList = assertDTO
};

function Assert(expectedAnswer, inputData) {
	this.expectedAnswer = expectedAnswer;
	this.inputData = inputData
}
/*
 * var assertOb1 = { expectedAnswer : "some Answ", inputData : "some InpD" };
 * var assertOb2 = { expectedAnswer : "some Answ2", inputData : "some InpD2" };
 */

var assertDto = [];

var sibling;
var assert;
var table;

function keypressHandler(e) {
	if (e.keyCode == 13) {
		// var text=$(this).val("input_data")?json['assertDtoList'].push({});

		sibling = $(this);
		$(this).find("textarea").blur();
		// var ob1=new Assert("answ1","data1");
		// var ob2=new Assert("answ2","data2");
		assertDto.push(new Assert("answasdasd", "dataasdas"));
		assertDto.push(new Assert("answer", "datadd"));
		// $("td.odd").
		/*
		 * $("td").each(function() { var str =
		 * $("textarea.no-expand.edit_mode").val(); console.log(str); });
		 */
		// alert(str);
		// json['assertDtoList'].push({});
		// console.log($( this ));
	}

}
function createTextArea() {
	return $("<textarea/>", {
		readonly : "readonly",
		class : "no-expand"
	}).css({
		"resize" : "none",
		"overflow" : "hidden",
		"height" : "100%",
		"width" : "100%",
		border : 0,
		"background-color" : "transparent"
	});
}
function createRow() {
	var $input_data_td = $("<td/>", {
		class : "editable input_data"
	}).css({
		"padding" : 0
	});
	var $answer_td = $("<td/>", {
		class : "editable expected_answer sorting_1"
	}).css("padding", 0)
	$input_data_td.bind("keypress", keypressHandler)
	$input_data_td.on("click", onTDClickHandler);
	$answer_td.bind("keypress", keypressHandler);
	$answer_td.on("click", onTDClickHandler);
	$input_data_td.append(createTextArea)
	$answer_td.append(createTextArea)
	$row = $("<tr/>", {
		role : "row"
	})
	$row.append($answer_td, $input_data_td);

	return $row;
}
function onTDClickHandler() {

	if (!$(this).hasClass("edit_mode")) {
		$(this).find("textarea").removeAttr("readonly").addClass("edit_mode");

	}

}
$(document).ready(
		function() {
			table = $('#assert').DataTable({// create table
				"columnDefs" : [ {
					"width" : "50%",// set first column width
					"targets" : 0
				} ]
			});

			$("#save").click(function(event) {
				var str1, str2;
				$("td textarea").each(function(index) {
					if (index % 2 == 0) {
						str1 = $(this).val();
					} else {
						str2 = $(this).val();
					}
					if(index%2==1){
						assertDto.push(new Assert(str1,str2));
						//console.log(assertDto);
					}
				});
				console.log(assertDto);
			});

			$("#addRow").click(
					function() {
						$last_row = $('#assert tbody>tr:last');
						$row_to_insert = createRow();
						$last_row.hasClass("odd") ? $row_to_insert
								.addClass("even") : $row_to_insert
								.addClass("odd");
						$row_to_insert.insertAfter($last_row);

					});
			$("#table_row").replaceWith(createRow().addClass("odd"));

			$("#submitButton").click(
					function(event) {
						// var dataRequest = {
						// questionName : '0',
						// questionDescription : '0',
						// assertDtoList : assertDto
						// };
						var dr = new dataRequest(assertDto);
						dr.questionName = $('#questionName').code().toString();
						dr.questionDescription = $('#questionDescription')
								.code().toString();
						// assertDtoList = assertDto;
						$.ajax({
							url : "/web/questioncreating",
							type : 'POST',
							dataType : 'html',
							// data : JSON.stringify(dataRequest),
							data : JSON.stringify(dr),
							contentType : 'application/json',
							mimeType : 'application/json',
							success : function(data) {
								window.location.replace("/web/index");
							}

						});
					});

		});
$(function() {
	$('.summernote').summernote({
		height : 100
	})
});
