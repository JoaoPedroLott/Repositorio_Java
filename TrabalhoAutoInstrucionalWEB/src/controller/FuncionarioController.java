package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Assunto;
import beans.Autor;
import beans.Funcionario;
import beans.Livro;
import geral.AssuntoDAO;
import geral.AutorDAO;
import geral.FuncionarioDAO;
import geral.LivroDAO;


@WebServlet("/FuncionarioController")
public class FuncionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FuncionarioController() {
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
		if ( acao.equals("gravarLivro")) {
			String titulo = request.getParameter("tituloLivro");
			double preco = Double.parseDouble(request.getParameter("precoLivro"));
			int ano = Integer.parseInt(request.getParameter("anoLivro"));
			int paginas = Integer.parseInt(request.getParameter("paginasLivro"));
			int idAssunto = Integer.parseInt(request.getParameter("idAssuntoLivro"));
			
			Livro livro = new Livro();
			livro.setTitulo(titulo);
			livro.setPreco(preco);
			livro.setAno(ano);
			livro.setPaginas(paginas);
			livro.setIdAssunto(idAssunto);
			
			try {
				LivroDAO.Incluir(livro);
				ServletContext sc = getServletContext();
				rd = sc.getRequestDispatcher("/index.jsp");
				request.setAttribute("livro", livro);
				rd.forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if ( acao.equals("listarLivro")) {
			
		} else if ( acao.equals("listarAutor")) {
			
		} else if ( acao.equals("gravarAutor")) {
			String nomeAutor = request.getParameter("nomeAutor");
			
			Autor autor = new Autor();
			autor.setNomeAutor(nomeAutor);
			
			try {
				AutorDAO.Incluir(autor);
				ServletContext sc = getServletContext();
				rd = sc.getRequestDispatcher("/index.jsp");
				request.setAttribute("autor", autor);
				rd.forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if ( acao.equals("gravarAssunto")) {
			String nomeAssunto = request.getParameter("nomeAssunto");
			
			Assunto assunto = new Assunto();
			assunto.setNomeAssunto(nomeAssunto);
			
			try {
				AssuntoDAO.Incluir(assunto);
				ServletContext sc = getServletContext();
				rd = sc.getRequestDispatcher("/index.jsp");
				request.setAttribute("assunto", assunto);
				rd.forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if ( acao.equals("listarAssunto")) {
			
		} else if ( acao.equals("listarCliente")) {
			
		} else if ( acao.equals("gravarFuncionario")) {
			String loginFuncionario = request.getParameter("loginFuncionario");
			String senhaFuncionario = request.getParameter("senhaFuncionario");
			String nomeFuncionario = request.getParameter("nomeFuncionario");
			
			Funcionario funcionario = new Funcionario();
			funcionario.setLoginFuncionario(loginFuncionario);
			funcionario.setSenhaFuncionario(senhaFuncionario);
			funcionario.setNomeFuncionario(nomeFuncionario);
			
			try {
				FuncionarioDAO.Incluir(funcionario);
				ServletContext sc = getServletContext();
				rd = sc.getRequestDispatcher("/index.jsp");
				request.setAttribute("funcionario", funcionario);
				rd.forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if ( acao.equals("listarFuncionario")) {
			
		}
		
		rd.forward(request, response);
		
	}
}
