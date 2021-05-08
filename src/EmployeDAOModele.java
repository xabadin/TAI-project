import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeDAOModele {
	
	public List<EmployeBeanModele> lireListe()
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		List<EmployeBeanModele> employeListe = new ArrayList<EmployeBeanModele>();		

		try
		{
			String requete = new String("SELECT id, nom_utilisateur, mdp, nom, prenom, id_service, datecreation FROM employe;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			EmployeBeanModele employe = new EmployeBeanModele();
			ServiceDAOModele serviceDAOModele = new ServiceDAOModele();
			
			while ( rs.next() )
			{
				
				employe.setId(rs.getInt("id"));
				employe.setNom_utilisateur(rs.getString("nom_utilisateur"));
				employe.setMdp(rs.getString("mdp"));
				employe.setNom(rs.getString("nom"));
				employe.setPrenom(rs.getString("prenom"));
				employe.setService(serviceDAOModele.lire(rs.getInt("id_service")));
				//employe.setDatecreation(rs.getDate("datecreation"));
				employeListe.add(employe);
			}
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		finally 
		{
			connexionBDDModele.fermerConnexion();
		}
		return employeListe;
	}
	
	public  EmployeBeanModele lire(int id)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		EmployeBeanModele employe = new EmployeBeanModele();
		
		ServiceDAOModele serviceDAOModele = new ServiceDAOModele();
		
		try
		{
			String requete = new String("SELECT id, nom_utilisateur, mdp, nom, prenom, id_service, datecreation reduc FROM commande WHERE id = ?;");
			PreparedStatement statement = connexion.prepareStatement(requete);

			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			if ( rs.next() )
			{
				employe = new EmployeBeanModele();
				employe.setId(id);
				employe.setNom_utilisateur(rs.getString("nom_utilisateur"));
				employe.setMdp(rs.getString("mdp"));
				employe.setNom(rs.getString("nom"));
				employe.setPrenom(rs.getString("prenom"));
				employe.setService(serviceDAOModele.lire(rs.getInt("id_service")));
				//employe.setDatecreation(rs.getDate("datecreation"));
			}
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		return employe;
	}
	
}
