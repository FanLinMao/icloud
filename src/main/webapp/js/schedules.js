var method = '';
var weekof = {"周日":"SUN","周一":"MON","周二":"TUE","周三":"WED","周四":"THU","周五":"FRI","周六":"SAT"};
var freq = {"每周":"weekly","每天":"daily"};
layui.use(['element','form','table','laytpl','laydate','jquery','layer'], function(){
  var table = layui.table;
  var form = layui.form;
  var element = layui.element;
  var laydate = layui.laydate;
  var laytpl = layui.laytpl;
  var $ = layui.jquery;
  var layer = layui.layer;
  var basepath =$("input[name=basePath]", window.parent.document).val();
  //监听提交
  form.on('submit(search)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
  table.render({
    elem: '#lay-table',
    id:'LAYTB',
    url: basepath+'task',
	method: 'post',
	height: 300,
	cols: [[
		{type:'checkbox'},
		{field: 'taskId', hide: true},
		{field: 'jobName', hide: true},
		{field: 'jobGroupName', hide: true},
		{field: 'triggerName', hide: true},
		{field: 'triggerGroupName', hide: true},
		{field: 'frequence', title: '频率', width: 150},
		{field: 'cycle', title: '循环', width: 100},
		{field: 'time', title: '时间', width: 250}, 
		{field: 'action', title: '行为', width: 100}, 
		{field: 'status', title: '状态', templet: '#switchTpl', unresize: true, width: 100}, 
		{field: 'operation', toolbar: '#row-opBar'}
		]],
	page: true,
	limit: 5,
	limits: [5,10,20],
	loading: true,
	text: '数据为空！',
	where:{op: 'list'},
	response:{
		statusName:'code',
		statusCode: 200 
	}
  });
  //监听开关操作
    form.on('switch(openStatus)', function(obj){
    	var msg = '已开启';
		var status = 1;
		if(!obj.elem.checked){
			var msg = '已关闭';
			status = 0;
		}
		$.ajax({
			url: basepath + 'task',
			type: 'get',
			async: false,
			data: {taskId: this.value, status: status},
			success: function(data){
				if(data.code === 200){
					layer.tips(data.msg+"："+msg, obj.othis);
				}else{
					layer.tips(data.msg+"："+msg, obj.othis);
				}
			},
			error: function (xhr, textStatus, errorThrown){
				
				layer.tips('请求错误，请稍后再试！', obj.othis);
				alert(xhr+","+textStatus+","+errorThrown)
			}
		})
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
	    			var id = data[i].taskId;
	    			arr.push(id);
	    		}
	    		var ids = arr.join(",");
	    		$.ajax({
	    			url: basepath+'task',
	    			type: 'post',
	    			async: false,
	    			dataType: 'json',
	    			data:{ids:ids,op:method},
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
	        ,offset: '20px'
	        ,title: '定时计划'
	        ,id: 'layer'+type //防止重复弹出
	        ,area: '800px'
	        ,content: '<div style="padding: 20px 50px;">'+$('#layerform').html()+'</div>'
	        ,shade: 0.5
	        ,zIndex: 1
	      });
	      //重新渲染动态加载的表单
	      form.render(null, 'tipsform');
	      //时间选择器
		  laydate.render({ 
			  elem: '#idate'
			  ,type: 'time'
		  });
		  
		  
	    },
	    edit:function(othis){
	    	var type = othis.data('type'),text = othis.text();
		      layer.open({
		        type: 1
		        ,offset: '20px'
		        ,title: '修改定时计划'
		        ,id: 'layer'+type //防止重复弹出
		        ,area: '800px'
		        ,content: '<div style="padding: 20px 50px;">'+$('#layerform').html()+'</div>'
		        ,shade: 0.5
		        ,zIndex: 1
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
		      
	    }
	  };
	  
	  $('.layui-btn-container .layui-btn').on('click', function(){
		    var othis = $(this)
		    method = othis.data('method');
		    active[method] ? active[method].call(this, othis) : '';
	   });
	  form.on('switch(taskStatus)', function(data){
		  	if(data.elem.checked){
		  		this.value = 1;
		  	}else{
		  		this.value = 0;
		  	}
		});
	  table.on('tool(tb-filter)', function(obj){
		  var data = obj.data; //获得当前行数据
		  var layEvent = obj.event; 
		  if(layEvent === 'del'){ //删除
			  method = layEvent;
		    layer.confirm('真的删除行么？', function(index){
		      obj.del();
		      layer.close(index);
		      var loading = layer.load(2);
		      $.ajax({
	    			url: basepath+'task',
	    			type: 'post',
	    			async: false,
	    			dataType: 'json',
	    			data:{ids: data.taskId, op: method},
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
			  var data = obj.data;
			  //编辑前先更新当前行的状态是否选中，然后更新字段status
			  var statusValue;
			  var isOn = $("input[name='action']").prop("checked");
			  if(isOn){
				  statusValue = 1;
			  }else{
				  statusValue = 0;
			  }
			  //更新到缓存
			  obj.update({
			      status: statusValue
			    });
		    method = layEvent;
		    var othis = $(this);
			active[method] ? active[method].call(this, othis) : '';
			
			$("input[name='status']").removeAttr("checked");
			if(statusValue == 1){
				$("input[name='status']").prop("checked",true);
			}else{
				$("input[name='status']").attr("checked",false);
			}
			if('每天' == data.frequence){
				$('select[name=cycle]').attr('disabled','true');
				  form.render('select');
			}
			var a = {"关机":0,"开机":1};
			form.val("tipsform", {
					"taskId": data.taskId
				  ,"frequence": freq[data.frequence]
				  ,"cycle": weekof[data.cycle]
				  ,"time": data.time
				  ,"action": a[data.action]
				  ,"jobName": data.jobName
				  ,"jobGroupName": data.jobGroupName
				  ,"triggerName": data.triggerName
				  ,"triggerGroupName": data.triggerGroupName
				  ,"status": statusValue
				});
			//时间选择器
			  laydate.render({ 
				  elem: '#idate'
				  ,type: 'time'
				  //,value: data.time
			  });
		    //同步更新缓存对应的值
		    /*obj.update({
		      username: '123'
		      ,title: 'xxx'
		    });*/
		  }
		}); 
		
		//添加、修改任务提交
		  form.on('submit(layerPane)', function(data){ 
		  		var values = data.field;
		  		values.op = method;
	            $.ajax({   
	                url: basepath+'task',       
	                method:'post',       
	                data: values,
					async: false,       
	                dataType:'json',         
	                success:function(res){  
	                     if(res.code === 200){       
	                        layer.alert(res.msg, {icon: 1,title:'操作信息',zIndex:2});
	                     }else{
		                      layer.alert(res.msg, {icon: 2,title:'操作信息',zIndex:2});     
							}            
	                },              
	                error:function (XMLHttpRequest, textStatus, errorThrown) {
	                       layer.alert(XMLHttpRequest+","+textStatus+","+errorThrown)
	                }           
	             });         
	                
	      });
			//定时频率下拉框
		  form.on('select(freq)', function(data){
			  if('daily' == data.value){
				  $('select[name=cycle]').attr('disabled','true');
				  form.render('select');
			  }else{
				  $('select[name=cycle]').removeAttr('disabled');
				  form.render('select');
			  }
			});
});
