package GUIElaboraDistinta;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Button;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Label;
import java.util.Calendar;

import ElaboraDistinta.StartUp;
import GUIElaboraDistinta.GDistinta;
import GUIElaboraDistinta.GProgLavori;



public class GHome {

	private JFrame frame;
	private final Button button = new Button("Programma Lavori");
	private JPanel panel;
	private GProgLavori pl;
	private GDistinta d;
	private Button start_up;
	private Button distinta;
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
		frame = new JFrame();
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

		
		/**Button Chiudi = new Button("X");
		Chiudi.setBounds((xSize-30), 0, 29, 22);
		frame.getContentPane().add(Chiudi);
		Chiudi.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				frame.dispose();}}
		);
		Button Minimizza = new Button("_");
		Minimizza.setBounds((xSize-60), 0, 29, 22);
		frame.getContentPane().add(Minimizza);
		Minimizza.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				frame.setState(Frame.ICONIFIED);}}
		);**/
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 543, 298);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		button.setBounds(153, 135, 139, 22);
		panel.add(button);
		
		start_up = new Button("Start Up");
		start_up.setBounds(311, 135, 100, 22);
		panel.add(start_up);
		
		distinta = new Button("Distinta");
		distinta.setBounds(400, 135, 53, 22);
		panel.add(distinta);
		
		
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
				start_up.setLocation(panel.getWidth()/2-start_up.getWidth()/2+button.getWidth(), panel.getHeight()/2-start_up.getHeight()/2);
				frame.validate();
				frame.repaint();		
			}

			@Override
			public void componentShown(ComponentEvent arg0) {

			}
			
		});
			
		start_up.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				StartUp s = StartUp.getInstance();
				ordineG.setText(s.gch.getCommessaById(1).getDistinta().getRigheLavoro().get(0).getNote());
				dataI.setText(s.o.getDataInizio().get(Calendar.DATE)+"/"+s.o.getDataInizio().get(Calendar.MONTH)+"/"+s.o.getDataInizio().get(Calendar.YEAR));
				dataF.setText(s.o.getDataFine().get(Calendar.DATE)+"/"+s.o.getDataScadenza().get(Calendar.MONTH)+"/"+s.o.getDataFine().get(Calendar.YEAR));
				panel.add(lblOrdineGestionale);
				panel.add(ordineG);
				panel.add(lblDataInizioCommessa);
				panel.add(dataI);
				panel.add(lblDataFineCommessa);
				panel.add(dataF);
				
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
		
		distinta.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				StartUp s = StartUp.getInstance();
				d = new GDistinta();
				frame.remove(panel);
				d.setBounds(0, 0, frame.getWidth(), frame.getHeight());
				frame.getContentPane().add(d);
				frame.validate();
				frame.repaint();}
		});
				

		
		
		


	}
}
