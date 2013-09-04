<%@ page language="java"
	import="java.util.*,cn.info.platform.entity.User" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String role_name = "";
	if (null != request.getSession().getAttribute("user")) {
		User user = (User) request.getSession().getAttribute("user");
		role_name = user.getRole_name();
	}
%>
<!DOCTYPE html>
<html lang="CN">
<head>
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

<body>
	<div class="sidebar-nav">
		<a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i
			class="icon-dashboard"></i>外呼系统</a>
		<ul id="dashboard-menu" class="nav nav-list collapse in">
			<%
				if (role_name.equals("管理员")) {
			%>
			<li><a href="users.jsp" target="mainFrame"><i
					class="icon-user"></i>员工管理</a>
			</li>
			<li><a href="projects.jsp" target="mainFrame"><i
					class="icon-th"></i>项目管理</a>
			</li>
			<li><a href="outcall_start.jsp" target="mainFrame"><i
					class="icon-bullhorn"></i>外呼</a>
			</li>
			<li><a href="answers.jsp" target="mainFrame"><i
					class="icon-leaf"></i>外呼回答情况</a>
			</li>
			<li><a href="staticsData.jsp" target="mainFrame"><i
					class="icon-align-left"></i>统计</a>
			</li>
			<li><a href="mycharts.jsp" target="mainFrame"><i
					class="icon-adjust"></i>分析对比</a>
			</li>
			<%
				} else {
			%>
			<li><a href="outcall_start.jsp" target="mainFrame"><i
					class="icon-bullhorn"></i>外呼</a>
			</li>
			<li><a href="staticsData.jsp" target="mainFrame"><i
					class="icon-align-left"></i>统计</a>
			</li>
			<%
				}
			%>
		</ul>
		<a href="help.html" class="nav-header" target="mainFrame"><i
			class="icon-question-sign"></i>帮助</a> <a href="faq.html"
			class="nav-header" target="mainFrame"><i class="icon-comment"></i>FAQ</a>
	</div>
	<script src="lib/bootstrap/js/bootstrap.js"></script>
</body>
</html>