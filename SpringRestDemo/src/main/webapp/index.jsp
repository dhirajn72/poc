<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Result of request</h1>
	<br>
	<c:if test="${STUD ne null }">
    Id:${STUD.sid }<br>
    Name:${STUD.sname }<br>
    Email:${STUD.email }<br>
    Phone:${STUD.phone }<br>
	</c:if>
	<c:if test="${ADDED ne null }">${ADDD }</c:if>

	<c:if test="${LIST ne null }">
		<table border="2" width="75%">
			<tr bgcolor="lightgreen">
				<td>SID</td>
				<td>NAME</td>
				<td>EMAIL</td>
				<td>PHONE</td>
			</tr>
			<c:forEach items="${LIST.studentTos }" var="st">
				<tr>
					<td>${st.sid }</td>
					<td>${st.sname }</td>
					<td>${st.email }</td>
					<td>${st.phone}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>