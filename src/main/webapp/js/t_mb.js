var method = '';
layui.use(['element','table','jquery','form','layer','laytpl'], function(){
	var laytpl = layui.laytpl;
  var table = layui.table;
  var element = layui.element;
  var $ = layui.jquery;
  var form = layui.form;
  var basepath =$("input[name=basePath]", window.parent.document).val();
  table.render({
    elem: '#lay-table',
    url: basepath+'template',
	method: 'post',
	id: 'LAYTB',
	height: 460,
	cols: [[
		{field: 'templateId', hide: true},
		{field: 'templateName', title: '名称', width: 120},
		{field: 'osType', title: '操作系统类型', width: 400}, 
		{field: 'creator', title: '制作人', width: 100},
		{field: 'createDate', title: '创建时间', width: 200},
		{field: 'operation', title: '操作', toolbar: '#row-opBar'}
		]],
	page: true,
	limit: 5,
	limits: [5,10,20],
	/*totalRow: true,*/
	loading: true,
	text: '数据为空！',
	where:{action: 'listTemplates'},
	response:{
		statusName:'code',
		statusCode: 200 
	}
  });
  
  table.on('tool(tb-filter)', function(obj){
	  var data = obj.data; //获得当前行数据
	  var layEvent = obj.event; 
	  if(layEvent === 'destroy'){ //销毁
		  method = layEvent;
	    layer.confirm('确认销毁此模板么？', function(index){
	      obj.del();
	      layer.close(index);
	      var loading = layer.load(2);
	      $.ajax({
    			url: basepath+'template',
    			type: 'post',
    			async: false,
    			dataType: 'json',
    			data:{ids: data.templateId, action: method},
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
	  } else if(layEvent === 'detail'){ //查看
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
  
  //按钮触发事件
  var active = {
    
    register: function(othis){//新增模板
    	$.ajax({
			url: basepath+'template',
			type: 'get',
			//async: false,
			dataType: 'json',
			data:{action: 'listurl'},
			success: function(res){
				if(res.code === 200){ 
					for(var i = 0 ; i < res.data.length; i++){
						 $("select[name=url]").append("<option class='addurl' value='"+res.data[i]+"'>"+res.data[i]+"</option>")
						form.render('select', 'tipsform');
					}
                }  
			},
			error: function(xq,s,e){
				layer.alert(xq+","+s+","+e, {icon: 2,title:'操作信息'});
			}
		})
      var type = othis.data('type'),text = othis.text();
      layer.open({
        type: 1
        ,offset: type
        ,title: '注册模板'
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
	    		url:basepath+'template',
	    		type:'post',
	    		async: false,
	    		data:{action:'registerTemplate',parameters:JSON.stringify(data)},
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
	    	$("option").remove(".addurl");
	    	form.render('select', 'tipsform');
	      //return false;
	    }
      });
      //重新渲染动态加载的表单
      form.render(null, 'tipsform');
    },
    detail:function(othis){
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
  
});