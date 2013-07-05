package GUIelaboradistinta;

import java.awt.BorderLayout;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import GUIelaboradistinta.model.GDatiDistintaModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import elaboradistinta.model.Distinta;
import elaboradistinta.model.Geometria;
import elaboradistinta.model.GeometriaFactory;
import elaboradistinta.model.RigaLavoro;
import elaboradistinta.model.RigaLavoroFactory;

import javax.swing.JEditorPane;

public class newLine {
	private Frame f;
	private JTextField base;
	private JTextField altezza;
	private JTextField lunghezza;
	private JTextField numero;
	private javax.swing.JComboBox<String> capitello;
	private JTextField tipo;
	private JEditorPane note;
	/**
	 * Create the panel.
	 */
	public newLine(final GDatiDistintaModel m, final Distinta d) {
		f = new JFrame( "Aggiungi riga lavoro" );
		f.setResizable(false);
		f.setBounds(700, 100, 297, 350);
		f.setVisible(true);
	
		JPanel inserimenti = new JPanel();
		
		JLabel b = new JLabel("Base");
		base = new JTextField();
		base.setColumns(3);
		JLabel a = new JLabel("Altezza");
		altezza = new JTextField();
		altezza.setColumns(3);
		JLabel l = new JLabel("Lunghezza");
		lunghezza = new JTextField();
		lunghezza.setColumns(3);
		JLabel c = new JLabel("Capitello");
		numero = new JTextField();
		numero.setColumns(3);
		JLabel num = new JLabel("Numero");
		capitello = new JComboBox();
		capitello.addItem("Si");
		capitello.addItem("No");
		JLabel t = new JLabel("Tipo Capitello");
		tipo = new JTextField();
		tipo.setColumns(10);
		capitello.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        if(capitello.getSelectedItem() == "No"){
		        	tipo.setEnabled(false);
		        }
		        else{
		        	tipo.setEnabled(true);
		        }
		    }
		});
		JLabel n = new JLabel("Note");
		note = new JEditorPane();
		inserimenti.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("64px"),
				ColumnSpec.decode("127px"),
				ColumnSpec.decode("92px"),},
			new RowSpec[] {
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				RowSpec.decode("13px"),
				RowSpec.decode("109px"),}));
		inserimenti.add(b, "1, 2, left, center");
		inserimenti.add(base, "3, 2, center, center");
		inserimenti.add(a, "1, 4, left, center");
		inserimenti.add(altezza, "3, 4, center, center");
		inserimenti.add(l, "1, 6, left, center");
		inserimenti.add(lunghezza, "3, 6, center, center");
		inserimenti.add(num, "1, 8, left, center");
		inserimenti.add(numero, "3, 8, center, center");
		inserimenti.add(c, "1, 10, left, center");
		inserimenti.add(capitello, "3, 10, center, center");
		inserimenti.add(t, "1, 12, left, center");
		inserimenti.add(tipo, "3, 12, center, center");
		inserimenti.add(n, "1, 14, left, top");
		inserimenti.add(note, "3, 14, center, top");
		JPanel bottoni = new JPanel();
		JButton salva = new JButton("Salva");
		bottoni.add(salva);
		salva.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				Geometria g = GeometriaFactory.createGeometria();
				g.setBase(Float.valueOf(base.getText()));
				g.setAltezza(Float.valueOf(altezza.getText()));
				g.setLunghezza(Float.valueOf(lunghezza.getText()));
				g.save();
				RigaLavoro r = RigaLavoroFactory.createRigaLavoro();//new RigaLavoro();
				r.setGeometria(g);
				if(capitello.getSelectedItem() == "Si"){
					r.setCapitello(true);
					r.setProfiloCapitello(tipo.getText());
				}
				else{
					r.setCapitello(false);
					r.setProfiloCapitello("");
				}
				r.setNumero(Integer.valueOf(numero.getText()));
				r.setNote(note.getText());
				r.save();
				d.getLavori().add(r);
				d.save();
				m.addNewRow(r);
				f.dispose();
			}
		});

			
		f.setLayout(new BorderLayout());
		f.add(inserimenti, BorderLayout.CENTER);
		f.add(bottoni,BorderLayout.SOUTH);
		
	}
	
	

}
