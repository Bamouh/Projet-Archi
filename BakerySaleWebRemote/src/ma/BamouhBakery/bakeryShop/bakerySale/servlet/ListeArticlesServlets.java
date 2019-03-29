package ma.BamouhBakery.bakeryShop.bakerySale.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.BamouhBakery.bakeryShop.bakerySale.facade.MenuOnSaleFacadeLocal;
import ma.BamouhBakery.bakeryShop.bakerySale.facade.MenuOnSaleFacadeRemote;
import ma.BamouhBakery.bakeryShop.persistance.Article;
import ma.BamouhBakery.business.delegate.MenuOnSaleBusinessDelegate;

public class ListeArticlesServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MenuOnSaleBusinessDelegate delegate;

	public ListeArticlesServlets() {
		super();
		delegate = new MenuOnSaleBusinessDelegate();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getServletPath().equals("/enregistrer")) {
			Article a = new Article();
			a.setLibelle(request.getParameter("libelle"));
			a.setPrix(Float.parseFloat(request.getParameter("prix")));
			delegate.addArticle(a);
		}
		if (request.getServletPath().equals("/supprimer")) {
			delegate.removeArticle(Long.parseLong(request
					.getParameter("idArticle")));
		}
		ArrayList<Article> a = delegate.getAllArticles();
		request.setAttribute("listeArticles", a);
		getServletContext().getRequestDispatcher("/listeArticles.jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}
}
