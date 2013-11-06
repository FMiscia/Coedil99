package coedil99.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.orm.PersistentException;

import coedil99.model.MCantiere;
import coedil99.persistentmodel.Cantiere;
import coedil99.persistentmodel.CantiereFactory;

public class GestisciCantiereHandler {
	private ArrayList<MCantiere> cantieri = null;
	private static GestisciCantiereHandler instance;
	
	
	/**
	 * Costruttore
	 * 
	 * Carica la lista dei clienti
	 */
	private GestisciCantiereHandler() {
		this.cantieri = new ArrayList<MCantiere>();
		try {
			ArrayList<Cantiere> persistent_cantieri = new ArrayList<Cantiere>(Arrays.asList(CantiereFactory.listCantiereByQuery(null, "ID")));
			for(Cantiere c: persistent_cantieri){
				this.cantieri.add(new MCantiere(c.getID()));
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Aggiunge un Ordine effettuato da un cliente
	 * @param c:Cliente
	 */
	public void addCantiere(MCantiere c) {
		this.cantieri.add(c);
	}

	/**
	 * Fornisce i clienti
	 * @return clienti:ArrayList<Cliente>
	 */
	public ArrayList<MCantiere> getCantieri(){
		return this.cantieri;
	}
	
	/**
	 * 
	 * @param id
	 * @return clienteID:int
	 */
	public MCantiere getCantiereById(int id){
		return new MCantiere(id);
	}
	
	/**
	 * Fornisce un cantiere dal nome
	 */
	@SuppressWarnings("null")
	public MCantiere getCantiereByName(String name){
		MCantiere result = null;
		for(MCantiere temp : this.cantieri)
			if(result.getPersistentModel().getNome().equals(name)){
				result = temp;
				break;
			}
		return result;
	}
	
	/**
	 * Singleton
	 * @return instance:GestisciClienteHandler
	 */
	public static GestisciCantiereHandler getInstance() {
		if (GestisciCantiereHandler.instance == null) {
			GestisciCantiereHandler.instance = new GestisciCantiereHandler();
		}

		return GestisciCantiereHandler.instance;
	}
}
