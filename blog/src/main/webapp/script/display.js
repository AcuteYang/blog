/**
 * 
 */
var nav=new Vue({
	el:"#nav",
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
							<img class="photo" v-bind:src="avatar"/>\
						</div>\
						<div class="unknown">\
							<div class="name">{{name}}</div>\
							<div class="recommendation">{{country}}</div>\
						</div>\
						<div class="deal">\
							<div class="accepted pointer logo" v-on:click="dealRequest(3)">\
								<i class="fa fa-check"></i>\
							</div>\
							<div class="declined pointer logo" v-on:click="dealRequest(4)">\
								<i class="fa fa-times"></i>\
							</div>\
						</div>\
					</div>',
			props:['requestId','name','country','avatar'],
			methods:{
				dealRequest(ac){
					var d={	
	        		        "requestId":parseInt(this.requestId),
	        		        "requestStatus":ac
					}
					$.ajax({
						url:"/blog/user/dealRequest",
						data:d,
						type:"GET",
	     		        dataType:"json",
	     		        success:function(rep){
	     		        	alert(rep.statusMessage)
	     		        },
	     		        error:function(){
	     		        	alert("oops")
	     		        }
					})
				}
			}
		}
	},
	data:{
		messageChosen:true,
		commentChosen:false,
		requestChosen:false,
		boxChosen:false,
		requestList:[]
	}
})


var request=new Vue({
    	el:"#request",
    	components:{
    		'stranger-info':{
    			template:'<div class="minicard">\
						<div class="photo">\
    					<img class="photo" v-bind:src="avatar"/>\
    					</div>\
    					<div class="unknown">\
    					<div class="name">{{name}}</div>\
    					<div class="recommendation">{{country}}</div>\
    					</div>\
    					<div class="logo request pointer">\
    					<i class="fa fa-plus" v-on:click="sendRequest(index)"></i>\
    					</div>\
    					</div>',
				props:['senderId','receiverId','name','country','avatar','index'],
				methods:{
					sendRequest(index){
		        		var d={
		        		        "senderId":parseInt(this.senderId),
		        		        "receiverId":parseInt(this.receiverId)
		    		    }
		     		    $.ajax({
		     		        url:"/blog/user/sendRequest",
		     		        data:d,
		     		        type:"GET",
		     		        dataType:"json",
		     		        success:function(rep,index){
		     		        	request.strangerList.splice(index,1);
		     		        	alert(rep.statusMessage)
		     		        },
		     		        error:function(){
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
	url:"/blog/user/getPendingRequest",
	type:"GET",
	dataType:"json",
	success:function(rep){
		nav.requestList=rep;
	},
	error:function(){
		alert("wrong");
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
    	alert("bad");
    }
})


