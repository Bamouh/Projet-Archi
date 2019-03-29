package ma.BamouhBakery.bakeryShop.bakerySale.stateful;
import java.util.ArrayList;

import javax.ejb.Remote;

import ma.BamouhBakery.bakeryShop.persistance.Commande;
import ma.BamouhBakery.bakeryShop.persistance.LigneDeCommande;

@Remote
public interface ShoppingCartBeanRemote {
	
	public void validerAchat(Commande commande);
	public Commande getCommande();
	public LigneDeCommande getLigneDeCommande(long idLigneCommande);
	public ArrayList<LigneDeCommande> getAllLigneDeCommande(long idCommande);
	public ArrayList<LigneDeCommande> getLigneDeCommandeByClient(long idClient);
	public  void AddLigneCommande(int quantite, int idArticle);
	public void removeLigneCommande(int quantite, int idArticle);
}
