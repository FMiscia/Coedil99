package GUI.ClipPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.CoedilFrame;
import GUI.LoginPanel;
import GUI.PanelStart;
import GUI.Abstract.AClipPanel;
import GUI.PLogin.Login;

/**
 * 
 * @author francesco
 *
 * Implementazione di AClipPanel per il menù in alto nella schermata principale
 */
public class ClipPanelMenu extends AClipPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Costruttore
	 */
	public ClipPanelMenu(){
		super();
		this.addlogButton();
		this.fill();
	}

	protected void changeButtonLogState() {
		// TODO Auto-generated method stub
		this.removeAll();
		this.addlogButton();
		this.fill();
		this.validate();
		this.repaint();
	}
	
	private void addlogButton(){

			this.addButton("Logout", "Logout", new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Login.logOut();
                    PanelStart.getInstance().getClipPanel().changeButtonLogState();
                    CoedilFrame.getInstance().montaPanel(LoginPanel.getInstance());
				}

			});

	}
	

}
