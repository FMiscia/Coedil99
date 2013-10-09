package GUI.Plichi;

import java.awt.BorderLayout;
import javax.swing.JButton;

import GUI.Abstract.APlico;

public class PlicoRDA extends APlico {

	private static PlicoRDA instance = null;

	private PlicoRDA() {
		setLayout(new BorderLayout());
		this.validate();
		this.repaint();
	}


	public static PlicoRDA getInstance() {
		if (PlicoRDA.instance == null)
			PlicoRDA.instance = new PlicoRDA();
		return PlicoRDA.instance;
	}


	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void load(int id) {
		// TODO Auto-generated method stub
		
	}


}
