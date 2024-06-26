package model;

import java.util.ArrayList;

public class BaseDados {
	private static ArrayList<Pessoa> pessoas;
		
	public static void createBase() {
		inicializarBase();
	}
	
	private static void inicializarBase() {
		pessoas = new ArrayList<Pessoa>();
		adicionarPessoa(new Administrador("Godofredo Silva", "358.251.830-27", "Masculino", "admin", "admin", "ADMIN001"));
		adicionarPessoa(new Usuario("Maria Silva", "833.533.163-34", "Feminino", "mariasilva", "mAriA"));
		adicionarPessoa(new Usuario("José Santos", "833.533.163-34", "Masculino", "joseSantos", "joseSantos"));
	}
	
	public static boolean adicionarPessoa(Pessoa pessoa) {
		if (pessoa == null)
			return false;
		if (ValidadorCPF.validarCPF(pessoa.getCpf())) {
			if (!isPessoa(pessoa))
				return pessoas.add(pessoa);
		}
		return false;
	}
	
	private static Pessoa buscarPessoa(String cpf) {
		if (cpf == null) {
			return null;
		}
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getCpf() == cpf) {
				return pessoa;
			}
		}
		return null;
	}
	
	public static boolean isAdmin(String chaveAcesso) {
		if (chaveAcesso == null) {
			return false;
		}
		
		for (Pessoa pessoa : pessoas)
			if (pessoa instanceof Administrador)
				if(((Administrador) pessoa).getChaveDeAcesso().equals(chaveAcesso)) {
					return true;
				}
		return false;
	}
	
	public static boolean isPessoa(Pessoa pessoa) {
		return pessoas.contains(buscarPessoa(pessoa.getCpf()));
	}
	
	public static boolean isUsuario(String login, String senha) {
		if (login == null || senha == null) {
			return false;
		}
		
		for (Pessoa pessoa: pessoas) {
			if (pessoa instanceof Usuario) {
				if (((Usuario) pessoa).getLogin().equalsIgnoreCase(login)
				 && ((Usuario) pessoa).getSenha().equals(senha)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean isUsuario(Usuario usuario) {
		if (usuario instanceof Usuario) {
			return isUsuario(usuario.getLogin(), usuario.getSenha());
		}
		return false;
	}
	
	public static boolean removerPessoa(Pessoa pessoa) {
		return pessoas.remove(buscarPessoa(pessoa.getCpf()));
	}
	
	public static ArrayList<String> listPessoas() { 
		ArrayList<String> listaPessoas = new ArrayList<String>();
		for (Pessoa pessoa : pessoas) {
			listaPessoas.add(pessoa.toString());
		}
		return listaPessoas;
	}
	
	public static ArrayList<String> listUsuarios() {
		ArrayList<String> listaUsuarios = new ArrayList<String>();
		for (Pessoa pessoa : pessoas) {
			if (pessoa instanceof Usuario) {
				listaUsuarios.add(pessoa.toString());
			}
		}
		return listaUsuarios;
	}
}
