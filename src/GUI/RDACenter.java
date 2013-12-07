package GUI;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import coedil99.controller.GestisciRDAHandler;
import coedil99.model.MRDA;
import coedil99.persistentmodel.RDA;
import GUI.ClipPanels.ClipPanelRDA;
import GUI.ClipPanels.ClipPanelRDAFactory;
import GUI.Form.CreaFormRDAFactory;
import GUI.Liste.ListaRDA;
import GUI.Liste.ListaRDAFactory;
import GUI.Liste.ListaRigheRDA;
import GUI.Plichi.PlicoRDA;

public class RDACenter extends JPanel {

	private static final long serialVersionUID = 1L;
	private static RDACenter instance = null;
	private MRDA rdaSelezionata = null;
	private ListaRDA lista = null;

	private ClipPanelRDA clipPanel = (ClipPanelRDA) ClipPanelRDAFactory
			.getInstance().makeClipPanel();

	/**
	 * Costruttore
	 */
	public RDACenter() {
		this.initialize();
	}

	/**
	 * Inizializza le componenti grafiche
	 */
	private void initialize() {
		this.setLayout(new BorderLayout());
		this.add(clipPanel, BorderLayout.NORTH);
		this.add(PlicoRDA.getInstance(), BorderLayout.CENTER);
		this.clipPanel.updateNotifiche();
	}

	/**
	 * Carica la lista delle RDA
	 */
	@SuppressWarnings("unchecked")
	public void loadListaRigheRDA() {
		ListaRDA listarda = (ListaRDA) ListaRDAFactory.getInstance()
				.makeListaComm(GestisciRDAHandler.CONGELATA);
		RDACenter.getInstance().setLista(listarda);
		RDACenter.getInstance().setRDASelezionata(
				GestisciRDAHandler.getInstance().getMRDAById(
						listarda.getPrimaRDA()));
		PlicoRDA.getInstance()
				.getListaRigheRDA()
				.load(new ArrayList<Object>(this.getRDASelezionata()
						.getPersistentModel().righeRDA.getCollection()));
		this.validate();
		this.repaint();
	}

	/**
	 * Singleton
	 * 
	 * @return RDACenter
	 */
	public static RDACenter getInstance() {
		if (RDACenter.instance == null)
			RDACenter.instance = new RDACenter();
		return RDACenter.instance;
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
	 * 
	 * @return ListaRDA
	 */
	public ListaRDA getLista() {
		return lista;
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
	 * rimuove il PlicoRDA
	 */
	public void removePlicoRDA() {
		this.remove(PlicoRDA.getInstance());
		this.validate();
		this.repaint();
	}

	/**
	 * Aggiunge il Plico RDA
	 */
	public void addPlicoRDA() {
		this.add(PlicoRDA.getInstance());
	}

	/**
	 * 
	 * @return ClipPanelRDA
	 */
	public ClipPanelRDA getClipPanel() {
		return clipPanel;
	}

	/**
	 * 
	 * @param clipPanel
	 */
	public void setClipPanel(ClipPanelRDA clipPanel) {
		this.clipPanel = clipPanel;
	}

	/**
	 * 
	 * @return true se RDACenter è instanziato, false altrimenti
	 */
	public static boolean isInstanciated() {
		return instance == null;
	}

	/**
	 * Metodo che ricarica la lista rda congelate e seleziona la prima rda
	 */
	public void refreshCongelate() {
		this.lista.svuota();
		this.lista.load(GestisciRDAHandler.CONGELATA);
		if (this.getLista().getPrimaCard() != null) {
			this.setRDASelezionata(GestisciRDAHandler.getInstance()
					.getMRDAById(this.lista.getPrimaRDA()));
			PlicoRDA prda = PlicoRDA.getInstance();
			ListaRigheRDA lista_righe_rda = prda.getListaRigheRDA();
			prda.reset();
			prda.addFormRDA(CreaFormRDAFactory.getInstance().makeFormRDA());
			lista_righe_rda.load(new ArrayList<Object>(this.getRDASelezionata()
					.getPersistentModel().righeRDA.getCollection()));
			lista_righe_rda.validate();
			lista_righe_rda.repaint();
		}
	}
}