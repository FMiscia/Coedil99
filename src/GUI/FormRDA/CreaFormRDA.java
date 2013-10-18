package GUI.FormRDA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import coedil99.controller.GestisciFornitoreHandler;
import coedil99.model.CatalogoFornitore;
import coedil99.model.ProductDescription;
import coedil99.model.ProductDescriptionFactory;
import coedil99.model.ProductDescriptionListCollection;
import coedil99.model.RDA;
import coedil99.model.RDAFactory;
import coedil99.model.RigaRDA;
import coedil99.model.RigaRDAFactory;

import GUI.RDACenter;
import GUI.Abstract.AFormRDA;
import GUI.Card.CardRDA;
import GUI.Card.CardRDAFactory;
import GUI.Card.CardRigaRDA;
import GUI.Card.CardRigaRDAFactory;
import GUI.Liste.ListaRDA;
import GUI.Liste.ListaRigheRDA;
import GUI.Plichi.PlicoRDA;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class CreaFormRDA extends AFormRDA {

	private JButton JBAddRiga = new JButton("Aggiungi");

	public CreaFormRDA() {
		// TODO Auto-generated constructor stub
		super();
		this.JBAddRiga.setEnabled(false);
		this.getSpinner().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(evt.getPropertyName().equals("enabled"))
					CreaFormRDA.this.JBAddRiga.setEnabled(true);
			}
		});
		
		
		MouseListener[] arrML = this.JBAddRiga.getMouseListeners();
		if (arrML.length == 1) {
			this.JBAddRiga.addActionListener(new ActionListener() {

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
						CatalogoFornitore cf = GestisciFornitoreHandler
								.getInstance().getFornitoreByName(fornitore);
						essenza = CreaFormRDA.this.getCbEssenza()
								.getSelectedItem().toString();
						geometria = CreaFormRDA.this.getCbGeometria()
								.getSelectedItem().toString();
						ProductDescription pd = GestisciFornitoreHandler
								.getInstance().getProductDescription(essenza,
										geometria, fornitore);
						RigaRDA rrda = RigaRDAFactory.createRigaRDA();
						RDACenter rdac = RDACenter.getInstance();
						rrda.setRDA(rdac.getRDASelezionata());
						rrda.setDescription(pd);
						rrda.setQuantity(numero);
						PlicoRDA prda = PlicoRDA.getInstance();
						CardRigaRDA cardRigaRDA = (CardRigaRDA) CardRigaRDAFactory
								.getInstance()
								.makeCard(prda.getListaRigheRDA());
						cardRigaRDA.load(rrda);
						ListaRDA lista = rdac.getLista();
						prda.getListaRigheRDA().getPanel().removeAll();
						prda.getListaRigheRDA().load(
								new ArrayList<Object>(
										rdac.getRDASelezionata().righeRDA
												.getCollection()));
						lista.getPrimaCard().setNomeFornitore(fornitore);
						CreaFormRDA.this.getCbFornitore().setEnabled(false);
						CreaFormRDA.this.resetConFornitoreSelezionato(CreaFormRDA.this.getCbFornitore().getSelectedItem().toString());
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
		RDACenter rdac = RDACenter.getInstance();
		RDA rda = RDAFactory.createRDA();
		CardRDA rdaCard = (CardRDA) CardRDAFactory.getInstance().makeCard(
				rdac.getLista());
		rdaCard.load(rda);
		rdac.getLista().getPanel().removeAll();
		rdac.getLista().addCard(rdaCard);
		rdac.setRDASelezionata(rda);
		rdac.getLista().deselectAll();
		rdac.getLista().getPrimaRDA();
		this.add(JBAddRiga, "2, 22, 3, 1");
	}

	@Override
	public void reset() {
		this.cbEssenza.setEnabled(false);
		this.cbEssenza.removeAllItems();
		this.cbGeometria.setEnabled(false);
		this.cbGeometria.removeAllItems();
		this.spinner.setValue(1);
		this.spinner.setEnabled(false);
		this.tfSpesa.setText(null);
		this.JBAddRiga.setEnabled(false);
		this.loadFornitori();
		this.validate();
		this.repaint();
	}
	
	public void resetConFornitoreSelezionato(String fornitore){
		this.cbEssenza.setEnabled(false);
		this.cbEssenza.removeAllItems();
		this.cbGeometria.setEnabled(false);
		this.cbGeometria.removeAllItems();
		this.spinner.setValue(1);
		this.spinner.setEnabled(false);
		this.tfSpesa.setText(null);
		this.JBAddRiga.setEnabled(false);
		this.loadEssenze(GestisciFornitoreHandler.getInstance().getFornitoreByName(fornitore));
		this.validate();
		this.repaint();
	}
	
	
	

}
