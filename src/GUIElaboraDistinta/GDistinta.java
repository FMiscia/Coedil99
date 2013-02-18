package GUIElaboraDistinta;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;


public class GDistinta extends JPanel {
	

	private Button addRigaLavoro;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public GDistinta() {
		
		DistintaTable d = new DistintaTable();
        setLayout(new BorderLayout(0,0));
        table = new JTable(d.getRighe(),d.getColonne());
        scrollPane = new JScrollPane(table);
        // Toolkit tk = Toolkit.getDefaultToolkit(); 
        // scrollPane.setBounds(0, 0, (int) tk.getScreenSize().getWidth(), 600);
        addRigaLavoro = new Button("Aggiungi Riga Lavoro");
        // addRigaLavoro.setLocation(20, (int) tk.getScreenSize().getHeight() - 80);
        // addRigaLavoro.setSize(120, 30);
        add(addRigaLavoro,BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.NORTH);

        
        
        
        addRigaLavoro.addMouseListener(new MouseAdapter(){
    		public void mouseClicked(MouseEvent arg0){
    			remove(scrollPane);
    			DistintaTable d = new DistintaTable();
    			d.addRigaLavoro();
    			//System.out.println(d.getRighe());
    	        setLayout(null);
    	        table = new JTable(d.getRighe(),d.getColonne());
    	        scrollPane = new JScrollPane(table);
    	        Toolkit tk = Toolkit.getDefaultToolkit(); 
    	        scrollPane.setBounds(0, 0, (int) tk.getScreenSize().getWidth(), 600);
    			add(scrollPane);
    			scrollPane.validate();
    			scrollPane.repaint();
    	        
    			
    		}
    	});

	}
	
	
}
