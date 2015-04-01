/**
 * Created by Ihor Demkovych on 13.03.15.
 */
function validator(element) {
    if ((($('#testName').code().length) == 0) || (($('#testDescription').code().length) == 0)) {
        $(element).popover({
            trigger: 'manual',
            content: 'Please, fill the fields',
            placement: 'top'
        }).popover('show');
        setTimeout(function () {
            $(element).popover('hide');
        }, 2000);
        return false;
    }
    return true;
}

function actionButtonAdd(baseDir, id) {
    return '<div class="btn-group" role="group">'+
    			'<button type="button"' +
    				'class="btn btn-primary btn-xs dropdown-toggle" id="add">' +
    					'<span class="glyphicon glyphicon-plus-sign"></span> Add'+
    				'</button>'+
        	'<div class="btn-group" role="group">'+
    	   		'<button type="button" class="btn btn-primary btn-xs '+
    	   		'dropdown-toggle" data-toggle="dropdown" aria-expanded="false">'+
    	   			'<span class="caret"></span>'+
    	   			'<span class="sr-only">Toggle Dropdown</span>'+
    	   		'</button>'+
    	   		'<ul class="dropdown-menu" role="menu">'+
    	   			'<li><a href="' + baseDir +'/test/'+ dataTest.testId+'/question/edit/' + id + 
    	   			'"><span class="glyphicon glyphicon-pencil"></span> Edit</a></li>'+
    	   		'</ul>'+
    	   	'</div>'+	
    	   '</div>';
}

function actionButtonRemove(baseDir, id) {
    return   '<div class="btn-group" role="group">'+
				'<button type="button"' +
					'class="btn btn-danger btn-xs dropdown-toggle" id="remove">' +
					'<span class="glyphicon glyphicon-minus-sign"></span> Remove'+
				'</button>'+
				'<div class="btn-group" role="group">'+
					'<button type="button" class="btn btn-danger btn-xs'+
					' dropdown-toggle" data-toggle="dropdown" aria-expanded="false">'+
						'<span class="caret"></span>'+
						'<span class="sr-only">Toggle Dropdown</span>'+
					'</button>'+
					'<ul class="dropdown-menu" role="menu">'+
						'<li><a href="' + baseDir +'/test/'+ dataTest.testId+'/question/edit/' + id + 
						'"><span class="glyphicon glyphicon-pencil"></span> Edit</a></li>'+
					'</ul>'+
				'</div>'+	
			'</div>';
}

$(function () {
    $('.summernote').summernote({
        height: 100
    })
});

var dataTest = {
    testId: 0,
    testName: '0',
    testDescription: '0',
    isPublic: true
};
var linkData = {
	testId: 0,
	shortCode:''
};

