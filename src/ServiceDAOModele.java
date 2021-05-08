import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAOModele {
	public List<ServiceBeanModele> lireListe()
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		List<ServiceBeanModele> serviceListe = new ArrayList<ServiceBeanModele>();		

		try
		{
			String requete = new String("SELECT id, nom FROM service;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			while ( rs.next() )
			{
				ServiceBeanModele service = new ServiceBeanModele();
				service.setId(rs.getInt("id"));
				service.setNom(rs.getString("nom"));

				serviceListe.add(service);
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
		return serviceListe;
	}
	
	public  ServiceBeanModele lire(int id)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		ServiceBeanModele service = new ServiceBeanModele();
		try
		{
			String requete = new String("SELECT id, nom FROM client WHERE id = ?;");
			PreparedStatement statement = connexion.prepareStatement(requete);

			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			if ( rs.next() )
			{
				service = new ServiceBeanModele();
				service.setId(id);
				service.setNom(rs.getString("nom"));
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
		return service;
	}
}
