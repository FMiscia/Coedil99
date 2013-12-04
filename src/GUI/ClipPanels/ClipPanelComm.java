package GUI.ClipPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import coedil99.controller.GestisciDipendenteHandler;

import GUI.CoedilFrame;
import GUI.LoginPanel;
import GUI.PanelStart;
import GUI.Abstract.AClipPanel;

/**
 * 
 * @author francesco
 *
 * Implementazione di AClipPanel per il menù in alto nella schermata principale
 */
public class ClipPanelComm extends AClipPanel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Costruttore
	 */
	public ClipPanelComm(){
		super();
		//this.addlogButton();
		this.fill();
	}

	protected void changeButtonLogState() {
		this.removeAll();
		//this.addlogButton();
		this.fill();
		this.validate();
		this.repaint();
	}
	
	private void addlogButton(){

		this.addButton("Logout", "Logout", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GestisciDipendenteHandler.getInstance().logOut();
                PanelStart.getInstance().getClipPanel().changeButtonLogState();
                CoedilFrame.getInstance().montaPanel(LoginPanel.getInstance());
			}

		});
		
	}
	

}
