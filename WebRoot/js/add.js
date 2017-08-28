// JavaScript Document
var cityList = new Array();
cityList['北京市'] = ['宣武','朝阳','东城','西城','大兴','顺义','房山','海淀','怀柔','延庆','崇文','门头沟','石景山','丰台','通州'];
cityList['上海市'] = ['宝山区','长宁区','丰贤区', '虹口区','黄浦区','青浦区','南汇区','徐汇区','卢湾区'];
cityList['广东省'] = ['深圳市','广州市','惠州市','汕头市','珠海市','佛山市','中山市','东莞市'];
cityList['深圳市'] = ['福田区', '罗湖区', '盐田区', '宝安区', '龙岗区', '南山区', '深圳周边'];
cityList['重庆市'] = ['俞中区', '南岸区', '江北区', '沙坪坝区', '九龙坡区', '渝北区', '大渡口区', '北碚区'];
cityList['天津市'] = ['和平区', '河西区', '南开区', '河北区', '河东区', '红桥区', '塘古区', '开发区'];
cityList['江苏省'] = ['南京市','苏州市','无锡市'];
cityList['浙江省'] = ['杭州市','宁波市','温州市'];
cityList['四川省'] = ['四川省','成都市'];
cityList['海南省'] = ['海口市'];
cityList['福建省'] = ['福州市','厦门市','泉州市','漳州市'];
cityList['山东省'] = ['青岛市','济南市','烟台市','威海市'];
cityList['江西省'] = ['江西省','南昌市'];
cityList['广西省'] = ['柳州市','南宁市'];
cityList['安徽省'] = ['安徽省','合肥市'];
cityList['河北省'] = ['邯郸市','石家庄市'];
cityList['河南省'] = ['郑州市','洛阳市'];
cityList['湖北省'] = ['武汉市','宜昌市'];
cityList['湖南省'] = ['湖南省','长沙市'];
cityList['陕西省'] = ['陕西省','西安市'];
cityList['山西省'] = ['山西省','太原市'];
cityList['黑龙江省'] = ['黑龙江省','哈尔滨市'];
cityList['其他'] = ['其他'];

function getPre()
{
var selP = document.getElementById("selP");
var selC = document.getElementById("selC");
var op1 = new Option("-请选择省份-",-1);
selP.add(op1);
var op2 = new Option("-请选择市-",-1);
selC.add(op2);
for(var p in cityList )
{
var op = new Option(p,p);
selP.add(op);
			 
}
}
function addCity()
{
var selP = document.getElementById("selP");
var selValue= selP.value;
var selC = document.getElementById("selC"); selC.options.length=0;
for(var c in cityList[selValue])
{
var cvalue=cityList[selValue][c];
var op = new Option(cvalue,cvalue);
selC.add(op);
}
}