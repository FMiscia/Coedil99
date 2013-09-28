package GUIelaborazione2;

public class ClipPanelProgrammaLavori extends ClipPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ClipPanelProgrammaLavori(){
		super();
	}
	
	@Override
	public void aggiornaClipPanel(Object t){
		// TODO Auto-generated method stub
				/*JButton btnHasDdo = new JButton("Visualizza DDO");
				JButton btnHasnotDdo = new JButton("Elabora DDO");
				btnHasDdo.setBounds(0, 67, 213, 25);
				btnHasnotDdo.setBounds(0, 67, 213, 25);
				btnHasDdo.setToolTipText("Visualizza Documento di Ottimizzazione");
				btnHasnotDdo.setToolTipText("Elabora Documento di Ottimizzazione");
				btnHasnotDdo.setPreferredSize(new Dimension(110, 25));
				btnHasDdo.setPreferredSize(new Dimension(110, 25));

				clipPanel.removeAll();
				menuButton.setText("Torna al menu");
				menuButton.setToolTipText("Torna al menu principale");
				menuButton.setHorizontalTextPosition(SwingConstants.LEFT);
				menuButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						CoedilFrame cf = CoedilFrame.getInstance();
						PanelStart pl = new PanelStart(cf);
						pl.setBounds(0, 0, cf.getWidth(), cf.getHeight());
						// cf.getContentPane().add(pl, BorderLayout.NORTH);
						// cf.validate();
						// cf.repaint();
						CoedilFrame.getInstance().montaPanel(pl);
					}
				});
				clipPanel.add(menuButton);
				clipPanel.add(commessaButton);
				clipPanel.add(distintaButton);

				if(oDistinta.hasDdo()){

					clipPanel.add(btnHasDdo);

					btnHasDdo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							changePlico(PlicoDDO.getInstance());
						}
					});
				} else {
					// System.out.println("non has ddo");
					clipPanel.add(btnHasnotDdo);

					btnHasnotDdo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JOptionPane confermaOtt = new JOptionPane();
							Object[] options = { "Si", "No" };
							int n = JOptionPane
									.showOptionDialog(
											RiquadroPlico.this,
											"Vuoi elaborare l'ottimizzazione?\n"
													+ "Nota: questa operazione non è reversibile",
											"Conferma operazione",
											JOptionPane.YES_NO_CANCEL_OPTION,
											JOptionPane.QUESTION_MESSAGE, null,
											options, options[1]);
							if (n == JOptionPane.YES_OPTION) {
								ProgrammaLavori.getInstance().getCommessaSelezionata()
										.getDistinta().creaDDO();
								changePlico(PlicoDDO.getInstance());
							}
						}
					});
				}
				clipPanel.add(btnNewButton_6);
				clipPanel.validate();
				clipPanel.repaint();*/
	}
	

}
