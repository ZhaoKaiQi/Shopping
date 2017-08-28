<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>收货地址</title>
<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/address.css" rel="stylesheet" type="text/css" />
</head>

<body onload="getPre()">
<div class="top">
 <div class="top_left">
 <ul id="nav">
  <li><img src="${pageContext.request.contextPath}/images/20140808174744.jpg">
   <ul>
        <li><a href="http://sc.xueit.com/"><img src="${pageContext.request.contextPath}/images/20140810150816.jpg"></a></li>
        <li><a href="http://sc.xueit.com/"><img src="${pageContext.request.contextPath}/images/20140810150724.jpg"></a></li>
        <li ><a href="http://sc.xueit.com/"><img src="${pageContext.request.contextPath}/images/20140810150640.jpg"></a></li>
        <li style="border-left: 1px #CCCCCC solid;"><a href="http://sc.xueit.com/"><img src="${pageContext.request.contextPath}/images/20140810150607.jpg"></a></li>
   </ul>
  </li>
 </ul>
 </div>
 <div class="top_2">
  <ul id="ul_2">
  <li><a href="index.html"></a></li>
  <li><a href="index.html"></a></li>
  </ul>
 </div>
 <div class="top_right">
  <ul id="ul_1">
   <li>收藏邦购</li>
   <li>在线客服
   <ul>
        <li><a href="#">意见反馈</a></li>
        <li><a href="http://sc.xueit.com/">帮助中心</a></li>
      </ul>
   </li>
   <li>我的邦购
   <ul>
        <li><a href="http://sc.xueit.com/">我的订单</a></li>
        <li><a href="http://sc.xueit.com/">我的收藏</a></li>
      </ul>
   </li>
   <li>积分商城
    <ul>
        <li><a href="http://sc.xueit.com/">会员尊享</a></li>
        <li><a href="http://sc.xueit.com/">潮流会</a></li>
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
<!---------->
<div class="addtop">
<img src="${pageContext.request.contextPath}/images/2014-08-12_091448.jpg" />
</div>
<!------------------------------------->
<div class="add1">
     <div class="add11">
     <br />
     &nbsp;&nbsp;收货地址&nbsp;
     </div> 
     <div class="add12">
     <ul class="add13">
         <li><font color="#FF0000">*</font>选择地区：<select id="selP" onchange="addCity()"></select><select id="selC"></select></li>
         <li><font color="#FF0000">*</font>详细地址：<input type="text" size="44px" style=" height:20px; border:#EBEBEB 1px solid" /></li>
         <li><font color="#FF0000">*</font>收货人&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" size="24px" style=" height:20px; border:#EBEBEB 1px solid" /></li>
         <li><font color="#FF0000">*</font>手&nbsp;&nbsp;机&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="tel" size="18px" style=" height:20px; border:#EBEBEB 1px solid" /><font  color="#C1C1C1">或者&nbsp;&nbsp;固定电话：</font><input type="text" size="10px" style=" height:20px; border:#EBEBEB 1px solid" />
         <input type="text" size="18px" style=" height:20px; border:#EBEBEB 1px solid" /><font  color="#C1C1C1">两者至少填写一项</font></li>
         <li style="margin-left:100px;"><a href="#" style="color:#FFF"><input type="button"  style="background-color:#F00;border:none; height:40px; size:120px; color:#FFF; font-family: 微软雅黑; font-size:16px" value="&nbsp;&nbsp;确认收货人信息&nbsp;&nbsp;" /></a></li>
     </ul>
     </div>
</div>
<!----------------------------------------->
<div class="add2">
      <div class="add21">
      &nbsp;&nbsp;支付方式&nbsp;&nbsp;
      </div>
      <div class="add22">
      <div class="add23">
      <input type="radio"  />在线支付（<font  color="#979797">及时到账，支持绝大多数借记卡、信用卡</font>）
      </div>
      </div>
</div>
<!----------------------------------------->
<div class="add3">
      <div class="add31">
     &nbsp;&nbsp; 配送方式&nbsp;&nbsp;
      </div>
      <div class="add32">
      <div class="add33">
      <input type="radio"  />快递（配送费用:&nbsp;<font color="#FF0000">0</font>元	）
      </div>
      </div>
