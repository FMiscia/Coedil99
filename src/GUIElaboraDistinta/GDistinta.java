package GUIElaboraDistinta;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GDistinta extends JFrame {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the frame.
	 */
	public GDistinta() {
		super( "Distinta" );
		setResizable(false);
		setBounds(100, 100, 600, 350);
		((JComponent) this.getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		String[] cl6 = {  "a","b","c","d","e","f","g"};
		final GPanelDistinta t = new GPanelDistinta( makeVector(cl6) );
		this.add(t,BorderLayout.CENTER);
		JPanel doc = new JPanel();
		Button save = new Button("Save");
		Button nLine = new Button("New line");
		nLine.addMouseListener(new MouseAdapter(){
    		public void mouseClicked(MouseEvent arg0){
				t.addRow( t);
				repaint();
    		}
    		});
		doc.add(nLine);
		doc.add(save);
		add(doc,BorderLayout.SOUTH);
		setVisible(true);
	}
	protected Vector<String> makeVector( String[] cl) {

		Vector<String> column  = new Vector<String>(); 
	    for(int i=0; i<cl.length; ++i)
	    	column.add(cl[i]);
	    
	    return column;

	}
}
