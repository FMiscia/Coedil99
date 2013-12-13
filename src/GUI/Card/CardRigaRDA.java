package GUI.Card;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import GUI.ConfigGUI;
import GUI.RDACenter;
import GUI.Abstract.ACard;
import GUI.Form.ModificaFormRDA;
import GUI.Form.ModificaFormRDAFactory;
import GUI.Liste.ListaRigheRDA;
import GUI.Plichi.PlicoRDA;
import coedil99.controller.GestisciRDAHandler;
import coedil99.model.MRigaRDA;
import coedil99.persistentmodel.RigaRDA;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * 
 * @author francesco
 *
 * Gestisce il pannello che mostra i dettagli principali di una riga RDA
 * creata o caricata
 */
public class CardRigaRDA extends ACard {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnElimina;
	private JLabel lblEssenza;
	private JLabel txtEssenza;
	private JLabel lblQuantita;
	private JLabel txtQuantita;
	private JLabel lblAltezza;
	private JLabel txtAltezza;
	private JLabel lblLunghezza;
	private JLabel txtLunghezza;
	private JLabel lblBase;
	private JLabel txtBase;
	private JLabel lblPezzi;
	private JLabel txtPezzi;
	private JLabel lblPrezzo;
	private JLabel txtPrezzo;
	ListaRigheRDA listaRigheRDA;
	private JButton btnModifica;

