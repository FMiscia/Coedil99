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

import GUI.RDACenter;
import GUI.Abstract.ACard;
import GUI.FormRDA.ModificaFormRDA;
import GUI.FormRDA.ModificaFormRDAFactory;
import GUI.Liste.ListaRigheRDA;
import GUI.Plichi.PlicoRDA;
import coedil99.model.RigaRDA;

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
		//setBounds(new Rectangle(0, 0, 0, 0));
		this.setPreferredSize(new Dimension(269, 220));
		this.setBackground(new Color(192, 192, 192));
		this.setBorder(new LineBorder(Color.BLACK));
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
		if (RDACenter.getInstance().getClipPanel().isSelectedNuova()){
			btnElimina = new JButton("Elimina");
			btnElimina.setBackground(Color.LIGHT_GRAY);
			add(btnElimina, "2, 2");
			
			btnModifica = new JButton("Modifica");
			btnModifica.setBackground(Color.LIGHT_GRAY);
			btnModifica.setVisible(false);
			add(btnModifica, "4, 2");
		}
		else if(RDACenter.getInstance().getClipPanel().isSelectedConfermate()){
			btnElimina = new JButton("Elimina");
			btnElimina.setBackground(Color.LIGHT_GRAY);
			btnElimina.setVisible(false);
			add(btnElimina, "2, 2");
			
			btnModifica = new JButton("Modifica");
			//btnModifica.setBackground(Color.LIGHT_GRAY);
			btnModifica.setVisible(false);
			add(btnModifica, "4, 2");
			this.setPreferredSize(new Dimension(269, 190));
		} else{
			btnElimina = new JButton("Elimina");
			btnElimina.setBackground(Color.LIGHT_GRAY);
			add(btnElimina, "4, 2");
			
			btnModifica = new JButton("Modifica");
			btnModifica.setBackground(Color.LIGHT_GRAY);
			add(btnModifica, "2, 2");
		}
	}

	@Override
	/**
	 * Carica una riga RDA
	 * @param o:Object
	 */
	public void load(Object o) {
		final RigaRDA riga = (RigaRDA) o;
		this.txtEssenza.setText(riga.getDescription().getEssenza());
		this.txtQuantita.setText(String.valueOf(riga.getQuantity()));
		this.txtAltezza.setText(String.valueOf(riga.getDescription()
				.getGeometria().getAltezza()));
		this.txtLunghezza.setText(String.valueOf(riga.getDescription()
				.getGeometria().getLunghezza()));
		this.txtLarghezza.setText(String.valueOf(riga.getDescription()
				.getGeometria().getBase()));
		this.txtPezzi.setText(String.valueOf(riga.getDescription()
				.getPezzi_per_pacco()));
		this.txtPrezzo.setText(String
				.valueOf(riga.getDescription().getPrezzo()));
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
				CardRigaRDA.this.setBackground(new Color(130,130,130));
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
							"Cancellando l'ultima riga cancellerai l'intera RDA.\n" +
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
					try {
						riga.deleteAndDissociate();
						CardRigaRDA.this.listaRigheRDA
								.removeRiquadro(CardRigaRDA.this);
						PlicoRDA.getInstance().controllaListaRighe();
					} catch (PersistentException e1) {
						e1.printStackTrace();
					}
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
