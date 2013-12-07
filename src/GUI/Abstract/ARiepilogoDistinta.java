package GUI.Abstract;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JComboBox;
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

public abstract class ARiepilogoDistinta extends ARiepilogo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static int width = 270;
	protected static int height = 230;
	protected JPanel panel;
	protected JLabel lblTitolo;
	protected JButton btnSalva;
	protected JButton btnElimina;
	protected JSeparator separator;
	protected JSeparator separator_1;
	protected JLabel lblOttimizzatore;
	protected JComboBox<Object> cbOttimizzatore;
	protected JButton btnAdd;
	protected JButton btnOttimizza;

	/**
	 * Costruttore
	 */
	public ARiepilogoDistinta() {
		super();
		this.initialize();
	}

	/**
	 * imposta la grafica
	 */
	private void initialize() {
		this.setSize(new Dimension(270, 210));
		this.setPreferredSize(new Dimension(270, 210));
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		this.panel = new JPanel();
		this.add(this.panel);
		this.panel.setBackground(SystemColor.controlHighlight);
		this.panel.setPreferredSize(new Dimension(280, 230));
		this.panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("40px"),
				ColumnSpec.decode("10px"),
				ColumnSpec.decode("max(80px;default)"),
				ColumnSpec.decode("10px"),
				ColumnSpec.decode("max(80px;default)"),
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));

		this.lblTitolo = new JLabel("Lista Righe Lavoro");
		this.lblTitolo.setFont(new Font("Tahoma", Font.BOLD, 16));
		this.lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel.add(lblTitolo, "3, 2, 3, 1");

		this.separator = new JSeparator();
		this.panel.add(separator, "3, 4, 3, 1");

		this.lblOttimizzatore = new JLabel("Ottimizzatore");
		this.lblOttimizzatore.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblOttimizzatore.setFont(new Font("Tahoma", Font.ITALIC, 11));
		this.panel.add(lblOttimizzatore, "3, 6, 3, 1");
		
		this.cbOttimizzatore = new JComboBox<Object>();
		this.panel.add(this.cbOttimizzatore, "3, 10, 3 ,1");
		

		separator_1 = new JSeparator();
		this.panel.add(separator_1, "3, 12, 3, 1");

		btnSalva = new JButton("Salva Distinta");

		//btnElimina = new JButton("Elimina Distinta");
		
		btnAdd = new JButton("Aggiungi Riga Lavoro");
		
		btnOttimizza = new JButton("Ottimizza");

	}
	
	/**
	 * Metodo che posiziona il bottone nella riga indicata
	 * @param bottone
	 * @param row
	 */
	public void addButton(JButton bottone, int row){
		this.panel.add(bottone,"3, "+row+", 3, 1");
	}
}
