package GUI.Panels;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import GUI.ConfigGUI;
import GUI.RDACenter;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Insets;
import javax.swing.JScrollPane;

public class NotaRDA extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea area;
	String newline = "\n";

	/**
	 * Costruttore
	 */
	public NotaRDA() {
		super();
		this.initialize();
	}

	/**
	 * Imposta la grafica e i bottoni (e relativi listeners)
	 */
	private void initialize() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("60px:grow"),
				ColumnSpec.decode("350px:grow"),
				ColumnSpec.decode("60px:grow"),},
			new RowSpec[] {
				RowSpec.decode("100px"),
				RowSpec.decode("190px"),}));

		JLabel label = new JLabel("Nota relativa alla RDA selezionata",
				JLabel.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, 16));
		add(label, "2, 1, center, center");

		area = new JTextArea();
		area.setMargin(new Insets(5, 5, 5, 5));
		area.setWrapStyleWord(true);
		area.setLineWrap(true);
		this.setEnable(false);
		
		JScrollPane scrollPane = new JScrollPane(area);
		add(scrollPane, "2, 2, fill, fill");
		//add(area, "2, 2, fill, fill");

	}

	public void setNotaTxt() {
		String desc = RDACenter.getInstance().getRDASelezionata()
				.getDescrizione();
		area.setText(desc);
	}

	/**
	 * Metodo che abilita/disabilita la text area
	 * 
	 * @param enable
	 */
	public void setEnable(boolean enable) {
		area.setEnabled(enable);
		if (enable)
			area.setBackground(ConfigGUI.getInstance().getColoreTextAreaEnable());
		else
			area.setBackground(ConfigGUI.getInstance().getColoreTextAreaDisable());
	}
	
	
	public String getNotaTxt(){
		if(area.getText().length() > 250)
			area.setText(area.getText().substring(0,200));
		return area.getText();
	}

}
