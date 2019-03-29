package ma.BamouhBakery.bakeryShop.persistance;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name="Article.findAllArticles",
                query="SELECT a FROM Article a"),
    @NamedQuery(name="Article.findAllArticlesFromNum",
                query="SELECT a FROM Article a WHERE a.numeroArticle = :numeroArticle"),
}) 
public class Article implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long numeroArticle;
	private String libelle;
	private float prix;
	@OneToMany(mappedBy="article",fetch=FetchType.LAZY)
	private List<LigneDeCommande> lignesDeCommande;
	
	
	@Transient
	public List<LigneDeCommande> getLignesDeCommande() {
		return lignesDeCommande;
	}
	public void setLignesDeCommande(List<LigneDeCommande> lignesDeCommande) {
		this.lignesDeCommande = lignesDeCommande;
	}
	public Article() {
		super();
	}
	public Article(String libelle, float prix) {
		super();
		this.libelle = libelle;
		this.prix = prix;
	}
	public long getNumeroArticle() {
		return numeroArticle;
	}
	public void setNumeroArticle(long numeroArticle) {
		this.numeroArticle = numeroArticle;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
}
