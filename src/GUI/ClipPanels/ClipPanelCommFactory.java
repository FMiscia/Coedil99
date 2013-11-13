package GUI.ClipPanels;

import GUI.Abstract.AClipPanel;

/**
 * 
 * Implementazione Factory di Abstract Factory 
 * @author cicerone
 *
 */
public class ClipPanelCommFactory extends ClipPanelFactory {

        private static ClipPanelCommFactory instance = null;
        
        private ClipPanelCommFactory(){
                
        };
        
        @Override
        public AClipPanel makeClipPanel() {
                // TODO Auto-generated method stub
                return new ClipPanelComm();
        }
        
        public static ClipPanelCommFactory getInstance(){
                if(instance == null)
                        instance = new ClipPanelCommFactory();
                return instance;
        }

}