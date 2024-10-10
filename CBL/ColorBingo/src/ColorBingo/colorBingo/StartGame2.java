package colorBingo;

import javax.swing.JFrame;

public class StartGame2 {

    private JFrame frame;

    public StartGame2() {
        initialize();
    }

    public void initialize() {
        frame = new JFrame();
        this.frame.setTitle("StartGame2");
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setSize(500, 400);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(true);
        this.frame.setVisible(true);
    }
}
