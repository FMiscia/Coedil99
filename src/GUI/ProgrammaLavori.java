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

import GUI.ClipPanels.ClipPanelProgrammaLavori;
import GUI.Plichi.PlicoCommessa;
import GUI.Plichi.PlicoDDO;
import GUI.Plichi.PlicoDistinta;
import GUI.Riquadri.RiquadroCodiciProgrammaLavoro;
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
	private RiquadroCodiciProgrammaLavoro riquadrocodici;
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

		this.riquadrocodici = new RiquadroCodiciProgrammaLavoro();
		this.riquadrocodici.setPreferredSize(new Dimension(200, 0));
		proglavoripanel.add(riquadrocodici, BorderLayout.WEST);

		proglavoripanel.add(this.raccoglitoreplichi, BorderLayout.CENTER);
		this.commessaSelezionata = GestisciCommessaHandler.getInstance()
				.getCommessaById(this.riquadrocodici.getPrimaCommessa());
		this.raccoglitoreplichi.caricaPrimaCommessa(this.commessaSelezionata);

		this.commessaSelezionata = GestisciCommessaHandler.getInstance()
				.getCommessaById(this.riquadrocodici.getPrimaCommessa());

		this.clip = new ClipPanelProgrammaLavori();
		

		proglavoripanel.add(clip, BorderLayout.NORTH);
		this.validate();
		this.repaint();


	}

	public static ProgrammaLavori getInstance() {
		if (ProgrammaLavori.instance == null)
			ProgrammaLavori.instance = new ProgrammaLavori();

		return ProgrammaLavori.instance;
	}

	public RiquadroCodiciProgrammaLavoro getRiquadrocodici() {
		return riquadrocodici;
	}

	public void setRiquadrocodici(RiquadroCodiciProgrammaLavoro riquadrocodici) {
		this.riquadrocodici = riquadrocodici;
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

}
