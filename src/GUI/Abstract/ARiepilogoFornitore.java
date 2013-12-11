package GUI.Abstract;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import GUI.ConfigGUI;
import GUI.FornitoriCenter;
import GUI.Plichi.PlicoFornitore;
import GUI.Utilities.CataloghiFilter;
import coedil99.controller.GestisciFornitoreHandler;
import coedil99.model.MCatalogoFornitore;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * Classe astratta per i riepiloghi dei dati del catalogo fornitore
 * 
 * @author Simone
 * 
 */
public abstract class ARiepilogoFornitore extends ARiepilogo {

	protected JPanel panel;
	protected JTextField lblNome;
	protected JSeparator separator;
	protected JButton btnModifica;
	private JButton btnSalva;
	private JLabel lblErrore;
	protected JButton btnCaricaCatalogo;
	protected ImageIcon IcoErrore = new ImageIcon(
			ARiepilogoFornitore.class.getResource("/GUI/image/cancel.png"));
	protected ImageIcon IcoOk = new ImageIcon(
			ARiepilogoFornitore.class.getResource("/GUI/image/ok.png"));
	protected boolean importing;
	private MCatalogoFornitore new_catalogo = null;
	protected JButton btnElimina;
	private JFileChooser fileChooser;
	private CataloghiFilter filtro;

	public ARiepilogoFornitore() {
		super();
		this.initialize();
	}

	/**
	 * Imposta la grafica
	 */
	private void initialize() {
		this.setPreferredSize(new Dimension(380, 120));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		this.panel = new JPanel();
		this.panel.setPreferredSize(new Dimension(380, 120));
		// this.panel.setBackground(new Color(240, 240, 240));
		this.add(panel);
		this.panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("30px"),
				FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("80px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("center:30px"),
				FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("80px"),
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("28px"),
				FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("28px"), },
				new RowSpec[] { FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("25px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("25px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("42px"), }));

		this.lblNome = new JTextField();
		this.lblNome.setBorder(null);
		// this.lblNome.setBackground(new Color(240, 240, 240));
		this.lblNome.setEnabled(false);
		this.lblNome.setDisabledTextColor(Color.BLACK);
		this.lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNome.setFont(new Font("Tahoma", Font.BOLD, 16));

