<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
						"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>기본 에러 화면</title>
</head>
<body bgcolor="#ffffff" text="#000000">
<!-- 타이틀 시작 -->
<table width="100%" border="1" cellspacing="0" cellpadding="0">
	<tr>
		<td align="center" bgcolor="orage"><b>기본 에러 화면입니다.</b></td>
	</tr>
</table>
	
<!-- 에러 메세지 -->
<table width="100%" border="1" cellspacing="0" cellpadding="0" align="center">
	<tr>
		<td align="center">
			<br><br><br><br><br>
			Message: ${exception.message}
			<br><br><br><br><br>
		</td>
	</tr>
</table>
</body>
</html>