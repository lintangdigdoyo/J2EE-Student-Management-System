<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Input Course</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
	<div class="nav">
		<div class="nav-item">
			<a class="nav-index" href="${pageContext.request.contextPath}/index.jsp">Home</a>
			<a class="nav-index" href="login.jsp" style="margin-right: 80px;">Logout</a>
		</div>
	</div>
	
	<div class="container-heading">
		<h1 class="heading">Input New Course</h1>
	</div>
	
	<form class="input-form" action="${pageContext.request.contextPath}/inputnewcourse" method="post" enctype="multipart/form-data">
		<div class="input-container">
			<label class="label">Course Name</label>
			<input type="text" class="input-item input-name" name="course_name" size="50"></input>
		</div>
		
		<div class="edit-submit"> 
			<div class="submit-cancel" style="margin-left: 40%;">
				<input type="button" onclick="window.location.href='${pageContext.request.contextPath}/index.jsp'" class="button btn-cancel input-button" value="Cancel Input" style="margin-top: 20px;margin-left: 57%;margin-right: auto">
			</div>
			<div class="submit-save">
				<input type="submit" class="button btn-save input-button" value="Submit Input" style="margin-top: 20px;margin-left: 57%;margin-right: auto;">
			</div>
		</div>
	</form>
	
	<div class="footer">
		<p>@Lintang 刘星强 L19253008</p>
	</div>
</body>
</html>