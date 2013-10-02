package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RDAPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static RDAPanel instance = null;
	
	private RDAPanel() {
		setMinimumSize(new Dimension(500, 600));
		setLayout(new BorderLayout());
		RDACenter rdaCenter = new RDACenter();

		add(rdaCenter, BorderLayout.CENTER);

	}
	
	//Singleton
	public static RDAPanel getInstance(){
		if(RDAPanel.instance == null)
			RDAPanel.instance = new RDAPanel();
		return RDAPanel.instance;
	}
	


}
