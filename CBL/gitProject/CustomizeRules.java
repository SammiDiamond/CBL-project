package CBL.gitProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Class creates an instance of rule customization when "Customize Rule" button
 * is pressed in main menu.
 */
public class CustomizeRules {

    // Declaration the MainMenu object
    MainMenu mainMenu;

    /**
     * Constructor responsible for the GUI for the gameplay.
     * 
     * @param menu Specific MainMenu object whose instance variables are used within
     *             CustomizeRules.
     */

    CustomizeRules(MainMenu menu) {
        // Contents of menu are stored into the mainMenu instance variable
        this.mainMenu = menu;

        // Buttons in the previous window are disabled and window is minimized
        mainMenu.menuFrame.setState(JFrame.ICONIFIED);
        mainMenu.startGame.setEnabled(false);
        mainMenu.customizeRules.setEnabled(false);
        mainMenu.gameHistory.setEnabled(false);

        // rule frame is initialized for the rulecustomization
        JFrame rule = new JFrame();
        // rule panel is initialized for the rulecustomization
        JPanel rulePanel = new JPanel();
        rulePanel.setLayout(new FlowLayout());
        // Creation of boolean values for each rule's button, true/false indicating rule
        // on/off
        boolean buttonSwapOn = false;
        boolean buttonObOn = false;
        boolean buttonElimOn = false;
        boolean buttonLeftColorOn = false;
        boolean buttonRightColorOn = false;

        // Creation of subpanels in pane
        JPanel sizes = new JPanel(new GridLayout(6, 1, 10, 10));
        JPanel leftColorPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        leftColorPanel.setVisible(false);
        JPanel rightColorPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        leftColorPanel.setVisible(false);
        rightColorPanel.setVisible(false);

        // Creation for all the size buttons
        JButton size5X5 = new JButton("5*5");
        JButton size6X6 = new JButton("6*6");
        JButton size7X7 = new JButton("7*7");
        JButton size8X8 = new JButton("8*8");
        JButton size9X9 = new JButton("9*9");
        JButton size10X10 = new JButton("10*10");

        // add size buttons into sizes panel
        sizes.setBounds(325, 50, 550, 400);
        sizes.setBackground(Color.WHITE);
        sizes.setBorder(BorderFactory.createRaisedBevelBorder());
        sizes.add(size5X5);
        sizes.add(size6X6);
        sizes.add(size7X7);
        sizes.add(size8X8);
        sizes.add(size9X9);
        sizes.add(size10X10);
        // sizes panel initially invisible, only visible when setting grid size
        sizes.setVisible(false);

        // Creation of color panel to hold leftColor button, rightColor button and
        // ruleColor label
        JPanel color = new JPanel();
        color.setLayout(new GridLayout(1, 3, 10, 0));

        // create various color buttons for left side
        JButton leftRed = new JButton(new ImageIcon("CBL\\icons\\red.png"));
        JButton leftOrange = new JButton(new ImageIcon("CBL\\icons\\orange.png"));
        JButton leftYellow = new JButton(new ImageIcon("CBL\\icons\\yellow.png"));
        JButton leftGreen = new JButton(new ImageIcon("CBL\\icons\\green.png"));
        JButton leftCyan = new JButton(new ImageIcon("CBL\\icons\\cyan.png"));
        JButton leftBlue = new JButton(new ImageIcon("CBL\\icons\\blue.png"));
        JButton leftPurple = new JButton(new ImageIcon("CBL\\icons\\purple.png"));
        JButton leftPink = new JButton(new ImageIcon("CBL\\icons\\pink.png"));
        JButton leftBrown = new JButton(new ImageIcon("CBL\\icons\\brown.png"));

        // adding color icons into leftColorPick panel
        leftColorPanel.add(leftRed);
        leftColorPanel.add(leftOrange);
        leftColorPanel.add(leftYellow);
        leftColorPanel.add(leftGreen);
        leftColorPanel.add(leftCyan);
        leftColorPanel.add(leftBlue);
        leftColorPanel.add(leftPurple);
        leftColorPanel.add(leftPink);
        leftColorPanel.add(leftBrown);

        // set up leftColorPanel
        leftColorPanel.setBounds(100, 300, 200, 200);
        leftColorPanel.setBackground(Color.WHITE);
        leftColorPanel.setBorder(BorderFactory.createRaisedBevelBorder());

        // Creation of choosing-color panel for right side
        JButton rightRed = new JButton(new ImageIcon("CBL\\icons\\red.png"));
        JButton rightOrange = new JButton(new ImageIcon("CBL\\icons\\orange.png"));
        JButton rightYellow = new JButton(new ImageIcon("CBL\\icons\\yellow.png"));
        JButton rightGreen = new JButton(new ImageIcon("CBL\\icons\\green.png"));
        JButton rightCyan = new JButton(new ImageIcon("CBL\\icons\\cyan.png"));
        JButton rightBlue = new JButton(new ImageIcon("CBL\\icons\\blue.png"));
        JButton rightPurple = new JButton(new ImageIcon("CBL\\icons\\purple.png"));
        JButton rightPink = new JButton(new ImageIcon("CBL\\icons\\pink.png"));
        JButton rightBrown = new JButton(new ImageIcon("CBL\\icons\\brown.png"));

        // adding color icons into rightColorPick panel
        rightColorPanel.add(rightRed);
        rightColorPanel.add(rightOrange);
        rightColorPanel.add(rightYellow);
        rightColorPanel.add(rightGreen);
        rightColorPanel.add(rightCyan);
        rightColorPanel.add(rightBlue);
        rightColorPanel.add(rightPurple);
        rightColorPanel.add(rightPink);
        rightColorPanel.add(rightBrown);

        // set up rightColorPanel
        rightColorPanel.setBounds(900, 300, 200, 200);
        rightColorPanel.setBackground(Color.WHITE);
        rightColorPanel.setBorder(BorderFactory.createRaisedBevelBorder());

        // set ActionListener for each color button in leftColorPanel
        leftRed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftRed.setIcon(new ImageIcon("CBL\\icons\\red_chosen.png"));
                rightRed.setIcon(new ImageIcon("CBL\\icons\\red_occupied.png"));
            }
        });
        leftOrange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftOrange.setIcon(new ImageIcon("CBL\\icons\\orange_chosen.png"));
                rightOrange.setIcon(new ImageIcon("CBL\\icons\\orange_occupied.png"));
            }
        });
        leftYellow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftYellow.setIcon(new ImageIcon("CBL\\icons\\yellow_chosen.png"));
                rightYellow.setIcon(new ImageIcon("CBL\\icons\\yellow_occupied.png"));
            }
        });
        leftGreen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftGreen.setIcon(new ImageIcon("CBL\\icons\\green_chosen.png"));
                rightGreen.setIcon(new ImageIcon("CBL\\icons\\green_occupied.png"));
            }
        });
        leftCyan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftCyan.setIcon(new ImageIcon("CBL\\icons\\cyan_chosen.png"));
                rightCyan.setIcon(new ImageIcon("CBL\\icons\\cyan_occupied.png"));
            }
        });
        leftBlue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftBlue.setIcon(new ImageIcon("CBL\\icons\\blue_chosen.png"));
                rightBlue.setIcon(new ImageIcon("CBL\\icons\\blue_occupied.png"));
            }
        });
        leftPurple.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftPurple.setIcon(new ImageIcon("CBL\\icons\\purple_chosen.png"));
                rightPurple.setIcon(new ImageIcon("CBL\\icons\\purple_occupied.png"));
            }
        });
        leftPink.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftPink.setIcon(new ImageIcon("CBL\\icons\\pink_chosen.png"));
                rightPink.setIcon(new ImageIcon("CBL\\icons\\pink_occupied.png"));
            }
        });
        leftBrown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftBrown.setIcon(new ImageIcon("CBL\\icons\\brown_chosen.png"));
                rightBrown.setIcon(new ImageIcon("CBL\\icons\\brown_occupied.png"));
            }
        });

        // set ActionListener for each color button in rightColorPanel
        rightRed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightRed.setIcon(new ImageIcon("CBL\\icons\\red_chosen.png"));
                leftRed.setIcon(new ImageIcon("CBL\\icons\\red_occupied.png"));
            }
        });
        rightOrange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightOrange.setIcon(new ImageIcon("CBL\\icons\\orange_chosen.png"));
                leftOrange.setIcon(new ImageIcon("CBL\\icons\\orange_occupied.png"));
            }
        });
        rightYellow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightYellow.setIcon(new ImageIcon("CBL\\icons\\yellow_chosen.png"));
                leftYellow.setIcon(new ImageIcon("CBL\\icons\\yellow_occupied.png"));
            }
        });
        rightGreen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightGreen.setIcon(new ImageIcon("CBL\\icons\\green_chosen.png"));
                leftGreen.setIcon(new ImageIcon("CBL\\icons\\green_occupied.png"));
            }
        });
        rightCyan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightCyan.setIcon(new ImageIcon("CBL\\icons\\cyan_chosen.png"));
                leftCyan.setIcon(new ImageIcon("CBL\\icons\\cyan_occupied.png"));
            }
        });
        rightBlue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightBlue.setIcon(new ImageIcon("CBL\\icons\\blue_chosen.png"));
                leftBlue.setIcon(new ImageIcon("CBL\\icons\\blue_occupied.png"));
            }
        });
        rightPurple.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightPurple.setIcon(new ImageIcon("CBL\\icons\\purple_chosen.png"));
                leftPurple.setIcon(new ImageIcon("CBL\\icons\\purple_occupied.png"));
            }
        });
        rightPink.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightPink.setIcon(new ImageIcon("CBL\\icons\\pink_chosen.png"));
                leftPink.setIcon(new ImageIcon("CBL\\icons\\pink_occupied.png"));
            }
        });
        rightBrown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightBrown.setIcon(new ImageIcon("CBL\\icons\\brown_chosen.png"));
                leftBrown.setIcon(new ImageIcon("CBL\\icons\\brown_occupied.png"));
            }
        });

        // Creation of JButton for each rule
        JButton buttonSave = new JButton("Save");
        buttonSave.setBorder(BorderFactory.createRaisedBevelBorder());

        JButton buttonSwap = new JButton("ON/OFF");
        buttonSwap.setBorder(BorderFactory.createRaisedBevelBorder());

        JButton buttonOb = new JButton("ON/OFF");
        buttonOb.setBorder(BorderFactory.createRaisedBevelBorder());

        JButton buttonElim = new JButton("ON/OFF");
        buttonElim.setBorder(BorderFactory.createRaisedBevelBorder());

        JButton buttonLeftColor = new JButton("left");
        JButton buttonRightColor = new JButton("right");

        JButton buttonSize = new JButton("Size: Change the size of the grid:");
        buttonSize.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonSize.setFocusable(false);

        buttonLeftColor.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonLeftColor.setSize(700, 200);
        buttonLeftColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftColorPanel.setVisible(true);
                // unable to choose again before choosing the color of red
                buttonSize.setEnabled(false);
                buttonElim.setEnabled(false);
                buttonOb.setEnabled(false);
                buttonSwap.setEnabled(false);
                buttonSave.setEnabled(false);
                buttonLeftColor.setEnabled(false);
            }
        });

        buttonRightColor.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonRightColor.setSize(700, 200);
        buttonRightColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightColorPanel.setVisible(true);
                // unable to choose again before choosing the color of red
                buttonSize.setEnabled(false);
                buttonElim.setEnabled(false);
                buttonOb.setEnabled(false);
                buttonSwap.setEnabled(false);
                buttonSave.setEnabled(false);
                buttonRightColor.setEnabled(false);
            }
        });

        // Creation of JLabel for each rule description except for GridSize
        JLabel ruleSwap = new JLabel(
                "Swap: Cover a given square in the opponent's color previously with your color."
                        + "(last: permanent; cd: 1 round)");
        ruleSwap.setAlignmentX(Component.CENTER_ALIGNMENT);
        ruleSwap.setFont(new Font("Arial", Font.BOLD, 35));
        ruleSwap.setBounds(50, 50, 200, 200);

        JLabel ruleOb = new JLabel(
                "Obstacle: Set an obstacle in a given square."
                        + "The square with obstacle in can't be the object of any other items."
                        + "(last: 4 rounds; cd: 1 round)");
        ruleOb.setAlignmentX(Component.CENTER_ALIGNMENT);
        ruleOb.setFont(new Font("Arial", Font.BOLD, 35));
        ruleOb.setBounds(50, 50, 200, 200);

        JLabel ruleElim = new JLabel(
                "Eliminate: Eliminate the color in a given square. (last: permanent; cd: 1 round)");
        ruleElim.setAlignmentX(Component.CENTER_ALIGNMENT);
        ruleElim.setFont(new Font("Arial", Font.BOLD, 35));
        ruleElim.setBounds(50, 50, 200, 200);

        JLabel ruleColor = new JLabel("Choose your colors!");
        ruleColor.setAlignmentX(Component.CENTER_ALIGNMENT);
        ruleColor.setFont(new Font("Arial", Font.BOLD, 35));
        ruleColor.setBounds(50, 50, 200, 200);
        // More rules to be added here

        // Creation of elim panel ho hold ruleElim label and buttonRuleElim button
        JPanel elim = new JPanel(new GridLayout(1, 2, 10, 10));
        // add mentioned components into the elim panel
        elim.add(ruleElim);
        elim.add(buttonElim);

        // Creation of Ob panel ho hold ruleOb label and buttonRuleOb button
        JPanel ob = new JPanel(new GridLayout(1, 2, 10, 10));
        // add mentioned components into the ob panel
        ob.add(ruleOb);
        ob.add(buttonOb);

        // Creation of Swap panel ho hold ruleSwap label and buttonRuleSwap button
        JPanel swap = new JPanel(new GridLayout(1, 2, 10, 10));
        // add mentioned components into the swap panel
        swap.add(ruleSwap);
        swap.add(buttonSwap);

        // set up rulesize
        buttonSize.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonSize.setFont(new Font("Arial", Font.BOLD, 35));
        buttonSize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sizes.setVisible(true);

                // Buttons for grid's size is now avaliable to be clicked
                size5X5.setEnabled(true);
                size6X6.setEnabled(true);
                size7X7.setEnabled(true);
                size8X8.setEnabled(true);
                size9X9.setEnabled(true);
                size10X10.setEnabled(true);

                // unable to quit before choosing the grid's size
                buttonElim.setEnabled(false);
                buttonSize.setEnabled(false);
                buttonOb.setEnabled(false);
                buttonSwap.setEnabled(false);
                buttonSave.setEnabled(false);
                buttonLeftColor.setEnabled(false);
                buttonRightColor.setEnabled(false);

            }
        });

        // add mentioned components into the color panel
        color.add(buttonLeftColor);
        color.add(ruleColor);
        color.add(buttonRightColor);

        JPanel save = new JPanel();
        save.add(buttonSave);
        save.setLayout(new GridLayout(1, 3, 0, 10));

        // set up pane and add components into pane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1200, 820);

        // adding components into pane
        layeredPane.add(sizes);
        layeredPane.add(leftColorPanel);
        layeredPane.add(rightColorPanel);
        layeredPane.add(rulePanel);
        // add rulePanel into rule frame
        rule.add(layeredPane);

        // adding components into rule panel
        rulePanel.add(buttonSize);
        rulePanel.add(elim);
        rulePanel.add(ob);
        rulePanel.add(swap);
        rulePanel.add(color);
        rulePanel.add(save);

        // rulePanel Layout
        rulePanel.setSize(1200, 820);
        rulePanel.setVisible(true);
        rulePanel.setLayout(new BoxLayout(rulePanel, BoxLayout.Y_AXIS));

        // game frame details are assigned
        rule.setSize(1200, 855);
        rule.setLocationRelativeTo(null);
        rule.setLayout(null);
        rule.setVisible(true);
    }
}
