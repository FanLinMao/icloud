
layui.use(['element','table','jquery','upload','layer','form','laytpl'], function(){
	var table = layui.table;
	var $ = layui.jquery;
	var upload = layui.upload;
	var element = layui.element;
	var form = layui.form;
	var laytpl = layui.laytpl;
	element.init();
  var layer = layui.layer;
  var basepath =$("input[name=basePath]", window.parent.document).val();
  var tableIns = table.render({
    elem: '#lay-table',
	height: 400,
	url:basepath+'soft',
	id:'LAYTABLE',
	cols: [[
		{field: 'softId', hide: true},
		{field: 'softName', title: '软件名', width: 450},
		{field: 'size', title: '大小', width: 100,templet:function(d){return d.size+'MB'}}, 
		{field: 'uploader', title: '上传者', width: 100},
		{field: 'uploadDate', title: '上传时间', width: 200},
		{field: 'mark', title: '备注', width: 200},
		{field: 'operation', title: '功能', toolbar: '#row-opBar'}
		]],
	
	page: true,
	limit: 5,
	limits: [5,10,20],
	/* totalRow: true, */
	loading: true,
	text: '数据为空！',
	where:{action: 'list'},
	response:{
		statusName:'code',
		statusCode: 200 
	}
  });
  
//指定允许上传的文件类型
  upload.render({
    elem: '#uploadSoft'
    ,url: basepath+'upload'
    ,accept: 'file' //普通文件
    ,exts: 'rpm|sh|exe|zip|rar|7z' //软件类型
	,progress: function(n, elem){
	    var percent = n + '%' //获取进度百分比
	    element.progress('progressbar', percent);
	  }
  	,error: function(index, upload){
  		layer.alert("上传失败，请重新上传！")
  		$('#progressbar').hide();
	    //当上传失败时，你可以生成一个“重新上传”的按钮，点击该按钮时，执行 upload() 方法即可实现重新上传
	  }
    ,done: function(res, index, upload){
      layer.alert(res.msg);
      $('#progressbar').hide();
      $('#progressbar .layui-progress-bar').attr("lay-percent","0%");
      //重载表格
      tableIns.reload({
    	 page: {
    	    curr: 1 //重新从第 1 页开始
    	  }
    	});
    }
  });
  $('#uploadSoft').click(function(){
	  $('#progressbar .layui-progress-bar').attr("lay-percent","0%");
	  $('#progressbar').show();
  })
  table.on('tool(tb-filter)', function(obj){
	  var data = obj.data; //获得当前行数据
	  var layEvent = obj.event; 
	  if(layEvent === 'del'){ //销毁
		  method = layEvent;
	    layer.confirm('确认删除此软件？', function(index){
	      obj.del();
	      layer.close(index);
	      var loading = layer.load(2);
	      $.ajax({
    			url: basepath+'soft',
    			type: 'post',
    			async: false,
    			dataType: 'json',
    			data:{ids: data.softId, filename:data.softName, action: method},
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
				"softId": data.softId,
			  "softName": data.softName
			  ,"size": data.size
			  ,"uploader": data.uploader
			  ,"uploadDate": data.uploadDate
			,"mark":data.mark
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
        ,title: '编辑'
        ,id: 'layer'+type //防止重复弹出
        ,area: ['500px', '550px']
        ,content: '<div style="padding: 20px 50px;">'+$('#layerform').html()+'</div>'
        ,shade: 0.5
        ,btn: ['提交', '取消']
	    ,yes: function(index, layero){
	        //按钮【提交】的回调
	    	form.verify();
	    	var loading = layer.load(2);
	    	var data = form.val("tipsform");
	    	$.ajax({
	    		url:basepath+'soft',
	    		type:'post',
	    		async: false,
	    		data:{action:method,parameters:JSON.stringify(data)},
	    		success:function(data){
	    			if(data.code === 200){
	    				layer.close(loading);
	    				//重载表格
    				    tableIns.reload({
    				    	page: {
    				    		curr: 1 //重新从第 1 页开始
    				    	}
				    	});
	    				layer.alert(data.msg);
	    				
	    			}else{
	    				layer.close(loading);
	    				layer.alert(data.msg);
	    			}
	    		},
	    		error:function(xhr,s,e){
	    			layer.close(loading);
	    			layer.alert("请求失败："+xhr+","+s+","+e);	
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