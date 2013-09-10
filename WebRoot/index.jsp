<%@ page language="java"
	import="java.util.*,cn.info.platform.entity.User" pageEncoding="UTF-8"%>
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
<link rel="shortcut icon" href="images/favicon.ico" />
<title>重庆移动外呼系统</title>

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

<link rel="shortcut icon" href="../assets/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="../assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="../assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="../assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="../assets/ico/apple-touch-icon-57-precomposed.png">
</head>

<frameset rows="47,*," cols="*" frameborder="no" border="0"
	framespacing="0">
	<frame src="top.jsp" name="topFrame" frameborder="no" scrolling="No"
		noresize="noresize" id="topFrame" title="topFrame" />
	<frameset name="myFrame" cols="187,5,*" frameborder="no" border="0"
		framespacing="0">
		<frame src="menu.jsp" name="leftFrame" frameborder="no"
			scrolling="yes" noresize="noresize" id="leftFrame" title="leftFrame" />
		<frame src="midbar.html" name="midFrame" frameborder="no"
			scrolling="no" noresize="noresize" id="midFrame" title="midFrame" />
		<frame src="staticsData.jsp" name="mainFrame" scrolling="auto"
			frameborder="no" id="mainFrame" title="mainFrame" />
	</frameset>
</frameset>
<body>
	<script src="lib/bootstrap/js/bootstrap.js"></script>
</body>
</html>
