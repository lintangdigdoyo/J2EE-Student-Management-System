<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to 南京晓庄学院  Student Management System</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	
	<div class="nav">
		<div class="nav-item">
			<a class="nav-index" href="#" style="margin-right: 80px;">Login</a>
		</div>
	</div>
	<div class="container-background">
		<div class="layer"> 
			<h1 class="heading-index">南京晓庄学院  <br> Student Management System</h1>
		</div>
	</div>
	<div class="container-item">
			<div class="login-page">
				<div align="center">
  					<h1>Login</h1>
  					<form action="LoginServlet" method="post" enctype="multipart/form-data">
   						<table style="with: 100%">
    						<tr>
    							<td>
    								<div class="input-login-container">
    								<i class="far fa-user login-icon"></i>
    								<input type="text" name="username" placeholder="Username" class="input-login" style="padding-right: 4%;"/>
    								</div>
    							</td>
    						</tr>
    						<tr>
    							<td>
    								<div class="input-login-container">
    								<i class="fas fa-key login-icon"></i>
     								<input type="password" name="password" placeholder="Password" class="input-login" />
     								</div>
     							</td>
    						</tr>
   						</table>
   						<input type="submit" class="btn-login" value="Login"/>
  					</form>
 				</div>
			</div>
	</div>
	<div class="footer footer-index">
		<p>© Lintang 刘星强 L19253008</p>
	</div>
	
	
</body>
</html>