package ma.BamouhBakery.bakeryShop.persistance;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

@Entity
@NamedQueries({
    @NamedQuery(name="LigneDeCommande.getLigneDeCommande",
                query="SELECT l FROM LigneDeCommande l WHERE l.identifiant = :x"),
    @NamedQuery(name="LigneDeCommande.getAllLigneDeCommande",
                query="SELECT l FROM LigneDeCommande l WHERE l.commande.numeroCommande = :x"),            
    @NamedQuery(name="LigneDeCommande.getLigneDeCommandeFromClient",
                query="SELECT l FROM LigneDeCommande l WHERE l.commande.client.identifiant = :x"),
}) 
public class LigneDeCommande implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long identifiant;
	private int quantite;
	@ManyToOne
	@JoinColumn(name="ID_ARTICLE")
	private Article article;
	@ManyToOne
	@JoinColumn(name="ID_COMMANDE")
	private Commande commande; 
	
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public long getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(long identifiant) {
		this.identifiant = identifiant;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public LigneDeCommande(int quantite) {
		super();
		this.quantite = quantite;
	}
	public LigneDeCommande() {
		super();
	}
	public LigneDeCommande(int quantite, Article article) {
		super();
		this.quantite = quantite;
		this.article = article;
	}
	public LigneDeCommande(int quantite, Article article, Commande commande) {
		super();
		this.quantite = quantite;
		this.article = article;
		this.commande = commande;
	}
	
}
