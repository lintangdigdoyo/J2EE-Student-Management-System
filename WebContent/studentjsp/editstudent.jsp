<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Student Information</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
	
	<div class="nav">
		<div class="nav-item">
			<a class="nav-index" href="index.jsp">Home</a>
			<a class="nav-index" href="${pageContext.request.contextPath}/managestudent">Manage Student</a>
			<a class="nav-index" href="login.jsp" style="margin-right: 80px;">Logout</a>
		</div>
	</div>
	<div class="container-heading">
		<h1 class="heading">Update Student Information</h1>
	</div>
		<form action="${pageContext.request.contextPath}/savestudentupdate" method="post" enctype="multipart/form-data">
		<%boolean profile = true; %>
			<c:forEach items="${detail}" var="studentdetail">
				<%if(profile){ %>
				<div class="container-detail">
					<img src="${studentdetail.studentpicurl }" width="120" class="detail-image" >
					<p class="detail-item"><b>Name: </b><input type="text" name="student_name" value="${studentdetail.student_name}" class="input-edit"></p> 
					<p class="detail-item"><b>Student Number: </b><input type="text" name="student_number" value="${studentdetail.student_number }" class="input-edit"> </p>
					<p class="detail-item"><b>Majors: </b><input type="text" name="majors" value="${studentdetail.majors }" class="input-edit"> </p>
					<p class="detail-item"><b>Faculty: </b><input type="text" name="faculty" value="${studentdetail.faculty }" class="input-edit"> </p>
					<p><input type="file" class="input-item" name="image" style="margin-top: 30px;"></p>
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
					<input type="hidden" name="cidLength" value="${status.count }">
					<td><input type="hidden" name="cid${status.count}" value="${studentdetail.course_id }" >${status.count }</td>
					<td>${studentdetail.course_name != null ? studentdetail.course_name : "No Course Added" }</td> 
					<td><input type="text" name="grade${status.count}" value="${studentdetail.grade }" ></td> 
				</tr>	
				</c:forEach>
			</table>
		
		<%boolean studentid = true; %>
		<input type="hidden" name="sid" 
			value=
			<%if(studentid){ %>
			<c:forEach items="${detail}" var="student_id" varStatus="status">
				${student_id.sid}
				<%studentid = false; %>
			</c:forEach>
		<%} %> />
		
		<div class="edit-submit"> 
			<div class="submit-cancel">
				<input type="button" onclick="window.location.href='${pageContext.request.contextPath}/managestudent'" class="button btn-cancel input-button" value="Cancel Update" style="margin-top: 20px;margin-left: 57%;margin-right: auto">
			</div>
			<div class="submit-save">
				<input type="submit" class="button btn-save input-button" value="Save Update" style="margin-top: 20px;margin-left: 57%;margin-right: auto;">
			</div>
		</div>
		</form>
	<div class="footer">
		<p>@Lintang 刘星强 L19253008</p>
	</div>
	
</body>
</html>