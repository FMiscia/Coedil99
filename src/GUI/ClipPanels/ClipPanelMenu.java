package GUI.ClipPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.CoedilFrame;
import GUI.LoginPanel;
import GUI.PanelStart;
import GUI.Abstract.AClipPanel;

/**
 * 
 * @author francesco
 *
 * Implementazione di AClipPanel per il menù in alto nella schermata principale
 */
public class ClipPanelMenu extends AClipPanel {

        /**
         * 
         */
        private static final long serialVersionUID = 1L;
        
        /**
         * Costruttore
         */
        public ClipPanelMenu(){
                super();
                this.fill();
        }
        
        /**
         * Elimina i bottoni del clip panel tranne quelli di 
         * gestione dell'applicazione (help,logout,exit)
         */
        public void changeButtonLogState() {
                this.removeAll();
                this.fill();
                this.validate();
                this.repaint();
        }
        
        

}