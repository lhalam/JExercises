/**
 * 
 */

function saveLink(linkData) {
	var baseDir = $("#hidden-attr").attr("data-basedir");
	$.ajax({
		url : baseDir + "/public/link/save",
		type : 'POST',
		dataType : 'html',
		data : JSON.stringify(linkData),
		contentType : 'application/json',
	});
}

function deleteLinkIfExists(testId) {
	var baseDir = $("#hidden-attr").attr("data-basedir");
	$.ajax({
		url : baseDir + "/public/link/delete/" + testId,
		type : 'POST',
		dataType : 'html',
		contentType : 'application/json',
	});
}