package GUI.Plichi;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import GUI.CoedilFrame;
import GUI.ProgrammaLavori;
import GUI.Abstract.APlico;
import GUI.Abstract.ARiquadro;
import GUI.Riquadri.RiquadroDatiAziendali;
import GUI.Riquadri.RiquadroDatiAziendaliFactory;
import GUI.Riquadri.RiquadroDatiClienteConsegna;
import GUI.Riquadri.RiquadroDatiClienteConsegnaFactory;
import GUI.Riquadri.RiquadroDatiConsegna;
import GUI.Riquadri.RiquadroDatiConsegnaFactory;
import GUI.Riquadri.RiquadroDatiProduzioneConsegna;
import GUI.Riquadri.RiquadroDatiProduzioneConsegnaFactory;
import GUI.Riquadri.RiquadroDatiSviluppoConsegna;
import GUI.Riquadri.RiquadroDatiSviluppoConsegnaFactory;
import coedil99.controller.GestisciClienteHandler;
import coedil99.controller.GestisciCommessaHandler;
import coedil99.controller.GestisciOrdineHandler;
import coedil99.model.MCliente;
import coedil99.model.MCommessa;
import coedil99.model.MOrdine;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

@SuppressWarnings("serial")
/**
 * 
 * @author francesco
 * Gestisce il pannello che si occupa di contenere 
 * i riquadri della commess
 */
public class PlicoCommessa extends APlico {

        private RiquadroDatiClienteConsegna rdcc;
        private RiquadroDatiAziendali rda;
        private RiquadroDatiConsegna rdc;
        private RiquadroDatiProduzioneConsegna rdpc;
        private RiquadroDatiSviluppoConsegna rsc;
        private ArrayList<ARiquadro> container;
        private JButton elimina;
        private static PlicoCommessa instance = null;

        /**
         * Costruttore
         */
        private PlicoCommessa() {
                this.initialize();
        }

        @Override
        public void load() {

        }

        @Override
        /**
         * Carica i riquadri
         * @param id:idCommessa
         */
        public void load(int id) {
                this.reset();
                MCommessa c = GestisciCommessaHandler.getInstance().getCommessaById(id);
                rda.load(c);
                rdcc.load(c);
                rdc.load(c);
                rdpc.load(c);
                rsc.load(c);
        }

        /**
         * Posiziona i riquadri nel plico
         */
        private void posizionaRiquadri() {
                int bounds = (CoedilFrame.getInstance().getBounds().width / 6);
                elimina.setBounds(bounds + (rda.getWidth() / 2)
                                - (elimina.getWidth() / 2), 20, elimina.getWidth(),
                                elimina.getHeight());
                rda.setBounds(bounds, elimina.getY() + elimina.getHeight() + 20,
                                rda.getWidth(), rda.getHeight());
                rdcc.setBounds(bounds, rda.getY() + rda.getHeight() + 20,
                                rdcc.getWidth(), rdcc.getHeight());
                rdc.setBounds(bounds, rdcc.getY() + rdcc.getHeight() + 20,
                                rdc.getWidth(), rdc.getHeight());
                rdpc.setBounds(bounds, rdc.getY() + rdc.getHeight() + 20,
                                rdpc.getWidth(), rdpc.getHeight());
                rsc.setBounds(bounds, rdpc.getY() + rdpc.getHeight() + 20,
                                rsc.getWidth(), rsc.getHeight());
                validate();
                repaint();

        }

        /**
         * Imposta la grafica
         */
        private void initialize() {
                setBorder(null);
                setLayout(null);
                container = new ArrayList<ARiquadro>();
                this.elimina = new JButton("Elimina");
                this.elimina.setSize(new Dimension(150, 30));
                this.elimina.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                                Object[] options = { "Si", "No" };
                                int n = JOptionPane
                                                .showOptionDialog(
                                                                null,
                                                                "Sicuro di voler eliminare la Commessa?\n"
                                                                                + "Nota: Questa operazione non è reversibile",
                                                                "Conferma operazione",
                                                                JOptionPane.YES_NO_CANCEL_OPTION,
                                                                JOptionPane.QUESTION_MESSAGE, null, options,
                                                                options[1]);
                                if (n == JOptionPane.YES_OPTION) {
                                        GestisciCommessaHandler
                                                        .getInstance()
                                                        .getCommesse()
                                                        .remove(ProgrammaLavori.getInstance()
                                                                        .getCommessaSelezionata());
                                        ProgrammaLavori.getInstance().getCommessaSelezionata()
                                                        .delete();
                                        ProgrammaLavori.getInstance().ListaCommesse()
                                                        .updatePanel();
                                        ProgrammaLavori.getInstance().setCommessaSelezionata(
                                                        new MCommessa(ProgrammaLavori.getInstance()
                                                                        .ListaCommesse().getPrimaCommessa()));
                                }

                        }
                });
                rda = (RiquadroDatiAziendali) RiquadroDatiAziendaliFactory
                                .getInstance().makeRiquadro();

                rda.addComponentListener(new ComponentAdapter() {
                        @Override
                        public void componentResized(ComponentEvent e) {
                                posizionaRiquadri();
                        }
                });
                rdcc = (RiquadroDatiClienteConsegna) RiquadroDatiClienteConsegnaFactory
                                .getInstance().makeRiquadro();
                rdc = (RiquadroDatiConsegna) RiquadroDatiConsegnaFactory.getInstance()
                                .makeRiquadro();
                rdpc = (RiquadroDatiProduzioneConsegna) RiquadroDatiProduzioneConsegnaFactory
                                .getInstance().makeRiquadro();
                rsc = (RiquadroDatiSviluppoConsegna) RiquadroDatiSviluppoConsegnaFactory
                                .getInstance().makeRiquadro();
                setPreferredSize(new Dimension(745, 1150));
                setSize(745, 950);
                posizionaRiquadri();
                add(elimina);
                add(rda);
                this.container.add(rda);
                add(rdcc);
                this.container.add(rdcc);
                rdcc.setLayout(new FormLayout(new ColumnSpec[] {}, new RowSpec[] {}));
                add(rdc);
                this.container.add(rdc);
                add(rdpc);
                this.container.add(rdpc);
                add(rsc);
                this.container.add(rsc);
        }

        /**
         * Singleton
         * 
         * @return instance:PlicoCommessa
         */
        public static PlicoCommessa getInstance() {
                if (PlicoCommessa.instance == null)
                        PlicoCommessa.instance = new PlicoCommessa();
                return PlicoCommessa.instance;
        }

        @Override
        /**
         * Metodo che controlla se è in corso una modifica dei riquadri
         * 
         * @return modifica: array list contenente i riquadri in modifica
         */
        public boolean isModifying() {
                ArrayList<ARiquadro> modifica = new ArrayList<ARiquadro>();
                for (ARiquadro a : this.container) {
                        if (!a.modify())
                                modifica.add(a);
                }
                boolean result = modifica.size()>0?true:false;
                return result;
        }

        /**
         * Riporta tutti i TextField del plico non editabili
         */
        public void reset() {
                this.rda.makeEditable(false);
                this.rdc.makeEditable(false);
                this.rdcc.makeEditable(false);
                this.rdpc.makeEditable(false);
                this.rsc.makeEditable(false);
        }

}