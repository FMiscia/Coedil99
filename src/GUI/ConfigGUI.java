package GUI;

import java.awt.Color;

import javax.swing.ImageIcon;

/**
 * Classe di configurazione per la GUI
 * 
 * @author Simone
 * 
 */
public class ConfigGUI {

	private static String LookAndFeel = "com.jtattoo.plaf.mint.MintLookAndFeel";
	private static ImageIcon ImportIcon = new ImageIcon(
			ConfigGUI.class.getResource("/GUI/image/import.png"));
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
	private static Color coloreSelezionato = new Color(171,171,171);
	private static Color coloreDeselezionato = new Color(240,240,240);
	private static Color coloreBordoCard = Color.BLACK;
	private static Color coloreRigaRDA = new Color(192, 192, 192);
	private static int numBottoniClipPanel = 8;

	/**
	 * Costruttore
	 */
	public ConfigGUI() {
	}

	public static String getLookAndFeel() {
		return LookAndFeel;
	}

	public static void setLookAndFeel(String lookAndFeel) {
		LookAndFeel = lookAndFeel;
	}

	public static ImageIcon getImportIcon() {
		return ImportIcon;
	}

	public static void setImportIcon(ImageIcon importIcon) {
		ImportIcon = importIcon;
	}

	public static ImageIcon getEditIcon() {
		return EditIcon;
	}

	public static void setEditIcon(ImageIcon editIcon) {
		EditIcon = editIcon;
	}

	public static ImageIcon getSaveIcon() {
		return SaveIcon;
	}

	public static void setSaveIcon(ImageIcon saveIcon) {
		SaveIcon = saveIcon;
	}

	public static ImageIcon getAbortIcon() {
		return AbortIcon;
	}

	public static void setAbortIcon(ImageIcon abortIcon) {
		AbortIcon = abortIcon;
	}

	public static ImageIcon getErrorIcon() {
		return ErrorIcon;
	}

	public static void setErrorIcon(ImageIcon errorIcon) {
		ErrorIcon = errorIcon;
	}

	public static ImageIcon getOkIcon() {
		return OkIcon;
	}

	public static void setOkIcon(ImageIcon okIcon) {
		OkIcon = okIcon;
	}

	public static Color getColoreSelezionato() {
		return coloreSelezionato;
	}

	public static void setColoreSelezionato(Color coloreSelezionato) {
		ConfigGUI.coloreSelezionato = coloreSelezionato;
	}

	public static Color getColoreDeselezionato() {
		return coloreDeselezionato;
	}

	public static void setColoreDeselezionato(Color coloreDeselezionato) {
		ConfigGUI.coloreDeselezionato = coloreDeselezionato;
	}

	public static Color getColoreBordoCard() {
		return coloreBordoCard;
	}

	public static void setColoreBordoCard(Color coloreBordoCard) {
		ConfigGUI.coloreBordoCard = coloreBordoCard;
	}

	public static Color getColoreRigaRDA() {
		return coloreRigaRDA;
	}

	public static void setColoreRigaRDA(Color coloreRigaRDA) {
		ConfigGUI.coloreRigaRDA = coloreRigaRDA;
	}

	public static int getNumBottoniClipPanel() {
		return numBottoniClipPanel;
	}

	public static void setNumBottoniClipPanel(int numBottoniClipPanel) {
		ConfigGUI.numBottoniClipPanel = numBottoniClipPanel;
	}

}
