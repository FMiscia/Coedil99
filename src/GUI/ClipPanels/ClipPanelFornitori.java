package GUI.ClipPanels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

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
				if (!ClipPanelFornitori.this.clickFromNuovoCatalogo()) {
					return;
				}
				PlicoFornitore.getInstance().abortImporting();
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
				if (!ClipPanelFornitori.this.clickFromNuovoCatalogo() ) {
					return;
				}
				PlicoFornitore.getInstance().abortImporting();
				JButton b = (JButton) arg0.getSource();
				ClipPanelFornitori.this.focusOut();
				b.setBackground(new Color(180, 180, 180));
				FornitoriCenter.getInstance().newCatalogo();
			}
		});

		this.fill();
		this.resetInitialState();
	}
	
	/**
	 * Imposta il focus sul bottone delle RDA congelate
	 */
	public void focusToListaCataloghi() {
		this.focusOut();
		JButton b = (JButton) ClipPanelFornitori.this.getComponent(1);
		b.setBackground(new Color(180, 180, 180));
	}
	
	
	/**
	 * Metodo che ritorna un booleano che indica se si sta importando o no un nuovo catalogo fornitore
	 * @return
	 */
	public boolean isImporting(){
		return PlicoFornitore.getInstance().isImporting();
	}
	
	
	/**
	 * Fornisce true se siamo in focus sul bottone per la creazione di un nuovo catalogo
	 * @return bool:boolean
	 */
	public boolean isSelectedNuovoCatalogo() {
		JButton b = (JButton) ClipPanelFornitori.this.getButtons().get(2);
		return this.isButtonFocused(b);
	}
	
	/**
	 * Metodo che fornisce true o false se stiamo importando un nuovo catalogo
	 * @return
	 */
	private boolean clickFromNuovoCatalogo(){
		if( this.isImporting() && this.isSelectedNuovoCatalogo() ){
			Object[] options = { "Si", "No" };
			int n = JOptionPane.showOptionDialog(null,
				"Sicuro di voler abbandonare la creazione del Catalogo?\n"
						+ "Nota: Le modifiche non salvate andranno perse",
				"Conferma operazione", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		if (n == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}
	}
	return true;
	}
}
