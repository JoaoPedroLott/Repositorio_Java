package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Cliente;
import beans.Livro;
import beans.Pedido;
import geral.ClienteDAO;
import geral.LivroDAO;
import geral.PedidoDAO;


@WebServlet("/ClienteController")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ClienteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcessa(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcessa(request, response);
	}

	protected void doProcessa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String acao = request.getParameter("acao");
		
		RequestDispatcher rd = null;
		
		if ( acao.equals("gravarCliente")) {
			String nomeCliente = request.getParameter("nomeCliente");
			String emailCliente = request.getParameter("emailCliente");
			String senhaCliente = request.getParameter("senhaCliente");
			
			Cliente cliente = new Cliente();
			cliente.setNomeCliente(nomeCliente);
			cliente.setEmailCliente(emailCliente);
			cliente.setSenhaCliente(senhaCliente);
			
			try {
				ClienteDAO.Incluir(cliente);
				ServletContext sc = getServletContext();
				rd = sc.getRequestDispatcher("/index.jsp");
				request.setAttribute("cliente", cliente);
				rd.forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (acao.equals("gravarPedidos")) {
			String dmaPedido = request.getParameter("dmaPedido");
			String horario = request.getParameter("horario");
			int idCliente = Integer.parseInt(request.getParameter("idCliente"));
			
			Pedido pedido = new Pedido();
			pedido.setDmaPedido(dmaPedido);
			pedido.setHorario(horario);
			pedido.setIdCliente(idCliente);
			try {
				PedidoDAO.Incluir(pedido);
				ServletContext sc = getServletContext();
				rd = sc.getRequestDispatcher("/index.jsp");
				request.setAttribute("pedido", pedido);
				rd.forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (acao.equals("listarPedidos")) {
						
		}  else if (acao.equals("listarLivros")) {
			try {
				ArrayList<Livro> livros = LivroDAO.getData();
				// cria um for pra exibir
				//ftp://ftpaluno.umc.br/Aluno/Pedro_Toledo/AWOO/Carrinho%20de%20Compras.pdf
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		rd.forward(request, response);
	}

}
