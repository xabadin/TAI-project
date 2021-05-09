import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReductionDAOModele {
	
	public int creer(ReductionBeanModele reduction)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		int resultat = -1;
		try
		{

			String requete = new String("INSERT INTO reduction (id_produit, min, max, reduc) VALUES (?,?,?,?);");
			PreparedStatement statement = connexion.prepareStatement(requete,
					Statement.RETURN_GENERATED_KEYS);
			
			statement.setInt(1, reduction.getProduit().getId());
			statement.setInt(2, reduction.getMin());
			statement.setInt(3, reduction.getMax());
			statement.setDouble(4, reduction.getReduc());

			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				resultat = rs.getInt(1);
				reduction.setId(resultat);
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
	
	public List<ReductionBeanModele> lireListe()
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		List<ReductionBeanModele> reductionListe = new ArrayList<ReductionBeanModele>();		

		try
		{
			String requete = new String("SELECT id, id_produit, min, max, reduc FROM reduction;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			ReductionBeanModele reduction = new ReductionBeanModele();
			ProduitDAOModele produitDAOModele = new ProduitDAOModele();
			
			while ( rs.next() )
			{
				
				reduction.setId(rs.getInt("id"));
				reduction.setProduit(produitDAOModele.lire(rs.getInt("id_produit")));
				reduction.setMin(rs.getInt("min"));
				reduction.setMax(rs.getInt("max"));
				reduction.setReduc(rs.getDouble("reduc"));

				reductionListe.add(reduction);
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
		return reductionListe;
	}
}
