package GUI.ClipPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.CoedilFrame;
import GUI.PanelStart;
import GUI.Abstract.AClipPanel;

public class ClipPanelRDA extends AClipPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ClipPanelRDA(){
		super();
		
		this.addButton("Menu", "Torna al menu principale", new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CoedilFrame cf = CoedilFrame.getInstance();
				PanelStart pl = new PanelStart(cf);
				pl.setBounds(0, 0, cf.getWidth(), cf.getHeight());
				CoedilFrame.getInstance().montaPanel(pl);
			}
		});

		this.addButton("Nuova RDA", "Crea una nuova RDA", new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("NEW RDA\n");
			}
		});
		this.fill();
	}
	
	

}
