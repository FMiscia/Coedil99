package GUI.Abstract;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import GUI.Utilities.WrapLayout;

/**
 * @author francesco
 * 
 */
public abstract class ALista extends JScrollPane {

	private static final long serialVersionUID = 1L;

	protected static Color coloreDeselezionato = new Color(30, 144, 255);
	protected JPanel panel;
	protected ARiepilogoRDA riepilogoRDA;

	/**
	 * Abstract Factory
	 * 
	 */
	public ALista() {
		this.initialize();
	}

	/**
	 * Metodo che deseleziona tutti gli elementi della lista
	 * 
	 */
	public void deselectAll() {
		for (Component c : panel.getComponents()) {
			c.setBackground(ALista.coloreDeselezionato);
			c.validate();
			c.repaint();
		}
	}

	public JPanel getPanel() {
		return this.panel;
	}

	/**
	 * Metodo astratto che carica la lista a partire dallo stato della RDA che
	 * si vuole caricare
	 * 
	 * @param s
	 */
	public abstract void load(String s);

	/**
	 * Metodo astratto che carica la lista
	 * 
	 */
	public abstract void load();

	/**
	 * Metodo che riuove dalla lista tutti gli elementi al suo interno
	 * 
	 */
	public void svuota() {
		this.panel.removeAll();
		this.panel.setPreferredSize(new Dimension(this.panel.getWidth(),0));
		this.panel.validate();
		this.panel.repaint();
	}

	/**
	 * @author francesco
	 * 
	 *         Aggiorna posizione e valore del Titolo e info aggiutivi del
	 *         panelTitle
	 */
	public abstract void updatePanelRDA();

	/**
	 * Imposta la grafica
	 */
	private void initialize() {
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.getVerticalScrollBar().setUnitIncrement(20);
		this.panel = new JPanel(new WrapLayout());
		this.setViewportView(this.panel);
	}
	
	

}
