package GUI.FormRDA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import coedil99.controller.GestisciFornitoreHandler;
import coedil99.model.CatalogoFornitore;
import coedil99.model.ProductDescription;
import coedil99.model.ProductDescriptionFactory;
import coedil99.model.ProductDescriptionListCollection;
import coedil99.model.RigaRDA;
import coedil99.model.RigaRDAFactory;

import GUI.RDACenter;
import GUI.Abstract.AFormRDA;
import GUI.Card.CardRDA;
import GUI.Card.CardRDAFactory;
import GUI.Card.CardRigaRDA;
import GUI.Card.CardRigaRDAFactory;
import GUI.Liste.ListaRDA;
import GUI.Plichi.PlicoRDA;

public class CreaFormRDA extends AFormRDA {
	
	private JButton JBAddRiga = new JButton("Aggiungi");
	
	public CreaFormRDA() {
		// TODO Auto-generated constructor stub
		super();
		this.JBAddRiga.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int a = CreaFormRDA.this.getCbFornitore().getSelectedIndex();
				int b = CreaFormRDA.this.getCbEssenza().getSelectedIndex();
				int c = CreaFormRDA.this.getCbGeometria().getSelectedIndex();
				
				//MODIFICARE DOPO CHE SIMONE PUSHA IL GETQUANTITY IN AFORMRDA
				int numero = 1;
				String fornitore	= "";
				String essenza	= "";
				String geometria	= "";
				
				if(a != -1 || b != -1 || c != -1){
					fornitore = CreaFormRDA.this.getCbFornitore().getSelectedItem().toString();
					CatalogoFornitore cf = GestisciFornitoreHandler.getInstance().getFornitoreByName(fornitore);
					essenza = CreaFormRDA.this.getCbEssenza().getSelectedItem().toString();
					geometria = CreaFormRDA.this.getCbGeometria().getSelectedItem().toString();		
					ProductDescription pd = GestisciFornitoreHandler.getInstance().getProductDescription( essenza, geometria, fornitore);
					RigaRDA rrda = RigaRDAFactory.createRigaRDA();
					RDACenter rdac = RDACenter.getInstance();
					rrda.setRDA(rdac.getRDASelezionata());
					rrda.setDescription(pd);
					rrda.setQuantity(numero);
					PlicoRDA prda = PlicoRDA.getInstance();
					CardRigaRDA cardRigaRDA = (CardRigaRDA) CardRigaRDAFactory.getInstance().makeCard(prda.getListaRigheRDA());
					cardRigaRDA.load(rrda);
					ListaRDA lista =  rdac.getLista();
					prda.getListaRigheRDA().load(new ArrayList<Object>(rdac.getRDASelezionata().righeRDA.getCollection()) );
				}else{
					JOptionPane.showMessageDialog(null, "Per creare una riga della nuova RDA, seleziona un fornitore, un'essenza e una geometria", "achtung", JOptionPane.PLAIN_MESSAGE);
				}
				

			}
		});
		this.add(JBAddRiga, "2, 22");
	}

}
