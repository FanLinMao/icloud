
layui.use('table', function(){
  var table = layui.table;
  
  table.render({
    elem: '#lay-table',
	height: 300,
	cols: [[
		
		{field: 'college', title: '学院', width: 100},
		{field: 'operator', title: '预约人', width: 100},
		{field: 'operateDate', title: '时间', width: 100}, 
		{field: 'address', title: '地点', width: 100},
		{field: 'clazz', title: '班级', width: 100},
		{field: 'teacher', title: '教师', width: 100},
		{field: 'course', title: '课程', width: 200},
		{field: 'template', title: '模板', width: 100},
		{field: 'operation', title: '操作', toolbar: '#row-opBar'}
		]],
	data: [
		{"college":"软件工程学院","operator":"Admin","operateDate":"2020/02/18","address":"H1308",
		"clazz": "165", "teacher": "王某", "course": "Java", "template": "windows"},
		],
	page: true,
	limit: 5,
	limits: [5,10,20],
	/* totalRow: true, */
	loading: true,
	text: '数据为空！'
  });
});