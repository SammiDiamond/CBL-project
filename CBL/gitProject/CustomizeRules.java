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
        // using array to avoid "local variable defined in an enclosing scope" error
        boolean buttonSwapOn = false;
        boolean buttonObOn = false;
        boolean buttonElimOn = false;
        boolean buttonLeftColorOn = false;
        boolean buttonRightColorOn = false;
        boolean[] buttonOnOff = { buttonSwapOn, buttonObOn, buttonElimOn, buttonLeftColorOn, buttonRightColorOn };

        // Creation of subpanels in pane(set up later)
        JPanel sizes = new JPanel(new GridLayout(6, 1, 10, 10));
        JPanel leftColorPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        leftColorPanel.setVisible(false);
        JPanel rightColorPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        leftColorPanel.setVisible(false);
        rightColorPanel.setVisible(false);

        // Create button and set up ActionListener for each rule
        JButton buttonSave = new JButton("Save");
        buttonSave.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //
            }
        });

        JButton buttonSwap = new JButton("OFF");
        buttonSwap.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonSwap.setFocusable(false);
        buttonSwap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonOnOff[0] = !buttonOnOff[0];
                if (buttonOnOff[0]) {
                    buttonSwap.setText("ON");
                } else {
                    buttonSwap.setText("OFF");
                }
            }
        });

        JButton buttonOb = new JButton("OFF");
        buttonOb.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonOb.setFocusable(false);
        buttonOb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonOnOff[1] = !buttonOnOff[1];
                if (buttonOnOff[1]) {
                    buttonOb.setText("ON");
                } else {
                    buttonOb.setText("OFF");
                }
            }
        });

        JButton buttonElim = new JButton("OFF");
        buttonElim.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonElim.setFocusable(false);
        buttonElim.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonOnOff[2] = !buttonOnOff[2];
                if (buttonOnOff[2]) {
                    buttonElim.setText("ON");
                } else {
                    buttonElim.setText("OFF");
                }
            }
        });

        JButton buttonLeftColor = new JButton("left");
        JButton buttonRightColor = new JButton("right");

        JButton buttonSize = new JButton("Size: Change the size of the grid:");
        buttonSize.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonSize.setFocusable(false);

        // region Creation for all the size buttons and set backgrounds as null
        JButton size5X5 = new JButton("5*5");
        size5X5.setBackground(null);
        JButton size6X6 = new JButton("6*6");
        size6X6.setBackground(null);
        JButton size7X7 = new JButton("7*7");
        size7X7.setBackground(null);
        JButton size8X8 = new JButton("8*8");
        size8X8.setBackground(null);
        JButton size9X9 = new JButton("9*9");
        size9X9.setBackground(null);
        JButton size10X10 = new JButton("10*10");
        size10X10.setBackground(null);
        // endregion

        // region initialize sizes panel and add size buttons into sizes panel
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
        // endregion

        // region set ActionListener for each size button in sizes pane
        size5X5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                size5X5.setBackground(Color.LIGHT_GRAY);
                size6X6.setBackground(null);
                size7X7.setBackground(null);
                size8X8.setBackground(null);
                size9X9.setBackground(null);
                size10X10.setBackground(null);
                // quit grid size panel
                sizes.setVisible(false);
                buttonElim.setEnabled(true);
                buttonSize.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
            }
        });
        size6X6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                size6X6.setBackground(Color.LIGHT_GRAY);
                size5X5.setBackground(null);
                size7X7.setBackground(null);
                size8X8.setBackground(null);
                size9X9.setBackground(null);
                size10X10.setBackground(null);
                // quit grid size panel
                sizes.setVisible(false);
                buttonElim.setEnabled(true);
                buttonSize.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
            }
        });
        size7X7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                size7X7.setBackground(Color.LIGHT_GRAY);
                size5X5.setBackground(null);
                size6X6.setBackground(null);
                size8X8.setBackground(null);
                size9X9.setBackground(null);
                size10X10.setBackground(null);
                // quit grid size panel
                sizes.setVisible(false);
                buttonElim.setEnabled(true);
                buttonSize.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
            }
        });
        size8X8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                size8X8.setBackground(Color.LIGHT_GRAY);
                size5X5.setBackground(null);
                size6X6.setBackground(null);
                size7X7.setBackground(null);
                size9X9.setBackground(null);
                size10X10.setBackground(null);
                // quit grid size panel
                sizes.setVisible(false);
                buttonElim.setEnabled(true);
                buttonSize.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
            }
        });
        size9X9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                size9X9.setBackground(Color.LIGHT_GRAY);
                size5X5.setBackground(null);
                size6X6.setBackground(null);
                size7X7.setBackground(null);
                size8X8.setBackground(null);
                size10X10.setBackground(null);
                // quit grid size panel
                sizes.setVisible(false);
                buttonElim.setEnabled(true);
                buttonSize.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
            }
        });
        size10X10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                size10X10.setBackground(Color.LIGHT_GRAY);
                size5X5.setBackground(null);
                size6X6.setBackground(null);
                size7X7.setBackground(null);
                size8X8.setBackground(null);
                size9X9.setBackground(null);
                // quit grid size panel
                sizes.setVisible(false);
                buttonElim.setEnabled(true);
                buttonSize.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
            }
        });
        // endregion

        // Creation of color panel to hold leftColor button, rightColor button and
        // ruleColor label
        JPanel color = new JPanel();
        color.setLayout(new GridLayout(1, 3, 10, 0));

        // region create various color buttons for left side
        JButton leftRed = new JButton(new ImageIcon("CBL\\icons\\red.png"));
        JButton leftOrange = new JButton(new ImageIcon("CBL\\icons\\orange.png"));
        JButton leftYellow = new JButton(new ImageIcon("CBL\\icons\\yellow.png"));
        JButton leftGreen = new JButton(new ImageIcon("CBL\\icons\\green.png"));
        JButton leftCyan = new JButton(new ImageIcon("CBL\\icons\\cyan.png"));
        JButton leftBlue = new JButton(new ImageIcon("CBL\\icons\\blue.png"));
        JButton leftPurple = new JButton(new ImageIcon("CBL\\icons\\purple.png"));
        JButton leftPink = new JButton(new ImageIcon("CBL\\icons\\pink.png"));
        JButton leftBrown = new JButton(new ImageIcon("CBL\\icons\\brown.png"));
        // endregion

        // region adding color icons into leftColorPick panel
        leftColorPanel.add(leftRed);
        leftColorPanel.add(leftOrange);
        leftColorPanel.add(leftYellow);
        leftColorPanel.add(leftGreen);
        leftColorPanel.add(leftCyan);
        leftColorPanel.add(leftBlue);
        leftColorPanel.add(leftPurple);
        leftColorPanel.add(leftPink);
        leftColorPanel.add(leftBrown);
        // endregion

        // set up leftColorPanel
        leftColorPanel.setBounds(100, 300, 200, 200);
        leftColorPanel.setBackground(Color.WHITE);
        leftColorPanel.setBorder(BorderFactory.createRaisedBevelBorder());

        // region Creation of choosing-color panel for right side
        JButton rightRed = new JButton(new ImageIcon("CBL\\icons\\red.png"));
        JButton rightOrange = new JButton(new ImageIcon("CBL\\icons\\orange.png"));
        JButton rightYellow = new JButton(new ImageIcon("CBL\\icons\\yellow.png"));
        JButton rightGreen = new JButton(new ImageIcon("CBL\\icons\\green.png"));
        JButton rightCyan = new JButton(new ImageIcon("CBL\\icons\\cyan.png"));
        JButton rightBlue = new JButton(new ImageIcon("CBL\\icons\\blue.png"));
        JButton rightPurple = new JButton(new ImageIcon("CBL\\icons\\purple.png"));
        JButton rightPink = new JButton(new ImageIcon("CBL\\icons\\pink.png"));
        JButton rightBrown = new JButton(new ImageIcon("CBL\\icons\\brown.png"));
        // endregion

        // region adding color icons into rightColorPick panel
        rightColorPanel.add(rightRed);
        rightColorPanel.add(rightOrange);
        rightColorPanel.add(rightYellow);
        rightColorPanel.add(rightGreen);
        rightColorPanel.add(rightCyan);
        rightColorPanel.add(rightBlue);
        rightColorPanel.add(rightPurple);
        rightColorPanel.add(rightPink);
        rightColorPanel.add(rightBrown);
        // endregion

        // set up rightColorPanel
        rightColorPanel.setBounds(900, 300, 200, 200);
        rightColorPanel.setBackground(Color.WHITE);
        rightColorPanel.setBorder(BorderFactory.createRaisedBevelBorder());

        // region set ActionListener for each color button in leftColorPanel
        leftRed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftRed.setIcon(new ImageIcon("CBL\\icons\\red_chosen.png"));
                rightRed.setIcon(new ImageIcon("CBL\\icons\\red_occupied.png"));
                // "back" to CustomizeRule panel
                leftColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
                // initializing other color buttons
                leftOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                leftYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                leftGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                leftCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                leftBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                leftPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                leftPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                leftBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                rightOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                rightYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                rightGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                rightCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                rightBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                rightPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                rightPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                rightBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                rightRed.setEnabled(false);
                rightOrange.setEnabled(true);
                rightYellow.setEnabled(true);
                rightGreen.setEnabled(true);
                rightCyan.setEnabled(true);
                rightBlue.setEnabled(true);
                rightPurple.setEnabled(true);
                rightPink.setEnabled(true);
                rightBrown.setEnabled(true);

            }
        });
        leftOrange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftOrange.setIcon(new ImageIcon("CBL\\icons\\orange_chosen.png"));
                rightOrange.setIcon(new ImageIcon("CBL\\icons\\orange_occupied.png"));
                leftColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
                // initializing other color buttons
                leftRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                leftYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                leftGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                leftCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                leftBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                leftPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                leftPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                leftBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                rightRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                rightYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                rightGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                rightCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                rightBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                rightPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                rightPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                rightBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                rightRed.setEnabled(true);
                rightOrange.setEnabled(false);
                rightYellow.setEnabled(true);
                rightGreen.setEnabled(true);
                rightCyan.setEnabled(true);
                rightBlue.setEnabled(true);
                rightPurple.setEnabled(true);
                rightPink.setEnabled(true);
                rightBrown.setEnabled(true);
            }
        });
        leftYellow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftYellow.setIcon(new ImageIcon("CBL\\icons\\yellow_chosen.png"));
                rightYellow.setIcon(new ImageIcon("CBL\\icons\\yellow_occupied.png"));
                leftColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
                // initializing other color buttons
                leftRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                leftOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                leftGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                leftCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                leftBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                leftPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                leftPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                leftBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                rightRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                rightOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                rightGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                rightCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                rightBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                rightPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                rightPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                rightBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                rightRed.setEnabled(true);
                rightOrange.setEnabled(true);
                rightYellow.setEnabled(false);
                rightGreen.setEnabled(true);
                rightCyan.setEnabled(true);
                rightBlue.setEnabled(true);
                rightPurple.setEnabled(true);
                rightPink.setEnabled(true);
                rightBrown.setEnabled(true);
            }
        });
        leftGreen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftGreen.setIcon(new ImageIcon("CBL\\icons\\green_chosen.png"));
                rightGreen.setIcon(new ImageIcon("CBL\\icons\\green_occupied.png"));
                leftColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
                // initializing other color buttons
                leftRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                leftOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                leftYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                leftCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                leftBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                leftPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                leftPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                leftBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                rightRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                rightOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                rightYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                rightCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                rightBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                rightPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                rightPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                rightBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                rightRed.setEnabled(true);
                rightOrange.setEnabled(true);
                rightYellow.setEnabled(true);
                rightGreen.setEnabled(false);
                rightCyan.setEnabled(true);
                rightBlue.setEnabled(true);
                rightPurple.setEnabled(true);
                rightPink.setEnabled(true);
                rightBrown.setEnabled(true);
            }
        });
        leftCyan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftCyan.setIcon(new ImageIcon("CBL\\icons\\cyan_chosen.png"));
                rightCyan.setIcon(new ImageIcon("CBL\\icons\\cyan_occupied.png"));
                leftColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
                // initializing other color buttons
                leftRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                leftOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                leftYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                leftGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                leftBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                leftPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                leftPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                leftBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                rightRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                rightOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                rightYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                rightGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                rightBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                rightPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                rightPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                rightBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                rightRed.setEnabled(true);
                rightOrange.setEnabled(true);
                rightYellow.setEnabled(true);
                rightGreen.setEnabled(true);
                rightCyan.setEnabled(false);
                rightBlue.setEnabled(true);
                rightPurple.setEnabled(true);
                rightPink.setEnabled(true);
                rightBrown.setEnabled(true);
            }
        });
        leftBlue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftBlue.setIcon(new ImageIcon("CBL\\icons\\blue_chosen.png"));
                rightBlue.setIcon(new ImageIcon("CBL\\icons\\blue_occupied.png"));
                leftColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
                // initializing other color buttons
                leftRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                leftOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                leftYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                leftGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                leftCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                leftPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                leftPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                leftBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                rightRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                rightOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                rightYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                rightGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                rightCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                rightPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                rightPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                rightBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                rightRed.setEnabled(true);
                rightOrange.setEnabled(true);
                rightYellow.setEnabled(true);
                rightGreen.setEnabled(true);
                rightCyan.setEnabled(true);
                rightBlue.setEnabled(false);
                rightPurple.setEnabled(true);
                rightPink.setEnabled(true);
                rightBrown.setEnabled(true);
            }
        });
        leftPurple.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftPurple.setIcon(new ImageIcon("CBL\\icons\\purple_chosen.png"));
                rightPurple.setIcon(new ImageIcon("CBL\\icons\\purple_occupied.png"));
                leftColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
                // initializing other color buttons
                leftRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                leftOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                leftYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                leftGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                leftCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                leftBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                leftPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                leftBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                rightRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                rightOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                rightYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                rightGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                rightCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                rightBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                rightPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                rightBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                rightRed.setEnabled(true);
                rightOrange.setEnabled(true);
                rightYellow.setEnabled(true);
                rightGreen.setEnabled(true);
                rightCyan.setEnabled(true);
                rightBlue.setEnabled(true);
                rightPurple.setEnabled(false);
                rightPink.setEnabled(true);
                rightBrown.setEnabled(true);
            }
        });
        leftPink.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftPink.setIcon(new ImageIcon("CBL\\icons\\pink_chosen.png"));
                rightPink.setIcon(new ImageIcon("CBL\\icons\\pink_occupied.png"));
                leftColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
                // initializing other color buttons
                leftRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                leftOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                leftYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                leftGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                leftCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                leftBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                leftPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                leftBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                rightRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                rightOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                rightYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                rightGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                rightCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                rightBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                rightPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                rightBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                rightRed.setEnabled(true);
                rightOrange.setEnabled(true);
                rightYellow.setEnabled(true);
                rightGreen.setEnabled(true);
                rightCyan.setEnabled(true);
                rightBlue.setEnabled(true);
                rightPurple.setEnabled(true);
                rightPink.setEnabled(false);
                rightBrown.setEnabled(true);
            }
        });
        leftBrown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftBrown.setIcon(new ImageIcon("CBL\\icons\\brown_chosen.png"));
                rightBrown.setIcon(new ImageIcon("CBL\\icons\\brown_occupied.png"));
                leftColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
                // initializing other color buttons
                leftRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                leftOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                leftYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                leftGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                leftCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                leftBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                leftPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                leftPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                // also for buttons in another panel
                rightRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                rightOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                rightYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                rightGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                rightCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                rightBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                rightPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                rightPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                rightRed.setEnabled(true);
                rightOrange.setEnabled(true);
                rightYellow.setEnabled(true);
                rightGreen.setEnabled(true);
                rightCyan.setEnabled(true);
                rightBlue.setEnabled(true);
                rightPurple.setEnabled(true);
                rightPink.setEnabled(true);
                rightBrown.setEnabled(false);
            }
        });
        // endregion

        // region set ActionListener for each color button in rightColorPanel
        rightRed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightRed.setIcon(new ImageIcon("CBL\\icons\\red_chosen.png"));
                leftRed.setIcon(new ImageIcon("CBL\\icons\\red_occupied.png"));
                // "back" to CustomizeRule panel
                rightColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
                // initializing other color buttons
                rightOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                rightYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                rightGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                rightCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                rightBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                rightPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                rightPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                rightBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                leftOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                leftYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                leftGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                leftCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                leftBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                leftPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                leftPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                leftBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                leftRed.setEnabled(false);
                leftOrange.setEnabled(true);
                leftYellow.setEnabled(true);
                leftGreen.setEnabled(true);
                leftCyan.setEnabled(true);
                leftBlue.setEnabled(true);
                leftPurple.setEnabled(true);
                leftPink.setEnabled(true);
                leftBrown.setEnabled(true);
            }
        });
        rightOrange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightOrange.setIcon(new ImageIcon("CBL\\icons\\orange_chosen.png"));
                leftOrange.setIcon(new ImageIcon("CBL\\icons\\orange_occupied.png"));
                // "back" to CustomizeRule panel
                rightColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
                // initializing other color buttons
                rightRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                rightYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                rightGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                rightCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                rightBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                rightPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                rightPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                rightBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                leftRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                leftYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                leftGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                leftCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                leftBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                leftPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                leftPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                leftBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                leftRed.setEnabled(true);
                leftOrange.setEnabled(false);
                leftYellow.setEnabled(true);
                leftGreen.setEnabled(true);
                leftCyan.setEnabled(true);
                leftBlue.setEnabled(true);
                leftPurple.setEnabled(true);
                leftPink.setEnabled(true);
                leftBrown.setEnabled(true);
            }
        });
        rightYellow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightYellow.setIcon(new ImageIcon("CBL\\icons\\yellow_chosen.png"));
                leftYellow.setIcon(new ImageIcon("CBL\\icons\\yellow_occupied.png"));
                // "back" to CustomizeRule panel
                rightColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
                // initializing other color buttons
                rightRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                rightOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                rightGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                rightCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                rightBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                rightPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                rightPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                rightBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                leftRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                leftOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                leftGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                leftCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                leftBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                leftPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                leftPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                leftBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                leftRed.setEnabled(true);
                leftOrange.setEnabled(true);
                leftYellow.setEnabled(false);
                leftGreen.setEnabled(true);
                leftCyan.setEnabled(true);
                leftBlue.setEnabled(true);
                leftPurple.setEnabled(true);
                leftPink.setEnabled(true);
                leftBrown.setEnabled(true);
            }
        });
        rightGreen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightGreen.setIcon(new ImageIcon("CBL\\icons\\green_chosen.png"));
                leftGreen.setIcon(new ImageIcon("CBL\\icons\\green_occupied.png"));
                // "back" to CustomizeRule panel
                rightColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
                // initializing other color buttons
                rightRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                rightOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                rightYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                rightCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                rightBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                rightPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                rightPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                rightBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                leftRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                leftOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                leftYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                leftCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                leftBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                leftPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                leftPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                leftBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                leftRed.setEnabled(true);
                leftOrange.setEnabled(true);
                leftYellow.setEnabled(true);
                leftGreen.setEnabled(false);
                leftCyan.setEnabled(true);
                leftBlue.setEnabled(true);
                leftPurple.setEnabled(true);
                leftPink.setEnabled(true);
                leftBrown.setEnabled(true);
            }
        });
        rightCyan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightCyan.setIcon(new ImageIcon("CBL\\icons\\cyan_chosen.png"));
                leftCyan.setIcon(new ImageIcon("CBL\\icons\\cyan_occupied.png"));
                // "back" to CustomizeRule panel
                rightColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
                // initializing other color buttons
                rightRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                rightOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                rightYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                rightGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                rightBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                rightPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                rightPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                rightBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                leftRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                leftOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                leftYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                leftGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                leftBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                leftPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                leftPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                leftBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                leftRed.setEnabled(true);
                leftOrange.setEnabled(true);
                leftYellow.setEnabled(true);
                leftGreen.setEnabled(true);
                leftCyan.setEnabled(false);
                leftBlue.setEnabled(true);
                leftPurple.setEnabled(true);
                leftPink.setEnabled(true);
                leftBrown.setEnabled(true);
            }
        });
        rightBlue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightBlue.setIcon(new ImageIcon("CBL\\icons\\blue_chosen.png"));
                leftBlue.setIcon(new ImageIcon("CBL\\icons\\blue_occupied.png"));
                // "back" to CustomizeRule panel
                rightColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
                // initializing other color buttons
                rightRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                rightOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                rightYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                rightGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                rightCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                rightPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                rightPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                rightBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                leftRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                leftOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                leftYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                leftGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                leftCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                leftPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                leftPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                leftBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                leftRed.setEnabled(true);
                leftOrange.setEnabled(true);
                leftYellow.setEnabled(true);
                leftGreen.setEnabled(true);
                leftCyan.setEnabled(true);
                leftBlue.setEnabled(false);
                leftPurple.setEnabled(true);
                leftPink.setEnabled(true);
                leftBrown.setEnabled(true);
            }
        });
        rightPurple.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightPurple.setIcon(new ImageIcon("CBL\\icons\\purple_chosen.png"));
                leftPurple.setIcon(new ImageIcon("CBL\\icons\\purple_occupied.png"));
                // "back" to CustomizeRule panel
                rightColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
                // initializing other color buttons
                rightRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                rightOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                rightYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                rightGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                rightCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                rightBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                rightPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                rightBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                leftRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                leftOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                leftYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                leftGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                leftCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                leftBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                leftPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                leftBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                leftRed.setEnabled(true);
                leftOrange.setEnabled(true);
                leftYellow.setEnabled(true);
                leftGreen.setEnabled(true);
                leftCyan.setEnabled(true);
                leftBlue.setEnabled(true);
                leftPurple.setEnabled(false);
                leftPink.setEnabled(true);
                leftBrown.setEnabled(true);
            }
        });
        rightPink.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightPink.setIcon(new ImageIcon("CBL\\icons\\pink_chosen.png"));
                leftPink.setIcon(new ImageIcon("CBL\\icons\\pink_occupied.png"));
                // "back" to CustomizeRule panel
                rightColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
                // initializing other color buttons
                rightRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                rightOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                rightYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                rightGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                rightCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                rightBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                rightPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                rightBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                leftRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                leftOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                leftYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                leftGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                leftCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                leftBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                leftPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                leftBrown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                leftRed.setEnabled(true);
                leftOrange.setEnabled(true);
                leftYellow.setEnabled(true);
                leftGreen.setEnabled(true);
                leftCyan.setEnabled(true);
                leftBlue.setEnabled(true);
                leftPurple.setEnabled(true);
                leftPink.setEnabled(false);
                leftBrown.setEnabled(true);
            }
        });
        rightBrown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightBrown.setIcon(new ImageIcon("CBL\\icons\\brown_chosen.png"));
                leftBrown.setIcon(new ImageIcon("CBL\\icons\\brown_occupied.png"));
                // "back" to CustomizeRule panel
                rightColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonLeftColor.setEnabled(true);
                buttonRightColor.setEnabled(true);
                // initializing other color buttons
                rightRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                rightOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                rightYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                rightGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                rightCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                rightBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                rightPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                rightPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                // also for buttons in another panel
                leftRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                leftOrange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                leftYellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                leftGreen.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                leftCyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                leftBlue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                leftPurple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                leftPink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                leftRed.setEnabled(true);
                leftOrange.setEnabled(true);
                leftYellow.setEnabled(true);
                leftGreen.setEnabled(true);
                leftCyan.setEnabled(true);
                leftBlue.setEnabled(true);
                leftPurple.setEnabled(true);
                leftPink.setEnabled(true);
                leftBrown.setEnabled(false);
            }
        });
        // endregion

        buttonLeftColor.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonLeftColor.setSize(700, 200);
        buttonLeftColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftColorPanel.setVisible(true);
                rightColorPanel.setVisible(false);
                // unable to choose again before choosing the color of red
                buttonSize.setEnabled(false);
                buttonElim.setEnabled(false);
                buttonOb.setEnabled(false);
                buttonSwap.setEnabled(false);
                buttonSave.setEnabled(false);
                buttonLeftColor.setEnabled(false);
                buttonRightColor.setEnabled(false);
            }
        });

        buttonRightColor.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonRightColor.setSize(700, 200);
        buttonRightColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightColorPanel.setVisible(true);
                leftColorPanel.setVisible(false);
                // unable to choose again before choosing the color of red
                buttonSize.setEnabled(false);
                buttonElim.setEnabled(false);
                buttonOb.setEnabled(false);
                buttonSwap.setEnabled(false);
                buttonSave.setEnabled(false);
                buttonRightColor.setEnabled(false);
                buttonLeftColor.setEnabled(false);
            }
        });

        // Creation of JLabel for each rule description except for GridSize
        JLabel ruleSwap = new JLabel(
                "Swap: Cover a given square in the opponent's color previously with your color."
                        + "(last: permanent; cd: 1 round)");
        ruleSwap.setAlignmentX(Component.CENTER_ALIGNMENT);
        ruleSwap.setFont(new Font("Arial", Font.BOLD, 15));
        ruleSwap.setBounds(50, 50, 200, 200);

        JLabel ruleOb = new JLabel(
                "Obstacle: Set an obstacle in a given square."
                        + "The square with obstacle in can't be the object of any other items."
                        + "(last: 4 rounds; cd: 1 round)");
        ruleOb.setAlignmentX(Component.CENTER_ALIGNMENT);
        ruleOb.setFont(new Font("Arial", Font.BOLD, 15));
        ruleOb.setBounds(50, 50, 200, 200);

        JLabel ruleElim = new JLabel(
                "Eliminate: Eliminate the color in a given square. (last: permanent; cd: 1 round)");
        ruleElim.setAlignmentX(Component.CENTER_ALIGNMENT);
        ruleElim.setFont(new Font("Arial", Font.BOLD, 15));
        ruleElim.setBounds(50, 50, 200, 200);

        JLabel ruleColor = new JLabel("Choose your colors!");
        ruleColor.setAlignmentX(Component.CENTER_ALIGNMENT);
        ruleColor.setFont(new Font("Arial", Font.BOLD, 15));
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
