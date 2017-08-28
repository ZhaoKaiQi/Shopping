// JavaScript Document



function setTab(name,cursel){
	cursel_0=cursel;
	for(var i=1; i<=links_len; i++){
		var menu = document.getElementById(name+i);
		var menudiv = document.getElementById("con_"+name+"_"+i);
		if(i==cursel){
			menu.className="off";
			menudiv.style.display="block";
		}
		else{
			menu.className="";
			menudiv.style.display="none";
		}
	}
}
function Next(){                                                        
	cursel_0++;
	if (cursel_0>links_len)cursel_0=1
	setTab(name_0,cursel_0);
} 
var name_0='one';
var cursel_0=1;

var links_len,iIntervalId;
onload=function(){
	var links = document.getElementById("tab1").getElementsByTagName('li')
	links_len=links.length;
	for(var i=0; i<links_len; i++){
		links[i].onmouseover=function(){
			clearInterval(iIntervalId);
			this.onmouseout=function(){
				iIntervalId = setInterval(Next,ScrollTime);;
			}
		}
	}
	document.getElementById("con_"+name_0+"_"+links_len).parentNode.onmouseover=function(){
		clearInterval(iIntervalId);
		this.onmouseout=function(){
			iIntervalId = setInterval(Next,ScrollTime);;
		}
	}
	setTab(name_0,cursel_0);
	iIntervalId = setInterval(Next,ScrollTime);
}

function reg(){
	if(checkUsername()&&checkPass()&&checkPass1()&&checkYzm()){
		return true;
	}
	return false;
}
function checkPass1(){
	var pass1=document.getElementById("password").value;
	var pass2=document.getElementById("pass").value;
	var passError1=document.getElementById("passError1");
	if(pass2.length<6){
		passError.innerHTML="<font color='red' size='4'>×</font>";
		document.getElementById("pass").focus();//获得焦点
		document.getElementById("pass").select();
		return false;
	}
	var p1=/^[a-zA-Z]{6,}$/;
	var p2=/^[0-9]{6,}$/;
	if(p1.test(pass1)){
		passError.innerHTML="<font color='red' size='2'>×密码太简单</font>";
	
		document.getElementById("pass").focus();//获得焦点
		document.getElementById("pass").select();
		return false;
	}
	if(p2.test(pass1)){
		passError.innerHTML="<font color='red' size='4'>× </font>";
		document.getElementById("pass").focus();//获得焦点	
		document.getElementById("pass").select();	
		return false;
	}
	passError1.innerHTML="<font color='green' size='4'>√</font>";
	return true;
	}
	if(pass1==pass2){
		passError1.innerHTML="<font color='green' size='4'>√</font>";
		
		}

function checkUsername(){
	// >6  不能使特殊字符; 字母打头  
	var uname=document.getElementById("username").value;
	var nameError=document.getElementById("nameError");
	if(uname.length<6){
		nameError.innerHTML="<font color='red' size='4'>×</font>";
		
		document.getElementById("username").focus();//获得焦点
		document.getElementById("username").select();
		return false;
	}
	// 
	var p=/^[a-zA-Z]\w{5,}$/;
	if(!p.test(uname)){
		nameError.innerHTML="<font color='red' size='4'>×</font>";
		document.getElementById("username").focus();//获得焦点
		document.getElementById("username").select();
		return false;
	}
	nameError.innerHTML="<font color='green' size='4'>√</font>";
	return true;
}

function checkPass(){
	var password=document.getElementById("password").value;
	var passError=document.getElementById("passError");
	if(password.length<6){
		passError.innerHTML="<font color='red' size='4'>×</font>";
		document.getElementById("password").focus();//获得焦点
		document.getElementById("password").select();
		return false;
	}
	var p1=/^[a-zA-Z]{6,}$/;
	var p2=/^[0-9]{6,}$/;
	if(p1.test(password)){
		passError.innerHTML="<font color='red' size='2'>×密码太简单</font>";
	
		document.getElementById("password").focus();//获得焦点
		document.getElementById("password").select();
		return false;
	}
	if(p2.test(password)){
		passError.innerHTML="<font color='red' size='4'>× </font>";
		document.getElementById("password").focus();//获得焦点	
		document.getElementById("password").select();	
		return false;
	}
	passError.innerHTML="<font color='green' size='4'>√</font>";
	return true;
}
function checkYzm(){
	var yzm=document.getElementById("yzm");
	
	
	if(yzm.value!='8AX4'){
		yzmError.innerHTML="<font color='red' size='2'>×</font>";
		
		document.getElementById("yzm").focus();//获得焦点
		document.getElementById("yzm").select();
		return false;
		}
		else if(yzm.value=='8AX4'){
			return true;
			}
}
function checkEmail(){
		
}