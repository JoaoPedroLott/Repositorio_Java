package beans;

public class Funcionario {

	private String loginFuncionario;
	private String senhaFuncionario;
	private String nomeFuncionario;
	
	public Funcionario() {
		
	}

	public String getLoginFuncionario() {
		return loginFuncionario;
	}

	public void setLoginFuncionario(String loginFuncionario) {
		this.loginFuncionario = loginFuncionario;
	}

	public String getSenhaFuncionario() {
		return senhaFuncionario;
	}

	public void setSenhaFuncionario(String senhaFuncionario) {
		this.senhaFuncionario = senhaFuncionario;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	@Override
	public String toString() {
		return "Funcionario [loginFuncionario=" + loginFuncionario + ", senhaFuncionario=" + senhaFuncionario
				+ ", nomeFuncionario=" + nomeFuncionario + "]";
	}
}
