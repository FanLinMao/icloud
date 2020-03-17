
layui.use('table', function(){
  var table = layui.table;
  
  table.render({
    elem: '#lay-table',
	height: 350,
	cols: [[
		{field: 'isoName', title: '名称', width: 150},
		{field: 'creator', title: '大小', width: 100},
		{field: 'osType', title: '上传者', width: 150}, 
		{field: 'osType', title: '角色', width: 150}, 
		{field: 'createDate', title: '上传时间', width: 200},
		{field: 'operation', title: '功能', toolbar: '#row-opBar'}
		]],
	data: [
		{"isoName": ".exe", "osType": "Windows Server 2008", "creator": "Admin", "createDate": "2019/02/12"},
		{"isoName": ".exe", "osType": "Ubantu", "creator": "Admin", "createDate": "2019/02/12"},
		{"isoName": ".exe", "osType": "CentOS6.5", "creator": "Admin", "createDate": "2019/02/12"}
		],
	page: true,
	limit: 5,
	limits: [5,10,20],
	loading: true,
	text: '数据为空！'
  });
});