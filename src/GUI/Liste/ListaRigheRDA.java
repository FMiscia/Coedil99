package GUI.Liste;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.orm.PersistentException;

import GUI.ProgrammaLavori;
import GUI.RDACenter;
import GUI.Abstract.ALista;
import GUI.Card.CardRigaRDA;
import GUI.Card.CardRigaRDAFactory;
import GUI.FormRDA.ModificaFormRDA;
import GUI.FormRDA.ModificaFormRDAFactory;
import GUI.Plichi.PlicoRDA;
import coedil99.controller.GestisciRDAHandler;
import coedil99.model.RDA;
import coedil99.model.RigaRDA;

public class ListaRigheRDA extends ALista {

	public ListaRigheRDA() {
		// TODO Auto-generated constructor stub
		super();
		this.validate();
		this.repaint();
	}

	@Override
	public void load(ArrayList<Object> t) {
		// Aggiorna titolo e prezzo delle righe rda
		this.updatePanel();
		this.setPreferredSize(new Dimension(290, 0));
		int row = t.size();
		this.panel.setPreferredSize(new Dimension(150, row * 70));
		CardRigaRDA riquadroRigaRDA;
		for (int k = 0; k < row; ++k) {
			riquadroRigaRDA = (CardRigaRDA) CardRigaRDAFactory.getInstance()
					.makeCard(this);
			final RigaRDA riga = (RigaRDA) t.get(k);
			riquadroRigaRDA.load(riga);
			this.panel.add(riquadroRigaRDA);
			this.panel.validate();
			this.panel.repaint();
		}
		this.setPreferredSize(new Dimension(290, panel.getHeight()));
		this.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		this.validate();
		this.repaint();
	}

	public void removeRiquadro(CardRigaRDA r) {
		this.panel.remove(r);
		this.validate();
		this.repaint();
	}

	public JPanel getPanel() {
		return this.panel;
	}

	@Override
	public void deselectAll() {
		for (Component c : this.panel.getComponents()) {
			c.setBackground(new Color(209, 209, 209));
			c.validate();
			c.repaint();
		}
	}

	

	@Override
	public void updatePanel() {
		this.panelTitle.removeAll();
		panelTitle.setSize(new Dimension(200, 200));
		panelTitle.setPreferredSize(new Dimension(200, 200));
		panel.add(panelTitle, 0);
		panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelTitle.add(labeltitle);
		panelTitle.add(labelprezzo);
		RDA r = RDACenter.getInstance().getRDASelezionata(); 
		float prezzo_totale = 0;
		for(int i=0; i<r.righeRDA.size(); ++i){
			prezzo_totale += (r.righeRDA.get(i).getQuantity()*r.righeRDA.get(i).getDescription().getPrezzo());
		}
		JLabel prezzo = new JLabel(String.valueOf(prezzo_totale));
		panelTitle.add(prezzo);
		this.btnSalva.setPreferredSize(new Dimension(120, 30));
		panelTitle.add(btnSalva);
		MouseListener[] arrML = this.btnSalva.getMouseListeners();
		if (arrML.length == 1) {
			this.btnSalva.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					GestisciRDAHandler.getInstance().saveAndAddRDA(
							RDACenter.getInstance().getRDASelezionata());
					JOptionPane.showMessageDialog(null,
							"RDA salvata con successo!\n",
							"Conferma operazione", JOptionPane.PLAIN_MESSAGE);
					RDACenter rdac = RDACenter.getInstance();
					ListaRDA listarda = (ListaRDA) ListaRDAFactory
							.getInstance().makeLista();
					rdac.setLista(listarda);

					rdac.setRDASelezionata(GestisciRDAHandler.getInstance()
							.getRDAById(
									RDACenter.getInstance().getLista()
											.getPrimaRDA()));

					PlicoRDA prda = PlicoRDA.getInstance();
					ListaRigheRDA lista_rda = prda.getListaRigheRDA();
					prda.resetFormRDA();
					lista_rda.getPanel().removeAll();
					lista_rda.load(new ArrayList<Object>(rdac
							.getRDASelezionata().righeRDA.getCollection()));
					
					rdac.getClipPanel().focusToRDACongelate();
					lista_rda.validate();
					lista_rda.repaint();
				}

			});
		}
		this.btnElimina.setPreferredSize(new Dimension(120, 30));
		this.panelTitle.add(this.btnElimina);
		arrML = this.btnElimina.getMouseListeners();
		if (arrML.length == 1) {
			this.btnElimina.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Object[] options = { "Si", "No" };
					int n = JOptionPane.showOptionDialog(
							ProgrammaLavori.getInstance(),
							"Sicuro di voler eliminare la RDA?\n"
									+ "Nota: Questa operazione non è reversibile",
							"Conferma operazione",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options,
							options[1]);
					if (n == JOptionPane.YES_OPTION) {
						GestisciRDAHandler.getInstance().deleteAndRemoveRDA(
								RDACenter.getInstance().getRDASelezionata());
						ListaRDA listarda = (ListaRDA) ListaRDAFactory
								.getInstance().makeLista();
						RDACenter.getInstance().setLista(listarda);
						PlicoRDA prda = PlicoRDA.getInstance();
						ListaRigheRDA lista_rda = prda.getListaRigheRDA();
						prda.resetFormRDA();
						listarda.getPanel().removeAll();
						listarda.load();
						RDACenter.getInstance().setRDASelezionata(
								GestisciRDAHandler.getInstance().getRDAById(
										listarda.getPrimaRDA()));
						lista_rda.getPanel().removeAll();
						lista_rda.load(new ArrayList<Object>(RDACenter
								.getInstance().getRDASelezionata().righeRDA
								.getCollection()));
						lista_rda.validate();
						lista_rda.repaint();
						listarda.validate();
						listarda.repaint();
					}
				}
			});
		}
		this.validate();
		this.repaint();
	}

}
