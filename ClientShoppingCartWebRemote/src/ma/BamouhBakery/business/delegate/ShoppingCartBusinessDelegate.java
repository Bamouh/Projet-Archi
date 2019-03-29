package ma.BamouhBakery.business.delegate;

import java.util.ArrayList;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import ma.BamouhBakery.bakeryShop.bakerySale.facade.MenuOnSaleFacadeRemote;
import ma.BamouhBakery.bakeryShop.persistance.Commande;
import ma.BamouhBakery.bakeryShop.persistance.LigneDeCommande;
import ma.BamouhBakery.bakeryShop.bakerySale.stateful.ShoppingCartBeanRemote;

public class ShoppingCartBusinessDelegate {
	ShoppingCartBeanRemote delegate;

	public ShoppingCartBusinessDelegate() {
		try {
			InitialContext ic = getInitialContext();
			delegate = (ShoppingCartBeanRemote) ic
					.lookup("ShoppingCart/remote");
		} catch (javax.naming.NamingException e) {
			e.printStackTrace();
		}
	}

	public LigneDeCommande getLigneDeCommande(long idLigneCommande) {
		return delegate.getLigneDeCommande(idLigneCommande);
	}

	public ArrayList<LigneDeCommande> getAllLigneDeCommande(long idCommande) {
		return delegate.getAllLigneDeCommande(idCommande);
	}

	public ArrayList<LigneDeCommande> getLigneDeCommandeByClient(long idClient) {
		return delegate.getLigneDeCommandeByClient(idClient);
	}

	public void AddLigneCommande(int quantite, int idArticle) {
		delegate.AddLigneCommande(quantite, idArticle);
	}

	public void removeLigneCommande(int quantite, int idArticle) {
		delegate.removeLigneCommande(quantite, idArticle);
	}

	InitialContext getInitialContext() throws javax.naming.NamingException {
		Properties p = new Properties();
		p.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jnp.interfaces.NamingContextFactory");
		p.put(Context.URL_PKG_PREFIXES, "jboss.naming:org.jnp.interfaces");
		p.put(Context.PROVIDER_URL, "jnp://localhost:1099");
		return new InitialContext(p);
	}

	public Commande getCommande() {
		return delegate.getCommande();
	}

	public void validerAchat() {
		delegate.validerAchat(this.getCommande());
		
	}
}
