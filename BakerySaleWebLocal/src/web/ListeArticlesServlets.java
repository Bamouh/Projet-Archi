package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.BamouhBakery.bakeryShop.bakerySale.facade.MenuOnSaleFacadeLocal;
import ma.BamouhBakery.bakeryShop.persistance.Article;

public class ListeArticlesServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListeArticlesServlets() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		InitialContext ic;
		MenuOnSaleFacadeLocal metier = null;

		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial",
				"org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.factory.url.pkgs",
				"org.jboss.naming:org.jnp.interfaces");
		props.setProperty("java.naming.provider.url", "jnp://localhost:1099");

		try {
			ic = new InitialContext(props);
			metier = (MenuOnSaleFacadeLocal) ic
					.lookup("MenuOnSaleFacade/local");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (request.getServletPath().equals("/enregistrer")) {
			Article a = new Article();
			a.setLibelle(request.getParameter("libelle"));
			a.setPrix(Float.parseFloat(request.getParameter("prix")));
			metier.addArticle(a);
		}
		if (request.getServletPath().equals("/supprimer")) {
			metier.removeArticle(Long.parseLong(request
					.getParameter("idArticle")));
		}
		

		ArrayList<Article> a = metier.getAllArticles();
		request.setAttribute("listeArticles", a);

		getServletContext().getRequestDispatcher("/listeArticles.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
