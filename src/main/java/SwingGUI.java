
import org.apache.log4j.Logger;
import lombok.*;
import javax.swing.*;
import java.awt.*;
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
        frame.setSize(300,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.resultFrame = new JFrame("Result");
        resultFrame.setSize(250,100);
        resultFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        this.label = new JLabel("Empty");

        buttonSum = new JButton("Сумма");
        buttonSum.addActionListener(this::actionPerformed);
        buttonSub = new JButton("Разница");
        buttonSub.addActionListener(this::actionPerformed);
        buttonLength = new JButton("Длина");
        buttonLength.addActionListener(this::actionPerformed);
        buttonAngle = new JButton("Угол");
        buttonAngle.addActionListener(this::actionPerformed);
        buttonReset = new JButton("Reset");
        buttonReset.addActionListener(this::actionPerformed);

        vector1x = new JTextField("   vector 1 x   ");
        vector1y = new JTextField("   vector 1 y   ");
        vector2x = new JTextField("   vector 2 x   ");
        vector2y = new JTextField("   vector 2 y   ");

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
        resultFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 25 ,25));
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event){
        String command = event.getActionCommand();
        switch (command) {
            case "Сумма" -> {
                if(!checkForErrorEmptyBox(true)){
                    errorBox(false);
                    break;
                }
                Vector vectorSum1 = new Vector(Integer.parseInt(vector1x.getText()), Integer.parseInt(vector1y.getText()));
                Vector vectorSum2 = new Vector(Integer.parseInt(vector2x.getText()), Integer.parseInt(vector2y.getText()));
                label.setText("New " + Vector.getSumOfVector(vectorSum1, vectorSum2).toString());
                resultFrame();
            }
            case "Разница" -> {
                if(!checkForErrorEmptyBox(true)){
                    errorBox(false);
                    break;
                }
                Vector vectorSub1 = new Vector(Integer.parseInt(vector1x.getText()), Integer.parseInt(vector1y.getText()));
                Vector vectorSub2 = new Vector(Integer.parseInt(vector2x.getText()), Integer.parseInt(vector2y.getText()));
                label.setText("New " + Vector.getSubtractionOfVector(vectorSub1, vectorSub2).toString());
                resultFrame();
            }
            case "Длина" -> {
                if(!checkForErrorEmptyBox(false)){
                    errorBox(false);
                    break;
                }
                Vector vectorLength = new Vector((Integer.parseInt(vector1x.getText())), Integer.parseInt(vector1y.getText()));
                label.setText("Длина = "+ Vector.getVectorLength(vectorLength));
                resultFrame();
            }
            case "Угол" -> {
                if((vector1x.getText().equals("0") && vector1y.getText().equals("0") ||
                        (vector2x.getText().equals("0") && vector2y.getText().equals("0")))){
                    errorBox(true);
                    break;
                }
                if(!checkForErrorEmptyBox(true)){
                    errorBox(false);
                    break;
                }
                Vector vectorAngle1 = new Vector((Integer.parseInt(vector1x.getText())), Integer.parseInt(vector1y.getText()));
                Vector vectorAngle2 = new Vector((Integer.parseInt(vector2x.getText())), Integer.parseInt(vector2y.getText()));
                try{
                    label.setText("Угол = "+ Vector.getAngleBetweenVectors(vectorAngle1, vectorAngle2));
                } catch (Exception e) {
                    LOGGER.error("error : ",e);
                }
                resultFrame();
            }
            case "Reset" -> {
                vector1x.setText("   vector 1 x   ");
                vector1y.setText("   vector 1 y   ");
                vector2x.setText("   vector 2 x   ");
                vector2y.setText("   vector 2 y   ");
                resultFrame.setVisible(false);
                resultFrame.dispose();
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
    private boolean checkForErrorEmptyBox(boolean fourVectors){
        vector1x.setText(vector1x.getText().replaceAll("\\s+","")); //убираем пробелы
        vector1y.setText(vector1y.getText().replaceAll("\\s+",""));
        vector2x.setText(vector2x.getText().replaceAll("\\s+",""));
        vector2y.setText(vector2y.getText().replaceAll("\\s+",""));
        if(fourVectors){
            return (vector1x.getText().matches("-?\\d+(\\.\\d+)?") &&
                    vector1y.getText().matches("-?\\d+(\\.\\d+)?") &&
                    vector2x.getText().matches("-?\\d+(\\.\\d+)?") &&
                    vector2y.getText().matches("-?\\d+(\\.\\d+)?")); //проверяем, если есть цифры
        } else {
            return vector1x.getText().matches("-?\\d+(\\.\\d+)?") &&
                    vector1y.getText().matches("-?\\d+(\\.\\d+)?");
        }
    }

}