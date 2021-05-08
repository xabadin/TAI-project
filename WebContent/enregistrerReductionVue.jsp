<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enregistrer une reduction</title>
</head>
<body>
	<h1>Définir une réduction en fonction de la quantité</h1>
	
	<form action="RechercheArticleControleur" method="post">
		<fieldset>
		Nom du produit : <select name="designation">
			<c:forEach items="${produitListe}" var="produit">
				<option><c:out value="${produit.designation}"/></option>
			</c:forEach>
		</select>
		</fieldset>
	</form>
		<fieldset>
	 		<table class='tableau'>
	   			<tr>
	    			<th>Min</th>
	    			<th>Max</th>
	    			<th>Réduction (en %)</th>
	   			</tr>
				<tr>
	    			<td><input type='text' name='1'/></td>
	    			<td><input type='text' name='2'/></td>
	    			<td><input type='text' name='3'/></td>
	  			</tr>
	  			<tr>
	    			<td><input type='text' name='4'/></td>
	    			<td><input type='text' name='5'/></td>
	    			<td><input type='text' name='6'/></td>
	  			</tr>
	  			<tr>
	    			<td><input type='text' name='7'/></td>
	    			<td><input type='text' name='8'/></td>
	    			<td><input type='text' name='9'/></td>
	  			</tr>
	  			<tr>
	    			<td><input type='text' name='10'/></td>
	    			<td><input type='text' name='11'/></td>
	    			<td><input type='text' name='12'/></td>
	  			</tr>
	  			<tr>
	    			<td><input type='text' name='13'/></td>
	    			<td><input type='text' name='14'/></td>
	    			<td><input type='text' name='15'/></td>
	  			</tr>
			</table>
		</fieldset>
	<input type="submit" />
</body>
</html>