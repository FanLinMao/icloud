
layui.use('table', function(){
  var table = layui.table;
  
  table.render({
    elem: '#lay-table',
	height: 350,
	cols: [[
		{field: 'templateName', title: '模板', width: 120},
		{field: 'osType', title: '操作系统', width: 150}, 
		{field: 'creator', title: '制作人', width: 100},
		{field: 'description', title: '模板介绍', width: 400},
		{field: 'softlist', title: '所用软件', width: 100},
		{field: 'environment', title: '环境配置', width: 100},
		{field: 'operation', title: '操作', toolbar: '#row-opBar'}
		]],
	data: [
		{"templateName": "windows", "osType": "Windows Server 2008", "creator": "Admin", "createDate": "2019/02/12"},
		{"templateName": "ubantu", "osType": "Ubantu", "creator": "Admin", "createDate": "2019/02/12"},
		{"templateName": "centos", "osType": "CentOS6.5", "creator": "Admin", "createDate": "2019/02/12"}
		],
	/* page: true,
	limit: 5,
	limits: [5,10,20],
	loading: true, */
	text: '数据为空！'
  });
});