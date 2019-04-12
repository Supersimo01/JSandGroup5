import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * @version 0.1
 * @author gruppo 5
 */

class swingCode {

    private JFrame frame;
    private JButton pickColor;
    private dataStorage dataStorage;
    
    public swingCode(dataStorage datiC) {
        this.dataStorage = datiC;
        frame = new JFrame("Controls");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // a panel where add buttons with flow layout
        JPanel controls = new JPanel();
        controls.setLayout(new FlowLayout());

        // define the button to choose color background
        pickColor = new JButton("Colore ...");
        pickColor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Color color = JColorChooser.showDialog(pickColor, "Color Picker", Color.RED);
                //dataStorage.setColor(color.getRed(), color.getGreen(), color.getBlue());
            }
        });

        // define the button to show the animated figure
        JButton incBtn = new JButton("Incrementa");
        incBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               dataStorage.incVel();
            }
        });
        
        // define the button to hide the animated figure
        JButton delBtn = new JButton("Decrementa");
        delBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               dataStorage.decVel();
            }
        });

        // add the buttons to the panel
        controls.add(pickColor);
        controls.add(incBtn);
        controls.add(delBtn);
        // add the panel to the frame
        frame.add(controls);
        frame.setSize(400, 80);
    }

    public void show() {
        frame.setVisible(true);
    }
}
