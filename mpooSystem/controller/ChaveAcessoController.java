package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BaseDados;
import model.Mensagem;
import view.ChaveAcessoView;
import view.MensagemView;

public class ChaveAcessoController {
	private MenuController menuController;
	private ChaveAcessoView chaveAcessoView;
	
	public ChaveAcessoController(MenuController menuController, ChaveAcessoView chaveAcessoView) {
		this.menuController = menuController;
		this.chaveAcessoView = chaveAcessoView;
		control();
	}
	
	private void control() {
		chaveAcessoView.getValidarButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (BaseDados.isAdmin(chaveAcessoView.getChaveAcessoField().getText())) {
					menuController.setChaveOk(true);
					MensagemView.exibirMensagem(Mensagem.ADMINISTRADOR_SUCESS);
				} else {
					menuController.setChaveOk(false);
					MensagemView.exibirMensagem(Mensagem.ADMINISTRADOR_ERROR);
				}
				chaveAcessoView.setVisible(false);
			}
		});
	}
	
	
}
