package GUI.Abstract;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import GUI.RDACenter;
import coedil99.model.RDA;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class ARiepilogoRDA extends JPanel {
	private JLabel lblTitolo;
	private JLabel lblPrezzo;
	private JLabel lblTotale;
	private JButton btSalva;
	private JButton btElimina;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblFornitore;
	private JLabel lblFornitoreSelezionato;
	private JLabel lblNumeroPacchi;
	private JLabel lblQuantita;

	public ARiepilogoRDA() {
		setBackground(SystemColor.controlHighlight);
		this.setPreferredSize(new Dimension(180, 200));
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(41dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(49dlu;default)"),},
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
		add(lblTitolo, "2, 2, 3, 1");
		
		separator = new JSeparator();
		add(separator, "2, 4, 3, 1");
		
		lblFornitore = new JLabel("Fornitore");
		lblFornitore.setFont(new Font("Tahoma", Font.ITALIC, 11));
		add(lblFornitore, "2, 6");
		
		lblFornitoreSelezionato = new JLabel("");
		add(lblFornitoreSelezionato, "4, 6, right, default");
		
		lblNumeroPacchi = new JLabel("Numero di pacchi");
		lblNumeroPacchi.setFont(new Font("Tahoma", Font.ITALIC, 11));
		add(lblNumeroPacchi, "2, 8");
		
		lblQuantita = new JLabel("");
		add(lblQuantita, "4, 8, right, default");
		
		lblTotale = new JLabel("");
		add(lblTotale, "4, 10, right, default");
		
		lblPrezzo = new JLabel("Prezzo Totale RDA");
		lblPrezzo.setFont(new Font("Tahoma", Font.ITALIC, 11));
		add(lblPrezzo, "2, 10");
		
		separator_1 = new JSeparator();
		add(separator_1, "2, 12, 3, 1");
		
		btSalva = new JButton("Salva RDA");
		add(btSalva, "2, 14");
		
		btElimina = new JButton("Elimina RDA");
		add(btElimina, "2, 16");
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
		this.validate();
		this.repaint();
	}

}
