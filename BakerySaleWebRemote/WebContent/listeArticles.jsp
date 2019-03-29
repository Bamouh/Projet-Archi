<%@page import="ma.BamouhBakery.bakeryShop.persistance.Article"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<title>Client BakerySale Local</title>
</head>
<body>

	<div class="container container-fluid ">
		<div class="panel panel-default spacer">
			<div class="panel-heading">Ajouter un Article</div>
			<div class="panel-body">
				<form action="enregistrer" method="get">
					<div class="form-group">
						<label>Libellé</label> <input class="form-control" name="libelle"
							required /><br> <label>Prix</label> <input
							class="form-control" name="prix" required /><br> <input
							class="btn btn-success" type="submit" value="Ok">
					</div>
				</form>

			</div>
		</div>
	</div>
	<div class="container container-fluid ">
		<div class="panel panel-primary spacer">
			<div class="panel-heading">Liste des Articles</div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Libellé</th>
						<th>Prix</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="article" items="${ listeArticles }">
					<tr>
						<td><c:out value="${ article.numeroArticle }"/></td>
						<td><c:out value="${ article.libelle }"/></td>
						<td><c:out value="${ article.prix }"/></td>
						<td>
							<form action="supprimer" method="get">
								<input class="btn btn-warning" type="submit" value="Supprimer">
								<input type="hidden" name="idArticle" value="${ article.numeroArticle }" />
							</form></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</div>

</body>
</html></html>