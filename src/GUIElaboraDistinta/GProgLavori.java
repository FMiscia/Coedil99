package GUIElaboraDistinta;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    JComponent panel5;
    
    public GProgLavori() {
        super(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane();

        panel1 = makeTextPanel(1);
        tabbedPane.addTab("Dati Cliente", null, panel1, "Dati Cliente");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        panel2 = makeTextPanel(2);
        tabbedPane.addTab("Dati Aziendali", null, panel2, "Dati Aziendali");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        panel3 = makeTextPanel(3);
        tabbedPane.addTab("Sviluppo Consegna", null, panel3, "Sviluppo Consegna");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        panel4 = makeTextPanel(4);
        tabbedPane.addTab("Produzione", null, panel4, "Produzione");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
        
        panel5 = makeTextPanel(5);
        tabbedPane.addTab("Consegna", null, panel5, "Consegna");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

        add(tabbedPane);
//add(panel1);

      }
    
      protected JComponent makeTextPanel(int a) {

    	  String[] column1 = {"Codice Interno",
                  "Cliente",
                  "Cantiere",
                  "Commessa Cliente"};
    	  String[] column2 = {"Codice Interno",
    			  "O/C",
                  "Anno",
                  "Ordine/Contratto",
                  "Commessa Coedil",
                  "Cod Interno",
                  "Ordine Gestionale",
                  "Data Inizio",
                  "Data Fine",
                  "Orario",
                  "Descrizione",
                  "Partizione",
    	  
                  };
    	  String[] column3 = {"Codice Interno",
                  "Responsabile",
                  "Data Inizio",
                  "Scadenza sviluppo",
                  "Data fine",
                  "Ritardo"};
    	  String[] column4 = {"Codice Interno",
                  "Data Inizio",
                  "Data fine",
                  "Scadenza sviluppo"
                  };
    	  String[] column5 = {"Codice Interno",
                  "Data prima consegna",
                  "Ritardo consegna"};
          JPanel panel1 = new Table(column1,1);
          JPanel panel2 = new Table(column2,2);
          JPanel panel3 = new Table(column3,3);
          JPanel panel4 = new Table(column4,4);
          JPanel panel5 = new Table(column5,5);
          JPanel panel;

          switch (a) {
          case 1:  
              panel = panel1;
                    break;
          case 2:  
              panel = panel2;
              break;
          case 3:  
              panel = panel3;
              break;
          case 4:  
              panel = panel4;
              break;
          case 5:
              panel = panel5;
              break;
          default:         	  		
              panel = panel1;
              break;
      }
    		  
          return panel;
          }


}