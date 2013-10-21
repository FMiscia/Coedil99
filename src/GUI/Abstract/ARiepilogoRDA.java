package GUI.Abstract;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * @author francesco Mostra un pannello di riepilogo della RDA in focus
 */

public abstract class ARiepilogoRDA extends JPanel {

	protected static int width = 270;
	protected static int height = 230;
	protected JPanel panel;
	protected JLabel lblTitolo;
	protected JLabel lblPrezzo;
	protected JLabel lblTotale;
	protected JButton btnSalva;
	protected JButton btnElimina;
	protected JButton btnInvia;
	protected JButton btnArrivata;
	protected JSeparator separator;
	protected JSeparator separator_1;
	protected JLabel lblFornitore;
	protected JLabel lblFornitoreSelezionato;
	protected JLabel lblNumeroPacchi;
	protected JLabel lblQuantita;

	/**
	 * Costruttore
	 */
	public ARiepilogoRDA() {
		this.initialize();
	}

	/**
	 * Aggiorna il pannello
	 */
	public abstract void refresh();

	/**
	 * imposta la grafica
	 */
	private void initialize() {
		this.setSize(new Dimension(width, height));
		this.setPreferredSize(new Dimension(width, height));
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		this.panel = new JPanel();
		this.add(this.panel);
		this.panel.setBackground(SystemColor.controlHighlight);
		this.panel.setPreferredSize(new Dimension(280, 230));
		this.panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("40px"), ColumnSpec.decode("10px"),
				ColumnSpec.decode("max(60px;default)"),
				ColumnSpec.decode("10px"),
				ColumnSpec.decode("max(70px;default)"),
				ColumnSpec.decode("10px"), ColumnSpec.decode("40px"), },
				new RowSpec[] { FormFactory.RELATED_GAP_ROWSPEC,
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
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

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
		this.panel.add(btnSalva, "3, 14, 3, 1");

		btnElimina = new JButton("Elimina RDA");
		this.panel.add(btnElimina, "3, 16, 3, 1");

		btnInvia = new JButton("Invia RDA");
		this.panel.add(btnInvia, "3, 18, 3, 1");

		btnArrivata = new JButton();
		btnArrivata.setLayout(new BorderLayout());
		JLabel label1 = new JLabel("Conferma Arrivo");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel label2 = new JLabel("Merci");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		btnArrivata.add(BorderLayout.NORTH, label1);
		btnArrivata.add(BorderLayout.SOUTH, label2);
		this.panel.add(btnArrivata, "3, 20, 3, 1");
	}
}
