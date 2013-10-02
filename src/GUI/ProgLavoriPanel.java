package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ProgLavoriPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ProgLavoriPanel instance = null;
	private JButton menuButton = new JButton();
	
	private ProgLavoriPanel() {
		setMinimumSize(new Dimension(500, 600));
		setLayout(new BorderLayout());
		ProgrammaLavori plCenter = ProgrammaLavori.getInstance();

		add(plCenter, BorderLayout.CENTER);

	}
	
	//Singleton
	public static ProgLavoriPanel getInstance(){
		if(ProgLavoriPanel.instance == null)
			ProgLavoriPanel.instance = new ProgLavoriPanel();
		return ProgLavoriPanel.instance;
	}
	

}