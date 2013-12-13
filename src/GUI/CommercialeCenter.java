package GUI;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import GUI.ClipPanels.ClipPanelComm;
import GUI.ClipPanels.ClipPanelCommFactory;
import GUI.Liste.ListaRDA;
import GUI.Plichi.PlicoCommerciale;
import coedil99.model.MRDA;

public class CommercialeCenter extends JPanel {

	private static final long serialVersionUID = 1L;
	private static CommercialeCenter instance = null;
	private ClipPanelComm clip;
	JPanel commPanel = new JPanel();
	private MRDA rdaSelezionata = null;
	private ListaRDA lista = null;

	/**
	 * Costruttore del pannello Programma Lavori
	 */
	private CommercialeCenter() {
		this.initialize();
	}

	/**
	 * Inizializza le componenti grafiche
	 */
	private void initialize() {
		this.addMenuBar();
		this.validate();
		this.repaint();
	}

	/**
	 * Aggiunge il ClipPanel, pannello dei button in alto
	 */
	private void addMenuBar() {
		setLayout(new BorderLayout());
		this.clip = (ClipPanelComm) ClipPanelCommFactory.getInstance()
				.makeClipPanel();
		this.add(clip, BorderLayout.NORTH);
		this.validate();
		this.repaint();
	}

	/**
	 * 
	 * @param r
	 *            : la listaRDA da impostare
	 */
	public void setLista(ListaRDA r) {
		if (this.lista != null)
			this.remove(this.lista);
		this.validate();
		this.repaint();
		this.lista = r;
		this.add(this.lista, BorderLayout.WEST);
		this.validate();
		this.repaint();
	}

	/**
	 * 
	 * @return ListaRDA
	 */
	public ListaRDA getLista() {
		return lista;
	}

	/**
	 * 
	 * @return MRDA
	 */
	public MRDA getRDASelezionata() {
		return rdaSelezionata;
	}

	/**
	 * 
	 * @param rdaSelezionata
	 */
	public void setRDASelezionata(MRDA rdaSelezionata) {
		this.rdaSelezionata = rdaSelezionata;
	}

	/**
	 * Singleton
	 * 
	 * @return CommercialePanel
	 */
	public static CommercialeCenter getInstance() {
		if (CommercialeCenter.instance == null)
			CommercialeCenter.instance = new CommercialeCenter();
		return CommercialeCenter.instance;
	}

	public void loadListaRigheRDA() {
		PlicoCommerciale
				.getInstance()
				.getListaRigheRDA()
				.loadComm(
						new ArrayList<Object>(this.getRDASelezionata()
								.getPersistentModel().righeRDA.getCollection()));
		this.add(PlicoCommerciale.getInstance(), BorderLayout.CENTER);
		this.validate();
		this.repaint();
	}

	/**
	 * 
	 * @return true se CommercialeCenter è instanziato, false altrimenti
	 */
	public static boolean isInstanciated() {
		return instance == null;
	}

	public ClipPanelComm getClip() {
		return clip;
	}

	public void setClip(ClipPanelComm clip) {
		this.clip = clip;
	}

}
