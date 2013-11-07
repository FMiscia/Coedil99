package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import coedil99.controller.GestisciRDAHandler;
import coedil99.model.MRDA;
import coedil99.persistentmodel.RigaRDA;

import GUI.ClipPanels.ClipPanelComm;
import GUI.ClipPanels.ClipPanelCommFactory;
import GUI.Liste.ListaRDA;
import GUI.Liste.ListaRDAFactory;
import GUI.Liste.ListaRigheRDA;
import GUI.Liste.ListaRigheRDAFactory;
import GUI.Plichi.PlicoCommerciale;
import GUI.Plichi.PlicoRDA;

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
		// setMinimumSize(new Dimension(500, 600));
		// setLayout(new BorderLayout());
		// this.lista = (ListaRDA) ListaRDAFactory.getInstance().makeLista(
		// GestisciRDAHandler.ATTESA_CONFERMA);
		// // this.lista.load(GestisciRDAHandler.ATTESA_CONFERMA);
		// this.setRDASelezionata(GestisciRDAHandler.getInstance().getMRDAById(
		// this.lista.getPrimaRDA()));
		// ArrayList<Object> l = new
		// ArrayList<Object>(this.getRDASelezionata().getPersistentModel().righeRDA.getCollection());
		// ListaRigheRDA lrr = (ListaRigheRDA)
		// ListaRigheRDAFactory.getInstance().makeLista();
		// lrr.load(l);
		// System.out.println("PORCAMADONNA");
		// PlicoCommerciale.getInstance().setListaRigheRDA(lrr);
		// this.add(PlicoCommerciale.getInstance(), BorderLayout.CENTER);

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
		// TODO Auto-generated method stub
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

}
