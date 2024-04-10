package model;

public class Administrador extends Usuario {
	private String chaveDeAcesso;

	public Administrador(String nome, String cpf, String sexo, String login, String senha, String chaveDeAcesso) {
		super(nome, cpf, sexo, login, senha);
		this.chaveDeAcesso = chaveDeAcesso;
	}
	
	public Administrador(String nome, String cpf, String login, String senha, String chaveDeAcesso) {
		super(nome, cpf, login, senha);
		this.chaveDeAcesso = chaveDeAcesso;
	}
	
	public String getChaveDeAcesso() {
		return chaveDeAcesso;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	
}
