<%@ page language="java"
	import="java.util.*,cn.info.platform.entity.Topic" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
	int object_id = Integer.valueOf((String)request.getAttribute("object_id"));
	int pro_id = Integer.valueOf((String)request.getAttribute("pro_id"));
	String pnumber = (String)request.getAttribute("pnumber");
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

* {
	margin: 0;
	padding: 0;
	list-style-type: none;
}

a,img {
	border: 0;
}

body {
	_background-image: url(about:blank); /*用浏览器空白页面作为背景*/
	_background-attachment: fixed;
	/* prevent screen flash in IE6 确保滚动条滚动时，元素不闪动*/
}

/* float-news */
.float-news,.float-open {
	background: #fbfbfb;
	border: 2px solid #e1e1e1;
	border-left: 0 none;
	border-top-right-radius: 4px;
	border-bottom-right-radius: 4px;
	box-shadow: 1px 1px 2px rgba(0, 0, 0, 0.5);
	display: inline-block;
	font-size: 16px;
}

.float-news {
	height: 380px;
	left: 0px;
	padding: 10px 15px;
	width: 300px;
	z-index: 100;
	top: 117px;
	_margin-top: 117px;
}

.float-open {
	height: 48px;
	left: -70px;
	padding: 4px 4px 4px 6px;
	width: 48px;
	z-index: 99;
	top: 206px;
	_margin-top: 206px;
}

.float-news,.float-open {
	position: fixed;
	*zoom: 1;
	_position: absolute;
	_top: expression(eval(document.documentElement.scrollTop) );
}

.float-close {
	background: url(images/close.png) no-repeat left top;
	overflow: hidden;
	height: 48px;
	opacity: .6;
	filter: alpha(opacity =                             60);
	position: absolute;
	right: 9px;
	text-indent: 100%;
	top: 10px;
	white-space: nowrap;
	width: 48px;
}

.float-refresh {
	background: url(images/refresh.png) no-repeat left top;
	overflow: hidden;
	height: 48px;
	opacity: .6;
	filter: alpha(opacity =                               60);
	position: absolute;
	right: 65px;
	text-indent: 100%;
	top: 10px;
	white-space: nowrap;
	width: 48px;
}

.open-btn {
	background: url(images/ml-open-demo.png) no-repeat left top;
	display: block;
	overflow: hidden;
	height: 48px;
	opacity: .6;
	filter: alpha(opacity =                                 60);
	text-indent: 100%;
	white-space: nowrap;
	width: 48px;
}

.float-close:hover,.float-refresh:hover,.open-btn:hover {
	opacity: 1;
	filter: alpha(opacity =                                100);
}

.newslist h3 {
	color: #333;
	border-bottom: 4px solid #F2F2F2;
	font-size: 20px;
	height: 54px;
	line-height: 54px;
	font-family: Microsoft Yahei, simsun, arial, sans-serif;
}

.newslist ul {
	margin-top: 10px;
}

.newslist li {
	position: relative;
	height: 30px;
	line-height: 30px;
	font-size: 14px;
	border-bottom: 1px #ccc dotted
}

.newslist li a {
	color: #404040;
}

.newslist li span {
	position: absolute;
	right: 0;
	color: #ccc;
}

