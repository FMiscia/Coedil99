package ElaboraDistinta;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Ordine {

	Cliente cliente;
	List<Commessa> commesse;
	private String ordineGestionale;
	private Calendar dataInizio;
	private Calendar dataFine;
	private Integer anno;
	private Integer id;
	private static int counter = 0;

	public Ordine(Cliente c, String og, Calendar inizio, Calendar fine){
		Ordine.counter = Ordine.counter+ 1;
		this.id = Ordine.counter;
		this.anno = new Integer(2013);
		this.cliente = c;
		this.ordineGestionale = og;
		this.dataInizio = inizio;
		this.dataFine = fine;
		this.commesse = new ArrayList<Commessa>();
	}
	
	public Integer getAnno(){
		return this.anno;
	}
	
	public Integer getId(){
		return this.id;
	}
	
	public void addCommessa( Commessa c ){
		this.commesse.add(c);
	}
	

	public String getOrdineGestionale() {
		return this.ordineGestionale;
	}

	public void setOrdineGestionale(String ordineGestionale) {
		this.ordineGestionale = ordineGestionale;
	}

	public Calendar getDataInizio() {
		return this.dataInizio;
	}

	public void setDataInizio(Calendar dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Calendar getDataFine() {
		return this.dataFine;
	}

	public void setDataFine(Calendar dataFine) {

		this.dataFine = dataFine;
	}
	
	public Cliente getCliente(){
		return this.cliente;
	}

}