package GUI.Abstract;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import GUI.FornitoriCenter;
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
	protected JButton btn = new JButton();
	protected JButton btnElimina;
	protected JButton btnModifica;
	private JButton btnSalva;

	public ARiepilogoFornitore() {
		super();
		this.initialize();
	}

	/**
	 * Imposta la grafica
	 */
	private void initialize() {
		this.setPreferredSize(new Dimension(261, 130));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		this.panel = new JPanel();
		this.panel.setPreferredSize(new Dimension(250, 130));
		this.panel.setBackground(new Color(240, 240, 240));
		this.add(panel);
		this.panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("80px"),
				FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("60px"),
				FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("80px"),
				FormFactory.RELATED_GAP_COLSPEC, }, new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"), }));

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
		this.panel.add(this.btnElimina, "5, 6, 2, 1");

		/*this.lblNome.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("enabled")
						&& evt.getOldValue().equals("true")) {
					ARiepilogoFornitore.this.lblNome.setBackground(new Color(
							240, 240, 240));
					ARiepilogoFornitore.this.btn.setText("Modifica");
					ARiepilogoFornitore.this.btn.removeMouseListener(ARiepilogoFornitore.this.btn.getMouseListeners()[0]);
				} else if (evt.getPropertyName().equals("enabled")) {
					ARiepilogoFornitore.this.lblNome.setBackground(Color.WHITE);
					ARiepilogoFornitore.this.btn.setText("Salva");
					if (ARiepilogoFornitore.this.getMouseListeners().length < 2)
						ARiepilogoFornitore.this.btn
								.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										ARiepilogoFornitore.this
												.salvaModifica();
									}
								});
				}
			}
		});*/
		
		
		this.btnModifica = new JButton("Modifica");
		this.btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
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
			public void mouseClicked(MouseEvent e){
				ARiepilogoFornitore.this.salvaModifica();
				ARiepilogoFornitore.this.lblNome.setBackground(new Color(
						240, 240, 240));
				ARiepilogoFornitore.this.btnModifica.setVisible(true);
				ARiepilogoFornitore.this.btnSalva.setVisible(false);
			}
		});
		
		this.panel.add(this.btnModifica, "2, 6, 2, 1"); 
		this.panel.add(this.btnSalva, "2, 6, 2, 1");
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
