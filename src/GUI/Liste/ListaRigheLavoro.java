package GUI.Liste;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GUI.Abstract.ALista;
import GUI.Abstract.ARiepilogoDistinta;
import GUI.Avvisi.AvvisoRigaLavoro;
import GUI.Avvisi.AvvisoRigaLavoroFactory;
import GUI.Card.CardRigaLavoro;
import GUI.Card.CardRigaLavoroFactory;
import GUI.Riepiloghi.RiepilogoDistintaFactory;

/**
 * 
 * @author francesco
 * 
 *         Gestisce la lista delle righe di unaRDA selezionata
 */
public class ListaRigheLavoro extends ALista {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ARiepilogoDistinta riepilogoDistinta;
	
	/**
	 * Costruttore
	 */
	public ListaRigheLavoro() {
		super();
		this.setPreferredSize(new Dimension(300, 0));
		this.validate();
		this.repaint();
	}

	/**
	 * Carica le righe lavoro
	 * 
	 * @param t
	 */
	public void load(ArrayList<Object> t) {
		this.updatePanel();
		int row = t.size();
		CardRigaLavoro riquadroRigaLavoro = null;
		if(row == 0){
			this.panel.add((AvvisoRigaLavoro) AvvisoRigaLavoroFactory.getInstance()
					.makeAvviso());
			this.panel.setPreferredSize(new Dimension(this.panel.getWidth(), 70));
		} else {
			for (int k = 0; k < row; k++) {
				riquadroRigaLavoro = (CardRigaLavoro) CardRigaLavoroFactory.getInstance()
						.makeCard(this);
				riquadroRigaLavoro.load( t.get(k) );
				this.panel.add(riquadroRigaLavoro);
				this.panel.validate();
				this.panel.repaint();
			}
		}
		if (riquadroRigaLavoro != null)
			this.panel.setPreferredSize(new Dimension(this.panel.getWidth(),
					this.riepilogoDistinta.getHeight() + row
							* (this.panel.getComponent(1).getHeight() + 10)));
		this.validate();
		this.repaint();
	}

	/**
	 * Rimuove un riquadro contenente una riga lavoro
	 * 
	 * @param cardRigaLavoro
	 */
	public void removeRiquadro(CardRigaLavoro cardRigaLavoro) {
		this.panel.remove(cardRigaLavoro);
		this.validate();
		this.repaint();
	}

	public JPanel getPanel() {
		return this.panel;
	}

	/**
	 * Aggiorna la lista delle righe lavoro e il riepilogo subito dopo una modifica
	 */
	public void updatePanel() {
		this.panel.removeAll();
		this.riepilogoDistinta = (ARiepilogoDistinta) RiepilogoDistintaFactory.getInstance().makeRiepilogo();
		if (this.riepilogoDistinta != null) {
			this.riepilogoDistinta.refresh();
			this.panel.add(this.riepilogoDistinta, 0);
			this.validate();
			this.repaint();
		}
	}

	
	public void updateRiepilogo() {
		if (this.riepilogoDistinta != null)
			this.riepilogoDistinta.refresh();
	}

	@Override
	public void load(String s) {
	}

	@Override
	public void load() {
	}

	/**
	 * Ritorna il numero di righe Lavoro
	 * 
	 * @return count:int
	 */
	public int getNumRigheLavoro() {
		return this.panel.getComponentCount() - 1;
	}

	/**
	 * Metodo che ricalcola l'altezza della lista
	 */
	public void updateAltezza() {
		this.panel.setPreferredSize(new Dimension(this.panel.getWidth(),
				this.riepilogoDistinta.getHeight() + this.getNumRigheLavoro()
						* (this.panel.getComponent(1).getHeight() + 10)));
		this.validate();
		this.repaint();
	}
	
	/**
	 * Metodo che abilita/disabilita i pulsanti per la modifica della distinta
	 * @param edit
	 */
	public void setEdit(boolean edit){
		if(this.getNumRigheLavoro() != 0){
			this.riepilogoDistinta.setEdit(edit);
			CardRigaLavoro riquadroRigaLavoro = null;
			for(int i=1; i<this.getNumRigheLavoro()+1; ++i){
				riquadroRigaLavoro = (CardRigaLavoro) this.panel.getComponent(i);
				riquadroRigaLavoro.setEdit(edit);
			}
			this.updateAltezza();
		}
	}

}
