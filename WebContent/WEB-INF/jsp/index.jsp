<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SMVP</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h3>Welcome</h3>
<a href="welcome.html">Click here to See Welcome Message</a>. (Controller... @RequestMapping("/welcome"))
<form action="upload" enctype="multipart/form-data" method="post">
	<ul>
		<li>name:<input type="text" name="name"></li>
		<li>file:<input type="file"></li>
	</ul>
	<input value="Submit" type="submit"></input>
</form>
</body>
</html>