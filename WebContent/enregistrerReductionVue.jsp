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
	 th {	font-size: 100%;
	font-family: Calibri, Helvetica, sans-serif
	}
	fieldset {	font-size: 100%;
	font-family: Calibri, Helvetica, sans-serif
	}
	a{font-family: Calibri, Helvetica, sans-serif;
	padding: 0 5px;
	}
  </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enregistrer une reduction</title>
</head>
<body>
<fieldset>
	<a href="RechercheArticleControleur">Montrer les données d'un produit</a>	
	<a href="EnregistrerClientControleur">Créer un new client</a>
	<a href="EnregistrerReductionControleur">Créer une nouvelle reduction</a>
	<a href="EnregistrerVenteControleur">Créer une nouvelle commande</a> <br />
	</fieldset>
	<p>Définir une réduction en fonction de la quantité</p>
	
	<form action="EnregistrerReductionControleur" method="post">
		<fieldset>
		Nom du produit : <select name="designation">
			<c:forEach items="${produitListe}" var="produit">
				<option><c:out value="${produit.designation}"/></option>
			</c:forEach>
		</select>
		</fieldset>
	
		<fieldset>
	 		<table class='tableau'>
	   			<tr>
	    			<th>Min</th>
	    			<th>Max</th>
	    			<th>Réduction (en %)</th>
	   			</tr>
				<tr>
	    			<td><input type='text' name='min1'/></td>
	    			<td><input type='text' name='max1'/></td>
	    			<td><input type='text' name='reduc1'/></td>
	  			</tr>
	  			<tr>
	    			<td><input type='text' name='min2'/></td>
	    			<td><input type='text' name='max2'/></td>
	    			<td><input type='text' name='reduc2'/></td>
	  			</tr>
	  			<tr>
	    			<td><input type='text' name='min3'/></td>
	    			<td><input type='text' name='max3'/></td>
	    			<td><input type='text' name='reduc3'/></td>
	  			</tr>
	  			<tr>
	    			<td><input type='text' name='min4'/></td>
	    			<td><input type='text' name='max4'/></td>
	    			<td><input type='text' name='reduc4'/></td>
	  			</tr>
	  			<tr>
	    			<td><input type='text' name='min5'/></td>
	    			<td><input type='text' name='max5'/></td>
	    			<td><input type='text' name='reduc5'/></td>
	  			</tr>
			</table>
		</fieldset>
		<input type="submit" />
	</form>
	<c:out value="${validation}" /> <br>
</body>
</html>