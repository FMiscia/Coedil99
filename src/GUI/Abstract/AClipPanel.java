package GUI.Abstract;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

import coedil99.controller.GestisciRDAHandler;

public abstract class AClipPanel extends JPanel {
	
	public static HashMap<String, Integer> RDAButtonState;
	{
		RDAButtonState = new HashMap<String, Integer>();
		RDAButtonState.put(GestisciRDAHandler.CONFERMATA, 3);
		RDAButtonState.put(GestisciRDAHandler.ATTESA_CONFERMA, 2);
		RDAButtonState.put(GestisciRDAHandler.CONGELATA, 1);		
	}
	private static final long serialVersionUID = 1L;
	private ArrayList<JButton> buttons = new ArrayList<JButton>(); 
	

	public AClipPanel() {
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
		JButton temp = new JButton();
		temp.setLayout(new BorderLayout());
		temp.setToolTipText(ToolTip);
		temp.setHorizontalTextPosition(SwingConstants.LEFT);
		temp.addActionListener(click);
		temp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JLabel nome = new JLabel(label);
		temp.add(nome,BorderLayout.WEST);
		this.buttons.add(temp);
		this.add(temp);
		this.validate();
		this.repaint();	
	}
	
	protected void AddNotificaLabel(String value,String RDAState){
		
		JLabel notifica = new JLabel(value);
		notifica.setHorizontalAlignment(SwingConstants.RIGHT);
		if(this.getButtons().get(AClipPanel.RDAButtonState.get(RDAState)).getComponentCount() != 1)
			this.getButtons().get(AClipPanel.RDAButtonState.get(RDAState)).remove(1);
		this.getButtons().get(AClipPanel.RDAButtonState.get(RDAState)).add(notifica,BorderLayout.EAST);
	}
	
	
	
	public JButton createButton(String label,String ToolTip){
		JButton temp = new JButton(label);
		temp.setToolTipText(ToolTip);
		temp.setHorizontalTextPosition(SwingConstants.LEFT);
		temp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		return temp;
		
	}
	
	public void addFintoButton(){
		JLabel temp = new JLabel();
		this.add(temp);
		this.validate();
		this.repaint();
	}
	
	public void fill(){
		int totButton = 8;
		for ( int n = totButton - this.getComponentCount(); n>0 ;n-- ){
			if(n<=totButton && n!=2 && n!=1)
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
	
	public void focusOut(){
		for(JButton b: buttons){
			b.setBackground(UIManager.getColor("Button.background"));
			b.setEnabled(true);
		}
	}
	
	public Boolean isButtonFocused(JButton b){
		return b.getBackground().equals(new Color(180,180,180));
	}
	
	public void resetInitialState(){
		this.focusOut();
		this.getButtons().get(1).setBackground(new Color(180,180,180));
	}

	public ArrayList<JButton> getButtons() {
		return buttons;
	}
	
	

	
	
}
