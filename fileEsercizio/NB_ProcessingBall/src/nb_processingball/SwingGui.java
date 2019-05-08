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
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author scuola
 */

public class SwingGui {
    
    /** indica il frame */
    private JFrame frame;

    /**
     * @brief Costruttore con un parametro che crea un frame, 4 bottoni, il pannello dove aggiungere i bottoni ed aggiunge il pannello alla finestra.
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

        JLabel labelIncX = new JLabel("Inclinazione asse x:");
        JLabel labelX = new JLabel("");
        
        //crea il pulsante per incrementare l'inclinazione
        JButton buttonIncInclinX = new JButton("Incrementa Inclinazione X");
        buttonIncInclinX.addActionListener(new ActionListener() {//quando viene pigiato

            @Override
            public void actionPerformed(ActionEvent e) {
               datiC.incInclinazioneX();//decrementa l'inclinazione x
               float inc = datiC.getInclinazioneY();
               labelX.setText(Float.toString(inc));//aggiorna la label con l'inclinazione corretta
            }
        });
        //crea il pulsante per decrementare l'inclinazione
        JButton buttonDecInclinX = new JButton("Decrementa Inclinazione X");
        buttonDecInclinX.addActionListener(new ActionListener() {//quando viene pigiato

            @Override
            public void actionPerformed(ActionEvent e) {
               datiC.decInclinazioneX();//decrementa l'inclinazione x
               float inc = datiC.getInclinazioneY();
               labelX.setText(Float.toString(inc));//aggiorna la label con l'inclinazione corretta
            }
        });
        
        JLabel labelIncY = new JLabel("Inclinazione asse y:");
        JLabel labelY = new JLabel("");
        //crea il pulsante per decrementare l'inclinazione
        JButton buttonIncInclinY = new JButton("Incrementa Inclinazione Y");
        buttonIncInclinY.addActionListener(new ActionListener() {//quando viene pigiato

            @Override
            public void actionPerformed(ActionEvent e) {
               datiC.incInclinazioneY();//incrementa l'inclinazione y
               float inc = datiC.getInclinazioneY();
               labelY.setText(Float.toString(inc));//aggiorna la label con l'inclinazione corretta
            }
        });
        
        //crea il pulsante per decrementare l'inclinazione
        JButton buttonDecInclinY = new JButton("Decrementa Inclinazione Y");
        buttonDecInclinY.addActionListener(new ActionListener() {//quando viene pigiato

            @Override
            public void actionPerformed(ActionEvent e) {
               datiC.decInclinazioneY();//decrementa l'inclinazione y
               float inc = datiC.getInclinazioneY();
               labelY.setText(Float.toString(inc));//aggiorna la label con l'inclinazione corretta
            }
        });
        //aggiunge i pulsanti al pannello
        controls.add(pickColor);
        controls.add(incBtn);
        controls.add(delBtn);
        controls.add(buttonIncInclinX);
        controls.add(buttonDecInclinX);
        controls.add(buttonIncInclinY);
        controls.add(buttonDecInclinY);
        controls.add(labelIncX);
        controls.add(labelX);
        controls.add(labelIncY);
        controls.add(labelY);
        //aggiunge il pannello nella finestra
        frame.add(controls);
        frame.setSize(400, 160);//imposta le dimensioni del pannello
    }

    /**
     * @brief Rende visibile la finestra.
     */
    public void show() {
        frame.setVisible(true);
    }
}
