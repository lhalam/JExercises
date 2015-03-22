function showButton(baseDir, id) {
	return '<a href="' + baseDir + '/test/result/' + id + '" target="_blank"' +
    ' class="btn btn-info btn-xs btn-shortened">' +
    '<span class="glyphicon glyphicon-new-window"></span>View</a>';
}
$(document).ready(function () {
	var baseDir = $("#hidden-attr").attr("data-basedir");
	var dt = $('#test_attempts_table').DataTable({
		"processing": true,
		serverSide: true,
		ajax :{
			url:location.pathname,
			type:'post',
			data:function (data) {
	                return JSON.stringify(data);
	        },
	        dataType:'json',
	        contentType:"application/json"
	        },
		
		"columns": [ 
		{
			"data": "id",
			"searchable": false,
			"visible": false
		},
		{
			"data": "firstName",
			"className": "dt-center"
		},
		{
			"data": "lastName",
			"className": "dt-center"
		},
		{
			"data": "createdDate",
			"searchable":false,
			"className": "dt-center"
			
		},
        {
            "data": "result",
            "searchable": false,
            "orderable": false,
            "className": "dt-center"
        },		
		{
			"searchable": false,
			"orderable": false,
			"data": null,
			"className": "dt-center",
			"defaultContent": ""			
		}
		],
		"order": [[3, 'desc']],
        "columnDefs": [{
            "targets": 3,
            "data":"createdDate",
            "render": function (data, type, full, meta) {
                var date = new Date(data);
                return date.getDate() + '/' +
                    (date.getMonth() + 1) + '/' + date.getFullYear();
            }
        },
        {
            "targets": 5,
            "createdCell": function (td, cellData, rowData, row, col) {
                $(td).html(showButton(baseDir, rowData.id));
            }
        },
        {
        	"targets": 1,
        	"createdCell": function (td,cellData,rowData,row,col){
        		if ($('#name').is(':hidden')){
        			$(td).addClass('hidden');
        		}
        	}
        },
        {
        	"targets": 2,
        	"createdCell": function (td,cellData,rowData,row,col){
        		if($('#surname').is(':hidden')){
        			$(td).addClass('hidden');
        		}
        	}
        }
        
        
        ]

	});
});