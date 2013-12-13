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
import GUI.ProgrammaLavoriCenter;
import GUI.Abstract.ACard;
import GUI.Liste.ListaRigheLavoro;
import GUI.Plichi.PlicoDistinta;
import coedil99.model.MDistinta;
import coedil99.model.MRigaLavoro;
import coedil99.persistentmodel.RigaLavoro;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * 
 * @author francesco
 * 
 *         Gestisce il pannello che mostra i dettagli principali di una riga RDA
 *         creata o caricata
 */
public class CardRigaLavoro extends ACard {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnElimina;
	private JLabel lblAltezza;
	private JLabel txtAltezza;
	private JLabel lblLunghezza;
	private JLabel txtLunghezza;
	private JLabel lblBase;
	private JLabel txtBase;
	private ListaRigheLavoro listaRigheLavoro;
	private JButton btnModifica;
	private JLabel lblCapitello;
	private JLabel lblTipoCapitello;
	private JLabel txtCapitello;
	private JLabel txtTipoCapitello;
	private JLabel lblNumero;
	private JLabel txtNumero;
	private JLabel lblNote;
	private JLabel txtNote;

	/**
	 * Costruttore (prende il padre come parametro)
	 * 
	 * @param lrRDA
	 */
	public CardRigaLavoro(ListaRigheLavoro lrLavoro) {
		super(lrLavoro);
		this.listaRigheLavoro = lrLavoro;
		this.setPreferredSize(new Dimension(270, 220));
		this.setSize(270, 220);
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));

		btnModifica = new JButton("Modifica");
		btnModifica.setPreferredSize(new Dimension(110, 40));
		btnModifica.setIconTextGap(10);
		btnModifica.setIcon(ConfigGUI.getInstance().getEditIcon());
		add(btnModifica, "6, 2");

		lblBase = new JLabel("Base: ");
		add(lblBase, "2, 4");

		txtBase = new JLabel("");
		add(txtBase, "4, 4, 3, 1, right, default");

		lblAltezza = new JLabel("Altezza: ");
		add(lblAltezza, "2, 6");

		txtAltezza = new JLabel("");
		add(txtAltezza, "4, 6, 3, 1, right, default");

		lblLunghezza = new JLabel("Lunghezza: ");
		add(lblLunghezza, "2, 8");

		txtLunghezza = new JLabel("");
		add(txtLunghezza, "4, 8, 3, 1, right, default");

		lblNumero = new JLabel("Numero");
		add(lblNumero, "2, 10");

		txtNumero = new JLabel("");
		add(txtNumero, "4, 10, 3, 1, right, default");

		lblCapitello = new JLabel("Capitello");
		add(lblCapitello, "2, 12");

		txtCapitello = new JLabel("");
		add(txtCapitello, "4, 12, 3, 1, right, default");

		lblTipoCapitello = new JLabel("Tipo Capitello");
		add(lblTipoCapitello, "2, 14");

		txtTipoCapitello = new JLabel("");
		add(txtTipoCapitello, "4, 14, 3, 1, right, default");

		lblNote = new JLabel("Note");
		add(lblNote, "2, 16");

		txtNote = new JLabel("");
		add(txtNote, "4, 16, 3, 1, right, default");

		btnElimina = new JButton("Elimina");
		btnElimina.setPreferredSize(new Dimension(110, 40));
		btnElimina.setIconTextGap(10);
		this.btnElimina.setIcon(ConfigGUI.getInstance().getAbortIcon());
		add(btnElimina, "2, 2");

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				CardRigaLavoro.this
						.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		this.validate();
		this.repaint();

	}

	@Override
	/**
	 * Carica una riga RDA
	 * @param o:Object
	 */
	public void load(Object o) {
		final MRigaLavoro riga = new MRigaLavoro();
		riga.setPersistentModel((RigaLavoro) o);
		this.txtAltezza.setText(String.valueOf(riga.getPersistentModel()
				.getGeometria().getAltezza()));
		this.txtLunghezza.setText(String.valueOf(riga.getPersistentModel()
				.getGeometria().getLunghezza()));
		this.txtBase.setText(String.valueOf(riga.getPersistentModel()
				.getGeometria().getBase()));
		if (riga.getPersistentModel().getCapitello()) {
			this.txtCapitello.setText("Si");
			this.txtTipoCapitello.setText(riga.getPersistentModel()
					.getProfiloCapitello());
		} else
			this.txtCapitello.setText("No");
		this.txtNumero.setText(String.valueOf(riga.getPersistentModel()
				.getNumero()));
		this.txtNote.setText(riga.getPersistentModel().getNote());
		if(this.btnModifica.getMouseListeners().length <=1 )
			this.btnModifica.addMouseListener(new MouseAdapter() {
	
				@Override
				public void mouseEntered(MouseEvent arg0) {
					CardRigaLavoro.this.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
	
				@Override
				public void mouseClicked(MouseEvent arg0) {
					CardRigaLavoro.this.listaRigheLavoro.deselectAll();
					CardRigaLavoro.this.setBackground(ConfigGUI.getInstance().getColoreRigaRDA());
					PlicoDistinta.getInstance().addRiquadroRigaLavoro(riga);
				}
			});
		this.btnElimina.setIcon(ConfigGUI.getInstance().getAbortIcon());
		if(this.btnElimina.getMouseListeners().length <=1 )
			this.btnElimina.addMouseListener(new MouseAdapter() {
	
				@Override
				public void mouseClicked(MouseEvent e) {
					Object[] options = { "Si", "No" };
					int n;
					if (CardRigaLavoro.this.listaRigheLavoro.getNumRigheLavoro() == 1) {
						n = JOptionPane.showOptionDialog(
								ProgrammaLavoriCenter.getInstance(),
								"Eliminando l'ultima riga cancellerai l'intera distinta.\n"
										+ "Sei sicuro di voler eliminare questa riga lavoro?\n"
										+ "Nota: questa operazione non è reversibile",
								"Conferma operazione",
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, options,
								options[1]);
					} else {
						n = JOptionPane.showOptionDialog(
								ProgrammaLavoriCenter.getInstance(),
								"Sei sicuro di voler eliminare questa riga lavoro?\n"
										+ "Nota: questa operazione non è reversibile",
								"Conferma operazione",
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, options,
								options[1]);
					}
					if (n == JOptionPane.YES_OPTION) {
						MDistinta odistinta = new MDistinta(ProgrammaLavoriCenter
								.getInstance().getCommessaSelezionata()
								.getPersistentModel().getDistinta().getID());
						odistinta.eliminaRigaLavoro(riga.getPersistentModel());
						CardRigaLavoro.this.listaRigheLavoro
								.removeRiquadro(CardRigaLavoro.this);
						PlicoDistinta.getInstance().refresh();
						JOptionPane.showMessageDialog(null,
								"Riga lavoro eliminata correttamente",
								"Messaggio di Sistema", JOptionPane.INFORMATION_MESSAGE);
					}
				}
	
				@Override
				public void mouseEntered(MouseEvent e) {
					CardRigaLavoro.this.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
	
			});

		this.validate();
		this.repaint();

	}
	
	/**
	 * Metodo che abilita/disabilita i pulsanti di modifica e elimina
	 * @param edit
	 */
	public void setEdit(boolean edit){
		this.btnElimina.setVisible(edit);
		this.btnModifica.setVisible(edit);
		this.setPreferredSize(new Dimension(270,180));
		this.setSize(270,180);
		this.validate();
		this.repaint();
	}

}