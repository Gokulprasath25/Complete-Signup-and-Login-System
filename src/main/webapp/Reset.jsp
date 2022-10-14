<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>resetPassword</title>
<style>
h1 {color:Tomato;
  font-family: Georgia;
  font-size: 300%;}
  td{
    font-family :Georgia;
  }
</style>
</head>
<body>
<div align="center"><h1>ResetPassword</h1></div>
<form action=ResetServlet method=post>
<div align="center">
<table >
<tr><td>User Name :</td><td><input type="text" name="UserName" /></td></tr>
<tr><td>New Password :</td><td><input type="password" name="Password" /></td></tr>
<tr><td>Confirm Password :</td><td><input type="password" name="Password1" /></td></tr>
</table>
<br>
<input type="submit" value="SUBMIT"></input>
</div>
</form>
</body>
</html>