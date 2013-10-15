package GUI.Abstract;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import GUI.ProgrammaLavori;
import GUI.RDACenter;
import GUI.Liste.ListaRDA;
import GUI.Liste.ListaRDAFactory;
import GUI.Liste.ListaRigheRDA;
import GUI.Plichi.PlicoRDA;
import coedil99.controller.GestisciRDAHandler;
import coedil99.model.RDA;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;

public class ARiepilogoRDA extends JPanel {
	
	private static int width = 200;
	private static int height = 200;
	private JPanel panel;
	private JLabel lblTitolo;
	private JLabel lblPrezzo;
	private JLabel lblTotale;
	private JButton btnSalva;
	private JButton btnElimina;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblFornitore;
	private JLabel lblFornitoreSelezionato;
	private JLabel lblNumeroPacchi;
	private JLabel lblQuantita;

	public ARiepilogoRDA() {
		this.setSize(new Dimension(width,height));
		this.setPreferredSize(new Dimension(270, 200));
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		this.panel = new JPanel();
		this.add(this.panel);
		this.panel.setBackground(SystemColor.controlHighlight);
		this.panel.setPreferredSize(new Dimension(280, 200));
		this.panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("40px"),
				ColumnSpec.decode("10px"),
				ColumnSpec.decode("max(60px;default)"),
				ColumnSpec.decode("10px"),
				ColumnSpec.decode("max(70px;default)"),
				ColumnSpec.decode("10px"),
				ColumnSpec.decode("40px"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblTitolo = new JLabel("Lista Righe RDA");
		lblTitolo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel.add(lblTitolo, "3, 2, 3, 1");
		
		separator = new JSeparator();
		this.panel.add(separator, "3, 4, 3, 1");
		
		lblFornitore = new JLabel("Fornitore");
		lblFornitore.setFont(new Font("Tahoma", Font.ITALIC, 11));
		this.panel.add(lblFornitore, "3, 6");
		
		lblFornitoreSelezionato = new JLabel("");
		this.panel.add(lblFornitoreSelezionato, "5, 6, right, default");
		
		lblNumeroPacchi = new JLabel("Numero di pacchi");
		lblNumeroPacchi.setFont(new Font("Tahoma", Font.ITALIC, 11));
		this.panel.add(lblNumeroPacchi, "3, 8");
		
		lblQuantita = new JLabel("");
		this.panel.add(lblQuantita, "5, 8, right, default");
		
		lblTotale = new JLabel("");
		this.panel.add(lblTotale, "5, 10, right, default");
		
		lblPrezzo = new JLabel("Prezzo Totale RDA");
		lblPrezzo.setFont(new Font("Tahoma", Font.ITALIC, 11));
		this.panel.add(lblPrezzo, "3, 10");
		
		separator_1 = new JSeparator();
		this.panel.add(separator_1, "3, 12, 3, 1");
		
		btnSalva = new JButton("Salva RDA");
		this.panel.add(btnSalva, "3, 14");
		
		btnElimina = new JButton("Elimina RDA");
		this.panel.add(btnElimina, "3, 16");
	}
	
	public void refresh(){
		RDA r = RDACenter.getInstance().getRDASelezionata(); 
		this.lblFornitoreSelezionato.setText(r.righeRDA.get(0).getDescription().getCatalogoFornitore().getName());
		float prezzo_totale = 0;
		int quantita_totale = 0;
		for(int i=0; i<r.righeRDA.size(); ++i){
			prezzo_totale += (r.righeRDA.get(i).getQuantity()*r.righeRDA.get(i).getDescription().getPrezzo());
			quantita_totale += r.righeRDA.get(i).getQuantity();
		}
		this.lblTotale.setText(String.valueOf(prezzo_totale));
		this.lblQuantita.setText(String.valueOf(quantita_totale));
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
