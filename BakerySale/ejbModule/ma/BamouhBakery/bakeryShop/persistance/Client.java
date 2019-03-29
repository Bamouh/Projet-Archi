package ma.BamouhBakery.bakeryShop.persistance;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long identifiant;
	private String nom;
	private String prenom;
	private String moteDePasse;
	@OneToMany(mappedBy="client")
	private List<Commande> commandes;
	
	
	
	public List<Commande> getCommande() {
		return commandes;
	}
	public void setCommande(List<Commande> commande) {
		this.commandes= commande;
	}
	public long getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(long identifiant) {
		this.identifiant = identifiant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMoteDePasse() {
		return moteDePasse;
	}
	public void setMoteDePasse(String moteDePasse) {
		this.moteDePasse = moteDePasse;
	}
	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	public Client(String nom, String prenom, String moteDePasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.moteDePasse = moteDePasse;
	}
	public Client() {
		super();
	}
	
	
	
}
