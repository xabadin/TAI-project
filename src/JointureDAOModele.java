import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JointureDAOModele {
	public List<JointureBeanModele> lireListe()
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		List<JointureBeanModele> jointureListe = new ArrayList<JointureBeanModele>();		

		try
		{
			String requete = new String("SELECT id, id_client, prix_total, prix_reduction, id_employe FROM commande;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			JointureBeanModele jointure = new JointureBeanModele();
			CommandeDAOModele commandeDAOModele = new CommandeDAOModele();
			ProduitDAOModele produitDAOModele = new ProduitDAOModele();
			
			while ( rs.next() )
			{
				
				jointure.setId(rs.getInt("id"));
				jointure.setCommande(commandeDAOModele.lire(rs.getInt("id_commande")));
				jointure.setProduit(produitDAOModele.lire(rs.getInt("id_produit")));
				jointure.setQuantite_produit(rs.getInt("quantite_produit"));

				jointureListe.add(jointure);
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
		return jointureListe;
	}
}
