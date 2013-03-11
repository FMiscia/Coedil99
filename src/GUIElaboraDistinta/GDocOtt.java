package GUIElaboraDistinta;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import ElaboraDistinta.Controller.GestisciCommessaHandler;

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
		public GDocOtt( final int index ) {
			
			final GestisciCommessaHandler gch = GestisciCommessaHandler.getInstance();
			
			f = new JFrame( "Documento Ottimizzazione " + gch.getCommessaByIndex(index).getCodiceInterno() );
			
			f.setResizable(false);
			f.setBounds(100, 100, 600, 350);
			((JComponent) f.getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));
			f.getContentPane().setLayout(new BorderLayout(0, 0));
			

			back = new Button("Indietro");
			back.addMouseListener( new MouseAdapter(){
	    		public void mouseClicked(MouseEvent arg0){
	    			f.dispose();
					GDistinta frameDist = new GDistinta( index );
	    		}
	    		} );
			back = new Button("Indietro");
			back.addMouseListener( new MouseAdapter(){
	    		public void mouseClicked(MouseEvent arg0){
	    			f.dispose();
					GDistinta frameDist = new GDistinta( index );
	    		}
	    		} );
			
			
			
			JTextArea textArea = new JTextArea(5, 20);
			textArea.setEditable(false);
			textArea.setText(gch.getCommessaByIndex(index).getDistinta().getOddo().toString());
			f.add(textArea,BorderLayout.CENTER);
			final JPanel doc = new JPanel();
			doc.add(back);
			f.add(doc,BorderLayout.SOUTH);
			f.setVisible(true);
		}
		
	}
