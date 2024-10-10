package CBL.gitProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Class creates an instance of rule customization when "Customize Rule" button
 * is pressed.
 */
public class CustomizeRules {

        // Declaration the MainMenu object
        MainMenu mainMenu;

        /**
         * Constructor responsible for the GUI for the rulecustomization.
         * 
         * @param menu Specific MainMenu object whose instance variables are used within
         *             CustomizeRules.
         */
        CustomizeRules(MainMenu menu) {
                // Contents of menu are stored into the mainMenu instance variable
                this.mainMenu = menu;

                // Creation of JButton for each rule
                JButton buttonSwap = new JButton();
                JButton buttonOb = new JButton();
                JButton buttonElim = new JButton();
                JButton leftColor = new JButton();
                JButton rightColor = new JButton();

                JButton save = new JButton();

                // Creation of boolean values for each rule's button, true/false indicating rule
                // on/off
                boolean buttonSwapOn = false;
                boolean buttonObOn = false;
                boolean buttonElimOn = false;
                boolean buttonLeftColor = false;
                boolean buttonRightColor = false;

                // Buttons in the previous window are disabled and window is minimized
                mainMenu.menuFrame.setState(JFrame.ICONIFIED);
                mainMenu.startGame.setEnabled(false);
                mainMenu.customizeRules.setEnabled(false);
                mainMenu.gameHistory.setEnabled(false);

                // JFrame is initialized for the gameplay
                JFrame rule = new JFrame();

                // Creation of JLabel for each rule

                JLabel ruleSize = new JLabel("Change the size of the grid:");
                ruleSize.setAlignmentX(Component.CENTER_ALIGNMENT);
                ruleSize.setFont(new Font("Arial", Font.BOLD, 35));

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
                // More rules to be added here

                // Creation of ruleSize
                JPanel sizes = new JPanel();
                JButton size5X5 = new JButton();
                JButton size6X6 = new JButton();
                JButton size7X7 = new JButton();
                JButton size8X8 = new JButton();
                JButton size9X9 = new JButton();
                JButton size10X10 = new JButton();

                sizes.add(size5X5);
                sizes.add(size6X6);
                sizes.add(size7X7);
                sizes.add(size8X8);
                sizes.add(size9X9);
                sizes.add(size10X10);

        }
}
