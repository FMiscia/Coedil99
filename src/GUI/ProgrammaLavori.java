package GUI;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GUI.Abstract.ALista;
import GUI.ClipPanels.ClipPanelProgrammaLavori;
import GUI.ClipPanels.ClipPanelProgrammaLavoriFactory;
import GUI.Liste.ListaCommesse;
import GUI.Liste.ListaCommesseFactory;
import coedil99.controller.GestisciCommessaHandler;
import coedil99.model.MCommessa;

public class ProgrammaLavori extends JPanel {

	private static final long serialVersionUID = 1L;
	private static ProgrammaLavori instance = null;
	private ListaCommesse lista;
	private RaccoglitorePlichi raccoglitoreplichi;
	private ClipPanelProgrammaLavori clip;
	private MCommessa commessaSelezionata = null;
	JPanel proglavoripanel = new JPanel();

	/**
	 * Costruttore del pannello Programma Lavori
	 */
	private ProgrammaLavori() {
		this.initialize();
	}
	
	/**
	 * Metodo che inizializza la grafica
	 */
	private void initialize(){
		this.setLayout(new BorderLayout());
		this.raccoglitoreplichi = RaccoglitorePlichi.getInstance();
		this.addPanelLavori();
		this.addMenuBar();
		this.checkCommesse();
	}

	/**
	 * Aggiunge un JPanel contenente la lista delle commesse e il raccoglitore
	 * plichi relativo alla commessa selezionata
	 */
	private void addPanelLavori() {
		add(proglavoripanel, BorderLayout.CENTER);
		proglavoripanel.setLayout(new BorderLayout(0, 0));
		this.lista = (ListaCommesse) ListaCommesseFactory.getInstance()
				.makeLista();
		proglavoripanel.add(lista, BorderLayout.WEST);
		proglavoripanel.add(this.raccoglitoreplichi, BorderLayout.CENTER);
		if (this.getCommessaSelezionata() == null && this.lista.getPrimaCommessa() != 0){
			this.commessaSelezionata = GestisciCommessaHandler.getInstance()
					.getCommessaById(
							this.lista.getPrimaCommessa());
		} else if(this.getCommessaSelezionata() != null && ((ListaCommesse) this.lista).getPrimaCommessa() != 0) {
			((ListaCommesse) this.lista).selectCommessaSelezionata(this.getCommessaSelezionata());
		} else {
			return;
		}
		this.raccoglitoreplichi.caricaPrimaCommessa(this.commessaSelezionata);
	}

	/**
	 * Aggiunge il ClipPanel, pannello dei button in alto
	 */
	private void addMenuBar() {
		this.clip = (ClipPanelProgrammaLavori) ClipPanelProgrammaLavoriFactory
				.getInstance().makeClipPanel();
		this.proglavoripanel.add(clip, BorderLayout.NORTH);
		this.validate();
		this.repaint();

	}

	/**
	 * Singleton
	 * 
	 * @return ProgrammaLavori
	 */
	public static ProgrammaLavori getInstance() {
		if (ProgrammaLavori.instance == null)
			ProgrammaLavori.instance = new ProgrammaLavori();
		return ProgrammaLavori.instance;
	}

	/**
	 * 
	 * @return ListaCommesse
	 */

	public ListaCommesse ListaCommesse() {
		return lista;
	}

	/**
	 * 
	 * @param listaCommesse
	 */
	public void setRiquadrocodici(ListaCommesse listaCommesse) {
		this.lista = listaCommesse;
	}

	/**
	 * 
	 * @return RaccoglitorePlichi
	 */
	public RaccoglitorePlichi getRaccoglitorePlichi() {
		return raccoglitoreplichi;
	}

	/**
	 * 
	 * @param raccoglitoreplichi
	 */
	public void setraccoglitoreplichi(RaccoglitorePlichi raccoglitoreplichi) {
		this.raccoglitoreplichi = raccoglitoreplichi;
	}

	/**
	 * 
	 * @return Commessa
	 */
	public MCommessa getCommessaSelezionata() {
		return commessaSelezionata;
	}

	/**
	 * 
	 * @param selectedComm
	 *            : la commessa da selezionare
	 */
	public void setCommessaSelezionata(MCommessa selectedComm) {
		this.commessaSelezionata = selectedComm;
	}

	/**
	 * 
	 * @return ClipPanelProgrammaLavori
	 */
	public ClipPanelProgrammaLavori getClipPanel() {
		return clip;
	}
	
	/**
	 * Metodo che abilita i bottoni del clip panel solo se ci sono delle commesse
	 */
	public void checkCommesse(){
		this.clip.enableButtons(this.lista.getPrimaCard() != null);
	}

}
