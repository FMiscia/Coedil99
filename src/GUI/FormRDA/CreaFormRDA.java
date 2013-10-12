package GUI.FormRDA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import coedil99.model.ProductDescriptionFactory;
import coedil99.model.ProductDescriptionListCollection;

import GUI.Abstract.AFormRDA;

public class CreaFormRDA extends AFormRDA {
	
	private JButton JBAddRiga = new JButton("Aggiungi");
	
	public CreaFormRDA() {
		// TODO Auto-generated constructor stub
		super();
		this.JBAddRiga.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String fornitore = CreaFormRDA.this.getCbFornitore().getSelectedItem().toString();

			}
		});
		this.add(JBAddRiga, "2, 22");
	}

}
