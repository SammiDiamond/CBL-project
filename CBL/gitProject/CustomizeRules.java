package CBL.gitProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Class creates an instance of rule customization when "Customize Rule" button
 * is pressed in main menu
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
                rulePanel.setLayout(new GridLayout(5, 1, 10, 10));

                // Creation of boolean values for each rule's button, true/false indicating rule
                // on/off
                boolean buttonSwapOn = false;
                boolean buttonObOn = false;
                boolean buttonElimOn = false;
                boolean buttonLeftColorOn = false;
                boolean buttonRightColorOn = false;

                // Creation of size panel and buttons inside
                JPanel sizes = new JPanel(new GridLayout(2, 1, 10, 10));
                JButton size5X5 = new JButton("5*5");
                JButton size6X6 = new JButton("6*6");
                JButton size7X7 = new JButton("7*7");
                JButton size8X8 = new JButton("8*8");
                JButton size9X9 = new JButton("9*9");
                JButton size10X10 = new JButton("10*10");

                // add size buttons into sizes panel
                sizes.add(size5X5);
                sizes.add(size6X6);
                sizes.add(size7X7);
                sizes.add(size8X8);
                sizes.add(size9X9);
                sizes.add(size10X10);
                sizes.setLayout(new GridLayout(1, 5, 0, 0));
                sizes.setVisible(false);

                // Creation of JButton for each rule
                JButton save = new JButton("Save");
                save.setBorder(BorderFactory.createRaisedBevelBorder());
                JButton buttonSwap = new JButton("ON/OFF");
                buttonSwap.setBorder(BorderFactory.createRaisedBevelBorder());
                JButton buttonOb = new JButton("ON/OFF");
                buttonOb.setBorder(BorderFactory.createRaisedBevelBorder());
                JButton buttonElim = new JButton("ON/OFF");
                buttonElim.setBorder(BorderFactory.createRaisedBevelBorder());

                JButton buttonLeftColor = new JButton("left");
                buttonLeftColor.setBorder(BorderFactory.createRaisedBevelBorder());
                JButton buttonRightColor = new JButton("right");
                buttonRightColor.setBorder(BorderFactory.createRaisedBevelBorder());

                JButton ruleSize = new JButton("Size: Change the size of the grid:");

                // Creation of JLabel for each rule description except for GridSize
                JLabel ruleSwap = new JLabel(
                                "Swap: Cover a given square in the opponent's color previously with your color."
                                                + "(last: permanent; cd: 1 round)");
                ruleSwap.setAlignmentX(Component.CENTER_ALIGNMENT);
                ruleSwap.setFont(new Font("Arial", Font.BOLD, 35));

                JLabel ruleOb = new JLabel(
                                "Obstacle: Set an obstacle in a given square."
                                                + "The square with obstacle in can't be the object of any other items."
                                                + "(last: 4 rounds; cd: 1 round)");
                ruleOb.setAlignmentX(Component.CENTER_ALIGNMENT);
                ruleOb.setFont(new Font("Arial", Font.BOLD, 35));

                JLabel ruleElim = new JLabel(
                                "Eliminate: Eliminate the color in a given square. (last: permanent; cd: 1 round)");
                ruleElim.setAlignmentX(Component.CENTER_ALIGNMENT);
                ruleElim.setFont(new Font("Arial", Font.BOLD, 35));

                JLabel ruleColor = new JLabel("Choose your color!");
                ruleColor.setAlignmentX(Component.CENTER_ALIGNMENT);
                ruleColor.setFont(new Font("Arial", Font.BOLD, 35));
                // More rules to be added here

                // Creation of color panel to hold leftColor button, rightColor button and
                // ruleColor label
                JPanel color = new JPanel();

                // Creation of choosingcolor panel for each side
                JPanel leftColorPick = new JPanel();
                JPanel rightColorPick = new JPanel();

                // create various color buttons for each side here later

                // set up rulesize
                ruleSize.setAlignmentX(Component.CENTER_ALIGNMENT);
                ruleSize.setFont(new Font("Arial", Font.BOLD, 35));
                ruleSize.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {

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

                // add two buttons in to color label and let text in the middle
                color.add(buttonRightColor);
                color.add(buttonLeftColor);

                // add ruleSize button
                rulePanel.add(ruleSize);

                // tadd description labels for rules
                rulePanel.add(ruleElim);
                rulePanel.add(ruleOb);
                rulePanel.add(ruleSwap);

                // add rule on/ off buttons
                rulePanel.add(buttonElim);
                rulePanel.add(buttonOb);
                rulePanel.add(buttonSwap);

                // add the color panel for all color components
                rulePanel.add(color);

                // add save button
                rulePanel.add(save);

                // rulePanel Layout

                rulePanel.setSize(1200, 820);
                rulePanel.setVisible(true);

                // add rulePanel into rule frame
                rule.add(rulePanel);

                // game frame details are assigned
                rule.setSize(1200, 820);
                rule.setLocationRelativeTo(null);
                rule.setLayout(null);
                rule.setVisible(true);
        }
}
