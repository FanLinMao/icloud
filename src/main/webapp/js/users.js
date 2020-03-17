
layui.use(['element','form','table','laytpl'], function(){
  var table = layui.table;
  var form = layui.form;
  var element = layui.element;
  var laytpl = layui.laytpl;
  
  
  //监听提交
  /*form.on('submit(search)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });*/
  var basepath =$("base", window.parent.document).attr("href");
  table.render({
    elem: '#lay-table',
    url: basepath+'account',
    method: 'post',
	height: 300,
	cols: [[
		{type:'checkbox'},
		{field: 'userId', hide: true},
		{field: 'user', title: '账户', width: 200},
		{field: 'role', title: '角色', width: 300}, 
		{field: 'permission', title: '权限', width: 80}, 
		{field: 'status', title: '状态', templet: '#switchTpl', unresize: true, width: 100}, 
		{field: 'operation', toolbar: '#row-opBar'}
		]],
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