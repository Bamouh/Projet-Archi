package ma.BamouhBakery.business.delegate;

import java.util.ArrayList;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import ma.BamouhBakery.bakeryShop.bakerySale.facade.MenuOnSaleFacadeRemote;
import ma.BamouhBakery.bakeryShop.persistance.Article;
import ma.BamouhBakery.bakeryShop.bakerySale.stateful.ShoppingCartBeanRemote;

public class MenuOnSaleBusinessDelegate {

	MenuOnSaleFacadeRemote delegate ;

	
	public MenuOnSaleBusinessDelegate() {

		try{
    		
    		InitialContext ic = getInitialContext();
    		delegate = (MenuOnSaleFacadeRemote)ic.lookup("MenuOnSaleFacade/remote");
    	} catch (javax.naming.NamingException e) {
    		e.printStackTrace();
    	}
	}

	public ArrayList<Article> getAllArticlesByRange(String range) {
		return delegate.getAllArticlesByRange(range);
	}

	public ArrayList<Article> getAllArticles() {
		return delegate.getAllArticles();
	}

	public void addArticle(Article article) {
		delegate.addArticle(article);
	}
	
	InitialContext getInitialContext() throws
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
