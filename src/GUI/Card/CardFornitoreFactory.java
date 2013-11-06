package GUI.Card;

import GUI.Abstract.ACard;
import GUI.Abstract.ALista;
import GUI.Liste.ListaFornitori;

public class CardFornitoreFactory extends CardFactory {

	private static CardFornitoreFactory instance = null;

	private CardFornitoreFactory() {
	};

	@Override
	public ACard makeCard(ALista lista) {
		return new CardFornitore((ListaFornitori) lista);
	}

	public static CardFornitoreFactory getInstance() {
		if (instance == null)
			instance = new CardFornitoreFactory();
		return instance;
	}
}
