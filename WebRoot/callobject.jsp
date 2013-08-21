<%@ page language="java"
	import="java.util.*,cn.info.platform.entity.CallObject"
	pageEncoding="UTF-8"%>
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
	String object_id = request.getParameter("object_id") != null
			? request.getParameter("object_id")
			: "";

	String object_pnumber = request.getParameter("object_pnumber") != null
			? request.getParameter("object_pnumber")
			: "";

	String object_remark = "";
	if (null != request.getParameter("object_remark")) {
		object_remark = new String(request
				.getParameter("object_remark").getBytes("iso-8859-1"),
				"utf-8");
	}
	String pro_id = "";
	if (null != request.getParameter("pro_id")) {
		pro_id = new String(request.getParameter("pro_id").getBytes(
				"iso-8859-1"), "utf-8");
	}
	String pro_name = "";
	if (null != request.getParameter("pro_name")) {
		pro_name = new String(request.getParameter("pro_name")
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
		<div class="header">
			<h1 class="page-title">编辑号码</h1>
		</div>
		<ul class="breadcrumb">
			<li><a href="index.jsp" target="_parent">主页</a> <span
				class="divider">/</span>
			</li>
			<li><a href="callobject/find_all_callobject.do">号码管理</a> <span
				class="divider">/</span></li>
			<li class="active">编辑</li>
		</ul>
		<%
			} else {
		%>
		<div class="header">
			<h1 class="page-title">添加号码</h1>
		</div>
		<ul class="breadcrumb">
			<li><a href="index.jsp" target="_parent">主页</a> <span
				class="divider">/</span>
			</li>
			<li><a href="callobject/find_all_callobject.do">号码管理</a> <span
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
							<form id="edit_info" action="callobject/save_obj.do"
								method="post">
								<input type="hidden" name="object_id" id='object_id'
									value="<%=object_id%>"> <label>号码</label> <input
									name="object_pnumber" id="object_pnumber"
									value="<%=object_pnumber%>" class="span3" /><label>所属项目</label><select
									name="project_select" id="project_select" style="height:30px"
									class="span3">
								</select> <input name="pro_id" id="pro_id" value="<%=pro_id%>"
									type="hidden" /> <label>备注</label>
								<textarea name="object_remark" rows="3" class="span3"><%=object_remark%></textarea>
							</form>
							<%
								} else {
							%>
							<form id="add_info" action="callobject/add_obj.do" method="post">
								<input type="hidden" name="object_id" id='object_id' value="0">
								<label>号码</label> <input name="object_pnumber"
									id="object_pnumber" class="span3" /><label>所属项目</label><select
									name="project_select" id="project_select" style="height:30px"
									class="span3">
								</select> <input name="pro_id" id="pro_id" type="hidden" /><label>备注</label>
								<textarea name="object_remark" rows="3" class="span3"></textarea>
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
							<i class="icon-warning-sign modal-icon"></i>你确定要删除这个号码吗?
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
			if ($('#object_pnumber').val() == "") {
				flag = 1;
			} else {
				flag = 2;
			}
			return flag;
		}
		$(function() {
			var basePath = $('#basePathIn').val();

			$.post(basePath + "outcall/getProList.do", function(data) {
				var dataPro = eval(data);
				var html = "";
				for ( var i = 0; i < dataPro.length; i++) {
					html += "<option value='"+dataPro[i].pro_id+"'>"
							+ dataPro[i].pro_name + "</option>";
				}
				$("#project_select").append(html);
				var pro_id = $('#pro_id').val();
				$("#project_select option[value='" + pro_id + "']").attr(
						"selected", "true");
				if ($('#pro_id').val() == "") {
					$('#pro_id').val(dataPro[0].pro_id);
				}
			});
			$("#project_select").change(function() {
				$('#pro_id').val($("#project_select").val());
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
			$('#del_btn').click(
					function() {
						window.location.href = basePath
								+ "callobject/del_obj.do?id="
								+ $('#object_id').val();
					});
			$('#object_pnumber').focus();
		});
	</script>
</body>
</html>