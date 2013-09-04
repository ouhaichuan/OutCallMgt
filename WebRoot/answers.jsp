<%@ page language="java"
	import="java.util.*,cn.info.platform.entity.Answer"
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
			<li class="active">答案查询</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">
				<div class="btn-toolbar" style="padding-bottom: 30px;">
					<div style="float: right;">
						<input type="text" placeholder='外呼号码/答案'
							class="input-medium search-query">
						<button id='search_bnt' class="btn btn-primary">搜索</button>
					</div>
				</div>
				<div class="well">
					<table class="table table-striped" id='answer_info_tab'>
						<thead>
							<tr>
								<th style="width: 80px;">编号</th>
								<th style="width: 100px;">外呼号码</th>
								<th style="width: 600px;">题目</th>
								<th>答案</th>
							</tr>
						</thead>
						<tbody id="list-content">
						</tbody>
					</table>
				</div>
				<div id="myPaginator"></div>

				<div class="modal small hide fade" id="myModal" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h3 id="myModalLabel">提示</h3>
					</div>
					<div class="modal-body">
						<p class="error-text">
							<i class="icon-warning-sign modal-icon"></i>你确定删除这个答案吗?
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
					.post(
							basePath + "answer/find_all_answer.do",
							function(data) {
								var dataAnswer = eval(data);
								totolP = parseInt(dataAnswer.length % 5 == 0 ? dataAnswer.length / 5
										: dataAnswer.length / 5 + 1);
								numP = dataAnswer.length / 5 < 1 ? dataAnswer.length % 5
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
									onPageClicked : function(event,
											originalEvent, type, page) {
										size = 5;
										if (type == 'first'
												&& dataAnswer.length < 5) {
											size = dataAnswer.length;
										} else if (type == 'next'
												&& page == totolP
												&& dataAnswer.length % 5 != 0) {
											size = dataAnswer.length % 5;
										} else if (type == 'next'
												&& page == totolP
												&& dataAnswer.length % 5 == 0) {
											size = 5;
										} else if (page == totolP
												&& dataAnswer.length % 5 != 0) {
											size = dataAnswer.length % 5;
										} else if (page == totolP
												&& dataAnswer.length % 5 == 0) {
											size = 5;
										} else if (type == 'last'
												&& dataAnswer.length % 5 != 0) {
											size = dataAnswer.length % 5;
										} else if (type == 'last'
												&& dataAnswer.length % 5 == 0) {
											size = 5;
										}
										$('#list-content').html('');
										for ( var i = 0; i < size; i++) {
											$('#list-content')
													.append(
															'<tr><td>'
																	+ dataAnswer[(page - 1)
																			* 5
																			+ i].answer_id
																	+ '</td><td>'
																	+ dataAnswer[(page - 1)
																			* 5
																			+ i].object_pnumber
																	+ '</td><td>'
																	+ dataAnswer[(page - 1)
																			* 5
																			+ i].topic_content
																	+ '</td><td>'
																	+ dataAnswer[(page - 1)
																			* 5
																			+ i].answer_content
																	+ '</td></tr>');
										}
										$("#list-content,tr").click(
												function() {
													var answer_id = $(this)
															.children(
																	"td:eq(0)")
															.text();
													if (answer_id != "") {
														$('#del_app_id').val(
																answer_id);
													}
												});
									}
								};
								bsize = dataAnswer.length < 5 ? dataAnswer.length
										: 5;
								$('#list-content').html('');
								for ( var i = 0; i < bsize; i++) {
									$('#list-content')
											.append(
													'<tr><td>'
															+ dataAnswer[i].answer_id
															+ '</td><td>'
															+ dataAnswer[i].object_pnumber
															+ '</td><td>'
															+ dataAnswer[i].topic_content
															+ '</td><td>'
															+ dataAnswer[i].answer_content
															+ '</td></tr>');
								}
								$('#myPaginator').bootstrapPaginator(options);
								$("#list-content,tr")
										.click(
												function() {
													var answer_id = $(this)
															.children(
																	"td:eq(0)")
															.text();
													if (answer_id != "") {
														$('#del_app_id').val(
																answer_id);
													}
												});
							});
		});
	</script>
</body>
</html>