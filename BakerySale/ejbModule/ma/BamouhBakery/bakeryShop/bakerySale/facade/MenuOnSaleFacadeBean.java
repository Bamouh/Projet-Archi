package ma.BamouhBakery.bakeryShop.bakerySale.facade;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.BamouhBakery.bakeryShop.persistance.Article;
import ma.BamouhBakery.bakeryShop.persistance.Commande;

/**
 * Session Bean implementation class MenuOnSaleFacadeBean
 */
@Stateless(name = "MenuOnSaleFacade")
@Local(MenuOnSaleFacadeLocal.class)
@Remote(MenuOnSaleFacadeRemote.class)
public class MenuOnSaleFacadeBean implements MenuOnSaleFacadeRemote,
		MenuOnSaleFacadeLocal {
	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "bakeryShopUnit")
	private EntityManager em;

	public MenuOnSaleFacadeBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Article> getAllArticlesByRange(String range) {
		Query req = em
				.createQuery("select a from Article a where a.libelle = :x");
		req.setParameter("x", range);
		return (ArrayList<Article>) req.getResultList();
	}

	@Override
	public ArrayList<Article> getAllArticles() {
		return (ArrayList<Article>) em.createNamedQuery("Article.findAllArticles")
				.getResultList();
	}

	@Override
	public void addArticle(Article article) {
		if (article.getPrix() <= 0)
			throw new RuntimeException("Exception: Prix négatif"
					+ article.getPrix());
		em.persist(article);
	}

	@Override
	public void updateArticle(Article article, Article nwArticle) {
		if (em.find(Article.class, article.getNumeroArticle()) != null)
			em.merge(nwArticle);
		else
			throw new RuntimeException("Exception");
	}

	@Override
	public void removeArticle(long idArticle) {
		try{
			Article a = em.find(Article.class, idArticle);
			em.remove(a);
		}catch(Exception e){
			System.out.println("ERREUR");
		}
	}
}
