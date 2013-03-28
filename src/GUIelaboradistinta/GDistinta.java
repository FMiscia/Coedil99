package GUIelaboradistinta;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.border.EmptyBorder;


import elaboradistinta.model.CoedilPersistentManager;
import elaboradistinta.model.Distinta;
import elaboradistinta.model.DocumentoOttimizzazione;
import elaboradistinta.model.Geometria;
import elaboradistinta.model.RigaLavoro;
import elaboradistinta.operation.ODistinta;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import GUIelaboradistinta.model.GDatiDistintaModel;
import GUIelaboradistinta.table.GDatiDistintaTable;

public class GDistinta {

	/**
	 * 
	 */
	private Button save;
	private Button cancel;
	private Button nLine;
	private Button ottimizza;
	private Button visDdo;
	private Button delDdo;
	private JFrame f;
	private	JPanel t = new JPanel();
	private	JPanel doc = new JPanel();

	/**
	 * Create the frame.
	 */
	public GDistinta(final Distinta d,final String codice) {

		f = new JFrame("Distinta "+ codice);
		f.setResizable(false);
		f.setBounds(100, 100, 600, 350);
		((JComponent) f.getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));
		f.getContentPane().setLayout(new BorderLayout(0, 0));
		t.add(new JScrollPane(new GDatiDistintaTable(d)));
		f.getContentPane().add(t);
		
		
		/**
		 * Pulsante per salvare le modifica
		 */
		save = new Button("Save");
		save.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				salvaModifiche(d);
			}
		});
		
		/**
		 * Pulsante per annullare le modifiche
		 */
		cancel = new Button("Reset");
		cancel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				GDatiDistintaModel m = getModel();
				try {
					int n = JOptionPane.showConfirmDialog(null,"Sicuro di voler annullare le modifiche?"
							,"Domanda",JOptionPane.YES_NO_OPTION);
					if(n == 0){
						if(m.getModifiche().get(0).size() == 0 && m.getModifiche().get(1).size() == 0)
							JOptionPane.showMessageDialog(null, "Nessuna modifica apportata");
						else{
							PersistentSession sess = CoedilPersistentManager.instance().getSession(); 
							for(int i=0; i<m.getModifiche().get(0).size(); ++i){
								if(m.getModifiche().get(0).get(i) != null)
									sess.refresh(m.getModifiche().get(0).get(i));
							}
							m.refresh();
							m.fireTableStructureChanged();
						}
					}
				} catch (PersistentException e) {
					e.printStackTrace();
				}
			}
		});
		nLine = new Button("New line");
		nLine.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				GDatiDistintaModel m = getModel();
				new newLine(m,d);
			}
		});
		this.visDdo = new Button("Visualizza DDO");
		this.visDdo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				f.setVisible(false);
				new GDocOtt(d,codice);
			}
		});
		

		this.ottimizza = new Button("Ottimizza");
		this.delDdo = new Button("Cancella DDO");
		this.delDdo.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				int n = JOptionPane.showConfirmDialog(null,"Sicuro di voler cancellare il DDO?"
						,"Attenzione",JOptionPane.YES_NO_OPTION);
				if(n == 0){
					DocumentoOttimizzazione ddo = d.getDdo();
					d.setDdo(null);
					d.save();
					ddo.delete();
					nLine.setEnabled(true);
					save.setEnabled(true);
					cancel.setEnabled(true);
					ottimizza.setEnabled(true);
					delDdo.setVisible(false);
					visDdo.setVisible(false);
					JViewport viewport = ((JScrollPane) t.getComponent(0)).getViewport(); 
					GDatiDistintaTable v = (GDatiDistintaTable) viewport.getView();
					v.abilitaModifica();
					f.validate();
					f.repaint();
				}
			}
		});
		
		
		if(d.getDdo() != null){
			ottimizza.setEnabled(false);
			visDdo.setVisible(true);
			nLine.setEnabled(false);
			save.setEnabled(false);
			cancel.setEnabled(false);
			delDdo.setVisible(true);
			JViewport viewport = ((JScrollPane) t.getComponent(0)).getViewport(); 
			GDatiDistintaTable v = (GDatiDistintaTable) viewport.getView();
			v.disabilitaModifica();
			f.validate();
			f.repaint();
		}
		else{
			ottimizza.setEnabled(true);
			delDdo.setVisible(false);
			visDdo.setVisible(false);
		}
		
		this.ottimizza.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				ODistinta o = new ODistinta(d);
				o.creaDDO();
				ottimizza.setEnabled(false);
				visDdo.setVisible(true);
				nLine.setEnabled(false);
				save.setEnabled(false);
				cancel.setEnabled(false);
				delDdo.setVisible(true);
				JViewport viewport = ((JScrollPane) t.getComponent(0)).getViewport(); 
				GDatiDistintaTable v = (GDatiDistintaTable) viewport.getView();
				v.disabilitaModifica();
				doc.validate();
				doc.repaint();
			}
		});

		doc.add(save);
		doc.add(cancel);
		doc.add(nLine);
		doc.add(ottimizza);
		doc.add(visDdo);
		doc.add(delDdo);

		f.getContentPane().add(doc, BorderLayout.SOUTH);
		f.setVisible(true);
	}
	
	public GDatiDistintaModel getModel(){
		JViewport viewport = ((JScrollPane) t.getComponent(0)).getViewport(); 
		GDatiDistintaTable v = (GDatiDistintaTable) viewport.getView();
		GDatiDistintaModel m = (GDatiDistintaModel) v.getModel();
		return m;
	}
	
	public void salvaModifiche(Distinta d){
		GDatiDistintaModel m = getModel();
			try {
				PersistentTransaction t = CoedilPersistentManager.instance().getSession().beginTransaction();
				for(int i=0; i<m.getModifiche().get(1).size(); ++i){
					RigaLavoro r =  (RigaLavoro) m.getModifiche().get(1).get(i);
					d.getLavori().righe.remove(r);
					Geometria g = r.getGeometria();
					r.delete();
					g.delete();
				}
				m.setModifiche(new ArrayList<ArrayList<Object>>());
				t.commit();
				JOptionPane.showMessageDialog(null,"Modifiche salvate correttamente");
			} catch (PersistentException e) {
				e.printStackTrace();
			}
	}
	
	public void salvaInserimento(RigaLavoro r){
		
	}
}
