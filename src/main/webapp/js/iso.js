
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
    url: basepath+'iso',
	height: 300,
	id: 'LAYTABLE',
	cols: [[
		{field: 'id', hide: true},
		{field: 'isoName', title: '名称', width: 350},
		{field: 'osType', title: '操作系统类型', width: 200}, 
		{field: 'osSize', title: '大小', width: 100,templet:function(d){return d.osSize+'MB'}},
		{field: 'creator', title: '上传者', width: 100},
		{field: 'createDate', title: '创建时间', width: 150},
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
    elem: '#uploadIso'
    ,url: basepath+'upload'
    ,accept: 'file' //普通文件
    ,exts: 'iso' //只允许上传iso文件
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
  $('#uploadIso').click(function(){
	  $('#progressbar').show();
  })
  table.on('tool(tb-filter)', function(obj){
	  var data = obj.data; //获得当前行数据
	  var layEvent = obj.event; 
	  if(layEvent === 'del'){ //销毁
		  method = layEvent;
	    layer.confirm('确认删除此ISO镜像文件？', function(index){
	      obj.del();
	      layer.close(index);
	      var loading = layer.load(2);
	      $.ajax({
    			url: basepath+'iso',
    			type: 'post',
    			async: false,
    			dataType: 'json',
    			data:{ids: data.id, filename: data.isoName, action: method},
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
						layer.close(loading);
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
			  "isoName": data.isoName
			  ,"osType": data.osType
			  ,"osSize": data.osSize
			  ,"creator": data.creator
			,"createDate":data.createDate
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
        ,title: '修改ISO'
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
	    		url:basepath+'iso',
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
  //加载进度条
  /*function open_progress(){
	    var  content ='<div class="layui-progress layui-progress-big" lay-filter="progress"  lay-showPercent="yes">\n' +
	        '  <div class="layui-progress-bar layui-bg-green" lay-percent="" id="progress"></div>\n' +
	        '</div>';
	    layer.open({
	        type: 1,
	        title: false,
	        closeBtn: 0,
	        resize: false,
	        area: ['800px', '18px'],这里要加入弹层的宽高，然后一个灰色的进度条就出现在弹层的顶部
	        content:content,
	        success: function(layero, index){
	            element.init();
	        }
	    });
	}*/
  
  
});