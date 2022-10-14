<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
h1 {color:dodgerblue;
  font-family: Georgia;
  font-size: 300%;}
</style>
</head>
<body>
<div align="center"><h1>User login</h1></div>
<form action=LoginServlet method=post>
<div align="center">
<table>
<tr><td>User Name:</td><td><input type=text name=txtName></td></tr>
<tr><td>password:</td><td><input type=password name=txtpwd></td></tr>
<tr><td><input type=submit value=Login></td><td><a href=Reset.jsp>ForgotPassword</a></td></tr>
</table>
</div>
<div align="center"><p>New user? <a href=SignUp.jsp> SignUp</a> now.</p></div>
</form>

</body>
</html>