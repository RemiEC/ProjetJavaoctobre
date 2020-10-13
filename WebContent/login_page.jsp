<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>

<title>TODO</title>

</head>

<body>

	<div>
		<h1>Login</h1>
	</div>
	
	<div>
		<!-- On met table pour indiquer qu'on veut un tableau -->
		<!-- La balise tr indique une ligne du tableau, ainsi ici chaque ligne contient un label et une case input -->
		<!-- Enfin la balise td indique une cellule du tableau. Ce qu'il y a entre deux balises td est donc le contenu d'une cellule -->
		<form action="login" method="post"> 
			<table>
				<tr>
					<td> </td>
					<td> <span style=color:red> ${message_erreur} </span> </td>
				</tr>
				
				<tr>
					<td> Username : </td>
					<td> <input type="text" name="username" /> </td>
				</tr>
					
				<tr>
					<td> Password : </td>
					<td> <input type="password" name="password" /> </td>
				</tr>
	
				<tr>
					<td> </td>
					<td> <input type="submit" value="Sign in" name="button"/> </td>
				</tr>
			</table>
		</form>
	</div>



</body>
</html>