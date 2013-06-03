package GUIelaborazione2;
import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import GUIelaborazione2.RiquadriCommessa.RiquadroDatiAziendali;
import GUIelaborazione2.RiquadriCommessa.RiquadroDatiClienteConsegna;
import GUIelaborazione2.RiquadriCommessa.RiquadroDatiConsegna;
import GUIelaborazione2.RiquadriCommessa.RiquadroDatiProduzioneConsegna;
import GUIelaborazione2.RiquadriCommessa.RiquadroSviluppoConsegna;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


@SuppressWarnings("serial")
public class PlicoCommessa extends Plico{

	private RiquadroDatiClienteConsegna rdcc;
	private RiquadroDatiAziendali rda;
	private RiquadroDatiConsegna rdc;
	private RiquadroDatiProduzioneConsegna rdpc;
	private RiquadroSviluppoConsegna rsc;

	public PlicoCommessa(){
		setBorder(null);
		setLayout(null);
		
		rda = new RiquadroDatiAziendali("Dati Aziendali");

		rda.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				posizionaRiquadri();
			}
		});
		rdcc = new RiquadroDatiClienteConsegna("Dati Consegna Cliente");
		rdc = new RiquadroDatiConsegna("Dati Consenga");
		rdpc = new RiquadroDatiProduzioneConsegna("Dati Consegna Produzione");
		rsc = new RiquadroSviluppoConsegna("Dati Sviluppo Consegna");
		posizionaRiquadri();
		setPreferredSize(new Dimension(745,calcolaAltezza()));
		setSize(745,950);
		add(rda);
		add(rdcc);
		add(rdc);
		add(rdpc);
		add(rsc);
		/*
		datiSviluppoConsegna = new JPanel();
		datiSviluppoConsegna.setPreferredSize(new Dimension(300,300));
		datiSviluppoConsegna.setBorder(new TitledBorder("Dati Sviluppo Consegna"));
		this.add(datiSviluppoConsegna);
		
		datiProduzioneConsegna = new JPanel();
		datiProduzioneConsegna.setPreferredSize(new Dimension(300,300));
		datiProduzioneConsegna.setBorder(new TitledBorder("Dati Produzione Consegna"));
		add(datiProduzioneConsegna);
		
		datiConsenga = new JPanel();
		datiConsenga.setPreferredSize(new Dimension(300,300));
		datiConsenga.setBorder(new TitledBorder("Dati Consegna"));
		add(datiConsenga);
		*/
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load(Object o) {
		// TODO Auto-generated method stub
		
	}
	
	private int calcolaAltezza(){
		return rda.getHeight()+rdcc.getHeight()+rdc.getHeight()+rdpc.getHeight()+rsc.getHeight()+100;
	}
	
	private void posizionaRiquadri(){
		rda.setBounds(40, 20,rda.getWidth(),rda.getHeight());
		rdcc.setBounds(40, rda.getY()+rda.getHeight()+20, rdcc.getWidth(), rdcc.getHeight());
		rdc.setBounds(40, rdcc.getY()+rdcc.getHeight()+20, rdc.getWidth(), rdc.getHeight());
		rdpc.setBounds(40, rdc.getY()+rdc.getHeight()+20, rdpc.getWidth(), rdpc.getHeight());
		rsc.setBounds(40, rdpc.getY()+rdpc.getHeight()+20, rsc.getWidth(), rsc.getHeight());
		validate();
		repaint();
		
	}
}