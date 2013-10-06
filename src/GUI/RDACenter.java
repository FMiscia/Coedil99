package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RDACenter extends JPanel {
	
	private static RDACenter instance = null;
	private RiquadroCodici riquadrocodici;
	private ClipPanelRDA clipPanel = new ClipPanelRDA();	
	public RDACenter(){
		this.setLayout(new BorderLayout());
		
		clipPanel.addButton("Menu", "Torna al menu principale", new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CoedilFrame cf = CoedilFrame.getInstance();
				PanelStart pl = new PanelStart(cf);
				pl.setBounds(0, 0, cf.getWidth(), cf.getHeight());
				CoedilFrame.getInstance().montaPanel(pl);
			}
		});

		clipPanel.addButton("Nuova RDA", "Crea una nuova RDA", new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("NEW RDA\n");
			}
		});
		clipPanel.fill();
		
		this.add(clipPanel, BorderLayout.NORTH);
		this.riquadrocodici = new RiquadroCodiciProgrammaLavoro();
		this.riquadrocodici.setPreferredSize(new Dimension(200, 0));
		this.add(this.riquadrocodici, BorderLayout.WEST);
		
	}
	
	//Singleton
	public static RDACenter getInstance(){
		if(RDACenter.instance == null)
			RDACenter.instance = new RDACenter();
		return RDACenter.instance;
	}
}
