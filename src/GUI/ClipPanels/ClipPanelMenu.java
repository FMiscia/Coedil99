package GUI.ClipPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.CoedilFrame;
import GUI.PanelStart;
import GUI.Abstract.AClipPanel;
import GUI.Login.Login;
import GUI.Login.LoginDialog;

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
		//se l'utente non è loggato
		if ( !Login.getLogged() ){
			this.addButton("Login", "Login", new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
	                LoginDialog loginDlg = new LoginDialog(CoedilFrame.getInstance());
	                loginDlg.setVisible(true);
	                // if logon successfully
	                if(loginDlg.isSucceeded()){
	                    PanelStart.getInstance().setButtonsAttivi(true);
	                    PanelStart.getInstance().getClipPanel().changeButtonLogState();
	                }	
				}

			});
		}
		// se l'utente é loggato
		if ( Login.getLogged() ){
			this.addButton("Logout", "Logout", new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Login.logOut();
					PanelStart.getInstance().setButtonsAttivi(false);
                    PanelStart.getInstance().getClipPanel().changeButtonLogState();
				}

			});
		}
	}
	

}
