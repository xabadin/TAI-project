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
  </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enregistrer nouveau client</title>
</head>
<body>
	<p>Enregistrer un nouveau client</p>
	
	<form action="EnregistrerClientControleur" method="post">
		<fieldset>
			Nom du client : <input type="text" name="nom" /> <br />
			Société : <input type="text" name="societe" /> <br />
			Adresse : <input type="text" name="adresse" /> <br />
			Code Postal : <input type="text" name="code_postal" /> <br />
			Numéro de téléphone : <input type="text" name="telephone" /> <br />
			Remise (en %) : <input type="text" name="reduc" /> <br />
		</fieldset>
		
		<input type="submit" />
		
	</form>
	
	<c:out value="${validation}" /> <br>
	
</body>
</html>