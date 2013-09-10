package GUIelaborazione2;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.ComponentOrientation;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

import elaboradistinta.controller.GestisciCommessaHandler;
import elaboradistinta.model.Commessa;

public class ProgrammaLavori extends JPanel {

	/**
	 * Create the panel.
	 */
	private static ProgrammaLavori instance = null;
	private RiquadroCodici riquadrocodici;
	private RiquadroPlico riquadroplico;
	private JMenuBar menuBar;
	private Commessa commessaSelezionata = null;
	
	private ProgrammaLavori() {
		setMinimumSize(new Dimension(500, 600));
		
		this.riquadrocodici = new RiquadroCodici();
		this.riquadrocodici.setMinimumSize(new Dimension(0, 0));
		this.riquadrocodici.setPreferredSize(new Dimension(200, 0));
		this.commessaSelezionata = GestisciCommessaHandler.
				getInstance().getCommessaById(this.riquadrocodici.getPrimaCommessa());
		this.riquadroplico = new RiquadroPlico();
		this.riquadroplico.aggiornaClipPanel(this.commessaSelezionata.getDistinta().getODistinta());
		setLayout(new BorderLayout(0, 0));
		
		this.menuBar = new JMenuBar();
		FlowLayout fl_menuBar = new FlowLayout();
		fl_menuBar.setAlignment(FlowLayout.LEFT);
		this.menuBar.setLayout(fl_menuBar);
		add(this.menuBar, BorderLayout.NORTH);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("File");
		mntmNewMenuItem.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.menuBar.add(mntmNewMenuItem);
		mntmNewMenuItem.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		JMenuItem mntmModifica = new JMenuItem("Modifica");
		mntmModifica.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.menuBar.add(mntmModifica);
		mntmModifica.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		JMenuItem mntmVisualizza = new JMenuItem("Visualizza");
		mntmVisualizza.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.menuBar.add(mntmVisualizza);
		mntmVisualizza.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mntmHelp.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.menuBar.add(mntmHelp);
		mntmHelp.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		add(this.riquadrocodici, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("Scegli una Commessa");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setMinimumSize(new Dimension(200, 15));
		lblNewLabel.setDoubleBuffered(true);
		lblNewLabel.setPreferredSize(new Dimension(70, 40));
		this.riquadrocodici.setColumnHeaderView(lblNewLabel);
		add(this.riquadroplico);
		this.riquadroplico.caricaPrimaCommessa(this.commessaSelezionata);

	}
	
	public static ProgrammaLavori getInstance(){
		if(ProgrammaLavori.instance == null)
			ProgrammaLavori.instance = new ProgrammaLavori();
		
		return ProgrammaLavori.instance;
	}

	public RiquadroCodici getRiquadrocodici() {
		return riquadrocodici;
	}

	public void setRiquadrocodici(RiquadroCodici riquadrocodici) {
		this.riquadrocodici = riquadrocodici;
	}

	public RiquadroPlico getRiquadroplico() {
		return riquadroplico;
	}

	public void setRiquadroplico(RiquadroPlico riquadroplico) {
		this.riquadroplico = riquadroplico;
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
