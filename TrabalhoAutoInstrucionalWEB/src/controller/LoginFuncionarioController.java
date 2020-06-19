package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import geral.Conexao;

@WebServlet("/LoginFuncionarioController")
public class LoginFuncionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginFuncionarioController() {
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

	protected void doProcessa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		try {
			if (autenticar(login, senha, request) == true) {
				HttpSession sessao = request.getSession();
				sessao.setAttribute("login", login);
				request.getRequestDispatcher("/Index.jsp").forward(request, response);
			} else {
				throw new Exception("Login ou Senha invalido");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private boolean autenticar(String login, String senha, HttpServletRequest request) throws Exception {
		String sql = "select * from Funcionario where login = '" + login + "' and senha = '" + senha + "'";
		ResultSet rs = Conexao.getList(sql);

		if (rs == null) {
			throw new Exception("Nao existe este usuario/ senha incorreta");
		}

		// HttpSession session = request.getSession();
		// session.setAttribute("idCliente", rs.getInt("idCliente"));
		return true;
	}
}