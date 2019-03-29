<%@page import="ma.BamouhBakery.bakeryShop.persistance.LigneDeCommande"%>
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
<title>Client ShoppingCarte Remote</title>
</head>
<body>
	<div class="container container-fluid ">
		<div class="panel panel-default spacer">
			<div class="panel-heading">Ajouter une Ligne De Commande</div>
			<div class="panel-body">
				<form action="enregistrer" method="get">
					<div class="form-group">
						<label>Article</label> <select name="idArticle" required>
							<option value=""></option>
							<c:forEach var="article" items="${ allArticles }">
								<option value="${ article.numeroArticle }">
									<c:out value="${ article.libelle }"/>
								</option>
							</c:forEach>
						</select>
					</div>

					<div class="panel-group">
						<label class="control-label">Quantité</label> <input
							pattern="^[0-9]*" class="form-control" type="text"
							name="quantite" required="required"><br>
					</div>
					<input class="btn btn-success" type="submit" value="Ok">
				</form>
				</form>
			</div>
		</div>
	</div>
	<div class="container container-fluid ">
		<div class="panel panel-primary spacer">
			<div class="panel-heading">Liste des Lignes de commande</div>
			<div class="panel-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Article</th>
							<th>Prix Article</th>
							<th>Quantité Commandée</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="ligne" items="${ listeLigneCommande }">
							<tr>
								<td><c:out value="${ ligne.article.libelle }" />
								</td>
								<td><c:out value="${ ligne.article.prix }" />
								</td>
								<td><c:out value="${ ligne.quantite }" />
								</td>
								<td>
									<form action="supprimer" method="get">
										<input class="btn btn-warning" type="submit" value="Supprimer">
										<input type="hidden" name="idLigne"
											value="${ ligne.identifiant }" />
										<input type="hidden" name="quantity"
											value="${ ligne.quantite }" />
										<input type="hidden" name="idArticle2"
											value="${ ligne.article.numeroArticle }" />
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<form action="valider" method="get">
					<input class="btn btn-success" type="submit" value="Valider Commande">
				</form>
			</div>
		</div>
	</div>
</body>
</html>