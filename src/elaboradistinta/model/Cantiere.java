package elaboradistinta.model;

import almonds.ParseObject;
import almonds.ParsePointer;


public class Cantiere extends ParseObject
{
	
	public Cantiere()
	{
		super(Cantiere.class.getName());
		// TODO Auto-generated constructor stub
	}
	
	public String getIndirizzo()
	{
		return this.getString("indirizzo");
	}

	public void setIndirizzo(String indirizzo)
	{
		this.put("indirizzo", indirizzo);
	}

	public String getNome()
	{
		return this.getString("nome");
	}

	public void setNome(String nome)
	{
		this.put("nome", nome);
	}

	public void setClienteId(ParsePointer pointer)
	{
		// TODO Auto-generated method stub
		this.put("clienteId", pointer);
	}


}