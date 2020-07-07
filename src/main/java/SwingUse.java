import lombok.extern.java.Log;
import org.apache.log4j.Logger;
import lombok.*;
import org.apache.log4j.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.IntStream;


@Getter
@Setter
public class SwingUse implements ActionListener {

    private static final Logger LOGGER = Logger.getLogger(SwingUse.class);

    private boolean newInput;
    private JFrame frame;
    private JLabel label;
    private JButton buttonSum, buttonSub, buttonLength, buttonAngle, buttonReset;
    private JTextField vector1x, vector1y, vector2x, vector2y;

    SwingUse(){
        this.frame = new JFrame("Vectors");
        frame.setSize(500,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.label = new JLabel("Empty");
        label.setBounds(100,400,250,50);
        buttonSum = new JButton("Сумма");
        buttonSum.setBounds(25,100,75,60);
        buttonSum.addActionListener(this);
        buttonSub = new JButton("Разница");
        buttonSub.setBounds(25,200,75,60);
        buttonSub.addActionListener(this);
        buttonLength = new JButton("Длина");
        buttonLength.setBounds(125,100,75,60);
        buttonLength.addActionListener(this);
        buttonAngle = new JButton("Угол");
        buttonAngle.setBounds(125,200,75,60);
        buttonAngle.addActionListener(this);
        buttonReset = new JButton("Reset");
        buttonReset.setBounds(25, 300, 75, 60);
        buttonReset.addActionListener(this);
        vector1x = new JTextField("vector 1 x");
        vector1x.setBounds(10,1,85,40);
        vector1y = new JTextField("vector 1 y");
        vector1y.setBounds(10,50,85,40);
        vector2x = new JTextField("vector 2 x");
        vector2x.setBounds(100,1,85,40);
        vector2y = new JTextField("vector 2 y");
        vector2y.setBounds(100,50,85,40);
        frame.add(buttonSum);
        frame.add(buttonSub);
        frame.add(buttonLength);
        frame.add(buttonAngle);
        frame.add(buttonReset);
        frame.add(vector1x);
        frame.add(vector1y);
        frame.add(vector2x);
        frame.add(vector2y);
        frame.add(label);
        frame.setLayout(new SpringLayout());
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        switch (command) {
            case "Сумма" -> {
                Vector vectorSum1 = new Vector(Integer.parseInt(vector1x.getText()), Integer.parseInt(vector1y.getText()));
                Vector vectorSum2 = new Vector(Integer.parseInt(vector2x.getText()), Integer.parseInt(vector2y.getText()));
                label.setText(Vector.getSumOfVector(vectorSum1, vectorSum2).toString());
            }
            case "Разница" -> {
                Vector vectorSub1 = new Vector(Integer.parseInt(vector1x.getText()), Integer.parseInt(vector1y.getText()));
                Vector vectorSub2 = new Vector(Integer.parseInt(vector2x.getText()), Integer.parseInt(vector2y.getText()));
                label.setText(Vector.getSubtractionOfVector(vectorSub1, vectorSub2).toString());
            }
            case "Длина" -> {
                Vector vectorLength = new Vector((Integer.parseInt(vector1x.getText())), Integer.parseInt(vector1y.getText()));
                label.setText(String.valueOf(Vector.getVectorLength(vectorLength)));
            }
            case "Угол" -> {
                Vector vectorAngle1 = new Vector((Integer.parseInt(vector1x.getText())), Integer.parseInt(vector1y.getText()));
                Vector vectorAngle2 = new Vector((Integer.parseInt(vector2x.getText())), Integer.parseInt(vector2y.getText()));
                LOGGER.info(String.valueOf(Vector.getAngleBetweenVectors(vectorAngle1, vectorAngle2)));
                LOGGER.info(Vector.getAngleBetweenVectors(vectorAngle1, vectorAngle2));
                label.setText(String.valueOf(Vector.getAngleBetweenVectors(vectorAngle1, vectorAngle2)));
            }
            case "Reset" -> {
                vector1x.setText("vector 1 x");
                vector1y.setText("vector 1 y");
                vector2x.setText("vector 2 x");
                vector2y.setText("vector 2 y");
                label.setText(" ");
                break;
            }
        }
    }

}