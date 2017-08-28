<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/css/main.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/common.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/index.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/slider.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.8.2.js"></script>
<title>邦购网_美特斯邦威官方商城（旗舰店）</title>
<script type="text/javascript">
	function change(dd) {
		var p = document.getElementById("photo");
		p.src = "${pageContext.request.contextPath}/images/" + dd;
	}

	var i = 1;
	var timer = setInterval(function() {
		var p = document.getElementById("photo");
		p.src = "${pageContext.request.contextPath}/images/" + i + ".jpg";
		i++;
		if (i > 5) {
			i = 0;
		}
	}, 3000);

	function fChangeStye(obj) {
		obj.className = "fBorder";
		if (obj.value == "您想要找什么？") {
			obj.value = "";
		}
	}
	function bChangeStye(obj) {
		obj.className = "bBorder";
		if (obj.value == "") {
			obj.value = "您想要找什么？";
		}
	}
</script>
</head>

<body>
	<!------------------------头部开始----------------------------------->
	<div class="top">
		<div class="top_left">
			<ul id="nav">
				<li><img
					src="${pageContext.request.contextPath}/images/20140808174744.jpg">
					<ul>
						<li><a href="http://sc.xueit.com/"><img
								src="${pageContext.request.contextPath}/images/20140810150816.jpg">
						</a>
						</li>
						<li><a href="http://sc.xueit.com/"><img
								src="${pageContext.request.contextPath}/images/20140810150724.jpg">
						</a>
						</li>
						<li><a href="http://sc.xueit.com/"><img
								src="${pageContext.request.contextPath}/images/20140810150640.jpg">
						</a>
						</li>
						<li style="border-left: 1px #CCCCCC solid;"><a
							href="http://sc.xueit.com/"><img
								src="${pageContext.request.contextPath}/images/20140810150607.jpg">
						</a>
						</li>
					</ul></li>
			</ul>
		</div>
		<div class="top_2">
			<ul id="ul_2">
				<li><a href="${pageContext.request.contextPath}/index.do?method=regist">注册</a>
				</li>
				<li><a href="${pageContext.request.contextPath}/index.do?method=landing">登录</a>
				</li>
			</ul>
		</div>
		<div class="top_right">
			<ul id="ul_1">
				<li>收藏邦购</li>
				<li>在线客服
					<ul>
						<li><a href="http://sc.xueit.com/">意见反馈</a>
						</li>
						<li><a href="http://sc.xueit.com/">帮助中心</a>
						</li>
					</ul></li>
				<li>我的邦购
					<ul>
						<li><a href="http://sc.xueit.com/">我的订单</a>
						</li>
						<li><a href="http://sc.xueit.com/">我的收藏</a>
						</li>
					</ul></li>
				<li>积分商城
					<ul>
						<li><a href="http://sc.xueit.com/">会员尊享</a>
						</li>
						<li><a href="http://sc.xueit.com/">潮流会</a>
						</li>
					</ul></li>
				<li>手机商城</li>
			</ul>
		</div>
	</div>
	<!------------------------头部结束----------------------------------->
	<!-------------------------导航栏开始--------------------------->
	<div class="login" id="juzhong">
		<div class="left">
			<img
				src="${pageContext.request.contextPath}/images/20140808174701.jpg"
				title="邦购网_美特斯邦威官方商城">
		</div>
		<div class="center">
			<div class="div_1">
				<form method="post">
					<input type="text" name="choose" id="txteMail" class="bBorder"
						value="您想要找什么？" onFocus="fChangeStye(this)"
						onBlur="bChangeStye(this)" size="50"
						style="height:33px; border:0; border:1px solid #F00"> <input
						type="submit" name="ok" id="ok" value=" "
						style="height:33px; width:49px; background:url(${pageContext.request.contextPath}/images/20140808174845.jpg); border:0 ">
				</form>
			</div>
			<div class="div_2">
				<span><a href="index.html">短袖T恤</a> <a href="index.html">短袖衬衫</a>
					<a href="index.html">连衣裙</a> <a href="index.html">中裤</a> <a
					href="index.html">POLO衫</a> <a href="index.html">夏季特惠</a>
				</span>
			</div>
		</div>
		<div class="right">
			<div class="div_3">
				<a href="index.html"><img
					src="${pageContext.request.contextPath}/images/20140808174801.jpg"
					title="购物车">
				</a>
			</div>
			<div class="div_4">
				购物袋<br>
				<span style=" color: #F00; font-weight:bold">0</span>件商品
			</div>
		</div>
	</div>

	<div class="top">
		<div class="div_6" id="juzhong">
			<span><a href="index.html"
				style="text-decoration:none; color:#F00">14秋新品</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="index.html">当季热卖</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="index.html">时尚男装</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="index.html">漂亮女装</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="index.html">国际潮流</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="index.html">狂野欧美</a>
			</span>
		</div>
	</div>
	<hr color="#FFFFFF">
	<!--------------------------------------菜单栏结束------------------------------------------>
	<!-------------------------------轮播图开始----------------------------------->
	<table width="980" border="1" cellpadding="0" cellspacing="0"
		id="juzhong">
		<tr>
			<td style="height:500px;">
				<div class="lunbo">
					<a href="javascript:change('1.jpg')">1</a> <a
						href="javascript:change('2.jpg')">2</a> <a
						href="javascript:change('3.jpg')">3</a> <a
						href="javascript:change('4.jpg')">4</a> <a
						href="javascript:change('5.jpg')">5</a>
				</div> <img src="${pageContext.request.contextPath}/images/1.jpg"
				title="美特斯邦威" id="photo" style="width: 980px;margin: 0px auto;">
			</td>
		</tr>
	</table>
	<div id="div_zx" style="width: 980px; height: 440px;margin: 0px auto">
		<div id="div_zx_title"
			style="width: 980px; height: 50px; background: pink; margin-top: 20px;">
			<h2
				style="display: inline-block; height: 50px; line-height: 50px; margin-left: 20px;">最新的商品</h2>
			<div id="div_zx_container">
				<ul>
					<li><a href="${pageContext.request.contextPath}/index.do?method=getProductById&gId=1"><img
							src="${pageContext.request.contextPath}/images/1.jpg" />
					</a></li>
					<li><a href="${pageContext.request.contextPath}/index.do?method=getProductById&gId=2"><img
							src="${pageContext.request.contextPath}/images/1.jpg" />
					</a></li>
					<li><a href="#"><img
							src="${pageContext.request.contextPath}/images/1.jpg" />
					</a></li>
					<li><a href="#"><img
							src="${pageContext.request.contextPath}/images/1.jpg" />
					</a></li>
					<li><a href="#"><img
							src="${pageContext.request.contextPath}/images/1.jpg" />
					</a></li>
					<li><a href="#"><img
							src="${pageContext.request.contextPath}/images/1.jpg" />
					</a></li>
					<li><a href="#"><img
							src="${pageContext.request.contextPath}/images/1.jpg" />
					</a></li>
					<li><a href="#"><img
							src="${pageContext.request.contextPath}/images/1.jpg" />
					</a></li>
				</ul>
			</div>
		</div>
	</div>


	<div id="div_zx" style="width: 980px; height: 440px;margin: 0px auto">
		<div id="div_zx_title"
			style="width: 980px; height: 50px; background: pink; margin-top: 20px;">
			<h2
				style="display: inline-block; height: 50px; line-height: 50px; margin-left: 20px;">最热商品</h2>
			<div id="div_zx_container">
				<ul>
					<li><a href="#"><img
							src="${pageContext.request.contextPath}/images/1.jpg" />
					</a></li>
					<li><a href="#"><img
							src="${pageContext.request.contextPath}/images/1.jpg" />
					</a></li>
					<li><a href="#"><img
							src="${pageContext.request.contextPath}/images/1.jpg" />
					</a></li>
					<li><a href="#"><img
							src="${pageContext.request.contextPath}/images/1.jpg" />
					</a></li>
					<li><a href="#"><img
							src="${pageContext.request.contextPath}/images/1.jpg" />
					</a></li>
					<li><a href="#"><img
							src="${pageContext.request.contextPath}/images/1.jpg" />
					</a></li>
					<li><a href="#"><img
							src="${pageContext.request.contextPath}/images/1.jpg" />
					</a></li>
					<li><a href="#"><img
							src="${pageContext.request.contextPath}/images/1.jpg" />
					</a></li>
				</ul>
			</div>
		</div>
	</div>





	<!-------------------------------内容三结束----------------------------------->
	<p>
	<hr size="1" color="#CCCCCC">
	<!------------------------结尾--------------------------->
	<div class="end_2" id="juzhong">

		<div class="div_12">
			<h4>新手指南</h4>
			<span style="color:#999; font-size:12px; line-height:20px;"><a
				href="index.html">注册新用户</a><br>
			<a href="index.html">找回密码</a><br>
			<a href="index.html">用户协议</a>
			</span>
		</div>
		<div class="div_13">
			<h4>购物指南</h4>
			<span style="color:#999; font-size:12px; line-height:20px;"><a
				href="index.html">购物流程</a><br>
			<a href="index.html">订单状态</a><br>
			<a href="index.html">邦购币绑定与使用</a>
			</span>
		</div>
		<div class="div_13">
			<h4>配送方式</h4>
			<span style="color:#999; font-size:12px; line-height:20px;"><a
				href="index.html">配送范围</a><br>
			<a href="index.html">订单拆分</a><br>
			<a href="index.html">商品验货与签收</a>
			</span>
		</div>
		<div class="div_13">
			<h4>支付方式</h4>
			<span style="color:#999; font-size:12px; line-height:20px;"><a
				href="index.html">支付方式</a><br>
			<a href="index.html">发票制度</a>
			</span>
		</div>
		<div class="div_13">
			<h4>售后服务</h4>
			<span style="color:#999; font-size:12px; line-height:20px;"><a
				href="index.html">退换货政策</a><br>
			<a href="index.html">退货办理流程</a><br>
			<a href="index.html">退款说明</a>
			</span>
		</div>
		<div class="div_14">
			<h4>联系方式</h4>
			<span style="color:#999; font-size:12px; line-height:20px;"><a
				href="index.html">客服：400 821 9988<br>
			</a><a href="index.html">监督：021-38119999-6038</a><br>
			<a href="index.html">在线客服</a>
			</span>
		</div>
	</div>
	<div class="end_3" id="juzhong">
		<div class="div_15">
			<span style="color:#F00; line-height:40px">14</span><span>天退换货保障</span>
		</div>
		<div class="div_15">
			<span style="color:#F00; line-height:40px">199</span><span>包邮</span>
		</div>
		<div class="div_16">
			<span style="color:#F00; line-height:40px">100%</span><span>正品保证</span>
		</div>
	</div>
	<div class="end_4" id="juzhong">
		<div class="jw_left">
			<ul id="ul_4">
				<li>门店查询</li>
				<li>搜索推荐</li>
				<li>手机商城</li>
				<li>搜邦购</li>
				<li>诚聘英才</li>
				<li>帮助中心</li>
				<li>关于邦购</li>
			</ul>
		</div>
		<div class="jw_center">
			<ul id="ul_4">
				<li>时尚秘书</li>
				<li>CH'IN祺</li>
				<li>ME@CITY</li>
				<li>美特斯邦威</li>
				<li>集团网站:</li>
			</ul>
		</div>
		<div class="jw_right">
			<img
				src="${pageContext.request.contextPath}/images/20140810221613.jpg">
		</div>
	</div>
	<div class="end_5">
		<div class="div_17" id="juzhong">
			<span>&nbsp;&nbsp;CopyRight © 2000-2014, 版权所有 banggo.com
				沪ICP备05033127号</span>
		</div>
		<div class="div_17" id="juzhong">
			<div class="div_18">
				<img
					src="${pageContext.request.contextPath}/images/20140808200022.jpg">
			</div>
			<div class="div_19">
				<img
					src="${pageContext.request.contextPath}/images/20140808200108.jpg">
			</div>
			<div class="div_20">
				<img
					src="${pageContext.request.contextPath}/images/20140808200124.jpg">
			</div>
		</div>
	</div>
</body>
</html>