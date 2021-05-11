<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<style type="text/css">
	input {
	  display:grid;
	  place:items:center;
	}
	button {
		background-color: #e7e7e7;
		color: black;
	}
	div {
		margin-top:150px;
		margin-bottom:50px;
  		text-align: center;
	}
	</style>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div>
		<img src="image/logo.jpg">
	</div>
	<form action="LoginControleur" method="post">
		<fieldset>
			<legend>Login</legend>
			<label for="nom_utilisateur">Identifiant</label>
			<input type="text" name="identifiant">
			<label for="mdp">Mot de Passe</label>
			<input type="password" name="mdp">
		</fieldset>
		<input type="submit" value="Connexion"/> <br />
		<c:out value="${validation}" /> <br>
	</form>
	
</body>
</html>
