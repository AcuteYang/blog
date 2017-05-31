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

var box=new Vue({
	el:"#box",
	data:{
		messageChosen:true,
		commentChosen:false,
		requestChosen:false
	},
	methods:{
		messageClick:function(){
			this.messageChosen=true;
			this.commentChosen=false;
			this.requestChosen=false;
		},
		commentClick:function(){
			this.commentChosen=true;
			this.messageChosen=false;
			this.requestChosen=false;
		},
		requestClick:function(){
			this.requestChosen=true;
			this.messageChosen=false;
			this.commentChosen=false;
		}
	}

})