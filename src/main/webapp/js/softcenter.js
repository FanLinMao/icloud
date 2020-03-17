
layui.use('table', function(){
  var table = layui.table;
  
  table.render({
    elem: '#lay-table',
	height: 300,
	cols: [[
		{field: 'softName', title: '软件名', width: 450},
		{field: 'size', title: '大小', width: 100}, 
		{field: 'uploader', title: '上传者', width: 100},
		{field: 'uploadDate', title: '上传时间', width: 200},
		{field: 'mark', title: '备注', width: 200},
		{field: 'operation', title: '功能', toolbar: '#row-opBar'}
		]],
	data: [
		{"mark":"无","softName": "windows_server_2008.iso", "size": "40MB", "uploader": "Admin", "uploadDate": "2019/02/12"},
		{"mark":"无","softName": "ubantu-5.07.iso", "size": "40MB", "uploader": "Admin", "uploadDate": "2019/02/12"},
		{"mark":"无","softName": "centos6.5.iso", "size": "40MB", "uploader": "Admin", "uploadDate": "2019/02/12"}
		],
	page: true,
	limit: 5,
	limits: [5,10,20],
	/* totalRow: true, */
	loading: true,
	text: '数据为空！'
  });
});