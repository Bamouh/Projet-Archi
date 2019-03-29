package ma.BamouhBakery.bakeryShop.bakerySale.test;

import java.util.ArrayList;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import ma.BamouhBakery.bakeryShop.bakerySale.stateful.ShoppingCartBeanRemote;
import ma.BamouhBakery.bakeryShop.persistance.Commande;
import ma.BamouhBakery.bakeryShop.persistance.LigneDeCommande;

public class Main {

	/**
	 * @param args
	 */
	private ShoppingCartBeanRemote metier;

	public static void main(String[] args) {
		InitialContext ctx;
		ShoppingCartBeanRemote metier = null;
		Properties p = new Properties();
		p.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jnp.interfaces.NamingContextFactory");
		p.put(Context.URL_PKG_PREFIXES, "jboss.naming:org.jnp.interfaces");
		p.put(Context.PROVIDER_URL, "jnp://localhost:1099");
		try {
			InitialContext ic = new InitialContext(p);
			metier = (ShoppingCartBeanRemote) ic.lookup("ShoppingCart/remote");
		} catch (javax.naming.NamingException e) {
			e.printStackTrace();
		}
		System.out
				.println("invocation de l'EJB StateFul et la méthode getCommande()\n");
		Commande c = metier.getCommande();
		
		System.out.println("Affichage des lignes de commande de la commande actuelle:\n");
		ArrayList<LigneDeCommande> l= (ArrayList<LigneDeCommande>) metier.getCommande().getLignesDeCommande();
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

}
