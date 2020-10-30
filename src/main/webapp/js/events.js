
layui.use(['element','form', 'laydate', 'table','jquery','layer'], function(){
  var table = layui.table;
  var form = layui.form;
  var element = layui.element;
  var laydate = layui.laydate;
  var $ = layui.jquery;
  var layer = layui.layer;
  
  var basepath =$("input[name=basePath]", window.parent.document).val();
  
  //日期
  laydate.render({
      elem: '#startDate'
  });
  //日期
  laydate.render({
      elem: '#endDate'
  });
  //搜索
  $("#search").click(function(){
	var startDate = $("#startDate").val();
	var endDate = $("#endDate").val();
	console.log(startDate);
	console.log(endDate);
      table.reload('LAYTABLE', {
        page: {
          curr: 1 //重新从第 1 页开始
        }
        ,where: {
        	action: 'search',
		    start:startDate,
		    end:endDate
        }
      }, 'data');
  })
  var tableIns = table.render({
    elem: '#lay-table',
	height: 300,
	id:'LAYTABLE',
	url:basepath+'events',
	cols: [[
		{field: 'id', hide:true},
		{field: 'created', title: '时间', width: 200},
		{field: 'description', title: '事件', width: 300}, 
		{field: 'type', title: '类型', width: 100}, 
		{field: 'level', title: '级别', width: 100}, 
		{field: 'username', title: '账户', width: 100},
		{field: 'state', title: '状态', width: 100},
		{field: 'operation', title: '功能', toolbar: '#row-opBar'}
		]],
	
	page: true,
	limit: 5,
	limits: [5,10,20],
	loading: true,
	text: '数据为空！',
	where:{action: 'listEvents'},
	response:{
		statusName:'code',
		statusCode: 200 
	}
  });
  
  table.on('tool(tb-filter)', function(obj){
	  var data = obj.data; //获得当前行数据
	  var layEvent = obj.event; 
	  if(layEvent === 'del'){ //销毁
		  method = layEvent;
	      obj.del();
	      layer.close(index);
	      var loading = layer.load(2);
	      $.ajax({
    			url: basepath+'events',
    			type: 'post',
    			async: false,
    			dataType: 'json',
    			data:{ids: data.id, action: method},
    			success: function(res){
    				if(res.code === 200){
    					//重载表格
    				    tableIns.reload({
    				    	page: {
    				    		curr: 1 //重新从第 1 页开始
    				    	}
				    	});
    				    layer.close(loading);      
                        layer.alert(res.msg, {icon: 1,title:'操作信息'});
                     }else{
                      layer.alert(res.msg, {icon: 2,title:'操作信息'});     
					}   
    			},
    			error: function(xq,s,e){
    				layer.alert(xq+","+s+","+e, {icon: 2,title:'操作信息'});
    			}
    		})
	  } else if(layEvent === 'edit'){ //编辑
		  method = layEvent;
		  var othis = $(this);
		  active[method] ? active[method].call(this, othis) : '';
		  form.val("tipsform", {
				"id": data.id,
			  "date": data.date
			  ,"event": data.event
			  ,"type": data.type
			  ,"level": data.level
			  ,"user": data.user
			,"role":data.role
			});
	  }
	});
  
  //触发事件
  var active = {
    
    edit: function(othis){
      var type = othis.data('type'),text = othis.text();
      layer.open({
        type: 1
        ,offset: type
        ,title: '编辑事件'
        ,id: 'layer'+type //防止重复弹出
        ,area: ['500px', '550px']
        ,content: '<div style="padding: 20px 50px;">'+$('#layerform').html()+'</div>'
        ,shade: 0.5
        ,btn: ['提交', '取消']
	    ,yes: function(index, layero){
	        //按钮【提交】的回调
	    	form.verify();
	    	var data = form.val("tipsform");
	    	$.ajax({
	    		url:basepath+'iso',
	    		type:'post',
	    		async: false,
	    		data:{action:method,parameters:JSON.stringify(data)},
	    		success:function(data){
	    			if(data.code === 200){
	    				layer.alert(data.msg);
	    			}else{
	    				layer.alert(data.msg);
	    			}
	    		},
	    		error:function(xhr,s,e){
	    			layer.alert("请求失败："+e);	
	    		}
	    	})
	    }
	    ,btn2: function(index, layero){
	    	
	      //return false;
	    }
      });
      //重新渲染动态加载的表单
      form.render(null, 'tipsform');
    }
    
  };
  
  
  
});