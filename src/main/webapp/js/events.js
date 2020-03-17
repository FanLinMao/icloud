
layui.use(['element','form', 'laydate', 'table'], function(){
  var table = layui.table;
  var form = layui.form;
  var element = layui.element;
  var laydate = layui.laydate;
  
  //日期
  laydate.render({
      elem: '#startDate'
  });
  //日期
  laydate.render({
      elem: '#endDate'
  });
  //监听提交
  form.on('submit(search)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
  table.render({
    elem: '#lay-table',
	height: 300,
	cols: [[
		{field: 'date', title: '时间', width: 200},
		{field: 'event', title: '事件', width: 300}, 
		{field: 'type', title: '类型', width: 100}, 
		{field: 'level', title: '级别', width: 100}, 
		{field: 'user', title: '账户', width: 100},
		{field: 'role', title: '角色', width: 100},
		{field: 'operation', title: '功能', toolbar: '#row-opBar'}
		]],
	data: [
		{"level":"1","role":"管理员","event": "死机", "type": "Windows Server 2008", "user": "Admin", "date": "2019/02/12"},
		{"level":"1","role":"管理员","event": "死机", "type": "Ubantu", "user": "Admin", "date": "2019/02/12"},
		{"level":"1","role":"管理员","event": "死机", "type": "CentOS6.5", "user": "Admin", "date": "2019/02/12"}
		],
	page: true,
	limit: 5,
	limits: [5,10,20],
	loading: true,
	text: '数据为空！'
  });
});