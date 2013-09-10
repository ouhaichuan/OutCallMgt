<%@ page language="java"
	import="java.util.*,cn.info.platform.entity.Project,cn.info.platform.entity.User"
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
		<ul class="breadcrumb">
			<li><a href="index.jsp" target="_parent">主页</a> <span
				class="divider">/</span></li>
			<li class="active">统计</li>
		</ul>
		<%
			if ("管理员".equals(((User) request.getSession().getAttribute("user"))
					.getRole_name())) {
		%>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="btn-toolbar">
					<button class="btn btn-info" id='export_btn'>
						<i class="icon-arrow-up"></i> 导出数据
					</button>
					<div style="float: right;">
						<input id="start_date" class="input-medium search-query"
							placeholder='开始日期（默认今天）' onclick="WdatePicker()" /><input
							id="end_date" placeholder='结束日期（默认今天）'
							class="input-medium search-query" onclick="WdatePicker()" />
						<button id='search_btn' class="btn btn-primary">筛选</button>
					</div>
					<div class="btn-group"></div>
				</div>
				<div class="well">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#home" data-toggle="tab">项目数据</a>
						</li>
						<li><a href="#profile" data-toggle="tab">员工数据</a></li>
					</ul>
					<div id="myTabContent" class="tab-content">
						<div class="tab-pane active in" id="home">
							<form id="tab">
								<table class="table table-striped" id='pro_info_tab'>
									<thead>
										<tr>
											<th>启动日期</th>
											<th style="width: 360px;">项目名称</th>
											<th>项目类型</th>
											<th>外呼总量</th>
											<th>成功量</th>
											<th>未成功量</th>
										</tr>
									</thead>
									<tbody id="list-content">
									</tbody>
								</table>
							</form>
							<div id="myPaginator"></div>
						</div>
						<div class="tab-pane fade" id="profile">
							<form id="tab2">
								<table class="table table-striped" id='pro_info_tab_person'>
									<thead>
										<tr>
											<th>员工姓名</th>
											<th>外呼总次数</th>
											<th>外呼完成数</th>
											<th>外呼未完成数</th>
											<th>外呼时长（秒）</th>
										</tr>
									</thead>
									<tbody id="list-content2">
									</tbody>
								</table>
							</form>
							<div id="myPaginator2"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%
			} else {
		%>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="well">
					<ul class="nav nav-tabs">
						<li><a href="#profile" data-toggle="tab">员工数据</a></li>
					</ul>
					<div id="myTabContent" class="tab-content">
						<div class="tab-pane active in" id="profile">
							<form id="tab2">
								<table class="table table-striped" id='pro_info_tab_person'>
									<thead>
										<tr>
											<th>员工姓名</th>
											<th>外呼总次数</th>
											<th>外呼完成数</th>
											<th>外呼未完成数</th>
											<th>外呼时长（秒）</th>
										</tr>
									</thead>
									<tbody id="list-content2">
									</tbody>
								</table>
							</form>
							<div id="myPaginator2"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%
			}
		%>
	</div>
	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		Date.prototype.Format = function(fmt) { //author: meizz   
			var o = {
				"M+" : this.getMonth() + 1, //月份   
				"d+" : this.getDate(), //日   
				"h+" : this.getHours(), //小时   
				"m+" : this.getMinutes(), //分   
				"s+" : this.getSeconds(), //秒   
				"q+" : Math.floor((this.getMonth() + 3) / 3), //季度   
				"S" : this.getMilliseconds()
			//毫秒   
			};
			if (/(y+)/.test(fmt))
				fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
						.substr(4 - RegExp.$1.length));
			for ( var k in o)
				if (new RegExp("(" + k + ")").test(fmt))
					fmt = fmt.replace(RegExp.$1,
							(RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k])
									.substr(("" + o[k]).length)));
			return fmt;
		};
		$(function() {
			var basePath = $('#basePathIn').val();

			$
					.ajax({
						url : basePath + "project/staticsDataPro.do",
						type : "post",
						data : {
							start_date : new Date().Format("yyyy-MM-dd"),
							end_date : new Date().Format("yyyy-MM-dd")
						},
						success : function(data) {
							var dataPro = eval(data);
							totolP = parseInt(dataPro.length % 8 == 0 ? dataPro.length / 8
									: dataPro.length / 8 + 1);
							numP = dataPro.length / 8 < 1 ? dataPro.length % 8
									: 8;
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
									size = 8;
									if (type == 'first' && dataPro.length < 8) {
										size = dataPro.length;
									} else if (type == 'next' && page == totolP
											&& dataPro.length % 8 != 0) {
										size = dataPro.length % 8;
									} else if (type == 'next' && page == totolP
											&& dataPro.length % 8 == 0) {
										size = 8;
									} else if (page == totolP
											&& dataPro.length % 8 != 0) {
										size = dataPro.length % 8;
									} else if (page == totolP
											&& dataPro.length % 8 == 0) {
										size = 8;
									} else if (type == 'last'
											&& dataPro.length % 8 != 0) {
										size = dataPro.length % 8;
									} else if (type == 'last'
											&& dataPro.length % 8 == 0) {
										size = 8;
									}
									$('#list-content').html('');
									for ( var i = 0; i < size; i++) {
										$('#list-content')
												.append(
														'<tr><td>'
																+ dataPro[(page - 1)
																		* 8 + i].pro_date
																+ '</td><td>'
																+ dataPro[(page - 1)
																		* 8 + i].pro_name
																+ '</td><td>'
																+ dataPro[(page - 1)
																		* 8 + i].pro_type
																+ "</td><td><a href='statics4object.jsp?state=1&pro_id="
																+ dataPro[i].pro_id
																+ "&pro_name="
																+ dataPro[i].pro_name
																+ "'>"
																+ dataPro[(page - 1)
																		* 8 + i].calltotal
																+ "</a></td><td><a href='statics4object.jsp?state=2&pro_id="
																+ dataPro[i].pro_id
																+ "&pro_name="
																+ dataPro[i].pro_name
																+ "'>"
																+ dataPro[(page - 1)
																		* 8 + i].callcomplete
																+ "</a></td><td><a href='statics4object.jsp?state=3&pro_id="
																+ dataPro[i].pro_id
																+ "&pro_name="
																+ dataPro[i].pro_name
																+ "'>"
																+ dataPro[(page - 1)
																		* 8 + i].callnotcomplete
																+ '</a></td></tr>');
									}
								}
							};
							bsize = dataPro.length < 8 ? dataPro.length : 8;
							$('#list-content').html('');
							for ( var i = 0; i < bsize; i++) {
								$('#list-content')
										.append(
												'<tr><td>'
														+ dataPro[i].pro_date
														+ '</td><td>'
														+ dataPro[i].pro_name
														+ '</td><td>'
														+ dataPro[i].pro_type
														+ "</td><td><a href='statics4object.jsp?state=1&pro_id="
														+ dataPro[i].pro_id
														+ "&pro_name="
														+ dataPro[i].pro_name
														+ "'>"
														+ dataPro[i].calltotal
														+ "</a></td><td><a href='statics4object.jsp?state=2&pro_id="
														+ dataPro[i].pro_id
														+ "&pro_name="
														+ dataPro[i].pro_name
														+ "'>"
														+ dataPro[i].callcomplete
														+ "</a></td><td><a href='statics4object.jsp?state=3&pro_id="
														+ dataPro[i].pro_id
														+ "&pro_name="
														+ dataPro[i].pro_name
														+ "'>"
														+ dataPro[i].callnotcomplete
														+ '</a></td></tr>');
							}
							$('#myPaginator').bootstrapPaginator(options);
						}
					});

			$
					.ajax({
						url : basePath + "user/staticsDataUser.do",
						type : "post",
						data : {
							start_date : new Date().Format("yyyy-MM-dd"),
							end_date : new Date().Format("yyyy-MM-dd")
						},
						success : function(data) {
							var dataUser = eval(data);
							totolP = parseInt(dataUser.length % 8 == 0 ? dataUser.length / 8
									: dataUser.length / 8 + 1);
							numP = dataUser.length / 8 < 1 ? dataUser.length % 8
									: 8;
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
									size = 8;
									if (type == 'first' && dataUser.length < 8) {
										size = dataUser.length;
									} else if (type == 'next' && page == totolP
											&& dataUser.length % 8 != 0) {
										size = dataUser.length % 8;
									} else if (type == 'next' && page == totolP
											&& dataUser.length % 8 == 0) {
										size = 8;
									} else if (page == totolP
											&& dataUser.length % 8 != 0) {
										size = dataUser.length % 8;
									} else if (page == totolP
											&& dataUser.length % 8 == 0) {
										size = 8;
									} else if (type == 'last'
											&& dataUser.length % 8 != 0) {
										size = dataUser.length % 8;
									} else if (type == 'last'
											&& dataUser.length % 8 == 0) {
										size = 8;
									}
									$('#list-content2').html('');
									for ( var i = 0; i < size; i++) {
										$('#list-content2')
												.append(
														'<tr><td>'
																+ dataUser[(page - 1)
																		* 8 + i].user_xm
																+ "</td><td><a href='statics4userdetail.jsp?state=1&user_name="
																+ dataUser[(page - 1)
																		* 8 + i].userName
																+ "'>"
																+ dataUser[(page - 1)
																		* 8 + i].outcall_times
																+ "</a></td><td><a href='statics4userdetail.jsp?state=2&user_name="
																+ dataUser[(page - 1)
																		* 8 + i].userName
																+ "'>"
																+ dataUser[(page - 1)
																		* 8 + i].outcall_complete
																+ "</a></td><td><a href='statics4userdetail.jsp?state=3&user_name="
																+ dataUser[(page - 1)
																		* 8 + i].userName
																+ "'>"
																+ dataUser[(page - 1)
																		* 8 + i].outcall_notcomplete
																+ '</a></td><td>'
																+ dataUser[(page - 1)
																		* 8 + i].outcall_timelength
																+ '</td></tr>');
									}
								}
							};
							bsize = dataUser.length < 8 ? dataUser.length : 8;
							$('#list-content2').html('');
							for ( var i = 0; i < bsize; i++) {
								$('#list-content2')
										.append(
												'<tr><td>'
														+ dataUser[i].user_xm
														+ "</td><td><a href='statics4userdetail.jsp?state=1&user_name="
														+ dataUser[i].userName
														+ "'>"
														+ dataUser[i].outcall_times
														+ "</a></td><td><a href='statics4userdetail.jsp?state=2&user_name="
														+ dataUser[i].userName
														+ "'>"
														+ dataUser[i].outcall_complete
														+ "</a></td><td><a href='statics4userdetail.jsp?state=3&user_name="
														+ dataUser[i].userName
														+ "'>"
														+ dataUser[i].outcall_notcomplete
														+ '</a></td><td>'
														+ dataUser[i].outcall_timelength
														+ '</td></tr>');
							}
							$('#myPaginator2').bootstrapPaginator(options);
						}
					});
			$('#search_btn')
					.click(
							function() {
								$
										.ajax({
											url : basePath
													+ "project/staticsDataPro.do",
											type : "post",
											data : {
												start_date : $('#start_date')
														.val(),
												end_date : $('#end_date').val()
											},
											success : function(data) {
												var dataPro = eval(data);
												totolP = parseInt(dataPro.length % 8 == 0 ? dataPro.length / 8
														: dataPro.length / 8 + 1);
												numP = dataPro.length / 8 < 1 ? dataPro.length % 8
														: 8;
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
														size = 8;
														if (type == 'first'
																&& dataPro.length < 8) {
															size = dataPro.length;
														} else if (type == 'next'
																&& page == totolP
																&& dataPro.length % 8 != 0) {
															size = dataPro.length % 8;
														} else if (type == 'next'
																&& page == totolP
																&& dataPro.length % 8 == 0) {
															size = 8;
														} else if (page == totolP
																&& dataPro.length % 8 != 0) {
															size = dataPro.length % 8;
														} else if (page == totolP
																&& dataPro.length % 8 == 0) {
															size = 8;
														} else if (type == 'last'
																&& dataPro.length % 8 != 0) {
															size = dataPro.length % 8;
														} else if (type == 'last'
																&& dataPro.length % 8 == 0) {
															size = 8;
														}
														$('#list-content')
																.html('');
														for ( var i = 0; i < size; i++) {
															$('#list-content')
																	.append(
																			'<tr><td>'
																					+ dataPro[(page - 1)
																							* 8
																							+ i].pro_date
																					+ '</td><td>'
																					+ dataPro[(page - 1)
																							* 8
																							+ i].pro_name
																					+ '</td><td>'
																					+ dataPro[(page - 1)
																							* 8
																							+ i].pro_type
																					+ "</td><td><a href='statics4object.jsp?state=1&pro_id="
																					+ dataPro[i].pro_id
																					+ "&pro_name="
																					+ dataPro[i].pro_name
																					+ "'>"
																					+ dataPro[(page - 1)
																							* 8
																							+ i].calltotal
																					+ "</a></td><td><a href='statics4object.jsp?state=2&pro_id="
																					+ dataPro[i].pro_id
																					+ "&pro_name="
																					+ dataPro[i].pro_name
																					+ "'>"
																					+ dataPro[(page - 1)
																							* 8
																							+ i].callcomplete
																					+ "</a></td><td><a href='statics4object.jsp?state=3&pro_id="
																					+ dataPro[i].pro_id
																					+ "&pro_name="
																					+ dataPro[i].pro_name
																					+ "'>"
																					+ dataPro[(page - 1)
																							* 8
																							+ i].callnotcomplete
																					+ '</a></td></tr>');
														}
													}
												};
												bsize = dataPro.length < 8 ? dataPro.length
														: 8;
												$('#list-content').html('');
												for ( var i = 0; i < bsize; i++) {
													$('#list-content')
															.append(
																	'<tr><td>'
																			+ dataPro[i].pro_date
																			+ '</td><td>'
																			+ dataPro[i].pro_name
																			+ '</td><td>'
																			+ dataPro[i].pro_type
																			+ "</td><td><a href='statics4object.jsp?state=1&pro_id="
																			+ dataPro[i].pro_id
																			+ "&pro_name="
																			+ dataPro[i].pro_name
																			+ "'>"
																			+ dataPro[i].calltotal
																			+ "</a></td><td><a href='statics4object.jsp?state=2&pro_id="
																			+ dataPro[i].pro_id
																			+ "&pro_name="
																			+ dataPro[i].pro_name
																			+ "'>"
																			+ dataPro[i].callcomplete
																			+ "</a></td><td><a href='statics4object.jsp?state=3&pro_id="
																			+ dataPro[i].pro_id
																			+ "&pro_name="
																			+ dataPro[i].pro_name
																			+ "'>"
																			+ dataPro[i].callnotcomplete
																			+ '</a></td></tr>');
												}
												$('#myPaginator')
														.bootstrapPaginator(
																options);
											}
										});
								$
										.ajax({
											url : basePath
													+ "user/staticsDataUser.do",
											type : "post",
											data : {
												start_date : $('#start_date')
														.val(),
												end_date : $('#end_date').val()
											},
											success : function(data) {
												var dataUser = eval(data);
												totolP = parseInt(dataUser.length % 8 == 0 ? dataUser.length / 8
														: dataUser.length / 8 + 1);
												numP = dataUser.length / 8 < 1 ? dataUser.length % 8
														: 8;
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
														size = 8;
														if (type == 'first'
																&& dataUser.length < 8) {
															size = dataUser.length;
														} else if (type == 'next'
																&& page == totolP
																&& dataUser.length % 8 != 0) {
															size = dataUser.length % 8;
														} else if (type == 'next'
																&& page == totolP
																&& dataUser.length % 8 == 0) {
															size = 8;
														} else if (page == totolP
																&& dataUser.length % 8 != 0) {
															size = dataUser.length % 8;
														} else if (page == totolP
																&& dataUser.length % 8 == 0) {
															size = 8;
														} else if (type == 'last'
																&& dataUser.length % 8 != 0) {
															size = dataUser.length % 8;
														} else if (type == 'last'
																&& dataUser.length % 8 == 0) {
															size = 8;
														}
														$('#list-content2')
																.html('');
														for ( var i = 0; i < size; i++) {
															$('#list-content2')
																	.append(
																			'<tr><td>'
																					+ dataUser[(page - 1)
																							* 8
																							+ i].user_xm
																					+ "</td><td><a href='statics4userdetail.jsp?state=1&user_name="
																					+ dataUser[(page - 1)
																							* 8
																							+ i].userName
																					+ "'>"
																					+ dataUser[(page - 1)
																							* 8
																							+ i].outcall_times
																					+ "</a></td><td><a href='statics4userdetail.jsp?state=2&user_name="
																					+ dataUser[(page - 1)
																							* 8
																							+ i].userName
																					+ "'>"
																					+ dataUser[(page - 1)
																							* 8
																							+ i].outcall_complete
																					+ "</a></td><td><a href='statics4userdetail.jsp?state=3&user_name="
																					+ dataUser[(page - 1)
																							* 8
																							+ i].userName
																					+ "'>"
																					+ dataUser[(page - 1)
																							* 8
																							+ i].outcall_notcomplete
																					+ '</a></td><td>'
																					+ dataUser[(page - 1)
																							* 8
																							+ i].outcall_timelength
																					+ '</td></tr>');
														}
													}
												};
												bsize = dataUser.length < 8 ? dataUser.length
														: 8;
												$('#list-content2').html('');
												for ( var i = 0; i < bsize; i++) {
													$('#list-content2')
															.append(
																	'<tr><td>'
																			+ dataUser[i].user_xm
																			+ "</td><td><a href='statics4userdetail.jsp?state=1&user_name="
																			+ dataUser[i].userName
																			+ "'>"
																			+ dataUser[i].outcall_times
																			+ "</a></td><td><a href='statics4userdetail.jsp?state=2&user_name="
																			+ dataUser[i].userName
																			+ "'>"
																			+ dataUser[i].outcall_complete
																			+ "</a></td><td><a href='statics4userdetail.jsp?state=3&user_name="
																			+ dataUser[i].userName
																			+ "'>"
																			+ dataUser[i].outcall_notcomplete
																			+ '</a></td><td>'
																			+ dataUser[i].outcall_timelength
																			+ '</td></tr>');
												}
												$('#myPaginator2')
														.bootstrapPaginator(
																options);
											}
										});
							});
		});
		$('#export_btn').click(function() {
			$.ajax({
				url : basePath + "file/exportData.do",
				type : "post",
				data : {
					start_date : $('#start_date').val(),
					end_date : $('#end_date').val()
				},
				success : function() {
				}
			});
		});
	</script>
</body>
</html>