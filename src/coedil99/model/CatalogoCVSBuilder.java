package coedil99.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.orm.PersistentException;

import coedil99.controller.GestisciFornitoreHandler;

import au.com.bytecode.opencsv.CSVReader;

/**
 * 
 * @author francesco
 * 
 *         Pattern Builder
 */
public class CatalogoCVSBuilder extends CatalogoFornitoreBuilder {

	@Override
	public void Parse(String catalogo) throws IOException {
		CSVReader reader = new CSVReader(new FileReader(catalogo), '#');
		CatalogoFornitore new_catalogo = GestisciFornitoreHandler.getInstance().creaCatalogoFornitore();
		String[] fornitore = reader.readNext();
		String[] nome_fornitore = reader.readNext();
		String[] intestazione = reader.readNext();
		new_catalogo.setName(nome_fornitore[0]);
		System.out.println(nome_fornitore[0]);
		String[] row = null;
		while ((row = reader.readNext()) != null) {
			ProductDescriptionFactory descrizione_factory = new ProductDescriptionFactory();
			ProductDescription new_productDescription = descrizione_factory.createProductDescription();
			new_productDescription.setEssenza(row[0]);
			new_productDescription.setPrezzo(Float.parseFloat(row[1]));
			new_productDescription.setPezzi_per_pacco(Integer.valueOf(row[2]));
			
			GeometriaFactory geometria_factory = new GeometriaFactory();
			Geometria new_geometria = geometria_factory.createGeometria();
			new_geometria.setBase(Float.parseFloat(row[3]));
			new_geometria.setAltezza(Float.parseFloat(row[4]));
			new_geometria.setAltezza(Float.parseFloat(row[5]));
			
			new_productDescription.setGeometria(new_geometria);
			new_catalogo.productDescription.add(new_productDescription);
			
			try {
				new_catalogo.save();
				new_productDescription.save();
				new_geometria.save();
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(row[0] + " # " + row[1] + " # " + row[2] + " # "
					+ row[3] + " # " + row[4] + " # " + row[5]);
		}
		reader.close();

	}
}