package GUIelaboradistinta;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import coedil99.model.Distinta;
import coedil99.operation.ODocumentoOttimizzazione;

public class GDocOtt {

	/**
	 * 
	 */
	Button back ;
	JFrame f;
	private static final long serialVersionUID = 1L;
	/**
	 * Create the frame.
	 */
	public GDocOtt( final Distinta d,final String codice ) {
		
		
		f = new JFrame( "Documento Ottimizzazione " + codice );
		
		f.setResizable(false);
		f.setBounds(100, 100, 600, 350);
		((JComponent) f.getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));
		f.getContentPane().setLayout(new BorderLayout(0, 0));
		
		back = new Button("Indietro");
		back.addMouseListener( new MouseAdapter(){
    		public void mouseClicked(MouseEvent arg0){
    			f.dispose();
				new GDistinta( d, codice );
    		}
    		} );
			
		JTextArea textArea = new JTextArea(5, 20);
		textArea.setEditable(false);
		ODocumentoOttimizzazione ott = new ODocumentoOttimizzazione(d.getDdo());
		textArea.setText(ott.stampaDDO());
		f.add(textArea,BorderLayout.CENTER);
		final JPanel doc = new JPanel();
		doc.add(back);
		f.add(doc,BorderLayout.SOUTH);
		f.setVisible(true);
	}

	/**
	 * Create the frame.
	 * @param index
	 * @return 
	 */
	public GDocOtt(final int index) {
		throw new UnsupportedOperationException();
	}
	
}