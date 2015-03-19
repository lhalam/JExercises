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

var assertDto = [];

var sibling;
var assert;
var table;
function validate($element){
	return $element.val();

}

function keypressHandler(e) {
	if (e.keyCode == 13) {
		sibling = $(this);
		$(this).find("textarea").blur();
	}
	

}
function textAreaFocusLost(){
	$textarea=$(this).find("textarea");
	console.log($textarea);
	if(validate($textarea)){
		$(this).find("textarea").css({"background-color" : "#66FF99"});
	}else{
		$textarea.css({"background-color" : "transparent"});

	}

	}
function createTextArea() {
	return $("<textarea/>", {
		readonly : "readonly",
		class : "no-expand table-textarea"
	})
}
function createRow() {
	var $input_data_td = $("<td/>", {
		class : "editable input-data"
	})
	var $answer_td = $("<td/>", {
		class : "editable sorting_1 expected-answer"
	});
	$input_data_td.bind("keypress", keypressHandler).bind("focusout",textAreaFocusLost);
	$input_data_td.on("click", onTDClickHandler)
	$answer_td.bind("keypress", keypressHandler).bind("focusout",textAreaFocusLost);;
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
		$(this).find("textarea").removeAttr("readonly").addClass("edit_mode").css({"background-color" : "white"});

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
					}
				});
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
						var dr = new dataRequest(assertDto);
						dr.questionName = $('#questionName').code().toString();
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
                                alert(data);
								window.location.href = baseDir +"/tests";
							}

						});
					});

		});
$(function() {
	$('.summernote').summernote({
		height : 100
	})
});
