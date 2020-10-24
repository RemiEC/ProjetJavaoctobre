<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="CSS/style.css" rel="stylesheet" type="text/css">
<html>
<head>

<title>TODO</title>

</head>

<body>

<a href = "logout">Logout</a>
<br>

<h1>Welcome ${sessionScope.username_session}</h1>
<br>

<c:if test = "${sessionScope.admin_bool_session == true}">
	<form action="userPage" method="post">
	<input type="text" name="text_todo"/>
	<input type="submit" value="Add Todo" name="Add_todo_button"/>
	</form>
</c:if>

<br>

<h3>You can find the latest version of the Todo list</h3>
<br>

<c:forEach var = "temp_todo" items="${list_todo}">
	
	<c:url var="EditLink" value= "editTodo">
		<c:param name="TodoId" value="${temp_todo.id}"/>
	</c:url>
	
	<c:url var="DeleteLink" value= "DeleteTodo">
		<c:param name="TodoId" value="${temp_todo.id}"/>
	</c:url>
	
	<ul>	
		<li>
			<div>
			<h4> ${temp_todo.id} </h4>
			<p> ${temp_todo.text}</p>
			<br>
			<c:if test = "${sessionScope.admin_bool_session == true}">
				<p><a href = "${EditLink}">Edit</a> | <a href="${DeleteLink}">Delete</a></p>
			</c:if>
			</div>
		</li>
		
	</ul>
	<br>
	<br>
	<br>
</c:forEach>
	

</body>
</html>