package GUIelaborazione2;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import elaboradistinta.controller.GestisciClienteHandler;
import elaboradistinta.controller.GestisciCommessaHandler;
import elaboradistinta.model.Cliente;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class RiquadroCodici extends JScrollPane {
	
	private JPanel panel;

	
	public RiquadroCodici(){
		panel = new JPanel(null);
		this.setViewportView(panel);
		panel.setLayout(new WrapLayout());
		this.load(GestisciClienteHandler.getInstance().getClienti());
	}
	
	public void load(ArrayList<Cliente> cliente){
		int row = GestisciCommessaHandler.getInstance().getNumOfCommesse();
		panel.setPreferredSize(new Dimension(150,row*70));
		for(int k=0; k<cliente.size(); ++k){
			for(int j=0; j<cliente.get(k).ordini.size(); ++j){
				for(int i=0; i<cliente.get(k).ordini.get(j).commesse.size(); ++i){
					final RiquadroCodiceInterno r = new RiquadroCodiceInterno();
					r.load(cliente.get(k), cliente.get(k).ordini.get(j), cliente.get(k).ordini.get(j).commesse.get(i));
					r.addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mousePressed(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseExited(MouseEvent e) {
							r.setBackground(new Color(30, 144, 255));
							
						}
						
						@Override
						public void mouseEntered(MouseEvent e) {
							r.setBackground(new Color(30, 44, 255));
							
						}
						
						@Override
						public void mouseClicked(MouseEvent e) {
							PlicoCommessa plico_commessa = PlicoCommessa.getInstance();
							// plico_commessa.load();
							Contenitore.getInstance().getRiquadroplico().getPaperPanel().removeAll();
							Contenitore.getInstance().getRiquadroplico().getPaperPanel().add(plico_commessa);
							Contenitore.getInstance().getRiquadroplico().aggiornaAltezze();
							Contenitore.getInstance().getRiquadroplico().getPlico().validate();
							Contenitore.getInstance().getRiquadroplico().getPlico().repaint();
							
						}
					});
					panel.add(r);
				}
			}
		}
		this.setPreferredSize(new Dimension(154,panel.getHeight()));
		this.getVerticalScrollBar().setPreferredSize (new Dimension(0,0));
		
	}

}