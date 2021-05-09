<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	</style>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="">
		<fieldset>
			<legend>Login</legend>
			<label for="email">E-Mail</label>
			<input type="text" name="email">
			<label for="motdepasse">Mot de Passe</label>
			<input type="text" name="motdepasse">
		</fieldset>
	</form>
	<button onclick="window.location.href = 'https://fr.w3docs.com/';">Connexion</button> <br />
	
	<a href="RechercheArticleControleur">Montrer les données d'un produit</a> <br />
	<a href="EnregistrerClientControleur">Créer un new client</a> <br />
	<a href="EnregistrerReductionControleur">Créer une nouvelle reduction</a> <br />
	<a href="EnregistrerVenteControleur">Créer une nouvelle commande</a> <br />
</body>
</html>
