package ma.BamouhBakery.bakeryShop.persistance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
@NamedQuery(name="Commande.findLastCommande", query="SELECT MAX(c.numeroCommande) FROM Commande c")
public class Commande implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long numeroCommande;
	@OneToMany(mappedBy="commande",fetch=FetchType.LAZY)
	private List<LigneDeCommande> lignesDeCommande;
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public long getNumeroCommande() {
		return numeroCommande;
	}
	public void setNumeroCommande(long numeroCommande) {
		this.numeroCommande = numeroCommande;
	}
	@Transient
	public List<LigneDeCommande> getLignesDeCommande() {
		return lignesDeCommande;
	}
	public void setLignesDeCommande(List<LigneDeCommande> lignesDeCommande) {
		this.lignesDeCommande = lignesDeCommande;
	}
	
	public Commande() {
		super();
		this.lignesDeCommande = new ArrayList<LigneDeCommande>();
	}
	
	public Commande(long numeroCommande) {
		super();
		this.numeroCommande = numeroCommande;
		this.lignesDeCommande = new ArrayList<LigneDeCommande>();
	}
	
	public Commande(Client client) {
		super();
		this.client = client;
		this.lignesDeCommande = null;
	}
	
}
