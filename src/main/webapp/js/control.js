layui.use(['element','jquery'], function(){
	var element = layui.element;
	var $ = layui.jquery;
	var basepath =$("input[name=basePath]", window.parent.document).val();
	var lists = new Map();
	$.ajax({
		url:basepath+'controlpanel',
		type:'post',
		async:false,
		data:{action:'listCapacity'},
		success:function(res){
			if(res.code === 200){
				var data = res.data;
				for(var i = 0; i < data.listcapacityresponse.count; i++){
					var arr = data.listcapacityresponse.capacity;
					console.log(arr[i].capacityused)
					lists.set(arr[i].type+"",arr[i].capacityused);
				}
			}
		},
		error:function(xhr,s,e){
			
		}
	})
	console.log(lists)
	//条形图
	var option1 = {
	    legend: {
	        data:['CPU占用','主存储占用','二级存储占用','共享IP占用','内存占用']
	    },
		toolbox: {
		        show : true,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            magicType : {
		                show: true, 
		                type: ['pie', 'funnel'],
		                option: {
		                    funnel: {
		                        x: '25%',
		                        width: '50%',
		                        funnelAlign: 'left',
		                        max: 1548
		                    }
		                }
		            },
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
	    calculable : true,
	    xAxis : [
	        {
	            type : 'category',
	            data : ['系统资源']
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value'
	        }
	    ],
	    series : [
	        {
	            name:'CPU占用',
	            type:'bar',
	            data:[lists.get("1")]
	        },{
	            name:'主存储占用',
	            type:'bar',
	            data:[lists.get("2")]
	        },{
			      name:'二级存储占用',
			      type:'bar',
			      data:[lists.get("6")]
			  },{
			      name:'共享IP占用',
			      type:'bar',
			      data:[lists.get("8")]
			  },{
			      name:'内存占用',
			      type:'bar',
			      data:[lists.get("0")]
			  }
			  
	    ]
	};
	
	//饼图
	var option2 = {
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	        orient : 'vertical',
	        x : 'left',
	        data:['CPU占用','主存储占用','二级存储占用','共享IP占用','内存占用']
	    },
	    toolbox: {
	        show : true,
	        feature : {
	            /* mark : {show: true},
	            dataView : {show: true, readOnly: false},
	            magicType : {
	                show: true, 
	                type: ['pie', 'funnel'],
	                option: {
	                    funnel: {
	                        x: '25%',
	                        width: '50%',
	                        funnelAlign: 'left',
	                        max: 1548
	                    }
	                }
	            }, */
	            restore : {show: true},
	            saveAsImage : {show: true}
	        }
	    },
	    calculable : true,
	    series : [
	        {
	            name:'访问来源',
	            type:'pie',
	            radius : '55%',
	            center: ['50%', '60%'],
	            data:[
	                {value:335, name:'CPU占用'},
	                {value:310, name:'主存储占用'},
	                {value:234, name:'二级存储占用'},
	                {value:135, name:'共享IP占用'},
	                {value:1548, name:'内存占用'}
	            ]
	        }
	    ]
	};
	var mychart = echarts.init(document.getElementById('main'));
	//默认饼图
	mychart.setOption(option2);
	$('.layui-badge-dot').each(function(i){
		if(i == 0){
			$(this).click(function(){
				$(".layui-badge-dot").attr("class","layui-badge-dot layui-bg-black")
				$(this).attr("class","layui-badge-dot layui-bg-green")
				var mychart = echarts.init(document.getElementById('main'));
				mychart.setOption(option2);
				return;
			})
		}else if(i == 1){
			$(this).click(function(){
				$(".layui-badge-dot").attr("class","layui-badge-dot layui-bg-black")
				$(this).attr("class","layui-badge-dot layui-bg-green")
				var mychart = echarts.init(document.getElementById('main'));
				mychart.setOption(option1);
				return;
			})
		}
	})                    
	
})
  
