/**
 * 
 */
var left=new Vue({
	el:"#left",
	data:{
		name:"",
		email:"",
		password:"",
		passwordConfirmed:"",
		emailError:false,
		emailMismatch:"",
		passwordError:false,
		passwordMismatch:"",
		passwordConfirmedError:false,
		passwordConfirmedMismatch:"",
		passwordType:"password"
	},
	methods:{
		emailValidation:function(){
			var emailPattern=/^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/;
			this.emailError=!emailPattern.test(this.email);
			if(this.emailError){
				this.emailMismatch="wrong pattern";
			}else{
				this.emailMismatch="";
			}
		},
		passwordValidation:function(){
			var passwordPattern=/^[\da-zA-Z]*((\d+[a-zA-Z]+)|([a-zA-Z]+\d+))[\da-zA-Z]*$/;
			this.passwordError=!(passwordPattern.test(this.password)&&
					this.password.length>=6&&this.password.length<=25);
			if(this.passwordError){
				this.passwordMismatch="password invalid";
			}else{
				if(this.passwordConfirmed!=""){
					this.passwordMatch();
				}
				this.passwordMismatch="";
			}
		},
		passwordMatch:function(){
			this.passwordConfirmedError=!(this.password==this.passwordConfirmed);
			if(this.passwordConfirmedError){
				this.passwordConfirmedMismatch="mismatched";
			}else{
				this.passwordConfirmedMismatch="";
			}
		},
		displayPwd:function(){
			var pwd = document.getElementById("pwd");
			if(pwd.type==="password"){
				pwd.type="text";
			}else{
				pwd.type="password";
			}
		}
	}
})

var right=new Vue({
	el:"#right",
	data:{
		birthdayYear:"",
		birthdayMonth:"",
		birthdayDay:"",
		gender:"",
		country:"",
		city:"",
		state:"",
		dateError:false,
		dateMismatch:""
	},
	methods:{
		dateValidation(){
			this.dateError=!dateCheck(this.birthdayYear, this.birthdayMonth, this.birthdayDay);
			if(this.dateError){
				this.dateMismatch="invalid";
			}else{
				this.dateMismatch="";
			}
		}
		
	}
})

function dateCheck(Ryear, Rmonth, Rday){
	var year = parseInt(Ryear);
	var month = parseInt(Rmonth);
	var day = parseInt(Rday);
	var nowDate = new Date(Date.now());
	if(0<year&&year<=nowDate.getFullYear()&&isAllDigits(Ryear)&&isAllDigits(Rmonth)&&isAllDigits(Rday)){
		if(month>=1&&month<=12){
			switch(month){
			case 1:case 3:case 5:case 7:case 8:case 10:case 12:
				return day<=31&&day>=1;
			case 4:case 6:case 9:case 11:
				return day<=30&&day>=1;
			case 2:
				return ((isLeapYear(year)&&day<=29)||(!isLeapYear(year)&&day<=28))&&day>=1;
			}
		}
	}else{
		return false;
	}
}

function isLeapYear(year){
	return (year%4==0&&year%100!=0)||(year%100==0&&year%400==0);
}

function isAllDigits(str){
	var strPattern = /^\d+$/;
	return strPattern.test(str);
}