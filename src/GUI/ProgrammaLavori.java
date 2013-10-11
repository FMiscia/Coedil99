package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GUI.Abstract.ALista;
import GUI.ClipPanels.ClipPanelProgrammaLavori;
import GUI.ClipPanels.ClipPanelProgrammaLavoriFactory;
import GUI.Liste.ListaCommesse;
import GUI.Liste.ListaCommesseFactory;
import GUI.Plichi.PlicoCommessa;
import GUI.Plichi.PlicoDDO;
import GUI.Plichi.PlicoDistinta;
import coedil99.controller.GestisciCommessaHandler;
import coedil99.model.Commessa;

public class ProgrammaLavori extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	private static ProgrammaLavori instance = null;
	private ALista lista;
	private RaccoglitorePlichi raccoglitoreplichi;
	private JMenuBar menuBar;
	private ClipPanelProgrammaLavori clip;

	private Commessa commessaSelezionata = null;

	private ProgrammaLavori() {
		setMinimumSize(new Dimension(500, 600));
		this.raccoglitoreplichi = RaccoglitorePlichi.getInstance();
		setLayout(new BorderLayout());
		this.addMenuBar();

	}

	private void addMenuBar() {
		// TODO Auto-generated method stub

		JPanel proglavoripanel = new JPanel();
		add(proglavoripanel, BorderLayout.CENTER);
		proglavoripanel.setLayout(new BorderLayout(0, 0));

		this.lista = (ListaCommesse)ListaCommesseFactory.getInstance().makeLista();
		this.lista.setPreferredSize(new Dimension(200, 0));
		proglavoripanel.add(lista, BorderLayout.WEST);

		proglavoripanel.add(this.raccoglitoreplichi, BorderLayout.CENTER);
		this.commessaSelezionata = GestisciCommessaHandler.getInstance()
				.getCommessaById(((ListaCommesse) this.lista).getPrimaCommessa());
		this.raccoglitoreplichi.caricaPrimaCommessa(this.commessaSelezionata);

		this.commessaSelezionata = GestisciCommessaHandler.getInstance()
				.getCommessaById(((ListaCommesse) this.lista).getPrimaCommessa());

		this.clip = (ClipPanelProgrammaLavori) ClipPanelProgrammaLavoriFactory.getInstance().makeClipPanel();
		

		proglavoripanel.add(clip, BorderLayout.NORTH);
		this.validate();
		this.repaint();


	}

	public static ProgrammaLavori getInstance() {
		if (ProgrammaLavori.instance == null)
			ProgrammaLavori.instance = new ProgrammaLavori();

		return ProgrammaLavori.instance;
	}

	public ListaCommesse getRiquadrocodici() {
		return (ListaCommesse) lista;
	}

	public void setRiquadrocodici(ListaCommesse riquadrocodici) {
		this.lista = riquadrocodici;
	}

	public RaccoglitorePlichi getRaccoglitorePlichi() {
		return raccoglitoreplichi;
	}

	public void setraccoglitoreplichi(RaccoglitorePlichi raccoglitoreplichi) {
		this.raccoglitoreplichi = raccoglitoreplichi;
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public Commessa getCommessaSelezionata() {
		return commessaSelezionata;
	}

	public void setCommessaSelezionata(Commessa selectedComm) {
		// TODO Auto-generated method stub
		this.commessaSelezionata = selectedComm;
	}
	public ClipPanelProgrammaLavori getClipPanel() {
		return clip;
	}

}
