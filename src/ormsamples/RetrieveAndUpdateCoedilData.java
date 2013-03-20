/**
 * Licensee: DuKe TeAm
 * License Type: Purchased
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateCoedilData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = elaboradistinta.model.CoedilPersistentManager.instance().getSession().beginTransaction();
		try {
			elaboradistinta.model.Cantiere elaboraDistintaModelCantiere = elaboradistinta.model.Cantiere.loadCantiereByQuery(null, null);
			// Update the properties of the persistent object
			elaboraDistintaModelCantiere.save();
			elaboradistinta.model.Commessa elaboraDistintaModelCommessa = elaboradistinta.model.Commessa.loadCommessaByQuery(null, null);
			// Update the properties of the persistent object
			elaboraDistintaModelCommessa.save();
			elaboradistinta.model.Cliente elaboraDistintaModelCliente = elaboradistinta.model.Cliente.loadClienteByQuery(null, null);
			// Update the properties of the persistent object
			elaboraDistintaModelCliente.save();
			elaboradistinta.model.Distinta elaboraDistintaModelDistinta = elaboradistinta.model.Distinta.loadDistintaByQuery(null, null);
			// Update the properties of the persistent object
			elaboraDistintaModelDistinta.save();
			elaboradistinta.model.DocumentoOttimizzazione elaboraDistintaModelDocumentoOttimizzazione = elaboradistinta.model.DocumentoOttimizzazione.loadDocumentoOttimizzazioneByQuery(null, null);
			// Update the properties of the persistent object
			elaboraDistintaModelDocumentoOttimizzazione.save();
			elaboradistinta.model.ListaRintracciabilita elaboraDistintaModelListaRintracciabilita = elaboradistinta.model.ListaRintracciabilita.loadListaRintracciabilitaByQuery(null, null);
			// Update the properties of the persistent object
			elaboraDistintaModelListaRintracciabilita.save();
			elaboradistinta.model.History elaboraDistintaModelHistory = elaboradistinta.model.History.loadHistoryByQuery(null, null);
			// Update the properties of the persistent object
			elaboraDistintaModelHistory.save();
			elaboradistinta.model.Geometria elaboraDistintaModelGeometria = elaboradistinta.model.Geometria.loadGeometriaByQuery(null, null);
			// Update the properties of the persistent object
			elaboraDistintaModelGeometria.save();
			elaboradistinta.model.Item elaboraDistintaModelItem = elaboradistinta.model.Item.loadItemByQuery(null, null);
			// Update the properties of the persistent object
			elaboraDistintaModelItem.save();
			elaboradistinta.model.Ordine elaboraDistintaModelOrdine = elaboradistinta.model.Ordine.loadOrdineByQuery(null, null);
			// Update the properties of the persistent object
			elaboraDistintaModelOrdine.save();
			elaboradistinta.model.RigaLavoro elaboraDistintaModelRigaLavoro = elaboradistinta.model.RigaLavoro.loadRigaLavoroByQuery(null, null);
			// Update the properties of the persistent object
			elaboraDistintaModelRigaLavoro.save();
			elaboradistinta.model.RigheLavoro elaboraDistintaModelRigheLavoro = elaboradistinta.model.RigheLavoro.loadRigheLavoroByQuery(null, null);
			// Update the properties of the persistent object
			elaboraDistintaModelRigheLavoro.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Cantiere by CantiereCriteria");
		elaboradistinta.model.CantiereCriteria cantiereCriteria = new elaboradistinta.model.CantiereCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//cantiereCriteria.ID.eq();
		System.out.println(cantiereCriteria.uniqueCantiere());
		
		System.out.println("Retrieving Commessa by CommessaCriteria");
		elaboradistinta.model.CommessaCriteria commessaCriteria = new elaboradistinta.model.CommessaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//commessaCriteria.ID.eq();
		System.out.println(commessaCriteria.uniqueCommessa());
		
		System.out.println("Retrieving Cliente by ClienteCriteria");
		elaboradistinta.model.ClienteCriteria clienteCriteria = new elaboradistinta.model.ClienteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//clienteCriteria.ID.eq();
		System.out.println(clienteCriteria.uniqueCliente());
		
		System.out.println("Retrieving Distinta by DistintaCriteria");
		elaboradistinta.model.DistintaCriteria distintaCriteria = new elaboradistinta.model.DistintaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//distintaCriteria.ID.eq();
		System.out.println(distintaCriteria.uniqueDistinta());
		
		System.out.println("Retrieving DocumentoOttimizzazione by DocumentoOttimizzazioneCriteria");
		elaboradistinta.model.DocumentoOttimizzazioneCriteria documentoOttimizzazioneCriteria = new elaboradistinta.model.DocumentoOttimizzazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//documentoOttimizzazioneCriteria.ID.eq();
		System.out.println(documentoOttimizzazioneCriteria.uniqueDocumentoOttimizzazione());
		
		System.out.println("Retrieving ListaRintracciabilita by ListaRintracciabilitaCriteria");
		elaboradistinta.model.ListaRintracciabilitaCriteria listaRintracciabilitaCriteria = new elaboradistinta.model.ListaRintracciabilitaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//listaRintracciabilitaCriteria.ID.eq();
		System.out.println(listaRintracciabilitaCriteria.uniqueListaRintracciabilita());
		
		System.out.println("Retrieving History by HistoryCriteria");
		elaboradistinta.model.HistoryCriteria historyCriteria = new elaboradistinta.model.HistoryCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//historyCriteria.ID.eq();
		System.out.println(historyCriteria.uniqueHistory());
		
		System.out.println("Retrieving Geometria by GeometriaCriteria");
		elaboradistinta.model.GeometriaCriteria geometriaCriteria = new elaboradistinta.model.GeometriaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//geometriaCriteria.ID.eq();
		System.out.println(geometriaCriteria.uniqueGeometria());
		
		System.out.println("Retrieving Item by ItemCriteria");
		elaboradistinta.model.ItemCriteria itemCriteria = new elaboradistinta.model.ItemCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//itemCriteria.ID.eq();
		System.out.println(itemCriteria.uniqueItem());
		
		System.out.println("Retrieving Ordine by OrdineCriteria");
		elaboradistinta.model.OrdineCriteria ordineCriteria = new elaboradistinta.model.OrdineCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ordineCriteria.ID.eq();
		System.out.println(ordineCriteria.uniqueOrdine());
		
		System.out.println("Retrieving RigaLavoro by RigaLavoroCriteria");
		elaboradistinta.model.RigaLavoroCriteria rigaLavoroCriteria = new elaboradistinta.model.RigaLavoroCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//rigaLavoroCriteria.ID.eq();
		System.out.println(rigaLavoroCriteria.uniqueRigaLavoro());
		
		System.out.println("Retrieving RigheLavoro by RigheLavoroCriteria");
		elaboradistinta.model.RigheLavoroCriteria righeLavoroCriteria = new elaboradistinta.model.RigheLavoroCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//righeLavoroCriteria.ID.eq();
		System.out.println(righeLavoroCriteria.uniqueRigheLavoro());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateCoedilData retrieveAndUpdateCoedilData = new RetrieveAndUpdateCoedilData();
			try {
				retrieveAndUpdateCoedilData.retrieveAndUpdateTestData();
				//retrieveAndUpdateCoedilData.retrieveByCriteria();
			}
			finally {
				elaboradistinta.model.CoedilPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