		if (this.lblNome.getKeyListeners().length == 0)
			this.lblNome.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					ARiepilogoFornitore.this.checkNome();
				}
			});

		this.btnModifica = new JButton("");
		btnModifica.setFocusPainted(false);
		this.btnModifica.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.btnModifica.setOpaque(false);
		this.btnModifica.setContentAreaFilled(false);
		this.btnModifica.setBorderPainted(false);
		this.btnModifica.setIcon(new ImageIcon(ARiepilogoFornitore.class
				.getResource("/GUI/image/edit.png")));
		this.btnModifica.setToolTipText("Modifica il nome del fornitore");
		this.btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ARiepilogoFornitore.this.setModify(true);
				checkNome();
			}
		});

		this.btnSalva = new JButton("");
		btnSalva.setFocusPainted(false);
		this.btnSalva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.btnSalva.setOpaque(false);
		this.btnSalva.setContentAreaFilled(false);
		this.btnSalva.setBorderPainted(false);
		this.btnSalva.setIcon(ConfigGUI.getSaveIcon());
		this.btnSalva.setEnabled(false);
		this.btnSalva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!ARiepilogoFornitore.this.btnSalva.isEnabled())
					return;
				else if (ARiepilogoFornitore.this.lblNome.getText().isEmpty()) {
					ARiepilogoFornitore.this.lblErrore.setVisible(true);
				} else {
					ARiepilogoFornitore.this.salvaModifica(new_catalogo);
					ARiepilogoFornitore.this.setModify(false);
				}
			}
		});

		this.lblErrore = new JLabel();
		this.lblErrore.setVisible(true);
		this.panel.add(lblErrore, "2, 2");

		this.panel.add(this.lblNome, "4, 2, 5, 2");

		this.panel.add(this.btnModifica, "12, 2");
		this.panel.add(this.btnSalva, "12, 2");

		this.btnElimina = new JButton();
		btnElimina.setFocusPainted(false);
		this.btnElimina.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.btnElimina.setOpaque(false);
		this.btnElimina.setContentAreaFilled(false);
		this.btnElimina.setBorderPainted(false);
		this.btnElimina.setIcon(ConfigGUI.getAbortIcon());
		this.btnElimina
				.setToolTipText("Annulla l'inserimento del nuovo catalogo");
		this.btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] options = { "Si", "No" };
				int n = JOptionPane
						.showOptionDialog(
								null,
								"Sicuro di voler abbandonare la creazione del Catalogo?\n"
										+ "Nota: Le modifiche non salvate andranno perse",
								"Conferma operazione",
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, options,
								options[1]);
				if (n == JOptionPane.YES_OPTION) {
					aborting();
					reset();
				}
			}
		});

		this.panel.add(btnElimina, "14, 2");

		this.separator = new JSeparator();
		this.panel.add(this.separator, "2, 4, 13, 1");

		this.btnCaricaCatalogo = new JButton();
		btnCaricaCatalogo.setIconTextGap(30);
		btnCaricaCatalogo.setHorizontalTextPosition(SwingConstants.LEADING);
		btnCaricaCatalogo.setText("Importa Prodotti");
		btnCaricaCatalogo.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.btnCaricaCatalogo.setIcon(ConfigGUI.getImportIcon());
		this.btnCaricaCatalogo.setToolTipText("Importa Prodotti");
		this.btnCaricaCatalogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ARiepilogoFornitore.this.importaProdotti();
			}
		});
		panel.add(btnCaricaCatalogo, "4, 6, 5, 1");

		this.btnSalva.setVisible(false);
	}

	@Override
	public abstract void refresh();

	/**
	 * Metodo che salva le modifiche effettuate sul catalogo fornitore
	 */
	private void salvaModifica(MCatalogoFornitore mcf) {
		if (mcf == null) {
			mcf = FornitoriCenter.getInstance().getFornitoreSelezionato();
		}
		mcf.getPersistentModel().setName(this.lblNome.getText());
		mcf.save();
		JOptionPane.showMessageDialog(null,
				"Catalogo Fornitore salvato correttamente");
		this.setImporting(false);
		this.refresh();
		FornitoriCenter.getInstance().setFornitoreSelezionato(mcf);
		FornitoriCenter.getInstance().refreshFornitori();
		FornitoriCenter.getInstance().getClipPanel().focusToListaCataloghi();
	}

	/**
	 * Metodo che importa la lista dei prodotti per un nuovo catalogo
	 */
	private void importaProdotti() {
		fileChooser = new JFileChooser();
		filtro = new CataloghiFilter();
		fileChooser.setFileFilter(filtro);
		if (!PlicoFornitore.getInstance().getListaProdotti().isEmpty()) {
			Object[] options = { "Si", "No" };
			int n = JOptionPane
					.showOptionDialog(
							null,
							"La lista dei prodotti del nuovo catalogo non è vuota\n"
									+ "Importando una nuova lista si perderanno tutti i prodotti precedentemente importati.\n"
									+ "Proseguire?", "Conferma operazione",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options,
							options[1]);
			if (n == JOptionPane.YES_OPTION) {
				int choose = fileChooser
						.showOpenDialog(ARiepilogoFornitore.this);
				if (choose == JFileChooser.APPROVE_OPTION) {
					new_catalogo = GestisciFornitoreHandler.getInstance()
							.getCatalogo();
					new_catalogo.delete();
					this.createNewCatalogo();
				}
			} else
				return;
		} else {
			int choose = fileChooser.showOpenDialog(ARiepilogoFornitore.this);
			if (choose == JFileChooser.APPROVE_OPTION)
				createNewCatalogo();
		}
		this.setImporting(true);
	}

	/**
	 * Metodo che abilita/disabilita la modifica
	 * 
	 * @param mod
	 *            : booleano che indica se si vuole o no modificare il riepilogo
	 */
	public void setModify(boolean mod) {
		this.btnSalva.setVisible(mod);
		this.btnModifica.setVisible(!mod);
		this.lblNome.setEnabled(mod);
		this.lblErrore.setVisible(mod);
		if (mod)
			this.lblNome.setBackground(Color.white);
		else
			lblNome.setBackground(new Color(240, 240, 240));
		this.lblNome.setBorder(null);
		if (this.btnCaricaCatalogo.isVisible()) {
			this.btnElimina.setVisible(true);
		}
		this.validate();
		this.repaint();
	}

	/**
	 * Controllo degli errori di input
	 */
	public void controlloErrori() {
		boolean test = true;
		if (this.lblErrore.getIcon() != null
				&& this.lblErrore.getIcon().equals(IcoErrore)
				|| this.lblNome.getText().isEmpty())
			test = false;
		if (PlicoFornitore.getInstance().getListaProdotti().isEmpty())
			test = false;
		this.btnSalva.setEnabled(test);
		this.validate();
		this.repaint();
	}

	/**
	 * Metodo che ritorna un booleano che indica se si sta creando un nuovo
	 * catalogo fornitore
	 * 
	 * @return
	 */
	public boolean isImporting() {
		return importing;
	}

	/**
	 * Metodo che annulla l'inserimento di un nuovo catalogo fornitore
	 */
	public void aborting() {
		if (new_catalogo != null) {
			new_catalogo = GestisciFornitoreHandler.getInstance().getCatalogo();
			new_catalogo.delete();
			new_catalogo = null;
		}
	}

	/**
	 * Reset del riepilogo
	 */
	public void reset() {
		this.importing = false;
		FornitoriCenter.getInstance().getClipPanel().getButtons().get(1)
				.doClick();
	}

	/**
	 * Metodo che controlla il nome del fornitore
	 */
	protected void checkNome() {
		String line = lblNome.getText();
		String pattern = "[^\\w\\è\\é\\ò\\à\\ù\\ì\'\\s]+";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		if (line.equals("")) {
			lblErrore.setIcon(IcoErrore);
			lblErrore
					.setToolTipText("Il nome del catalogo fornitore non può essere vuoto!");
			lblNome.setBorder(new LineBorder(Color.red));
		} else if (m.find()) {
			lblErrore.setIcon(IcoErrore);
			lblErrore
					.setToolTipText("Il nome del catalogo fornitore può essere solo alfa numerico");
			lblNome.setBorder(new LineBorder(Color.red));
		} else if (!line.equals(FornitoriCenter.getInstance()
				.getFornitoreSelezionato().getPersistentModel().getName())
				&& GestisciFornitoreHandler.getInstance().getFornitoreByName(
						line) != null) {
			lblErrore.setIcon(IcoErrore);
			lblErrore
					.setToolTipText("Esiste già un catalogo fornitore con nome "
							+ line);
			lblNome.setBorder(new LineBorder(Color.red));
		} else {
			lblErrore.setIcon(IcoOk);
			lblErrore.setToolTipText(null);
			lblNome.setBorder(new LineBorder(Color.green));
		}
		this.controlloErrori();
		if (this.btnCaricaCatalogo.isVisible())
			this.setImporting(true);

	}

	/**
	 * Metodo che cambia la visibilità del pulsante per importare il catalogo in
	 * base al booleano che prende in ingresso
	 * 
	 * @param importing
	 *            :boolean
	 */
	public void setImporting(boolean importing) {
		this.btnCaricaCatalogo.setVisible(importing ? true : false);
		this.importing = importing;
	}

	/**
	 * Metodo che salva un nuovo catalogo fornitore
	 */
	protected void createNewCatalogo() {
		GestisciFornitoreHandler.getInstance().setBuilder(
				GestisciFornitoreHandler.cataloghiBuilders.get(filtro
						.getExtension(fileChooser.getSelectedFile())));
		if (GestisciFornitoreHandler.getInstance().ConstructCatalogo(
				fileChooser.getSelectedFile().getPath())) {
			new_catalogo = GestisciFornitoreHandler.getInstance().getCatalogo();
			new_catalogo.getPersistentModel().setName(
					ARiepilogoFornitore.this.lblNome.getText());
			new_catalogo.save();
			FornitoriCenter.getInstance().setFornitoreSelezionato(new_catalogo);
			PlicoFornitore.getInstance().loadListaProdotti(
					this.lblNome.getText());
			this.setModify(true);
			this.btnElimina.setVisible(true);
			this.controlloErrori();
			this.btnCaricaCatalogo.setVisible(true);
			validate();
			repaint();
			JOptionPane.showMessageDialog(null, "Catalogo Caricato");
		}
	}
}
