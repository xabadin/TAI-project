
public class JointureBeanModele {
	private int id;
	private CommandeBeanModele commande;
	private ProduitBeanModele produit;
	private int quantite_produit;
	public int getQuantite_produit() {
		return quantite_produit;
	}
	public void setQuantite_produit(int quantite_produit) {
		this.quantite_produit = quantite_produit;
	}
	public ProduitBeanModele getProduit() {
		return produit;
	}
	public void setProduit(ProduitBeanModele produit) {
		this.produit = produit;
	}
	public CommandeBeanModele getCommande() {
		return commande;
	}
	public void setCommande(CommandeBeanModele commande) {
		this.commande = commande;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
