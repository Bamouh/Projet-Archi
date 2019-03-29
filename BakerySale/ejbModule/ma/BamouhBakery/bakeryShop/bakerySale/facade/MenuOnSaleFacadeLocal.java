package ma.BamouhBakery.bakeryShop.bakerySale.facade;

import java.util.ArrayList;

import javax.ejb.Local;

import ma.BamouhBakery.bakeryShop.persistance.Article;

@Local
public interface MenuOnSaleFacadeLocal {

	public ArrayList<Article> getAllArticlesByRange(String range);
	public ArrayList<Article> getAllArticles();
	public void addArticle(Article article);
	public void updateArticle(Article article, Article nwArticle);
	public void removeArticle(long idArticle);
}
