<%@ page language="java"
	import="java.util.*,cn.info.platform.entity.Project"
	pageEncoding="UTF-8"%>
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
		<ul class="breadcrumb">
			<li><a href="index.jsp" target="_parent">主页</a> <span
				class="divider">/</span>
			</li>
			<li class="active">外呼</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">
				<div class="btn-toolbar" style="padding-bottom: 30px;">
					<div style="float: right;">
						<input type="text" placeholder='项目名称' id='search_txt'
							class="input-medium search-query">
						<button id='search_bnt' class="btn btn-primary">搜索</button>
					</div>
				</div>
				<div class="well">
					<table class="table table-striped" id='pro_info_tab'>
						<thead>
							<tr>
								<th>编号</th>
								<th>项目名称</th>
								<th>项目类型</th>
								<th>项目状态</th>
								<th>启动日期</th>
								<th>项目指派人</th>
								<th>项目备注</th>
								<th style="width: 207px;"></th>
							</tr>
						</thead>
						<tbody id="list-content">
						</tbody>
					</table>
				</div>
				<div id="myPaginator"></div>
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
						url : basePath + "outcall/find_all_project.do",
						type : "post",
						data : {
							search_txt : $('#search_txt').val()
						},
						success : function(data) {
							var dataPro = eval(data);
							totolP = parseInt(dataPro.length % 5 == 0 ? dataPro.length / 5
									: dataPro.length / 5 + 1);
							numP = dataPro.length / 5 < 1 ? dataPro.length % 5
									: 5;
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
									size = 5;
									if (type == 'first' && dataPro.length < 5) {
										size = dataPro.length;
									} else if (type == 'next' && page == totolP
											&& dataPro.length % 5 != 0) {
										size = dataPro.length % 5;
									} else if (type == 'next' && page == totolP
											&& dataPro.length % 5 == 0) {
										size = 5;
									} else if (page == totolP
											&& dataPro.length % 5 != 0) {
										size = dataPro.length % 5;
									} else if (page == totolP
											&& dataPro.length % 5 == 0) {
										size = 5;
									} else if (type == 'last'
											&& dataPro.length % 5 != 0) {
										size = dataPro.length % 5;
									} else if (type == 'last'
											&& dataPro.length % 5 == 0) {
										size = 5;
									}
									$('#list-content').html('');
									for ( var i = 0; i < size; i++) {
										$('#list-content')
												.append(
														'<tr><td>'
																+ dataPro[(page - 1)
																		* 5 + i].pro_id
																+ '</td><td>'
																+ dataPro[(page - 1)
																		* 5 + i].pro_name
																+ '</td><td>'
																+ dataPro[(page - 1)
																		* 5 + i].pro_type
																+ '</td><td>'
																+ dataPro[(page - 1)
																		* 5 + i].pro_state
																+ '</td><td>'
																+ dataPro[(page - 1)
																		* 5 + i].pro_date
																+ '</td><td>'
																+ dataPro[(page - 1)
																		* 5 + i].pro_zpr
																+ '</td><td>'
																+ dataPro[(page - 1)
																		* 5 + i].pro_remark
																+ '</td><td>'
																+ "<a href='outcall_topic.jsp?pro_id="
																+ dataPro[(page - 1)
																		* 5 + i].pro_id
																+ "' target='mainFrame'><button class='btn btn-info' type='button'><i class='icon-file'></i>&nbsp;相关题目</button></a>&nbsp;&nbsp;<a href='outcall_callobject.jsp?pro_id="
																+ dataPro[(page - 1)
																		* 5 + i].pro_id
																+ "' target='mainFrame'><button class='btn btn-primary' type='button'><i class='icon-circle-arrow-right'></i>&nbsp;开始外呼</button> </a></td></tr>");
									}
								}
							};
							bsize = dataPro.length < 5 ? dataPro.length : 5;
							$('#list-content').html('');
							for ( var i = 0; i < bsize; i++) {
								$('#list-content')
										.append(
												'<tr><td>'
														+ dataPro[i].pro_id
														+ '</td><td>'
														+ dataPro[i].pro_name
														+ '</td><td>'
														+ dataPro[i].pro_type
														+ '</td><td>'
														+ dataPro[i].pro_state
														+ '</td><td>'
														+ dataPro[i].pro_date
														+ '</td><td>'
														+ dataPro[i].pro_zpr
														+ '</td><td>'
														+ dataPro[i].pro_remark
														+ '</td><td>'
														+ "<a href='outcall_topic.jsp?pro_id="
														+ dataPro[i].pro_id
														+ "' target='mainFrame'><button class='btn btn-info' type='button'><i class='icon-file'></i>&nbsp;相关题目</button></a>&nbsp;&nbsp;<a href='outcall_callobject.jsp?pro_id="
														+ dataPro[i].pro_id
														+ "' target='mainFrame'><button class='btn btn-primary' type='button'><i class='icon-circle-arrow-right'></i>&nbsp;开始外呼</button></a></td></tr>");
							}
							$('#myPaginator').bootstrapPaginator(options);
						}
					});
			$('#search_bnt')
					.click(
							function() {
								$
										.ajax({
											url : basePath
													+ "outcall/find_all_project.do",
											type : "post",
											data : {
												search_txt : $('#search_txt')
														.val()
											},
											success : function(data) {
												var dataPro = eval(data);
												totolP = parseInt(dataPro.length % 5 == 0 ? dataPro.length / 5
														: dataPro.length / 5 + 1);
												numP = dataPro.length / 5 < 1 ? dataPro.length % 5
														: 5;
												var options = {
													currentPage : 1,
													totalPages : totolP,
													numberOfPages : numP,
													itemTexts : function(type,
															page, current) {
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
													onPageClicked : function(
															event,
															originalEvent,
															type, page) {
														size = 5;
														if (type == 'first'
																&& dataPro.length < 5) {
															size = dataPro.length;
														} else if (type == 'next'
																&& page == totolP
																&& dataPro.length % 5 != 0) {
															size = dataPro.length % 5;
														} else if (type == 'next'
																&& page == totolP
																&& dataPro.length % 5 == 0) {
															size = 5;
														} else if (page == totolP
																&& dataPro.length % 5 != 0) {
															size = dataPro.length % 5;
														} else if (page == totolP
																&& dataPro.length % 5 == 0) {
															size = 5;
														} else if (type == 'last'
																&& dataPro.length % 5 != 0) {
															size = dataPro.length % 5;
														} else if (type == 'last'
																&& dataPro.length % 5 == 0) {
															size = 5;
														}
														$('#list-content')
																.html('');
														for ( var i = 0; i < size; i++) {
															$('#list-content')
																	.append(
																			'<tr><td>'
																					+ dataPro[(page - 1)
																							* 5
																							+ i].pro_id
																					+ '</td><td>'
																					+ dataPro[(page - 1)
																							* 5
																							+ i].pro_name
																					+ '</td><td>'
																					+ dataPro[(page - 1)
																							* 5
																							+ i].pro_type
																					+ '</td><td>'
																					+ dataPro[(page - 1)
																							* 5
																							+ i].pro_state
																					+ '</td><td>'
																					+ dataPro[(page - 1)
																							* 5
																							+ i].pro_date
																					+ '</td><td>'
																					+ dataPro[(page - 1)
																							* 5
																							+ i].pro_zpr
																					+ '</td><td>'
																					+ dataPro[(page - 1)
																							* 5
																							+ i].pro_remark
																					+ '</td><td>'
																					+ "<a href='outcall_topic.jsp?pro_id="
																					+ dataPro[(page - 1)
																							* 5
																							+ i].pro_id
																					+ "' target='mainFrame'><button class='btn btn-info' type='button'><i class='icon-file'></i>&nbsp;相关题目</button></a>&nbsp;&nbsp;<a href='outcall_callobject.jsp?pro_id="
																					+ dataPro[(page - 1)
																							* 5
																							+ i].pro_id
																					+ "' target='mainFrame'><button class='btn btn-primary' type='button'><i class='icon-circle-arrow-right'></i>&nbsp;开始外呼</button> </a></td></tr>");
														}
													}
												};
												bsize = dataPro.length < 5 ? dataPro.length
														: 5;
												$('#list-content').html('');
												for ( var i = 0; i < bsize; i++) {
													$('#list-content')
															.append(
																	'<tr><td>'
																			+ dataPro[i].pro_id
																			+ '</td><td>'
																			+ dataPro[i].pro_name
																			+ '</td><td>'
																			+ dataPro[i].pro_type
																			+ '</td><td>'
																			+ dataPro[i].pro_state
																			+ '</td><td>'
																			+ dataPro[i].pro_date
																			+ '</td><td>'
																			+ dataPro[i].pro_zpr
																			+ '</td><td>'
																			+ dataPro[i].pro_remark
																			+ '</td><td>'
																			+ "<a href='outcall_topic.jsp?pro_id="
																			+ dataPro[i].pro_id
																			+ "' target='mainFrame'><button class='btn btn-info' type='button'><i class='icon-file'></i>&nbsp;相关题目</button></a>&nbsp;&nbsp;<a href='outcall_callobject.jsp?pro_id="
																			+ dataPro[i].pro_id
																			+ "' target='mainFrame'><button class='btn btn-primary' type='button'><i class='icon-circle-arrow-right'></i>&nbsp;开始外呼</button></a></td></tr>");
												}
												$('#myPaginator')
														.bootstrapPaginator(
																options);
											}
										});
							});
		});
	</script>
</body>
</html>