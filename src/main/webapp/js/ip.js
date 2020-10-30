
layui.use(['element','form','table','jquery','layer'], function(){
  var table = layui.table;
  var form = layui.form;
  var element = layui.element;
  var $ = layui.jquery;
  var layer = layui.layer;
  var basepath =$("input[name=basePath]", window.parent.document).val();
  
  
  table.render({
    elem: '#lay-table',
	height: 300,
	id:'LAYTB',
	url:basepath+'ip',
	cols: [[
		{field: 'id', hide:true},
		{field: 'startIP', title: '起始IP段', width: 200},
		{field: 'endIP', title: '结束IP段', width: 300}, 
		{field: 'ipStatus', title: '状态', width: 100}, 
		{field: 'useCount', title: '使用数', width: 100}, 
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
    			url: basepath+'ip',
    			type: 'post',
    			async: false,
    			dataType: 'json',
    			data:{ids: data.id, action: method},
    			success: function(res){
    				if(res.code === 200){ 
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
	    });
	  } else if(layEvent === 'edit'){ //编辑
		  
	    method = layEvent;
	    var othis = $(this);
	    
		active[method] ? active[method].call(this, othis) : '';
		
		form.val("tipsform", {
				"id": data.id,
			  "startIP": data.startIP
			  ,"endIP": data.endIP
			  ,"ipStatus": data.ipStatus
			});
		
	    
	  }
	});  
  
  
//按钮触发事件
  var active = {
    
    add: function(othis){
      var type = othis.data('type'),text = othis.text();
      layer.open({
        type: 1
        ,offset: type
        ,title: '创建IP段'
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
	    		url:basepath+'ip',
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
    },
    edit:function(othis){
    	var type = othis.data('type'),text = othis.text();
	      layer.open({
	        type: 1
	        ,offset: type
	        ,title: '编辑'
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
		    		url:basepath+'ip',
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
		    ,cancel: function(index, layero){ 
	        	table.reload('LAYTB', {
	        		 page: {
	        		    curr: 1 //重新从第 1 页开始
	        		  }
	        		}); 
	        	} 
	      });
	      //重新渲染动态加载的表单
	      form.render(null, 'tipsform');
    },
    dispatch: function(othis){
    	//ajax先请求到正在运行的虚拟机主机
        var type = othis.data('type'),text = othis.text();
        layer.open({
          type: 1
          ,offset: type
          ,title: 'IP分配'
          ,id: 'layer'+type //防止重复弹出
          ,area: '800px'
          ,content: '<div style="padding: 20px 50px;">'+$('#layerform2').html()+'</div>'
          ,shade: 0.5
          ,btn: ['提交', '取消']
  	    ,yes: function(index, layero){
  	        //按钮【提交】的回调
  	    	form.verify();
  	    	var data = form.val("tipsform");
  	    	$.ajax({
  	    		url:basepath+'ip',
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
  
  $('.layui-btn-container .layui-btn').on('click', function(){
    var othis = $(this);
    method = othis.data('method');
    active[method] ? active[method].call(this, othis) : '';
  });
  
  form.on('radio(manual)', function(data){
	  $("#manual").show();
	});
  form.on('radio(dhcp)', function(data){
	  $("input[name=manualIP]").val("");
	  $("#manual").hide();
	}); 
  
});