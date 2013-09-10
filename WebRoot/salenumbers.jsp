<%@ page language="java"
	import="java.util.*,cn.info.platform.entity.SaleTelNumber"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	String pro_id = request.getParameter("pro_id") != null ? request
			.getParameter("pro_id") : "";

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
<script type="text/javascript" src="js/bootstrap-paginator.min.js"></script>
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
	<input id='pro_id' type="hidden" value="<%=pro_id%>">
	<input id='pro_name' type="hidden" value="<%=pro_name%>">
	<div>
		<ul class="breadcrumb">
			<li><a href="index.jsp" target="_parent">主页</a> <span
				class="divider">/</span></li>
			<li><a href="projects.jsp" target="mainFrame">项目管理</a> <span
				class="divider">/</span>
			</li>
			<li class="active">销售号码管理</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">
				<div class="btn-toolbar">
					<button class="btn btn-primary" id='addnum_btn'>
						<i class="icon-plus"></i> 添加号码
					</button>
					<button class="btn btn-info" id='import_btn'>
						<i class="icon-circle-arrow-down"></i> 导入号码
					</button>
					<div style="float: right;">
						<input type="text" placeholder='号码' id='search_txt'
							class="input-medium search-query">
						<button id='search_btn' class="btn btn-primary">搜索</button>
					</div>
					<div class="btn-group"></div>
				</div>
				<div class="well">
					<table class="table table-striped" id='num_info_tab'>
						<thead>
							<tr>
								<th>编号</th>
								<th>号码</th>
								<th>状态</th>
								<th>所属项目</th>
								<th>售出时间</th>
								<th>销售人</th>
								<th style="width: 36px;"></th>
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

				<div class="modal small hide fade" id="myModal" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h3 id="myModalLabel">提示</h3>
					</div>
					<div class="modal-body">
						<p class="error-text">
							<i class="icon-warning-sign modal-icon"></i>你确定删除这个号码吗?
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

			$
					.ajax({
						url : basePath + "saletelnumber/find_all_numbers.do",
						type : "post",
						data : {
							pro_id : $("#pro_id").val(),
							search_txt : $("#search_txt").val()
						},
						success : function(data) {
							var dataNumber = eval(data);
							$('#content').text('号码总数：' + dataNumber.length);
							totolP = parseInt(dataNumber.length % 8 == 0 ? dataNumber.length / 8
									: dataNumber.length / 8 + 1);
							numP = dataNumber.length / 8 < 1 ? dataNumber.length % 8
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
									if (type == 'first'
											&& dataNumber.length < 8) {
										size = dataNumber.length;
									} else if (type == 'next' && page == totolP
											&& dataNumber.length % 8 != 0) {
										size = dataNumber.length % 8;
									} else if (type == 'next' && page == totolP
											&& dataNumber.length % 8 == 0) {
										size = 8;
									} else if (page == totolP
											&& dataNumber.length % 8 != 0) {
										size = dataNumber.length % 8;
									} else if (page == totolP
											&& dataNumber.length % 8 == 0) {
										size = 8;
									} else if (type == 'last'
											&& dataNumber.length % 8 != 0) {
										size = dataNumber.length % 8;
									} else if (type == 'last'
											&& dataNumber.length % 8 == 0) {
										size = 8;
									}
									$('#list-content').html('');
									for ( var i = 0; i < size; i++) {
										$('#list-content')
												.append(
														'<tr><td>'
																+ dataNumber[(page - 1)
																		* 8 + i].num_id
																+ '</td><td>'
																+ dataNumber[(page - 1)
																		* 8 + i].telnumber
																+ '</td><td>'
																+ dataNumber[(page - 1)
																		* 8 + i].num_state
																+ '</td><td>'
																+ dataNumber[(page - 1)
																		* 8 + i].pro_name
																+ '</td><td>'
																+ dataNumber[(page - 1)
																		* 8 + i].sale_time
																+ '</td><td>'
																+ dataNumber[(page - 1)
																		* 8 + i].user_xm
																+ '</td><td>'
																+ "<a href='salenumber.jsp?edit_type=2&num_id="
																+ dataNumber[(page - 1)
																		* 8 + i].num_id
																+ '&telnumber='
																+ dataNumber[(page - 1)
																		* 8 + i].telnumber
																+ '&num_state='
																+ dataNumber[(page - 1)
																		* 8 + i].num_state
																+ '&pro_id='
																+ dataNumber[(page - 1)
																		* 8 + i].pro_id
																+ '&pro_name='
																+ dataNumber[(page - 1)
																		* 8 + i].pro_name
																+ "'><i class='icon-pencil'></i> </a>&nbsp;&nbsp;<a href='#myModal' role='button' data-toggle='modal'><i class='icon-remove'></i> </a></td></tr>");
									}
									$("#list-content,tr").click(
											function() {
												var num_id = $(this).children(
														"td:eq(0)").text();
												if (num_id != "") {
													$('#del_app_id')
															.val(num_id);
												}
											});
								}
							};
							bsize = dataNumber.length < 8 ? dataNumber.length
									: 8;
							$('#list-content').html('');
							for ( var i = 0; i < bsize; i++) {
								$('#list-content')
										.append(
												'<tr><td>'
														+ dataNumber[i].num_id
														+ '</td><td>'
														+ dataNumber[i].telnumber
														+ '</td><td>'
														+ dataNumber[i].num_state
														+ '</td><td>'
														+ dataNumber[i].pro_name
														+ '</td><td>'
														+ dataNumber[i].sale_time
														+ '</td><td>'
														+ dataNumber[i].user_xm
														+ '</td><td>'
														+ "<a href='salenumber.jsp?edit_type=2&num_id="
														+ dataNumber[i].num_id
														+ '&telnumber='
														+ dataNumber[i].telnumber
														+ '&num_state='
														+ dataNumber[i].num_state
														+ '&pro_id='
														+ dataNumber[i].pro_id
														+ '&pro_name='
														+ dataNumber[i].pro_name
														+ "'><i class='icon-pencil'></i> </a>&nbsp;&nbsp;<a href='#myModal' role='button' data-toggle='modal'><i class='icon-remove'></i> </a></td></tr>");
							}
							$('#myPaginator').bootstrapPaginator(options);
							$("#list-content,tr").click(
									function() {
										var num_id = $(this).children(
												"td:eq(0)").text();
										if (num_id != "") {
											$('#del_app_id').val(num_id);
										}
									});
						}
					});
			$('#search_btn')
					.click(
							function() {
								$
										.ajax({
											url : basePath
													+ "saletelnumber/find_all_numbers.do",
											type : "post",
											data : {
												pro_id : $("#pro_id").val(),
												search_txt : $("#search_txt")
														.val()
											},
											success : function(data) {
												var dataNumber = eval(data);
												$('#content')
														.text(
																'号码总数：'
																		+ dataNumber.length);
												totolP = parseInt(dataNumber.length % 8 == 0 ? dataNumber.length / 8
														: dataNumber.length / 8 + 1);
												numP = dataNumber.length / 8 < 1 ? dataNumber.length % 8
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
																&& dataNumber.length < 8) {
															size = dataNumber.length;
														} else if (type == 'next'
																&& page == totolP
																&& dataNumber.length % 8 != 0) {
															size = dataNumber.length % 8;
														} else if (type == 'next'
																&& page == totolP
																&& dataNumber.length % 8 == 0) {
															size = 8;
														} else if (page == totolP
																&& dataNumber.length % 8 != 0) {
															size = dataNumber.length % 8;
														} else if (page == totolP
																&& dataNumber.length % 8 == 0) {
															size = 8;
														} else if (type == 'last'
																&& dataNumber.length % 8 != 0) {
															size = dataNumber.length % 8;
														} else if (type == 'last'
																&& dataNumber.length % 8 == 0) {
															size = 8;
														}
														$('#list-content')
																.html('');
														for ( var i = 0; i < size; i++) {
															$('#list-content')
																	.append(
																			'<tr><td>'
																					+ dataNumber[(page - 1)
																							* 8
																							+ i].num_id
																					+ '</td><td>'
																					+ dataNumber[(page - 1)
																							* 8
																							+ i].telnumber
																					+ '</td><td>'
																					+ dataNumber[(page - 1)
																							* 8
																							+ i].num_state
																					+ '</td><td>'
																					+ dataNumber[(page - 1)
																							* 8
																							+ i].pro_name
																					+ '</td><td>'
																					+ dataNumber[(page - 1)
																							* 8
																							+ i].sale_time
																					+ '</td><td>'
																					+ dataNumber[(page - 1)
																							* 8
																							+ i].user_xm
																					+ '</td><td>'
																					+ "<a href='salenumber.jsp?edit_type=2&num_id="
																					+ dataNumber[(page - 1)
																							* 8
																							+ i].num_id
																					+ '&telnumber='
																					+ dataNumber[(page - 1)
																							* 8
																							+ i].telnumber
																					+ '&num_state='
																					+ dataNumber[(page - 1)
																							* 8
																							+ i].num_state
																					+ '&pro_id='
																					+ dataNumber[(page - 1)
																							* 8
																							+ i].pro_id
																					+ '&pro_name='
																					+ dataNumber[(page - 1)
																							* 8
																							+ i].pro_name
																					+ "'><i class='icon-pencil'></i> </a>&nbsp;&nbsp;<a href='#myModal' role='button' data-toggle='modal'><i class='icon-remove'></i> </a></td></tr>");
														}
														$("#list-content,tr")
																.click(
																		function() {
																			var num_id = $(
																					this)
																					.children(
																							"td:eq(0)")
																					.text();
																			if (num_id != "") {
																				$(
																						'#del_app_id')
																						.val(
																								num_id);
																			}
																		});
													}
												};
												bsize = dataNumber.length < 8 ? dataNumber.length
														: 8;
												$('#list-content').html('');
												for ( var i = 0; i < bsize; i++) {
													$('#list-content')
															.append(
																	'<tr><td>'
																			+ dataNumber[i].num_id
																			+ '</td><td>'
																			+ dataNumber[i].telnumber
																			+ '</td><td>'
																			+ dataNumber[i].num_state
																			+ '</td><td>'
																			+ dataNumber[i].pro_name
																			+ '</td><td>'
																			+ dataNumber[i].sale_time
																			+ '</td><td>'
																			+ dataNumber[i].user_xm
																			+ '</td><td>'
																			+ "<a href='salenumber.jsp?edit_type=2&num_id="
																			+ dataNumber[i].num_id
																			+ '&telnumber='
																			+ dataNumber[i].telnumber
																			+ '&num_state='
																			+ dataNumber[i].num_state
																			+ '&pro_id='
																			+ dataNumber[i].pro_id
																			+ '&pro_name='
																			+ dataNumber[i].pro_name
																			+ "'><i class='icon-pencil'></i> </a>&nbsp;&nbsp;<a href='#myModal' role='button' data-toggle='modal'><i class='icon-remove'></i> </a></td></tr>");
												}
												$('#myPaginator')
														.bootstrapPaginator(
																options);
												$("#list-content,tr")
														.click(
																function() {
																	var num_id = $(
																			this)
																			.children(
																					"td:eq(0)")
																			.text();
																	if (num_id != "") {
																		$(
																				'#del_app_id')
																				.val(
																						num_id);
																	}
																});
											}
										});
							});
			$('#addnum_btn').click(
					function() {
						window.location.href = basePath
								+ "salenumber.jsp?edit_type=1&pro_id="
								+ $('#pro_id').val() + "&pro_name="
								+ $('#pro_name').val();
					});
			$('#del_btn').click(
					function() {
						window.location.href = basePath
								+ "saletelnumber/del_num.do?id="
								+ $('#del_app_id').val() + "&pro_id="
								+ $('#pro_id').val() + "&pro_name="
								+ $('#pro_name').val();
					});
			$("#num_info_tab,tr").click(function() {
				var num_id = $(this).children("td:eq(0)").text();
				if (num_id != "") {
					$('#del_app_id').val(num_id);
				}
			});
			$('#import_btn').click(
					function() {
						art.dialog.open(basePath + "num_uploadfile.jsp?pro_id="
								+ $('#pro_id').val() + '&pro_name='
								+ $('#pro_name').val(), {
							id : 'filechosseDialog',
							width : 420,
							height : 350,
							title : "'" + $('#pro_name').val() + "'"
									+ '&nbsp;&nbsp;&nbsp;导入销售号码',
							lock : true,
							drag : false,
							resize : false,
							close : function() {
								window.location.href = basePath
										+ 'salenumbers.jsp?pro_id='
										+ $('#pro_id').val() + "&pro_name="
										+ $('#pro_name').val();
							}
						});
					});
		});
	</script>
</body>
</html>