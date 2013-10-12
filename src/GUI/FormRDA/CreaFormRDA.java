package GUI.FormRDA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import coedil99.controller.GestisciFornitoreHandler;
import coedil99.model.CatalogoFornitore;
import coedil99.model.ProductDescription;
import coedil99.model.ProductDescriptionFactory;
import coedil99.model.ProductDescriptionListCollection;

import GUI.Abstract.AFormRDA;

public class CreaFormRDA extends AFormRDA {
	
	private JButton JBAddRiga = new JButton("Aggiungi");
	
	public CreaFormRDA() {
		// TODO Auto-generated constructor stub
		super();
		this.JBAddRiga.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String fornitore = CreaFormRDA.this.getCbFornitore().getSelectedItem().toString();
				CatalogoFornitore cf = GestisciFornitoreHandler.getInstance().getFornitoreByName(fornitore);
				String essenza = CreaFormRDA.this.getCbEssenza().getSelectedItem().toString();
				String geometria = CreaFormRDA.this.getCbGeometria().getSelectedItem().toString();
				List l = cf.productDescription.getCollection();
				ProductDescription pd = null;
				for ( int i=0 ; i<l.size() ; i++  ){
					pd = (ProductDescription) l.get(i);
					System.out.println(pd.getEssenza().toString());
					System.out.println(essenza);
					System.out.println(pd.getGeometria().myToString());
					System.out.println(geometria);
					
					if( pd.getEssenza().toString().equalsIgnoreCase(essenza)  && pd.getGeometria().myToString().equalsIgnoreCase(geometria)){
						System.out.println("yo yo yo ");
						//		associare pd.getID(); con rigardadiddio
					}else{
						System.out.println("no no no ");
					}
					System.out.println("--------------------------");
				}
			}
		});
		this.add(JBAddRiga, "2, 22");
	}

}
