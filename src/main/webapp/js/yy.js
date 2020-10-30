//document.addEventListener('DOMContentLoaded', function() {});
layui.use(['element','jquery','laydate','layer','form'], function(){
	var element = layui.element;
	var laydate = layui.laydate;
	var layer = layui.layer;
    var $ = layui.jquery;
    var form = layui.form;
    var basepath =$("input[name=basePath]", window.parent.document).val();
    var dateStr = new Date().toISOString();
    var today = dateStr.substring(0,dateStr.indexOf("T"));
    var events = [];
    var errorMsg = '';
    $.ajax({
    	url: basepath + 'event',
    	type: 'post',
    	async: false,
    	dataType: 'json',
    	data: {action:'listEvent'},
    	success: function(res){
    		if(res.code===200){
    			events = res.data;
    		}else{
    			errorMsg = res.msg;
    		}
    	},
    	error: function(xhr, state, ex){
    		layer.alert(xhr+','+state+','+ex);
    	}
    })
    var calendarEl = document.getElementById('my-calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
	  locale: 'zh-cn',
	  height: 'parent',
      plugins: [ 'interaction', 'dayGrid', 'timeGrid' ],
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay'
      },
      defaultDate: today,
      navLinks: true, // can click day/week names to navigate views
      selectable: true,
      selectMirror: true,
      select: function(arg) {
    	  $.ajax({
  			url: basepath+'event',
  			type: 'get',
  			//async: false,
  			dataType: 'json',
  			data:{action: 'listAddr'},
  			success: function(res){
  				if(res.code === 200){ 
  					for(var i = 0 ; i < res.data.length; i++){
  						 $("select[name=address]").append("<option class='address' value='"+res.data[i]+"'>"+res.data[i]+"</option>")
  						form.render('select', 'eventform2');
  					}
                  }  
  			},
  			error: function(xq,s,e){
  				layer.alert(xq+","+s+","+e, {icon: 2,title:'操作信息'});
  			}
  		})
  		
    	  layer.tab({
    		  area: '600px',
    		  id: 'LAYTB_23',
    		  offset: '20px',
    		  tab: [{
    		    title: '事件时间', 
    		    content: '<div style="padding: 20px 50px;">'+$('#eventBox').html()+'</div>'
    		  }, {
    		    title: '预约信息1', 
    		    content: '<div style="padding: 20px 50px;">'+$('#eventBox2').html()+'</div>'
    		  }, {
    		    title: '预约信息2', 
    		    content: '<div style="padding: 20px 50px;">'+$('#eventBox3').html()+'</div>'
    		  }],
    		  btn:['提交','清空'],
    		  yes:function(index){
    			  var val1 = form.val('eventform');
    			  var val2 = form.val('eventform2');
    			  var val3 = form.val('eventform3');
    			  if(val1.event == null || ''== val1.event){
    				  layer.tips('标题不能为空','#event')
    				  return false;
    			  }
    			  if(val3.teacher == null || ''== val3.teacher){
    				  layer.tips('教师不能为空','#teacher')
    				  return false;
    			  }
    			  calendar.addEvent({
    		            title: val1.event+"-"+val3.teacher,
    		            start: val1.startTime,
    		            end: val1.endTime
    		          })
    		          //提交到服务器
    		          $.ajax({
    		        	  url: basepath + 'event',
    		        	  type: 'post',
    		        	  data: {action:'addEvent', form1:JSON.stringify(val1), form2:JSON.stringify(val2), form3: JSON.stringify(val3)},
    		        	  dataType: 'json',
    		        	  async: false,
    		        	  success: function(res){
    		        		  if(res.code === 200){
    		        			  layer.alert(res.msg,{title: '提示',icon:1})
    		        		  }else{
    		        			  layer.alert(res.msg,{title:'提示',icon:2})
    		        		  }
    		        	  },
    		        	  error: function(xhr, state, ex){
    		        		  layer.alert(xhr+","+state+","+ex);
    		        	  }
    		          })
    		          layer.close(index);
    		  },
    		  btn2:function(index){
    			  $("input[class='layui-input']").val("");
    			  return false;
    		  }
    		}); 
    	  //重新渲染动态加载的表单
    	  form.render(null, 'eventform1');
          form.render(null, 'eventform2');
          form.render(null, 'eventform3');
    	  /*layer.open({
    		  type: 1, 
    		  title: '添加预约',
    		  id: 'LAYTB_23',
    		  offset: '0px',	
    		  content: '<div style="padding: 20px 50px;">'+$('#eventBox').html()+'</div>', //这里content是一个普通的String
    		  btn:['提交','清空'],
    		  yes:function(index){
    			  var val = form.val('eventform');
    			  if(val.event == null || ''== val.event){
    				  layer.tips('标题不能为空','#event')
    				  return false;
    			  }
    			  calendar.addEvent({
    		            title: val.event,
    		            start: val.startTime,
    		            end: val.endTime
    		          })
    		          //提交到服务器
    		          $.ajax({
    		        	  url: basepath + 'event',
    		        	  type: 'post',
    		        	  data: {action:'addEvent', event:val.event, startTime:val.startTime, endTime:val.endTime},
    		        	  dataType: 'json',
    		        	  async: false,
    		        	  success: function(res){
    		        		  if(res.code === 200){
    		        			  console.log('添加成功')
    		        		  }
    		        	  },
    		        	  error: function(xhr, state, ex){
    		        		  layer.alert(xhr+","+state+","+ex);
    		        	  }
    		          })
    		          //提示
    		          layer.close(index);
    		  },
    		  btn2:function(index){
    			  $("input[class='layui-input']").val("");
    			  return false;
    		  }
    		});*/
    	  laydate.render({
        	  elem: '#startTime'
        		  ,type: 'datetime'
        		,format: 'yyyy-MM-ddTHH:mm:ss'
        			,value: arg.start
        	});
    	  laydate.render({
        	  elem: '#endTime'
        		  ,type: 'datetime'
        			  ,format: 'yyyy-MM-ddTHH:mm:ss'
        				  ,value: arg.end
        	});
        calendar.unselect()
      },
      editable: true,
      eventLimit: true, // allow "more" link when too many events
      events: events
    });
    calendar.render();
    if(errorMsg != ''){
    	layer.alert(errorMsg);
    }
    $("input[type='text']").focus(function(){
        $(this).css("border","1px solid black");
      });
      $("input[type='text']").blur(function(){
      	if(this.value == ''){
        	$(this).css("border","1px solid red");
        }
      });
  
});

