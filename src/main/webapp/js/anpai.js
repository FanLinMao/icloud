
layui.use(['table','jquery'], function(){
  var table = layui.table;
  var $ = layui.jquery;
  var basepath =$("input[name=basePath]", window.parent.document).val();
  table.render({
    elem: '#lay-table',
	height: 420,
	url: basepath+'arrange',
	method: 'post',
	id: 'LAYTB',
	cols: [[
		
		{field: 'college', title: '学院', width: 100},
		{field: 'date', title: '时间', width: 200}, 
		{field: 'address', title: '地点', width: 100},
		{field: 'clazz', title: '班级', width: 100},
		{field: 'teacher', title: '教师', width: 100},
		{field: 'course', title: '课程', width: 200},
		{field: 'template', title: '模板', width: 100},
		{field: 'operation', title: '操作', toolbar: '#row-opBar'}
		]],
	
	page: true,
	limit: 10,
	limits: [5,10,20],
	loading: true,
	text: '数据为空！',
	where:{action: 'list'},
	response:{
		statusName:'code',
		statusCode: 200 
	}
  });
});