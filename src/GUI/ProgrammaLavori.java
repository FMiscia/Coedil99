package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import GUI.Abstract.ALista;
import GUI.ClipPanels.ClipPanelProgrammaLavori;
import GUI.ClipPanels.ClipPanelProgrammaLavoriFactory;
import GUI.Liste.ListaCommesse;
import GUI.Liste.ListaCommesseFactory;
import coedil99.controller.GestisciCommessaHandler;
import coedil99.model.Commessa;

public class ProgrammaLavori extends JPanel {


	private static final long serialVersionUID = 1L;
	private static ProgrammaLavori instance = null;
	private ALista lista;
	private RaccoglitorePlichi raccoglitoreplichi;
	private ClipPanelProgrammaLavori clip;
	private Commessa commessaSelezionata = null;
	JPanel proglavoripanel = new JPanel();
	
	/**
	 * Costruttore del pannello Programma Lavori 
	 */
	private ProgrammaLavori() {
		setMinimumSize(new Dimension(500, 600));
		this.raccoglitoreplichi = RaccoglitorePlichi.getInstance();
		setLayout(new BorderLayout());
		this.AddPanelLavori();
		this.addMenuBar();

	}
	
	/**
	 * Aggiunge un JPanel contenente la lista delle commesse 
	 * e il raccoglitore plichi relativo alla commessa selezionata
	 */
	private void AddPanelLavori(){
		add(proglavoripanel, BorderLayout.CENTER);
		proglavoripanel.setLayout(new BorderLayout(0, 0));

		this.lista = (ListaCommesse)ListaCommesseFactory.getInstance().makeLista();
		this.lista.setPreferredSize(new Dimension(200, 0));
		proglavoripanel.add(lista, BorderLayout.WEST);

		proglavoripanel.add(this.raccoglitoreplichi, BorderLayout.CENTER);
		this.commessaSelezionata = GestisciCommessaHandler.getInstance()
				.getCommessaById(((ListaCommesse) this.lista).getPrimaCommessa());
		this.raccoglitoreplichi.caricaPrimaCommessa(this.commessaSelezionata);

		this.commessaSelezionata = GestisciCommessaHandler.getInstance()
				.getCommessaById(((ListaCommesse) this.lista).getPrimaCommessa());
	}

	/**
	 * Aggiunge il ClipPanel, pannello dei button in alto
	 */
	private void addMenuBar() {

		this.clip = (ClipPanelProgrammaLavori) ClipPanelProgrammaLavoriFactory.getInstance().makeClipPanel();
		this.proglavoripanel.add(clip, BorderLayout.NORTH);
		this.validate();
		this.repaint();


	}
	
	/**
	 * Singleton
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
	public ListaCommesse getRiquadrocodici() {
		return (ListaCommesse) lista;
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
	public Commessa getCommessaSelezionata() {
		return commessaSelezionata;
	}

	/**
	 * 
	 * @param selectedComm: la commessa da selezionare
	 */
	public void setCommessaSelezionata(Commessa selectedComm) {
		// TODO Auto-generated method stub
		this.commessaSelezionata = selectedComm;
	}
	/**
	 * 
	 * @return ClipPanelProgrammaLavori
	 */
	public ClipPanelProgrammaLavori getClipPanel() {
		return clip;
	}

}
