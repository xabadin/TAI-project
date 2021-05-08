import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RechercheArticleControleur
 */
@WebServlet("/RechercheArticleControleur")
public class RechercheArticleControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheArticleControleur() {
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

		request.setAttribute("produitListe", produitListe);
		
		request.getRequestDispatcher("/rechercheArticleVue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String designation = request.getParameter("designation");
		
		ProduitDAOModele produitDAOModele = new ProduitDAOModele();
		ProduitBeanModele produit = new ProduitBeanModele();
		List<ProduitBeanModele> produitListe = produitDAOModele.lireListe();
		for(int i = 0; i < produitListe.size(); i++)
		{
			System.out.println(designation);
			//System.out.println(produitListe.get(i).getDesignation());
			if(produitListe.get(i).getDesignation().equalsIgnoreCase(designation))
			{
				produit.setId(produitListe.get(i).getId());
				String test = produitListe.get(i).getDesignation();
				System.out.println(produitListe.get(i).getId());
				System.out.println(test);
				System.out.println(produitListe.get(i).getPrix());
				produit.setDesignation(designation);
				produit.setPrix(produitListe.get(i).getPrix());
			}
		}
		
		request.setAttribute("produitListe", produitListe);
		request.setAttribute("produit", produit);
		request.getRequestDispatcher("/rechercheArticleVue.jsp").forward(request, response);
	}

}
