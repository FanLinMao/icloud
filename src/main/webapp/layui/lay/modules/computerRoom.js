
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
		{type:'checkbox'},
		{field: 'room', title: '机房', width: 200},
		{field: 'equipment', title: '设施设备', width: 300}, 
		{field: 'course', title: '适用课程', width: 100}, 
		{field: 'userCount', title: '人数容量', width: 100}, 
		{field: 'operation', title: '功能', toolbar: '#row-opBar'}
		]],
	data: [
		{"userCount":"40","room": "H-A506", "equipment": "计算机", "course": "计算机基础等"},
		{"userCount":"40","room": "H-A507", "equipment": "计算机", "course": "实验等"},
		{"userCount":"40","room": "H-A508", "equipment": "数字电路箱", "course": "计算机组成原理等"}
		],
	page: true,
	limit: 5,
	limits: [5,10,20],
	loading: true,
	text: '数据为空！'
  });
});