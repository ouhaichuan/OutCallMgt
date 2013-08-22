<%@ page language="java"
	import="java.util.*,cn.info.platform.entity.User" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//1，添加，2编辑
	int edit_type = Integer
			.valueOf(request.getParameter("edit_type") != null
					? request.getParameter("edit_type")
					: "0");
	String user_id = request.getParameter("user_id") != null ? request
			.getParameter("user_id") : "";
	String user_name = request.getParameter("user_name") != null
			? request.getParameter("user_name")
			: "";
	String user_pass = request.getParameter("user_pass") != null
			? request.getParameter("user_pass")
			: "";
	String role_id = request.getParameter("role_id") != null ? request
			.getParameter("role_id") : "";
	String remark = "";
	if (null != request.getParameter("user_remark")) {
		remark = new String(request.getParameter("user_remark")
				.getBytes("iso-8859-1"), "utf-8");
	}
	String user_phone = "";
	if (null != request.getParameter("user_phone")) {
		user_phone = new String(request.getParameter("user_phone")
				.getBytes("iso-8859-1"), "utf-8");
	}
	String user_xm = "";
	if (null != request.getParameter("user_xm")) {
		user_xm = new String(request.getParameter("user_xm").getBytes(
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
		<%
			if (edit_type == 2) {
		%>
		<ul class="breadcrumb">
			<li><a href="index.jsp" target="_parent">主页</a> <span
				class="divider">/</span>
			</li>
			<li><a href="users.jsp">人员管理</a> <span
				class="divider">/</span></li>
			<li class="active">编辑</li>
		</ul>
		<%
			} else {
		%>
		<ul class="breadcrumb">
			<li><a href="index.jsp" target="_parent">主页</a> <span
				class="divider">/</span>
			</li>
			<li><a href="users.jsp">人员管理</a> <span
				class="divider">/</span></li>
			<li class="active">添加</li>
		</ul>
		<%
			}
		%>

		<div class="container-fluid">
			<div class="row-fluid">
				<%
					if (edit_type == 2) {
				%>
				<div class="btn-toolbar">
					<button class="btn btn-primary" id="save_btn">
						<i class="icon-save"></i>保存
					</button>
					<a href="#myModal" data-toggle="modal" class="btn">删除</a>
					<div class="btn-group"></div>
				</div>
				<%
					} else {
				%>
				<div class="btn-toolbar">
					<button class="btn btn-primary" id="add_btn">
						<i class="icon-save"></i>添加
					</button>
					<div class="btn-group"></div>
				</div>
				<%
					}
				%>
				<div class="well">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#home" data-toggle="tab">详细信息</a>
						</li>
					</ul>
					<div id="myTabContent" class="tab-content">
						<div class="tab-pane active in" id="home">
							<%
								if (edit_type == 2) {
							%>
							<form id="edit_info" action="user/save_user.do" method="post">
								<input type="hidden" name="userID" id='user_id'
									value="<%=user_id%>"> <label>工号</label> <input
									name="userName" id="userName" value="<%=user_name%>"
									class="span3" /> <label>密码</label> <input name="passWord"
									id="passWord" value="<%=user_pass%>" type="password"
									class="span3" /> <label>确认密码</label> <input
									name="cfr_passWord" id="cfr_passWord" value="<%=user_pass%>"
									type="password" class="span3" /><label>电话</label> <input
									name="user_phone" id="user_phone" value="<%=user_phone%>"
									class="span3" /><label>姓名</label> <input name="user_xm"
									id="user_xm" value="<%=user_xm%>" class="span3" /><label>角色</label>
								<select name="role_select" id="role_select" class="span3">
									<option value="1">管理员</option>
									<option value="2">普通用户</option>
								</select> <input type="hidden" name="role_id" id='role_id'
									value="<%=role_id%>"> <label>备注</label>
								<textarea name="remark" rows="3" class="span3"><%=remark%></textarea>
							</form>
							<%
								} else {
							%>
							<form id="add_info" action="user/add_user.do" method="post">
								<input type="hidden" name="userID" id='user_id' value='0' /> <label>工号</label>
								<input name="userName" id="userName" class="span3" /> <label>密码</label>
								<input name="passWord" id="passWord" type="password"
									class="span3" /> <label>确认密码</label> <input
									name="cfr_passWord" id="cfr_passWord" type="password"
									class="span3" /><label>电话</label> <input name="user_phone"
									id="user_phone" class="span3" /><label>姓名</label> <input
									name="user_xm" id="user_xm" class="span3" /><label>角色</label>
								<select name="role_select" id="role_select" style="height:30px"
									class="span3">
									<option value="1">管理员</option>
									<option value="2">普通用户</option>
								</select> <input type="hidden" name="role_id" id='role_id' value="1">
								<label>备注</label>
								<textarea name="remark" rows="3" class="span3"></textarea>
							</form>
							<%
								}
							%>
						</div>
					</div>
				</div>

				<div class="modal small hide fade" id="myModal" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h3 id="myModalLabel">提示</h3>
					</div>
					<div class="modal-body">
						<p class="error-text">
							<i class="icon-warning-sign modal-icon"></i>你确定要删除这个用户吗?
						</p>
					</div>
					<div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
						<button class="btn btn-danger" data-dismiss="modal" id='del_btn'>删除</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<input type="hidden" id='etype' value="<%=edit_type%>">
	<input type="hidden" id='oldUserName' value="<%=user_name%>">

	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		String.prototype.Trim = function() {
			return this.replace(/(^\s*)|(\s*$)/g, "");
		};
		function validate() {
			var flag = 0;
			if ($('#userName').val().Trim() == ""
					|| $('#passWord').val().Trim() == ""
					|| $('#cfr_passWord').val().Trim() == ""
					|| $('#user_phone').val().Trim() == ""
					|| $('#user_xm').val().Trim() == "") {
				flag = 1;
			} else if ($('#passWord').val().Trim() != $('#cfr_passWord').val()
					.Trim()) {
				flag = 2;
			} else {
				flag = 3;
			}
			return flag;
		}
		$(function() {
			var basePath = $('#basePathIn').val();
			var role_id = $('#role_id').val();
			if (role_id == '1') {
				$("#role_select option[value='1']").attr("selected", "true");
			} else if (role_id == '2') {
				$("#role_select option[value='2']").attr("selected", "true");
			} else {
				$("#role_select option[value='1']").attr("selected", "true");
			}
			$("#role_select").change(function() {
				$('#role_id').val($("#role_select").val());
			});
			$('#save_btn').click(function() {
				result = validate();
				if (result == 3) {//验证完成
					$('#edit_info').submit();
				} else {
					if (result == 1) {
						result = '有空值';
					} else if (result == 2) {
						result = '两次密码输入不一致';
					} else if (result == 4) {
						result = '重复工号';
					} else {
						result = '异常';
					}
					dialog = art.dialog({
						content : result,
						lock : true,
						drag : false,
						resize : false,
						icon : 'warning'
					});
				}
			});
			$('#add_btn').click(function() {
				result = validate();
				if (result == 3) {//验证完成
					$('#add_info').submit();
				} else {
					if (result == 1) {
						result = '有空值';
					} else if (result == 2) {
						result = '两次密码输入不一致';
					} else if (result == 4) {
						result = '重复工号';
					} else {
						result = '异常';
					}
					dialog = art.dialog({
						content : result,
						lock : true,
						drag : false,
						resize : false,
						icon : 'warning'
					});
				}
			});
			$('#del_btn').click(
					function() {
						window.location.href = basePath
								+ "user/del_user.do?id=" + $('#user_id').val();
					});
			$('#userName').focus();
			$('#userName').blur(
					function() {
						if ($('#etype').val() == 1
								|| ($('#etype').val() == 2 && $('#oldUserName')
										.val() != $('#userName').val())) {
							$.ajax({
								url : basePath + "user/validate_user.do",
								type : "post",
								data : {
									user_name : $('#userName').val()
								},
								dataType : "json",
								success : function(data) {
									if (data + '' == 'false') {
										dialog = art.dialog({
											content : '重复工号',
											lock : true,
											drag : false,
											resize : false,
											icon : 'warning'
										});
										$('#userName').val('');
									}
								}
							});
						}
					});
		});
	</script>
</body>
</html>