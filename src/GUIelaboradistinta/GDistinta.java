package GUIelaboradistinta;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.border.EmptyBorder;

import provaTabelle.GDatiDistintaModel;
import provaTabelle.GDatiDistintaTable;

import elaboradistinta.StartUp;
import elaboradistinta.controller.GestisciCommessaHandler;
import elaboradistinta.model.CoedilPersistentManager;
import elaboradistinta.model.Distinta;
import elaboradistinta.model.Geometria;
import elaboradistinta.model.GeometriaFactory;
import elaboradistinta.model.Item;
import elaboradistinta.model.RigaLavoro;
import elaboradistinta.model.RigaLavoroFactory;
import elaboradistinta.operation.ODistinta;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

public class GDistinta {

	/**
	 * 
	 */
	Button save;
	Button cancel;
	Button nLine;
	Button ottimizza;
	Button visDdo;
	JFrame f;
	private static final long serialVersionUID = 1L;


	/**
	 * Create the frame.
	 */
	public GDistinta(final Distinta d,final String codice) {

		//JOptionPane.showMessageDialog(null, index.toString() );
		//final StartUp s = StartUp.getInstance();
		//final GestisciCommessaHandler gch = GestisciCommessaHandler.getInstance();
		f = new JFrame("Distinta "+ codice);
		f.setResizable(false);
		f.setBounds(100, 100, 600, 350);
		((JComponent) f.getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));
		f.getContentPane().setLayout(new BorderLayout(0, 0));
//		String[] cl6 = { "Base", "Altezza", "Lunghezza", "Numero", "Capitello","TipoCap", "Note" };
		//final GPanelDistinta t = new GPanelDistinta(makeVector(cl6), gch.getCommessaByCodiceInterno(index.toString()).getID());
		final JPanel t = new JPanel();
		t.add(new JScrollPane(new GDatiDistintaTable(d)));
		f.getContentPane().add(t);
		final JPanel doc = new JPanel();
		
		/**
		 * Pulsante per salvare le modifica
		 */
		save = new Button("Save");
		save.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
					PersistentTransaction t = CoedilPersistentManager.instance().getSession().beginTransaction();
					t.commit();
					JOptionPane.showMessageDialog(null,"Dati salvati correttamente");
				} catch (PersistentException e) {
					e.printStackTrace();
				}
			}
		});
		
		/**
		 * Pulsante per annullare le modifiche
		 */
		cancel = new Button("Annulla");
		cancel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
					int n = JOptionPane.showConfirmDialog(null,"Sicuro di voler annullare le modifiche?"
							,"Domanda",JOptionPane.YES_NO_OPTION);
					if(n == 0){
						PersistentTransaction s = CoedilPersistentManager.instance().getSession().beginTransaction();
						s.rollback();
						JViewport viewport = ((JScrollPane) t.getComponent(0)).getViewport(); 
						GDatiDistintaTable v = (GDatiDistintaTable) viewport.getView();
						GDatiDistintaModel m = (GDatiDistintaModel) v.getModel();
						PersistentSession sess = CoedilPersistentManager.instance().getSession(); 
						for(int i=0; i<m.getModifiche().size(); ++i){
							if(m.getModifiche().get(i) != null)
								sess.refresh(m.getModifiche().get(i));
						}
						t.remove(0);
						t.add(new JScrollPane(new GDatiDistintaTable(d)));
						f.validate();
						f.repaint();}
				} catch (PersistentException e) {
					e.printStackTrace();
				}
			}
		});
		nLine = new Button("New line");
		nLine.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Geometria g = GeometriaFactory.createGeometria();
				g.save();
				RigaLavoro r = RigaLavoroFactory.createRigaLavoro();
				r.setGeometria(g);
				r.save();
				d.getLavori().righe.add(r);
				d.getLavori().save();
				d.save();
				t.remove(0);
				t.add(new JScrollPane(new GDatiDistintaTable(d)));
				f.validate();
				f.repaint();
			}
		});
		this.visDdo = new Button("Visualizza DDO");
		this.visDdo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				f.setVisible(false);
				final GDocOtt frameDocOtt = new GDocOtt(d,codice);
			}
		});
		

		this.ottimizza = new Button("Ottimizza");
		
		if(d.getDdo() != null){
			ottimizza.setEnabled(false);
			visDdo.setVisible(true);
		}
		else{
			ottimizza.setEnabled(true);
			visDdo.setVisible(false);
		}
		//if (gch.getCommessaByCodiceInterno(index.toString()).getDistinta() == null)
			//this.ottimizza.setVisible(false);
		this.ottimizza.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				//gch.getCommessaByCodiceInterno(index.toString()).getOdistinta().creaDDO();
				ODistinta o = new ODistinta(d);
				o.creaDDO();
				visDdo.setVisible(true);
				ottimizza.setEnabled(false);
				nLine.setEnabled(false);
				doc.validate();
				doc.repaint();
			}
		});

		doc.add(save);
		doc.add(cancel);
		doc.add(nLine);
		doc.add(ottimizza);
		doc.add(visDdo);

		f.getContentPane().add(doc, BorderLayout.SOUTH);
		f.setVisible(true);
	}
}
