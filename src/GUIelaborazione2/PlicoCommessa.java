package GUIelaborazione2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import GUIelaborazione2.WrapLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;

public class PlicoCommessa extends Plico{

	public PlicoCommessa(){
		
		WrapLayout flowLayout = new WrapLayout(FlowLayout.LEFT,50,10);
		//flowLayout.setAlignment(FlowLayout.LEFT);
		//flowLayout.setHgap(50);
		JPanel panel = new JPanel(flowLayout);
		this.setViewportView(panel);
		this.setPreferredSize(new Dimension(1000, 500));
		this.setMaximumSize(new Dimension(1000,500));
		
		final JPanel datiClienteConsegna = new JPanel();
		datiClienteConsegna.setPreferredSize(new Dimension(300,300));
		datiClienteConsegna.setBorder(new TitledBorder("Dati Cliente consegna"));
		datiClienteConsegna.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0){
				datiClienteConsegna.setSize(300,20);
			}
		});
		panel.add(datiClienteConsegna);
		
		JPanel datiAziendali = new JPanel();
		datiAziendali.setPreferredSize(new Dimension(300,300));
		datiAziendali.setBorder(new TitledBorder("Dati Aziendali"));
		panel.add(datiAziendali);
		
		JPanel datiSviluppoConsegna = new JPanel();
		datiSviluppoConsegna.setPreferredSize(new Dimension(300,300));
		datiSviluppoConsegna.setBorder(new TitledBorder("Dati Sviluppo Consegna"));
		panel.add(datiSviluppoConsegna);
		
		JPanel datiProduzioneConsegna = new JPanel();
		datiProduzioneConsegna.setPreferredSize(new Dimension(300,300));
		datiProduzioneConsegna.setBorder(new TitledBorder("Dati Produzione Consegna"));
		panel.add(datiProduzioneConsegna);
		
		JPanel datiConsenga = new JPanel();
		datiConsenga.setPreferredSize(new Dimension(300,300));
		datiConsenga.setBorder(new TitledBorder("Dati Consegna"));
		panel.add(datiConsenga);
		
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load(Object o) {
		// TODO Auto-generated method stub
		
	}
}