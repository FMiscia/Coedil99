package GUIelaboradistinta;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Button;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Label;

import GUIelaboradistinta.GProgLavori;



public class GHome {

	private JFrame frame;
	private final Button button = new Button("Programma Lavori");
	private static JPanel panel;
	private static GProgLavori pl;
	final Label ordineG = new Label("");
	final Label dataI = new Label("");
	final Label dataF = new Label("");
	final Label lblOrdineGestionale = new Label();
	final Label lblDataInizioCommessa = new Label();
	final Label lblDataFineCommessa = new Label();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GHome window = new GHome();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Coedil99");
		frame.setResizable(false);
		frame.setBounds(100, 100, 549, 326);
		Toolkit tk = Toolkit.getDefaultToolkit(); 
		
//		Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize();
//		Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
//		int taskBarHeight = scrnSize.height - winSize.height;
		
		int xSize = ((int) tk.getScreenSize().getWidth()); 
		int ySize = ((int) tk.getScreenSize().getHeight()-55);
		frame.setSize(xSize,ySize); 
		//Centraggio della finestra
		Dimension screenSize = tk.getScreenSize();
		Dimension frameSize = frame.getSize ();
		frame.setLocation ((screenSize.width - frameSize.width) / 2,(screenSize.height - frameSize.height) / 2);	

		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 543, 298);
		panel.setName("primo");
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout());
		button.setBounds(153, 135, 139, 22);
		panel.add(button, BorderLayout.NORTH  );
		
		
		
		pl = new GProgLavori();
		
		ordineG.setBounds(10, 57, 300, 22);
		dataI.setBounds(10, 106, 300, 22);
		dataF.setBounds(10, 149, 300, 22);
		lblOrdineGestionale.setText("Commento prima riga lavoro");
		lblOrdineGestionale.setBounds(10, 37, 300, 14);
		lblDataInizioCommessa.setText("Data inizio Commessa");
		lblDataInizioCommessa.setBounds(10, 86, 300, 14);
		lblDataFineCommessa.setText("Data fine Commessa");
		lblDataFineCommessa.setBounds(10, 130, 300, 14);
		
		frame.addComponentListener(new ComponentListener(){

			@Override
			public void componentHidden(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentResized(ComponentEvent arg0) {
				panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
				button.setLocation(panel.getWidth()/2-button.getWidth()/2, panel.getHeight()/2-button.getHeight()/2);
				
				frame.validate();
				frame.repaint();		
			}

			@Override
			public void componentShown(ComponentEvent arg0) {

			}
			
		});
			
		
		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				frame.remove(panel);
				pl.setBounds(0, 0, frame.getWidth(), frame.getHeight());
				frame.getContentPane().add(pl);
				frame.validate();
				frame.repaint();		
			}
		});
		



	}
//	public static void monta( Component c ){
//		frame.remove(pl);
//		c.setBounds(0, 0, frame.getWidth(), frame.getHeight());
//		frame.getContentPane().add(c);
//		frame.validate();
//		frame.repaint();
//	}
}
