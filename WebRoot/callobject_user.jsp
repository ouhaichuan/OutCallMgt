<%@ page language="java"
	import="java.util.*,cn.info.platform.entity.User,cn.info.platform.entity.CallObject"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String object_id = request.getParameter("object_id") != null
			? request.getParameter("object_id")
			: "";

	String pnumber = "";
	if (null != request.getParameter("pnumber")) {
		pnumber = new String(request.getParameter("pnumber").getBytes(
				"iso-8859-1"), "utf-8");
	}
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
</head>

<body>
	<input id='basePathIn' type="hidden" value="<%=basePath%>">
	<div>
		<div class="header">
			<h1 class="page-title">绑定工号</h1>
		</div>
		<ul class="breadcrumb">
			<li><a href="index.jsp" target="_parent">主页</a> <span
				class="divider">/</span>
			</li>
			<li><a href="callobject/find_all_callobject.do">号码管理</a> <span
				class="divider">/</span></li>
			<li class="active">绑定工号</li>
		</ul>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="btn-toolbar">
					<button class="btn btn-primary" id="bound_btn">
						<i class="icon-save"></i>&nbsp;&nbsp;绑定
					</button>
					<div class="btn-group"></div>
				</div>
				<div class="well">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#home" data-toggle="tab">详细信息</a>
						</li>
					</ul>
					<div id="myTabContent" class="tab-content">
						<div class="tab-pane active in" id="home">
							<form id="edit_info" action="project/save_pro.do" method="post">
								<input type="hidden" name="object_id" id='object_id'
									value="<%=object_id%>"> <label>外呼号码</label> <input
									name="pnumber" id="pnumber" value="<%=pnumber%>"
									class="span3" /> <label>员工</label>
								<div style="float: left;">
									<select name="user_select" id="user_select"
										style="height:130px;width: 100px" class="span3" size="2">
									</select>
								</div>
								<div id="users_txt" class="span3"
									style="width: 420px;min-height:130px;border: 1px solid;border-color:#97CBFF;height:auto !important;"></div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();

		$(function() {
			var basePath = $('#basePathIn').val();

			$.post(basePath + "user/findUserForPro.do", function(data) {
				var dataUser = eval(data);
				var html = "";
				for ( var i = 0; i < dataUser.length; i++) {
					html += "<option value='"+dataUser[i].userName+"'>"
							+ dataUser[i].user_xm + "</option>";
				}
				$("#user_select").append(html);
			});
			$
					.ajax({
						url : basePath + "objectuser/findbound_user.do",
						type : "post",
						data : {
							object_id : $("#object_id").val()
						},
						success : function(data) {
							var dataUser = eval(data);
							for ( var i = 0; i < dataUser.length; i++) {
								newstr = dataUser[i].user_xm + "&lt;"
										+ dataUser[i].user_name + "&gt;;";
								$('#users_txt')
										.append(
												"<button ondblclick='$(this).remove();' onclick='return false;' style='background-color:transparent;border:0;' text="
														+ newstr
														+ ">"
														+ newstr
														+ "</button>");
							}
						}
					});
			$("#user_select")
					.change(
							function() {
								text = $("#user_select")
										.find("option:selected").text();
								value = $("#user_select").val();
								buttons = $("#users_txt :button");

								for ( var i = 0; i < buttons.length; i++) {
									text = $(buttons[i]).attr("text");
									begin = text.indexOf("<") + 1;
									end = text.indexOf(">");
									if (text.substring(begin, end) == value) {
										$(buttons[i]).remove();
									}
								}
								newstr = $("#user_select").find(
										"option:selected").text()
										+ "&lt;"
										+ $("#user_select").val()
										+ "&gt;;";

								$('#users_txt')
										.append(
												"<button ondblclick='$(this).remove();' onclick='return false;' style='background-color:transparent;border:0;' text="
														+ newstr
														+ ">"
														+ newstr
														+ "</button>");
							});
			$("#bound_btn").click(function() {
				if ($("#users_txt :button").length <= 0) {
					dialog = art.dialog({
						content : '请选择员工',
						lock : true,
						drag : false,
						resize : false,
						icon : 'warning'
					});
				} else {
					buttons = $("#users_txt :button");
					user_names = new Array();
					for ( var i = 0; i < buttons.length; i++) {
						text = $(buttons[i]).attr("text");
						begin = text.indexOf("<") + 1;
						end = text.indexOf(">");
						user_name = text.substring(begin, end);
						user_names.push(user_name);
					}
					$.ajax({
						url : basePath + "objectuser/bound_user.do",
						type : "post",
						data : {
							object_id : $("#object_id").val(),
							user_names : user_names.toString()
						},
						success : function(data) {
							dialog = art.dialog({
								content : data,
								lock : true,
								drag : false,
								resize : false,
								icon : 'succeed'
							});
						}
					});
				}
			});
		});
	</script>
</body>
</html>