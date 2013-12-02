package GUI;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import GUI.Panels.LoginDialog;


public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private LoginDialog pannelloCentrale = new LoginDialog();



	private static LoginPanel myInstance;
    
	/**
	 * Costruttore
	 */
	private LoginPanel() {
		this.initUI();
	}

	/**
	 * Inizializza il panel con un ClipPanel e il Pannello di selezione attività
	 */
	public void initUI() {
	    this.setLayout(new BorderLayout());
		this.addPannelloCentrale();
	}



	private void addPannelloCentrale() {
		this.pannelloCentrale = new LoginDialog();
		this.add(pannelloCentrale, BorderLayout.CENTER);

	}

	
	/**
	 * Singleton
	 * 
	 * @return PanelStart
	 */
	public static LoginPanel getInstance() {
		if (myInstance == null) {
			myInstance = new LoginPanel();
		}
		return myInstance;
	}

}