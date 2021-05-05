
public class CommandeBeanModele {
	private int id;
	private int prix_total;
	private int prix_reduction;
	private ClientBeanModele client;
	private EmployeBeanModele employe;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrix_total() {
		return prix_total;
	}
	public void setPrix_total(int prix_total) {
		this.prix_total = prix_total;
	}
	public int getPrix_reduction() {
		return prix_reduction;
	}
	public void setPrix_reduction(int prix_reduction) {
		this.prix_reduction = prix_reduction;
	}
	public ClientBeanModele getClient() {
		return client;
	}
	public void setClient(ClientBeanModele client) {
		this.client = client;
	}
	public EmployeBeanModele getEmploye() {
		return employe;
	}
	public void setEmploye(EmployeBeanModele employe) {
		this.employe = employe;
	}
}
