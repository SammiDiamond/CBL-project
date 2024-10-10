package colorBingo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ColorBingo extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    JLabel menu = new JLabel();

    JButton start = new JButton();
    JFrame game = new JFrame();

    JButton history = new JButton();
    JFrame gameHistory = new JFrame();

    JButton rule = new JButton();
    JFrame ruleCustomize = new JFrame();

    Font customFont = new Font("Monospaced", Font.ITALIC, 15);

    ColorBingo() {

        JLabel pic = new JLabel(new ImageIcon(
                "D:\\programming\\CBL\\Materials\\pics\\elements\\ColorBingo.png"));
        pic.setSize(1200, 550);

        JLabel backGround = new JLabel(
                new ImageIcon("D:\\programming\\CBL\\Materials\\pics\\elements\\background.png"));
        backGround.setSize(1200, 850);

        ImageIcon gridIcon = new ImageIcon(ColorBingo.class.getClassLoader().getResource(
                "CBL-project\\CBL\\Materials\\pics\\elements\\gridicon.png"));

        ImageIcon calanderIcon = new ImageIcon(ColorBingo.class.getClassLoader().getResource(
                "CBL-project\\CBL\\Materials\\pics\\elements\\calanderIcon.png"));

        ImageIcon ruleCustomizeIcon = new ImageIcon(ColorBingo.class.getClassLoader().getResource(
                "CBL-project\\CBL\\Materials\\pics\\elements\\rulecustomize.png"));

        game.setBounds(0, 0, 1200, 700);
        game.setVisible(false);

        start.setText("StartGame");
        start.setIcon(gridIcon);
        start.setFocusable(false);
        // remove the frame around components in the button
        start.setHorizontalTextPosition(JButton.LEFT);
        start.setBounds(450, 460, 300, 40);
        start.setBorder(BorderFactory.createRaisedBevelBorder());
        start.addActionListener(this);
        start.setFont(customFont);
        start.setIconTextGap(90);
        // startGame.setForeground(Color.black);
        start.setBackground(Color.pink);
        // startGame.setEnabled(false);
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("startGame");
                game.setVisible(true);
            }
        });

        history.setText("History");
        history.setIcon(calanderIcon);
        history.setFocusable(false);
        history.setHorizontalTextPosition(JButton.LEFT);
        history.setBounds(450, 520, 300, 40);
        history.setBorder(BorderFactory.createRaisedBevelBorder());
        history.setFont(customFont);
        history.setIconTextGap(105);
        history.setBackground(Color.orange);

        rule.setText("Rule Customization");
        rule.setIcon(ruleCustomizeIcon);
        rule.setFocusable(false);
        rule.setHorizontalTextPosition(JButton.LEFT);
        rule.setBounds(450, 580, 300, 40);
        rule.setBorder(BorderFactory.createRaisedBevelBorder());
        rule.setFont(customFont);
        rule.setIconTextGap(5);
        rule.setBackground(Color.yellow);

        frame.setTitle("ColorBingo");
        frame.setBounds(0, 0, 1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(pic);
        frame.add(menu);
        frame.setVisible(true);
        frame.add(backGround);

        menu.setLayout(null);
        menu.add(start);
        menu.add(history);
        menu.add(rule);
        menu.add(game);
    }
    /*
     * @Override
     * public void actionPerformed(ActionEvent c) {
     * if (c.getSource() == history) {
     * System.out.println("historyReady");
     * gameHistory.setVisible(true);
     * }
     * }
     */

    public static void main(String[] args) {
        new ColorBingo();
    }
}
