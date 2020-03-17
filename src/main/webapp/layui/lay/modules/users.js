
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
		{field: 'user', title: '账户', width: 200},
		{field: 'role', title: '角色', width: 300}, 
		{field: 'permission', title: '权限', width: 80}, 
		{field: 'status', title: '状态', templet: '#switchTpl', unresize: true, width: 100}, 
		{field: 'operation', toolbar: '#row-opBar'}
		]],
	data: [
		{"user":"范林茂","role": "管理员", "permission": "root"},
		{"user":"admin","role": "超级管理员", "permission": "super"}
		
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