<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recherche sur un article</title>
</head>
<body>
	<h1>Recherche sur un article</h1>
	
	<form action="RechercheArticleControleur" method="post">
		<fieldset>
		Nom du produit : <select name="designation">
			<c:forEach items="${produitListe}" var="produit">
				<option><c:out value="${produit.designation}"/></option>
			</c:forEach>
		</select>
		</fieldset>
		<input type="submit" />
		
		<fieldset>
			<ul>
				<li><c:out value="${produit.id}" /></li>
				<li><c:out value="${produit.designation}" /></li>
				<li><c:out value="${produit.prix}" /></li>
			</ul>
		</fieldset>
		
	</form>
	
</body>
</html>