import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommandeDAOModele {
	
	public int creer(CommandeBeanModele commande)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		int resultat = -1;
		try
		{

			String requete = new String("INSERT INTO produit (nom, prix, id_categorie) VALUES (?,?,?);");
			PreparedStatement statement = connexion.prepareStatement(requete,
					Statement.RETURN_GENERATED_KEYS);
			
			statement.setInt(1, commande.getClient().getId());
			statement.setInt(2, commande.getPrix_total());
			statement.setInt(3, commande.getPrix_reduction());
			statement.setInt(4, commande.getEmploye().getId());

			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				resultat = rs.getInt(1);
				commande.setId(resultat);
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
	
	public List<CommandeBeanModele> lireListe()
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		List<CommandeBeanModele> commandeListe = new ArrayList<CommandeBeanModele>();		

		try
		{
			String requete = new String("SELECT id, id_client, prix_total, prix_reduction, id_employe FROM commande;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			CommandeBeanModele commande = new CommandeBeanModele();
			EmployeDAOModele employeDAOModele = new EmployeDAOModele();
			ClientDAOModele clientDAOModele = new ClientDAOModele();
			
			while ( rs.next() )
			{
				
				commande.setId(rs.getInt("id"));
				commande.setClient(clientDAOModele.lire(rs.getInt("id_client")));
				commande.setPrix_total(rs.getInt("prix_total"));
				commande.setPrix_reduction(rs.getInt("prix_reduction"));
				commande.setEmploye(employeDAOModele.lire(rs.getInt("id_employe")));

				commandeListe.add(commande);
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
		return commandeListe;
	}
}
