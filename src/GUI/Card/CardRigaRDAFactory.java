package GUI.Card;

import GUI.Abstract.ACard;
import GUI.Abstract.ALista;
import GUI.Liste.ListaRigheRDA;

public class CardRigaRDAFactory extends CardFactory {
	
	private static CardRigaRDAFactory instance = null;
	
	private CardRigaRDAFactory(){};
	
	@Override
	public ACard makeCard(ALista lista) {
		return new CardRigaRDA((ListaRigheRDA)lista);
	}
	
	public static CardRigaRDAFactory getInstance(){
		if(instance == null)
			instance =  new CardRigaRDAFactory();
		return instance;
	}

}
