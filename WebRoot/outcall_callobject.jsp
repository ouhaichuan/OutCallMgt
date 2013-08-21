<%@ page language="java"
	import="java.util.*,cn.info.platform.entity.CallObject"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
	String pro_id = (String)(request.getAttribute("pro_id") != null ? request
	.getAttribute("pro_id") : "");
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
			<h1 class="page-title">外呼号码</h1>
		</div>

		<ul class="breadcrumb">
			<li><a href="index.jsp" target="_parent">主页</a> <span
				class="divider">/</span>
			</li>
			<li><a href="outcall/find_all_project.do" target="mainFrame">外呼</a>
				<span class="divider">/</span>
			</li>
			<li class="active">号码</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">
				<div class="well">
					<table class="table table-striped" id='obj_info_tab'>
						<thead>
							<tr>
								<th>编号</th>
								<th>号码</th>
								<th>所属项目</th>
								<th>号码状态</th>
								<th>外呼时间</th>
								<th>外呼时长(分)</th>
								<th style="width: 75px;"></th>
							</tr>
						</thead>
						<tbody>
							<%
								List<CallObject> list = (List<CallObject>)request.getAttribute("callobject_list");
															for(CallObject callobject:list){
							%>
							<tr>
								<td><%=callobject.getObject_id()%></td>
								<td><%=callobject.getObject_pnumber()%></td>
								<td><%=callobject.getPro_name()%></td>
								<td><%=callobject.getState_name()%></td>
								<td><%=callobject.getOut_time()%></td>
								<td><%=callobject.getOut_time_length()%></td>
								<td>
									<%
										if(callobject.getState_name().equals("初始状态")){
									%> <a
									href="outcall/outcall.do?pro_id=<%=pro_id%>&object_id=<%=callobject.getObject_id()%>&pnumber=<%=callobject.getObject_pnumber()%>"
									target="mainFrame"><button class="btn btn-primary"
											type="button">
											<i class="icon-bullhorn"></i>&nbsp;外呼
										</button> </a> <%
 	}else{
 %>
									<button class="btn active" type="button" rel="tooltip"
										title="号码状态不允许外呼">
										<i class="icon-bullhorn"></i>&nbsp;外呼
									</button> </i> <%
 	}
 %>
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
					};
					$('#myPaginator').bootstrapPaginator(options);
				</script>
			</div>
		</div>
	</div>
	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		$(function() {
		});
	</script>
</body>
</html>