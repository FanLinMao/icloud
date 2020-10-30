
layui.use(['table','jquery'], function(){
  var table = layui.table;
  var $ = layui.jquery;
  var basepath =$("input[name=basePath]", window.parent.document).val();
  var role = getCookie('r');
  var cols = [
		{field: 'college', title: '学院', width: 100},
		{field: 'date', title: '时间', width: 200}, 
		{field: 'address', title: '地点', width: 100},
		{field: 'clazz', title: '班级', width: 100},
		{field: 'teacher', title: '教师', width: 100},
		{field: 'course', title: '课程', width: 200},
		{field: 'template', title: '模板', width: 100},
		{field: 'operation', title: '操作', toolbar: '#row-opBar'}
		];
  if(role == '3'){
	  for(var i = 0; i < 3; i++){
		  cols.pop();
	  }
	  cols.push({field: 'course', title: '课程', width: 350});
	  cols.push({field: 'template', title: '模板'});
  }
  var tableIns = table.render({
    elem: '#lay-table',
	height: 420,
	url: basepath+'arrange',
	method: 'post',
	id: 'LAYTB',
	cols: [cols],
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
  
  table.on('tool(tb-filter)', function(obj){
	  var data = obj.data; //获得当前行数据
	  var layEvent = obj.event; 
	  if(layEvent === 'del'){ //删除
		  
	  } else if(layEvent === 'sure'){ //确定
		  
	  }
	});
  
  //搜索
  $("#search").click(function(){
	var teacher = $("#teacher").val();
	var course = $("#course").val();
      table.reload('LAYTB', {
        page: {
          curr: 1 //重新从第 1 页开始
        }
        ,where: {
        	action: 'search',
        	teacher:teacher,
        	course:course
        }
      }, 'data');
  })
  
  
});

function getCookie(name){
    var strcookie = window.parent.document.cookie;//获取cookie字符串
    var arrcookie = strcookie.split("; ");//分割
    //遍历匹配
    for ( var i = 0; i < arrcookie.length; i++) {
        var arr = arrcookie[i].split("=");
        if (arr[0] == name){
            return arr[1];
        }
    }
    return "";
}
