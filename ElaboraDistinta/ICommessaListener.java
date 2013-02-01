package ElaboraDistinta;

public interface ICommessaListener {

	Commessa getCommessa();

	/**
	 * 
	 * @param commessa
	 * @param value
	 * @return 
	 */
	abstract void onPropertyEvent(Commessa commessa, string value);

}