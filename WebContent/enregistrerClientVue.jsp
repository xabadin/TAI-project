<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<style>
    p { 
	font-size: 200%;
	text-align: left;
	margin-top: 10px;
	font-family: Calibri, Helvetica, sans-serif
	 }
	fieldset {	font-size: 100%;
	font-family: Calibri, Helvetica, sans-serif
	}
	a{font-family: Calibri, Helvetica, sans-serif;
	padding: 0 5px;
	}
	label{
	display: block;
	width: 200px;
	float: left;
}
input {
    margin: .4rem;
}
  </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enregistrer nouveau client</title>
</head>
<body>
<fieldset>
	<a href="RechercheArticleControleur">Montrer les données d'un produit</a>	
	<a href="EnregistrerClientControleur">Créer un new client</a>
	<a href="EnregistrerReductionControleur">Créer une nouvelle reduction</a>
	<a href="EnregistrerVenteControleur">Créer une nouvelle commande</a> <br />
	</fieldset>
	<p>Enregistrer un nouveau client</p>
	
	<form action="EnregistrerClientControleur" method="post">
		<fieldset>
			<label for="nom du client">Nom du client :</label><input type="text" name="nom" /> <br />
			<label for="société">Société :</label> <input type="text" name="societe" /> <br />
			<label for="adresse">Adresse :</label> <input type="text" name="adresse" /> <br />
			<label for="code postal">Code Postal :</label> <input type="text" name="code_postal" /> <br />
			<label for="numéro de téléphone">Numéro de téléphone :</label><input type="text" name="telephone" /> <br />
			<label for="remise (en%)">Remise (en %) :</label><input type="text" name="reduc" /> <br />
		</fieldset>
		
		<input type="submit" />
		
	</form>
	
	<c:out value="${validation}" /> <br>
	
</body>
</html>