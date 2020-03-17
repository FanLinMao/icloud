
layui.use(['element','form','table'], function(){
  var table = layui.table;
  var form = layui.form;
  var element = layui.element;
  var laydate = layui.laydate;
  
  
  //监听提交
  form.on('submit(search)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
  table.render({
    elem: '#lay-table',
	height: 300,
	cols: [[
		{field: 'startIP', title: '起始IP段', width: 200},
		{field: 'endIP', title: '结束IP段', width: 300}, 
		{field: 'ipStatus', title: '状态', width: 100}, 
		{field: 'userCount', title: '用户数', width: 100}, 
		{field: 'operation', title: '功能', toolbar: '#row-opBar'}
		]],
	data: [
		{"userCount":"0","endIP": "192.168.21.30", "ipStatus": "可用", "startIP": "192.168.21.11"},
		{"userCount":"0","endIP": "192.168.21.50", "ipStatus": "可用", "startIP": "192.168.21.31"},
		{"userCount":"0","endIP": "192.168.21.70", "ipStatus": "可用", "startIP": "192.168.21.51"}
		],
	page: true,
	limit: 5,
	limits: [5,10,20],
	loading: true,
	text: '数据为空！'
  });
});