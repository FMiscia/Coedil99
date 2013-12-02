package GUI.Card;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import org.orm.PersistentException;

import org.hibernate.transaction.BTMTransactionManagerLookup;

import GUI.ConfigGUI;
import GUI.RDACenter;
import GUI.Abstract.ACard;
import GUI.FormRDA.ModificaFormRDA;
import GUI.FormRDA.ModificaFormRDAFactory;
import GUI.Liste.ListaRigheRDA;
import GUI.Plichi.PlicoRDA;
import coedil99.controller.GestisciRDAHandler;
import coedil99.model.MRigaRDA;
import coedil99.persistentmodel.IPersistentModel;
import coedil99.persistentmodel.RigaRDA;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

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
	private JLabel txtLarghezza;
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
		this.setPreferredSize(new Dimension(269, 220));
		this.setBackground(ConfigGUI.getColoreRigaRDA());
		this.setBorder(new LineBorder(ConfigGUI.getColoreBordoCard()));
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(52dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(52dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(88dlu;default)"), }, new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, }));

		lblEssenza = new JLabel("Essenza: ");
		add(lblEssenza, "2, 4");

		txtEssenza = new JLabel("");
		add(txtEssenza, "4, 4");

		lblQuantita = new JLabel("Quantità: ");
		add(lblQuantita, "2, 6");

		txtQuantita = new JLabel("");
		add(txtQuantita, "4, 6");

		lblAltezza = new JLabel("Altezza: ");
		add(lblAltezza, "2, 8");

		txtAltezza = new JLabel("");
		add(txtAltezza, "4, 8");

		lblLunghezza = new JLabel("Lunghezza: ");
		add(lblLunghezza, "2, 10");

		txtLunghezza = new JLabel("");
		add(txtLunghezza, "4, 10");

		lblBase = new JLabel("Base: ");
		add(lblBase, "2, 12");

		txtLarghezza = new JLabel("");
		add(txtLarghezza, "4, 12");

		lblPezzi = new JLabel("Pezzi per pacco: ");
		add(lblPezzi, "2, 14");

		txtPezzi = new JLabel("");
		add(txtPezzi, "4, 14");

		lblPrezzo = new JLabel("Prezzo: ");
		add(lblPrezzo, "2, 16");

		txtPrezzo = new JLabel("");
		add(txtPrezzo, "4, 16");

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
			btnElimina = new JButton("Elimina");
			add(btnElimina, "2, 2");
			
			btnModifica = new JButton("Modifica");
			btnModifica.setVisible(false);
			add(btnModifica, "4, 2");
		}
		else if(RDACenter.getInstance().getClipPanel().isSelected(GestisciRDAHandler.ATTESA_CONFERMA)){
			btnElimina = new JButton("Elimina");
			btnElimina.setVisible(false);
			add(btnElimina, "2, 2");
			
			btnModifica = new JButton("Modifica");
			btnModifica.setVisible(false);
			add(btnModifica, "4, 2");
			this.setPreferredSize(new Dimension(269, 190));
		}
		else if(RDACenter.getInstance().getClipPanel().isSelected(GestisciRDAHandler.CONGELATA)){
			btnElimina = new JButton("Elimina");
			btnElimina.setVisible(true);
			add(btnElimina, "2, 2");
			
			btnModifica = new JButton("Modifica");
			btnModifica.setVisible(true);
			add(btnModifica, "4, 2");
			this.setPreferredSize(new Dimension(269, 190));
		}
		else if(RDACenter.getInstance().getClipPanel().isSelected(GestisciRDAHandler.RIFIUTATA)){
			btnElimina = new JButton("Elimina");
			btnElimina.setVisible(false);
			add(btnElimina, "2, 2");
			
			btnModifica = new JButton("Modifica");
			btnModifica.setVisible(false);
			add(btnModifica, "4, 2");
			this.setPreferredSize(new Dimension(269, 190));
		}
		else if(RDACenter.getInstance().getClipPanel().isSelected(GestisciRDAHandler.CONFERMATA)){
			btnElimina = new JButton("Elimina");
			btnElimina.setVisible(false);
			add(btnElimina, "4, 2");
			
			btnModifica = new JButton("Modifica");
			btnModifica.setVisible(false);
			add(btnModifica, "2, 2");
		}
	}
	/**
	 * Gestisce i pulsanti da utilizzare per la riga RDA, ovvero 
	 * a seconda dello stato permetterà la modifica di quella riga
	 */
	public void setCardWithNoOptions() {
		this.remove(btnElimina);
		this.remove(btnModifica);
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
		this.txtLarghezza.setText(String.valueOf(riga.getPersistentModel().getDescription()
				.getGeometria().getBase()));
		this.txtPezzi.setText(String.valueOf(riga.getPersistentModel().getDescription()
				.getPezzi_per_pacco()));
		this.txtPrezzo.setText(String
				.valueOf(riga.getPersistentModel().getDescription().getPrezzo()));
		this.btnModifica.setIcon(new ImageIcon(CardRigaRDA.class
				.getResource("/GUI/image/congelata.png")));
		this.btnModifica.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent arg0) {
				CardRigaRDA.this.setCursor(new Cursor(Cursor.HAND_CURSOR));

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				CardRigaRDA.this.listaRigheRDA.deselectAll();
				CardRigaRDA.this.setBackground(ConfigGUI.getColoreRigaRDA());
				ModificaFormRDA form = (ModificaFormRDA) ModificaFormRDAFactory
						.getInstance().makeFormRDA();
				form.modificaRDA(riga);
				PlicoRDA.getInstance().addFormRDA(form);
			}
		});
		this.btnElimina.setIcon(new ImageIcon(CardRigaRDA.class
				.getResource("/GUI/image/cancella.png")));
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
