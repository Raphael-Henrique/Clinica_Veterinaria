package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/Consulta", "/insert", "/edit", "/update", "/delete" })
public class ConsultaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();
	JavaBeans agendamento = new JavaBeans();

	public ConsultaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/Consulta")) {
			consultas(request, response);
		} else if (action.equals("/insert")) {
			novaConsulta(request, response);
		} else if (action.equals("/edit")) {
			listarConsulta(request, response);
		} else if (action.equals("/update")) {
			editarConsulta(request, response);
		} else if (action.equals("/delete")) {
			deletarConsulta(request, response);
		}

		else {
			response.sendRedirect("Index.html");
		}
	}

	protected void consultas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<JavaBeans> lista = dao.listarConsultas();

		request.setAttribute("consultas", lista);
		RequestDispatcher rd = request.getRequestDispatcher("Lista_Edicao.jsp");
		rd.forward(request, response);
	}

	
	protected void novaConsulta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		agendamento.setNome_cliente(request.getParameter("nome_cliente"));
		agendamento.setNome_pet(request.getParameter("nome_pet"));
		agendamento.setId_anim(request.getParameter("id_anim"));
		agendamento.setId_vet(request.getParameter("id_vet"));
		agendamento.setData_consulta(request.getParameter("data_consulta"));

		dao.inserirAgendamento(agendamento);

		response.sendRedirect("Consulta");
	}

	protected void listarConsulta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id_consulta = request.getParameter("id_consulta");
		System.out.println(id_consulta);
		
		agendamento.setId_consulta(id_consulta);

		dao.selecionarConsulta(agendamento);

		request.setAttribute("id_consulta", agendamento.getId_consulta());
		request.setAttribute("nome_cliente", agendamento.getNome_cliente());
		request.setAttribute("nome_pet", agendamento.getNome_pet());
		request.setAttribute("id_anim", agendamento.getId_anim());
		request.setAttribute("id_vet", agendamento.getId_vet());

		RequestDispatcher rd = request.getRequestDispatcher("Consulta");
		rd.forward(request, response);
	}
	
	protected void editarConsulta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		agendamento.setId_consulta(request.getParameter("id_consulta"));
		agendamento.setNome_cliente(request.getParameter("nome_cliente"));
		agendamento.setNome_pet(request.getParameter("nome_pet"));
		agendamento.setId_anim(request.getParameter("id_anim"));
		agendamento.setId_vet(request.getParameter("id_vet"));
		agendamento.setData_consulta(request.getParameter("data_consulta"));

		dao.alterarConsulta(agendamento);

		response.sendRedirect("Consulta");
	}
	
		protected void deletarConsulta(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String id_consulta = request.getParameter("id_consulta");

			agendamento.setId_consulta(id_consulta);

			dao.deletarConsulta(agendamento);

			response.sendRedirect("Consulta");
		}
}