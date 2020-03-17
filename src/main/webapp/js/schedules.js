
layui.use(['element','form','table','laytpl'], function(){
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
		{field: 'plan', title: '计划(每天)', width: 200},
		{field: 'timePoint', title: '时间点', width: 300}, 
		{field: 'action', title: '行为', width: 100}, 
		{field: 'action', title: '状态', templet: '#switchTpl', unresize: true, width: 100}, 
		{field: 'operation', toolbar: '#row-opBar'}
		]],
	data: [
		{"plan":"上午","timePoint": "07:00", "action": "创建"},
		{"plan":"中午","timePoint": "12:00", "action": "销毁"},
		{"plan":"下午","timePoint": "14:00", "action": "创建"},
		{"plan":"下午","timePoint": "18:00", "action": "销毁"}
		],
	page: true,
	limit: 5,
	limits: [5,10,20],
	loading: true,
	text: '数据为空！'
  });
  //监听打开操作
    form.on('switch(openStatus)', function(obj){
      layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
    });
});