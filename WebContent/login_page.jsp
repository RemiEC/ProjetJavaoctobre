<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="CSS/style.css" rel="stylesheet" type="text/css">

<html>
<head>

<title>TODO</title>

</head>

<body>

	
	<h1>Login</h1>
	<br>
	<br>
	
	<div>
		<!-- On met table pour indiquer qu'on veut un tableau -->
		<!-- La balise tr indique une ligne du tableau, ainsi ici chaque ligne contient un label et une case input -->
		<!-- Enfin la balise td indique une cellule du tableau. Ce qu'il y a entre deux balises td est donc le contenu d'une cellule -->
		<p id="message_erreur">${message_erreur} </p>
		<form action="login" method="post"> 
			<table>		
				<tr>
					<td class="align_left"> Username : </td>
					<td> <input type="text" class="align_right" name="username" value="${username_cookie}" /> </td>
				</tr>
					
				<tr>
					<td class = "align_left"> Password : </td>
					<td> <input type="password" class="align_right" name="password" /> </td>
				</tr>		
			</table>
			<br>
			<input type="submit" value="Sign in" name="button"/>
		</form>
	</div>



</body>
</html>