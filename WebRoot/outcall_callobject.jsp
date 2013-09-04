<%@ page language="java"
	import="java.util.*,cn.info.platform.entity.CallObject"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	int pro_id = Integer.valueOf((String) request
			.getParameter("pro_id"));
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
	<input id='pro_id' type="hidden" value="<%=pro_id%>">
	<div>
		<ul class="breadcrumb">
			<li><a href="index.jsp" target="_parent">主页</a> <span
				class="divider">/</span>
			</li>
			<li><a href="outcall_start.jsp" target="mainFrame">外呼</a> <span
				class="divider">/</span>
			</li>
			<li class="active">号码</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">
				<div class="btn-toolbar" style="padding-bottom: 30px;">
					<div style="float: right;">
						<input type="text" placeholder='外呼号码'
							class="input-medium search-query">
						<button id='search_bnt' class="btn btn-primary">搜索</button>
					</div>
				</div>
				<div class="well">
					<table class="table table-striped" id='obj_info_tab'>
						<thead>
							<tr>
								<th>编号</th>
								<th>号码</th>
								<th>所属项目</th>
								<th>号码状态</th>
								<th>外呼时间</th>
								<th>外呼人</th>
								<th style="width: 75px;"></th>
							</tr>
						</thead>
						<tbody id="list-content">
						</tbody>
					</table>
				</div>
				<div id="myPaginator"></div>
				<div class="alert-info">
					<span id="content"></span>
				</div>
			</div>
		</div>
	</div>
	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		$(function() {
			var basePath = $('#basePathIn').val();

			$
					.ajax({
						url : basePath + "outcall/findCallObjectByProId.do",
						type : "post",
						data : {
							pro_id : $("#pro_id").val()
						},
						success : function(data) {
							var dataObject = eval(data);
							$('#content').text('号码总数：' + dataObject.length);
							totolP = parseInt(dataObject.length % 7 == 0 ? dataObject.length / 7
									: dataObject.length / 7 + 1);
							numP = dataObject.length / 7 < 1 ? dataObject.length % 7
									: 7;
							var options = {
								currentPage : 1,
								totalPages : totolP,
								numberOfPages : numP,
								itemTexts : function(type, page, current) {
									switch (type) {
									case "first":
										return "首页";
									case "prev":
										return "上一页";
									case "next":
										return "下一页";
									case "last":
										return "尾页";
									case "page":
										return page;
									}
								},
								onPageClicked : function(event, originalEvent,
										type, page) {
									size = 7;
									if (type == 'first'
											&& dataObject.length < 7) {
										size = dataObject.length;
									} else if (type == 'next' && page == totolP
											&& dataObject.length % 7 != 0) {
										size = dataObject.length % 7;
									} else if (type == 'next' && page == totolP
											&& dataObject.length % 7 == 0) {
										size = 7;
									} else if (page == totolP
											&& dataObject.length % 7 != 0) {
										size = dataObject.length % 7;
									} else if (page == totolP
											&& dataObject.length % 7 == 0) {
										size = 7;
									} else if (type == 'last'
											&& dataObject.length % 7 != 0) {
										size = dataObject.length % 7;
									} else if (type == 'last'
											&& dataObject.length % 7 == 0) {
										size = 7;
									}
									$('#list-content').html('');
									for ( var i = 0; i < size; i++) {
										var td_str = '<tr><td>'
												+ dataObject[(page - 1) * 7 + i].object_id
												+ '</td><td>'
												+ dataObject[(page - 1) * 7 + i].object_pnumber
												+ '</td><td>'
												+ dataObject[(page - 1) * 7 + i].pro_name
												+ '</td><td>'
												+ dataObject[(page - 1) * 7 + i].state_name
												+ '</td><td>'
												+ dataObject[(page - 1) * 7 + i].out_time
												+ '</td><td>'
												+ dataObject[(page - 1) * 7 + i].call_user_name
												+ '</td>';
										if (dataObject[(page - 1) * 7 + i].state_name == '初始状态') {
											td_str += "<td><a href='outcall/outcall.do?pro_id="
													+ dataObject[(page - 1) * 7
															+ i].pro_id
													+ "&object_id="
													+ dataObject[(page - 1) * 7
															+ i].object_id
													+ "&pnumber="
													+ dataObject[(page - 1) * 7
															+ i].object_pnumber
													+ "' target='mainFrame'><button class='btn btn-primary' type='button'><i class='icon-bullhorn'></i>&nbsp;外呼</button></a></td></tr>";
										} else {
											td_str += "<td><button class='btn active' type='button' rel='tooltip' title='号码状态不允许外呼'> <i class='icon-bullhorn'></i>&nbsp;外呼 </button> </i></td></tr>";
										}
										$('#list-content').append(td_str);
									}
								}
							};
							bsize = dataObject.length < 7 ? dataObject.length
									: 7;
							$('#list-content').html('');
							for ( var i = 0; i < bsize; i++) {
								var td_str = '<tr><td>'
										+ dataObject[i].object_id + '</td><td>'
										+ dataObject[i].object_pnumber
										+ '</td><td>' + dataObject[i].pro_name
										+ '</td><td>'
										+ dataObject[i].state_name
										+ '</td><td>' + dataObject[i].out_time
										+ '</td><td>' + dataObject[i].call_user_name
										+ '</td>';
								if (dataObject[i].state_name == '初始状态') {
									td_str += "<td><a href='outcall/outcall.do?pro_id="
											+ dataObject[i].pro_id
											+ "&object_id="
											+ dataObject[i].object_id
											+ "&pnumber="
											+ dataObject[i].object_pnumber
											+ "' target='mainFrame'><button class='btn btn-primary' type='button'><i class='icon-bullhorn'></i>&nbsp;外呼</button></a></td></tr>";
								} else {
									td_str += "<td><button class='btn active' type='button' rel='tooltip' title='号码状态不允许外呼'> <i class='icon-bullhorn'></i>&nbsp;外呼 </button> </i></td></tr>";
								}
								$('#list-content').append(td_str);
							}
							$('#myPaginator').bootstrapPaginator(options);
						}
					});
		});
	</script>
</body>
</html>