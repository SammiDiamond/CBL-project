package CBL.gitProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BoxLayout;

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
        JPanel leftColorPanel = new JPanel(new GridLayout(3, 3, 50, 50));
        leftColorPanel.setVisible(false);
        JPanel rightColorPanel = new JPanel(new GridLayout(3, 3, 50, 50));
        leftColorPanel.setVisible(false);

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
        sizes.add(size5X5);
        sizes.add(size6X6);
        sizes.add(size7X7);
        sizes.add(size8X8);
        sizes.add(size9X9);
        sizes.add(size10X10);
        // sizes panel initially invisible, only visible when setting grid size
        sizes.setVisible(false);

        // set up leftColorPanel

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
        buttonLeftColor.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonLeftColor.setSize(700, 200);
        buttonLeftColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftColorPanel.setVisible(true);
                // unable to choose again before choosing the color of red
                buttonLeftColor.setEnabled(false);
            }
        });

        JButton buttonRightColor = new JButton("right");
        buttonRightColor.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonRightColor.setSize(700, 200);
        buttonRightColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightColorPanel.setVisible(true);
                // unable to choose again before choosing the color of red
                buttonRightColor.setEnabled(false);
            }
        });

        JButton ruleSize = new JButton("Size: Change the size of the grid:");
        ruleSize.setBorder(BorderFactory.createRaisedBevelBorder());
        ruleSize.setFocusable(false);

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
        // add mentioned components into the elim panel
        ob.add(ruleOb);
        ob.add(buttonOb);

        // Creation of Swap panel ho hold ruleSwap label and buttonRuleSwap button
        JPanel swap = new JPanel(new GridLayout(1, 2, 10, 10));
        // add mentioned components into the elim panel
        swap.add(ruleSwap);
        swap.add(buttonSwap);

        // Creation of color panel to hold leftColor button, rightColor button and
        // ruleColor label
        JPanel color = new JPanel();
        color.setLayout(new GridLayout(1, 3, 10, 0));
        // add mentioned components into the color panel
        color.add(buttonRightColor);
        color.add(ruleColor);
        color.add(buttonLeftColor);

        JPanel save = new JPanel();
        save.add(buttonSave);
        save.setLayout(new GridLayout(1, 3, 0, 10));

        // Creation of choosing-color panel for each side
        JPanel leftColorPick = new JPanel();
        JPanel rightColorPick = new JPanel();

        // create various color buttons for left side
        JButton leftRed = new JButton();
        JButton leftOrange = new JButton();
        JButton leftYellow = new JButton();
        JButton leftGreen = new JButton();
        JButton leftMikuCyan = new JButton();
        JButton leftPruple = new JButton();
        JButton leftPink = new JButton();
        JButton leftBrown = new JButton();

        // Creation of choosing-color panel for right side
        JButton rightRed = new JButton();
        JButton rightOrange = new JButton();
        JButton rightYellow = new JButton();
        JButton rightGreen = new JButton();
        JButton rightMikuCyan = new JButton();
        JButton rightPurple = new JButton();
        JButton rightPink = new JButton();
        JButton rightBrown = new JButton();

        // set up rulesize
        ruleSize.setAlignmentX(Component.CENTER_ALIGNMENT);
        ruleSize.setFont(new Font("Arial", Font.BOLD, 35));
        ruleSize.addActionListener(new ActionListener() {
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
                ruleSize.setEnabled(false);
            }
        });

        // adding components into rule panel
        rulePanel.add(ruleSize);
        rulePanel.add(elim);
        rulePanel.add(ob);
        rulePanel.add(swap);
        rulePanel.add(color);
        rulePanel.add(save);

        // rulePanel Layout
        rulePanel.setSize(1200, 820);
        rulePanel.setVisible(true);
        rulePanel.setLayout(new BoxLayout(rulePanel, BoxLayout.Y_AXIS));

        // set up pane and add components into pane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1200, 820);

        // adding components into pane
        layeredPane.add(sizes);
        layeredPane.add(rulePanel);
        layeredPane.add(leftColorPanel);
        layeredPane.add(rightColorPanel);

        // add rulePanel into rule frame
        rule.add(layeredPane);

        // game frame details are assigned
        rule.setSize(1200, 820);
        rule.setLocationRelativeTo(null);
        rule.setLayout(null);
        rule.setVisible(true);
    }
}
