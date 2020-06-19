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

@WebServlet("/LoginClienteController")
public class LoginClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginClienteController() {
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

		String email = request.getParameter("emailCliente");
		String senha = request.getParameter("senhaCliente");

		try {
			if (autenticar(email, senha, request) == true) {
				HttpSession sessao = request.getSession();
				sessao.setAttribute("email", email);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} else {
				throw new Exception("Email ou Senha invalido");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private boolean autenticar(String email, String senha, HttpServletRequest request) throws Exception {
		String sql = "select * from Cliente where email = '" + email + "' and senha = '" + senha + "'";
		ResultSet rs = Conexao.getList(sql);

		if (rs == null) {
			throw new Exception("Nao existe este usuario/ senha incorreta");
		}

		HttpSession session = request.getSession();
		session.setAttribute("idCliente", rs.getInt("idCliente"));
		return true;

	}

}