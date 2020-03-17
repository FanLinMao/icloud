
layui.use('table', function(){
  var table = layui.table;
  
  table.render({
    elem: '#lay-table',
	height: 300,
	cols: [[
		{field: 'templateName', title: '名称', width: 120},
		{field: 'osType', title: '操作系统类型', width: 400}, 
		{field: 'creator', title: '制作人', width: 100},
		{field: 'createDate', title: '创建时间', width: 200},
		{field: 'operation', title: '操作', toolbar: '#row-opBar'}
		]],
	data: [
		{"templateName": "windows", "osType": "Windows Server 2008", "creator": "Admin", "createDate": "2019/02/12"},
		{"templateName": "ubantu", "osType": "Ubantu", "creator": "Admin", "createDate": "2019/02/12"},
		{"templateName": "centos", "osType": "CentOS6.5", "creator": "Admin", "createDate": "2019/02/12"}
		],
	page: true,
	limit: 5,
	limits: [5,10,20],
	totalRow: true,
	loading: true,
	text: '数据为空！'
  });
});