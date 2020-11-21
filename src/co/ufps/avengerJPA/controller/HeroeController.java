package co.ufps.avengerJPA.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.ufps.avengerJPA.dao.EstadoDao;
import co.ufps.avengerJPA.dao.GeneroDao;
import co.ufps.avengerJPA.dao.HeroeDao;
import co.ufps.avengerJPA.model.Estado;
import co.ufps.avengerJPA.model.Genero;
import co.ufps.avengerJPA.model.Heroe;

/**
 * Servlet implementation class HeroeController
 */
@WebServlet("/Heroe")
public class HeroeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HeroeDao heroeDao = new HeroeDao();
	GeneroDao generoDao = new GeneroDao();
	EstadoDao estadoDao = new EstadoDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeroeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		String action = request.getParameter("action");
		System.out.println(action);
			switch(action) {
			case "new":
				showNewForm(request, response);
				break;
			case "insert":
				insertarHeroe(request, response);
				break;
			case "delete":
				eliminarHeroe(request, response);
				break;
			case "edit":
				showEditHeroe(request, response);
				break;
			case "update":
				actualizarHeroe(request, response);
				break;
			case "buscar":
				buscarHeroe(request, response);
				break;	
			case "listar":
				listHeroe(request, response);
				break;
			case "participacion":
				listParticipacion(request, response);
				break;	
			default:
				index(request,response);	
					
			}
			
	}

	private void listParticipacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Heroe heroe =  new HeroeDao().find(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar-participacion.jsp");
		request.setAttribute("heroe", heroe);
		request.setAttribute("participaciones", heroe.getPeliculas());
        dispatcher.forward(request, response);

	}

	private void index(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
			request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List <Estado> estados = estadoDao.list();
		List <Genero> generos = generoDao.list();
        RequestDispatcher dispatcher = request.getRequestDispatcher("heroe-form.jsp");
        request.setAttribute("estados", estados);
        request.setAttribute("generos", generos);
        dispatcher.forward(request, response);
	}
	
	private void listHeroe(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		List <Heroe> listaHeroes = heroeDao.list();
		request.getSession().setAttribute("listaHeroes", listaHeroes);	
		request.getRequestDispatcher("listar-heroes.jsp").forward(request, response);
		
	}

	private void buscarHeroe(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void actualizarHeroe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 	Heroe heroe = heroeDao.find(Integer.parseInt(request.getParameter("id")));
	        heroe.setNombre(request.getParameter("nombre"));
	        heroe.setHeroe(request.getParameter("alias"));
	        
	        heroeDao.update(heroe);
	        List <Heroe> listaHeroes = heroeDao.list();
			request.getSession().setAttribute("listaHeroes", listaHeroes);
		    response.sendRedirect("listar-heroes.jsp");
	}

	private void showEditHeroe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List <Estado> estados = estadoDao.list();
		List <Genero> generos = generoDao.list();
        int id = Integer.parseInt(request.getParameter("id"));
        Heroe existingHeroe = heroeDao.find(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("heroe-form.jsp");
        request.setAttribute("heroe", existingHeroe);
        request.setAttribute("estados", estados);
        request.setAttribute("generos", generos);
        dispatcher.forward(request, response);
	}

	private void eliminarHeroe(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		 	int id = Integer.parseInt(request.getParameter("id"));
		    Heroe heroe = heroeDao.find(id);
		    heroeDao.delete(heroe);
		    List <Heroe> listaHeroes = heroeDao.list();
			request.getSession().setAttribute("listaHeroes", listaHeroes);
		    response.sendRedirect("listar-heroes.jsp");
	}

	private void insertarHeroe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		Heroe heroe = new Heroe();
		Genero genero = generoDao.find(request.getParameter("generos"));
		Estado estado = estadoDao.find(request.getParameter("estados"));
		heroe.setNombre(request.getParameter("nombre"));
		heroe.setHeroe(request.getParameter("alias"));
		heroe.setGeneroBean(genero);
		heroe.setEstadoBean(estado);
		heroeDao.insert(heroe);
		List <Heroe> listaHeroes = heroeDao.list();
		request.getSession().setAttribute("listaHeroes", listaHeroes);	
	    response.sendRedirect("listar-heroes.jsp");
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
