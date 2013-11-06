package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import GUI.ClipPanels.ClipPanelComm;
import GUI.ClipPanels.ClipPanelCommFactory;
import GUI.ClipPanels.ClipPanelProgrammaLavoriFactory;

public class CommercialePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static CommercialePanel instance = null;
	private ClipPanelComm clip;
	JPanel commPanel = new JPanel();
	
	
	/**
	 * Costruttore del pannello Programma Lavori 
	 */
	private CommercialePanel() {
		setMinimumSize(new Dimension(500, 600));
		setLayout(new BorderLayout());
		this.addMenuBar();
		this.addCommPanel();

	}
	
	private void addCommPanel() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Aggiunge il ClipPanel, pannello dei button in alto
	 */
	private void addMenuBar() {
		setLayout(new BorderLayout());
		this.clip = (ClipPanelComm) ClipPanelCommFactory.getInstance().makeClipPanel();
		this.add(clip, BorderLayout.NORTH);
		this.validate();
		this.repaint();
	}
	
	/**
	 * Singleton
	 * 
	 * @return CommercialePanel
	 */
	public static CommercialePanel getInstance() {
		if (CommercialePanel.instance == null)
			CommercialePanel.instance = new CommercialePanel();
		return CommercialePanel.instance;
	}
	
}
