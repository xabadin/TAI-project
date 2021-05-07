import java.sql.Connection;
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
			//ServiceDAOModele serviceDAOModele = new ServiceDAOModele();
			
			while ( rs.next() )
			{
				
				employe.setId(rs.getInt("id"));
				employe.setNom_utilisateur(rs.getString("nom_utilisateur"));
				employe.setMdp(rs.getString("mdp"));
				employe.setNom(rs.getString("nom"));
				employe.setPrenom(rs.getString("prenom"));
				//employe.set(rs.getInt("id_service"));
				//employe.setDatecreation(rs.getD("datecreation");

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
	
}
