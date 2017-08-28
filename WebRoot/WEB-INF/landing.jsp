<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>登陆</title>

		<link href="${pageContext.request.contextPath}/css/land.css" rel="stylesheet" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.8.2.js"></script>
		<script type="text/javascript">
			$(window).load(function() {

				//用来重新生成验证码
				$('#imgcheck').click(function() {
					$(this).attr('src', "${pageContext.request.contextPath}/check.do?time=" + new Date().getTime());
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
						checkLandingUserValitedAndNot(userName);
					}
				});
				//下面是密码的校验
				$('#password').blur(function() {
					var password = $(this).val();
					var userName = $('#username').val();
					if(password == null || password == '') {
						$('#passError').html('密码是空的');
					} else {
						//这里要判定当密码不是空的时候，和数据库存储的是否一致
						checkLandingpasswordRightOrWrong(password, userName);
					}
					//else{$('#passError').html("<font color='green'>密码合法</font>");}
				});
				/**
				 * 验证用户密码是否合法
				 * @param {Object} checkLandingpasswordRightOrWrong(password)
				 */
				function checkLandingpasswordRightOrWrong(password, userName) {
					var url = "${pageContext.request.contextPath}/user.do";
					$.post(url, {
						'method': 'checkLandingPassword',
						'uPassword': password,
						'uName': userName
					}, function(backData) {
						$("#passError").html(backData);
					});
				};

				/**
				 * 验证这个用户名是否存在
				 * @param {Object} checkLandingUserValitedAndNot
				 */
				function checkLandingUserValitedAndNot(userName) {
					var url = "${pageContext.request.contextPath}/user.do";
					$.post(url, {
						'method': 'checkLandingUserName',
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
			<!---logo---------------->
			<div class="logo">
				<img src="${pageContext.request.contextPath}/images/logo_bg.jpg" />
			</div>
			<!---logo end---------------->
			<!--------------------正文开始------------------------------------>

			<div class="content">
				<div class="left1"><img src="${pageContext.request.contextPath}/images/login_banner.jpg"></div>
				<form method="post" action="${pageContext.request.contextPath}/user.do">
					<input type="hidden" name="method" value="landing"></input>
					<div class="tab1" id="tab1">
						<!------------------------菜单-------------------------------->
						<div class="menu">
							<li id="one1" onclick="setTab('one',1)">账户登录</li>
						</div>

						<div class="user">
							<label for="username">用 户 名:</label>
							<input type="text" id="username" name="uName" class="bBorder" value="" style="height:25px;  line-height:25px; width:150px;" />
							<div id="nameError" style="display:inline; color:#F00">*</div>
						</div>

						<div class="user_1">
							<label for="password">登陆密码:</label>
							<input type="password" id="password" name="uPassword" class="bBorder" value="" style="height:25px; width:150px;line-height:25px;" />
							<div id="passError" style="display:inline; color:#F00">*</div>
						</div>

						<div class="end">
							<div class="user_2">验 证 码：<input type="text" id="yzm" name="yzm" class="bBorder" value="" style="height:25px; width:100px;line-height:25px;" />
								<div id="yzmError" style="display:inline"></div>
							</div>
							<div class="user_3"><img id="imgcheck" src="${pageContext.request.contextPath}/check.do" /></div>
						</div>
					</div>
					<!------------------------菜单end----------------------------->
					<!---------------------------------账户登录------------------------>
					<div class="public"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="radio" value="" />记住用户名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="radio1" value="" />自动登陆
						<div class="pict">
							<input type="submit" id="submit" value="登陆" style=" background-color:#C41006;color:#FFF; width:80px; height:28px;" />
						</div>

						<span style="font-size:12px">&nbsp;&nbsp;&nbsp;&nbsp;您还不是邦购网用户?马上加入吧~~</span>
						<a href="${pageContext.request.contextPath}/index.do?method=regist"><input type="button" value="马上注册>>" /> </a>
						<div class="jietu"><img src="${pageContext.request.contextPath}/images/3 (2).jpg" /></div>
					</div>

				</form>
			</div>

			<div class="foot">
				美特斯邦威集团网站： 美特斯邦威 | ME&CITY | CH'IN祺 | 时尚秘书 | 邦购网
			</div>
		</div>
	</body>

</html>