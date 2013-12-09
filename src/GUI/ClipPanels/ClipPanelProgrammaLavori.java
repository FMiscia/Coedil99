package GUI.ClipPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

import GUI.CoedilFrame;
import GUI.PanelStart;
import GUI.ProgrammaLavori;
import GUI.RaccoglitorePlichi;
import GUI.Abstract.AClipPanel;
import GUI.Abstract.APlico;
import GUI.Plichi.PlicoCommessa;
import GUI.Plichi.PlicoCreaCommessa;
import GUI.Plichi.PlicoDDO;
import GUI.Plichi.PlicoDistinta;
import coedil99.model.MDistinta;

/**
 * 
 * @author francesco
 * 
 *         Implementazione di ACLipPanel per il menù in alto del programma
 *         lavori
 */
public class ClipPanelProgrammaLavori extends AClipPanel {

	/**
         * 
         */
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore
	 */
	public ClipPanelProgrammaLavori() {
		super();
		this.initialize();
	}

	/**
	 * Imposta la grafica e i bottoni del particolare clip panel
	 */
	private void initialize() {
		this.addButton("Menu", "Torna al Menu Principale",
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (!ClipPanelProgrammaLavori.this.clickDuringModify()) {
							return;
						}
						CoedilFrame cf = CoedilFrame.getInstance();
						PanelStart pl = PanelStart.getInstance();
						pl.resetInitialState();
						pl.setBounds(0, 0, cf.getWidth(), cf.getHeight());
						CoedilFrame.getInstance().montaPanel(pl);
					}
				});
		this.addButton("Commessa", "Vai alla Commessa", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ClipPanelProgrammaLavori.this.focusOut();
				if (!ClipPanelProgrammaLavori.this.clickDuringModify()) {
					return;
				} else if (!ClipPanelProgrammaLavori.this.clickDuringNewCommessa()) {
					return;
				}
				ProgrammaLavori pl = ProgrammaLavori.getInstance();
				pl.getRaccoglitorePlichi().reset();
				if(pl.getCommessaSelezionata() != null){
					pl.ListaCommesse().deselectAll();
					pl.getRaccoglitorePlichi().changePlico(PlicoCommessa.getInstance());
					pl.getRaccoglitorePlichi().caricaPrimaCommessa(pl.getCommessaSelezionata());
					pl.ListaCommesse().selectCommessaSelezionata(pl.getCommessaSelezionata());
				}
				pl.checkCommesse();
				pl.checkDDO();
				JToggleButton b = (JToggleButton) e.getSource();
				b.setSelected(true);
				RaccoglitorePlichi.getInstance().validate();
				RaccoglitorePlichi.getInstance().repaint();
			}

		});
		this.addButton("Distinta", "Vai alla distinta", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ClipPanelProgrammaLavori.this.focusOut();
				if (!ClipPanelProgrammaLavori.this.clickDuringModify()) {
					return;
				} else if (!ClipPanelProgrammaLavori.this.clickDuringNewCommessa()) {
					return;
				}
				ProgrammaLavori.getInstance().getRaccoglitorePlichi()
						.changePlico(PlicoDistinta.getInstance());
				JToggleButton b = (JToggleButton) e.getSource();
				b.setSelected(true);
				ProgrammaLavori.getInstance().checkDDO();
				RaccoglitorePlichi.getInstance().validate();
				RaccoglitorePlichi.getInstance().repaint();
			}
		});
		this.addButton("DDO", "Vai al DDO", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!ClipPanelProgrammaLavori.this.clickDuringModify()) {
					return;
				} else if (!ClipPanelProgrammaLavori.this.clickDuringNewCommessa()) {
					return;
				}
				MDistinta odistinta = new MDistinta(ProgrammaLavori
						.getInstance().getCommessaSelezionata()
						.getPersistentModel().getDistinta().getID());
				if (odistinta.hasDdo()) {
					ClipPanelProgrammaLavori.this.focusOut();
					JToggleButton b = (JToggleButton) e.getSource();
					b.setSelected(true);
					ProgrammaLavori.getInstance().getRaccoglitorePlichi()
							.changePlico(PlicoDDO.getInstance());
				} 					
				RaccoglitorePlichi.getInstance().validate();
				RaccoglitorePlichi.getInstance().repaint();
			}
		});
		this.addButton("Nuova Commessa", "Crea una nuova Commessa",
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (!ClipPanelProgrammaLavori.this.clickDuringModify()) {
							return;
						} 
						PlicoCreaCommessa.getInstance().resetAll();
						ProgrammaLavori.getInstance().getRaccoglitorePlichi()
								.changePlico(PlicoCreaCommessa.getInstance());
						ClipPanelProgrammaLavori.this.focusOut();
						ProgrammaLavori.getInstance().ListaCommesse()
								.deselectAll();
						ProgrammaLavori.getInstance().checkCommesse();
						JToggleButton b = (JToggleButton) e.getSource();
						b.setSelected(true);
						RaccoglitorePlichi.getInstance().validate();
						RaccoglitorePlichi.getInstance().repaint();
					}
				});
		this.fill();
		this.resetInitialState();
	}

	/**
	 * Fornisce true o false a seconda se, durante la modifica di un plico,
	 * stiamo andando in focus su altri bottoni
	 * 
	 * @return bool:boolean
	 */
	public boolean clickDuringModify() {
		if (RaccoglitorePlichi.getInstance().getPlico_container()
				.getComponentCount() != 0
				&& ((APlico) RaccoglitorePlichi.getInstance()
						.getPlico_container().getComponent(0)).isModifying()) {
			Object[] options = { "Si", "No" };
			int n = JOptionPane.showOptionDialog(null,
					"Sicuro di voler abbandonare la modifica?\n"
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
	
	/**
	 * Fornisce true o false a seconda se, durante l'inserimento di una nuova commessa,
	 * stiamo andando in focus su altri bottoni
	 * 
	 * @return bool:boolean
	 */
	public boolean clickDuringNewCommessa(){
		if (isSelectedNuovaCommessa()) {
			Object[] options = { "Si", "No" };
			int n = JOptionPane.showOptionDialog(null,
					"Sicuro di voler abbandonare la modifica?\n"
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
	
	
	/**
	 * Metodo che blocca/attiva i bottoni del clip panel 
	 */
	public void enableButtons(boolean test){
		if(!test){
			((JToggleButton) this.getComponent(2)).setToolTipText("Non ci sono commesse!");
			((JToggleButton) this.getComponent(3)).setToolTipText("Non ci sono commesse!");
		} else {
			((JToggleButton) this.getComponent(2)).setToolTipText("Vai alla distinta");
			((JToggleButton) this.getComponent(3)).setToolTipText("Vai al DDO");
		}
		this.getComponent(2).setEnabled(test);
		this.getComponent(3).setEnabled(test);
		this.validate();
		this.repaint();
	}
	
	private boolean isSelectedNuovaCommessa(){
		JToggleButton b = (JToggleButton) ClipPanelProgrammaLavori.this.getButtons().get(4);
		return this.isButtonFocused(b);
	}
	

}