<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Grade</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
	<div class="nav">
		<div class="nav-item">
			<a class="nav-index" href="index.jsp">Home</a>
			<a class="nav-index" href="login.jsp" style="margin-right: 80px;">Logout</a>
		</div>
	</div>
	<div class="container-heading">
		<h1 class="heading">Add Student Grade</h1>
	</div>
	<div class="container-grade">
	<table border="1" >
		<tr style="background-color: #fc5185; color: white">
			<th></th>
			<th>Student Name</th>
			<th>Student Number</th>
			<th>Add</th>
		</tr>
		<c:forEach items="${studentgrade}" var="studentinfo" varStatus="status" >
			<tr class="${status.count % 2 == 0 ? 'even' : 'odd' }">
				<td>${status.count }</td>
				<td>${studentinfo.student_name}</td>
				<td>${studentinfo.student_number }</td>
				<td><a href="addcourse?sid=${studentinfo.id}" style="color:blue"><i class="fas fa-plus-circle"></i></a></td>
			</tr>	
		</c:forEach>
	</table>
	</div>
		<div class="footer">
		<p>@Lintang 刘星强 L19253008</p>
	</div>
</body>
</html>