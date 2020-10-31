<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="CSS/style-edit.css" rel="stylesheet" type="text/css">
<html>
<head>

	<title>TODO</title>

</head>

<header>

Welcome ${sessionScope.username_session}
<a href = "logout">Click to logout</a>

</header>
<br>
<br>
<br>
<body>

	<h2> Edit Todo number ${todo.getId()} </h2>
	<br>
	<br>
	<label>Description: </label>
	<br>
	<br>
		<form action="editTodo" method = "post"> 
				 
				<textarea name="text_todo">${todo.getText()}</textarea>
				<input type="submit" value = "Save"/>
		</form>


</body>
</html>