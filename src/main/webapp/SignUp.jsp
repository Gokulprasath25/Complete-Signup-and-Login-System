<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp</title>
<style>
h1 {color:MediumSeaGreen;
  font-family: Georgia;
  font-size: 300%;}
  td{
    font-family :Georgia;
  }
</style>
</head>
<body>
<div align="center"><h1>SignUp</h1></div>
<form action=SignUpServlet method=post>
<div align="center">
<table >
<tr><td>Name :</td><td><input type="text" name="Name" /></td></tr>
<tr><td>UserName :</td><td><input type="text" name="UserName" /></td></tr>
<tr><td>Password :</td><td><input type="password" name="Password" /></td></tr>
<tr><td>Confirm Password :</td><td><input type="password" name="Password1" /></td></tr>
</table>
<br>
<input type="submit" value="SUBMIT"></input>
</div>
</form>
</body>
</html>