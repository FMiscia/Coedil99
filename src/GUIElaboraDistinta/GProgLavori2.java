package GUIElaboraDistinta;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.Calendar;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JPanel;

import javax.swing.JTabbedPane;

import ElaboraDistinta.Commessa;
import ElaboraDistinta.StartUp;





public class GProgLavori2 extends JPanel {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComponent panel1;
    JComponent panel2;
    JComponent panel3;
    JComponent panel4;
    JComponent panel5;
    
    public GProgLavori2() {
        super(new GridLayout(1, 1));
        StartUp s = StartUp.getInstance();
        JTabbedPane tabbedPane = new JTabbedPane();

        panel1 = makeTextPanel();
        tabbedPane.addTab("Dati Cliente", null, panel1, "Dati Cliente");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        panel2 = makeTextPanel();
        tabbedPane.addTab("Dati Aziendali", null, panel2, "Dati Aziendali");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        panel3 = makeTextPanel();
        tabbedPane.addTab("Sviluppo Consegna", null, panel3, "Sviluppo Consegna");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        panel4 = makeTextPanel();
        tabbedPane.addTab("Produzione", null, panel4, "Produzione");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
        
        panel5 = makeTextPanel();
        tabbedPane.addTab("Consegna", null, panel5, "Consegna");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

        add(tabbedPane);


      }
    
      protected JComponent makeTextPanel() {

    	  ProgrammaLavoriTableModel model = new ProgrammaLavoriTableModel();
    	  model.addCommessa(null);
    	  JTable t = new JTable(model);
    	  t.setBounds(0, 0, 331, 32);
    	  t.setFillsViewportHeight(true);
    	  t.setPreferredScrollableViewportSize(new Dimension(500, 70));
    	  
          JPanel p = new JPanel();
          p.setLayout(new BorderLayout());
          p.add(t.getTableHeader(), BorderLayout.NORTH);
          p.add(t, BorderLayout.CENTER);
          p.add(t);
          return p;
          }


}