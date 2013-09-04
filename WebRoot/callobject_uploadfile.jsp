<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String pro_id = "";
	if (null != request.getParameter("pro_id")) {
		pro_id = new String(request.getParameter("pro_id").getBytes(
				"iso-8859-1"), "utf-8");
	}
	String pro_name = "";
	if (null != request.getParameter("pro_name")) {
		pro_name = new String(request.getParameter("pro_name")
				.getBytes("iso-8859-1"), "utf-8");
	}
%>

<!DOCTYPE>
<html>
<head>
<base href="<%=basePath%>">

<title></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="uploadify/uploadify.css" type="text/css"></link>

<script type="text/javascript" src="lib/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="uploadify/jquery.uploadify.min.js"></script>
</head>
<body>
	<input id='basePathIn' type="hidden" value="<%=basePath%>">
	<input id='pro_id' type="hidden" value="<%=pro_id%>">
	<input id='pro_name' type="hidden" value="<%=pro_name%>">

	<input id="file_upload" class="uploadify" type="file"
		style="height: 30px; width: 80px;float: left;" />

	<button id="cls_btn" class="uploadify-button"
		style="height: 30px; width: 80px;float: right;cursor:hand;">清空</button>

	<button id="import_btn" class="uploadify-button"
		style="height: 30px; width: 80px;float: right;cursor:hand;">上传</button>

	<div id="file_upload-queue" class="uploadify-queue"
		style="padding-top: 40px;"></div>

	<script type="text/javascript">
		$(function() {
			var basePath = $('#basePathIn').val();

			$("#file_upload").uploadify({
				'height' : 30,
				'width' : 80,
				'swf' : basePath + 'uploadify/uploadify.swf',
				'auto' : false,
				'debug' : false,
				'multi' : false,
				'successTimeout' : 99999,
				'queueID' : 'file_upload-queue',
				'fileTypeExts' : '*.xls;*.xlsx',
				'fileTypeDesc' : '支持格式:xls,xlsx.',
				'fileSizeLimit' : '3MB',
				'queueSizeLimit' : 5,
				'uploader' : basePath + 'file/object.do',
				'buttonText' : '浏览',
				'onUploadComplete' : function(file) {

				},
				'onUploadSuccess' : function(file, data, response) {

				},
				'onUploadStart' : function(file) {
					$("#file_upload").uploadify("settings", "formData", {
						'pro_id' : $('#pro_id').val()
					});
				}
			});
			$('#cls_btn').click(function() {
				$('#file_upload').uploadify('cancel', '*');
			});
			$('#import_btn').click(function() {
				$('#file_upload').uploadify('upload', '*');
			});
		});
	</script>
</body>
</html>
