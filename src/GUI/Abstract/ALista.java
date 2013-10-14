package GUI.Abstract;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import coedil99.model.RDA;

import GUI.WrapLayout;

/**
 * @author francesco
 *
 */
public abstract class ALista extends JScrollPane {

	private static final long serialVersionUID = 1L;

	protected JPanel panel;
	protected JPanel panelTitle = new JPanel();
	JLabel labeltitle = new JLabel("Lista Righe RDA");
	JLabel labelprezzo = new JLabel("Prezzo RDA:");
	
	

	public ALista() {
		this.panel = new JPanel(null);
		this.setViewportView(this.panel);
		this.panel.setLayout(new WrapLayout());
	}

	public void deselectAll() {
		// TODO Auto-generated method stub
		for(Component c:panel.getComponents()){
			c.setBackground(new Color(30,144,255));
			c.validate();
			c.repaint();
		}
	}
	
	public JPanel getPanel(){
		return this.panel;
	}

	public abstract void load(ArrayList<Object> t);
	
	/**
	 * @author francesco
	 * Aggiorna posizione e valore di Titolo e Prezzo delle righe RDA
	 */
	public void updateTitlePanel(){
		this.panelTitle.removeAll();
		panelTitle.setSize(new Dimension(200, 50));
		panelTitle.setPreferredSize(new Dimension(200, 50));
		panel.add(panelTitle,0);
		panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));	
		panelTitle.add(labeltitle);
		panelTitle.add(labelprezzo);
		JLabel prezzo = new JLabel("0.0");
		panelTitle.add(prezzo);
		this.validate();
		this.repaint();
		
	}

}
