package GUI;

import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.alee.laf.scroll.WebScrollBarUI;
import com.jtattoo.plaf.mint.MintLookAndFeel;

/**
 * Classe di configurazione per la GUI
 * 
 * @author Simone
 * 
 */
public class ConfigGUI {

	private static String LookAndFeel = "com.jtattoo.plaf.mint.MintLookAndFeel";
	private static URL CoedilIcon = ConfigGUI.class.getResource("/GUI/image/coedil.png");
	private static ImageIcon ImportIcon = new ImageIcon(
			ConfigGUI.class.getResource("/GUI/image/upload.png"));
	private static ImageIcon EditIcon = new ImageIcon(
			ConfigGUI.class.getResource("/GUI/image/edit.png"));
	private static ImageIcon SaveIcon = new ImageIcon(
			ConfigGUI.class.getResource("/GUI/image/save.png"));
	private static ImageIcon AbortIcon = new ImageIcon(
			ConfigGUI.class.getResource("/GUI/image/canc.png"));
	private static ImageIcon ErrorIcon = new ImageIcon(
			ConfigGUI.class.getResource("/GUI/image/cancel.png"));
	private static ImageIcon OkIcon = new ImageIcon(
			ConfigGUI.class.getResource("/GUI/image/ok.png"));
	
	private static ImageIcon RDACongelata = new ImageIcon(
			ConfigGUI.class.getResource("/GUI/image/congelata.png"));
	private static ImageIcon RDARifiutata = new ImageIcon(
			ConfigGUI.class.getResource("/GUI/image/rifiutata.png"));
	private static ImageIcon RDAAttesa = new ImageIcon(ConfigGUI.class
			.getResource("/GUI/image/attesaconferma.png"));
	private static ImageIcon RDAConfermata = new ImageIcon(
			ConfigGUI.class.getResource("/GUI/image/confermata.png"));
	private static ImageIcon UCProgrammaLavori = new ImageIcon(
			ConfigGUI.class.getResource("/GUI/image/proglavori.png"));
	private static ImageIcon UCRDA = new ImageIcon(
			ConfigGUI.class.getResource("/GUI/image/rda.png"));
	private static ImageIcon UCFornitori = new ImageIcon(
			ConfigGUI.class.getResource("/GUI/image/fornitori.png"));

	private static Color coloreSelezionato = new Color(171, 171, 171);
	private static Color coloreDeselezionato = new Color(248, 248, 255);
	private static Color coloreProdottoPari = new Color(180, 180, 180);
	private static Color coloreProdottoDispari = new Color(240, 240, 240);
	private static Color coloreBordoCard = Color.BLACK;
	private static Color coloreRigaRDA = new Color(192, 192, 192);
	private static Color coloreTextAreaDisable = Color.darkGray;
	private static Color coloreTextAreaEnable = Color.WHITE;
	private static Color coloreBordoErrore = Color.RED;
	private static Color coloreBordoOk = Color.GREEN;
	private static Color coloreBordoStandard = Color.GRAY;
	private static int numBottoniClipPanel = 8;
	private XPath xpath;
	private Object doc;
	private static ConfigGUI instance;
	private boolean parsed;

