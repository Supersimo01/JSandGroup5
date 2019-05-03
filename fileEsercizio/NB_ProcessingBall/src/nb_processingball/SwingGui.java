/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nb_processingball;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author scuola
 */

public class SwingGui {

    private JFrame frame;

    /**
     * @brief costruttore vuoto
     * @param datiC 
     */
    public SwingGui(DatiCondivisi datiC) {
        frame = new JFrame("Controls");//crea il frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//aggiunge l'evento per la chiusura
        
        //inserisce un pannello dove aggiungere elementi
        JPanel controls = new JPanel();
        controls.setLayout(new FlowLayout());

        //crea il bottone per selezionare il colore dello sfondo
        JButton pickColor = new JButton("Colore ...");
        pickColor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {//quando viene azionato il pulsante
                Color color = JColorChooser.showDialog(pickColor, "Color Picker", Color.RED);//si apre il pannello per selezionare il colore
                datiC.setColor(color.getRed(), color.getGreen(), color.getBlue());//si salva il colore selezionato
            }
        });

        //crea il pulsante per incrementare la velocità
        JButton incBtn = new JButton("Incrementa");
        incBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {//quando viene pigiato
               datiC.incVel();//incrementa la velocità
            }
        });
        
        //crea il pulsante per decrementare la velocità
        JButton delBtn = new JButton("Decrementa");
        delBtn.addActionListener(new ActionListener() {//quando viene pigiato

            @Override
            public void actionPerformed(ActionEvent e) {
               datiC.decVel();//decrementa la velocità
            }
        });

        //crea il pulsante per incrementare l'inclinazione
        JButton buttonIncInclin = new JButton("Incrementa Inclinazione");
        buttonIncInclin.addActionListener(new ActionListener() {//quando viene pigiato

            @Override
            public void actionPerformed(ActionEvent e) {
               datiC.incInclinazione();//decrementa l'inclinazione
            }
        });
        //crea il pulsante per decrementare l'inclinazione
        JButton buttonDecInclin = new JButton("Decrementa Inclinazione");
        buttonDecInclin.addActionListener(new ActionListener() {//quando viene pigiato

            @Override
            public void actionPerformed(ActionEvent e) {
               datiC.decInclinazione();//decrementa l'inclinazione
            }
        });
        
        //aggiunge i pulsanti al pannello
        controls.add(pickColor);
        controls.add(incBtn);
        controls.add(delBtn);
        controls.add(buttonIncInclin);
        controls.add(buttonDecInclin);
        //aggiunge il pannello nella finestra
        frame.add(controls);
        frame.setSize(400, 120);//imposta le dimensioni del pannello
    }

    /**
     * @brief rende visibile la finestra
     */
    public void show() {
        frame.setVisible(true);
    }
}
