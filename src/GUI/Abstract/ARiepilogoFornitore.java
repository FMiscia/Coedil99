package GUI.Abstract;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import GUI.FornitoriCenter;
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
	protected JButton btnElimina;
	protected JButton btnModifica;
	private JButton btnSalva;
	private JLabel lblErrore;
	private JButton btnCaricaCatalogo;

	public ARiepilogoFornitore() {
		super();
		this.initialize();
	}

	/**
	 * Imposta la grafica
	 */
	private void initialize() {
		this.setPreferredSize(new Dimension(340, 190));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		this.panel = new JPanel();
		this.panel.setPreferredSize(new Dimension(340, 190));
		this.panel.setBackground(new Color(240, 240, 240));
		this.add(panel);
		this.panel
				.setLayout(new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("80px"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("60px"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("75px"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("90px"),
						FormFactory.RELATED_GAP_COLSPEC, }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("30px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("30px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("30px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("30px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		this.lblNome = new JTextField();
		this.lblNome.setBorder(null);
		this.lblNome.setBackground(new Color(240, 240, 240));
		this.lblNome.setEnabled(false);
		this.lblNome.setDisabledTextColor(Color.BLACK);
		this.lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNome.setFont(new Font("Tahoma", Font.BOLD, 16));
		this.panel.add(this.lblNome, "2, 2, 5, 1");

		this.separator = new JSeparator();
		this.panel.add(this.separator, "2, 4, 5, 1");

		this.btnElimina = new JButton("Elimina");
		this.panel.add(this.btnElimina, "8, 4");

		/*
		 * this.lblNome.addPropertyChangeListener(new PropertyChangeListener() {
		 * 
		 * @Override public void propertyChange(PropertyChangeEvent evt) { if
		 * (evt.getPropertyName().equals("enabled") &&
		 * evt.getOldValue().equals("true")) {
		 * ARiepilogoFornitore.this.lblNome.setBackground(new Color( 240, 240,
		 * 240)); ARiepilogoFornitore.this.btn.setText("Modifica");
		 * ARiepilogoFornitore
		 * .this.btn.removeMouseListener(ARiepilogoFornitore.this
		 * .btn.getMouseListeners()[0]); } else if
		 * (evt.getPropertyName().equals("enabled")) {
		 * ARiepilogoFornitore.this.lblNome.setBackground(Color.WHITE);
		 * ARiepilogoFornitore.this.btn.setText("Salva"); if
		 * (ARiepilogoFornitore.this.getMouseListeners().length < 2)
		 * ARiepilogoFornitore.this.btn .addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent e) {
		 * ARiepilogoFornitore.this .salvaModifica(); } }); } } });
		 */

		this.btnModifica = new JButton("Modifica");
		this.btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ARiepilogoFornitore.this.lblNome.setBackground(Color.WHITE);
				ARiepilogoFornitore.this.lblNome.setEnabled(true);
				ARiepilogoFornitore.this.btnModifica.setVisible(false);
				ARiepilogoFornitore.this.btnSalva.setVisible(true);
				ARiepilogoFornitore.this.validate();
				ARiepilogoFornitore.this.repaint();
			}
		});

		this.btnSalva = new JButton("Salva");
		this.btnSalva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (ARiepilogoFornitore.this.lblNome.getText().isEmpty()) {
					ARiepilogoFornitore.this.lblErrore.setVisible(true);
				} else {
					ARiepilogoFornitore.this.salvaModifica();
					ARiepilogoFornitore.this.lblErrore.setVisible(false);
					ARiepilogoFornitore.this.lblNome.setBackground(new Color(
							240, 240, 240));
					ARiepilogoFornitore.this.btnModifica.setVisible(true);
					ARiepilogoFornitore.this.btnSalva.setVisible(false);
				}
			}
		});

		this.panel.add(this.btnModifica, "8, 2");
		this.panel.add(this.btnSalva, "8, 2");

		this.lblErrore = new JLabel("Testo Errore");
		this.lblErrore.setVisible(false);
		this.panel.add(lblErrore, "2, 6, 5, 1");

		btnCaricaCatalogo = new JButton("Importa Catalogo Fornitore");
		btnCaricaCatalogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				CataloghiFilter filtro = new CataloghiFilter();
				fileChooser.setFileFilter(filtro);
				int n = fileChooser.showOpenDialog(ARiepilogoFornitore.this);
				if (n == JFileChooser.APPROVE_OPTION) {
					GestisciFornitoreHandler.getInstance().setBuilder(
							GestisciFornitoreHandler.cataloghiBuilders
									.get(filtro.getExtension(fileChooser
											.getSelectedFile())));
					GestisciFornitoreHandler.getInstance().ConstructCatalogo(
							fileChooser.getSelectedFile().getPath());
					MCatalogoFornitore new_catalogo = GestisciFornitoreHandler.getInstance().getCatalogo();
					new_catalogo.getPersistentModel().setName(ARiepilogoFornitore.this.lblNome.getText());
					//new_catalogo.save();
					JOptionPane.showMessageDialog(null, "Catalogo Caricato");
				}

			}
		});
		panel.add(btnCaricaCatalogo, "2, 8, 5, 1");
		this.btnSalva.setVisible(false);
	}

	@Override
	public abstract void refresh();

	/**
	 * Metodo che salva le modifiche effettuate sul catalogo fornitore
	 */
	private void salvaModifica() {

		MCatalogoFornitore mcf = FornitoriCenter.getInstance()
				.getFornitoreSelezionato();
		mcf.getPersistentModel().setName(this.lblNome.getText());
		mcf.save();
		JOptionPane.showMessageDialog(null,
				"Catalogo Fornitore salvato correttamente");
		FornitoriCenter.getInstance().refreshFornitori();

	}

}
