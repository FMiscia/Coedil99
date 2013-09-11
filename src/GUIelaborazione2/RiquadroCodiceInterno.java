package GUIelaborazione2;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import elaboradistinta.controller.GestisciCommessaHandler;
import elaboradistinta.model.Cliente;
import elaboradistinta.model.Commessa;
import elaboradistinta.model.Ordine;
import GUIelaborazione2.RiquadroCodici;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class RiquadroCodiceInterno extends JPanel {
	
	private JLabel scadenza;
	private JLabel codiceInterno;
	private JLabel cliente;
	private RiquadroCodici riquadro = null;
	private int commessaId;

	public RiquadroCodiceInterno(RiquadroCodici rc){
		this.riquadro = rc;
		setBounds(new Rectangle(0, 0, 0, 0));
		this.setPreferredSize(new Dimension(200,59));
		this.setBackground(new Color(30, 144, 255));
		this.setBorder(new LineBorder(Color.BLACK));
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setLayout(null);
		
		scadenza = new JLabel();
		scadenza.setHorizontalAlignment(SwingConstants.CENTER);
		scadenza.setHorizontalTextPosition(SwingConstants.LEADING);
		scadenza.setBounds(100, 30, 100, 30);
		scadenza.setBorder(new LineBorder(Color.BLACK));
		
		codiceInterno = new JLabel();
		codiceInterno.setHorizontalAlignment(SwingConstants.CENTER);
		codiceInterno.setBounds(0, 30, 100, 30);
		codiceInterno.setBorder(new LineBorder(Color.BLACK));
		
		cliente = new JLabel();
		cliente.setHorizontalAlignment(SwingConstants.CENTER);
		cliente.setHorizontalTextPosition(SwingConstants.CENTER);
		cliente.setBorder(new LineBorder(new Color(0, 0, 0)));
		cliente.setBounds(0, 0, 200, 30);
		
		add(cliente);
		add(scadenza);
		add(codiceInterno);
				
	}
	
	public void load(Cliente c, Ordine o, final Commessa cc){
		cliente.setText(c.getName());
		if(o.getDataScadenza() == null)
			scadenza.setText("--/--/----");
		else
			scadenza.setText(o.getDataScadenza().toString());
		codiceInterno.setText(cc.getCodiceInterno());
		this.commessaId = cc.getID();
		
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				PlicoCommessa plico_commessa = PlicoCommessa.getInstance();		
				RiquadroCodiceInterno.this.riquadro.deselectAll();
				plico_commessa.load(RiquadroCodiceInterno.this.commessaId);
				final int idCommessa = RiquadroCodiceInterno.this.commessaId;
				ProgrammaLavori contenitore = ProgrammaLavori.getInstance();
				contenitore.setCommessaSelezionata(cc);
				contenitore.getRiquadroplico().getPaperPanel().removeAll();
				contenitore.getRiquadroplico().getPaperPanel().validate();
				contenitore.getRiquadroplico().getPaperPanel().repaint();
				contenitore.getRiquadroplico().getPaperPanel().add(plico_commessa);
				contenitore.getRiquadroplico().
				aggiornaClipPanel(GestisciCommessaHandler.getInstance().getCommessaById(idCommessa).getDistinta().getODistinta());
				RiquadroCodiceInterno.this.setBackground(new Color(30,44,255));
				RiquadroCodiceInterno.this.validate();
				RiquadroCodiceInterno.this.repaint();
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}

	public int getCommessaId() {
		return commessaId;
	}
	

}