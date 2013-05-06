package GUIelaborazione2;


import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class RiquadroCodici extends JPanel {
	
	private JScrollPane panel;
	
	public RiquadroCodici(){
		setLayout(null);
		panel = new JScrollPane();
		panel.setBounds(0,0,200, 200);
		add(panel);
	}
	
	private void load(){
		int row = 20;
		panel.setSize(panel.getWidth(),row*200);
		for(int i=0; i<row; ++i){
			RiquadroCodiceInterno r = new RiquadroCodiceInterno();
			r.setLocation(0, i*r.getHeight());
			panel.add(r);
		}
	}

}
