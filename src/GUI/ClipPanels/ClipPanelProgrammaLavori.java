package GUI.ClipPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import GUI.CoedilFrame;
import GUI.PanelStart;
import GUI.ProgrammaLavori;
import GUI.RaccoglitorePlichi;
import GUI.Abstract.AClipPanel;
import GUI.Abstract.APlico;
import GUI.Plichi.PlicoCommessa;
import GUI.Plichi.PlicoCreaCommessa;
import GUI.Plichi.PlicoDDO;
import GUI.Plichi.PlicoDistinta;
import coedil99.model.MDistinta;

/**
 * 
 * @author francesco
 * 
 *         Implementazione di ACLipPanel per il menù in alto del programma
 *         lavori
 */
public class ClipPanelProgrammaLavori extends AClipPanel {

        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        /**
         * Costruttore
         */
        public ClipPanelProgrammaLavori() {
                super();
                this.initialize();
        }

        /**
         * Imposta la grafica e i bottoni del particolare clip panel
         */
        private void initialize() {
                this.addButton("Menu", "Torna al Menu Principale",
                                new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                                if (!ClipPanelProgrammaLavori.this.clickDuringModify()) {
                                                        return;
                                                }
                                                CoedilFrame cf = CoedilFrame.getInstance();
                                                PanelStart pl = PanelStart.getInstance();
                                                pl.setBounds(0, 0, cf.getWidth(), cf.getHeight());
                                                CoedilFrame.getInstance().montaPanel(pl);
                                        }
                                });
                this.addButton("Commessa", "Vai alla Commessa", new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                                if (!ClipPanelProgrammaLavori.this.clickDuringModify()) {
                                        return;
                                }
                                ProgrammaLavori.getInstance().getRaccoglitorePlichi()
                                                .changePlico(PlicoCommessa.getInstance());
                                ClipPanelProgrammaLavori.this.focusOut();
                                JButton b = (JButton) e.getSource();
                                b.setBackground(AClipPanel.getColoreSelezionato());
                                RaccoglitorePlichi.getInstance().validate();
                                RaccoglitorePlichi.getInstance().repaint();
                        }

                });
                this.addButton("Distinta", "Vai alla distinta", new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                                if (!ClipPanelProgrammaLavori.this.clickDuringModify()) {
                                        return;
                                }
                                ProgrammaLavori.getInstance().getRaccoglitorePlichi()
                                                .changePlico(PlicoDistinta.getInstance());
                                ClipPanelProgrammaLavori.this.focusOut();
                                JButton b = (JButton) e.getSource();
                                b.setBackground(AClipPanel.getColoreSelezionato());
                                RaccoglitorePlichi.getInstance().validate();
                                RaccoglitorePlichi.getInstance().repaint();
                        }
                });
                this.addButton("DDO", "Vai al DDO", new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                                if (!ClipPanelProgrammaLavori.this.clickDuringModify()) {
                                        return;
                                }
                                MDistinta odistinta = new MDistinta(ProgrammaLavori
                                                .getInstance().getCommessaSelezionata()
                                                .getPersistentModel().getDistinta().getID());
                                if (odistinta.hasDdo()) {
                                        ClipPanelProgrammaLavori.this.focusOut();
                                        JButton b = (JButton) e.getSource();
                                        b.setBackground(AClipPanel.getColoreSelezionato());
                                        ProgrammaLavori.getInstance().getRaccoglitorePlichi()
                                                        .changePlico(PlicoDDO.getInstance());
                                } else {
                                        Object[] options = { "Si", "No" };
                                        int n = JOptionPane.showOptionDialog(
                                                        ProgrammaLavori.getInstance(),
                                                        "Il DDO non esiste.\nVuoi elaborare l'ottimizzazione?\n"
                                                                        + "Nota: questa operazione non è reversibile",
                                                        "Conferma operazione",
                                                        JOptionPane.YES_NO_CANCEL_OPTION,
                                                        JOptionPane.QUESTION_MESSAGE, null, options,
                                                        options[1]);
                                        if (n == JOptionPane.YES_OPTION) {
                                                odistinta.creaDDO();
                                                ProgrammaLavori.getInstance().getRaccoglitorePlichi()
                                                                .changePlico(PlicoDDO.getInstance());
                                                ((JButton) e.getSource()).doClick();
                                        }
                                }
                                RaccoglitorePlichi.getInstance().validate();
                                RaccoglitorePlichi.getInstance().repaint();
                        }
                });
                this.addButton("Nuova Commessa", "Crea una nuova Commessa",
                                new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                                if (!ClipPanelProgrammaLavori.this.clickDuringModify()) {
                                                        return;
                                                }
                                                PlicoCreaCommessa.getInstance().resetAll();
                                                ProgrammaLavori.getInstance().getRaccoglitorePlichi()
                                                                .changePlico(PlicoCreaCommessa.getInstance());
                                                ClipPanelProgrammaLavori.this.focusOut();
                                                ProgrammaLavori.getInstance().ListaCommesse().deselectAll();
                                                JButton b = (JButton) e.getSource();
                                                b.setBackground(AClipPanel.getColoreSelezionato());
                                                RaccoglitorePlichi.getInstance().validate();
                                                RaccoglitorePlichi.getInstance().repaint();
                                        }
                                });
                this.fill();
                this.resetInitialState();
        }

        /**
         * Fornisce true o false a seconda se, durante la modifica di un plico,
         * stiamo andando in focus su altri bottoni
         * 
         * @return bool:boolean
         */
        public boolean clickDuringModify() {
                if (((APlico) RaccoglitorePlichi.getInstance().getPlico_container()
                                .getComponent(0)).isModifying()) {
                        Object[] options = { "Si", "No" };
                        int n = JOptionPane.showOptionDialog(null,
                                        "Sicuro di voler abbandonare la modifica?\n"
                                                        + "Nota: Le modifiche non salvate andranno perse",
                                        "Conferma operazione", JOptionPane.YES_NO_CANCEL_OPTION,
                                        JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                        if (n == JOptionPane.YES_OPTION) {
                                return true;
                        } else {
                                return false;
                        }
                }
                return true;
        }

}