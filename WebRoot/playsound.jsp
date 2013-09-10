<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	String object_id = "";
	if (null != request.getParameter("object_id")) {
		object_id = new String(request.getParameter("object_id")
				.getBytes("iso-8859-1"), "utf-8");
	}
	String object_pnumber = "";
	if (null != request.getParameter("object_pnumber")) {
		object_pnumber = new String(request.getParameter(
				"object_pnumber").getBytes("iso-8859-1"), "utf-8");
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
<script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>
</head>
<input value="<%=object_id%>" type="hidden">
<body>
	<div align="center">
		<br> <label><%=object_pnumber%>&nbsp;的录音</label> <br>
		<br>
		<br>
		<object height=400 width=500 align="middle"
			classid=CLSID:6BF52A52-394A-11d3-B153-00C04F79FAA6>
			<param name='URL'
				value='<%=basePath%>sound/1388360045090_20120602105433_022.WAV' />
			<param name='rate' value='1' />
			<param name='balance' value='0' />
			<param name='currentPosition' value='0' />
			<param name='defaultFrame' value='' />
			<param name='playCount' value='1' />
			<param name='autoStart' value='-1' />
			<param name='currentMarker' value='0' />
			<param name='invokeURLs' value='-1' />
			<param name='baseURL' value='' />
			<param name='volume' value='50' />
			<param name='mute' value='0' />
			<param name='uiMode' value='full' />
			<param name='stretchToFit' value='0' />
			<param name='windowlessVideo' value='0' />
			<param name='enabled' value='-1' />
			<param name='enableContextMenu' value='-1' />
			<param name='fullScreen' value='0' />
			<param name='SAMIStyle' value='' />
			<param name='SAMILang' value='' />
			<param name='SAMIFilename' value='' />
			<param name='captioningID' value='' />
			<param name='enableErrorDialogs' value='0' />
			<param name='_cx' value='13229' />
			<param name='_cy' value='10583' />
		</object>
	</div>
</body>
</html>