package controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import model.BaseDados;
import model.Mensagem;
import view.CadastrarView;
import view.ChaveAcessoView;
import view.LoginView;
import view.MensagemView;

public class LoginController implements ActionListener {
	private LoginView loginView;
	private CadastrarView cadastrarView;
	private ChaveAcessoView chaveAcessoView;
	private MenuController menuController;
		
	public LoginController(LoginView loginView, MenuController menuController) {
		this.loginView = loginView;
		this.menuController = menuController;
		control();
	}

	public void control() {
		loginView.getAddButton().addActionListener(this);
		loginView.getSairButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginView.getAddButton()) {	
			buttonContext();
		} else if (e.getSource() == loginView.getSairButton()) {
			loginView.setVisible(false);
		}
	}
	
	// <TO-DO> Add people to DataBase or Receive NullPointerException
	public void buttonContext() {
		String login = loginView.getLoginField().getText();
		String senha = loginView.getSenhaField().getText();
	
		if (BaseDados.isUsuario(login, senha)) {
			menuController.setAdminOn(true);
			menuController.setChaveOk(false);
			MensagemView.exibirMensagem(Mensagem.USUARIO_LOGIN_SUCESS);
			loginView.setVisible(false);
		} else {
			menuController.setAdminOn(false);
			menuController.setChaveOk(false);
			MensagemView.exibirMensagem(Mensagem.USUARIO_LOGIN_ERROR);
		}
	}
	
	
	
}
