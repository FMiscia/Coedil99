package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RDAPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static RDAPanel instance = null;
	private JMenuBar menuBar;
	private JButton menuButton = new JButton();
	
	private RDAPanel() {
		setMinimumSize(new Dimension(500, 600));
		setLayout(new BorderLayout());
		this.addMenuBar();
		RDACenter rdaCenter = new RDACenter();

		add(rdaCenter, BorderLayout.CENTER);

	}
	
	//Singleton
	public static RDAPanel getInstance(){
		if(RDAPanel.instance == null)
			RDAPanel.instance = new RDAPanel();
		return RDAPanel.instance;
	}
	
	private void addMenuBar() {
		// TODO Auto-generated method stub
		menuBar = new JMenuBar();

		//Build the first menu.
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		JMenuItem eMenuItem = new JMenuItem("Exit");
      eMenuItem.setToolTipText("Exit application");
      eMenuItem.addActionListener(
      		new ActionListener(){
      			public void actionPerformed(ActionEvent e){
      				System.exit(0);
      			}
      		}
      );
		menu.add(eMenuItem);
		JMenuItem hMenuItem = new JMenuItem("Help");
		menuBar.add(hMenuItem);
		add(this.menuBar, BorderLayout.NORTH);
	}

}
