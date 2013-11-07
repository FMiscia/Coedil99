package GUI.ClipPanels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.CoedilFrame;
import GUI.FornitoriCenter;
import GUI.PanelStart;
import GUI.RDACenter;
import GUI.Abstract.AClipPanel;
import GUI.Plichi.PlicoFornitore;

/**
 * Implementazione di ACLipPanel per il menù in alto del FornitoreCenter
 * 
 * @author Simone
 *
 */
public class ClipPanelFornitori extends AClipPanel {

	/**
	 * Costruttore
	 */
	public ClipPanelFornitori() {
		super();
		this.initialize();
	}
	
	/**
	 * Imposta la grafica e i bottoni
	 */
	private void initialize() {
		this.addButton("Menu", "Torna al menu principale",
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						CoedilFrame cf = CoedilFrame.getInstance();
						PanelStart pl = PanelStart.getInstance();
						pl.setBounds(0, 0, cf.getWidth(), cf.getHeight());
						CoedilFrame.getInstance().montaPanel(pl);
					}
				});

		this.addButton("Lista dei Cataloghi", "Elenco di tutti i cataloghi fornitori", new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JButton b = (JButton) arg0.getSource();
				ClipPanelFornitori.this.focusOut();
				b.setBackground(new Color(180, 180, 180));
				FornitoriCenter fc = FornitoriCenter.getInstance();
				fc.refreshFornitori();
				fc.selectPrimoCatalogo();
			}
		});
		
		this.addButton("Nuovo Catalogo Fornitore", "Crea un nuovo Catalogo Fornitore", new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JButton b = (JButton) arg0.getSource();
				ClipPanelFornitori.this.focusOut();
				b.setBackground(new Color(180, 180, 180));
				FornitoriCenter fc = FornitoriCenter.getInstance();
				fc.newCatalogo();
			}
		});

		this.fill();
		this.resetInitialState();
	}
}
