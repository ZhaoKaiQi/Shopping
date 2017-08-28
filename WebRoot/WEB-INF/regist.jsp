<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>注册</title>
		<link href="${pageContext.request.contextPath}/css/regist.css" rel="stylesheet" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/regist.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery-1.8.2.js"></script>
		<script type="text/javascript">
		
			$(window).load(function() {
			
			//用来重新生成验证码
			$('#imgcheck').click(function() {
			$(this).attr('src',"${pageContext.request.contextPath}/check.do?time="+new Date().getTime());
	});

				//做前台的校验
				$('#username').blur(function() {
					//失去焦点的时候调用
					var userName = $(this).val();
					if(userName == null || userName == '') {
						//直接告诉他用户名为null
						$('#nameError').html('用户名是空的');
					} else {
						//进入后台进行校验
						checkUserNameExitOrNot(userName);
					}
				});
				//下面是密码的校验
				$('#password').blur(function() {
					var password = $(this).val();
					if(password == null || password == '') {
						$('#passError').html('密码是空的');
					} else {
						$('#passError').html("<font color='green'>密码合法</font>");
					}
				});
				/**
				 * 验证两次输入的密码是否一致
				 * @param {Object} checkUserNameExitOrNot
				 */
				$('#repassword').blur(function() {
					var repassword = $(this).val();
					var password = $('#password').val();
					if(repassword != password) {
						$('#passError1').html('密码不一致');
					}else if(repassword==null||repassword==""){
						$('#passError1').html('确认密码是空的');
					} else {
						$('#passError1').html("<font color='green'>确认成功</font>");
					}
				});

				/**
				 * 验证这个用户名是否重复
				 * @param {Object} checkUserNameExitOrNot
				 */
				function checkUserNameExitOrNot(userName) {
					var url = "${pageContext.request.contextPath}/user.do";
					$.post(url, {
						'method': 'checkUserName',
						'uName': userName
					}, function(backData) {
						$("#nameError").html(backData);
					});
				};

			});
		</script>
	</head>

	<body>
		<div class="sum">
			<div class="logo">
				<img src="${pageContext.request.contextPath}/images/logo_bg.jpg" />
			</div>

			<div class="content">
				<div class="tab1" id="tab1">
					<!------------------------菜单-------------------------------->
					<div class="menu">
						<ul id="cc">
							<li id="one1">普通注册</li>
						</ul>
					</div>
				</div>
				<!------------------------菜单end----------------------------->

				<!--------------------------table开始---------------------------------->
				<!-----form---------------------------->
				<form method="get" action="${pageContext.request.contextPath}/user.do">
				<input type="hidden" name="method" value="regist"></input>
				<div class="table">
					<span style="margin-left:35px; font-family:'新宋体'">填写账户信息（以下内容均为必填）</span><p></p>
					<!---------------------------------账户登录------------------------>
					
						<div>&nbsp;&nbsp;&nbsp;
							<label for="username">用&nbsp;&nbsp;户&nbsp;&nbsp;名：</label><input id="username" name="uName" type="text" class="inputs" style="height:22px; width:230px" />
							<div id="nameError" style="display:inline; color:#F00">*</div>
						</div>
						<p></p><br/>

						<div>&nbsp;&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：
							<input id="password" type="password" name="uPassword" class="inputs" style="height:22px;width:230px" value="" />
							<div id="passError" style="display:inline; color:#F00">*</div>
						</div>
						<p></p><br/>

						<div>&nbsp;&nbsp;&nbsp;确认密码：
							<input id="repassword" name="repassword" type="password" class="inputs" style="height:22px;width:230px" value="" />
							<div id="passError1" style="display:inline; color:#F00">*</div>
						</div>
						<p></p><br/>

						<div>&nbsp;&nbsp;&nbsp;&nbsp;验&nbsp;&nbsp;证&nbsp;&nbsp;码：<input id="yzm" name="yzm" type="text" class="inputs" onblur="checkYzm()" style="height:22px;width:230px" />
						<div id="passError" style="display:inline; color:#F00">*</div>
						</div>
				</div>
				<!--------------------------table结束---------------------------------->
				<div class="landYzm">
					<img id="imgcheck" src="${pageContext.request.contextPath}/check.do" style="margin-left:130px" />
					<span style="font-size:12px; color:#CCCCCC">看得清吗？</span><p></p>
					<input type="submit" id="submit" value="同意以下协议并注册" style="margin-left:150px; background-color:#C41006; color:#FFF; " />
					
					<br/>
					<span style="font-size:12px; color:#999999; margin-left:180px;">邦购用户协议</span>
				</div>
				</form>
				<div class="pic">
					<img src="${pageContext.request.contextPath}/images/1 (2).jpg" />
				</div>
			</div>
		</div>
		<div class="foot">美特斯邦威网站： 美特斯邦威 | ME＆CITY | CH'IN祺 | 时尚秘书 | 邦购网</div>
	</body>

</html>