package GUIElaboraDistinta;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class GHome {

	private JFrame frame;
	private final Button button = new Button("Programma Lavori");
	private JPanel panel;
	private JPanel pl;

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
		frame.setBounds(100, 100, 549, 326);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1, 1);
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		button.setBounds(215, 5, 119, 23);
		panel.add(button);
		frame.getContentPane().add(panel);
		//frame.getContentPane().add(panel_1);
		this.pl = new programmaLavori();
		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				frame.getContentPane().remove(panel);
				frame.getContentPane().add( pl );
				pl.setBounds(0, 0, frame.getWidth(), frame.getHeight());
				frame.validate();
				frame.repaint();

			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

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
				pl.setBounds(0, 0, frame.getWidth(), frame.getHeight());
				button.setLocation(panel.getWidth()/2-button.getWidth()/2, panel.getHeight()/2-button.getHeight()/2);
				frame.validate();
				frame.repaint();		
			}

			@Override
			public void componentShown(ComponentEvent arg0) {

			}
			
		});
	}

}
