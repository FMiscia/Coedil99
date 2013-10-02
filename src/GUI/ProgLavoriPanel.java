package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ProgLavoriPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ProgLavoriPanel instance = null;
	private JMenuBar menuBar;
	private JButton menuButton = new JButton();
	
	private ProgLavoriPanel() {
		setMinimumSize(new Dimension(500, 600));
		setLayout(new BorderLayout());
		this.addMenuBar();
		ProgrammaLavori plCenter = ProgrammaLavori.getInstance();

		add(plCenter, BorderLayout.CENTER);

	}
	
	//Singleton
	public static ProgLavoriPanel getInstance(){
		if(ProgLavoriPanel.instance == null)
			ProgLavoriPanel.instance = new ProgLavoriPanel();
		return ProgLavoriPanel.instance;
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