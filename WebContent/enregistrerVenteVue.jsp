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
	    				<select name="designation1">
							<c:forEach items="${produitListe}" var="produit">
								<option><c:out value="${produit.designation}"/></option>
							</c:forEach>
						</select>
					</td>
					<td><c:out value="${prix1}" /></td>
	    			<td><input type='number' name='quantite1'/></td>
	    			<td><c:out value="${prixTot1}" /></td>
	    			<td><c:out value="${reducProduit1}" /></td>
	    			<td><c:out value="${prixReduc1}" /></td>
	  			</tr>
	  			<tr>
	    			<td>
	    				<select name="designation2">
							<c:forEach items="${produitListe}" var="produit">
								<option><c:out value="${produit.designation}"/></option>
							</c:forEach>
						</select>
					</td>
					<td><c:out value="${prix2}" /></td>
	    			<td><input type='number' name='quantite2'/></td>
	    			<td><c:out value="${prixTot2}" /></td>
	    			<td><c:out value="${reducProduit2}" /></td>
	    			<td><c:out value="${prixReduc2}" /></td>
	  			</tr>
	  			<tr>
	    			<td>
	    				<select name="designation3">
							<c:forEach items="${produitListe}" var="produit">
								<option><c:out value="${produit.designation}"/></option>
							</c:forEach>
						</select>
					</td>
					<td><c:out value="${prix3}" /></td>
	    			<td><input type='number' name='quantite3'/></td>
	    			<td><c:out value="${prixTot3}" /></td>
	    			<td><c:out value="${reducProduit3}" /></td>
	    			<td><c:out value="${prixReduc3}" /></td>
	  			</tr>
	  			<tr>
	    			<td>
	    				<select name="designation4">
							<c:forEach items="${produitListe}" var="produit">
								<option><c:out value="${produit.designation}"/></option>
							</c:forEach>
						</select>
					</td>
					<td><c:out value="${prix4}" /></td>
	    			<td><input type='number' name='quantite4'/></td>
	    			<td><c:out value="${prixTot4}" /></td>
	    			<td><c:out value="${reducProduit4}" /></td>
	    			<td><c:out value="${prixReduc4}" /></td>
	  			</tr>
	  			<tr>
	    			<td>
	    				<select name="designation5">
							<c:forEach items="${produitListe}" var="produit">
								<option><c:out value="${produit.designation}"/></option>
							</c:forEach>
						</select>
					</td>
					<td><c:out value="${prix5}" /></td>
	    			<td><input type='number' name='quantite5'/></td>
	    			<td><c:out value="${prixTot5}" /></td>
	    			<td><c:out value="${reducProduit5}" /></td>
	    			<td><c:out value="${prixReduc5}" /></td>
	  			</tr>
			</table>
			
			Prix total de la commande sans remise : <c:out value="${prixCommande}" /> <br>
			Prix total de la commande avec remise : <c:out value="${prixCommandeReduc}" /> <br>
		</fieldset>
		
		<input type="submit" value="Créer commande"/>	
		
		<c:out value="${validation}" />
	</form>
</body>
</html>