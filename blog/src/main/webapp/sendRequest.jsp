<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
<script src="/blog/script/vue.js"></script>

</head>
<body>
    <div id="request">
	    <label>sender</label><input id="senderId" name="senderId" type="number" v-model="senderId"/>
	    <label>receiver</label><input id="receiverId" name="receiverId" type="number" v-model="receiverId"/>
	    <div>{{sendStatus}}</div>
	    <button v-on:click="sendRequest">submit</button>
    </div>

<script>
var request=new Vue({
    el:"#request",
    data:{
        senderId:"",
        receiverId:"",
        sendStatus:"wait",
        resObj:null
    },
    methods:{
        sendRequest:function(){
            
            
        }
    }
})
var d={
    "senderId":4,
    "receiverId":8
}

$.ajax({
    url:"/blog/user/sendRequest",
    data:d,
    type:"GET",
    dataType:"json",
    success:function(rep){
        request.sendStatus=rep;
    },
    error:function(){
        request.sendStatus="error"
    }
})
    
</script>

</body>
</html>