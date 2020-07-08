
import org.apache.log4j.Logger;
import lombok.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;


@Getter
@Setter
public class SwingGUI { // здесь было наследование от Listener
    private static final Logger LOGGER = Logger.getLogger(SwingGUI.class);

    private JFrame frame, resultFrame;
    private JLabel label;
    private JButton buttonSum, buttonSub, buttonLength, buttonAngle, buttonReset;
    private JTextField vector1x, vector1y, vector2x, vector2y;


    SwingGUI(){
        this.frame = new JFrame("Vectors");
        frame.setSize(500,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.resultFrame = new JFrame("Result");
        resultFrame.setSize(250,100);
        resultFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.label = new JLabel("Empty");
        //label.setBounds(100,400,250,50);
        buttonSum = new JButton("Сумма");
        buttonSum.setBounds(25,100,80,40);
        //buttonSum.addActionListener(this);
        buttonSum.addActionListener(this::actionPerformed);
        buttonSub = new JButton("Разница");
        buttonSub.setBounds(25,200,80,40);
        //buttonSub.addActionListener(this);
        buttonSub.addActionListener(this::actionPerformed);
        buttonLength = new JButton("Длина");
        buttonLength.setBounds(125,100,80,40);
        //buttonLength.addActionListener(this);
        buttonLength.addActionListener(this::actionPerformed);
        buttonAngle = new JButton("Угол");
        buttonAngle.setBounds(125,200,80,40);
        //buttonAngle.addActionListener(this);
        buttonAngle.addActionListener(this::actionPerformed);
        buttonReset = new JButton("Reset");
        buttonReset.setBounds(25, 300, 80, 40);
        //buttonReset.addActionListener(this);
        buttonReset.addActionListener(this::actionPerformed);
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
        resultFrame.add(label);
        //frame.setLayout(new SpringLayout());
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event){
        String command = event.getActionCommand();
        switch (command) {
            case "Сумма" -> {
                if(!errorEmptyBox(true)){
                    errorBox(false);
                    break;
                }
                Vector vectorSum1 = new Vector(Integer.parseInt(vector1x.getText().replaceAll("\\s+","")), Integer.parseInt(vector1y.getText().replaceAll("\\s+","")));
                Vector vectorSum2 = new Vector(Integer.parseInt(vector2x.getText().replaceAll("\\s+","")), Integer.parseInt(vector2y.getText().replaceAll("\\s+","")));
                resultFrame();
                label.setText(Vector.getSumOfVector(vectorSum1, vectorSum2).toString());
            }
            case "Разница" -> {
                if(!errorEmptyBox(true)){
                    errorBox(false);
                    break;
                }
                Vector vectorSub1 = new Vector(Integer.parseInt(vector1x.getText().replaceAll("\\s+","")), Integer.parseInt(vector1y.getText().replaceAll("\\s+","")));
                Vector vectorSub2 = new Vector(Integer.parseInt(vector2x.getText().replaceAll("\\s+","")), Integer.parseInt(vector2y.getText().replaceAll("\\s+","")));
                resultFrame();
                label.setText(Vector.getSubtractionOfVector(vectorSub1, vectorSub2).toString());
            }
            case "Длина" -> {
                if(!errorEmptyBox(false)){
                    errorBox(false);
                    break;
                }
                Vector vectorLength = new Vector((Integer.parseInt(vector1x.getText().replaceAll("\\s+",""))), Integer.parseInt(vector1y.getText().replaceAll("\\s+","")));
                resultFrame();
                label.setText(String.valueOf(Vector.getVectorLength(vectorLength)));
            }
            case "Угол" -> {
                if((vector1x.getText().equals("0") && vector1y.getText().equals("0") || (vector2x.getText().equals("0") && vector2y.getText().equals("0")))){
                    errorBox(true);
                    break;
                }
                if(!errorEmptyBox(true)){
                    errorBox(false);
                    break;
                }
                Vector vectorAngle1 = new Vector((Integer.parseInt(vector1x.getText().replaceAll("\\s+",""))), Integer.parseInt(vector1y.getText().replaceAll("\\s+","")));
                Vector vectorAngle2 = new Vector((Integer.parseInt(vector2x.getText().replaceAll("\\s+",""))), Integer.parseInt(vector2y.getText().replaceAll("\\s+","")));
                //LOGGER.info(String.valueOf(Vector.getAngleBetweenVectors(vectorAngle1, vectorAngle2)));
                //LOGGER.info(Vector.getAngleBetweenVectors(vectorAngle1, vectorAngle2));
                resultFrame();
                try{
                    label.setText(String.valueOf(Vector.getAngleBetweenVectors(vectorAngle1, vectorAngle2)));
                } catch (Exception e) {
                    LOGGER.error("error : ",e);
                }
            }
            case "Reset" -> {
                vector1x.setText("vector 1 x");
                vector1y.setText("vector 1 y");
                vector2x.setText("vector 2 x");
                vector2y.setText("vector 2 y");
            }
        }
    }

    private void resultFrame(){
        this.resultFrame.setVisible(true);
    }

    private void errorBox(boolean angleFlag)
    {
        if(angleFlag){
            JOptionPane.showMessageDialog(null, "Нельзя посчитать угол с нулевым вектором");
        }
        else {
            JOptionPane.showMessageDialog(null, "Заполните пожалуйста все нужные поля числами");
        }
    }
    private boolean errorEmptyBox(boolean fourVectors){

        if(fourVectors){
            return vector1x.getText().matches("-?\\d+(\\.\\d+)?") && vector1y.getText().matches("-?\\d+(\\.\\d+)?") && vector2x.getText().matches("-?\\d+(\\.\\d+)?") && vector2y.getText().matches("-?\\d+(\\.\\d+)?");
        } else {
            return vector1x.getText().matches("-?\\d+(\\.\\d+)?") && vector1y.getText().matches("-?\\d+(\\.\\d+)?");
        }
    }

}