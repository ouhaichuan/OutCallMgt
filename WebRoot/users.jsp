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
<script type="text/javascript" src="js/bootstrap-paginator.min.js"></script>

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
			<h1 class="page-title">人员管理</h1>
		</div>

		<ul class="breadcrumb">
			<li><a href="index.jsp" target="_parent">主页</a> <span
				class="divider">/</span>
			</li>
			<li class="active">人员管理</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">
				<div class="btn-toolbar">
					<button class="btn btn-primary" id='adduser_btn'>
						<i class="icon-plus"></i> 添加人员
					</button>
					<div class="btn-group"></div>
				</div>
				<div class="well">
					<table class="table table-striped" id='user_info_tab'>
						<thead>
							<tr>
								<th>编号</th>
								<th>工号</th>
								<th>电话</th>
								<th>姓名</th>
								<th>角色</th>
								<th style="width: 26px;"></th>
							</tr>
						</thead>
						<tbody>
							<%
								List<User> list = (List<User>)request.getAttribute("users_list");
									for(User user:list){
							%>
							<tr>
								<td><%=user.getUserID()%></td>
								<td><%=user.getUserName()%></td>
								<td><%=user.getUser_phone()%></td>
								<td><%=user.getUser_xm()%></td>
								<td><%=user.getRole_name()%></td>
								<td><a
									href="user.jsp?edit_type=2&user_id=<%=user.getUserID()%>&user_name=<%=user.getUserName()%>&user_pass=<%=user.getPassWord()%>&role_id=<%=user.getRole_id()%>&user_remark=<%=user.getRemark()%>&user_phone=<%=user.getUser_phone()%>&user_xm=<%=user.getUser_xm()%>"><i
										class="icon-pencil"></i> </a> <a href="#myModal" role="button"
									data-toggle="modal"><i class="icon-remove"></i> </a>
								</td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
				<div id="myPaginator"></div>
				<script type='text/javascript'>
					var options = {
						currentPage : 4,
						totalPages : 10,
						numberOfPages : 5
					}
					$('#myPaginator').bootstrapPaginator(options);
				</script>

				<div class="modal small hide fade" id="myModal" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h3 id="myModalLabel">提示</h3>
					</div>
					<div class="modal-body">
						<p class="error-text">
							<i class="icon-warning-sign modal-icon"></i>你确定删除这个用户吗?
						</p>
					</div>
					<div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
						<button class="btn btn-danger" data-dismiss="modal" id='del_btn'>删除</button>
					</div>
					<input type="hidden" id="del_app_id">
				</div>
			</div>
		</div>
	</div>
	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		$(function() {
			var basePath = $('#basePathIn').val();
			$('#adduser_btn').click(function() {
				window.location.href = basePath + "user.jsp?edit_type=1";
			});
			$('#del_btn').click(
					function() {
						window.location.href = basePath
								+ "user/del_user.do?id="
								+ $('#del_app_id').val();
					});
			$("#user_info_tab,tr").click(function() {
				var user_id = $(this).children("td:eq(0)").text();
				if (user_id != "") {
					$('#del_app_id').val(user_id);
				}
			});
		});
	</script>
</body>
</html>