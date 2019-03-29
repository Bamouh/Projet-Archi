package ma.BamouhBakery.Bakeryshop.utils;

import java.util.ArrayList;
import java.util.List;

import ma.BamouhBakery.bakeryShop.persistance.Article;

public class BakeryShopBouchon {
	
	public BakeryShopBouchon() {
		super();
	}

	public static ArrayList<Article> getAllArticlesForTransaction(){
		List<Article> listeArticle = new ArrayList<Article>();
		Article a1 = new Article("ARTICLE1", 50);
		Article a2 = new Article("ARTICLE2", 100);
		Article a3 = new Article("ARTICLE3", 60);
		Article a4 = new Article("ARTICLE4", 450);
		Article a5 = new Article("ARTICLE5", 12);
		Article a6 = new Article("ARTICLE6", 12);
		Article a7 = new Article("ARTICLE7", 14);
		Article a8 = new Article("ARTICLE8", 10);
		Article a9 = new Article("ARTICLE9", 14);
		Article a10 = new Article("ARTICLE10", 45);
		listeArticle.add(a1);
		listeArticle.add(a2);
		listeArticle.add(a3);
		listeArticle.add(a4);
		listeArticle.add(a5);
		listeArticle.add(a6);
		listeArticle.add(a7);
		listeArticle.add(a8);
		listeArticle.add(a9);
		listeArticle.add(a10);
		return (ArrayList<Article>) listeArticle;
	}

}
