

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EnregistrerClientControleur
 */
@WebServlet("/EnregistrerClientControleur")
public class EnregistrerClientControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnregistrerClientControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/enregistrerClientVue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("nom") == "" || request.getParameter("societe") == "" || request.getParameter("adresse") == "" || request.getParameter("code_postal") == "" || request.getParameter("telephone") == "" || request.getParameter("reduc") == "")
		{
			String validation = "Veuillez remplir tout les champs.";
			request.setAttribute("validation", validation);
			request.getRequestDispatcher("/enregistrerClientVue.jsp").forward(request, response);
		}
		else {
			
			String nom = request.getParameter("nom");
			String societe = request.getParameter("societe");
			String adresse = request.getParameter("adresse");
			String code_postal = request.getParameter("code_postal");
			String telephone = request.getParameter("telephone");
			String reduc = request.getParameter("reduc");
			
			String validation = "Le nouveau client a été enregistré.";
			
			ClientBeanModele client = new ClientBeanModele();
			ClientDAOModele clientDAOModele = new ClientDAOModele();
			
			client.setNom(nom);
			client.setSociete(societe);
			client.setAdresse(adresse);
			client.setCode_postal(Integer.parseInt(code_postal));
			client.setTelephone(Integer.parseInt(telephone));
			client.setReduc(Double.parseDouble(reduc));
			clientDAOModele.creer(client);
			request.setAttribute("client", client);
			
			request.setAttribute("validation", validation);
			
			request.getRequestDispatcher("/enregistrerClientVue.jsp").forward(request, response);
		}
		
		
		//clientDAOModele.creer(client);
		//request.setAttribute("client", client);
		
		//request.getRequestDispatcher("/enregistrerClientVue.jsp").forward(request, response);
	}

}
