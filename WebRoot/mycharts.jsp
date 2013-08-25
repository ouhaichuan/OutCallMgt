<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="CN">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap.css">

<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

<script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="artDialog4.1.7/artDialog.js?skin=twitter"></script>
<script src="artDialog4.1.7/jquery.artDialog.js"></script>
<script src="artDialog4.1.7/plugins/iframeTools.js"></script>
<script src="js/highcharts.js"></script>
<script src="js/exporting.js"></script>

<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.brand {
	font-family: georgia, serif;
}

.brand .first {
	color: #ccc;
	font-style: italic;
}

.brand .second {
	color: #fff;
	font-weight: bold;
}
</style>

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Le fav and touch icons -->
<link rel="shortcut icon" href="../assets/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="../assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="../assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="../assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="../assets/ico/apple-touch-icon-57-precomposed.png">
<style>
body {
	height: 100%;
	overflow: hidden;
	margin: 0px;
	padding: 0px;
}

.box {
	height: 100%;
	position: absolute;
	width: 100%;
}
</style>
</head>

<body>
	<input id='basePathIn' type="hidden" value="<%=basePath%>">
	<div id='container' class="box"></div>
	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();

		var chart;
		$(function() {
			var basePath = $('#basePathIn').val();
			chart = new Highcharts.Chart({
				chart : {
					renderTo : 'container',
					defaultSeriesType : 'column', //图表类别，可取值有：line、spline、area、areaspline、bar、column等 
					marginRight : 100,
					marginBottom : 30
				},
				title : {
					text : '数据统计', //设置一级标题 
					x : -20
				//center 
				},
				subtitle : {
					text : 'www.wewin.com.cn', //设置二级标题 
					x : -20
				},
				xAxis : {
					categories : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月',
							'八月', '九月', '十月', '十一月', '十二月' ]
				//设置x轴的标题 
				},
				yAxis : {
					title : {
						text : '外呼次数（次）' //设置y轴的标题 
					},
					plotLines : [ {
						value : 0,
						width : 1,
						color : '#808080'
					} ]
				},
				tooltip : {
					formatter : function() {
						return '<b>' + this.series.name + '</b><br/>' + this.x
								+ ': ' + this.y + '次'; //鼠标放在数据点的显示信息，但是当设置显示了每个节点的数据项的值时就不会再有这个显示信息 
					}
				},
				credits : {
					enabled : true,
					href : 'http://www.wewin.com.cn',
					text : '@品胜科技'
				},
				legend : {
					layout : 'vertical',
					align : 'right', //设置说明文字的文字 left/right/top/ 
					verticalAlign : 'top',
					x : -10,
					y : 100,
					borderWidth : 0
				},
				plotOptions : {
					line : {
						dataLabels : {
							enabled : true
						//显示每条曲线每个节点的数据项的值 
						},
						enableMouseTracking : false
					}
				},
				series : [
						{
							name : '张三', //每条线的名称 
							data : [ 7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2,
									26.5, 23.3, 18.3, 13.9, 9.6 ]
						//每条线的数据 
						},
						{
							name : '李四',
							data : [ -0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8,
									24.1, 20.1, 14.1, 8.6, 2.5 ]
						},
						{
							name : '王五',
							data : [ -0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6,
									17.9, 14.3, 9.0, 3.9, 1.0 ]
						},
						{
							name : '赵六',
							data : [ 3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0,
									16.6, 14.2, 10.3, 6.6, 4.8 ]
						} ]
			});
		});
	</script>
</body>
</html>