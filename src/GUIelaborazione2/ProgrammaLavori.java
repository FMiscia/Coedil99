package GUIelaborazione2;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import elaboradistinta.controller.GestisciCommessaHandler;
import elaboradistinta.model.Commessa;

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
	private RiquadroPlico riquadroplico;
	private JMenuBar menuBar;
	private ClipPanelProgrammaLavori clip;
	private Commessa commessaSelezionata = null;

	private ProgrammaLavori() {
		setMinimumSize(new Dimension(500, 600));
		this.riquadroplico = RiquadroPlico.getInstance();
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

		proglavoripanel.add(this.riquadroplico, BorderLayout.CENTER);
		this.commessaSelezionata = GestisciCommessaHandler.getInstance()
				.getCommessaById(this.riquadrocodici.getPrimaCommessa());
		this.riquadroplico.caricaPrimaCommessa(this.commessaSelezionata);

		this.commessaSelezionata = GestisciCommessaHandler.getInstance()
				.getCommessaById(this.riquadrocodici.getPrimaCommessa());

		this.clip = new ClipPanelProgrammaLavori();
		this.clip.addButton("Menu Principale", "Torna al Menu Principale",
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						CoedilFrame cf = CoedilFrame.getInstance();
						PanelStart pl = new PanelStart(cf);
						pl.setBounds(0, 0, cf.getWidth(), cf.getHeight());
						CoedilFrame.getInstance().montaPanel(pl);
					}
				});
		this.clip.addButton("Commessa", "Vai alla Commessa",
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						riquadroplico.changePlico(PlicoCommessa.getInstance());
						RiquadroPlico.getInstance().getScrollPaneWrapper().validate();
						RiquadroPlico.getInstance().getScrollPaneWrapper().repaint();
					}
				});
		this.clip.addButton("Distinta", "Vai alla distinta",
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						riquadroplico.changePlico(PlicoDistinta.getInstance());
						System.out.println(PlicoDistinta.getInstance().getRiquadri().size()+"\n");
						PlicoDistinta.getInstance().getRiquadri().clear();
						System.out.println(PlicoDistinta.getInstance().getRiquadri().size()+"\n");
						RiquadroPlico.getInstance().getScrollPaneWrapper().validate();
						RiquadroPlico.getInstance().getScrollPaneWrapper().repaint();
					}
				});
		this.clip.addButton("DDO", "Vai al DDO", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (commessaSelezionata.getODistinta().hasDdo())
					riquadroplico.changePlico(PlicoDDO.getInstance());
				else {
					//JOptionPane confermaOtt = new JOptionPane();
					Object[] options = { "Si", "No" };
					int n = JOptionPane
							.showOptionDialog(
									ProgrammaLavori.this,
									"Il DDO non esiste.\nVuoi elaborare l'ottimizzazione?\n"
											+ "Nota: questa operazione non è reversibile",
									"Conferma operazione",
									JOptionPane.YES_NO_CANCEL_OPTION,
									JOptionPane.QUESTION_MESSAGE, null,
									options, options[1]);
					if (n == JOptionPane.YES_OPTION) {
						ProgrammaLavori.getInstance().getCommessaSelezionata()
								.getDistinta().creaDDO();
						riquadroplico.changePlico(PlicoDDO.getInstance());
					}
				}
				RiquadroPlico.getInstance().getScrollPaneWrapper().validate();
				RiquadroPlico.getInstance().getScrollPaneWrapper().repaint();
			}
		});
		this.clip.addButton("LDR", "Vai alla LDR", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

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
