
layui.use(['element','form','table','jquery','layer'], function(){
  var table = layui.table;
  var form = layui.form;
  var element = layui.element;
  var $ = layui.jquery;
  var layer = layui.layer;
  var basepath =$("input[name=basePath]", window.parent.document).val();
  
  var tableIns = table.render({
    elem: '#lay-table',
	height: 300,
	id:'LAYTB',
	url:basepath+'room',
	cols: [[
		{type:'checkbox'},
		{field: 'id', hide:true},
		{field: 'room', title: '机房', width: 200},
		{field: 'equipment', title: '设施设备', width: 300}, 
		{field: 'course', title: '适用课程', width: 100}, 
		{field: 'userCount', title: '人数容量', width: 100}, 
		{field: 'operation', title: '功能', toolbar: '#row-opBar'}
		]],
	
	page: true,
	limit: 5,
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
		  method = layEvent;
	    layer.confirm('确定删除此机房信息？', function(index){
	      obj.del();
	      layer.close(index);
	      var loading = layer.load(2);
	      $.ajax({
    			url: basepath+'room',
    			type: 'post',
    			async: false,
    			dataType: 'json',
    			data:{ids: data.id, action: method},
    			success: function(res){
    				layer.close(loading);      
    				if(res.code === 200){ 
                        layer.alert(res.msg, {icon: 1,title:'操作信息'});
                     }else{
                      	layer.alert(res.msg, {icon: 2,title:'操作信息'});     
					}   
    			},
    			error: function(xq,s,e){
    				layer.close(loading);
    				layer.alert(xq+","+s+","+e, {icon: 2,title:'操作信息'});
    			}
    		})
	    });
	  } else if(layEvent === 'edit'){ //编辑
		  
	    method = layEvent;
	    var othis = $(this);
	    
		active[method] ? active[method].call(this, othis) : '';
		
		form.val("tipsform", {
				"id": data.id,
			  "room": data.room
			  ,"equipment": data.equipment
			  ,"course": data.course
			  ,"userCount": data.userCount
			});
		
	    
	  }
	});  
  
  
//按钮触发事件
  var active = {
    del: function(){
    	var checkStatus = table.checkStatus('LAYTB');
    	if(checkStatus.data.length == 0){
    		layer.msg('请您选中数据后再删除！',{icon: 2,time: 2000});
    		return;
    	}
    	layer.confirm('您确认删除这'+checkStatus.data.length+'条数据？', {icon: 3, title:'提示'}, function(index){
    		var loading = layer.load(2);
    		var data = checkStatus.data;
    		var arr = new Array();
    		for(var i in data){
    			var id = data[i].id;
    			arr.push(id);
    		}
    		var ids = arr.join(",");
    		$.ajax({
    			url: basepath+'room',
    			type: 'post',
    			async: false,
    			dataType: 'json',
    			data:{ids:ids,action:method},
    			success: function(res){
    				if(res.code === 200){ 
    				layer.close(loading);      
                        layer.alert(res.msg, {icon: 1,title:'操作信息'});
    					table.reload('LAYTB', {
    					  page: {
    					    curr: 1 //重新从第 1 页开始
    					  }
    					});
                     }else{
                      layer.alert(res.msg, {icon: 2,title:'操作信息'});     
						}   
    			},
    			error: function(xq,s,e){
    				layer.alert(xq+","+s+","+e, {icon: 2,title:'操作信息'});
    			}
    		})
    		  layer.close(index);
    	});
    },
    add: function(othis){
      var type = othis.data('type'),text = othis.text();
      layer.open({
        type: 1
        ,offset: type
        ,title: '录入机房'
        ,id: 'layer'+type //防止重复弹出
        ,area: '800px'
        ,content: '<div style="padding: 20px 50px;">'+$('#layerform').html()+'</div>'
        ,shade: 0.5
        ,btn: ['提交', '取消']
	    ,yes: function(index, layero){
	        //按钮【提交】的回调
	    	form.verify();
	    	var data = form.val("tipsform");
	    	$.ajax({
	    		url:basepath+'room',
	    		type:'post',
	    		async: false,
	    		data:{action:method,parameters:JSON.stringify(data)},
	    		success:function(data){
	    			if(data.code === 200){
	    				layer.alert(data.msg);
	    				tableIns.reload({
	   	        		 page: {
	   	        		    curr: 1 //重新从第 1 页开始
	   	        		  }
	   	        		}); 
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
	    	tableIns.reload({
       		 page: {
       		    curr: 1 //重新从第 1 页开始
       		  }
       		}); 
	      //return false;
	    }
      });
      //重新渲染动态加载的表单
      form.render(null, 'tipsform');
    },
    edit:function(othis){
    	var type = othis.data('type'),text = othis.text();
	      layer.open({
	        type: 1
	        ,offset: type
	        ,title: '修改机房信息'
	        ,id: 'layer'+type //防止重复弹出
	        ,area: '800px'
	        ,content: '<div style="padding: 20px 50px;">'+$('#layerform').html()+'</div>'
	        ,shade: 0.5
	      ,btn: ['提交', '取消']
		    ,yes: function(index, layero){
		        //按钮【提交】的回调
		    	form.verify();
		    	var data = form.val("tipsform");
		    	$.ajax({
		    		url:basepath+'room',
		    		type:'post',
		    		async: false,
		    		data:{action:method,parameters:JSON.stringify(data)},
		    		success:function(data){
		    			if(data.code === 200){
		    				layer.alert(data.msg);
		    				tableIns.reload({
		   	        		 page: {
		   	        		    curr: 1 //重新从第 1 页开始
		   	        		  }
		   	        		}); 
		    			}else{
		    				layer.alert(data.msg);
		    			}
		    			layer.close(index);
		    		},
		    		error:function(xhr,s,e){
		    			layer.alert("请求失败："+e);	
		    		}
		    	})
		    }
		    ,btn2: function(index, layero){
		    	
		      //return false;
		    }
		    ,cancel: function(index, layero){ 
	        	tableIns.reload({
	        		 page: {
	        		    curr: 1 //重新从第 1 页开始
	        		  }
	        		}); 
	        	} 
	      });
	      //重新渲染动态加载的表单
	      form.render(null, 'tipsform');
    }
  };
  
  $('.layui-btn-container .layui-btn').on('click', function(){
    var othis = $(this)
    method = othis.data('method');
    active[method] ? active[method].call(this, othis) : '';
  });
  
  
});