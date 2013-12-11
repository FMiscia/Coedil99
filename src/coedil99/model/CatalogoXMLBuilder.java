package coedil99.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 * @author francesco
 * 
 *         Pattern Builder
 */

public class CatalogoXMLBuilder extends CatalogoFornitoreBuilder {

	@Override
	public void Parse(String catalogo) throws IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc = null;
		try {
			builder = factory.newDocumentBuilder();
			doc = builder.parse(catalogo);
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			if(this.salvaProdotti(getProdotti(doc, xpath), getGeometrie(doc, xpath)));
			else
				throw new IOException();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			JOptionPane.showMessageDialog(null,
					"Errore nella lettura del catalogo: \n" + e.getMessage());
			throw new IOException();
		}
		

	}

	private ArrayList<MProductDescription> getProdotti(Document doc, XPath xpath) {
		XPathExpression essenze;
		XPathExpression prezzi;
		XPathExpression pezzi;
		ArrayList<MProductDescription> prodotti = new ArrayList<MProductDescription>();
		try {
			essenze = xpath.compile("/fornitore/prodotto/essenza/text()");
			prezzi = xpath.compile("/fornitore/prodotto/prezzo/text()");
			pezzi = xpath.compile("/fornitore/prodotto/pezzi_per_pacco/text()");
			NodeList nessenze = (NodeList) essenze.evaluate(doc,
					XPathConstants.NODESET);
			NodeList nprezzi = (NodeList) prezzi.evaluate(doc,
					XPathConstants.NODESET);
			NodeList npezzi = (NodeList) pezzi.evaluate(doc,
					XPathConstants.NODESET);
			if (nessenze.getLength() == nprezzi.getLength()
					&& nprezzi.getLength() == npezzi.getLength())
				for (int i = 0; i < nessenze.getLength(); i++) {
					MProductDescription p = new MProductDescription();
					p.getPersistentModel().setEssenza(
							nessenze.item(i).getNodeValue());
					p.getPersistentModel().setPrezzo(
							Float.parseFloat(nprezzi.item(i).getNodeValue()));
					p.getPersistentModel().setPezzi_per_pacco(
							Integer.parseInt(npezzi.item(i).getNodeValue()));
					prodotti.add(p);
				}
		} catch (XPathExpressionException e) {
			JOptionPane.showMessageDialog(
					null,
					"Errore nella lettura del catalogo XML. \n"
							+ e.getMessage());
		}
		return prodotti;
	}

	private ArrayList<MGeometria> getGeometrie(Document doc, XPath xpath) {
		XPathExpression basi;
		XPathExpression altezze;
		XPathExpression lunghezze;
		ArrayList<MGeometria> geometrie = new ArrayList<MGeometria>();
		try {
			basi = xpath.compile("/fornitore/prodotto/geometria/base/text()");
			altezze = xpath
					.compile("/fornitore/prodotto/geometria/altezza/text()");
			lunghezze = xpath
					.compile("/fornitore/prodotto/geometria/lunghezza/text()");
			NodeList nbasi = (NodeList) basi.evaluate(doc,
					XPathConstants.NODESET);
			NodeList naltezze = (NodeList) altezze.evaluate(doc,
					XPathConstants.NODESET);
			NodeList nlunghezze = (NodeList) lunghezze.evaluate(doc,
					XPathConstants.NODESET);
			if (nbasi.getLength() == naltezze.getLength()
					&& naltezze.getLength() == nlunghezze.getLength())
				for (int i = 0; i < nbasi.getLength(); i++) {
					MGeometria g = new MGeometria();
					g.getPersistentModel().setBase(
							Float.parseFloat(nbasi.item(i).getNodeValue()));
					g.getPersistentModel().setAltezza(
							Float.parseFloat(naltezze.item(i).getNodeValue()));
					g.getPersistentModel()
							.setLunghezza(
									Float.parseFloat(nlunghezze.item(i)
											.getNodeValue()));
					geometrie.add(g);
				}
		} catch (XPathExpressionException e) {
			JOptionPane.showMessageDialog(
					null,
					"Errore nella lettura del catalogo XML. \n"
							+ e.getMessage());
		}
		return geometrie;
	}

	private boolean salvaProdotti(ArrayList<MProductDescription> prodotti,
			ArrayList<MGeometria> geometrie) {
		if (prodotti.isEmpty() || geometrie.isEmpty()
				|| prodotti.size() != geometrie.size()) {
			return false;
		} else if (prodotti.size() == geometrie.size()) {
			for (int i = 0; i < prodotti.size(); ++i) {
				prodotti.get(i).getPersistentModel()
						.setGeometria(geometrie.get(i).getPersistentModel());
				this.catalogo.getPersistentModel().productDescription
						.add(prodotti.get(i).getPersistentModel());
				this.catalogo.save();
			}
		}
		return true;
	}

}