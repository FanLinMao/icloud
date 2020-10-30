layui.use(['table','form','jquery'], function(){
  var $ = layui.jquery;
  var table = layui.table;
  var form = layui.form;
  var basepath =$("input[name=basePath]", window.parent.document).val();
  var tableIns = table.render({
    elem: '#lay-table',
	height: 300,
	url: basepath+'vm',
	id: 'LAYTABLE',
	cols: [[
		{type: 'checkbox'},
		{field: 'vmId', hide: true},
		{field: 'vmName', title: '名称', width: 100},
		{field: 'status', title: '状态', width: 100},
		{field: 'osType', title: '操作系统类型', width: 300}, 
		{field: 'storage', title: '内存', width: 100},
		{field: 'cpu', title: 'CPU', width: 100},
		{field: 'disk', title: '硬盘', width: 100},
		{field: 'createDate', title: '创建时间', width: 200},
		{field: 'operation', title: '控制', toolbar: '#row-opBar'}
		]],
	/*data: [
		{"disk":"255G","cpu":"Intel-core-7u344 2.4HZ ","storage":"1.0G","status":"运行中","isoName": "windows", "osType": "Windows Server 2008", "storage": "Admin", "createDate": "2019/02/12"},
		{"disk":"255G","cpu":"Intel-core-7u344 2.4HZ ","storage":"1.0G","status":"运行中","isoName": "ubantu", "osType": "Ubantu", "storage": "Admin", "createDate": "2019/02/12"},
		{"disk":"255G","cpu":"Intel-core-7u344 2.4HZ ","storage":"1.0G","status":"运行中","isoName": "centos", "osType": "CentOS6.5", "storage": "Admin", "createDate": "2019/02/12"}
		],*/
	page: true,
	limit: 5,
	limits: [5,10,20],
	/* totalRow: true, */
	loading: true,
	text: '数据为空！',
	where:{action: 'listVirtualMachines'},
	response:{
		statusName:'code',
		statusCode: 200 
	}
  });
  
  table.on('tool(tb-filter)', function(obj){
	  var data = obj.data; //获得当前行数据
	  var layEvent = obj.event; 
	  if(layEvent === 'into'){ //进入
		  method = layEvent;
	    
	      var loading = layer.load(2);
	      $.ajax({
    			url: basepath+'vm',
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
	   
	  } else if(layEvent === 'startVirtualMachine'){ //开机
		  method = layEvent;
		  var othis = $(this);
		  active[method] ? active[method].call(this, othis) : '';
		  
	  }else if(layEvent === 'stopVirtualMachine'){ //关闭
		  method = layEvent;
		  var othis = $(this);
		  active[method] ? active[method].call(this, othis) : '';
		  
	  }else if(layEvent === 'make'){ //制作
		  method = layEvent;
		  
	  }
	  
	  
	});
  
  //触发事件
  var active = {
    
	deployVirtualMachine: function(othis){
      var type = othis.data('type'),text = othis.text();
      layer.open({
        type: 1
        ,offset: type
        ,title: '新建虚拟机'
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
	    		url:basepath+'vm',
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
    startVirtualMachine: function(othis){
        var type = othis.data('type'),text = othis.text();
        
  	    	$.ajax({
  	    		url:basepath+'vm',
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
  	    
      },
      stopVirtualMachine: function(othis){
          var type = othis.data('type'),text = othis.text();
	    	$.ajax({
	    		url:basepath+'vm',
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
        },
        destroyVirtualMachine: function(othis){
            var type = othis.data('type'),text = othis.text();
      	    	$.ajax({
      	    		url:basepath+'vm',
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
          },
          rebootVirtualMachine:function(othis){
              var type = othis.data('type'),text = othis.text();
    	    	$.ajax({
    	    		url:basepath+'vm',
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
  };
  
  $('.layui-btn-container .layui-btn').on('click', function(){
	    var othis = $(this)
	    method = othis.data('method');
	    active[method] ? active[method].call(this, othis) : '';
	  });
  
  
});