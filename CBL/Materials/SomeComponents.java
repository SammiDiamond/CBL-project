import java.awt.*;
import javax.swing.*;

public class SomeComponents {
    JFrame frame;
    JButton okButton;
    JButton nokButton;
    JLabel label;
    JPanel panel;
    JTextField field;

    SomeComponents() {
        // Create the frame, which is a window
        frame = new JFrame("Some Components");

        // Create components, i.e., subclasses of JComponent
        ImageIcon image = new ImageIcon("huus.jpeg");
        label = new JLabel(image);
        field = new JTextField("Don't press these buttons!");
        okButton = new JButton("Ok");
        nokButton = new JButton("Not Ok");
        panel = new JPanel();
    }

    void setupGui() {
        frame.add(panel); 
        
        frame.add(okButton, BorderLayout.SOUTH);
        frame.add(nokButton, BorderLayout.WEST);
        
        Color yellow = new Color(255, 255, 0);
        panel.setBackground(yellow);

        panel.add(label);

        frame.add(field, BorderLayout.NORTH);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SomeComponents().setupGui();
    }   
}
