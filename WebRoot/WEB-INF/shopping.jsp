<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>商品详细</title>
		<link href="${pageContext.request.contextPath}/css/shopping.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			function over(obj_small, obj_big) {
				obj_small.style.border = "solid 1px #999";
				document.getElementById("big").src = "${pageContext.request.contextPath}/images/" +
					obj_big;
			}

			function out(obj_small) {
				obj_small.style.border = 0;
			}
		</script>
		<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css">
	</head>

	<body>
		<div class="top">
			<div class="top_left">
				<ul id="nav">
					<li><img src="${pageContext.request.contextPath}/images/20140808174744.jpg">
						<ul>
							<li>
								<a href="http://sc.xueit.com/"><img src="${pageContext.request.contextPath}/images/20140810150816.jpg">
								</a>
							</li>
							<li>
								<a href="http://sc.xueit.com/"><img src="${pageContext.request.contextPath}/images/20140810150724.jpg">
								</a>
							</li>
							<li>
								<a href="http://sc.xueit.com/"><img src="${pageContext.request.contextPath}/images/20140810150640.jpg">
								</a>
							</li>
							<li style="border-left: 1px #CCCCCC solid;">
								<a href="http://sc.xueit.com/"><img src="${pageContext.request.contextPath}/images/20140810150607.jpg">
								</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
			<div class="top_2">
				<ul id="ul_2">
					<li>
						<a href="regist.html"></a>
					</li>
					<li>
						<a href="landing.html"></a>
					</li>
				</ul>
			</div>
			<div class="top_right">
				<ul id="ul_1">
					<li>收藏邦购</li>
					<li>在线客服
						<ul>
							<li>
								<a href="http://sc.xueit.com/">意见反馈</a>
							</li>
							<li>
								<a href="http://sc.xueit.com/">帮助中心</a>
							</li>
						</ul>
					</li>
					<li>我的邦购
						<ul>
							<li>
								<a href="http://sc.xueit.com/">我的订单</a>
							</li>
							<li>
								<a href="http://sc.xueit.com/">我的收藏</a>
							</li>
						</ul>
					</li>
					<li>积分商城
						<ul>
							<li>
								<a href="http://sc.xueit.com/">会员尊享</a>
							</li>
							<li>
								<a href="http://sc.xueit.com/">潮流会</a>
							</li>
						</ul>
					</li>
					<li>手机商城</li>
				</ul>
			</div>
		</div>
		<!------------------------头部结束----------------------------------->
		<!-------------------------导航栏开始--------------------------->
		<div class="login" id="juzhong">
			<div class="left">
				<img src="${pageContext.request.contextPath}/images/20140808174701.jpg" title="邦购网_美特斯邦威官方商城">
			</div>
			<div class="center">
				<div class="div_1">
					<form method="post">
						<input type="text" name="choose" id="txteMail" class="bBorder" value="您想要找什么？" onFocus="fChangeStye(this)" onBlur="bChangeStye(this)" size="50" style="height:33px; border:0; border:1px solid #F00"> <input type="submit" name="ok" id="ok" value=" " style="height:33px; width:49px; background:url(${pageContext.request.contextPath}/images/20140808174845.jpg); border:0 ">
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
					<a href="index.html"><img src="${pageContext.request.contextPath}/images/20140808174801.jpg" title="购物车">
					</a>
				</div>
				<div class="div_4">
					购物袋<br>
					<span style=" color: #F00; font-weight:bold">0</span>件商品
				</div>
			</div>
		</div>
		<!-------------------------导航栏结束--------------------------->
		<!--------------------------------------菜单栏开始------------------------------------------>

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
		<div class="div biankuang">
			<div class="title">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邦购首页 >秋装新品</div>
			<br>
			<font size="+1"><strong>${product.gName}</strong>
			</font> <strong><font color="#CC0000" size="+1">购买美邦新品满199元即可+49元换购精美锆石项链一条
				&nbsp;&nbsp;&nbsp;单件包邮&nbsp;&nbsp;&nbsp;购物199免邮
		</strong>&nbsp;&nbsp;(商品编号：218438)</ font>
			</br>
			<div class="body1">
				<div class="body2">
					<img src="${pageContext.request.contextPath}/images/big1.jpg" " width="498 " height="498 " id="big " />
			</div>
			<div class="body3 ">
				<div class="body4 ">
					售价:<font size="+1 " color="#CC0000 "><strong>&nbsp;&nbsp;&yen;${product.gPrice}</strong>
					</font><br />
					<br /> vip价:&nbsp;&yen;${product.gVipPrice}&nbsp;&nbsp;svip价:${product.gSvipPrice}</br>
					<br /> 曾送积分:&nbsp;&nbsp;单件送&nbsp;&nbsp;<strong>${product.gPrice}</strong>&nbsp;&nbsp;分
					</br>
					<br />
					<div class="body7 ">
						<img
							src="${pageContext.request.contextPath}/images/2014-08-11_112447.png "
							width="12 " height="14 " />如何成为vip
					</div>

				</div>
				<div class="body5 ">
					<div class="body8 ">
						<br />颜色：请选择颜色 <br />
						<div class="body13 ">
							<div class="body10 ">
								<img
									src="${pageContext.request.contextPath}/images/2014-08-11_124250.png "
									onMouseOver="over(this, 'big9.jpg') " onMouseOut="out(this) " />
							</div>
							<div class="body11 ">
								<img
									src="${pageContext.request.contextPath}/images/2014-08-11_124328.png "
									onMouseOver="over(this, 'big8.jpg') " onMouseOut="out(this) " />
							</div>
							<div class="body12 ">
								<img
									src="${pageContext.request.contextPath}/images/2014-08-11_124340.png "
									onMouseOver="over(this, 'big7.jpg') " onMouseOut="out(this) " />
							</div>
						</div>
						<br />尺码:请选择尺码<br />

					</div>
					<div class="body9 ">
						<div class="body14 ">
							<br />
							<table width="380 ">
								<tr>
									<td width="70 "
										style="border: #D6D6D6 1px solid; font-size:10px; color:#050505 ">165/88A(S)</td>
									<td width="70 "
										style="border: #D6D6D6 1px solid; font-size:10px; color:#050505 ">170/88A(M)</td>
									<td width="70 "
										style="border: #D6D6D6 1px solid; font-size:10px; color:#050505 ">175/92A(L)</td>
									<td width="70 "
										style="border: #D6D6D6 1px solid; font-size:10px; color:#050505 ">180/96A(XL)</td>
									<td width="70 "
										style="border: #D6D6D6 1px solid; font-size:10px; color:#050505 ">185/100B(2XL)</td>
								</tr>
							</table>
						</div>
					</div>
				</div>


				<div class="body6 ">
					<br /> <a href="${pageContext.request.contextPath}/card.do?method=addCard&gId=${product.gId}"> <img
						src="${pageContext.request.contextPath}/images/2014-08-11_145959.png "
						width="128 " height="36 " />
					</a>&nbsp;<img
						src="${pageContext.request.contextPath}/images/2014-08-11_150153.png "
						width="15 " height="12 " />添加到收藏（收藏人气：29）<br /> <img
						src="${pageContext.request.contextPath}/images/2014-08-11_150212.png "
						width="13 " height="21 " /><strong>该商品参与的优惠活动</strong>
				</div>
			</div>
		</div>



		<div class="body16 ">
			<div class="body17 ">
				<div class="body19 ">
					<!-- 这张图是对的，下面的以后再做 -->
					<img
						src="${pageContext.request.contextPath}/images/${product.gSmallPic}"
						onMouseOver="over(this, 'big1.jpg') " onMouseOut="out(this) "
						width="76 " height="76 " />
				</div>
				<div class="body20 ">
					<img
						src="${pageContext.request.contextPath}/images/218438_01--w_76_h_76.jpg "
						onmouseover="over(this, 'big2.jpg') " onMouseOut="out(this) "
						width="76 " height="76 " />
				</div>
				<div class="body21 ">
					<img
						src="${pageContext.request.contextPath}/images/218438_02--w_76_h_76.jpg "
						onmouseover="over(this, 'big3.jpg') " onMouseOut="out(this) "
						width="76 " height="76 " />
				</div>
				<div class="body22 ">
					<img
						src="${pageContext.request.contextPath}/images/218438_04--w_76_h_76.jpg "
						onmouseover="over(this, 'big4.jpg') " onMouseOut="out(this) "
						width="76 " height="76 " />
				</div>
				<div class="body23 ">
					<img
						src="${pageContext.request.contextPath}/images/218438_03--w_76_h_76.jpg "
						onmouseover="over(this, 'big5.jpg') " onMouseOut="out(this) "
						width="76 " height="76 " />
				</div>
				<div class="body24 ">
					<img
						src="${pageContext.request.contextPath}/images/218438_05--w_76_h_76.jpg "
						onmouseover="over(this, 'big6.jpg') " onMouseOut="out(this) "
						width="76 " height="76 " />
				</div>

				<br />
				<div class="body26 ">
					&nbsp;&nbsp;&nbsp;&nbsp;分享该商品到：<img
						src="${pageContext.request.contextPath}/images/2006-01-02_033942.png "
						width="84 " height="15 " />
				</div>
				<div class="body25 ">
					<img
						src="${pageContext.request.contextPath}/images/2006-01-02_040022.png "
						width="146 " height="20 " />
				</div>

			</div>
			<div class="body18 ">
				<table width="467 " height="107 " border="0 " cellpadding="0 "
					cellspacing="0 ">
					<tr>
						<td height="33 "; >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&gt;&gt;购物满199免邮</td>
					</tr>
					<tr>
						<td height="38 "; >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&gt;&gt;购买任意商品满500元，加500元，即可换购千元手表一块</td>
					</tr>
					<tr>
						<td style="font-size:10px; color:#030303; ">&nbsp;</td>
					</tr>
				</table>
			</div>
		</div>



		<div class="body29 ">

			<div class="end_2 " id="juzhong ">
				<div class="div_12 ">
					<h4>新手指南</h4>
					<span style="color:#999; font-size:12px; line-height:20px; "><a
						href="index.html ">注册新用户</a><br>
					<a href="index.html ">找回密码</a><br>
					<a href="index.html ">用户协议</a>
					</span>
				</div>
				<div class="div_13 ">
					<h4>购物指南</h4>
					<span style="color:#999; font-size:12px; line-height:20px; "><a
						href="index.html ">购物流程</a><br>
					<a href="index.html ">订单状态</a><br>
					<a href="index.html ">邦购币绑定与使用</a>
					</span>
				</div>
				<div class="div_13 ">
					<h4>配送方式</h4>
					<span style="color:#999; font-size:12px; line-height:20px; "><a
						href="index.html ">配送范围</a><br>
					<a href="index.html ">订单拆分</a><br>
					<a href="index.html ">商品验货与签收</a>
					</span>
				</div>
				<div class="div_13 ">
					<h4>支付方式</h4>
					<span style="color:#999; font-size:12px; line-height:20px; "><a
						href="index.html ">支付方式</a><br>
					<a href="index.html ">发票制度</a>
					</span>
				</div>
				<div class="div_13 ">
					<h4>售后服务</h4>
					<span style="color:#999; font-size:12px; line-height:20px; "><a
						href="index.html ">退换货政策</a><br>
					<a href="index.html ">退货办理流程</a><br>
					<a href="index.html ">退款说明</a>
					</span>
				</div>
				<div class="div_14 ">
					<h4>联系方式</h4>
					<span style="color:#999; font-size:12px; line-height:20px; "><a
						href="index.html ">客服：400 821 9988<br>
					</a><a href="index.html ">监督：021-38119999-6038</a><br>
					<a href="index.html ">在线客服</a>
					</span>
				</div>
			</div>
			<div class="end_3 " id="juzhong ">
				<div class="div_15 ">
					<span style="color:#F00; line-height:40px ">14</span><span>天退换货保障</span>
				</div>
				<div class="div_15 ">
					<span style="color:#F00; line-height:40px ">199</span><span>包邮</span>
				</div>
				<div class="div_16 ">
					<span style="color:#F00; line-height:40px ">100%</span><span>正品保证</span>
				</div>
			</div>
			<div class="end_4 " id="juzhong ">
				<div class="jw_left ">
					<ul id="ul_4 ">
						<li>门店查询</li>
						<li>搜索推荐</li>
						<li>手机商城</li>
						<li>搜邦购</li>
						<li>诚聘英才</li>
						<li>帮助中心</li>
						<li>关于邦购</li>
					</ul>
				</div>
				<div class="jw_center ">
					<ul id="ul_4 ">
						<li>时尚秘书</li>
						<li>CH'IN祺</li>
						<li>ME@CITY</li>
						<li>美特斯邦威</li>
						<li>集团网站:</li>
					</ul>
				</div>
				<div class="jw_right ">
					<img
						src="${pageContext.request.contextPath}/images/20140810221613.jpg ">
				</div>
			</div>
</body>
</html>