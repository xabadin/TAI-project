

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EnregistrerVenteControleur
 */
@WebServlet("/EnregistrerVenteControleur")
public class EnregistrerVenteControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnregistrerVenteControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProduitDAOModele produitDAOModele = new ProduitDAOModele();
		List<ProduitBeanModele> produitListe = produitDAOModele.lireListe();
		
		ClientDAOModele clientDAOModele = new ClientDAOModele();
		List<ClientBeanModele> clientListe = clientDAOModele.lireListe();
		
		CommandeDAOModele commandeDAOModele = new CommandeDAOModele();
		List<CommandeBeanModele> commandeListe = commandeDAOModele.lireListe();
		
		String numCommande = Integer.toString(commandeListe.size() + 1);
		
		request.setAttribute("produitListe", produitListe);
		request.setAttribute("numCommande", numCommande);
		request.setAttribute("clientListe", clientListe);
		request.getRequestDispatcher("/enregistrerVenteVue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nom = request.getParameter("nom");
		
		ClientDAOModele clientDAOModele = new ClientDAOModele();
		ClientBeanModele client = new ClientBeanModele();
		List<ClientBeanModele> clientListe = clientDAOModele.lireListe();
		
		for(int i = 0; i < clientListe.size(); i++)
		{
			if(clientListe.get(i).getNom().equals(nom))
			{
				client.setId(clientListe.get(i).getId());
			}
		}
		
		ProduitDAOModele produitDAOModele = new ProduitDAOModele();
		//ProduitBeanModele produit = new ProduitBeanModele();
		//List<ProduitBeanModele> produitListe = produitDAOModele.lireListe();
		
		request.getRequestDispatcher("/enregistrerVenteVue.jsp").forward(request, response);
	}

}
