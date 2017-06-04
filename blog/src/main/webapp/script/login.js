/**
 * 
 */
var login=new Vue({
	el:"#login",
	data: {
		email:"",
		password:"",
		message:""
	},
	methods:{
		requestLogin(){
			var info={
				"email":this.email,
				"password":this.password
			}
			$.ajax({
				url:"/blog/user/loginResult",
				data:info,
				type:'POST',
				dataType:"json",
				success:function(status){
					if(status.statusCode==0){
						login.message=status.statusMessage;
						window.location.href="/blog/user/display/?email="
					}else{
						login.email="";
						login.password="";
						login.message=status.statusMessage;
					}
				},
				error:function(){
					alert("none");
				}
			})
		}
	}
})