</div>
<!----------------------------------------->
<div class="add4">
      <div class="add41">
     &nbsp;&nbsp; 商品清单&nbsp;&nbsp;
      </div>
      <div class="add42">
      <table width="880" height="380"  cellspacing="0" cellpadding="0">
  <tr style="color:#828282" >
    <td  ><div align="center">商品名称</div></td>
    <td ><div align="center">单价（元）</div></td>
    <td ><div align="center">数量</div></td>
    <td ><div align="center">优惠</div></td>
    <td ><div align="center">小计</div></td>
    <td ><div align="center">赠送积分</div></td>
  </tr>
  <tr>
    <td><div align="center"><img  src="${pageContext.request.contextPath}/images/2014-08-12_090240.jpg" /></div></td>
    <td><div align="center">售价:&yen;138.00</div></td>
    <td><div align="center">1</div></td>
    <td><div align="center">0.00</div></td>
    <td><div align="center"><font color="#FF0000">&yen;138.00</font></div></td>
    <td><div align="center">138</div></td>
  </tr>
  <tr>
    <td><div align="center"><img  src="${pageContext.request.contextPath}/images/2014-08-13_175856.jpg" /></div></td>
    <td><div align="center">售价:&yen;155.00</div></td>
    <td><div align="center">1</div></td>
    <td><div align="center">0.00</div></td>
    <td><div align="center"><font color="#FF0000">&yen;155.00</font></div></td>
    <td><div align="center">155</div></td>
  </tr>
  <tr>
    <td><div align="center"><img  src="${pageContext.request.contextPath}/images/2014-08-13_180026.jpg" /></div></td>
    <td><div align="center">售价:&yen;265.00</div></td>
    <td><div align="center">1</div></td>
    <td><div align="center">0.00</div></td>
    <td><div align="center"><font color="#FF0000">&yen;265.00</font></div></td>
    <td><div align="center">265</div></td>
  </tr>
  <tr>
    <td colspan="6" ><div align="right"><input type="radio" />领取发票&nbsp;&nbsp;&nbsp;&nbsp;</div></td>
    </tr>
</table>

      </div>
</div>
<!----------------------------------------->
<div class="add5">
      <div class="add51">
     &nbsp;&nbsp; 结算信息&nbsp;&nbsp;
      </div>
      <div class="add52">
         <div class="add53">商品金额￥558+运费0元-邦购币：￥0&nbsp;&nbsp;应付金额:&nbsp;<font color="#FF0000" size="+2">￥558.00</font></div>
         <p>
         <div align="center" style="margin-top:40px;"><input type="button"  style="background-color:#F00; border:none; height:40px; size:140px; color:#FFF; font-family: 微软雅黑; font-size:16px" value="&nbsp;&nbsp;提交订单&nbsp;&nbsp;" /></div>
      </div>
</div>
<!--------------------------->
<!------------------------结尾--------------------------->
<div class="end_2" id="juzhong">
 <div class="div_12">
 <h4>新手指南</h4>
 <span style="color:#999; font-size:12px; line-height:20px;"><a href="index.html">注册新用户</a><br><a href="index.html">找回密码</a><br><a href="index.html">用户协议</a></span>
 </div>
 <div class="div_13">
 <h4>购物指南</h4>
 <span style="color:#999; font-size:12px; line-height:20px;"><a href="index.html">购物流程</a><br><a href="index.html">订单状态</a><br><a href="index.html">邦购币绑定与使用</a></span>
 </div>
 <div class="div_13">
 <h4>配送方式</h4>
 <span style="color:#999; font-size:12px; line-height:20px;"><a href="index.html">配送范围</a><br><a href="index.html">订单拆分</a><br><a href="index.html">商品验货与签收</a></span>
 </div>
 <div class="div_13">
 <h4>支付方式</h4>
 <span style="color:#999; font-size:12px; line-height:20px;"><a href="index.html">支付方式</a><br><a href="index.html">发票制度</a></span>
 </div>
 <div class="div_13">
 <h4>售后服务</h4>
 <span style="color:#999; font-size:12px; line-height:20px;"><a href="index.html">退换货政策</a><br><a href="index.html">退货办理流程</a><br><a href="index.html">退款说明</a></span>
 </div>
 <div class="div_14">
 <h4>联系方式</h4>
 <span style="color:#999; font-size:12px; line-height:20px;"><a href="index.html">客服：400 821 9988<br></a><a href="index.html">监督：021-38119999-6038</a><br><a href="index.html">在线客服</a></span>
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
