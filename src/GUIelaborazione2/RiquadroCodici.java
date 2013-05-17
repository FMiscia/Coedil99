package GUIelaborazione2;


import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import java.awt.BorderLayout;

public class RiquadroCodici extends JScrollPane {
	
	private JPanel panel;
	
	public RiquadroCodici(){
		panel = new JPanel(null);
		setViewportView(panel);
		panel.setLayout(new BorderLayout(0, 0));
		load();
	}
	
	public void load(){
		int row = 10;
		panel.setPreferredSize(new Dimension(200,row*70));
		for(int i=0; i<row; ++i){
			RiquadroCodiceInterno r = new RiquadroCodiceInterno();
			r.setLocation(0, i*(r.getHeight()+10));
			panel.add(r);
		}
		setPreferredSize(new Dimension(218,panel.getHeight()));
		
	}
}
