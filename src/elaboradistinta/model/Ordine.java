package elaboradistinta.model;

import java.util.Date;

import almonds.ParseException;
import almonds.ParseObject;
import almonds.ParsePointer;
import almonds.ParseQuery;


	public class Ordine extends ParseObject{
		
		public Ordine()
		{
			super(Ordine.class.getName());
			// TODO Auto-generated constructor stub
		}
		
		public String getOrdineGestionale()
		{
			return this.getString("ordineGestionale");
		}
		public void setOrdineGestionale(String ordineGestionale)
		{
			this.put("ordineGestionale", ordineGestionale);
		}
		
		public String getDataInizio()
		{
			return this.getString("dataInizio");
		}
		public void setDataInizio(Date d)
		{
			this.put("dataInizio", d);
		}
		
		public String getDataScadenza()
		{
			return this.getString("dataScadenza");
		}
		public void setDataScadenza(Date d)
		{
			this.put("dataScadenza", d);
		}
		
		public String getDataFine()
		{
			return this.getString("dataFine");
		}
		public void setDataFine(Date d)
		{
			this.put("dataFine", d);
		}
		
		public String getAnno()
		{
			return this.getString("anno");
		}
		public void setAnno(int anno)
		{
			this.put("anno", anno);
		}
		
		public void setClienteId(ParsePointer pointer)
		{
			// TODO Auto-generated method stub
			this.put("clienteId", pointer);
		}
		
		public ParseObject getCliente() {
			ParseQuery q = new ParseQuery("Cliente");
			ParseObject mioCliente= null;
			try {
				mioCliente = q.get(this.getObjectId());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return mioCliente;
		} 

	}

//  Da fare...
	
//	NumeroOrdine
//	OC
//	ClienteID	

