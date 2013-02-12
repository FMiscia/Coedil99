package GUIElaboraDistinta;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import ElaboraDistinta.Ordine;

import java.awt.FlowLayout;

public class GProgLavori extends JPanel {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComponent panel1;
    JComponent panel2;
    JComponent panel3;
    JComponent panel4;
    
    public GProgLavori() {
        super(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane();

        panel1 = makeList();
        tabbedPane.addTab("Tab 1", null, panel1, "Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        panel2 = makeTextPanel("Panel #2");
        tabbedPane.addTab("Tab 2", null, panel2, "Does twice as much nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        panel3 = makeTextPanel("Panel #3");
        tabbedPane.addTab("Tab 3", null, panel3, "Still does nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        panel4 = makeTextPanel("Panel #4 ");
        tabbedPane.addTab("Tab 4", null, panel4, "Does nothing at all");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

        add(tabbedPane);


      }
    
      protected JComponent makeTextPanel(String text) {
            JPanel panel = new JPanel(false);
            OrdiniPLTableModel model = new OrdiniPLTableModel();
            Calendar inizio = Calendar.getInstance();
    		Calendar fine = Calendar.getInstance();
    		fine.add(Calendar.DAY_OF_MONTH, 1);
    		Ordine o = new Ordine( null, "pippo", inizio , fine );
            model.addOrdine(o);
            panel.setLayout(null);
            JTable table = new JTable(model);
            table.setColumnSelectionAllowed(true);
            table.setBounds(109, 31, 225, 43);
            table.setFillsViewportHeight(true);


            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setSize(445, 272);
            scrollPane.setLocation(0, 0);
            panel.add(scrollPane);
            return panel;
          }
      
      protected JComponent makeList() {
            JPanel panel = new JPanel(false);
            
            Vector v = new Vector();
            for ( int i=0 ; i<200; i++ ){
                v.add(""+i);
            }
            JList list = new JList( v ); //data has type Object[]

            list.setLayoutOrientation(JList.VERTICAL);
            list.setVisibleRowCount(-1);

            JScrollPane listScroller = new JScrollPane(list);
            panel.setLayout(new GridLayout(1, 1));
            panel.add(listScroller);
            return panel;
          }
    

}