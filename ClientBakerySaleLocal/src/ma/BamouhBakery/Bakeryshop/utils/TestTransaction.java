package ma.BamouhBakery.Bakeryshop.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ma.BamouhBakery.bakeryShop.bakerySale.facade.MenuOnSaleFacadeLocal;
import ma.BamouhBakery.bakeryShop.bakerySale.facade.MenuOnSaleFacadeRemote;
import ma.BamouhBakery.bakeryShop.persistance.Article;
import ma.BamouhBakery.bakeryShop.persistance.LigneDeCommande;
import ma.BamouhBakery.bakeryShop.bakerySale.stateful.ShoppingCartBeanRemote;

public class TestTransaction {
	public static ArrayList<Article> listeArticle = new ArrayList<Article>();

	public TestTransaction() {
		super();
	}

	public static void main(String[] args) {
		MenuOnSaleFacadeRemote metier = null;
		InitialContext ic = null;
		
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial",
				"org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.factory.url.pkgs",
				"org.jboss.naming:org.jnp.interfaces");
		props.setProperty("java.naming.provider.url", "jnp://localhost:1099");
		
		try {
			ic = new InitialContext(props);
			metier = (MenuOnSaleFacadeRemote) ic
					.lookup("MenuOnSaleFacade/remote");
		} catch (javax.naming.NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out
				.println("invocation de l'EJB stateless Chargement de la base de donnée...\n");
		ArrayList<Article> l = BakeryShopBouchon.getAllArticlesForTransaction();
		for (int i = 0; i < l.size(); i++) {
			try{
				metier.addArticle(l.get(i));
				System.out.println("L'Article numero " + l.get(i).getNumeroArticle() + " a bien été ajouté.");
			}catch(Exception e){
				System.out.println("Echec de l'ajout de l'Article numero " + l.get(i).getNumeroArticle() );
				e.printStackTrace();
			}
		}
	}

}
