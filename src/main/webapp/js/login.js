layui.use(['element','form','jquery','layer'], function(){
  var form = layui.form;
  var element = layui.element;
  var $ = layui.jquery;
  var layer = layui.layer;
  form.on('submit(go)', function(data){
	  var index = layer.load(2, {shade:0.5});
	  var basepath =$("base").attr("href");
	  $.ajax({
		 url: basepath+'login',
		 type: 'post',
		 async: false,
		 dataType: 'json',
		 data: data.field,
		 success: function(data){
			 layer.close(index);
			 if(data.code === 200){
				 window.location.href = basepath+'index';
			 }else{
				 layer.alert(data.msg);
				 form.val("loginbox", { 
					  "username": ""
					  ,"password": ""
					  ,"role": ""
					});
			 }
		 },
		 error: function (XMLHttpRequest, textStatus, errorThrown) {
			 layer.close(index);
			 layer.alert(XMLHttpRequest.readyState+","+textStatus+","+errorThrown);
			 form.val("loginbox", { 
				  "username": ""
				  ,"password": ""
				  ,"role": ""
				});
		}
	  });
	  //return false;
	});
});