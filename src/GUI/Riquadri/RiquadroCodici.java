package GUI.Riquadri;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import GUI.WrapLayout;

public abstract class RiquadroCodici extends JScrollPane {

	private static final long serialVersionUID = 1L;

	protected JPanel panel;

	public RiquadroCodici() {
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

	public abstract void load(ArrayList<Object> t);

}