$(document).ready(function () {
    var baseDir = $("#hidden-attr").attr("data-basedir");
    $("#title").html('Edit current test');
    $("#create").addClass('hidden');

    $.ajax({
        url: location.pathname,
        type: 'POST',
        dataType: 'html',
        async: false,
        data: '',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (dataResponse) {
            dataTest = JSON.parse(dataResponse);
            $("#testName").code(dataTest.testName.toString());
            $("#testDescription").code(dataTest.testDescription.toString());
            if (dataTest.isPublic) {
                document.getElementById("public").checked = true;
            } else {
            	linkData.shortCode=dataTest.testUrl;
                dataTest.testUrl = 'http://' + window.location.host + baseDir + '/' + dataTest.testUrl;
                document.getElementById("private").checked = true;
                $('#link').removeClass('hidden');
                $('#testUrl').val(dataTest.testUrl);
            }
        }
    });

    $('#regenerate').on('click', function () {
        $.ajax({
            url: baseDir + "/public/link/generate/",
            type: 'POST',
            dataType: 'html',
            data: JSON.stringify(dataTest),
            contentType: 'application/json',
            mimeType: 'application/json',
            async: false,
            success: function (url) {
                dataTest.testUrl = 'http://' + window.location.host + baseDir + '/' + url;
                linkData.shortCode=url;
                $('#testUrl').val(dataTest.testUrl);
            }
        });
    });

    $('input[type=radio]').click(function(){
        if (this.id == 'public'){
            $('#link').addClass('hidden');
        } else {
            $('#link').removeClass('hidden');
            if (dataTest.testUrl == 'noURL') {
                $.ajax({
                    url: baseDir + "/public/link/generate/",
                    type: 'POST',
                    dataType: 'html',
                    data: JSON.stringify(dataTest),
                    contentType: 'application/json',
                    mimeType: 'application/json',
                    async: false,
                    success: function (url) {
                        dataTest.testUrl = 'http://' + window.location.host + baseDir + '/' + url;
                        linkData.shortCode=url;
                        $('#testUrl').val(dataTest.testUrl);
                    }
                });
            }
        }
    });

    $('#allQuestionsTable').hide();
    $('#tables').removeClass('hidden');
    $('#testgrid_wrapper').removeClass('dataTables_wrapper');

    $('#allQuestions').on('click', function () {
        $('#allQuestionsTable').show();
        $('#selectedQuestionsTable').hide();
    });

    $('#selectedQuestions').on('click', function () {
        $('#allQuestionsTable').hide();
        $('#selectedQuestionsTable').show();
    });

    $('#addNewQuestion').on('click', function () {
        window.location.href = baseDir + "/question/create/" + dataTest.testId;
    });

    var allQuestionsTable = $('#allQuestionsGrid').DataTable({
        processing: true,
        serverSide: true,
        ajax: {
            url: baseDir + "/tests/" + dataTest.testId + "/all",
            type: 'POST',
            mimeType: 'application/json',
            contentType: 'application/json',
            data: function (dataPost) {
                return JSON.stringify(dataPost);
            }
        },
        columns: [
            {data: "id", className: "gridtable", searchable: false},
            {data: "name", className: "dt-center"},
            {data: "description", className: "dt-center"},
            {
                data: null, bSortable: false, className: "dt-center col-md-2",
                defaultContent: "", searchable: false
            }
        ],
        order: [[0, 'asc']],
        columnDefs: [{
            targets: -1,
            createdCell: function (td, cellData, rowData, row, col) {
                $(td).html(actionButtonAdd(baseDir, rowData.id));
            }
        }]
    });

    var selectedQuestionsTable = $('#selectedQuestionsGrid').DataTable({
        processing: true,
        serverSide: true,
        ajax: {
            url: baseDir + "/tests/" + dataTest.testId + "/added",
            type: 'POST',
            mimeType: 'application/json',
            contentType: 'application/json',
            data: function (dataPost) {
                return JSON.stringify(dataPost);
            }
        },
        columns: [
            {data: "id", className: "gridtable", searchable: false},
            {data: "name", className: "dt-center"},
            {data: "description", className: "dt-center"},
            {
                data: null, bSortable: false, className: "dt-center col-md-2",
                defaultContent: "", searchable: false
            }
        ],
        columnDefs: [{
            targets: -1,
            createdCell: function (td, cellData, rowData, row, col) {
                $(td).html(actionButtonRemove(baseDir, rowData.id));
            }
        }]
    });

    $('#update').on('click',
        function () {
            if (validator($(this))) {
                dataTest.testName = $('#testName').code().toString();
                dataTest.testDescription = $('#testDescription').code().toString();
                dataTest.isPublic = true;
                if (document.getElementById("private").checked) {
                    dataTest.isPublic = false;
                }
                $.ajax({
                    url: baseDir + "/tests/" + dataTest.testId + "/update",
                    type: 'POST',
                    dataType: 'html',
                    data: JSON.stringify(dataTest),
                    contentType: 'application/json',
                    mimeType: 'application/json',
                    success: function (data) {
                    	if(!dataTest.isPublic){
                    		linkData.testId=dataTest.testId;
                    		saveLink(linkData);
                    	}else{
                    		deleteLinkIfExists(dataTest.testId);
                    	}
                        window.location.href = baseDir + "/tests";
                    }
                });
            }
        });

    $('#selectedQuestionsGrid tbody').on('click', '#remove', function () {
        var dataID = selectedQuestionsTable.row($(this).parents('tr')).data();
        $.ajax({
            url: baseDir + "/tests/" + dataTest.testId + "/remove",
            type: 'POST',
            dataType: 'html',
            data: JSON.stringify(dataID.id),
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function (dataResponse) {
                allQuestionsTable.ajax.reload();
                selectedQuestionsTable.ajax.reload();
            }
        });
    });

    $('#allQuestionsGrid tbody').on('click', '#add', function () {
        var dataID = allQuestionsTable.row($(this).parents('tr')).data();
        $.ajax({
            url: baseDir + "/tests/" + dataTest.testId + "/add",
            type: 'POST',
            dataType: 'html',
            data: JSON.stringify(dataID.id),
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function (dataResponse) {
                allQuestionsTable.ajax.reload();
                selectedQuestionsTable.ajax.reload();
            }
        });
    });
});