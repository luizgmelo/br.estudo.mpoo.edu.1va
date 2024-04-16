package app;

import controller.LoginController;
import controller.MenuController;
import view.CadastrarView;
import view.ChaveAcessoView;
import view.LoginView;
import view.MenuView;

public class App {

	public static void main(String[] args) {
		MenuView menuView = new MenuView();
		CadastrarView cadastrarView = new CadastrarView();
		LoginView loginView = new LoginView();
		ChaveAcessoView chaveAcessoView = new ChaveAcessoView();
		
		MenuController menuController = new MenuController(menuView, cadastrarView, loginView, chaveAcessoView);
		LoginController loginController = new LoginController(loginView, menuController);
	}

}
