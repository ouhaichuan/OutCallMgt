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
		<ul class="breadcrumb">
			<li><a href="index.jsp" target="_parent">主页</a> <span
				class="divider">/</span></li>
			<li class="active">项目管理</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">
				<div class="btn-toolbar">
					<button class="btn btn-primary" id='addpro_btn'>
						<i class="icon-plus"></i> 添加项目
					</button>
					<button class="btn btn-info" id='startpro_btn'>
						<i class="icon-play"></i> 启动
					</button>
					<button class="btn btn-info" id='pausepro_btn'>
						<i class="icon-pause"></i> 暂停
					</button>
					<button class="btn btn-info" id='stoppro_btn'>
						<i class="icon-stop"></i> 停止
					</button>
					<button class="btn btn-info" id='cplpro_btn'>
						<i class="icon-ok-sign"></i> 完成
					</button>
					<div style="float: right;">
						<input type="text" placeholder='项目名称' id='search_txt'
							class="input-medium search-query">
						<button id='search_bnt' class="btn btn-primary">搜索</button>
					</div>
					<div class="btn-group"></div>
				</div>
				<div class="well">
					<table class="table table-striped" id='pro_info_tab'>
						<thead>
							<tr>
								<th style="width: 10px;"></th>
								<th style="width: 30px;">编号</th>
								<th style="width: 180px;">项目名称</th>
								<th style="width: 60px;">项目类型</th>
								<th style="width: 60px;">项目状态</th>
								<th style="width: 80px;">启动日期</th>
								<th style="width: 80px;">项目指派人</th>
								<th style="width: 80px;">外呼号码量</th>
								<th style="width: 80px;">项目负责人</th>
								<th style="width: 150px;"></th>
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
							<i class="icon-warning-sign modal-icon"></i>你确定删除这个项目吗?
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
		var basePath = $('#basePathIn').val();
		$(function() {
			$
					.ajax({
						url : basePath + "project/find_projects_pg.do",
						type : "post",
						data : {
							search_txt : $('#search_txt').val()
						},
						success : function(data) {
							var dataPro = eval(data);
							totolP = parseInt(dataPro.length % 7 == 0 ? dataPro.length / 7
									: dataPro.length / 7 + 1);
							numP = dataPro.length / 7 < 1 ? dataPro.length % 7
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
									if (type == 'first' && dataPro.length < 7) {
										size = dataPro.length;
									} else if (type == 'next' && page == totolP
											&& dataPro.length % 7 != 0) {
										size = dataPro.length % 7;
									} else if (type == 'next' && page == totolP
											&& dataPro.length % 7 == 0) {
										size = 7;
									} else if (page == totolP
											&& dataPro.length % 7 != 0) {
										size = dataPro.length % 7;
									} else if (page == totolP
											&& dataPro.length % 7 == 0) {
										size = 7;
									} else if (type == 'last'
											&& dataPro.length % 7 != 0) {
										size = dataPro.length % 7;
									} else if (type == 'last'
											&& dataPro.length % 7 == 0) {
										size = 7;
									}
									$('#list-content').html('');
									for ( var i = 0; i < size; i++) {
										$('#list-content')
												.append(
														"<tr><td><label class='checkbox'><input type='checkbox' onchange='checkedFn("
																+ dataPro[(page - 1)
																		* 7 + i].pro_id
																+ ",this);'/></label></td><td>"
																+ dataPro[(page - 1)
																		* 7 + i].pro_id
																+ '</td><td>'
																+ dataPro[(page - 1)
																		* 7 + i].pro_name
																+ '</td><td>'
																+ dataPro[(page - 1)
																		* 7 + i].pro_type
																+ '</td><td>'
																+ dataPro[(page - 1)
																		* 7 + i].pro_state
																+ '</td><td>'
																+ dataPro[(page - 1)
																		* 7 + i].pro_date
																+ '</td><td>'
																+ dataPro[(page - 1)
																		* 7 + i].pro_zpr
																+ '</td><td>'
																+ dataPro[(page - 1)
																		* 7 + i].outCallNums
																+ '</td><td>'
																+ dataPro[(page - 1)
																		* 7 + i].pro_users
																+ '</td><td>'
																+ "<a href='callobjects.jsp?pro_id="
																+ dataPro[(page - 1)
																		* 7 + i].pro_id
																+ "&pro_name="
																+ dataPro[(page - 1)
																		* 7 + i].pro_name
																+ "' rel='tooltip' title='外呼号码'><i class='icon-phone' style='font-size:20px;'></i> </a>&nbsp;&nbsp;"
																+ "<a href='topics.jsp?pro_id="
																+ dataPro[(page - 1)
																		* 7 + i].pro_id
																+ "&pro_name="
																+ dataPro[(page - 1)
																		* 7 + i].pro_name
																+ "' rel='tooltip' title='题目管理'><i class='icon-file' style='font-size:20px;'></i> </a>&nbsp;&nbsp;"
																+ "<a href='project_user.jsp?pro_id="
																+ dataPro[(page - 1)
																		* 7 + i].pro_id
																+ "&pro_name="
																+ dataPro[(page - 1)
																		* 7 + i].pro_name
																+ "' rel='tooltip' title='绑定工号'><i class='icon-user' style='font-size:20px;'></i> </a>&nbsp;&nbsp;<a href='salenumbers.jsp?pro_id="
																+ dataPro[(page - 1)
																		* 7 + i].pro_id
																+ "&pro_name="
																+ dataPro[(page - 1)
																		* 7 + i].pro_name
																+ "' rel='tooltip' title='销售号码'><i class='icon-bookmark' style='font-size:20px;'></i> </a>&nbsp;&nbsp;"
																+ "<a href='project.jsp?edit_type=2&pro_id="
																+ dataPro[(page - 1)
																		* 7 + i].pro_id
																+ '&pro_name='
																+ dataPro[(page - 1)
																		* 7 + i].pro_name
																+ '&pro_zpr='
																+ dataPro[(page - 1)
																		* 7 + i].pro_zpr
																+ '&pro_type='
																+ dataPro[(page - 1)
																		* 7 + i].pro_type
																+ '&pro_state='
																+ dataPro[(page - 1)
																		* 7 + i].pro_state
																+ '&pro_date='
																+ dataPro[(page - 1)
																		* 7 + i].pro_date
																+ '&pro_remark='
																+ dataPro[(page - 1)
																		* 7 + i].pro_remark
																+ "'><i class='icon-pencil' style='font-size:20px;'></i></a>&nbsp;&nbsp;<a href='#myModal' role='button' data-toggle='modal'><i class='icon-remove' style='font-size:20px;color:#FF0080;'></i> </a></td></tr>");
									}
									$("#pro_info_tab,tr").click(
											function() {
												var pro_id = $(this).children(
														"td:eq(1)").text();
												if (pro_id != "") {
													$('#del_app_id')
															.val(pro_id);
												}
											});
								}
							};
							bsize = dataPro.length < 7 ? dataPro.length : 7;
							$('#list-content').html('');
							for ( var i = 0; i < bsize; i++) {
								$('#list-content')
										.append(
												"<tr><td><label class='checkbox'><input type='checkbox' onchange='checkedFn("
														+ dataPro[i].pro_id
														+ ",this);'/></label></td><td>"
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
														+ dataPro[i].outCallNums
														+ '</td><td>'
														+ dataPro[i].pro_users
														+ '</td><td>'
														+ "<a href='callobjects.jsp?pro_id="
														+ dataPro[i].pro_id
														+ "&pro_name="
														+ dataPro[i].pro_name
														+ "' rel='tooltip' title='外呼号码'><i class='icon-phone' style='font-size:20px;'></i> </a>&nbsp;&nbsp;"
														+ "<a href='topics.jsp?pro_id="
														+ dataPro[i].pro_id
														+ "&pro_name="
														+ dataPro[i].pro_name
														+ "' rel='tooltip' title='题目管理'><i class='icon-file' style='font-size:20px;'></i> </a>&nbsp;&nbsp;"
														+ "<a href='project_user.jsp?pro_id="
														+ dataPro[i].pro_id
														+ "&pro_name="
														+ dataPro[i].pro_name
														+ "' rel='tooltip' title='绑定工号'><i class='icon-user' style='font-size:20px;'></i> </a>&nbsp;&nbsp;<a href='salenumbers.jsp?pro_id="
														+ dataPro[i].pro_id
														+ "&pro_name="
														+ dataPro[i].pro_name
														+ "' rel='tooltip' title='销售号码'><i class='icon-book' style='font-size:20px;'></i> </a>&nbsp;&nbsp;"
														+ "<a href='project.jsp?edit_type=2&pro_id="
														+ dataPro[i].pro_id
														+ '&pro_name='
														+ dataPro[i].pro_name
														+ '&pro_zpr='
														+ dataPro[i].pro_zpr
														+ '&pro_type='
														+ dataPro[i].pro_type
														+ '&pro_state='
														+ dataPro[i].pro_state
														+ '&pro_date='
														+ dataPro[i].pro_date
														+ '&pro_remark='
														+ dataPro[i].pro_remark
														+ "'><i class='icon-pencil' style='font-size:20px;'></i> </a>&nbsp;&nbsp;<a href='#myModal' role='button' data-toggle='modal'><i class='icon-remove' style='font-size:20px;color:#FF0080;'></i> </a></td></tr>");
							}
							$('#myPaginator').bootstrapPaginator(options);
							$("#pro_info_tab,tr").click(
									function() {
										var pro_id = $(this).children(
												"td:eq(1)").text();
										if (pro_id != "") {
											$('#del_app_id').val(pro_id);
										}
									});
						}
					});

			$('#addpro_btn').click(function() {
				window.location.href = basePath + "project.jsp?edit_type=1";
			});
			$('#del_btn').click(
					function() {
						window.location.href = basePath
								+ "project/del_pro.do?id="
								+ $('#del_app_id').val();
					});
		});

		/* 
		 *  方法:Array.remove(dx) 
		 *  功能:根据元素值删除数组元素. 
		 *  参数:元素值 
		 *  返回:在原数组上修改数组 
		 */
		Array.prototype.indexOf = function(val) {
			for ( var i = 0; i < this.length; i++) {
				if (this[i] == val) {
					return i;
				}
			}
			return -1;
		};
		Array.prototype.removevalue = function(val) {
			var index = this.indexOf(val);
			if (index > -1) {
				this.splice(index, 1);
			}
		};

		proIdList = new Array();
		function checkedFn(pro_id, obj) {
			if (obj.checked) {
				proIdList.push(pro_id);
			} else {
				proIdList.removevalue(pro_id);
			}
		}

		$('#startpro_btn').click(function() {
			$.ajax({
				url : basePath + "project/checkPro.do",
				type : "post",
				data : {
					list : proIdList.join()
				},
				success : function(data) {
					if (proIdList.length < 1) {
						dialog = art.dialog({
							content : "请选择要启动的项目",
							lock : true,
							drag : false,
							resize : false,
							icon : 'succeed'
						});
						return;
					}
					if (data == "false") {
						dialog = art.dialog({
							content : "你选择的项目未导入号码或者题目",
							lock : true,
							drag : false,
							resize : false,
							icon : 'succeed'
						});
						return;
					}
					$.ajax({
						url : basePath + "project/changestatepro.do",
						type : "post",
						data : {
							pro_state : '进行中',
							pro_id_list : proIdList.join()
						},
						success : function(data) {
							dialog = art.dialog({
								content : data,
								lock : true,
								drag : false,
								resize : false,
								icon : 'succeed'
							});
							window.location.href = basePath + 'projects.jsp';
						}
					});
				}
			});
		});
		$('#pausepro_btn').click(function() {
			if (proIdList.length < 1) {
				dialog = art.dialog({
					content : "请选择要暂停的项目",
					lock : true,
					drag : false,
					resize : false,
					icon : 'succeed'
				});
				return;
			}
			$.ajax({
				url : basePath + "project/changestatepro.do",
				type : "post",
				data : {
					pro_state : '暂停',
					pro_id_list : proIdList.join()
				},
				success : function(data) {
					dialog = art.dialog({
						content : data,
						lock : true,
						drag : false,
						resize : false,
						icon : 'succeed'
					});
					window.location.href = basePath + 'projects.jsp';
				}
			});
		});
		$('#stoppro_btn').click(function() {
			if (proIdList.length < 1) {
				dialog = art.dialog({
					content : "请选择要停止的项目",
					lock : true,
					drag : false,
					resize : false,
					icon : 'succeed'
				});
				return;
			}
			$.ajax({
				url : basePath + "project/changestatepro.do",
				type : "post",
				data : {
					pro_state : '停止',
					pro_id_list : proIdList.join()
				},
				success : function(data) {
					dialog = art.dialog({
						content : data,
						lock : true,
						drag : false,
						resize : false,
						icon : 'succeed'
					});
					window.location.href = basePath + 'projects.jsp';
				}
			});
		});
		$('#cplpro_btn').click(function() {
			if (proIdList.length < 1) {
				dialog = art.dialog({
					content : "请选择要完成的项目",
					lock : true,
					drag : false,
					resize : false,
					icon : 'succeed'
				});
				return;
			}
			$.ajax({
				url : basePath + "project/changestatepro.do",
				type : "post",
				data : {
					pro_state : '完成',
					pro_id_list : proIdList.join()
				},
				success : function(data) {
					dialog = art.dialog({
						content : data,
						lock : true,
						drag : false,
						resize : false,
						icon : 'succeed'
					});
					window.location.href = basePath + 'projects.jsp';
				}
			});
		});
		$('#search_bnt')
				.click(
						function() {
							$
									.ajax({
										url : basePath
												+ "project/find_projects_pg.do",
										type : "post",
										data : {
											search_txt : $('#search_txt').val()
										},
										success : function(data) {
											var dataPro = eval(data);
											totolP = parseInt(dataPro.length % 7 == 0 ? dataPro.length / 7
													: dataPro.length / 7 + 1);
											numP = dataPro.length / 7 < 1 ? dataPro.length % 7
													: 7;
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
												onPageClicked : function(event,
														originalEvent, type,
														page) {
													size = 7;
													if (type == 'first'
															&& dataPro.length < 7) {
														size = dataPro.length;
													} else if (type == 'next'
															&& page == totolP
															&& dataPro.length % 7 != 0) {
														size = dataPro.length % 7;
													} else if (type == 'next'
															&& page == totolP
															&& dataPro.length % 7 == 0) {
														size = 7;
													} else if (page == totolP
															&& dataPro.length % 7 != 0) {
														size = dataPro.length % 7;
													} else if (page == totolP
															&& dataPro.length % 7 == 0) {
														size = 7;
													} else if (type == 'last'
															&& dataPro.length % 7 != 0) {
														size = dataPro.length % 7;
													} else if (type == 'last'
															&& dataPro.length % 7 == 0) {
														size = 7;
													}
													$('#list-content').html('');
													for ( var i = 0; i < size; i++) {
														$('#list-content')
																.append(
																		"<tr><td><label class='checkbox'><input type='checkbox' onchange='checkedFn("
																				+ dataPro[(page - 1)
																						* 7
																						+ i].pro_id
																				+ ",this);'/></label></td><td>"
																				+ dataPro[(page - 1)
																						* 7
																						+ i].pro_id
																				+ '</td><td>'
																				+ dataPro[(page - 1)
																						* 7
																						+ i].pro_name
																				+ '</td><td>'
																				+ dataPro[(page - 1)
																						* 7
																						+ i].pro_type
																				+ '</td><td>'
																				+ dataPro[(page - 1)
																						* 7
																						+ i].pro_state
																				+ '</td><td>'
																				+ dataPro[(page - 1)
																						* 7
																						+ i].pro_date
																				+ '</td><td>'
																				+ dataPro[(page - 1)
																						* 7
																						+ i].pro_zpr
																				+ '</td><td>'
																				+ dataPro[(page - 1)
																						* 7
																						+ i].outCallNums
																				+ '</td><td>'
																				+ dataPro[(page - 1)
																						* 7
																						+ i].pro_users
																				+ '</td><td>'
																				+ "<a href='callobjects.jsp?pro_id="
																				+ dataPro[(page - 1)
																						* 7
																						+ i].pro_id
																				+ "&pro_name="
																				+ dataPro[(page - 1)
																						* 7
																						+ i].pro_name
																				+ "' rel='tooltip' title='外呼号码'><i class='icon-phone' style='font-size:20px;'></i> </a>&nbsp;&nbsp;"
																				+ "<a href='topics.jsp?pro_id="
																				+ dataPro[(page - 1)
																						* 7
																						+ i].pro_id
																				+ "&pro_name="
																				+ dataPro[(page - 1)
																						* 7
																						+ i].pro_name
																				+ "' rel='tooltip' title='题目管理'><i class='icon-file' style='font-size:20px;'></i> </a>&nbsp;&nbsp;"
																				+ "<a href='project_user.jsp?pro_id="
																				+ dataPro[(page - 1)
																						* 7
																						+ i].pro_id
																				+ "&pro_name="
																				+ dataPro[(page - 1)
																						* 7
																						+ i].pro_name
																				+ "' rel='tooltip' title='绑定工号'><i class='icon-user' style='font-size:20px;'></i> </a>&nbsp;&nbsp;<a href='salenumbers.jsp?pro_id="
																				+ dataPro[(page - 1)
																						* 7
																						+ i].pro_id
																				+ "&pro_name="
																				+ dataPro[(page - 1)
																						* 7
																						+ i].pro_name
																				+ "' rel='tooltip' title='销售号码'><i class='icon-bookmark' style='font-size:20px;'></i> </a>&nbsp;&nbsp;"
																				+ "<a href='project.jsp?edit_type=2&pro_id="
																				+ dataPro[(page - 1)
																						* 7
																						+ i].pro_id
																				+ '&pro_name='
																				+ dataPro[(page - 1)
																						* 7
																						+ i].pro_name
																				+ '&pro_zpr='
																				+ dataPro[(page - 1)
																						* 7
																						+ i].pro_zpr
																				+ '&pro_type='
																				+ dataPro[(page - 1)
																						* 7
																						+ i].pro_type
																				+ '&pro_state='
																				+ dataPro[(page - 1)
																						* 7
																						+ i].pro_state
																				+ '&pro_date='
																				+ dataPro[(page - 1)
																						* 7
																						+ i].pro_date
																				+ '&pro_remark='
																				+ dataPro[(page - 1)
																						* 7
																						+ i].pro_remark
																				+ "'><i class='icon-pencil' style='font-size:20px;'></i></a>&nbsp;&nbsp;<a href='#myModal' role='button' data-toggle='modal'><i class='icon-remove' style='font-size:20px;color:#FF0080;'></i> </a></td></tr>");
													}
													$("#pro_info_tab,tr")
															.click(
																	function() {
																		var pro_id = $(
																				this)
																				.children(
																						"td:eq(1)")
																				.text();
																		if (pro_id != "") {
																			$(
																					'#del_app_id')
																					.val(
																							pro_id);
																		}
																	});
												}
											};
											bsize = dataPro.length < 7 ? dataPro.length
													: 7;
											$('#list-content').html('');
											for ( var i = 0; i < bsize; i++) {
												$('#list-content')
														.append(
																"<tr><td><label class='checkbox'><input type='checkbox' onchange='checkedFn("
																		+ dataPro[i].pro_id
																		+ ",this);'/></label></td><td>"
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
																		+ dataPro[i].outCallNums
																		+ '</td><td>'
																		+ dataPro[i].pro_users
																		+ '</td><td>'
																		+ "<a href='callobjects.jsp?pro_id="
																		+ dataPro[i].pro_id
																		+ "&pro_name="
																		+ dataPro[i].pro_name
																		+ "' rel='tooltip' title='外呼号码'><i class='icon-phone' style='font-size:20px;'></i> </a>&nbsp;&nbsp;"
																		+ "<a href='topics.jsp?pro_id="
																		+ dataPro[i].pro_id
																		+ "&pro_name="
																		+ dataPro[i].pro_name
																		+ "' rel='tooltip' title='题目管理'><i class='icon-file' style='font-size:20px;'></i> </a>&nbsp;&nbsp;"
																		+ "<a href='project_user.jsp?pro_id="
																		+ dataPro[i].pro_id
																		+ "&pro_name="
																		+ dataPro[i].pro_name
																		+ "' rel='tooltip' title='绑定工号'><i class='icon-user' style='font-size:20px;'></i> </a>&nbsp;&nbsp;<a href='salenumbers.jsp?pro_id="
																		+ dataPro[i].pro_id
																		+ "&pro_name="
																		+ dataPro[i].pro_name
																		+ "' rel='tooltip' title='销售号码'><i class='icon-book' style='font-size:20px;'></i> </a>&nbsp;&nbsp;"
																		+ "<a href='project.jsp?edit_type=2&pro_id="
																		+ dataPro[i].pro_id
																		+ '&pro_name='
																		+ dataPro[i].pro_name
																		+ '&pro_zpr='
																		+ dataPro[i].pro_zpr
																		+ '&pro_type='
																		+ dataPro[i].pro_type
																		+ '&pro_state='
																		+ dataPro[i].pro_state
																		+ '&pro_date='
																		+ dataPro[i].pro_date
																		+ '&pro_remark='
																		+ dataPro[i].pro_remark
																		+ "'><i class='icon-pencil' style='font-size:20px;'></i> </a>&nbsp;&nbsp;<a href='#myModal' role='button' data-toggle='modal'><i class='icon-remove' style='font-size:20px;color:#FF0080;'></i> </a></td></tr>");
											}
											$('#myPaginator')
													.bootstrapPaginator(options);
											$("#pro_info_tab,tr")
													.click(
															function() {
																var pro_id = $(
																		this)
																		.children(
																				"td:eq(1)")
																		.text();
																if (pro_id != "") {
																	$(
																			'#del_app_id')
																			.val(
																					pro_id);
																}
															});
										}
									});
						});
	</script>
</body>
</html>