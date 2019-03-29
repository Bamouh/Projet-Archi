package ma.BamouhBakery.bakeryShop.servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.BamouhBakery.bakeryShop.bakerySale.facade.MenuOnSaleFacadeRemote;
import ma.BamouhBakery.bakeryShop.persistance.Article;
import ma.BamouhBakery.bakeryShop.persistance.LigneDeCommande;
import ma.BamouhBakery.bakeryShop.bakerySale.stateful.ShoppingCartBeanRemote;
import ma.BamouhBakery.business.delegate.MenuOnSaleBusinessDelegate;
import ma.BamouhBakery.business.delegate.ShoppingCartBusinessDelegate;

public class AddArticleToShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShoppingCartBusinessDelegate delegate;
	private MenuOnSaleBusinessDelegate delegateSale;
    public AddArticleToShoppingCart() {
        super();
        delegate = new ShoppingCartBusinessDelegate();
        delegateSale = new MenuOnSaleBusinessDelegate();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	if(request.getServletPath().equals("/enregistrer"))
		{
    		System.out.println(delegate.getCommande().getNumeroCommande());
    		System.out.println(Integer.parseInt(request.getParameter("quantite")));
    		System.out.println(Integer.parseInt(request.getParameter("idArticle")));
    		delegate.AddLigneCommande(Integer.parseInt(request.getParameter("quantite")),Integer.parseInt(request.getParameter("idArticle")));
		}
    	if(request.getServletPath().equals("/supprimer"))
		{
    		delegate.removeLigneCommande(Integer.parseInt(request.getParameter("quantity")), Integer.parseInt(request.getParameter("idArticle2")));
		}
    	if(request.getServletPath().equals("/valider"))
		{
    		delegate.validerAchat();
		}
    	
    	ArrayList<Article> articles= delegateSale.getAllArticles();
    	request.setAttribute("allArticles",articles);
    	//ArrayList<LigneDeCommande> l= delegate.getAllLigneDeCommande(/*delegate.getCommande().getNumeroCommande()*/2);
    	ArrayList<LigneDeCommande> l= (ArrayList<LigneDeCommande>) delegate.getCommande().getLignesDeCommande();
    	if (l == null){
    		l = new ArrayList<LigneDeCommande>();
    		l.add(new LigneDeCommande(1, articles.get(0)));
    	}
    	//liste.add(new LigneDeCommande(1, articles.get(0)));
    	/*
    	for(int i=0;i<l.size();i++){
			System.out.println("ID Commande"+l.get(i).getCommande().getNumeroCommande());
			System.out.println("ID ligne Commande:"+l.get(i).getIdentifiant());
			System.out.println("Nom de l'article commandée:"+l.get(i).getArticle().getLibelle());
			System.out.println("Prix de l'article:"+l.get(i).getArticle().getPrix());
			System.out.println("Quantité Commandée:"+l.get(i).getQuantite());
			//System.out.println("Nom du Client:"+l.get(i).getCommande().getClient().getNom()+
			//					" "+l.get(i).getCommande().getClient().getPrenom()+"\n------\n");
		}
		*/
    	request.setAttribute("listeLigneCommande",l);
    	getServletContext().getRequestDispatcher("/commande.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	
}