	/**
	 * Costruttore (prende il padre come parametro)
	 * @param lrRDA
	 */
	public CardRigaRDA(ListaRigheRDA lrRDA) {
		super(lrRDA);
		this.listaRigheRDA = lrRDA;
		this.setPreferredSize(new Dimension(270, 220));
		this.setBackground(ConfigGUI.getInstance().getColoreRigaRDA());
		this.setBorder(new LineBorder(ConfigGUI.getInstance().getColoreBordoCard()));
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(85px;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(35px;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(85px;default)"),
				FormFactory.RELATED_GAP_COLSPEC,},
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

		lblEssenza = new JLabel("Essenza: ");
		add(lblEssenza, "2, 4");

		txtEssenza = new JLabel("");
		add(txtEssenza, "4, 4, 3, 1, right, default");

		lblQuantita = new JLabel("Quantità: ");
		add(lblQuantita, "2, 6");

		txtQuantita = new JLabel("");
		add(txtQuantita, "4, 6, 3, 1, right, default");

		lblAltezza = new JLabel("Altezza: ");
		add(lblAltezza, "2, 8");

		txtAltezza = new JLabel("");
		add(txtAltezza, "4, 8, 3, 1, right, default");

		lblLunghezza = new JLabel("Lunghezza: ");
		add(lblLunghezza, "2, 10");

		txtLunghezza = new JLabel("");
		add(txtLunghezza, "4, 10, 3, 1, right, default");

		lblBase = new JLabel("Base: ");
		add(lblBase, "2, 12");

		txtBase = new JLabel("");
		add(txtBase, "4, 12, 3, 1, right, default");

		lblPezzi = new JLabel("Pezzi per pacco: ");
		add(lblPezzi, "2, 14");

		txtPezzi = new JLabel("");
		add(txtPezzi, "4, 14, 3, 1, right, default");

		lblPrezzo = new JLabel("Prezzo: ");
		add(lblPrezzo, "2, 16");

		txtPrezzo = new JLabel("");
		add(txtPrezzo, "4, 16, 3, 1, right, default");
		
		btnModifica = new JButton("Modifica");
		btnModifica.setPreferredSize(new Dimension(110, 40));
		btnModifica.setIconTextGap(10);
		btnModifica.setIcon(ConfigGUI.getInstance().getEditIcon());
		add(btnModifica, "6, 2");
		
		btnElimina = new JButton("Elimina");
		btnElimina.setPreferredSize(new Dimension(110, 40));
		btnElimina.setIconTextGap(10);
		this.btnElimina.setIcon(ConfigGUI.getInstance().getAbortIcon());
		add(btnElimina, "2, 2");

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				CardRigaRDA.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		this.setCardOptions();
		this.validate();
		this.repaint();
			
	}

	/**
	 * Gestisce i pulsanti da utilizzare per la riga RDA, ovvero 
	 * a seconda dello stato permetterà la modifica di quella riga
	 */
	private void setCardOptions() {
		if (RDACenter.getInstance().getClipPanel().isSelected("NUOVA")){
			btnModifica.setVisible(false);
			btnElimina.setVisible(true);
			this.setPreferredSize(new Dimension(270, 220));
		}
		else if(RDACenter.getInstance().getClipPanel().isSelected(GestisciRDAHandler.ATTESA_CONFERMA)){
			btnElimina.setVisible(false);
			btnModifica.setVisible(false);
			this.setPreferredSize(new Dimension(270, 180));
		}
		else if(RDACenter.getInstance().getClipPanel().isSelected(GestisciRDAHandler.CONGELATA)){
			btnElimina.setVisible(true);
			btnModifica.setVisible(true);
			this.setPreferredSize(new Dimension(270, 220));
		}
		else if(RDACenter.getInstance().getClipPanel().isSelected(GestisciRDAHandler.RIFIUTATA)){
			btnElimina.setVisible(false);
			btnModifica.setVisible(false);
			this.setPreferredSize(new Dimension(270, 180));
		}
		else if(RDACenter.getInstance().getClipPanel().isSelected(GestisciRDAHandler.CONFERMATA)){
			btnElimina.setVisible(false);
			btnModifica.setVisible(false);
			this.setPreferredSize(new Dimension(270, 180));
		}
	}
	/**
	 * Gestisce i pulsanti da utilizzare per la riga RDA, ovvero 
	 * a seconda dello stato permetterà la modifica di quella riga
	 */
	public void setCardWithNoOptions() {
		btnElimina.setVisible(false);
		btnModifica.setVisible(false);
		this.setPreferredSize(new Dimension(270, 180));
	}

	@Override
	/**
	 * Carica una riga RDA
	 * @param o:Object
	 */
	public void load(Object o) {
		final MRigaRDA riga = new MRigaRDA();
		riga.setPersistentModel((RigaRDA) o);
		this.txtEssenza.setText(riga.getPersistentModel().getDescription().getEssenza());
		this.txtQuantita.setText(String.valueOf(riga.getPersistentModel().getQuantity()));
		this.txtAltezza.setText(String.valueOf(riga.getPersistentModel().getDescription()
				.getGeometria().getAltezza()));
		this.txtLunghezza.setText(String.valueOf(riga.getPersistentModel().getDescription()
				.getGeometria().getLunghezza()));
		this.txtBase.setText(String.valueOf(riga.getPersistentModel().getDescription()
				.getGeometria().getBase()));
		this.txtPezzi.setText(String.valueOf(riga.getPersistentModel().getDescription()
				.getPezzi_per_pacco()));
		this.txtPrezzo.setText(String
				.valueOf(riga.getPersistentModel().getDescription().getPrezzo()));
		this.btnModifica.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent arg0) {
				CardRigaRDA.this.setCursor(new Cursor(Cursor.HAND_CURSOR));

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				CardRigaRDA.this.listaRigheRDA.deselectAll();
				CardRigaRDA.this.setBackground(ConfigGUI.getInstance().getColoreRigaRDA());
				ModificaFormRDA form = (ModificaFormRDA) ModificaFormRDAFactory
						.getInstance().makeFormRDA();
				form.modificaRDA(riga);
				PlicoRDA.getInstance().addFormRDA(form);
			}
		});
		this.btnElimina.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] options = { "Si", "No" };
				int n;
				if(CardRigaRDA.this.listaRigheRDA.getNumRigheRDA() == 1){
					n = JOptionPane.showOptionDialog(
							RDACenter.getInstance(),
							"Eliminando l'ultima riga cancellerai l'intera RDA.\n" +
							"Sei sicuro di voler eliminare questa riga RDA?\n"
									+ "Nota: questa operazione non è reversibile",
							"Conferma operazione",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				}
				else{
					n = JOptionPane.showOptionDialog(
							RDACenter.getInstance(),
							"Sei sicuro di voler eliminare questa riga RDA?\n"
									+ "Nota: questa operazione non è reversibile",
							"Conferma operazione",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				}
				if (n == JOptionPane.YES_OPTION) {
						riga.delete();
						CardRigaRDA.this.listaRigheRDA
								.removeRiquadro(CardRigaRDA.this);
						PlicoRDA.getInstance().controllaListaRighe();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				CardRigaRDA.this.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

		});

		this.validate();
		this.repaint();

	}

}
