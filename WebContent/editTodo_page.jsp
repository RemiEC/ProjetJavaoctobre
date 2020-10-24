<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="CSS/style.css" rel="stylesheet" type="text/css">
<html>
<head>

	<title>TODO</title>

</head>

<body>

	<h3> Edit a todo </h3>
	<br>
	<br>
	<h4> TODO number ${todo.getId()} </h4>
		<form action="editTodo" method = "post"> 
			<table>
				<tr>
				<td><label>Description: </label> </td>
				<td><input type="text" name="text_todo" value="${todo.getText()}"/></td>
				</tr>
				
				<tr>
				<td><label></label> </td>
				<td><input type="submit" value = "Save"/></td>
				</tr>
			</table>
		</form>


</body>
</html>