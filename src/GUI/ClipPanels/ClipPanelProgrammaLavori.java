package GUI.ClipPanels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import GUI.CoedilFrame;
import GUI.PanelStart;
import GUI.ProgrammaLavori;
import GUI.RaccoglitorePlichi;
import GUI.Abstract.AClipPanel;
import GUI.Plichi.PlicoCommessa;
import GUI.Plichi.PlicoDDO;
import GUI.Plichi.PlicoDistinta;

public class ClipPanelProgrammaLavori extends AClipPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ClipPanelProgrammaLavori(){
		super();
		this.addButton("Menu", "Torna al Menu Principale",
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						CoedilFrame cf = CoedilFrame.getInstance();
						PanelStart pl = new PanelStart(cf);
						pl.setBounds(0, 0, cf.getWidth(), cf.getHeight());
						CoedilFrame.getInstance().montaPanel(pl);
					}
				});
		this.addButton("Commessa", "Vai alla Commessa",
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ProgrammaLavori.getInstance().getRaccoglitorePlichi().changePlico(PlicoCommessa.getInstance());
						ClipPanelProgrammaLavori.this.focusOut();
						JButton b = (JButton) e.getSource();
						b.setBackground(new Color(180,180,180));
						RaccoglitorePlichi.getInstance().getScrollPaneWrapper().validate();
						RaccoglitorePlichi.getInstance().getScrollPaneWrapper().repaint();
					}
					
					
				});
		this.addButton("Distinta", "Vai alla distinta",
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ProgrammaLavori.getInstance().getRaccoglitorePlichi().changePlico(PlicoDistinta.getInstance());
						ClipPanelProgrammaLavori.this.focusOut();
						JButton b = (JButton) e.getSource();
						b.setBackground(new Color(180,180,180));
						RaccoglitorePlichi.getInstance().getScrollPaneWrapper().validate();
						RaccoglitorePlichi.getInstance().getScrollPaneWrapper().repaint();
					}
				});
		this.addButton("DDO", "Vai al DDO", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (ProgrammaLavori.getInstance().getCommessaSelezionata().getOdistinta().hasDdo()){
					ClipPanelProgrammaLavori.this.focusOut();
					JButton b = (JButton) e.getSource();
					b.setBackground(new Color(180,180,180));
					ProgrammaLavori.getInstance().getRaccoglitorePlichi().changePlico(PlicoDDO.getInstance());
				}
				else {
					//JOptionPane confermaOtt = new JOptionPane();
					Object[] options = { "Si", "No" };
					int n = JOptionPane
							.showOptionDialog(
									ProgrammaLavori.getInstance(),
									"Il DDO non esiste.\nVuoi elaborare l'ottimizzazione?\n"
											+ "Nota: questa operazione non è reversibile",
									"Conferma operazione",
									JOptionPane.YES_NO_CANCEL_OPTION,
									JOptionPane.QUESTION_MESSAGE, null,
									options, options[1]);
					if (n == JOptionPane.YES_OPTION) {
						ProgrammaLavori.getInstance().getCommessaSelezionata()
								.getDistinta().creaDDO();
						ProgrammaLavori.getInstance().getRaccoglitorePlichi().changePlico(PlicoDDO.getInstance());
					}
				}
				RaccoglitorePlichi.getInstance().getScrollPaneWrapper().validate();
				RaccoglitorePlichi.getInstance().getScrollPaneWrapper().repaint();
			}
		});
		this.addButton("LDR", "Vai alla LDR", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		this.fill();
		this.resetInitialState();
	}
	
	public void resetInitialState(){
		this.focusOut();
		this.getButtons().get(1).setBackground(new Color(180,180,180));
	}

}
