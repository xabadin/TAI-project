
public class ReductionBeanModele {
	private int id;
	private ProduitBeanModele produit;
	private int min;
	private int max;
	private double reduc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ProduitBeanModele getProduit() {
		return produit;
	}
	public void setProduit(ProduitBeanModele produit) {
		this.produit = produit;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public double getReduc() {
		return reduc;
	}
	public void setReduc(double reduc) {
		this.reduc = reduc;
	}
}
