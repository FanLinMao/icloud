window.onload=function(){
	//获取父窗口link标签对象列表
	var linkList=window.parent.document.getElementsByTagName("link");
	var head=document.getElementsByTagName("head").item(0);
	//外联样式
	for(var i=0;i<linkList.length;i++){
		var l=document.createElement("link");
		l.rel = 'stylesheet'
		l.type = 'text/css';
		l.href=linkList[i].href;
		head.appendChild(l);
	}
	//获取父窗口script标签对象列表
	var scriptList=window.parent.document.getElementsByTagName("script");
	var body=document.getElementsByTagName("body").item(0);
	//外联样式
	for(var i=0;i<scriptList.length;i++){
		var s=document.createElement("script");
		s.type = 'text/javascript';
		if("" != scriptList[i].src || null != scriptList[i].src || undefined != scriptList[i].src){
			s.src=scriptList[i].src;
		}
		body.appendChild(s);
	}
	var iframe =window.parent.document.getElementById("main-content");
	var params = iframe.src;
	var jsfile = params.substring(params.indexOf('=')+1,params.indexOf('&'));
	var s=document.createElement("script");
	s.type = 'text/javascript';
	s.src='../js/'+jsfile+'.js';
	body.appendChild(s);
	
}
