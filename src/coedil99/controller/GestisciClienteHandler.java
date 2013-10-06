package coedil99.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.orm.PersistentException;

import coedil99.model.Cliente;
import coedil99.model.ClienteFactory;

public class GestisciClienteHandler {
	
	private int id;
	private ArrayList<Cliente> clienti = null;
	private static GestisciClienteHandler instance;
	
	private GestisciClienteHandler() {
		try {
			this.clienti = new ArrayList<Cliente>(Arrays.asList(ClienteFactory.listClienteByQuery(null, "ID")));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addOrdine(Cliente c) {
		this.clienti.add(c);
	}

	public ArrayList<Cliente> getClienti(){
		return this.clienti;
	}
	
	public Cliente getClienteById(int id){
		try {
			return ClienteFactory.getClienteByORMID(id);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static GestisciClienteHandler getInstance() {
		if (GestisciClienteHandler.instance == null) {
			GestisciClienteHandler.instance = new GestisciClienteHandler();
		}

		return GestisciClienteHandler.instance;
	}

}

