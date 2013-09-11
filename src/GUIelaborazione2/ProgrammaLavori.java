package GUIelaborazione2;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenu;
import javax.swing.KeyStroke;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.ComponentOrientation;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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
		this.riquadrocodici.setPreferredSize(new Dimension(200, 0));
		this.commessaSelezionata = GestisciCommessaHandler.
				getInstance().getCommessaById(this.riquadrocodici.getPrimaCommessa());
		this.riquadroplico = new RiquadroPlico();
		this.riquadroplico.aggiornaClipPanel(this.commessaSelezionata.getDistinta().getODistinta());
		setLayout(new BorderLayout());
		
		this.addMenuBar();
		
		
		JLabel lblNewLabel = new JLabel("Scegli una Commessa");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setMinimumSize(new Dimension(200, 15));
		lblNewLabel.setDoubleBuffered(true);
		lblNewLabel.setPreferredSize(new Dimension(70, 40));
		this.riquadrocodici.setColumnHeaderView(lblNewLabel);
		this.add(this.riquadroplico, BorderLayout.CENTER);
		this.add(this.riquadrocodici, BorderLayout.WEST);
		this.riquadroplico.caricaPrimaCommessa(this.commessaSelezionata);

	}
	
	private void addMenuBar() {
		// TODO Auto-generated method stub
		menuBar = new JMenuBar();

		//Build the first menu.
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		JMenuItem eMenuItem = new JMenuItem("Exit");
      eMenuItem.setToolTipText("Exit application");
      eMenuItem.addActionListener(
      		new ActionListener(){
      			public void actionPerformed(ActionEvent e){
      				System.exit(0);
      			}
      		}
      );
		menu.add(eMenuItem);
		JMenuItem hMenuItem = new JMenuItem("Help");
		menuBar.add(hMenuItem);
		add(this.menuBar, BorderLayout.NORTH);
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
