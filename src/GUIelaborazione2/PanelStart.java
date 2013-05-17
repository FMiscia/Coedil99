package GUIelaborazione2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import GUIelaboradistinta.GDistinta;

public class PanelStart extends JPanel{
    public PanelStart(CoedilFrame f){
   
    this.initUI();
   
    }
private void initUI(){
   
    this.setLayout( new BorderLayout() );

        JButton plButton = new JButton("Programma Lavori(contenitore)");
        plButton.setToolTipText("Programma Lavori");
        
        

        plButton.addMouseListener( new MouseAdapter(){
        public void mouseClicked(MouseEvent arg0){
        Contenitore p = new Contenitore();
                    CoedilFrame.getInstance().montaPanel( p);
        }
        } );


        
        this.add(plButton, BorderLayout.NORTH);
        
    }
} 