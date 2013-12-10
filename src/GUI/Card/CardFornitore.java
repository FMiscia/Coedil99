package GUI.Card;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import GUI.ConfigGUI;
import GUI.FornitoriCenter;
import GUI.Abstract.ACard;
import GUI.Liste.ListaFornitori;
import coedil99.model.MCatalogoFornitore;
import javax.swing.border.MatteBorder;
import java.awt.Color;
/**
 * Pannello che mostra le informazioni principali del Catalogo Fornitore
 * 
 * @author Simone
 *
 */
@SuppressWarnings("serial")
public class CardFornitore extends ACard{

	private ListaFornitori riquadro = null;
	private JLabel lblNomeFornitore = null;
	private JLabel lblProductCount = null;
	private int CatalogoID;
	private boolean saved = false;
	
	/**
	 * Costruttore
	 * 
	 * @param lf
	 */
	public CardFornitore(ListaFornitori lf) {
		super(lf);
		this.setRiquadro(lf);
		this.initialize();
	}

	/**
	 * Metodo che carica il contenuto della card
	 * @param o
	 */
	@Override
	public void load(Object o) {
		final MCatalogoFornitore catalogo = (MCatalogoFornitore) o;
		this.lblNomeFornitore.setText(catalogo.getPersistentModel().getName());
		this.lblProductCount.setText(String.valueOf(catalogo.getPersistentModel().productDescription.size()));
		this.CatalogoID = catalogo.getPersistentModel().getID();
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				CardFornitore.this.riquadro.deselectAll();				
				FornitoriCenter contenitore = FornitoriCenter.getInstance();
				contenitore.setFornitoreSelezionato(catalogo);
				contenitore.loadListaProdotti();
				CardFornitore.this.setBackground(ConfigGUI.getColoreSelezionato());
				CardFornitore.this.validate();
				CardFornitore.this.repaint();
			}
		});
		this.validate();
		this.repaint();
	}
	
	/**
	 * Imposta la grafica
	 */
	private void initialize() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(200, 30));
		this.setBackground(ConfigGUI.getColoreDeselezionato());
		this.setBorder(new LineBorder(ConfigGUI.getColoreBordoCard(),2));
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.lblNomeFornitore = new JLabel();
		this.lblNomeFornitore.setBounds(0, 0, 150, 30);
		
		this.lblProductCount = new JLabel();
		this.lblProductCount.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblProductCount.setBounds(150, 0, 50, 30);
		this.lblProductCount.setBorder(new MatteBorder(0, 1, 0, 0, ConfigGUI.getColoreBordoCard()));
		
		this.add(lblNomeFornitore);
		this.add(lblProductCount);
		
	}

	/**
	 * Metodo che ritorna l'id del catalogo fornitore associato alla card
	 * 
	 * @return CatalogoID:int
	 */
	public int getCatalogoFornitoreId() {
		return this.CatalogoID;
	}

	/**
	 * Metodo che ritorna un booleano che indica se la card è stata salvata oppure no
	 * 
	 * @return saved:boolean
	 */
	public boolean isSaved() {
		return this.saved;
	}

	/**
	 * @return the riquadro
	 */
	public ListaFornitori getRiquadro() {
		return riquadro;
	}

	/**
	 * @param riquadro the riquadro to set
	 */
	public void setRiquadro(ListaFornitori riquadro) {
		this.riquadro = riquadro;
	}
	
}
