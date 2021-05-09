

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginControleur
 */
@WebServlet("/LoginControleur")
public class LoginControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/loginVue.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
        
        EmployeDAOModele employeDAOModele = new EmployeDAOModele();
        List< EmployeBeanModele > employeListe = employeDAOModele.lireListe();
        
        String nom_utilisateur = request.getParameter( "identifiant" );
        String mdp = request.getParameter( "mdp" );
        boolean verif = false;
        int j = 0;
        for ( int i = 0 ; i < employeListe.size() ; i ++ ) {
        	if ( employeListe.get( i ).getNom_utilisateur().equals( nom_utilisateur ) && employeListe.get( i ).getMdp().equals( mdp ) ) {
                    verif = true;
                    j = i ;                     
                    session.setAttribute( "nom_utilisateur", nom_utilisateur );
                    session.setAttribute( "id_employe", employeListe.get( i ).getId() );
                    
            }
        }
        
        if ( verif ) {
        	if ( employeListe.get( j ).getService().getNom().equals( "Commercial" ) ) {
                request.getRequestDispatcher( "/enregistrerClientVue.jsp" ).forward( request, response );
            } else if ( employeListe.get( j ).getNom().equals( "Acheteur" ) ) {
                request.getRequestDispatcher( "/enregistrerVenteVue.jsp" ).forward( request, response );
            } else if ( employeListe.get( j ).getNom().equals( "Directeur commercial" ) ) {
                request.getRequestDispatcher( "/enregistrerReductionVue.jsp" ).forward( request, response );
            }
        } else {
            String validation = "Identifiant ou mot de passe incorrect";
            request.setAttribute( "validation", validation );
            request.getRequestDispatcher("/loginVue.jsp").forward(request, response);
        }
    }
}


