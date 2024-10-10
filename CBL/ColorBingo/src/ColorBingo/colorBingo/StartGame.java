package colorBingo;

import javax.swing.JFrame;

public class StartGame extends JFrame {

    public StartGame() {// constrctor
        initialize();// method
    }

    public void initialize() {
        setTitle("StartGame");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }
}
