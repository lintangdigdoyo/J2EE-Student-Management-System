<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detail Information</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

	<div class="nav">
		<div class="nav-item">
			<a class="nav-index" href="index.jsp">Home</a>
			<a class="nav-index" href="${pageContext.request.contextPath}/studentlist">Student Information</a>
			<a class="nav-index" href="login.jsp" style="margin-right: 80px;">Logout</a>
		</div>
	</div>
	<div class="container-heading">
		<h1 class="heading">Detail Student Information</h1>
	</div>
		<%boolean profile = true; %>
			<c:forEach items="${detail}" var="studentdetail">
				<%if(profile){ %>
				<div class="container-detail">
					<img src="${studentdetail.studentpicurl }" width="120" class="detail-image" >
					<p class="detail-item"><b>Name: </b> ${studentdetail.student_name}</p> 
					<p class="detail-item"><b>Student Number: </b> ${studentdetail.student_number }</p>
					<p class="detail-item"><b>Majors: </b> ${studentdetail.majors }</p>
					<p class="detail-item"><b>Faculty: </b> ${studentdetail.faculty }</p>
				</div>
				<%profile = false; %>
				<%} %>	
			</c:forEach>
	<table border="1" class="grade-item">
		<tr style="background-color: #fc5185; color: white">
			<th></th>
			<th>Course Name</th>
			<th>Grade</th>
		</tr>
			<c:forEach items="${detail}" var="studentdetail" varStatus="status">
			<tr class="${status.count % 2 == 0 ? 'even' : 'odd' }">
				<td>${status.count }</td>
				<td>${studentdetail.course_name != null ? studentdetail.course_name : "No Course Added"}</td> 
				<td>${studentdetail.course_name != null ? studentdetail.grade : "-" }</td> 
			</tr>	
			</c:forEach>
		</table>
			
	<div class="footer">
		<p>@Lintang 刘星强 L19253008</p>
	</div>
	
</body>
</html>