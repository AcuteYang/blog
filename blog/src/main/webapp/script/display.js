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
    					<div class="logo request pointer">\
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

$.ajax({
	url:"/blog/user/getPendingRequest",
	type:"GET",
	dataType:"json",
	success:function(rep){
		navigator.requestList=rep;
	},
	error:function(){
		alert("wrong");
	}
})

var navigator=new Vue({
	el:"#navigator",
	data:{
		messageChosen:true,
		commentChosen:false,
		requestChosen:false,
		boxChosen:false,
		requestList:[],
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
		},
		boxClick:function(){
			this.boxChosen=!this.boxChosen;
		}
	},
	components:{
		'pending-request':{
			template:'<div class="line">\
						<div>\
							<img class="photo" src="/blog/images/avatar-4.jpeg"/>\
						</div>\
						<div class="unknown">\
							<div class="name">{{name}}</div>\
							<div class="recommendation">{{country}}</div>\
						</div>\
						<div class="deal">\
							<div class="pointer logo" v-on:click="dealRequest(3)">\
								<i class="fa fa-check"></i>\
							</div>\
							<div class="pointer logo" v-on:click="dealRequest(4)">\
								<i class="fa fa-times"></i>\
							</div>\
						</div>\
					</div>',
			props:['senderId','recieverId','name','country'],
			methods:{
				dealRequest(ac){
					var d={	
							"senderId":parseInt(this.senderId),
	        		        "receiverId":parseInt(this.receiverId),
	        		        "requestStatus":ac
					}
					$ajax({
						url:""
					})
				}
			},
		}
	}
})