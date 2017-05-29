/**
 * 
 */
var request=new Vue({
    	el:"#request",
    	components:{
    		'stranger-info':{
    			template:'<div class="minicard">\
						<div class="photo">\
    					<img class="photo" src="/blog/images/avatar-1.jpg"/>\
    					</div>\
    					<div class="unknown">\
    					<div class="name">{{name}}</div>\
    					<div class="recommendation">{{country}}</div>\
    					</div>\
    					<div class="logo request">\
    					<input id="senderId" name="senderId" type="hidden" v-model="senderId"/>\
    					<input id="receiverId" name="receiverId" type="hidden" v-model="receiverId"/>\
    					<i class="fa fa-plus" v-on:click="sendRequest"></i>\
    					</div>\
    					</div>',
				props:['senderId','receiverId','name','country'],
				methods:{
					sendRequest:function(){
		        		var d={
		        		        "senderId":parseInt(this.senderId),
		        		        "receiverId":parseInt(this.receiverId)
		    		    }
		     		    $.ajax({
		     		        url:"/blog/user/sendRequest",
		     		        data:d,
		     		        type:"GET",
		     		        dataType:"json",
		     		        success:function(rep){
		     		            //request.sendStatus=rep
		     		        	alert(rep)
		     		        },
		     		        error:function(){
		     		            //request.sendStatus="error"
		     		        	alert("error")
		     		        }
		     		    })
		        	}
				}
    		}
    	},
        data:{
        	strangerList:[]
        }
    })

$.ajax({
    url:"/blog/user/getStranger",
    type:"GET",
    dataType:"json",
    success:function(rep){
        request.strangerList=rep;
    },
    error:function(){
    	alert("error");
    }
})