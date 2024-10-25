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

        // Create variables to pass arguements to StartGame class;

        // rule frame is initialized for the rulecustomization
        JFrame rule = new JFrame();
        // rule panel is initialized for the rulecustomization
        JPanel rulePanel = new JPanel();
        rulePanel.setLayout(new FlowLayout());

        // Creation of parameters to be passed on to StartGame class later

        // Creation of final colors for each player, index 0 for player 1 color and
        // index 1 for player 2 color
        Color[] finalColor = { mainMenu.p1Color, mainMenu.p2Color };

        // Creation of datas for each rules, used for calculation
        // 3 for the numbers of the total rules(become 5 if spread and protect rules are
        // added)
        // 2 for the properties of each rules(lasting time and cooldown time
        // for instance, datas[1][0] representing the lasting time for obstacle rule
        int[][] datas = new int[5][2];

        // Creation of two labels showing p1Color and p2Color
        JLabel p1Color = new JLabel();
        p1Color.setSize(5, 5);
        p1Color.setBackground(mainMenu.p1Color);
        p1Color.setVisible(true);
        p1Color.setBorder(BorderFactory.createRaisedBevelBorder());

        JLabel p2Color = new JLabel();
        p2Color.setSize(50, 50);
        p2Color.setBackground(mainMenu.p2Color);
        p2Color.setVisible(true);
        p2Color.setBorder(BorderFactory.createRaisedBevelBorder());

        // Creation of subpanels in pane(set up later)
        JPanel sizes = new JPanel(new GridLayout(6, 1, 10, 10));
        JPanel p1ColorPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        p1ColorPanel.setVisible(false);
        p1Color.setOpaque(true);
        JPanel p2ColorPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        p1ColorPanel.setVisible(false);
        p2ColorPanel.setVisible(false);
        p2Color.setOpaque(true);

        // Creation of buttonSave for saving and passing all parameters in CustomizeRule
        // class
        JButton buttonSave = new JButton("Save");
        buttonSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // passing parameters to MainMenu
                mainMenu.p1Color = finalColor[0];
                mainMenu.p2Color = finalColor[1];
                // Main Menu buttons are enabled again
                rule.dispose();
                mainMenu.startGame.setEnabled(true);
                mainMenu.customizeRules.setEnabled(true);
                mainMenu.gameHistory.setEnabled(true);
                mainMenu.menuFrame.setState(Frame.NORMAL);
            }
        });

        // Create button and set up ActionListener for each rule
        JButton buttonSwap = new JButton("ON");
        buttonSwap.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonSwap.setFocusable(false);
        buttonSwap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenu.rules[0] = !mainMenu.rules[0];
                if (mainMenu.rules[0]) {
                    buttonSwap.setText("ON");
                } else {
                    buttonSwap.setText("OFF");
                }
            }
        });

        JButton buttonOb = new JButton("ON");
        buttonOb.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonOb.setFocusable(false);
        buttonOb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenu.rules[1] = !mainMenu.rules[1];
                if (mainMenu.rules[1]) {
                    buttonOb.setText("ON");
                } else {
                    buttonOb.setText("OFF");
                }
            }
        });

        JButton buttonElim = new JButton("ON");
        buttonElim.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonElim.setFocusable(false);
        buttonElim.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenu.rules[2] = !mainMenu.rules[2];
                if (mainMenu.rules[2]) {
                    buttonElim.setText("ON");
                } else {
                    buttonElim.setText("OFF");
                }
            }
        });

        JButton buttonProtect = new JButton("ON");
        buttonProtect.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonProtect.setFocusable(false);
        buttonProtect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenu.rules[3] = !mainMenu.rules[3];
                if (mainMenu.rules[3]) {
                    buttonProtect.setText("ON");
                } else {
                    buttonProtect.setText("OFF");
                }
            }
        });

        JButton buttonSpread = new JButton("ON");
        buttonSpread.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonSpread.setFocusable(false);
        buttonSpread.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenu.rules[4] = !mainMenu.rules[4];
                if (mainMenu.rules[4]) {
                    buttonSpread.setText("ON");
                } else {
                    buttonSpread.setText("OFF");
                }
            }
        });

        JButton buttonP1Color = new JButton("Player 1");
        JButton buttonP2Color = new JButton("Player 2");

        JButton buttonSize = new JButton("Size: Change the size of the grid:");
        buttonSize.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonSize.setFocusable(false);

        // region: Creation for all the size buttons and set backgrounds as null
        JButton size5X5 = new JButton("5*5");
        size5X5.setBackground(null);
        JButton size6X6 = new JButton("6*6");
        size6X6.setBackground(null);
        JButton size7X7 = new JButton("7*7");
        size7X7.setBackground(null);
        JButton size8X8 = new JButton("8*8");
        size8X8.setBackground(Color.LIGHT_GRAY);
        JButton size9X9 = new JButton("9*9");
        size9X9.setBackground(null);
        JButton size10X10 = new JButton("10*10");
        size10X10.setBackground(null);
        // endregion

        // region: Initialize sizes panel and add size buttons into sizes panel
        sizes.setBounds(325, 50, 550, 400);
        sizes.setBackground(Color.WHITE);
        sizes.setBorder(BorderFactory.createRaisedBevelBorder());
        sizes.add(size5X5);
        sizes.add(size6X6);
        sizes.add(size7X7);
        sizes.add(size8X8);
        sizes.add(size9X9);
        sizes.add(size10X10);
        // endregion

        // sizes panel initially invisible, only visible when setting grid size
        sizes.setVisible(false);

        // region: Set ActionListener for each size button in sizes pane
        size5X5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenu.gridSize = 5;
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
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
            }
        });
        size6X6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenu.gridSize = 6;
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
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
            }
        });
        size7X7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenu.gridSize = 7;
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
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
            }
        });
        size8X8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenu.gridSize = 8;
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
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
            }
        });
        size9X9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenu.gridSize = 9;
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
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
            }
        });
        size10X10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenu.gridSize = 10;
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
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
            }
        });
        // endregion

        // Creation of color panel to hold P1Color button, P2Color button and
        // ruleColor label
        JPanel color = new JPanel();
        color.setLayout(new GridLayout(1, 3, 10, 0));

        // region: Create various color buttons for player 1
        JButton p1Red = new JButton(new ImageIcon("CBL\\icons\\red_chosen.png"));
        JButton p1Orange = new JButton(new ImageIcon("CBL\\icons\\orange.png"));
        JButton p1Yellow = new JButton(new ImageIcon("CBL\\icons\\yellow_occupied.png"));
        JButton p1Green = new JButton(new ImageIcon("CBL\\icons\\green.png"));
        JButton p1Cyan = new JButton(new ImageIcon("CBL\\icons\\cyan.png"));
        JButton p1Blue = new JButton(new ImageIcon("CBL\\icons\\blue.png"));
        JButton p1Purple = new JButton(new ImageIcon("CBL\\icons\\purple.png"));
        JButton p1Pink = new JButton(new ImageIcon("CBL\\icons\\pink.png"));
        JButton p1Brown = new JButton(new ImageIcon("CBL\\icons\\brown.png"));
        // endregion

        // region: Adding color icons into p1ColorPick panel
        p1ColorPanel.add(p1Red);
        p1ColorPanel.add(p1Orange);
        p1ColorPanel.add(p1Yellow);
        p1ColorPanel.add(p1Green);
        p1ColorPanel.add(p1Cyan);
        p1ColorPanel.add(p1Blue);
        p1ColorPanel.add(p1Purple);
        p1ColorPanel.add(p1Pink);
        p1ColorPanel.add(p1Brown);
        // endregion

        // set up p1ColorPanel
        p1ColorPanel.setBounds(100, 300, 200, 200);
        p1ColorPanel.setBackground(Color.WHITE);
        p1ColorPanel.setBorder(BorderFactory.createRaisedBevelBorder());

        // region: Creation of choosing-color panel for player 2
        JButton p2RedRed = new JButton(new ImageIcon("CBL\\icons\\red_occupied.png"));
        JButton p2Orange = new JButton(new ImageIcon("CBL\\icons\\orange.png"));
        JButton p2Yellow = new JButton(new ImageIcon("CBL\\icons\\yellow_chosen.png"));
        JButton p2Green = new JButton(new ImageIcon("CBL\\icons\\green.png"));
        JButton p2Cyan = new JButton(new ImageIcon("CBL\\icons\\cyan.png"));
        JButton p2Blue = new JButton(new ImageIcon("CBL\\icons\\blue.png"));
        JButton p2Purple = new JButton(new ImageIcon("CBL\\icons\\purple.png"));
        JButton p2Pink = new JButton(new ImageIcon("CBL\\icons\\pink.png"));
        JButton p2Brown = new JButton(new ImageIcon("CBL\\icons\\brown.png"));
        // endregion

        // region: Adding color icons into p2ColorPick panel
        p2ColorPanel.add(p2RedRed);
        p2ColorPanel.add(p2Orange);
        p2ColorPanel.add(p2Yellow);
        p2ColorPanel.add(p2Green);
        p2ColorPanel.add(p2Cyan);
        p2ColorPanel.add(p2Blue);
        p2ColorPanel.add(p2Purple);
        p2ColorPanel.add(p2Pink);
        p2ColorPanel.add(p2Brown);
        // endregion

        // set up p2ColorPanel
        p2ColorPanel.setBounds(900, 300, 200, 200);
        p2ColorPanel.setBackground(Color.WHITE);
        p2ColorPanel.setBorder(BorderFactory.createRaisedBevelBorder());

        // region Set ActionListener for each color button in p1ColorPanel
        p1Red.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalColor[0] = new Color(255, 0, 0, 255);
                p1Color.setBackground(new Color(255, 0, 0, 255));
                p1Red.setIcon(new ImageIcon("CBL\\icons\\red_chosen.png"));
                p2RedRed.setIcon(new ImageIcon("CBL\\icons\\red_occupied.png"));
                // "back" to CustomizeRule panel
                p1ColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
                // initializing other color buttons
                p1Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p1Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p1Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p1Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p1Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p1Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p1Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p1Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                p2Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p2Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p2Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p2Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p2Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p2Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p2Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p2Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                p2RedRed.setEnabled(false);
                p2Orange.setEnabled(true);
                p2Yellow.setEnabled(true);
                p2Green.setEnabled(true);
                p2Cyan.setEnabled(true);
                p2Blue.setEnabled(true);
                p2Purple.setEnabled(true);
                p2Pink.setEnabled(true);
                p2Brown.setEnabled(true);

            }
        });
        p1Orange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalColor[0] = new Color(237, 141, 0, 255);
                p1Color.setBackground(new Color(237, 141, 0, 255));
                p1Orange.setIcon(new ImageIcon("CBL\\icons\\orange_chosen.png"));
                p2Orange.setIcon(new ImageIcon("CBL\\icons\\orange_occupied.png"));
                p1ColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
                // initializing other color buttons
                p1Red.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p1Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p1Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p1Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p1Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p1Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p1Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p1Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                p2RedRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p2Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p2Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p2Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p2Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p2Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p2Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p2Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                p2RedRed.setEnabled(true);
                p2Orange.setEnabled(false);
                p2Yellow.setEnabled(true);
                p2Green.setEnabled(true);
                p2Cyan.setEnabled(true);
                p2Blue.setEnabled(true);
                p2Purple.setEnabled(true);
                p2Pink.setEnabled(true);
                p2Brown.setEnabled(true);
            }
        });
        p1Yellow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalColor[0] = new Color(255, 239, 40, 255);
                p1Color.setBackground(new Color(255, 239, 40, 255));
                p1Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow_chosen.png"));
                p2Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow_occupied.png"));
                p1ColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
                // initializing other color buttons
                p1Red.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p1Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p1Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p1Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p1Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p1Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p1Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p1Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                p2RedRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p2Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p2Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p2Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p2Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p2Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p2Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p2Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                p2RedRed.setEnabled(true);
                p2Orange.setEnabled(true);
                p2Yellow.setEnabled(false);
                p2Green.setEnabled(true);
                p2Cyan.setEnabled(true);
                p2Blue.setEnabled(true);
                p2Purple.setEnabled(true);
                p2Pink.setEnabled(true);
                p2Brown.setEnabled(true);
            }
        });
        p1Green.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalColor[0] = new Color(131, 201, 55, 255);
                p1Color.setBackground(new Color(131, 201, 55, 255));
                p1Green.setIcon(new ImageIcon("CBL\\icons\\green_chosen.png"));
                p2Green.setIcon(new ImageIcon("CBL\\icons\\green_occupied.png"));
                p1ColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
                // initializing other color buttons
                p1Red.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p1Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p1Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p1Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p1Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p1Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p1Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p1Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                p2RedRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p2Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p2Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p2Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p2Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p2Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p2Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p2Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                p2RedRed.setEnabled(true);
                p2Orange.setEnabled(true);
                p2Yellow.setEnabled(true);
                p2Green.setEnabled(false);
                p2Cyan.setEnabled(true);
                p2Blue.setEnabled(true);
                p2Purple.setEnabled(true);
                p2Pink.setEnabled(true);
                p2Brown.setEnabled(true);
            }
        });
        p1Cyan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalColor[0] = new Color(50, 204, 204, 255);
                p1Color.setBackground(new Color(50, 204, 204, 255));
                p1Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan_chosen.png"));
                p2Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan_occupied.png"));
                p1ColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
                // initializing other color buttons
                p1Red.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p1Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p1Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p1Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p1Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p1Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p1Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p1Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                p2RedRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p2Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p2Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p2Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p2Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p2Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p2Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p2Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                p2RedRed.setEnabled(true);
                p2Orange.setEnabled(true);
                p2Yellow.setEnabled(true);
                p2Green.setEnabled(true);
                p2Cyan.setEnabled(false);
                p2Blue.setEnabled(true);
                p2Purple.setEnabled(true);
                p2Pink.setEnabled(true);
                p2Brown.setEnabled(true);
            }
        });
        p1Blue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalColor[0] = new Color(0, 111, 192, 255);
                p1Color.setBackground(new Color(0, 111, 192, 255));
                p1Blue.setIcon(new ImageIcon("CBL\\icons\\blue_chosen.png"));
                p2Blue.setIcon(new ImageIcon("CBL\\icons\\blue_occupied.png"));
                p1ColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
                // initializing other color buttons
                p1Red.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p1Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p1Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p1Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p1Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p1Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p1Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p1Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                p2RedRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p2Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p2Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p2Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p2Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p2Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p2Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p2Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                p2RedRed.setEnabled(true);
                p2Orange.setEnabled(true);
                p2Yellow.setEnabled(true);
                p2Green.setEnabled(true);
                p2Cyan.setEnabled(true);
                p2Blue.setEnabled(false);
                p2Purple.setEnabled(true);
                p2Pink.setEnabled(true);
                p2Brown.setEnabled(true);
            }
        });
        p1Purple.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalColor[0] = new Color(112, 48, 160, 255);
                p1Color.setBackground(new Color(112, 48, 160, 255));
                p1Purple.setIcon(new ImageIcon("CBL\\icons\\purple_chosen.png"));
                p2Purple.setIcon(new ImageIcon("CBL\\icons\\purple_occupied.png"));
                p1ColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
                // initializing other color buttons
                p1Red.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p1Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p1Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p1Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p1Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p1Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p1Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p1Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                p2RedRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p2Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p2Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p2Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p2Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p2Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p2Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p2Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                p2RedRed.setEnabled(true);
                p2Orange.setEnabled(true);
                p2Yellow.setEnabled(true);
                p2Green.setEnabled(true);
                p2Cyan.setEnabled(true);
                p2Blue.setEnabled(true);
                p2Purple.setEnabled(false);
                p2Pink.setEnabled(true);
                p2Brown.setEnabled(true);
            }
        });
        p1Pink.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalColor[0] = new Color(255, 155, 188, 255);
                p1Color.setBackground(new Color(255, 155, 188, 255));
                p1Pink.setIcon(new ImageIcon("CBL\\icons\\pink_chosen.png"));
                p2Pink.setIcon(new ImageIcon("CBL\\icons\\pink_occupied.png"));
                p1ColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
                // initializing other color buttons
                p1Red.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p1Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p1Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p1Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p1Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p1Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p1Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p1Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                p2RedRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p2Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p2Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p2Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p2Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p2Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p2Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p2Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                p2RedRed.setEnabled(true);
                p2Orange.setEnabled(true);
                p2Yellow.setEnabled(true);
                p2Green.setEnabled(true);
                p2Cyan.setEnabled(true);
                p2Blue.setEnabled(true);
                p2Purple.setEnabled(true);
                p2Pink.setEnabled(false);
                p2Brown.setEnabled(true);
            }
        });
        p1Brown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalColor[0] = new Color(107, 70, 35, 255);
                p1Color.setBackground(new Color(107, 70, 35, 255));
                p1Brown.setIcon(new ImageIcon("CBL\\icons\\brown_chosen.png"));
                p2Brown.setIcon(new ImageIcon("CBL\\icons\\brown_occupied.png"));
                p1ColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
                // initializing other color buttons
                p1Red.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p1Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p1Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p1Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p1Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p1Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p1Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p1Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                // also for buttons in another panel
                p2RedRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p2Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p2Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p2Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p2Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p2Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p2Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p2Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p2RedRed.setEnabled(true);
                p2Orange.setEnabled(true);
                p2Yellow.setEnabled(true);
                p2Green.setEnabled(true);
                p2Cyan.setEnabled(true);
                p2Blue.setEnabled(true);
                p2Purple.setEnabled(true);
                p2Pink.setEnabled(true);
                p2Brown.setEnabled(false);
            }
        });
        // endregion

        // region: Set ActionListener for each color button in p2ColorPanel
        p2RedRed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalColor[1] = new Color(255, 0, 0, 255);
                p2Color.setBackground(new Color(255, 0, 0, 255));
                p2RedRed.setIcon(new ImageIcon("CBL\\icons\\red_chosen.png"));
                p1Red.setIcon(new ImageIcon("CBL\\icons\\red_occupied.png"));
                // "back" to CustomizeRule panel
                p2ColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
                // initializing other color buttons
                p2Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p2Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p2Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p2Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p2Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p2Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p2Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p2Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                p1Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p1Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p1Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p1Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p1Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p1Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p1Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p1Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                p1Red.setEnabled(false);
                p1Orange.setEnabled(true);
                p1Yellow.setEnabled(true);
                p1Green.setEnabled(true);
                p1Cyan.setEnabled(true);
                p1Blue.setEnabled(true);
                p1Purple.setEnabled(true);
                p1Pink.setEnabled(true);
                p1Brown.setEnabled(true);
            }
        });
        p2Orange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalColor[1] = new Color(237, 141, 0, 255);
                p2Color.setBackground(new Color(237, 141, 0, 255));
                p2Orange.setIcon(new ImageIcon("CBL\\icons\\orange_chosen.png"));
                p1Orange.setIcon(new ImageIcon("CBL\\icons\\orange_occupied.png"));
                // "back" to CustomizeRule panel
                p2ColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
                // initializing other color buttons
                p2RedRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p2Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p2Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p2Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p2Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p2Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p2Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p2Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                p1Red.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p1Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p1Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p1Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p1Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p1Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p1Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p1Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                p1Red.setEnabled(true);
                p1Orange.setEnabled(false);
                p1Yellow.setEnabled(true);
                p1Green.setEnabled(true);
                p1Cyan.setEnabled(true);
                p1Blue.setEnabled(true);
                p1Purple.setEnabled(true);
                p1Pink.setEnabled(true);
                p1Brown.setEnabled(true);
            }
        });
        p2Yellow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalColor[1] = new Color(255, 239, 40, 255);
                p2Color.setBackground(new Color(255, 239, 40, 255));
                p2Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow_chosen.png"));
                p1Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow_occupied.png"));
                // "back" to CustomizeRule panel
                p2ColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
                // initializing other color buttons
                p2RedRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p2Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p2Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p2Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p2Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p2Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p2Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p2Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                p1Red.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p1Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p1Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p1Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p1Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p1Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p1Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p1Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                p1Red.setEnabled(true);
                p1Orange.setEnabled(true);
                p1Yellow.setEnabled(false);
                p1Green.setEnabled(true);
                p1Cyan.setEnabled(true);
                p1Blue.setEnabled(true);
                p1Purple.setEnabled(true);
                p1Pink.setEnabled(true);
                p1Brown.setEnabled(true);
            }
        });
        p2Green.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalColor[1] = new Color(131, 201, 55, 255);
                p2Color.setBackground(new Color(131, 201, 55, 255));
                p2Green.setIcon(new ImageIcon("CBL\\icons\\green_chosen.png"));
                p1Green.setIcon(new ImageIcon("CBL\\icons\\green_occupied.png"));
                // "back" to CustomizeRule panel
                p2ColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
                // initializing other color buttons
                p2RedRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p2Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p2Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p2Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p2Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p2Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p2Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p2Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                p1Red.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p1Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p1Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p1Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p1Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p1Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p1Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p1Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                p1Red.setEnabled(true);
                p1Orange.setEnabled(true);
                p1Yellow.setEnabled(true);
                p1Green.setEnabled(false);
                p1Cyan.setEnabled(true);
                p1Blue.setEnabled(true);
                p1Purple.setEnabled(true);
                p1Pink.setEnabled(true);
                p1Brown.setEnabled(true);
            }
        });
        p2Cyan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalColor[1] = new Color(50, 204, 204, 255);
                p2Color.setBackground(new Color(50, 204, 204, 255));
                p2Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan_chosen.png"));
                p1Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan_occupied.png"));
                // "back" to CustomizeRule panel
                p2ColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
                // initializing other color buttons
                p2RedRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p2Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p2Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p2Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p2Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p2Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p2Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p2Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                p1Red.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p1Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p1Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p1Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p1Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p1Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p1Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p1Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                p1Red.setEnabled(true);
                p1Orange.setEnabled(true);
                p1Yellow.setEnabled(true);
                p1Green.setEnabled(true);
                p1Cyan.setEnabled(false);
                p1Blue.setEnabled(true);
                p1Purple.setEnabled(true);
                p1Pink.setEnabled(true);
                p1Brown.setEnabled(true);
            }
        });
        p2Blue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalColor[1] = new Color(0, 111, 192, 255);
                p2Color.setBackground(new Color(0, 111, 192, 255));
                p2Blue.setIcon(new ImageIcon("CBL\\icons\\blue_chosen.png"));
                p1Blue.setIcon(new ImageIcon("CBL\\icons\\blue_occupied.png"));
                // "back" to CustomizeRule panel
                p2ColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
                // initializing other color buttons
                p2RedRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p2Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p2Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p2Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p2Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p2Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p2Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p2Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                p1Red.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p1Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p1Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p1Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p1Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p1Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p1Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p1Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                p1Red.setEnabled(true);
                p1Orange.setEnabled(true);
                p1Yellow.setEnabled(true);
                p1Green.setEnabled(true);
                p1Cyan.setEnabled(true);
                p1Blue.setEnabled(false);
                p1Purple.setEnabled(true);
                p1Pink.setEnabled(true);
                p1Brown.setEnabled(true);
            }
        });
        p2Purple.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalColor[1] = new Color(112, 48, 160, 255);
                p2Color.setBackground(new Color(112, 48, 160, 255));
                p2Purple.setIcon(new ImageIcon("CBL\\icons\\purple_chosen.png"));
                p1Purple.setIcon(new ImageIcon("CBL\\icons\\purple_occupied.png"));
                // "back" to CustomizeRule panel
                p2ColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
                // initializing other color buttons
                p2RedRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p2Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p2Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p2Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p2Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p2Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p2Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p2Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                p1Red.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p1Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p1Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p1Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p1Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p1Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p1Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p1Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                p1Red.setEnabled(true);
                p1Orange.setEnabled(true);
                p1Yellow.setEnabled(true);
                p1Green.setEnabled(true);
                p1Cyan.setEnabled(true);
                p1Blue.setEnabled(true);
                p1Purple.setEnabled(false);
                p1Pink.setEnabled(true);
                p1Brown.setEnabled(true);
            }
        });
        p2Pink.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalColor[1] = new Color(255, 155, 188, 255);
                p2Color.setBackground(new Color(255, 155, 188, 255));
                p2Pink.setIcon(new ImageIcon("CBL\\icons\\pink_chosen.png"));
                p1Pink.setIcon(new ImageIcon("CBL\\icons\\pink_occupied.png"));
                // "back" to CustomizeRule panel
                p2ColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
                // initializing other color buttons
                p2RedRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p2Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p2Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p2Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p2Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p2Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p2Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p2Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                // also for buttons in another panel
                p1Red.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p1Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p1Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p1Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p1Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p1Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p1Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p1Brown.setIcon(new ImageIcon("CBL\\icons\\brown.png"));
                p1Red.setEnabled(true);
                p1Orange.setEnabled(true);
                p1Yellow.setEnabled(true);
                p1Green.setEnabled(true);
                p1Cyan.setEnabled(true);
                p1Blue.setEnabled(true);
                p1Purple.setEnabled(true);
                p1Pink.setEnabled(false);
                p1Brown.setEnabled(true);
            }
        });
        p2Brown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalColor[1] = new Color(107, 70, 35, 255);
                p2Color.setBackground(new Color(107, 70, 35, 255));
                p2Brown.setIcon(new ImageIcon("CBL\\icons\\brown_chosen.png"));
                p1Brown.setIcon(new ImageIcon("CBL\\icons\\brown_occupied.png"));
                // "back" to CustomizeRule panel
                p2ColorPanel.setVisible(false);
                buttonSize.setEnabled(true);
                buttonElim.setEnabled(true);
                buttonOb.setEnabled(true);
                buttonSwap.setEnabled(true);
                buttonSave.setEnabled(true);
                buttonSpread.setEnabled(true);
                buttonProtect.setEnabled(true);
                buttonP1Color.setEnabled(true);
                buttonP2Color.setEnabled(true);
                // initializing other color buttons
                p2RedRed.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p2Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p2Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p2Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p2Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p2Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p2Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p2Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                // also for buttons in another panel
                p1Red.setIcon(new ImageIcon("CBL\\icons\\red.png"));
                p1Orange.setIcon(new ImageIcon("CBL\\icons\\orange.png"));
                p1Yellow.setIcon(new ImageIcon("CBL\\icons\\yellow.png"));
                p1Green.setIcon(new ImageIcon("CBL\\icons\\green.png"));
                p1Cyan.setIcon(new ImageIcon("CBL\\icons\\cyan.png"));
                p1Blue.setIcon(new ImageIcon("CBL\\icons\\blue.png"));
                p1Purple.setIcon(new ImageIcon("CBL\\icons\\purple.png"));
                p1Pink.setIcon(new ImageIcon("CBL\\icons\\pink.png"));
                p1Red.setEnabled(true);
                p1Orange.setEnabled(true);
                p1Yellow.setEnabled(true);
                p1Green.setEnabled(true);
                p1Cyan.setEnabled(true);
                p1Blue.setEnabled(true);
                p1Purple.setEnabled(true);
                p1Pink.setEnabled(true);
                p1Brown.setEnabled(false);
            }
        });
        // endregion

        buttonP1Color.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonP1Color.setSize(700, 200);
        buttonP1Color.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                p1ColorPanel.setVisible(true);
                p2ColorPanel.setVisible(false);
                // unable to choose again before choosing the color of red
                buttonSize.setEnabled(false);
                buttonElim.setEnabled(false);
                buttonOb.setEnabled(false);
                buttonSwap.setEnabled(false);
                buttonSave.setEnabled(false);
                buttonSpread.setEnabled(false);
                buttonProtect.setEnabled(false);
                buttonP1Color.setEnabled(false);
                buttonP2Color.setEnabled(false);
            }
        });

        buttonP2Color.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonP2Color.setSize(700, 200);
        buttonP2Color.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                p2ColorPanel.setVisible(true);
                p1ColorPanel.setVisible(false);
                // unable to choose again before choosing the color of red
                buttonSize.setEnabled(false);
                buttonElim.setEnabled(false);
                buttonOb.setEnabled(false);
                buttonSwap.setEnabled(false);
                buttonSave.setEnabled(false);
                buttonSpread.setEnabled(false);
                buttonProtect.setEnabled(false);
                buttonP2Color.setEnabled(false);
                buttonP1Color.setEnabled(false);
            }
        });

        // Creation of JLabel for each rule description except for GridSize
        JLabel ruleSwap = new JLabel(
                "<html>Swap: Cover a given square in the opponent's color previously with your color."
                        + "(last: permanent; cd: 1 round)<html>");
        ruleSwap.setAlignmentX(Component.CENTER_ALIGNMENT);
        ruleSwap.setFont(new Font("Arial", Font.BOLD, 15));
        ruleSwap.setBounds(50, 50, 200, 200);

        JLabel ruleOb = new JLabel(
                "<html>Obstacle: Set an obstacle in a given square."
                        + "The square with obstacle in can't be the object of any other items."
                        + "(last: 4 rounds; cd: 1 round)<html>");
        ruleOb.setAlignmentX(Component.CENTER_ALIGNMENT);
        ruleOb.setFont(new Font("Arial", Font.BOLD, 15));
        ruleOb.setBounds(50, 50, 200, 200);

        JLabel ruleElim = new JLabel(
                "<html>Eliminate: Eliminate the color in a given"
                        + "square. (last: permanent; cd: 1 round)<html>");
        ruleElim.setAlignmentX(Component.CENTER_ALIGNMENT);
        ruleElim.setFont(new Font("Arial", Font.BOLD, 15));
        ruleElim.setBounds(50, 50, 200, 200);

        JLabel ruleProtect = new JLabel("<html>Protect: protect a square, "
                + "the square can't be \nchosen as an object for any other rules in next round<html>");
        ruleProtect.setAlignmentX(Component.CENTER_ALIGNMENT);
        ruleProtect.setFont(new Font("Arial", Font.BOLD, 15));
        ruleProtect.setBounds(50, 50, 200, 200);

        JLabel ruleSpread = new JLabel("<html>Spread: a square in 8 arounded squares of"
                + "the selected square will be colored after 2 rounds<html>");
        ruleSpread.setAlignmentX(Component.CENTER_ALIGNMENT);
        ruleSpread.setFont(new Font("Arial", Font.BOLD, 15));
        ruleSpread.setBounds(50, 50, 200, 200);

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

        JPanel protect = new JPanel(new GridLayout(1, 2, 10, 10));
        // add mentioned components into the protect panel
        protect.add(ruleProtect);
        protect.add(buttonProtect);

        JPanel spread = new JPanel(new GridLayout(1, 2, 10, 10));
        // add mentioned components into the protect panel
        spread.add(ruleSpread);
        spread.add(buttonSpread);

        // shape a proper layout for save button, no extra function
        JPanel save = new JPanel();
        save.add(buttonSave);
        save.setLayout(new GridLayout(1, 3, 0, 10));

        // set up rulesize(button)
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
                buttonSpread.setEnabled(false);
                buttonProtect.setEnabled(false);
                buttonP1Color.setEnabled(false);
                buttonP2Color.setEnabled(false);

            }
        });

        // add mentioned components into the color panel
        color.add(buttonP1Color);
        color.add(p1Color);
        color.add(ruleColor);
        color.add(p2Color);
        color.add(buttonP2Color);

        // set up pane and add components into pane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1200, 820);

        // adding components into pane
        layeredPane.add(sizes);
        layeredPane.add(p1ColorPanel);
        layeredPane.add(p2ColorPanel);
        layeredPane.add(rulePanel);
        // add rulePanel into rule frame
        rule.add(layeredPane);

        // adding components into rule panel
        rulePanel.add(buttonSize);
        rulePanel.add(elim);
        rulePanel.add(ob);
        rulePanel.add(swap);
        rulePanel.add(protect);
        rulePanel.add(spread);
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

    // remained to establish:

    // clicking on save button, close CustomizeRules window and go back to
    // mainmenu(done)
    // adding protect and spred rules into CustomizeRule class(done)
    // complete the description of spread rules
    // calculation for each rule to decide specific lasting time and cooldown time
    // data
    // passing size data to StartGame
    // passing rules' on/off condition to StartGame(done)
    // passing rules' lasting time and cooldown time datas to StartGame and show
    // passing colors datas to StartGame(done)
}
