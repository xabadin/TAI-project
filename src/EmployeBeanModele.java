import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmployeBeanModele {
	private int id;
	private String nom_utilisateur;
	private String mdp;
	private String nom;
	private String prenom;
	//private ServiceBeanModele ; 
	private LocalDateTime datecreation;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom_utilisateur() {
		return nom_utilisateur;
	}
	public void setNom_utilisateur(String nom_utilisateur) {
		this.nom_utilisateur = nom_utilisateur;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
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
	public LocalDateTime getDatecreation() {
		return datecreation;
	}
	public void setDatecreation(LocalDateTime datecreation) {
		this.datecreation = datecreation;
	}
	public String getDatefrancais () {
		DateTimeFormatter formatter = DateTimeFormatter . ofPattern ("dd MM yyyy ’a’ HH:mm") ;
		 // pour date , sans l’heure , ce serait
		 // DateTimeFormatter formatter = DateTimeFormatter . ofPattern (" dd MM yyyy ’a’ HH:mm ");
		 return this.datecreation.format(formatter);
	}

}
