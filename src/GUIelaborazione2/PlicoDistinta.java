package GUIelaborazione2;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import GUIelaborazione2.Riquadri.RiquadroDatiDistinta;

public class PlicoDistinta extends Plico{

	
	private static PlicoDistinta instance = null;
	private RiquadroDatiDistinta rd;
	
	private PlicoDistinta(){
		setBorder(null);
		setLayout(null);
		
		rd = new RiquadroDatiDistinta("Lavoro");
		rd.setBounds(40, 20,rd.getWidth(),rd.getHeight());
		setPreferredSize(new Dimension(745,1000));
		setSize(745,950);
		this.add(rd);
		
		rd.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				validate();
				repaint();
			}
		});
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load(Object o) {
		// TODO Auto-generated method stub
		
	}
	
	public static PlicoDistinta getInstance(){
		if(PlicoDistinta.instance == null)
			PlicoDistinta.instance = new PlicoDistinta();
		return PlicoDistinta.instance;
	}

}
