<%@ page language="java"
	import="java.util.*,cn.info.platform.entity.Topic" pageEncoding="UTF-8"%>
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
				class="divider">/</span></li>
			<li class="active">题目管理</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">
				<div class="btn-toolbar">
					<button class="btn btn-primary" id='addtopic_btn'>
						<i class="icon-plus"></i> 添加题目
					</button>
					<div class="btn-group"></div>
				</div>
				<div class="well">
					<table class="table table-striped" id='topic_info_tab'>
						<thead>
							<tr>
								<th>编号</th>
								<th>所属项目</th>
								<th style="width: 600px;">题目内容</th>
								<th>题目类型</th>
								<th>备注</th>
								<th style="width: 36px;"></th>
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
							<i class="icon-warning-sign modal-icon"></i>你确定删除这个题目吗?
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
			
			$.post(basePath + "topic/find_all_topic.do", function(data) {
				var dataTopic = eval(data);
				totolP = parseInt(dataTopic.length % 5 == 0 ? dataTopic.length / 5
						: dataTopic.length / 5 + 1);
				numP = dataTopic.length / 5 < 1 ? dataTopic.length % 5 : 5;
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
					onPageClicked : function(event, originalEvent, type, page) {
						size = 5;
						if (type == 'first' && dataTopic.length < 5) {
							size = dataTopic.length;
						}else if(type == 'next' && page==totolP){
							size = dataTopic.length % 5;
						}else if(page==totolP){
							size = dataTopic.length % 5;
						}else if (type == 'last' && dataTopic.length % 5 != 0) {
							size = dataTopic.length % 5;
						}
						$('#list-content').html('');
						for ( var i = 0; i < size; i++) {
							$('#list-content').append(
							'<tr><td>' + dataTopic[(page-1)*5+i].topic_id + '</td><td>'
									+ dataTopic[(page-1)*5+i].pro_name + '</td><td>'
									+ dataTopic[(page-1)*5+i].topic_content + '</td><td>'
									+ dataTopic[(page-1)*5+i].topic_type + '</td><td>'
									+ dataTopic[(page-1)*5+i].topic_remark + '</td><td>'+"<a href='topic.jsp?edit_type=2&topic_id="+dataTopic[(page-1)*5+i].topic_id+'&pro_id='+dataTopic[(page-1)*5+i].pro_id+'&pro_name='+dataTopic[(page-1)*5+i].pro_name+'&topic_content='+dataTopic[(page-1)*5+i].topic_content+'&topic_type='+dataTopic[(page-1)*5+i].topic_type+'&topic_remark='+dataTopic[(page-1)*5+i].topic_remark+"'><i class='icon-pencil'></i> </a>&nbsp;&nbsp;<a href='#myModal' role='button' data-toggle='modal'><i class='icon-remove'></i> </a></td></tr>");
						}
						$("#list-content,tr").click(function() {
							var topic_id = $(this).children("td:eq(0)").text();
							if (topic_id != "") {
								$('#del_app_id').val(topic_id);
							}
						});
					}
				};
				bsize = dataTopic.length < 5 ? dataTopic.length : 5;
				$('#list-content').html('');
				for ( var i = 0; i < bsize; i++) {
					$('#list-content').append(
							'<tr><td>' + dataTopic[i].topic_id + '</td><td>'
									+ dataTopic[i].pro_name + '</td><td>'
									+ dataTopic[i].topic_content + '</td><td>'
									+ dataTopic[i].topic_type + '</td><td>'
									+ dataTopic[i].topic_remark + '</td><td>'+"<a href='topic.jsp?edit_type=2&topic_id="+dataTopic[i].topic_id+'&pro_id='+dataTopic[i].pro_id+'&pro_name='+dataTopic[i].pro_name+'&topic_content='+dataTopic[i].topic_content+'&topic_type='+dataTopic[i].topic_type+'&topic_remark='+dataTopic[i].topic_remark+"'><i class='icon-pencil'></i> </a>&nbsp;&nbsp;<a href='#myModal' role='button' data-toggle='modal'><i class='icon-remove'></i> </a></td></tr>");
				}
				$('#myPaginator').bootstrapPaginator(options);
				$("#list-content,tr").click(function() {
					var topic_id = $(this).children("td:eq(0)").text();
					if (topic_id != "") {
						$('#del_app_id').val(topic_id);
					}
				});
			});
			
			$('#addtopic_btn').click(function() {
				window.location.href = basePath + "topic.jsp?edit_type=1";
			});
			$('#del_btn').click(
					function() {
						window.location.href = basePath
								+ "topic/del_topic.do?id="
								+ $('#del_app_id').val();
					});
			$("#topic_info_tab,tr").click(function() {
				var topic_id = $(this).children("td:eq(0)").text();
				if (topic_id != "") {
					$('#del_app_id').val(topic_id);
				}
			});
		});
	</script>
</body>
</html>