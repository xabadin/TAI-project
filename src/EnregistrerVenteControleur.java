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
		
		ProduitDAOModele produitDAOModele = new ProduitDAOModele();
		List<ProduitBeanModele> produitListe = produitDAOModele.lireListe();
		
		ClientDAOModele clientDAOModele = new ClientDAOModele();
		List<ClientBeanModele> clientListe = clientDAOModele.lireListe();
		
		CommandeDAOModele commandeDAOModele = new CommandeDAOModele();
		List<CommandeBeanModele> commandeListe = commandeDAOModele.lireListe();
		
		ReductionDAOModele reductionDAOModele = new ReductionDAOModele();
		List<ReductionBeanModele> reductionListe = reductionDAOModele.lireListe();
		
		EmployeDAOModele employeDAOModele = new EmployeDAOModele();
		List<EmployeBeanModele> employeListe = employeDAOModele.lireListe();
		
		String numCommande = Integer.toString(commandeListe.size() + 1);
		
		request.setAttribute("produitListe", produitListe);
		request.setAttribute("numCommande", numCommande);
		request.setAttribute("clientListe", clientListe);
		request.setAttribute("employeListe", employeListe);
		
		String client = request.getParameter("client");
		
		double reducClient = 0;
		int id_client = 0;
		int id_employe = 0;
		
		for(int i = 0; i < clientListe.size(); i++)
		{
			if(clientListe.get(i).getNom().equals(client))
			{
				reducClient = clientListe.get(i).getReduc();
				id_client = clientListe.get(i).getId();
			}
		}

		for(int i = 0; i < employeListe.size(); i++)
		{
			/*if(employeListe.get(i).getNom_utilisateur(nom_utilisateur)
			{
				id_employe = employeListe.get(i).getId();
			}*/
		}
		
		if(request.getParameter("quantite1") == "")
		{
			String validation = "Veuillez remplir la première ligne de la colonne quantité.";
			request.setAttribute("validation", validation);
		}
		else {
			String quantite1 = request.getParameter("quantite1");
			String designation1 = request.getParameter("designation1");
			double prixTot1 = 0;
			double prix1 = 0;
			int id_produit = 0;
			double reducProduit1 = 0;
			double prixReduc1 = 0;
			
			String quantite2 = request.getParameter("quantite2");
			String designation2 = request.getParameter("designation2");
			double prixTot2 = 0;
			double prix2 = 0;
			int id_produit2 = 0;
			double reducProduit2 = 0;
			double prixReduc2 = 0;
			
			String quantite3 = request.getParameter("quantite3");
			String designation3 = request.getParameter("designation3");
			double prixTot3 = 0;
			double prix3 = 0;
			int id_produit3 = 0;
			double reducProduit3 = 0;
			double prixReduc3 = 0;
			
			String quantite4 = request.getParameter("quantite4");
			String designation4 = request.getParameter("designation4");
			double prixTot4 = 0;
			double prix4 = 0;
			int id_produit4 = 0;
			double reducProduit4 = 0;
			double prixReduc4 = 0;
			
			String quantite5 = request.getParameter("quantite5");
			String designation5 = request.getParameter("designation5");
			double prixTot5 = 0;
			double prix5 = 0;
			int id_produit5 = 0;
			double reducProduit5 = 0;
			double prixReduc5 = 0;
			
			for(int i = 0; i < produitListe.size(); i++)
			{
				if(produitListe.get(i).getDesignation().equals(designation1))
				{
					prix1 = produitListe.get(i).getPrix();
					request.setAttribute("prix1", prix1);
					prixTot1 = prix1 * Double.parseDouble(quantite1);
					request.setAttribute("prixTot1", prixTot1);
					id_produit = produitListe.get(i).getId();
				}
			}
			for(int i = 0; i < reductionListe.size(); i++)
			{
				if(reductionListe.get(i).getProduit().getId() == id_produit)
				{
					if(reductionListe.get(i).getMin() <= Integer.parseInt(quantite1) && Integer.parseInt(quantite1) <= reductionListe.get(i).getMax())
					{
						reducProduit1 = reductionListe.get(i).getReduc();
						request.setAttribute("reducProduit1", reducProduit1);
						prixReduc1 = prixTot1 - reducProduit1 * prixTot1;
						request.setAttribute("prixReduc1", prixReduc1);
					}else
					{
						request.setAttribute("reducProduit1", reducProduit1);
						prixReduc1 = prixTot1;
						request.setAttribute("prixReduc1", prixReduc1);
					}
				}else{
					request.setAttribute("reducProduit1", reducProduit1);
					prixReduc1 = prixTot1;
					request.setAttribute("prixReduc1", prixReduc1);
				}
			}
			
			if(request.getParameter("quantite2") != "")
			{
				
				for(int i = 0; i < produitListe.size(); i++)
				{
					if(produitListe.get(i).getDesignation().equals(designation2))
					{
						prix2 = produitListe.get(i).getPrix();
						request.setAttribute("prix2", prix2);
						prixTot2 = prix2 * Double.parseDouble(quantite2);
						request.setAttribute("prixTot2", prixTot2);
						id_produit2 = produitListe.get(i).getId();
					}
				}
				for(int i = 0; i < reductionListe.size(); i++)
				{
					if(reductionListe.get(i).getProduit().getId() == id_produit2)
					{
						if(reductionListe.get(i).getMin() <= Integer.parseInt(quantite2) && Integer.parseInt(quantite2) <= reductionListe.get(i).getMax())
						{
							reducProduit2 = reductionListe.get(i).getReduc();
							request.setAttribute("reducProduit2", reducProduit2);
							prixReduc2 = prixTot2 - reducProduit2 * prixTot2;
							request.setAttribute("prixReduc2", prixReduc2);
						}else
						{
							request.setAttribute("reducProduit2", reducProduit2);
							prixReduc2 = prixTot2;
							request.setAttribute("prixReduc2", prixReduc2);
						}
					}else
					{
						request.setAttribute("reducProduit2", reducProduit2);
						prixReduc2 = prixTot2;
						request.setAttribute("prixReduc2", prixReduc2);
					}
				}
			}
			if(request.getParameter("quantite3") != "")
			{
				
				for(int i = 0; i < produitListe.size(); i++)
				{
					if(produitListe.get(i).getDesignation().equals(designation3))
					{
						prix3 = produitListe.get(i).getPrix();
						request.setAttribute("prix3", prix3);
						prixTot3 = prix3 * Double.parseDouble(quantite3);
						request.setAttribute("prixTot3", prixTot3);
						id_produit3 = produitListe.get(i).getId();
					}
				}
				for(int i = 0; i < reductionListe.size(); i++)
				{
					if(reductionListe.get(i).getProduit().getId() == id_produit3)
					{
						if(reductionListe.get(i).getMin() <= Integer.parseInt(quantite3) && Integer.parseInt(quantite3) <= reductionListe.get(i).getMax())
						{
							reducProduit3 = reductionListe.get(i).getReduc();
							request.setAttribute("reducProduit3", reducProduit3);
							prixReduc3 = prixTot3 - reducProduit3 * prixTot3;
							request.setAttribute("prixReduc3", prixReduc3);
						}else
						{
							request.setAttribute("reducProduit3", reducProduit3);
							prixReduc3 = prixTot3;
							request.setAttribute("prixReduc3", prixReduc3);
						}
					}else
					{
						request.setAttribute("reducProduit3", reducProduit3);
						prixReduc3 = prixTot3;
						request.setAttribute("prixReduc3", prixReduc3);
					}
				}
			}
			
			if(request.getParameter("quantite4") != "")
			{
				
				for(int i = 0; i < produitListe.size(); i++)
				{
					if(produitListe.get(i).getDesignation().equals(designation4))
					{
						prix4 = produitListe.get(i).getPrix();
						request.setAttribute("prix4", prix4);
						prixTot4 = prix4 * Double.parseDouble(quantite4);
						request.setAttribute("prixTot4", prixTot4);
						id_produit4 = produitListe.get(i).getId();
					}
				}
				for(int i = 0; i < reductionListe.size(); i++)
				{
					if(reductionListe.get(i).getProduit().getId() == id_produit4)
					{
						if(reductionListe.get(i).getMin() <= Integer.parseInt(quantite4) && Integer.parseInt(quantite4) <= reductionListe.get(i).getMax())
						{
							reducProduit4 = reductionListe.get(i).getReduc();
							request.setAttribute("reducProduit4", reducProduit4);
							prixReduc4 = prixTot4 - reducProduit4 * prixTot4;
							request.setAttribute("prixReduc4", prixReduc4);
						}else
						{
							request.setAttribute("reducProduit4", reducProduit4);
							prixReduc4 = prixTot4;
							request.setAttribute("prixReduc4", prixReduc4);
						}
					}else
					{
						request.setAttribute("reducProduit4", reducProduit4);
						prixReduc4 = prixTot4;
						request.setAttribute("prixReduc4", prixReduc4);
					}
				}
			}
			
			if(request.getParameter("quantite5") != "")
			{
				
				for(int i = 0; i < produitListe.size(); i++)
				{
					if(produitListe.get(i).getDesignation().equals(designation5))
					{
						prix5 = produitListe.get(i).getPrix();
						request.setAttribute("prix5", prix5);
						prixTot5 = prix5 * Double.parseDouble(quantite5);
						request.setAttribute("prixTot5", prixTot5);
						id_produit5 = produitListe.get(i).getId();
					}
				}
				for(int i = 0; i < reductionListe.size(); i++)
				{
					if(reductionListe.get(i).getProduit().getId() == id_produit5)
					{
						if(reductionListe.get(i).getMin() <= Integer.parseInt(quantite5) && Integer.parseInt(quantite5) <= reductionListe.get(i).getMax())
						{
							reducProduit5 = reductionListe.get(i).getReduc();
							request.setAttribute("reducProduit5", reducProduit5);
							prixReduc5 = prixTot5 - reducProduit5 * prixTot5;
							request.setAttribute("prixReduc5", prixReduc5);
						}else
						{
							request.setAttribute("reducProduit5", reducProduit5);
							prixReduc5 = prixTot5;
							request.setAttribute("prixReduc5", prixReduc5);
						}
					}else
					{
						request.setAttribute("reducProduit5", reducProduit5);
						prixReduc5 = prixTot5;
						request.setAttribute("prixReduc5", prixReduc5);
					}
				}
			}
			
			double prixTotalSansRemise = prixReduc1 + prixReduc2 + prixReduc3 + prixReduc4 + prixReduc5;
			request.setAttribute("prixCommande", prixTotalSansRemise);
			double prixTotal = prixTotalSansRemise - prixTotalSansRemise * reducClient;
			request.setAttribute("prixCommandeReduc", prixTotal);
			
			
			
			
			
		}
		
		
		
		
		request.getRequestDispatcher("/enregistrerVenteVue.jsp").forward(request, response);
	}

}
