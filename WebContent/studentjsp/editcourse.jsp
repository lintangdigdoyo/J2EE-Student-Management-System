<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Course Name</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

	<div class="nav">
		<div class="nav-item">
			<a class="nav-index" href="index.jsp">Home</a>
			<a class="nav-index" href="${pageContext.request.contextPath}/showallcourse">Update Course</a>
			<a class="nav-index" href="login.jsp" style="margin-right: 80px;">Logout</a>
		</div>
	</div>
	
	<div class="container-heading">
		<h1 class="heading">Update Course Name</h1>
	</div>
	<form action="${pageContext.request.contextPath}/savecourseupdate" method="post" enctype="multipart/form-data">
		<div class="container-course">
			<p><b>Course Name:</b> <input type="text" name="course_name" value="${detailcourse.course_name }" class="input-edit " style="font-size:20px"></p>
			<input type="hidden" value="${detailcourse.id }" name="cid">
			<div class="edit-submit"> 
			<div class="submit-cancel" style="margin-left: 6%;">
				<input type="button" onclick="window.location.href='${pageContext.request.contextPath}/showallcourse'" class="button btn-cancel input-button" value="Cancel Update" style="margin-top: 20px;margin-left: 57%;margin-right: auto">
			</div>
			<div class="submit-save">
				<input type="submit" class="button btn-save input-button" value="Save Update" style="margin-top: 20px;margin-left: 57%;margin-right: auto;">
			</div>
			</div>
		
		</div>
	</form>
	
	<div class="footer">
		<p>@Lintang 刘星强 L19253008</p>
	</div> 

</body>
</html>