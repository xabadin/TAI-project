<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enregistrer une nouvelle vente</title>
</head>
<body>
	<h1>Renseigner une nouvelle commande</h1>
	
	<form action="EnregistrerVenteControleur" method="post">
		<fieldset>
		Client : <select name="client">
			<c:forEach items="${clientListe}" var="client">
				<option><c:out value="${client.nom}"/></option>
			</c:forEach>
		</select>
		Commande N° : <c:out value="${numCommande}" /> <br>
		
		<table class='tableau'>
	   			<tr>
	    			<th>Nom du produit</th>
	    			<th>Prix unitaire</th>
	    			<th>Quantité</th>
	    			<th>Prix Total</th>
	    			<th>Remise</th>
	    			<th>Prix avec remise</th>
	   			</tr>
				<tr>
	    			<td>
	    				<select name="produit">
							<c:forEach items="${produitListe}" var="produit">
								<option><c:out value="${produit.designation}"/></option>
							</c:forEach>
						</select>
					</td>
	    			<td><input type='text' name='max1'/></td>
	    			<td><input type='text' name='reduc1'/></td>
	  			</tr>
	  			<tr>
	    			<td>
	    				<select name="produit">
							<c:forEach items="${produitListe}" var="produit">
								<option><c:out value="${produit.designation}"/></option>
							</c:forEach>
						</select>
					</td>
	    			<td><input type='text' name='max2'/></td>
	    			<td><input type='text' name='reduc2'/></td>
	  			</tr>
	  			<tr>
	    			<td>
	    				<select name="produit">
							<c:forEach items="${produitListe}" var="produit">
								<option><c:out value="${produit.designation}"/></option>
							</c:forEach>
						</select>
					</td>
	    			<td><input type='text' name='max3'/></td>
	    			<td><input type='text' name='reduc3'/></td>
	  			</tr>
	  			<tr>
	    			<td>
	    				<select name="produit">
							<c:forEach items="${produitListe}" var="produit">
								<option><c:out value="${produit.designation}"/></option>
							</c:forEach>
						</select>
					</td>
	    			<td><input type='text' name='max4'/></td>
	    			<td><input type='text' name='reduc4'/></td>
	  			</tr>
	  			<tr>
	    			<td>
	    				<select name="produit">
							<c:forEach items="${produitListe}" var="produit">
								<option><c:out value="${produit.designation}"/></option>
							</c:forEach>
						</select>
					</td>
	    			<td><input type='text' name='max5'/></td>
	    			<td><input type='text' name='reduc5'/></td>
	  			</tr>
			</table>
			
		</fieldset>
		<input type="submit" />	
	</form>
</body>
</html>