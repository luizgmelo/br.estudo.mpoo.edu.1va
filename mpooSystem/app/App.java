package app;

import controller.ChaveAcessoController;
import controller.LoginController;

import controller.MenuController;
import model.BaseDados;
import view.CadastrarView;
import view.ChaveAcessoView;
import view.LoginView;
import view.MenuView;

public class App {

	public static void main(String[] args) {
		BaseDados.createBase();
		MenuView menuView = new MenuView();
		CadastrarView cadastrarView = new CadastrarView();
		LoginView loginView = new LoginView();
		ChaveAcessoView chaveAcessoView = new ChaveAcessoView();
		
		MenuController menuController = new MenuController(menuView, cadastrarView, loginView, chaveAcessoView);
		LoginController loginController = new LoginController(loginView, menuController);
		ChaveAcessoController chaveAcessoController = new ChaveAcessoController(menuController, chaveAcessoView);
	}

}
