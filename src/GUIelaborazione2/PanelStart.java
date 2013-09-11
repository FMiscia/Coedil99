package GUIelaborazione2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import GUIelaboradistinta.GDistinta;

public class PanelStart extends JPanel{
    public PanelStart(CoedilFrame f){
   
    this.initUI();
   
    }
private void initUI(){
   
    this.setLayout( new BorderLayout() );

        JButton plButton = new JButton("Programma Lavori");
        plButton.setToolTipText("Programma Lavori");
        plButton.setSize(200, 200);
        
        

        plButton.addMouseListener( new MouseAdapter(){
        public void mouseClicked(MouseEvent arg0){
        	ProgrammaLavori p = ProgrammaLavori.getInstance();
        	CoedilFrame.getInstance().montaPanel( p );
        }
        } );


        
        this.add(plButton,BorderLayout.CENTER);
        this.addMenuBar();
        
    }

private void addMenuBar() {
	// TODO Auto-generated method stub
	JMenuBar menuBar = new JMenuBar();

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
	add(menuBar, BorderLayout.NORTH);
}

} 