<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<font color="red"> ${errPassMissmatch}</font>
		<form:form action="loginSubmit.do" commandName="login" method="POST">
			<table bgcolor="#aed6f1">
				<tr>
					<td colspan="2" align="center"><h2>Enter Credentials</h2></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" /></td>
					<td><font color="red"><form:errors path="email" /></font></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" /></td>
					<td><font color="red"><form:errors path="password" /></font></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Login"></td>
				</tr>
			</table>
		</form:form>
	</center>

</body>
</html>