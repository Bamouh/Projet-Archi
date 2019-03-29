package ma.BamouhBakery.business.delegate;

import java.util.ArrayList;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import ma.BamouhBakery.bakeryShop.bakerySale.facade.MenuOnSaleFacadeRemote;
import ma.BamouhBakery.bakeryShop.persistance.Article;

public class MenuOnSaleBusinessDelegate {
	MenuOnSaleFacadeRemote delegate;

	public void removeArticle(long idArticle) {
		delegate.removeArticle(idArticle);
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

	public void updateArticle(Article article, Article nwArticle) {
		delegate.updateArticle(article, nwArticle);
	}

	public MenuOnSaleBusinessDelegate() {
		try {
			InitialContext ic = getInitialContext();
			delegate = (MenuOnSaleFacadeRemote) ic
					.lookup("MenuOnSaleFacade/remote");
		} catch (javax.naming.NamingException e) {
			e.printStackTrace();
		}
	}

	InitialContext getInitialContext() throws javax.naming.NamingException {
		Properties p = new Properties();
		p.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jnp.interfaces.NamingContextFactory");
		p.put(Context.URL_PKG_PREFIXES, "jboss.naming:org.jnp.interfaces");
		p.put(Context.PROVIDER_URL, "jnp://localhost:1099");
		return new InitialContext(p);
	}
}
