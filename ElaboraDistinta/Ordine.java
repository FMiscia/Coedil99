package ElaboraDistinta;

public class Ordine {

	Cliente cliente;
	Commessa[] commessa;
	private String ordineGestionale;
	private Date dataInizio;
	private Date dataFine;

	public String getOrdineGestionale() {
		return this.ordineGestionale;
	}

	public void setOrdineGestionale(String ordineGestionale) {
		this.ordineGestionale = ordineGestionale;
	}

	public Date getDataInizio() {
		return this.dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return this.dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

}