import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOModele {
	
	public int creer(ClientBeanModele client)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		int resultat = -1;
		try
		{

			String requete = new String("INSERT INTO client (nom, societe, adresse, code_postal, telephone, reduc) VALUES (?,?,?,?,?,?);");
			PreparedStatement statement = connexion.prepareStatement(requete,
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, client.getNom());
			statement.setString(2, client.getSociete());
			statement.setString(3, client.getAdresse());
			statement.setInt(4, client.getCode_postal());
			statement.setInt(5, client.getTelephone());
			statement.setDouble(6, client.getReduc());

			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				resultat = rs.getInt(1);
				client.setId(resultat);
			}
			else 
				resultat = -1;

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
		return resultat;
	}
	
	public List<ClientBeanModele> lireListe()
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		List<ClientBeanModele> clientListe = new ArrayList<ClientBeanModele>();		

		try
		{
			String requete = new String("SELECT id, nom, societe, adresse, code_postal, telephone, reduc FROM client;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			while ( rs.next() )
			{
				ClientBeanModele client = new ClientBeanModele();
				client.setId(rs.getInt("id"));
				client.setNom(rs.getString("nom"));
				client.setSociete(rs.getString("societe"));
				client.setAdresse(rs.getString("adresse"));
				client.setCode_postal(rs.getInt("code_postal"));
				client.setTelephone(rs.getInt("telephone"));
				client.setReduc(rs.getDouble("reduc"));
				

				clientListe.add(client);
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
		return clientListe;
	}
}
