package GUIElaboraDistinta;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import ElaboraDistinta.StartUp;
import ElaboraDistinta.Controller.GestisciCommessaHandler;
import ElaboraDistinta.Model.Distinta;
import ElaboraDistinta.Model.Item;

public class GDistinta {

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
	public GDistinta( final int index ) {
		f = new JFrame( "Distinta" );
		
		final StartUp s = StartUp.getInstance();
		final GestisciCommessaHandler gch = GestisciCommessaHandler.getInstance();
		
		f.setResizable(false);
		f.setBounds(100, 100, 600, 350);
		((JComponent) f.getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));
		f.getContentPane().setLayout(new BorderLayout(0, 0));
		String[] cl6 = {  "Base","Altezza","Lunghezza","Numero","Capitello","TipoCap","Note" };
		final GPanelDistinta t = new GPanelDistinta( makeVector(cl6), index );
		f.add(t,BorderLayout.CENTER);
		final JPanel doc = new JPanel();
		save = new Button("Save");
		save.addMouseListener(new MouseAdapter(){
    		public void mouseClicked(MouseEvent arg0){
    			Distinta d = new Distinta();
				for ( int i = 0 ; i<t.getTable().getRowCount(); i++ ){
					
				d.addRigaLavoro( t.getRow(i) ); 
				}
				gch.associaDistinta(d, gch.getCommessaByIndex(index).getId());
    			ottimizza.setVisible(true);
    			doc.validate();
    			doc.repaint();
    		}
    		});
		nLine = new Button("New line");
		nLine.addMouseListener(new MouseAdapter(){
    		public void mouseClicked(MouseEvent arg0){
				t.addRow( t);
				f.repaint();
    		}
    		});
		this.visDdo = new Button("Visualizza DDO");
		this.visDdo.addMouseListener(new MouseAdapter(){
    		public void mouseClicked(MouseEvent arg0){
    			String s = "";
    			java.util.Iterator<Item> it = gch.getCommessaByIndex(index).getDistinta().getDdo().getItems().iterator();
    			while(it.hasNext()){
    				s = s + it.next().getDescrizione();
    			}
    			//JOptionPane.showMessageDialog(null, s );
    			
    			JTextArea textArea = new JTextArea(5, 20);
    			JScrollPane scrollPane = new JScrollPane(textArea); 
    			textArea.setEditable(false);
    			textArea.setText(s);
    			f.remove(t);
    			f.add( textArea ,BorderLayout.CENTER);
    			f.validate();
    			f.repaint();
    		}
    		});
		if ( gch.getCommessaByIndex(index).getDistinta() == null || 
				( gch.getCommessaByIndex(index).getDistinta() != null && 
						!gch.getCommessaByIndex(index).getDistinta().hasDdo() ) )
			this.visDdo.setVisible(false);
		
		this.ottimizza = new Button("Ottimizza");
		if ( gch.getCommessaByIndex(index).getDistinta() == null )
			this.ottimizza.setVisible(false);
		this.ottimizza.addMouseListener(new MouseAdapter(){
    		public void mouseClicked(MouseEvent arg0){
    			gch.getCommessaByIndex(index).getDistinta().creaDDO();
    			visDdo.setVisible(true);
    			doc.validate();
    			doc.repaint();
    		}
    		});
		
		doc.add(save);
		doc.add(nLine);
		doc.add(ottimizza);
		doc.add(visDdo);


		f.add(doc,BorderLayout.SOUTH);
		f.setVisible(true);
	}
	protected Vector<String> makeVector( String[] cl) {

		Vector<String> column  = new Vector<String>(); 
	    for(int i=0; i<cl.length; ++i)
	    	column.add(cl[i]);
	    
	    return column;

	}
}
