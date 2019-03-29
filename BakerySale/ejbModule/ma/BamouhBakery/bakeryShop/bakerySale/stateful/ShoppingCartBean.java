package ma.BamouhBakery.bakeryShop.bakerySale.stateful;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.ejb3.annotation.CacheConfig;
import org.jboss.proxy.compiler.Runtime;

import com.sun.security.ntlm.Client;

import ma.BamouhBakery.bakeryShop.persistance.Article;
import ma.BamouhBakery.bakeryShop.persistance.Commande;
import ma.BamouhBakery.bakeryShop.persistance.LigneDeCommande;

@Stateful(name="ShoppingCart")
public  class ShoppingCartBean implements ShoppingCartBeanRemote, ShoppingCartBeanLocal {
	Commande commande ; 
	@PersistenceContext(unitName="bakeryShopUnit")
	private EntityManager em;
    public ShoppingCartBean() {
    }
	@PostConstruct
	public void initialize()
	{
		commande = new Commande(Long.parseLong(em.createNamedQuery("Commande.findLastCommande").getResultList().get(0).toString())+1);
		System.out.println("NUMERO COMMANDE :" + commande.getNumeroCommande());
	}
	@Override
	public LigneDeCommande getLigneDeCommande(long idLigneDeCommande) {
		return (LigneDeCommande) em.createNamedQuery("LigneDeCommande.getLigneDeCommande")
		.setParameter("x",idLigneDeCommande)
		.getResultList();
	}
	@Override
	public ArrayList<LigneDeCommande> getLigneDeCommandeByClient(long idClient) {
		return (ArrayList<LigneDeCommande>) em.createNamedQuery("LigneDeCommande.getLigneDeCommandeFromClient")
		.setParameter("x",idClient)
		.getResultList();
	}
	@Override
	public void removeLigneCommande(int quantite, int idArticle) {
		//long id = idLigneDeCommande ; 
		//LigneDeCommande l = em.find(LigneDeCommande.class,id);
		//em.remove(l);
		long b = idArticle;
		Article article = em.find(Article.class,b);
		LigneDeCommande l = new LigneDeCommande(quantite, article);
		for(LigneDeCommande li : this.getCommande().getLignesDeCommande()){
			if((l.getArticle().getNumeroArticle() == (li.getArticle().getNumeroArticle())) && (l.getQuantite() == li.getQuantite())){
				this.getCommande().getLignesDeCommande().remove(li);
				break;
			}
		}
		
	}

	@Override
	public ArrayList<LigneDeCommande> getAllLigneDeCommande(long idCommande) {
		return (ArrayList<LigneDeCommande>) em.createNamedQuery("LigneDeCommande.getAllLigneDeCommande")
		.setParameter("x",idCommande)
		.getResultList();
	}

	@Override
	public void AddLigneCommande(int quantite, int idArticle) {
		/*
		long a = idcommande;
		long b = idArticle;
		
		Commande comd = em.find(Commande.class,a);
		Article article = em.find(Article.class,b);
		
		if(article == null)
			new RuntimeException("Article indéfini");
		if(comd == null)
			new RuntimeException("Commande indéfinie");
		
		LigneDeCommande l = new LigneDeCommande(quantite, article, comd);
		em.persist(l);
		*/
		long b = idArticle;
		Article article = em.find(Article.class,b);
		LigneDeCommande l = new LigneDeCommande(quantite, article, this.getCommande());
		this.getCommande().getLignesDeCommande().add(l);

	}
	@Override
	public Commande getCommande(){
		System.out.println("Passage dans la méthode getCommande()");
		return this.commande;
	}
	@Override
	public void validerAchat(Commande commande){
		commande.setNumeroCommande(0);
		em.persist(commande);
		for(LigneDeCommande li : commande.getLignesDeCommande()){
			em.persist(li);
		}
	}
}

