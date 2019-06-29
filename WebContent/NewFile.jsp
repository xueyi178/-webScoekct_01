<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>webScoekct</title>
<script type="text/javascript">
	var ws;  //一个ws对象就是一个通信管道
	//target: 表示服务端的webScoekct的地址,你请求那个就连接那个
	var target = "ws://localhost:8080/webScoekct_01/echo"
	//与服务端建立连接
	function suOpen() {
	    if ('WebSocket' in window) {
      	  ws = new WebSocket(target);
  	  } else if ('MozWebSocket' in window) {
     	   ws = new MozWebSocket(target);
  	  } else {
       	 alert('WebSocket is not supported by this browser.');
       	 return;
    	}
	    
	    //接收服务端的数据
	   ws.onmessage =  function(event){
	    	var dv  = document.getElementById("dv");
	    	dv.innerHTML += event.data;
	    }
	}
	
	//发送消息
	function subSend(){
		var msg  = document.getElementById("msg").value;
		console.log("输出的数据==="+ msg);
		//通过ws中的send方法发送数据
		ws.send(msg);
		document.getElementById("msg").value = ""
	}
</script>
</head>
<body>
	<button onclick="suOpen()">open</button>
	<br/>
	<input id="msg"/>
	<button onclick="subSend()">send</button>
	<br/>
	<div id="dv"></div>
</body>
</html>