.newslist li:last-child {
	border-bottom: 0;
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
	<div class="float-open" id="float-open" style="left:-2px;">
		<a class="open-btn" href="javascript:void(0);">&gt;</a>
	</div>
	<div class="float-news" id="float-news" style="left:-450px;">
		<a class="float-close" href="javascript:void(0);">X</a> <a
			class="float-refresh" href="javascript:void(0);">R</a>
		<div class="newslist">
			<h3>号码列表，<span id='titleNum'></span></h3>
			<ul id='listUl' style="overflow-y:scroll; height: 275px;">
			</ul>
		</div>
	</div>

	<input id='basePathIn' type="hidden" value="<%=basePath%>" />
	<div>
		<div class="header">
			<h1 class="page-title">
				外呼
				<%=pnumber%>
				中。。。
			</h1>
		</div>

		<ul class="breadcrumb">
			<li><a href="index.jsp" target="_parent">主页</a> <span
				class="divider">/</span></li>
			<li><a href="outcall_start.jsp" target="mainFrame">外呼</a> <span
				class="divider">/</span></li>
			<li><a href="outcall_callobject.jsp?pro_id=<%=pro_id%>"
				target="mainFrame">号码</a> <span class="divider">/</span></li>
			<li class="active">答题</li>
		</ul>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="btn-toolbar">
					<div class="input-prepend input-append">
						<span class="add-on">地址</span> <input class="span4"
							id="object_addr" type="text">
						<button class="btn btn-info" type="button" id="saveAddrBtn">更新地址</button>
						<div class="btn-group">
							<span class="add-on">外呼异常</span> <select style="width: 140px"
								id="error_select">
								<option value="3">关机</option>
								<option value="4">停机</option>
								<option value="5">空号</option>
								<option value="6">无人接听</option>
								<option value="7">中途续约</option>
								<option value="8">中途挂机</option>
								<option value="9">挂机</option>
							</select>
						</div>
						<button class="btn btn-info" type="button" id="errorCmtBtn">提交异常</button>
						<div class="btn-group"></div>
						<div class="btn-group"></div>
						<span class="add-on">售出号码</span> <input class="span3"
							id="saletelnum" type="text">
					</div>
				</div>
				<div class="well">
					<table class="table table-striped" id='answer_info_tab'>
						<thead>
							<tr>
								<th>编号</th>
								<th>题目类型</th>
								<th style='width:600px'>题目内容</th>
								<th>回答</th>
							</tr>
						</thead>
						<tbody>
							<%
								List<Topic> list = (List<Topic>)request.getAttribute("topic_list");
										for(Topic topic:list){
							%>
							<tr>
								<td><%=topic.getTopic_id()%></td>
								<td><%=topic.getTopic_type()%></td>
								<td><%=topic.getTopic_content()%></td>
								<td><textarea class='span3' rows='4'></textarea></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
				<div class="btn-toolbar" align="center">
					<button class="btn btn-primary" id='commit_btn'>
						<i class="icon-circle-arrow-up"></i> 提交答案
					</button>
					<div class="btn-group"></div>
				</div>
			</div>
		</div>
	</div>
	<input type="hidden" value="<%=object_id%>" id="object_id" />
	<input type="hidden" value="<%=pro_id%>" id="pro_id" />
	<input type="hidden" value="<%=pnumber%>" id="object_pnumber" />
	<input type="hidden" id="object_flag" />
	<input type="hidden" id="object_state" value="4" />

	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		String.prototype.Trim = function() {
			return this.replace(/(^\s*)|(\s*$)/g, "");
		};
		Date.prototype.format = function(format) //author: meizz 
		{
			var o = {
				"M+" : this.getMonth() + 1, //month 
				"d+" : this.getDate(), //day 
				"h+" : this.getHours(), //hour 
				"m+" : this.getMinutes(), //minute 
				"s+" : this.getSeconds(), //second 
				"q+" : Math.floor((this.getMonth() + 3) / 3), //quarter 
				"S" : this.getMilliseconds()
			//millisecond 
			};
			if (/(y+)/.test(format))
				format = format.replace(RegExp.$1, (this.getFullYear() + "")
						.substr(4 - RegExp.$1.length));
			for ( var k in o)
				if (new RegExp("(" + k + ")").test(format))
					format = format.replace(RegExp.$1,
							RegExp.$1.length == 1 ? o[k] : ("00" + o[k])
									.substr(("" + o[k]).length));
			return format;
		};
		function validate() {
			var flag = 0;
			$("#answer_info_tab td").each(function(i) {
				if (i % 4 == 3) {//第四列
					textVal = $(this).find('textarea').val();
					if (textVal == '') {
						flag = 1;
					}
				}
			});
			return flag;
		}

		function selectToBoard(s) {
			$('#saletelnum').val(s);
		}

		$(function() {
			function ml_close() {
				$('.float-news').animate({
					left : '-450px'
				}, 300, function() {
					$('.float-open').delay(50).animate({
						left : '-2px'
					}, 300);
				});
			}
			function ml_open() {
				$('.float-open').animate({
					left : '-70px'
				}, 100, function() {
					$('.float-news').delay(50).animate({
						left : '0px'
					}, 300);
				});
			}

			var basePath = $('#basePathIn').val();

			function ml_refresh() {
				$('#listUl').html('');
				$.ajax({
					url : basePath + "saletelnumber/find_cansale_numbers.do",
					type : "post",
					data : {
						pro_id : $("#pro_id").val()
					},
					success : function(data) {
						var dataNums = eval(data);
						$('#titleNum').text('数量：' + dataNums.length);
						for ( var i = 0; i < dataNums.length; i++) {
							$('#listUl').append(
									"<li><a href='javascript:void(0);' onclick='selectToBoard("
											+ dataNums[i].telnumber + ");'>"
											+ dataNums[i].telnumber
											+ "</a><span>"
											+ dataNums[i].num_state
											+ "</span></li>");
						}
					}
				});
			}

			$('.float-close').click(function() {
				ml_close();
				return false;
			});
			$('.open-btn').click(function() {
				ml_open();
				return false;
			});
			$('.float-refresh').click(function() {
				ml_refresh();
				return false;
			});

			$.ajax({
				url : basePath + "saletelnumber/find_cansale_numbers.do",
				type : "post",
				data : {
					pro_id : $("#pro_id").val()
				},
				success : function(data) {
					var dataNums = eval(data);
					$('#titleNum').text('数量：' + dataNums.length);
					for ( var i = 0; i < dataNums.length; i++) {
						$('#listUl').append(
								"<li><a href='javascript:void(0);' onclick='selectToBoard("
										+ dataNums[i].telnumber + ");'>"
										+ dataNums[i].telnumber + "</a><span>"
										+ dataNums[i].num_state
										+ "</span></li>");
					}
				}
			});

			var old_outtime = new Date().format('yyyy-MM-dd hh:mm:ss');
			$.ajax({
				url : basePath + "addr/findAddr.do",
				type : "post",
				data : {
					object_id : $("#object_id").val()
				},
				success : function(data) {
					ch = new Array();
					ch = data.split("&");
					$("#object_flag").val(ch[1]);
					$("#object_addr").val(ch[0]);
				}
			});
			$('#commit_btn')
					.click(
							function() {
								result = validate();
								if (result == 0) {//验证完成
									dialog = art
											.dialog({
												content : "确定提交这些答案吗？",
												lock : true,
												drag : false,
												resize : false,
												icon : 'warning',
												ok : function() {
													var dataArray = new Array();
													$("#answer_info_tab td")
															.each(
																	function(i) {
																		topic_id = '';
																		if (i % 4 == 0) {//第1列
																			topic_id = $(
																					this)
																					.html();
																			dataArray
																					.push(topic_id);
																		}
																		object_id = $(
																				"#object_id")
																				.val();
																		answer_content = '';
																		if (i % 4 == 3) {//第4列
																			answer_content = $(
																					this)
																					.find(
																							'textarea')
																					.val();
																			dataArray
																					.push(object_id);
																			dataArray
																					.push(answer_content);
																		}
																	});
													$
															.ajax({
																url : basePath
																		+ "answer/addAnswer.do",
																type : "post",
																data : {
																	saletelnum : $(
																			'#saletelnum')
																			.val(),
																	dataArray : dataArray
																			.join('^'),
																	out_time : old_outtime
																},
																success : function(
																		data) {
																	if (data == '提交完成') {
																		window.location.href = basePath
																				+ "commitComplete.jsp?pro_id="
																				+ $(
																						"#pro_id")
																						.val();
																	} else {
																		dialog = art
																				.dialog({
																					content : data,
																					lock : true,
																					drag : false,
																					resize : false,
																					icon : 'succeed',
																				});
																	}
																}
															});
												},
												cancel : function() {
												}
											});
								} else {
									if (result == 1) {
										result = '有还没有回答的问题';
									} else {
										result = '异常';
									}
									dialog = art.dialog({
										content : result,
										lock : true,
										drag : false,
										resize : false,
										icon : 'warning',
									});
								}
							});

			$('#saveAddrBtn').click(function() {
				dialog = art.dialog({
					content : "确定更新地址吗？",
					lock : true,
					drag : false,
					resize : false,
					icon : 'warning',
					ok : function() {
						var myurl = basePath;
						if ($("#object_flag").val() == '2') {//add
							myurl += "addr/saveAddr.do";
						} else {
							myurl += "addr/addAddr.do";
						}
						$.ajax({
							url : myurl,
							type : "post",
							data : {
								object_id : $("#object_id").val(),
								object_pnumber : $("#object_pnumber").val(),
								object_addr : $("#object_addr").val()
							},
							success : function(data) {
								dialog = art.dialog({
									content : data,
									lock : true,
									drag : false,
									resize : false,
									icon : 'succeed',
								});
							}
						});
					},
					cancel : function() {
					}
				});
			});

			$("#error_select").change(function() {
				$("#object_state").val($("#error_select").val());
			});
			$('#errorCmtBtn')
					.click(
							function() {
								dialog = art
										.dialog({
											content : "确定提交异常吗？",
											lock : true,
											drag : false,
											resize : false,
											icon : 'warning',
											ok : function() {
												$
														.ajax({
															url : basePath
																	+ "callobject/commitError.do",
															type : "post",
															data : {
																object_id : $(
																		"#object_id")
																		.val(),
																object_state : $(
																		"#object_state")
																		.val(),
																out_time : old_outtime
															},
															success : function(
																	data) {
																art
																		.dialog({
																			content : data
																					+ "，关闭弹出继续将跳转",
																			icon : 'succeed',
																			lock : true,
																			drag : false,
																			resize : false,
																			close : function() {
																				window.location.href = basePath
																						+ "outcall_callobject.jsp?pro_id="
																						+ $(
																								"#pro_id")
																								.val();
																			}
																		});
															}
														});
											},
											cancel : function() {
											}
										});
							});
		});
	</script>
</body>
</html>