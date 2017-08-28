<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>我的购物车</title>
		<link href="${pageContext.request.contextPath}/css/myCart.css" type="text/css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="js/myCart.js">
		</script>

	</head>

	<body>
		<div class="top">
			<div class="top_left">
				<ul id="nav">
					<li><img src="${pageContext.request.contextPath}/images/20140808174744.jpg">
						<ul>
							<li>
								<a href="http://sc.xueit.com/"><img src="${pageContext.request.contextPath}/images/20140810150816.jpg"></a>
							</li>
							<li>
								<a href="http://sc.xueit.com/"><img src="${pageContext.request.contextPath}/images/20140810150724.jpg"></a>
							</li>
							<li>
								<a href="http://sc.xueit.com/"><img src="${pageContext.request.contextPath}/images/20140810150640.jpg"></a>
							</li>
							<li style="border-left: 1px #CCCCCC solid;">
								<a href="http://sc.xueit.com/"><img src="${pageContext.request.contextPath}/images/20140810150607.jpg"></a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
			<div class="top_2">
				<ul id="ul_2">
					<li>
						<a href="index.html">注册</a>
					</li>
					<li>
						<a href="index.html">登录</a>
					</li>
				</ul>
			</div>
			<div class="top_right">
				<ul id="ul_1">
					<li>收藏邦购</li>
					<li>在线客服
						<ul>
							<li>
								<a href="#">意见反馈</a>
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
		<!-------------------------导航栏开始--------------------------->
		<div class="login" id="juzhong">
			<div class="left"><img src="${pageContext.request.contextPath}/images/20140808174701.jpg" title="邦购网_美特斯邦威官方商城"></div>

		</div>
		<!------------------------------->
		<div id="z">
			<img src="${pageContext.request.contextPath}/images/2014-08-10_174948.jpg" />
		</div>

		<div id="z" class="z1">
			<div class="z11">您目前享受:&nbsp;<img src="${pageContext.request.contextPath}/images/2014-08-10_183048.jpg" />&nbsp;单件包邮 </div>
			<div class="z12">&nbsp;<img src="${pageContext.request.contextPath}/images/2014-08-10_183048.jpg" />&nbsp;购物满199免邮</div>
		</div>
		<br />
		<div id="z">
			我挑选的商品
			<hr style="border:2px #CCCCCC solid" />
		</div>

		<div id="content">
			<table width="95%" border="0" cellspacing="0" cellpadding="0" id="shopping">
				<form action="" method="post" name="myform">
					<tr style="margin-bottom:10px; margin-top:10px;">
						<td class="title_1"><input id="allCheckBox" type="checkbox" value="" onclick="selectAll()" />全选</td>
						<td class="title_2" colspan="2">商品名称</td>
						<td class="title_3">赠送积分</td>
						<td class="title_4">单价（元）</td>
						<td class="title_5">数量</td>
						<td class="title_6">小计（元）</td>
						<td class="title_7">操作</td>
					</tr>
                    <c:forEach items="${card.cardItems2}" var="cardItem" varStatus="state">
					<tr id="product1">
						<td class="cart_td_1"><input name="cartCheckBox" type="checkbox" value="product1" onclick="selectSingle()" /></td>
						<td class="cart_td_2">&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/images/${cardItem.product.gSmallPic}" /> </td>
						<td class="cart_td_3"></td>
						<td class="cart_td_4">${cardItem.product.gPrice}</td>
						<td class="cart_td_5">${cardItem.product.gPrice}</td>
						<td class="cart_td_6"><img src="${pageContext.request.contextPath}/images/taobao_minus.jpg" alt="minus" onclick="changeNum('num_1','minus')" class="hand" /> 
						                                <input id="num_1" type="text" value="${cardItem.productCount}" class="num_input" readonly="readonly" /> 
						                                <img src="${pageContext.request.contextPath}/images/taobao_adding.jpg" alt="add" onclick="changeNum('num_1','add')" class="hand" /></td>
						<td class="cart_td_7">${cardItem.subTotalPrice}</td>
						<td class="cart_td_8">
							<a href="#">加入收藏&nbsp;|&nbsp;</a>
							<a href="${pageContext.request.contextPath}/card.do?method=remove&gId=${cardItem.product.gId}">删除</a>
						</td>
					</tr>
                    </c:forEach>
					<%-- <tr id="product2">
						<td class="cart_td_1"><input name="cartCheckBox" type="checkbox" value="product2" onclick="selectSingle()" /></td>
						<td class="cart_td_2">&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/images/2014-08-13_175856.jpg" /></td>
						<td class="cart_td_3"></td>
						<td class="cart_td_4">265</td>
						<td class="cart_td_5">265.00</td>
						<td class="cart_td_6"><img src="${pageContext.request.contextPath}/images/taobao_minus.jpg" alt="minus" onclick="changeNum('num_2','minus')" class="hand" /> <input id="num_2" type="text" value="1" class="num_input" readonly="readonly" /> <img src="${pageContext.request.contextPath}/images/taobao_adding.jpg" alt="add" onclick="changeNum('num_2','add')" class="hand" /></td>
						<td class="cart_td_7"></td>
						<td class="cart_td_8">
							<a href="#">加入收藏&nbsp;|&nbsp;</a>
							<a href="javascript:deleteRow('product2');">删除</a>
						</td>
					</tr>

					<tr id="product3">
						<td class="cart_td_1"><input name="cartCheckBox" type="checkbox" value="product3" onclick="selectSingle()" /></td>
						<td class="cart_td_2"><img src="${pageContext.request.contextPath}/images/2014-08-13_180026.jpg" /></td>
						<td class="cart_td_3"></td>
						<td class="cart_td_4">85</td>
						<td class="cart_td_5">85.00</td>
						<td class="cart_td_6"><img src="${pageContext.request.contextPath}/images/taobao_minus.jpg" alt="minus" onclick="changeNum('num_3','minus')" class="hand" /> <input id="num_3" type="text" value="1" class="num_input" readonly="readonly" /> <img src="${pageContext.request.contextPath}/images/taobao_adding.jpg" alt="add" onclick="changeNum('num_3','add')" class="hand" /></td>
						<td class="cart_td_7"></td>
						<td class="cart_td_8">
							<a href="#">加入收藏&nbsp;|&nbsp;</a>
							<a href="javascript:deleteRow('product3');">删除</a>
						</td>
					</tr> --%>

					<tr>
						<td colspan="2">
							<a href="javascript:deleteSelectRow()">&nbsp;&nbsp;清空所选</a>
						</td>
						<td colspan="6" class="shopend">总价-优惠：&yen;0.00=商品总价（不含运费）：<label id="total" class="yellow"></label> 元&nbsp; 获得积分 <label class="yellow" id="integral"></label> 点
						</td>
					</tr>
				</form>
			</table>

		</div>
		<div id="z" class="z2">
			<div class="z21">
				<a href="${pageContext.request.contextPath}/index.do">&lt;&lt;继续购物</a>
			</div>
			<div class="z22">
				<a href="${pageContext.request.contextPath}/order.do?method=addOrder" style="color:#FFF">去结算</a>
			</div>
		</div>
		<!--------------------------------------------------------->
		<br />
		<div class="z3" id="z">
			<div class="z31">
				购买了此商品的顾客还购买了
			</div>
			<ul class="z33">
				<li><img src="${pageContext.request.contextPath}/images/2014-08-12_090445.jpg" /></li>
				<li><img src="${pageContext.request.contextPath}/images/2014-08-12_090510.jpg" /></li>
				<li><img src="${pageContext.request.contextPath}/images/2014-08-12_090529.jpg" /></li>
				<li><img src="${pageContext.request.contextPath}/images/2014-08-12_090540.jpg" /></li>
			</ul>
		</div>
		<!------------------------结尾--------------------------->
		<div class="end_2" id="juzhong">
			<div class="div_12">
				<h4>新手指南</h4>
				<span style="color:#999; font-size:12px; line-height:20px;">注册新用户<br>找回密码<br>用户协议</span>
			</div>
			<div class="div_13">
				<h4>购物指南</h4>
				<span style="color:#999; font-size:12px; line-height:20px;">购物流程<br>订单状态<br>邦购币绑定与使用</span>
			</div>
			<div class="div_13">
				<h4>配送方式</h4>
				<span style="color:#999; font-size:12px; line-height:20px;">配送范围<br>订单拆分<br>商品验货与签收</span>
			</div>
			<div class="div_13">
				<h4>支付方式</h4>
				<span style="color:#999; font-size:12px; line-height:20px;">支付方式<br>发票制度</span>
			</div>
			<div class="div_13">
				<h4>售后服务</h4>
				<span style="color:#999; font-size:12px; line-height:20px;">退换货政策<br>退货办理流程<br>退款说明</span>
			</div>
			<div class="div_14">
				<h4>联系方式</h4>
				<span style="color:#999; font-size:12px; line-height:20px;">客服：400 821 9988<br>监督：021-38119999-6038<br>在线客服</span>
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
			<div class="jw_right"><img src="${pageContext.request.contextPath}/images/20140810221613.jpg"></div>
		</div>
		<div class="end_5">
			<div class="div_17" id="juzhong">
				<span>&nbsp;&nbsp;CopyRight © 2000-2014, 版权所有 banggo.com 沪ICP备05033127号</span>
			</div>
			<div class="div_17" id="juzhong">
				<div class="div_18"><img src="${pageContext.request.contextPath}/images/20140808200022.jpg"></div>
				<div class="div_19"><img src="${pageContext.request.contextPath}/images/20140808200108.jpg"></div>
				<div class="div_20"><img src="${pageContext.request.contextPath}/images/20140808200124.jpg"></div>
			</div>
		</div>

	</body>

</html>