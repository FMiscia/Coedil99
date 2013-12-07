package GUI.Riepiloghi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import GUI.ProgrammaLavori;
import GUI.RDACenter;
import GUI.Abstract.ARiepilogoDistinta;
import GUI.Card.CardRDA;
import GUI.Plichi.PlicoDistinta;
import coedil99.controller.GestisciRDAHandler;
import coedil99.controller.OttimizzatoreHandler;
import coedil99.model.MDistinta;
import coedil99.model.MRigaLavoro;

/**
 * Gestisce il riepilogo dei dati relativi al catalogo fornitore
 * @author Simone
 *
 */
@SuppressWarnings("serial")
public class RiepilogoDistinta extends ARiepilogoDistinta {

	/**
	 * Costruttore
	 */
	public RiepilogoDistinta(){
		super();
		this.initialize();
	}

	@Override
	/**
	 * Metodo che si occupa di aggiornare i dati relativi alla distinta
	 */
	public void refresh() {
		if(ProgrammaLavori.getInstance().getCommessaSelezionata() != null){
			MDistinta d = new MDistinta(ProgrammaLavori.getInstance().getCommessaSelezionata().getPersistentModel().getDistinta().getID());
			this.cbOttimizzatore.removeAllItems();
			for(int i=0; i<OttimizzatoreHandler.ottimizzatori.keySet().size(); ++i)
				this.cbOttimizzatore.addItem(OttimizzatoreHandler.ottimizzatori.keySet().toArray()[i]);
			if (this.btnSalva.getMouseListeners().length == 1) {
				this.btnSalva.addMouseListener(new MouseAdapter() {
					@SuppressWarnings("unchecked")
					@Override
					public void mouseClicked(MouseEvent e) {
						MDistinta d = new MDistinta(ProgrammaLavori.getInstance().getCommessaSelezionata().getPersistentModel().getDistinta().getID());
						d.save();
						JOptionPane.showMessageDialog(null,
								"Distinta salvata con successo!\n",
								"Conferma operazione",
								JOptionPane.INFORMATION_MESSAGE);
						ProgrammaLavori.getInstance().getClipPanel().getButtons().get(2).doClick();
					}

				});
			}
			
			if (this.btnAdd.getMouseListeners().length == 1) {
				this.btnAdd.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						PlicoDistinta.getInstance().addRiquadroRigaLavoro(new MRigaLavoro());
					}

				});
			}
			
			this.validate();
			this.repaint();
		}
	}
	
	/**
	 * Metodo che inizializza la grafica
	 */
	private void initialize(){
		this.addButton(this.btnSalva, 14);
		//this.addButton(this.btnElimina, 16);
		this.addButton(this.btnAdd, 16);
		this.addButton(this.btnOttimizza, 18);
	}
	
}
