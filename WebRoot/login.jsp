<%@ page language="java"
	import="java.util.*,cn.info.platform.entity.User" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	/**
	 *验证是否登录
	 */
	if (null != request.getSession().getAttribute("user")) {
		response.setContentType("text/html; charset=utf-8");
		response.sendRedirect(basePath + "index.jsp");
	}
%>

<!DOCTYPE html>
<html lang="CN">
<head>
<base href="<%=basePath%>">
<link rel="shortcut icon" href="<%=basePath%>images/favicon.ico" />
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
<script src="artDialog4.1.7/artDialog.js?skin=twitter"></script>
<script src="artDialog4.1.7/jquery.artDialog.js"></script>
<script src="artDialog4.1.7/plugins/iframeTools.js"></script>

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
	<input type="hidden" value="${requestScope.failure}" id='resultHid'>
	<div class="navbar">
		<div class="navbar-inner">
			<ul class="nav pull-right">

			</ul>
			<a class="brand" href="login.jsp"><span class="first">移动</span> <span class="second">外呼</span>
			</a>
		</div>
	</div>
	<div class="row-fluid">
		<div class="dialog">
			<div class="block">
				<p class="block-heading">登&nbsp;&nbsp;录</p>
				<div class="block-body">
					<form method="post" action="user/login.do" id='login_info'>
						<label>工&nbsp;&nbsp;号</label> <input type="text" name="userName"
							id="userName" class="span12"> <label>密&nbsp;&nbsp;码</label>
						<input type="password" class="span12" name="passWord"
							id="passWord">
					</form>
					<button class="btn btn-primary pull-right" id='login_btn'>登
						录</button>
					<label class="remember-me"> <input type="checkbox">记住我
					</label>
					<div class="clearfix"></div>
				</div>
			</div>
			<p class="pull-right" style="">
				<a href="http://www.wewin.com.cn" target="blank">&copy;品胜科技</a>
			</p>
		</div>
	</div>

	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		String.prototype.Trim = function() {
			return this.replace(/(^\s*)|(\s*$)/g, "");
		};
		function validate() {
			var flag = 0;
			if ($('#userName').val().Trim() == ""
					|| $('#passWord').val().Trim() == "") {
				flag = 1;
			} else {
				flag = 2;
			}
			return flag;
		}
		$(function() {
			if ($('#resultHid').val() != "" && $('#resultHid').val() != null) {
				dialog = art.dialog({
					content : $('#resultHid').val(),
					lock : true,
					drag : false,
					resize : false,
					icon : 'warning'
				});
			}
			$('#login_btn').click(function() {
				result = validate();
				if (result == 2) {//验证完成
					$('#login_info').submit();
				} else {
					if (result == 1) {
						result = '工号或密码不能为空';
					} else {
						result = '异常';
					}
					dialog = art.dialog({
						content : result,
						lock : true,
						drag : false,
						resize : false,
						icon : 'warning',
					});
				}
			});
		});
	</script>
</body>
</html>