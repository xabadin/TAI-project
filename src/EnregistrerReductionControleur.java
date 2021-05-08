

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
		
		String designation = request.getParameter("designation");
		
		ProduitDAOModele produitDAOModele = new ProduitDAOModele();
		ProduitBeanModele produit = new ProduitBeanModele();
		List<ProduitBeanModele> produitListe = produitDAOModele.lireListe();
		
		ReductionDAOModele reductionDAOModele = new ReductionDAOModele();
		
		ReductionBeanModele reduction = new ReductionBeanModele();
		ReductionBeanModele reduction1 = new ReductionBeanModele();
		ReductionBeanModele reduction2 = new ReductionBeanModele();
		ReductionBeanModele reduction3 = new ReductionBeanModele();
		ReductionBeanModele reduction4 = new ReductionBeanModele();
		
		
		for(int i = 0; i < produitListe.size(); i++)
		{
			if(produitListe.get(i).getDesignation().equals(designation))
			{
				produit.setId(produitListe.get(i).getId());
			}
		}
		//Première ligne non remplie
		if(request.getParameter("min1") == "" || request.getParameter("max1") == "" || request.getParameter("reduc1") == "")
		{
			String validation = "Veuillez remplir la première ligne.";
			request.setAttribute("validation", validation);
		}
		else {
			
			reduction.setMax(Integer.parseInt(request.getParameter("max1")));
			reduction.setMin(Integer.parseInt(request.getParameter("min1")));
			reduction.setReduc(Double.parseDouble(request.getParameter("reduc1")));
			reduction.setProduit(produit);
			
			reductionDAOModele.creer(reduction);
			String validation = "La réduction a été enregistrée.";
			request.setAttribute("validation", validation);
			
			if(request.getParameter("min2") == "" || request.getParameter("max2") == "" || request.getParameter("reduc2") == "")
			{
				
			}else {
				
				reduction1.setMax(Integer.parseInt(request.getParameter("max2")));
				reduction1.setMin(Integer.parseInt(request.getParameter("min2")));
				reduction1.setReduc(Double.parseDouble(request.getParameter("reduc2")));
				reduction1.setProduit(produit);
				
				reductionDAOModele.creer(reduction1);
				
				if(request.getParameter("min3") == "" || request.getParameter("max3") == "" || request.getParameter("reduc3") == "")
				{
				}else {
					reduction2.setMax(Integer.parseInt(request.getParameter("max3")));
					reduction2.setMin(Integer.parseInt(request.getParameter("min3")));
					reduction2.setReduc(Double.parseDouble(request.getParameter("reduc3")));
					reduction2.setProduit(produit);
					
					reductionDAOModele.creer(reduction2);
					if(request.getParameter("min4") == "" || request.getParameter("max4") == "" || request.getParameter("reduc4") == "")
					{
					}else {
						reduction3.setMax(Integer.parseInt(request.getParameter("max4")));
						reduction3.setMin(Integer.parseInt(request.getParameter("min4")));
						reduction3.setReduc(Double.parseDouble(request.getParameter("reduc4")));
						reduction3.setProduit(produit);
						
						reductionDAOModele.creer(reduction3);
						if(request.getParameter("min5") == "" || request.getParameter("max5") == "" || request.getParameter("reduc5") == "")
						{
						}else {
							reduction4.setMax(Integer.parseInt(request.getParameter("max5")));
							reduction4.setMin(Integer.parseInt(request.getParameter("min5")));
							reduction4.setReduc(Double.parseDouble(request.getParameter("reduc5")));
							reduction4.setProduit(produit);
							
							reductionDAOModele.creer(reduction4);
						}
					}
				}
			}
		}
		request.setAttribute("produitListe", produitListe);
		
		request.getRequestDispatcher("/enregistrerReductionVue.jsp").forward(request, response);
	}

}
