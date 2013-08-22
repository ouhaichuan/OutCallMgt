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
	String pro_id = request.getParameter("pro_id") != null ? request
			.getParameter("pro_id") : "";

	String pro_name = "";
	if (null != request.getParameter("pro_name")) {
		pro_name = new String(request.getParameter("pro_name")
				.getBytes("iso-8859-1"), "utf-8");
	}

	String pro_type = "";
	if (null != request.getParameter("pro_type")) {
		pro_type = new String(request.getParameter("pro_type")
				.getBytes("iso-8859-1"), "utf-8");
	}

	String pro_state = "";
	if (null != request.getParameter("pro_state")) {
		pro_state = new String(request.getParameter("pro_state")
				.getBytes("iso-8859-1"), "utf-8");
	}

	String pro_date = request.getParameter("pro_date") != null
			? request.getParameter("pro_date")
			: "";

	String pro_remark = "";
	if (null != request.getParameter("pro_remark")) {
		pro_remark = new String(request.getParameter("pro_remark")
				.getBytes("iso-8859-1"), "utf-8");
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
<script src="datePicker/WdatePicker.js"></script>

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
			<li><a href="projects.jsp">项目管理</a> <span
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
			<li><a href="projects.jsp">项目管理</a> <span
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
							<form id="edit_info" action="project/save_pro.do" method="post">
								<input type="hidden" name="pro_id" id='pro_id'
									value="<%=pro_id%>"> <label>项目名称</label> <input
									name="pro_name" id="pro_name" value="<%=pro_name%>"
									class="span3" /> <label>项目类型</label> <select
									name="type_select" id="type_select" style="height:30px"
									class="span3">
									<option value="普通">普通</option>
									<option value="销售">销售</option>
								</select> <input type="hidden" name="pro_type" id='pro_type'
									value="<%=pro_type%>"> <label>项目状态</label> <select
									name="state_select" id="state_select" style="height:30px"
									class="span3">
									<option value="有效">有效</option>
									<option value="无效">无效</option>
								</select> <input type="hidden" name="pro_state" id='pro_state'
									value="<%=pro_state%>"> <label>启动日期</label> <input
									name="pro_date" id="pro_date" value="<%=pro_date%>"
									class="span3" onclick="WdatePicker()" /> <label>备注</label>
								<textarea name="pro_remark" rows="3" class="span3"><%=pro_remark%></textarea>
							</form>
							<%
								} else {
							%>
							<form id="add_info" action="project/add_pro.do" method="post">
								<input type="hidden" name="pro_id" id='pro_id' value="0">
								<label>项目名称</label> <input name="pro_name" id="pro_name"
									class="span3" /> <label>项目类型</label> <select
									name="type_select" id="type_select" style="height:30px"
									class="span3">
									<option value="普通">普通</option>
									<option value="销售">销售</option>
								</select> <input type="hidden" name="pro_type" id='pro_type' value="普通">
								<label>项目状态</label> <select name="state_select"
									id="state_select" style="height:30px" class="span3">
									<option value="有效">有效</option>
									<option value="无效">无效</option>
								</select> <input type="hidden" name="pro_state" id='pro_state' value="有效">
								<label>启动日期</label><input name="pro_date" id="pro_date"
									class="span3" onclick="WdatePicker()" /><label>备注</label>
								<textarea name="pro_remark" rows="3" class="span3"></textarea>
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
							<i class="icon-warning-sign modal-icon"></i>你确定要删除这个项目吗?
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

	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		function validate() {
			var flag = 0;
			if ($('#pro_name').val() == "" || $('#pro_type').val() == ""
					|| $('#pro_state').val() == ""
					|| $('#pro_date').val() == ""
					|| $('#pro_remark').val() == "") {
				flag = 1;
			} else {
				flag = 2;
			}
			return flag;
		}
		$(function() {
			var basePath = $('#basePathIn').val();
			var pro_type = $('#pro_type').val();
			$("#type_select option[value='" + pro_type + "']").attr("selected",
					"true");
			$("#type_select").change(function() {
				$('#pro_type').val($("#type_select").val());
			});

			var pro_state = $('#pro_state').val();
			$("#state_select option[value='" + pro_state + "']").attr(
					"selected", "true");
			$("#state_select").change(function() {
				$('#pro_state').val($("#state_select").val());
			});

			$('#save_btn').click(function() {
				result = validate();
				if (result == 2) {//验证完成
					$('#edit_info').submit();
				} else {
					if (result == 1) {
						result = '有空值';
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
				if (result == 2) {//验证完成
					$('#add_info').submit();
				} else {
					if (result == 1) {
						result = '有空值';
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
			$('#del_btn')
					.click(
							function() {
								window.location.href = basePath
										+ "project/del_pro.do?id="
										+ $('#pro_id').val();
							});
			$('#pro_name').focus();
		});
	</script>
</body>
</html>