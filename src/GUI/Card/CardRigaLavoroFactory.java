package GUI.Card;

import GUI.Abstract.ACard;
import GUI.Abstract.ALista;
import GUI.Liste.ListaRigheLavoro;
import GUI.Liste.ListaRigheRDA;
/**
 * 
 * @author francesco
 * 
 * Implementazione Factory di Abstract Factory
 */
public class CardRigaLavoroFactory extends CardFactory {
	
	private static CardRigaLavoroFactory instance = null;
	
	private CardRigaLavoroFactory(){};
	
	@Override
	public ACard makeCard(ALista lista) {
		return new CardRigaLavoro((ListaRigheLavoro)lista);
	}
	
	public static CardRigaLavoroFactory getInstance(){
		if(instance == null)
			instance =  new CardRigaLavoroFactory();
		return instance;
	}

}
