/**
 * Licensee: DuKe TeAm
 * License Type: Purchased
 */
package ormsamples;

import org.orm.*;
public class CreateCoedilData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = elaboradistinta.model.CoedilPersistentManager.instance().getSession().beginTransaction();
		try {
			elaboradistinta.model.Cantiere elaboraDistintaModelCantiere = elaboradistinta.model.Cantiere.createCantiere();
			// Initialize the properties of the persistent object here
			elaboraDistintaModelCantiere.save();
			elaboradistinta.model.Commessa elaboraDistintaModelCommessa = elaboradistinta.model.Commessa.createCommessa();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : ldr
			elaboraDistintaModelCommessa.save();
			elaboradistinta.model.Cliente elaboraDistintaModelCliente = elaboradistinta.model.Cliente.createCliente();
			// Initialize the properties of the persistent object here
			elaboraDistintaModelCliente.save();
			elaboradistinta.model.Distinta elaboraDistintaModelDistinta = elaboradistinta.model.Distinta.createDistinta();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : lavori
			elaboraDistintaModelDistinta.save();
			elaboradistinta.model.DocumentoOttimizzazione elaboraDistintaModelDocumentoOttimizzazione = elaboradistinta.model.DocumentoOttimizzazione.createDocumentoOttimizzazione();
			// Initialize the properties of the persistent object here
			elaboraDistintaModelDocumentoOttimizzazione.save();
			elaboradistinta.model.ListaRintracciabilita elaboraDistintaModelListaRintracciabilita = elaboradistinta.model.ListaRintracciabilita.createListaRintracciabilita();
			// Initialize the properties of the persistent object here
			elaboraDistintaModelListaRintracciabilita.save();
			elaboradistinta.model.History elaboraDistintaModelHistory = elaboradistinta.model.History.createHistory();
			// Initialize the properties of the persistent object here
			elaboraDistintaModelHistory.save();
			elaboradistinta.model.Geometria elaboraDistintaModelGeometria = elaboradistinta.model.Geometria.createGeometria();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : lunghezza, altezza, base
			elaboraDistintaModelGeometria.save();
			elaboradistinta.model.Item elaboraDistintaModelItem = elaboradistinta.model.Item.createItem();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : history, geometria
			elaboraDistintaModelItem.save();
			elaboradistinta.model.Ordine elaboraDistintaModelOrdine = elaboradistinta.model.Ordine.createOrdine();
			// Initialize the properties of the persistent object here
			elaboraDistintaModelOrdine.save();
			elaboradistinta.model.RigaLavoro elaboraDistintaModelRigaLavoro = elaboradistinta.model.RigaLavoro.createRigaLavoro();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : numero, capitello, geometria
			elaboraDistintaModelRigaLavoro.save();
			elaboradistinta.model.RigheLavoro elaboraDistintaModelRigheLavoro = elaboradistinta.model.RigheLavoro.createRigheLavoro();
			// Initialize the properties of the persistent object here
			elaboraDistintaModelRigheLavoro.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateCoedilData createCoedilData = new CreateCoedilData();
			try {
				createCoedilData.createTestData();
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
