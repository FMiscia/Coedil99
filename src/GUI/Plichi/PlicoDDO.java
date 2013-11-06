package GUI.Plichi;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import GUI.CoedilFrame;
import GUI.Abstract.APlico;
import GUI.Abstract.ARiquadro;
import GUI.Riquadri.RiquadroOttimizzazione;
import coedil99.controller.GestisciCommessaHandler;
import coedil99.model.MCommessa;
import coedil99.model.MDocumentoOttimizzazione;

@SuppressWarnings("serial")
/**
 * 
 * @author francesco
 * 
 *  Gestisce il pannello del DDO
 */
public class PlicoDDO extends APlico {

	private RiquadroOttimizzazione ro;
	private static PlicoDDO instance = null;
	private JPanel panel;

	/**
	 * Costruttore
	 */
	private PlicoDDO() {
		this.initialize();
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub

	}

	/**
	 * Singleton
	 * 
	 * @return instance:PlicoDDO
	 */
	public static PlicoDDO getInstance() {
		if (PlicoDDO.instance == null)
			PlicoDDO.instance = new PlicoDDO();
		return PlicoDDO.instance;
	}

	/**
	 * Carica il riquadro del documento di ottimizzazione
	 * 
	 * @param id
	 *            :idCommessa
	 */
	public void load(int id) {
		// TODO Auto-generated method stub
		MCommessa c = GestisciCommessaHandler.getInstance().getCommessaById(id);
		MDocumentoOttimizzazione docott = new MDocumentoOttimizzazione(
				GestisciCommessaHandler.getInstance().getCommessaById(id)
						.getPersistentModel().getDistinta().getDdo().getID());
		this.panel.removeAll();
		this.panel.setPreferredSize(new Dimension(600,
				docott.getPersistentModel().items.size() * 250));
		this.panel.setSize(new Dimension(600, docott.getPersistentModel().items
				.size() * 250));
		this.setPreferredSize(new Dimension(600, this.panel.getHeight()));
		this.setSize(new Dimension(600, this.panel.getHeight()));
		for (int i = 0; i < docott.getPersistentModel().items.size(); i++) {
			ro = new RiquadroOttimizzazione("Ottimizzazione");
			ro.load(c.getPersistentModel().getDistinta().getDdo().items
					.toArray()[i]);
			this.panel.add(ro);
		}
	}

	/**
	 * Imposta la grafica
	 */
	private void initialize() {
		int bounds = (CoedilFrame.getInstance().getBounds().width / 6);
		setBorder(null);
		setLayout(null);
		panel = new JPanel(null);
		panel.setBounds(bounds, 20, 745, 200);
		setBounds(bounds, 20, 745, 200);
		setPreferredSize(new Dimension(745, panel.getHeight()));
		setSize(745, panel.getHeight());
		add(panel);
		this.validate();
		this.repaint();
	}

	@Override
	public ArrayList<ARiquadro> isModifying() {
		return new ArrayList<ARiquadro>();
	}

}
