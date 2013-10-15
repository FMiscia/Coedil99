package GUI.Card;

import GUI.Abstract.ACard;
import GUI.Abstract.ALista;
import GUI.Liste.ListaRDA;


public class CardRDAFactory extends CardFactory {

	private static CardRDAFactory instance = null;
	
	private CardRDAFactory(){};
	
	@Override
	public ACard makeCard(ALista lista) {
		// TODO Auto-generated method stub
		return new CardRDA((ListaRDA) lista);
	}
	
	public static CardRDAFactory getInstance(){
		if(instance == null)
			instance = new CardRDAFactory();
		return instance;
	}

}
