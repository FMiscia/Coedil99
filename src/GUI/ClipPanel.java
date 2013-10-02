package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public abstract class ClipPanel extends JPanel {
	

	private static final long serialVersionUID = 1L;


	public ClipPanel() {
		// TODO Auto-generated constructor stub
		this.setLayout(new GridLayout(1, 0));
		this.setBackground(new Color(238, 238, 238));
		this.setPreferredSize(new Dimension(210, 40));
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
	}
	
	public void aggiornaClipPanel(Object t) {
		
		this.validate();
		this.repaint();
	}
	
	public void addButton(String label,String ToolTip,ActionListener click){
		JButton temp = new JButton(label);
		temp.setToolTipText(ToolTip);
		temp.setHorizontalTextPosition(SwingConstants.LEFT);
		temp.addActionListener(click);
		this.add(temp);
		this.validate();
		this.repaint();
		
	}
	
	public void addFintoButton(){
		JLabel temp = new JLabel();
		this.add(temp);
		this.validate();
		this.repaint();
		
	}
	
	public void fill(){
		int totButton = 10;
		for ( int n = totButton - this.getComponentCount(); n>0 ;n-- ){
			if(n<totButton-2 && n!=2 && n!=1)
				this.addFintoButton();
			if(n==2)
				this.addButton("Help", "Help", null);
			if(n==1)
				this.addButton("Exit", "Close Coedil99",       		new ActionListener(){
      			public void actionPerformed(ActionEvent e){
      				System.exit(0);
      			}
      		});
		}
	}
	

	
	
}
