<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enregistrer une nouvelle vente</title>
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
</head>
<body>
	<fieldset>
	<a href="RechercheArticleControleur">Montrer les données d'un produit</a>	
	<a href="EnregistrerClientControleur">Créer un new client</a>
	<a href="EnregistrerReductionControleur">Créer une nouvelle reduction</a>
	<a href="EnregistrerVenteControleur">Créer une nouvelle commande</a> <br />
	</fieldset>
	
	<p>Renseigner une nouvelle commande</p>
	
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
					<td><input type='text' name='prix1'/></td>
	    			<td><input type='text' name='quantite1'/></td>
	    			<td><input type='text' name='prixTot1'/></td>
	    			<td><input type='text' name='reduc1'/></td>
	    			<td><input type='text' name='prixReduc1'/></td>
	  			</tr>
	  			<tr>
	    			<td>
	    				<select name="produit">
							<c:forEach items="${produitListe}" var="produit">
								<option><c:out value="${produit.designation}"/></option>
							</c:forEach>
						</select>
					</td>
					<td><input type='text' name='prix2'/></td>
	    			<td><input type='text' name='quantite2'/></td>
	    			<td><input type='text' name='prixTot2'/></td>
	    			<td><input type='text' name='reduc2'/></td>
	    			<td><input type='text' name='prixReduc2'/></td>
	  			</tr>
	  			<tr>
	    			<td>
	    				<select name="produit">
							<c:forEach items="${produitListe}" var="produit">
								<option><c:out value="${produit.designation}"/></option>
							</c:forEach>
						</select>
					</td>
					<td><input type='text' name='prix3'/></td>
	    			<td><input type='text' name='quantite3'/></td>
	    			<td><input type='text' name='prixTot3'/></td>
	    			<td><input type='text' name='reduc3'/></td>
	    			<td><input type='text' name='prixReduc3'/></td>
	  			</tr>
	  			<tr>
	    			<td>
	    				<select name="produit">
							<c:forEach items="${produitListe}" var="produit">
								<option><c:out value="${produit.designation}"/></option>
							</c:forEach>
						</select>
					</td>
					<td><input type='text' name='prix4'/></td>
	    			<td><input type='text' name='quantite4'/></td>
	    			<td><input type='text' name='prixTot4'/></td>
	    			<td><input type='text' name='reduc4'/></td>
	    			<td><input type='text' name='prixReduc4'/></td>
	  			</tr>
	  			<tr>
	    			<td>
	    				<select name="produit">
							<c:forEach items="${produitListe}" var="produit">
								<option><c:out value="${produit.designation}"/></option>
							</c:forEach>
						</select>
					</td>
					<td><input type='text' name='prix5'/></td>
	    			<td><input type='text' name='quantite5'/></td>
	    			<td><input type='text' name='prixTot5'/></td>
	    			<td><input type='text' name='reduc5'/></td>
	    			<td><input type='text' name='prixReduc5'/></td>
	  			</tr>
			</table>
			
		</fieldset>
		<input type="submit" />	
	</form>
</body>
</html>