
layui.use('table', function(){
  var table = layui.table;
  
  table.render({
    elem: '#lay-table',
	height: 300,
	cols: [[
		{field: 'isoName', title: '名称', width: 350},
		{field: 'osType', title: '操作系统类型', width: 200}, 
		{field: 'creator', title: '大小', width: 100},
		{field: 'createDate', title: '创建时间', width: 200},
		{field: 'operation', title: '功能', toolbar: '#row-opBar'}
		]],
	data: [
		{"isoName": "windows_server_2008.iso", "osType": "Windows Server 2008", "creator": "Admin", "createDate": "2019/02/12"},
		{"isoName": "ubantu-5.07.iso", "osType": "Ubantu", "creator": "Admin", "createDate": "2019/02/12"},
		{"isoName": "centos6.5.iso", "osType": "CentOS6.5", "creator": "Admin", "createDate": "2019/02/12"}
		],
	page: true,
	limit: 5,
	limits: [5,10,20],
	/* totalRow: true, */
	loading: true,
	text: '数据为空！'
  });
});