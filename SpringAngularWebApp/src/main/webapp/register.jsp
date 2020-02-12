<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<font color="red"> ${errMessage}</font>
		<h2>Please Enter Details !</h2>
		<form:form action="registerSubmit.do" commandName="registerTo"
			modelAttribute="registerTo" method="POST">
			<table bgcolor="#aed6f1">
				<tr bgcolor=" #d0ece7 ">
					<td>Name:</td>
					<td><form:input path="name" /></td>
					<td><font color="red"><form:errors path="name" /></font></td>
				</tr>
				<tr bgcolor=" #d0ece7 ">
					<td>Email:</td>
					<td><form:input path="email" /></td>
					<td><font color="red"><form:errors path="email" /></font></td>
				</tr>
				<tr bgcolor=" #d0ece7 ">
					<td>Password:</td>
					<td><form:password path="password" /></td>
					<td><font color="red"><form:errors path="password" /></font></td>

				</tr>
				<tr bgcolor=" #d0ece7 ">
					<td>Confirm Password:</td>
					<td><form:password path="confirmPassword" /></td>
					<td><font color="red"><form:errors
								path="confirmPassword" /></font></td>
				</tr>
				<tr>
					<td colspan="2" align="center" bgcolor="#d0ece7"><input
						type="submit" value="Register"></td>
				</tr>
				<tr>
					<td colspan="2" align="center" bgcolor="#FF0000"><a
						href="<c:url value = "login.do"/>">Got Account? Click to Login
							!</a></td>
				</tr>

			</table>
		</form:form>
	</center>
</body>
</html>