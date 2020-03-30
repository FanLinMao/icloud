<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String contextPath = request.getContextPath(); //  path = "/travel"
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/"; // basePath="http://localhost:8080/travel/"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>icloud云平台</title>
<link rel="stylesheet" href="./layui/css/layui.css">
<style type="text/css">
  #slide-btn:hover{
	  background-color:#4E5465;
  }
</style>
<script type="text/javascript">
	window.onload = function(){
		document.getElementById('slide-btn').click();
	}
</script>
</head>
<body class="layui-layout-body">
<input type="hidden" name="basePath" value="<%=basePath %>">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header layui-bg-black">
			<div class="layui-logo"
				style="color: #ffffff; font-size: 16px;">iCloud上机系统</div>
			
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:void(0);"> <img
						src="http://t.cn/RCzsdCq" class="layui-nav-img"> <c:out value="${vo.user.username }"></c:out>
				</a> 
				</li>
				<li id="logout" class="layui-nav-item"><a href="javascript:void(0);">注销</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-cyan">
			<div class="layui-side-scroll">
				<%-- 左侧导航区域（可配合layui已有的垂直导航） --%>
				<%-- 折叠菜单按钮 --%>
				<c:if test="${vo.fold}">
				<div id="slide-btn" style="width: 100%;height: 20px;text-align: left;border-bottom: 1px solid #737383;border-top: 1px solid #737383;">
				  	<i class="layui-icon layui-icon-shrink-right" style="position: relative;top: 4px;left: 80px;color: #8D8D8D;font-size: 12px;"></i>
			  	</div>
			  	</c:if>
				<ul class="layui-nav layui-nav-tree layui-bg-cyan" lay-filter="left-menu">
					<c:forEach items="${vo.menuList}" var="menu">
						<li class="layui-nav-item"><a href="${menu.menuHref }"><i class="${menu.menuIcon }"></i><span>&nbsp;&nbsp;</span><span><c:out value="${menu.menuTitle }"></c:out></span></a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<%-- 主体内容 --%>
		<div class="layui-body">
			<iframe id="main-content" frameborder="0" style="width: 100%; min-height: 200px"
				src="./pages/welcome.html"></iframe>
		</div>

		<%-- 底部固定区域 --%>
		<div class="layui-footer">&copy;2020 Flemming. All rights reserved.</div>

	</div>
	<script src="./layui/layui.js"></script>
	<script type="text/javascript" src="./layui/lay/modules/jquery.js"></script>
	<script>
	//加载lay组件
	layui.use(['element','jquery','layer'], function(){
	  var element = layui.element;
	  var $ = layui.jquery;
	  var layer = layui.layer;
		//iframe自适应
	  	$(window).on('resize', function(){
	  		var $content = $('.layui-body');
	  		//$content.height($(this).height - 120);
	  		$content.find('iframe').each(function(){
	  			$(this).height($content.height());
	  		});
	  	}).resize();
	  	element.on('nav(left-menu)', function(elem){
	  	  var a_href = elem.attr("href");
	  	  var ref = a_href.substring(a_href.lastIndexOf("/")+1,a_href.indexOf("."))
	  	  var iframe_src = a_href.substr(1);
	  	  $("#main-content").attr("src","./"+iframe_src+"?ref="+ref+"&t="+new Date().getTime());
	  	  //$("iframe").src = './'+iframe_src+'?ref='+ref;
	  	});
	  
		//侧边菜单栏隐藏
	   var isShow = true;
	      $('#slide-btn').click(function(){
	          //选择出所有的span，并判断是不是hidden
	          $('.layui-nav-item span').each(function(){
	              if($(this).is(':hidden')){
	                  $(this).show();
	              }else{
	                  $(this).hide();
	              }
	          });
	          //判断isshow的状态
	          if(isShow){
	        	  $(".layui-side.layui-bg-cyan").animate({width:'60px'},500);
	        	  $('#slide-btn i').animate({left: '22px'},500);
	        	  $('#slide-btn i').removeClass('layui-icon layui-icon-shrink-right');
	              $('#slide-btn i').addClass('layui-icon layui-icon-app');  //修改图标样式
	        	  $('.layui-body').animate({left:'60px'},500);
	              $('.layui-footer').animate({left:'60px'},500);
	              //二级导航栏隐藏
	             /* $('dd span').each(function(){
	                  $(this).hide();
	              }); */
	              //修改标志位
	              isShow =false;
	          }else{
	        	  $(".layui-side.layui-bg-cyan").animate({width:'200px'},500);
	        	  $('#slide-btn i').animate({left: '80px'},500);
	        	  $('#slide-btn i').removeClass('layui-icon layui-icon-app');
				  $('#slide-btn i').addClass('layui-icon layui-icon-shrink-right');  //修改图标样式
	        	  $('.layui-body').animate({left:'200px'},500);
	              $('.layui-footer').animate({left:'200px'},500);
	              isShow =true;
	          }
	      });
	      var basepath = $("input[name='basePath']").val();
	      //退出
	      $("#logout").click(function(){
	    	  var loading = layer.load(2);
	    	  $.ajax({
	    		  url: basepath + 'logout'
	    		  ,type: 'post'
	    		  ,data: {}
	    	  		,success: function(res){
	    	  			if(res.code === 200){
	    	  				layer.close(loading);
	    	  				window.location.href = basepath + 'login';
	    	  			}else{
	    	  				
	    	  			}
	    	  		}
	    	  		,error: function(xhr,s,e){
	    	  			layer.alert('出错：'+xhr.readtState+","+s+","+e);
	    	  		}
	    	  })
	      })
	      
	});
	
	
	
	
</script>
</body>
</html>