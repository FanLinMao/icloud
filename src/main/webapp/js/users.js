var method = '';
layui.use(['element','form','table','laytpl','jquery','layer'], function(){
	  var table = layui.table;
	  var form = layui.form;
	  var element = layui.element;
	  var laytpl = layui.laytpl;
	  var $ = layui.jquery;
	  var layer = layui.layer;
	  var basepath =$("input[name=basePath]", window.parent.document).val();
	  table.render({
	    elem: '#lay-table',
		url: basepath+'account',
		method: 'post',
		id: 'LAYTB',
		height: 300,
		cols: [[
			{type:'checkbox'},
		{field: 'userId', hide: true},
		{field: 'user', title: '账户', width: 200},
		{field: 'pass', hide: true},
		{field: 'role', title: '角色', width: 300}, 
		{field: 'permission', title: '权限', width: 80}, 
		{field: 'status', title: '状态', templet: '#switchTpl', unresize: true, width: 100}, 
		{field: 'operation',title: '操作', toolbar: '#row-opBar'}
			]],
		page: true,
		limit: 5,
		limits: [5,10,20],
		loading: true,
		text: {none:'数据为空！'},
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
		    layer.confirm('真的删除行么？', function(index){
		      obj.del();
		      layer.close(index);
		      var loading = layer.load(2);
		      $.ajax({
	    			url: basepath+'account',
	    			type: 'post',
	    			async: false,
	    			dataType: 'json',
	    			data:{ids: data.userId, action: method},
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
		    var role=0;
			active[method] ? active[method].call(this, othis) : '';
			$(":password").attr("placeholder","不修改密码则默认为原密码");
			$(":password").removeAttr("required");
			$(":password").removeAttr("lay-verify");
			if(data.role == '管理员'){
				role = 1;
			}else if(data.role == '教师'){
				role = 2;
			}else if(data.role == '学生'){
				role = 3;
			}
			$("input[name='enable']").removeAttr("checked");
			if(statusValue == 1){
				$("input[name='enable']").prop("checked",true);
			}else{
				$("input[name='enable']").attr("checked",false);
			}
			form.val("tipsform", {
					"userId": data.userId,
				  "username": data.user
				  ,"role": role
				  ,"enable": statusValue
				});
			
		    //同步更新缓存对应的值
		    /*obj.update({
		      username: '123'
		      ,title: 'xxx'
		    });*/
		  }
		});  
	form.on('switch(openStatus)', function(obj){
		var msg = '已启用';
		var status = 1;
		if(!obj.elem.checked){
			var msg = '已禁用';
			status = 0;
		}
		$.ajax({
			url: basepath + 'account',
			type: 'get',
			async: false,
			data: {userId: this.value, status: status},
			success: function(data){
				if(data.code === 200){
					layer.tips(data.msg+"："+msg, obj.othis);
				}else{
					layer.tips(data.msg+"："+msg, obj.othis);
				}
			},
			error: function (XMLHttpRequest, textStatus, errorThrown){
				
				layer.tips('请求错误，请稍后再试！', obj.othis);
				alert(XMLHttpRequest+","+textStatus+","+errorThrown)
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
	    			var id = data[i].userId;
	    			arr.push(id);
	    		}
	    		var ids = arr.join(",");
	    		$.ajax({
	    			url: basepath+'account',
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
	        ,title: '添加账户'
	        ,id: 'layer'+type //防止重复弹出
	        ,area: '800px'
	        ,content: '<div style="padding: 20px 50px;">'+$('#layerform').html()+'</div>'
	        ,shade: 0.5
	        ,zIndex: 1
	      });
	      //重新渲染动态加载的表单
	      form.render(null, 'tipsform');
	      $(":password").attr("placeholder","请输入密码");
	      $(":password").attr("required","true");
		  $(":password").attr("lay-verify","password");
	    },
	    edit:function(othis){
	    	var type = othis.data('type'),text = othis.text();
		      layer.open({
		        type: 1
		        ,offset: type
		        ,title: text+'账户'
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
	  form.verify({
		  username: function(value, item){ //value：表单的值、item：表单的DOM对象
		    if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
		      return '用户名不能有特殊字符';
		    }
		    if(/(^\_)|(\__)|(\_+$)/.test(value)){
		      return '用户名首尾不能出现下划线\'_\'';
		    }
		    if(/^\d+\d+\d$/.test(value)){
		      return '用户名不能全为数字';
		    }
		  },
		  password: [
		    /^[\S]{6,12}$/
		    ,'密码必须6到12位，且不能出现空格'
		  ],
		  required:function(value, item){ 
    		    if(value == '' || /^\s*$/.test(value)){
        		      return '该项为必填项，不能出现空白字符或为空';
        		}
           }
		});
	  
	  	form.on('submit(layerPane)', function(data){ 
	  		var values = data.field;
	  		values.action = method;
              $.ajax({   
                  url: basepath+'account',       
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
                         alert(XMLHttpRequest+","+textStatus+","+errorThrown)
                  }           
               });         
                  
        });  
  
	  form.on('switch(accountStatus)', function(data){
		  	if(data.elem.checked){
		  		this.value = 1;
		  	}else{
		  		this.value = 0;
		  	}
		});  
		
		
});