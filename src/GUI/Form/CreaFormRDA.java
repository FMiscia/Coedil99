package GUI.Form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import coedil99.controller.GestisciCommessaHandler;
import coedil99.controller.GestisciFornitoreHandler;
import coedil99.controller.GestisciRDAHandler;
import coedil99.model.MCatalogoFornitore;
import coedil99.model.MProductDescription;
import coedil99.model.MRDA;
import coedil99.model.MRigaRDA;
import coedil99.persistentmodel.CatalogoFornitore;
import coedil99.persistentmodel.ProductDescription;
import coedil99.persistentmodel.RDA;
import coedil99.persistentmodel.RDAFactory;
import coedil99.persistentmodel.RigaRDA;
import coedil99.persistentmodel.RigaRDAFactory;

import GUI.RDACenter;
import GUI.Abstract.AFormRDA;
import GUI.Card.CardRDA;
import GUI.Card.CardRDAFactory;
import GUI.Card.CardRigaRDA;
import GUI.Card.CardRigaRDAFactory;
import GUI.Liste.ListaRDA;
import GUI.Plichi.PlicoRDA;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

/**
 * 
 * @author francesco
 * 
 *         Gestisce La form per la creazione di una nuova RDA
 */
public class CreaFormRDA extends AFormRDA {

	private static final long serialVersionUID = 1L;
	private JButton JBAddRiga = new JButton("Aggiungi");

	/**
	 * Costruttore
	 */
	public CreaFormRDA() {
		super();
		/**
		 * Imposta lo spinner per la selezione della quantità
		 */
		this.JBAddRiga.setEnabled(false);
		this.getSpinner().addPropertyChangeListener(
				new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent evt) {
						if (evt.getPropertyName().equals("enabled"))
							CreaFormRDA.this.JBAddRiga.setEnabled(true);
					}
				});
		this.initialize();
	}

	/**
	 * Metodo che resetta la form
	 */
	@Override
	public void reset() {
		this.getCbFornitore().setEnabled(false);
		this.resetEssenza();
		this.resetGeometria();
		this.JBAddRiga.setEnabled(false);
		this.loadFornitori();
		this.validate();
		this.repaint();
	}

	/**
	 * Metodo che resetta la form fissando il fornitore e rendendolo non
	 * modificabile
	 * 
	 * @param fornitore
	 */
	public void resetConFornitoreSelezionato(String fornitore) {
		this.getCbFornitore().setEnabled(false);
		this.resetEssenza();
		this.resetGeometria();
		this.disableSpinner();
		this.JBAddRiga.setEnabled(false);
		this.loadEssenze(GestisciFornitoreHandler.getInstance()
				.getFornitoreByName(fornitore));
		this.validate();
		this.repaint();
	}

	/**
	 * Imposta la grafica e i bottoni con relativi listener
	 */
	private void initialize() {
		MouseListener[] arrML = this.JBAddRiga.getMouseListeners();
		if (arrML.length == 1) {
			this.JBAddRiga.addActionListener(new ActionListener() {

				@SuppressWarnings("unchecked")
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

					int indiceCbFornitore = CreaFormRDA.this.getCbFornitore()
							.getSelectedIndex();
					int indiceCbEssenza = CreaFormRDA.this.getCbEssenza()
							.getSelectedIndex();
					int indiceCbGeometria = CreaFormRDA.this.getCbGeometria()
							.getSelectedIndex();

					int numero = CreaFormRDA.this.getQuantity();
					String fornitore = "";
					String essenza = "";
					String geometria = "";

					if (numero != -1 && indiceCbFornitore != -1
							&& indiceCbEssenza != -1 && indiceCbGeometria != -1) {
						fornitore = CreaFormRDA.this.getCbFornitore()
								.getSelectedItem().toString();
						@SuppressWarnings("unused")
						MCatalogoFornitore cf = GestisciFornitoreHandler
								.getInstance().getFornitoreByName(fornitore);
						essenza = CreaFormRDA.this.getCbEssenza()
								.getSelectedItem().toString();
						geometria = CreaFormRDA.this.getCbGeometria()
								.getSelectedItem().toString();
						MProductDescription pd = GestisciFornitoreHandler
								.getInstance().getMProductDescription(essenza,
										geometria, fornitore);
						MRigaRDA rrda = new MRigaRDA();
						RDACenter rdac = RDACenter.getInstance();
						rrda.getPersistentModel().setRDA(
								rdac.getRDASelezionata().getPersistentModel());
						rrda.getPersistentModel().setDescription(
								pd.getPersistentModel());
						rrda.getPersistentModel().setQuantity(numero);
						PlicoRDA prda = PlicoRDA.getInstance();
						CardRigaRDA cardRigaRDA = (CardRigaRDA) CardRigaRDAFactory
								.getInstance()
								.makeCard(prda.getListaRigheRDA());
						cardRigaRDA.load(rrda.getPersistentModel());
						ListaRDA lista = rdac.getLista();
						prda.getListaRigheRDA().getPanel().removeAll();
						prda.getListaRigheRDA().load(
								new ArrayList<Object>(rdac.getRDASelezionata()
										.getPersistentModel().righeRDA
										.getCollection()));
						lista.getPrimaCard().setNomeFornitore(fornitore);
						CreaFormRDA.this
								.resetConFornitoreSelezionato(fornitore);
						lista.getPrimaCard().validate();
						lista.getPrimaCard().repaint();
					} else {
						JOptionPane
								.showMessageDialog(
										null,
										"Per creare una riga della nuova RDA, seleziona un fornitore, un'essenza una geometria e una quantità valida",
										"Attenzione", JOptionPane.PLAIN_MESSAGE);
					}

				}
			});
		}
		if (RDACenter.getInstance().getClipPanel().isSelected("NUOVA")) {
			RDACenter rdac = RDACenter.getInstance();
			CardRDA rdaCard = (CardRDA) CardRDAFactory.getInstance().makeCard(
					rdac.getLista());
			MRDA rda = new MRDA();
			rda.getPersistentModel().setDate(new Date());
			rdaCard.load(rda);

			rdac.getLista().svuota();
			rdac.getLista().addCard(rdaCard);
			rdac.setRDASelezionata(rda);
			rdac.getLista().deselectAll();
			rdac.getLista().getPrimaRDA();
		}
		if (RDACenter.getInstance().getClipPanel()
				.isSelected(GestisciRDAHandler.CONGELATA)
				&& RDACenter.getInstance().getRDASelezionata()
						.getPersistentModel().righeRDA.get(0) != null) {
			this.cbFornitore.setSelectedItem(RDACenter.getInstance()
					.getRDASelezionata().getPersistentModel().righeRDA.get(0)
					.getDescription().getCatalogoFornitore().getName());
			this.cbFornitore.setEnabled(false);
		}
		this.add(JBAddRiga, "2, 22, 3, 1");
	}

}
