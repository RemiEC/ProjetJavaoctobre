<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="CSS/style-user.css" rel="stylesheet" type="text/css">
<html>
<head>

<title>TODO</title>

</head>

<body>
<header>

Welcome ${sessionScope.username_session}
<a href = "logout">Click to logout</a>

</header>
<br>
<br>
<br>
<c:if test = "${sessionScope.admin_bool_session == true}">
	<form action="userPage" method="post">
	<textarea name="text_todo"></textarea>
	<input type="submit" value="Add Todo" name="Add_todo_button"/>
	</form>
</c:if>

<br>

<h3>You can find the latest version of the Todo list</h3>
<br>

<c:forEach var = "temp_todo" items="${list_todo}">
<div class="Todo_Block">
	
	<c:url var="EditLink" value= "editTodo">
		<c:param name="TodoId" value="${temp_todo.id}"/>
	</c:url>
	
	<c:url var="DeleteLink" value= "DeleteTodo">
		<c:param name="TodoId" value="${temp_todo.id}"/>
	</c:url>
	
			
			<h4> ${temp_todo.id} </h4>
			 ${temp_todo.text}
			<br>
			<div class="Todo_lien">
			<c:if test = "${sessionScope.admin_bool_session == true}">
				<p><a href = "${EditLink}">Edit</a> | <a href="${DeleteLink}">Delete</a></p>
			</c:if>
			</div>
		
	</div>
</c:forEach>


</body>
</html>