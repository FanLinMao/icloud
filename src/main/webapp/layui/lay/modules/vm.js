layui.use('table', function(){
  var table = layui.table;
  
  table.render({
    elem: '#lay-table',
	height: 300,
	cols: [[
		{type: 'checkbox'},
		{field: 'isoName', title: '名称', width: 100},
		{field: 'status', title: '状态', width: 100},
		{field: 'osType', title: '操作系统类型', width: 300}, 
		{field: 'storage', title: '内存', width: 100},
		{field: 'cpu', title: 'CPU', width: 100},
		{field: 'disk', title: '硬盘', width: 100},
		{field: 'createDate', title: '创建时间', width: 200},
		{field: 'operation', title: '控制', toolbar: '#row-opBar'}
		]],
	data: [
		{"disk":"255G","cpu":"Intel-core-7u344 2.4HZ ","storage":"1.0G","status":"运行中","isoName": "windows", "osType": "Windows Server 2008", "storage": "Admin", "createDate": "2019/02/12"},
		{"disk":"255G","cpu":"Intel-core-7u344 2.4HZ ","storage":"1.0G","status":"运行中","isoName": "ubantu", "osType": "Ubantu", "storage": "Admin", "createDate": "2019/02/12"},
		{"disk":"255G","cpu":"Intel-core-7u344 2.4HZ ","storage":"1.0G","status":"运行中","isoName": "centos", "osType": "CentOS6.5", "storage": "Admin", "createDate": "2019/02/12"}
		],
	page: true,
	limit: 5,
	limits: [5,10,20],
	/* totalRow: true, */
	loading: true,
	text: '数据为空！'
  });
});