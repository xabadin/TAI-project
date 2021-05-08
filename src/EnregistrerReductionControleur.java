

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EnregistrerReductionControleur
 */
@WebServlet("/EnregistrerReductionControleur")
public class EnregistrerReductionControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnregistrerReductionControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProduitDAOModele produitDAOModele = new ProduitDAOModele();
		List<ProduitBeanModele> produitListe = produitDAOModele.lireListe();

		request.setAttribute("produitListe", produitListe);
		
		request.getRequestDispatcher("/enregistrerReductionVue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProduitDAOModele produitDAOModele = new ProduitDAOModele();
		List<ProduitBeanModele> produitListe = produitDAOModele.lireListe();

		request.setAttribute("produitListe", produitListe);
		
		request.getRequestDispatcher("/enregistrerReductionVue.jsp").forward(request, response);
	}

}