	/**
	 * Costruttore
	 */
	public ConfigGUI() {
		Properties props = new Properties();
		props.put("buttonBackgroundColor", "171 171 171");
		props.put("buttonColorLight", "171 171 171");
		props.put("buttonColorDark", "171 171 171");
		props.put("selectionBackgroundColor", "171 171 171");
		props.put("focusColor", "171 171 171");
		props.put("focusCellColor", "171 171 171");
		props.put("rolloverColor", "171 171 171");
		props.put("rolloverColorLight", "171 171 171");
		props.put("rolloverColorDark", "171 171 171");

		MintLookAndFeel.setCurrentTheme(props);

		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
			UIManager.put("ScrollBarUI", WebScrollBarUI.class.getName());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		try {
			this.parsed = parseConfig();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Singleton
	 * 
	 * @return ConfigGUI
	 */
	public static ConfigGUI getInstance() {
		if (instance == null) {
			instance = new ConfigGUI();
		}
		return instance;
	}

	public boolean isParsed() {
		return parsed;
	}

	public static String getLookAndFeel() {
		return LookAndFeel;
	}

	public static void setLookAndFeel(String lookAndFeel) {
		LookAndFeel = lookAndFeel;
	}

	public URL getCoedilIcon() {
		if(parsed)
			return getURL("icon/CoedilIcon");
		else
			return CoedilIcon;
	}

	public static void setCoedilIcon(URL coedilIcon) {
		CoedilIcon = coedilIcon;
	}
	
	public ImageIcon getImportIcon() {
		if (parsed)
			return getIcon("ImportIcon");
		else
			return ImportIcon;
	}

	public static void setImportIcon(ImageIcon importIcon) {
		ImportIcon = importIcon;
	}

	public ImageIcon getEditIcon() {
		if (parsed)
			return getIcon("EditIcon");
		else
			return EditIcon;
	}

	public static void setEditIcon(ImageIcon editIcon) {
		EditIcon = editIcon;
	}

	public ImageIcon getSaveIcon() {
		if (parsed)
			return getIcon("SaveIcon");
		else
			return SaveIcon;
	}

	public static void setSaveIcon(ImageIcon saveIcon) {
		SaveIcon = saveIcon;
	}

	public ImageIcon getAbortIcon() {
		if (parsed)
			return getIcon("AbortIcon");
		else
			return AbortIcon;
	}

	public static void setAbortIcon(ImageIcon abortIcon) {
		AbortIcon = abortIcon;
	}

	public ImageIcon getErrorIcon() {
		if (parsed)
			return getIcon("ErrorIcon");
		else
			return ErrorIcon;
	}

	public static void setErrorIcon(ImageIcon errorIcon) {
		ErrorIcon = errorIcon;
	}

	public ImageIcon getOkIcon() {
		if (parsed)
			return getIcon("OkIcon");
		else
			return OkIcon;
	}

	public static void setOkIcon(ImageIcon okIcon) {
		OkIcon = okIcon;
	}

	public Color getColoreSelezionato() {
		if (parsed)
			return getColor("Selezionato");
		else
			return coloreSelezionato;
	}

	public static void setColoreSelezionato(Color coloreSelezionato) {
		ConfigGUI.coloreSelezionato = coloreSelezionato;
	}

	public Color getColoreDeselezionato() {
		if (parsed)
			return getColor("Deselezionato");
		else
			return coloreDeselezionato;
	}

	public static void setColoreDeselezionato(Color coloreDeselezionato) {
		ConfigGUI.coloreDeselezionato = coloreDeselezionato;
	}

	public Color getColoreBordoCard() {
		if (parsed)
			return getColor("BordoCard");
		else
			return coloreBordoCard;
	}

	public static void setColoreBordoCard(Color coloreBordoCard) {
		ConfigGUI.coloreBordoCard = coloreBordoCard;
	}

	public Color getColoreProdottoPari() {
		if (parsed)
			return getColor("ProdottoPari");
		else
			return coloreProdottoPari;
	}

	public static void setColoreProdottoPari(Color coloreProdottoPari) {
		ConfigGUI.coloreProdottoPari = coloreProdottoPari;
	}

	public Color getColoreProdottoDispari() {
		if (parsed)
			return getColor("ProdottoDispari");
		else
			return coloreProdottoDispari;
	}

	public static void setColoreProdottoDispari(Color coloreProdottoDispari) {
		ConfigGUI.coloreProdottoDispari = coloreProdottoDispari;
	}

	public Color getColoreRigaRDA() {
		if (parsed)
			return getColor("RigaRDA");
		else
			return coloreRigaRDA;
	}

	public Color getColoreTextAreaDisable() {
		if (parsed)
			return getColor("TextAreaDisable");
		else
			return coloreTextAreaDisable;
	}

	public static void setColoreTextAreaDisable(Color coloreTextAreaDisable) {
		ConfigGUI.coloreTextAreaDisable = coloreTextAreaDisable;
	}

	public Color getColoreTextAreaEnable() {
		if (parsed)
			return getColor("TextAreaEnable");
		else
			return coloreTextAreaEnable;
	}

	public static void setColoreTextAreaEnable(Color coloreTextAreaEnable) {
		ConfigGUI.coloreTextAreaEnable = coloreTextAreaEnable;
	}

	public static void setColoreRigaRDA(Color coloreRigaRDA) {
		ConfigGUI.coloreRigaRDA = coloreRigaRDA;
	}

	public Color getColoreBordoErrore() {
		if (parsed)
			return getColor("BordoErrore");
		return coloreBordoErrore;
	}

	public Color getColoreBordoOk() {
		if (parsed)
			return getColor("BordoOk");
		else
			return coloreBordoOk;
	}

	public static void setColoreBordoOk(Color coloreBordoOk) {
		ConfigGUI.coloreBordoOk = coloreBordoOk;
	}

	public static void setColoreBordoErrore(Color coloreBordoErrore) {
		ConfigGUI.coloreBordoErrore = coloreBordoErrore;
	}

	public int getNumBottoniClipPanel() {
		if (parsed)
			return getNumBottoni();
		else
			return numBottoniClipPanel;
	}

	public static void setNumBottoniClipPanel(int numBottoniClipPanel) {
		ConfigGUI.numBottoniClipPanel = numBottoniClipPanel;
	}

	public ImageIcon getRDACongelata() {
		if(parsed)
			return getIcon("RDACongelata");
		else
			return RDACongelata;
	}

	public static void setRDACongelata(ImageIcon rDACongelata) {
		RDACongelata = rDACongelata;
	}

	public ImageIcon getRDARifiutata() {
		if(parsed)
			return getIcon("RDARifiutata");
		else
			return RDARifiutata;
	}

	public static void setRDARifiutata(ImageIcon rDARifiutata) {
		RDARifiutata = rDARifiutata;
	}

	public ImageIcon getRDAAttesa() {
		if(parsed)
			return getIcon("RDAAttesa");
		else
			return RDAAttesa;
	}

	public static void setRDAAttesa(ImageIcon rDAAttesa) {
		RDAAttesa = rDAAttesa;
	}

	public ImageIcon getRDAConfermata() {
		if(parsed)
			return getIcon("RDAConfermata");
		else
			return RDAConfermata;
	}

	public static void setRDAConfermata(ImageIcon rDAConfermata) {
		RDAConfermata = rDAConfermata;
	}

	public ImageIcon getUCProgrammaLavori() {
		if(parsed)
			return getIcon("UCProgrammaLavori");
		else
			return UCProgrammaLavori;
	}

	public static void setUCProgrammaLavori(ImageIcon uCProgrammaLavori) {
		UCProgrammaLavori = uCProgrammaLavori;
	}

	public ImageIcon getUCRDA() {
		if(parsed)
			return getIcon("UCRDA");
		else
			return UCRDA;
	}

	public static void setUCRDA(ImageIcon uCRDA) {
		UCRDA = uCRDA;
	}

	public ImageIcon getUCFornitori() {
		if(parsed)
			return getIcon("UCFornitori");
		else
			return UCFornitori;
	}

	public static void setUCFornitori(ImageIcon uCFornitori) {
		UCFornitori = uCFornitori;
	}

	/**
	 * Metodo che parsa il file di configurazione presente nella cartella
	 * GUI/Configuration
	 * 
	 * @return boolean: indica l'esito del parsing
	 */
	public boolean parseConfig() throws SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		doc = null;
		try {
			builder = factory.newDocumentBuilder();
			try {
				doc = builder.parse(ConfigGUI.class.getResource(
						"/GUI/Configuration/ConfigGUI.xml").toString());
			} catch (Exception e) {
				return false;
			}
			XPathFactory xpathFactory = XPathFactory.newInstance();
			xpath = xpathFactory.newXPath();
			return true;
		} catch (ParserConfigurationException e) {
			return false;
		}
	}

	public String getLAF() {
		XPathExpression LAF;
		try {
			LAF = xpath.compile("/configuration/LookAndFeel/text()");
			NodeList nlaf = (NodeList) LAF
					.evaluate(doc, XPathConstants.NODESET);
			if (nlaf.getLength() <= 0)
				return null;
			else
				return nlaf.item(0).getNodeValue();
		} catch (XPathExpressionException e) {
			JOptionPane.showMessageDialog(
					null,
					"Errore nella lettura del catalogo XML. \n"
							+ e.getMessage());
			return null;
		}
	}

	/**
	 * Metodo che ritorna il colore associato all'emenento ricercato
	 * 
	 * @param elemento
	 * @return Color
	 */
	public Color getColor(String elemento) {
		XPathExpression r;
		XPathExpression g;
		XPathExpression b;
		try {
			r = xpath
					.compile("/configuration/colore/" + elemento + "/r/text()");
			b = xpath
					.compile("/configuration/colore/" + elemento + "/g/text()");
			g = xpath
					.compile("/configuration/colore/" + elemento + "/b/text()");
			NodeList nr = (NodeList) r.evaluate(doc, XPathConstants.NODESET);
			NodeList nb = (NodeList) g.evaluate(doc, XPathConstants.NODESET);
			NodeList ng = (NodeList) b.evaluate(doc, XPathConstants.NODESET);
			if (nr.getLength() == nb.getLength()
					&& nb.getLength() == ng.getLength() && nr.getLength() > 0)
				return new Color(Integer.valueOf(nr.item(0).getNodeValue()),
						Integer.valueOf(ng.item(0).getNodeValue()),
						Integer.valueOf(nb.item(0).getNodeValue()));
			else
				return null;
		} catch (XPathExpressionException e) {
			JOptionPane.showMessageDialog(
					null,
					"Errore nella lettura del catalogo XML. \n"
							+ e.getMessage());
			return null;
		}
	}

	/**
	 * Metodo che ritorna l'icona associata all'emenento ricercato
	 * 
	 * @param elemento
	 * @return ImageIcon
	 */
	public ImageIcon getIcon(String elemento) {
		XPathExpression ico;
		try {
			ico = xpath.compile("/configuration/icon/" + elemento + "/text()");
			NodeList nico = (NodeList) ico
					.evaluate(doc, XPathConstants.NODESET);
			if (nico.getLength() > 0)
				return new ImageIcon(ConfigGUI.class.getResource(nico.item(0).getNodeValue()));
			else
				return null;
		} catch (XPathExpressionException e) {
			JOptionPane.showMessageDialog(
					null,
					"Errore nella lettura del catalogo XML. \n"
							+ e.getMessage());
			return null;
		}
	}
	
	/**
	 * Metodo che ritorna l'icona associata all'emenento ricercato
	 * 
	 * @param elemento
	 * @return ImageIcon
	 */
	public URL getURL(String elemento) {
		XPathExpression ico;
		try {
			ico = xpath.compile("/configuration/" + elemento + "/text()");
			NodeList nico = (NodeList) ico
					.evaluate(doc, XPathConstants.NODESET);
			if (nico.getLength() > 0)
				return ConfigGUI.class.getResource(nico.item(0).getNodeValue());
			else
				return null;
		} catch (XPathExpressionException e) {
			JOptionPane.showMessageDialog(
					null,
					"Errore nella lettura del catalogo XML. \n"
							+ e.getMessage());
			return null;
		}
	}

	/**
	 * Meotodo che ritorna il numero di bottoni visualizzabili nel clip panel
	 * 
	 * @return int
	 */
	public int getNumBottoni() {
		XPathExpression bottoni;
		try {
			bottoni = xpath
					.compile("/configuration/numBottoniClipPanel/text()");
			NodeList nico = (NodeList) bottoni.evaluate(doc,
					XPathConstants.NODESET);
			if (nico.getLength() > 0)
				return Integer.parseInt(nico.item(0).getNodeValue());
			else
				return 0;
		} catch (XPathExpressionException e) {
			JOptionPane.showMessageDialog(
					null,
					"Errore nella lettura del catalogo XML. \n"
							+ e.getMessage());
			return 0;
		}

	}

	/**
	 * @return the coloreBordoStandard
	 */
	public Color getColoreBordoStandard() {
		if (parsed)
			return getColor("BordoStandard");
		else
			return coloreBordoStandard;
	}

	/**
	 * @param coloreBordoStandard
	 *            the coloreBordoStandard to set
	 */
	public static void setColoreBordoStandard(Color coloreBordoStandard) {
		ConfigGUI.coloreBordoStandard = coloreBordoStandard;
	}

}
