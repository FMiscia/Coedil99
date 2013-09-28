package GUIelaborazione2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import elaboradistinta.operation.ODistinta;

public abstract class ClipPanel extends JPanel {
	

	private static final long serialVersionUID = 1L;


	public ClipPanel() {
		// TODO Auto-generated constructor stub
		this.setLayout(new GridLayout(1, 0));
		this.setBackground(new Color(222, 184, 135));
		this.setPreferredSize(new Dimension(210, 50));
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
	

	
	
}
