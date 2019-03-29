import java.util.ArrayList;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ma.BamouhBakery.bakeryShop.bakerySale.facade.MenuOnSaleFacadeRemote;
import ma.BamouhBakery.bakeryShop.persistance.LigneDeCommande;
import ma.BamouhBakery.bakeryShop.bakerySale.stateful.ShoppingCartBeanLocal;
import ma.BamouhBakery.bakeryShop.bakerySale.stateful.ShoppingCartBeanRemote;

public class Main {
	private ShoppingCartBeanRemote metier;
	public static void main(String[] args) {
		InitialContext ctx;
		ShoppingCartBeanRemote metier = null;
		try {
	    	InitialContext ic = getInitialContext();
	    	metier = (ShoppingCartBeanRemote) ic.lookup("ShoppingCart/remote");
	    	} catch (javax.naming.NamingException e) {
	    		e.printStackTrace();
	    	}
		System.out.println("invocation de l'EJB StateFull\n afficher toutes les lignes de commande d'id=2...\n");
		ArrayList<LigneDeCommande> l = metier.getAllLigneDeCommande(2);
		for(int i=0;i<l.size();i++){
			System.out.println("ID Commande"+l.get(i).getCommande().getNumeroCommande());
			System.out.println("ID ligne Commande:"+l.get(i).getIdentifiant());
			System.out.println("Nom de l'article commandée:"+l.get(i).getArticle().getLibelle());
			System.out.println("Prix de l'article:"+l.get(i).getArticle().getPrix());
			System.out.println("Quantité Commandée:"+l.get(i).getQuantite());
			//System.out.println("Nom du Client:"+l.get(i).getCommande().getClient().getNom()+
			//					" "+l.get(i).getCommande().getClient().getPrenom()+"\n------\n");
		}

	}
	static InitialContext getInitialContext() throws
	javax.naming.NamingException {
		Properties p = new Properties();
		p.put(Context. INITIAL_CONTEXT_FACTORY,
				"org.jnp.interfaces.NamingContextFactory");
		p.put(Context. URL_PKG_PREFIXES,
		"jboss.naming:org.jnp.interfaces");
		p.put(Context. PROVIDER_URL, "jnp://localhost:1099");
		return new InitialContext(p);
	}

}
