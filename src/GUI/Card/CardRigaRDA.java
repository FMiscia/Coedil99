package GUI.Card;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTable;

import org.orm.PersistentException;

import GUI.ProgrammaLavori;
import GUI.Abstract.ACard;
import GUI.FormRDA.ModificaFormRDA;
import GUI.FormRDA.ModificaFormRDAFactory;
import GUI.Liste.ListaRigheRDA;
import GUI.Plichi.PlicoDDO;
import GUI.Plichi.PlicoRDA;
import coedil99.model.RigaRDA;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

public class CardRigaRDA extends ACard {

	JLabel lblElimina;
	JLabel lblEssenza;
	JLabel txtEssenza;
	JLabel lblQuantita;
	JLabel txtQuantita;
	JLabel lblAltezza;
	JLabel txtAltezza;
	JLabel lblLunghezza;
	JLabel txtLunghezza;
	JLabel lblBase;
	JLabel txtLarghezza;
	JLabel lblPezzi;
	JLabel txtPezzi;
	JLabel lblPrezzo;
	JLabel txtPrezzo;
	ListaRigheRDA listaRigheRDA;
	private JLabel lblModifica;

	public CardRigaRDA(ListaRigheRDA lrRDA) {
		// TODO Auto-generated constructor stub
		super(lrRDA);
		this.listaRigheRDA = lrRDA;
		setBounds(new Rectangle(0, 0, 0, 0));
		this.setPreferredSize(new Dimension(300, 200));
		this.setBackground(new Color(204, 204, 204));
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
		
		lblModifica = new JLabel("");
		add(lblModifica, "4, 2");

		lblElimina = new JLabel("");
		add(lblElimina, "6, 2");

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
		
	}


	@Override
	public void load(Object o) {
		// TODO Auto-generated method stub
		final RigaRDA riga = (RigaRDA) o;
		this.txtEssenza.setText(riga.getDescription().getEssenza());
		this.txtQuantita.setText(String.valueOf(riga.getQuantity()));
		this.txtAltezza.setText(String.valueOf(riga.getDescription().getGeometria().getAltezza()));
		this.txtLunghezza.setText(String.valueOf(riga.getDescription().getGeometria().getLunghezza()));
		this.txtLarghezza.setText(String.valueOf(riga.getDescription().getGeometria().getBase()));
		this.txtPezzi.setText(String.valueOf(riga.getDescription().getPezzi_per_pacco()));
		this.txtPrezzo.setText(String.valueOf(riga.getDescription().getPrezzo()));
		this.lblModifica.setIcon(new ImageIcon(CardRigaRDA.class.getResource("/GUI/image/congelata.png")));
		this.lblModifica.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				CardRigaRDA.this.listaRigheRDA.deselectAll();
				CardRigaRDA.this.setBackground(new Color(90, 90, 90));
				ModificaFormRDA form = (ModificaFormRDA) ModificaFormRDAFactory.getInstance().makeFormRDA();
				form.modificaRDA(riga);
				PlicoRDA.getInstance().addFormRDA(form);
			}
		});
		this.lblElimina.setIcon(new ImageIcon(CardRigaRDA.class
				.getResource("/GUI/image/cancella.png")));
		this.lblElimina.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] options = { "Si", "No" };
				int n = JOptionPane
						.showOptionDialog(
								ProgrammaLavori.getInstance(),
								"Sei sicuro di voler eliminare questa riga RDA?\n"
										+ "Nota: questa operazione non è reversibile",
								"Conferma operazione",
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE, null,
								options, options[1]);
				if (n == JOptionPane.YES_OPTION) {
					try {
						riga.deleteAndDissociate();
						CardRigaRDA.this.listaRigheRDA.removeRiquadro(CardRigaRDA.this);
					} catch (PersistentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});			
		
		this.validate();
		this.repaint();

	}


}