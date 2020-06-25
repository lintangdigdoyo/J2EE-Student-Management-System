<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Management System</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	
	<div class="nav">
		<div class="nav-item">
			<a class="nav-index" href="index.jsp">Home</a>
			<a class="nav-index" href="login.jsp" style="margin-right: 80px;">Logout</a>
		</div>
	</div>
	<div class="container-background">
		<div class="layer"> 
			<h1 class="heading-index">南京晓庄学院  <br> Student Management System</h1>
		</div>
	</div>
	<div class="container-item">
		<a href="studentlist" class="link">
			<div class="item">
				<i class="fas fa-users"></i> Show Student List
			</div>
		</a>
		<a href="managestudent"  class="link">
			<div class="item">
				<i class="fas fa-user-cog"></i> Manage Student
			</div>
		</a>
		<a href="showallcourse"  class="link">
			<div class="item">
				<i class="fas fa-book-reader"></i> Manage Course
			</div>
		</a>
		<br><br>
		<a href="showgrade" class="link">
			<div class="item">
				<i class="far fa-list-alt"></i> Add Student Grade
			</div>
		</a>
		<a href="studentjsp/inputnewcourse.jsp" class="link">
			<div class="item">
				<i class="fas fa-file-medical"></i> Add New Course
			</div>
		</a>
		<a href="studentjsp/inputstudent.jsp" class="link">
			<div class="item">
				<i class="fas fa-user-plus"></i> Add New Student
			</div>
		</a>
	</div>
	<div class="footer footer-index">
		<p>© Lintang 刘星强 L19253008</p>
	</div>
</body>
</html>