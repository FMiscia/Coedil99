package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import GUI.Abstract.ARiquadroCodici;
import GUI.ClipPanels.ClipPanelRDA;
import GUI.Plichi.PlicoRDA;
import GUI.Riquadri.RiquadroCodiciRDA;

public class RDACenter extends JPanel {
	
	private static RDACenter instance = null;

	private ARiquadroCodici riquadrocodici;
	private ClipPanelRDA clipPanel = new ClipPanelRDA();	
	private PlicoRDA plicoRDA = PlicoRDA.getInstance();
	public RDACenter(){
		this.setLayout(new BorderLayout());
		
		this.add(clipPanel, BorderLayout.NORTH);
		this.riquadrocodici = new RiquadroCodiciRDA();
		this.riquadrocodici.setPreferredSize(new Dimension(200, 0));
		this.add(this.riquadrocodici, BorderLayout.WEST);
		
		
		this.add(this.plicoRDA, BorderLayout.CENTER);
	}
	
	//Singleton
	public static RDACenter getInstance(){
		if(RDACenter.instance == null)
			RDACenter.instance = new RDACenter();
		return RDACenter.instance;
	}
}
