package GUIElaboraDistinta;

import java.awt.BorderLayout;
import java.awt.Button;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import ElaboraDistinta.Controller.GestisciCommessaHandler;

public class GDocOtt {

		/**
		 * 
		 */
		Button save ;
		Button nLine;
		Button ottimizza;
		Button visDdo;
		JFrame f;
		private static final long serialVersionUID = 1L;
		/**
		 * Create the frame.
		 */
		public GDocOtt( final int index ) {
			
			final GestisciCommessaHandler gch = GestisciCommessaHandler.getInstance();
			
			f = new JFrame( "Documento Ottimizzazione " + gch.getCommessaByIndex(index).getCodiceInterno() );
			
			f.setResizable(false);
			f.setBounds(700, 100, 600, 350);
			((JComponent) f.getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));
			f.getContentPane().setLayout(new BorderLayout(0, 0));
			

			
			JTextArea textArea = new JTextArea(5, 20);
			textArea.setEditable(false);
			textArea.setText(gch.getCommessaByIndex(index).getDistinta().getDdo().toString());
			f.add(textArea,BorderLayout.CENTER);
//			final JPanel doc = new JPanel();
//			doc.add(save);
//			doc.add(nLine);
//			doc.add(ottimizza);
//			doc.add(visDdo);
//			f.add(doc,BorderLayout.SOUTH);
			f.setVisible(true);
		}
		
	}
