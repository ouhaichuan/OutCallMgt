<%@ page language="java"
	import="java.util.*,cn.info.platform.entity.Topic" pageEncoding="UTF-8"%>
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
	String num_id = request.getParameter("num_id") != null ? request
			.getParameter("num_id") : "";

	String pro_id = request.getParameter("pro_id") != null ? request
			.getParameter("pro_id") : "";

	String pro_name = "";
	if (null != request.getParameter("pro_name")) {
		pro_name = new String(request.getParameter("pro_name")
				.getBytes("iso-8859-1"), "utf-8");
	}

	String telnumber = "";
	if (null != request.getParameter("telnumber")) {
		telnumber = new String(request.getParameter("telnumber")
				.getBytes("iso-8859-1"), "utf-8");
	}

	String num_state = "";
	if (null != request.getParameter("num_state")) {
		num_state = new String(request.getParameter("num_state")
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
		<ul class="breadcrumb">
			<li><a href="index.jsp" target="_parent">主页</a> <span
				class="divider">/</span></li>
			<li><a href="projects.jsp">项目管理</a> <span class="divider">/</span>
			</li>
			<li><a
				href="salenumbers.jsp?pro_id=<%=pro_id%>&pro_name=<%=pro_name%>">销售号码管理</a>
				<span class="divider">/</span></li>
			<li class="active">编辑</li>
		</ul>
		<%
			} else {
		%>
		<ul class="breadcrumb">
			<li><a href="index.jsp" target="_parent">主页</a> <span
				class="divider">/</span></li>
			<li><a href="projects.jsp">项目管理</a> <span class="divider">/</span>
			</li>
			<li><a
				href="salenumbers.jsp?pro_id=<%=pro_id%>&pro_name=<%=pro_name%>">销售号码管理</a>
				<span class="divider">/</span>
			</li>
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
					<div id="myTabContent" class="tab-content">
						<div class="tab-pane active in" id="home">
							<%
								if (edit_type == 2) {
							%>
							<form id="edit_info" action="saletelnumber/save_num.do"
								method="post">
								<input type="hidden" name="num_id" id='num_id'
									value="<%=num_id%>"> <input id="pro_id" name="pro_id"
									value="<%=pro_id%>" type="hidden" /><label>所属项目</label><input
									name="pro_name" id='pro_name' value="<%=pro_name%>"
									readonly="readonly" class='span3' /><label>号码</label> <input
									name="telnumber" id='telnumber' value="<%=telnumber%>"
									class='span3' /> <label>号码状态</label><select
									name="state_select" id="state_select" style="height:30px"
									class="span3">
									<option value="未售">未售</option>
									<option value="已售">已售</option>
								</select> <input name="num_state" id="num_state" type="hidden"
									value="<%=num_state%>" />
							</form>
							<%
								} else {
							%>
							<form id="add_info" action="saletelnumber/add_num.do"
								method="post">
								<input type="hidden" name="num_id" id='num_id' value="0">
								<input name="pro_id" id="pro_id" type="hidden"
									value="<%=pro_id%>" /> <label>所属项目</label><input
									name="pro_name" id='pro_name' value="<%=pro_name%>"
									readonly="readonly" class='span3' /><label>号码</label> <input
									name="telnumber" id='telnumber' class='span3' /> <label>号码状态</label>
								<select name="state_select" id="state_select"
									style="height:30px" class="span3">
									<option value="未售">未售</option>
									<option value="已售">已售</option>
								</select> <input name="num_state" id="num_state" type="hidden" value="未售" />
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
			if ($('#telnumber').val() == "") {
				flag = 1;
			} else {
				flag = 2;
			}
			return flag;
		}
		$(function() {
			var basePath = $('#basePathIn').val();

			var num_state = $('#num_state').val();
			$("#state_select option[value='" + num_state + "']").attr(
					"selected", "true");
			$("#state_select").change(function() {
				$('#num_state').val($("#state_select").val());
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
								+ "saletelnumber/del_num.do?id="
								+ $('#num_id').val() + "&pro_id="
								+ $('#pro_id').val() + "&pro_name="
								+ $('#pro_name').val();
					});
			$('#telnumber').focus();
		});
	</script>
</body>
</html>