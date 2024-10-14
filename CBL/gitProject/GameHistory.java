package CBL.gitProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameHistory {

    // Declaration the MainMenu object
    MainMenu mainMenu;

    /**
     * Constructor responsible for the GUI for the gameplay.
     * 
     * @param menu Specific MainMenu object whose instance variables are used within
     *             GameHistory.
     */

    GameHistory(MainMenu menu) {
        // Contents of menu are stored into the mainMenu instance variable
        this.mainMenu = menu;

        // Buttons in the previous window are disabled and window is minimized
        mainMenu.menuFrame.setState(JFrame.ICONIFIED);
        mainMenu.startGame.setEnabled(false);
        mainMenu.customizeRules.setEnabled(false);
        mainMenu.gameHistory.setEnabled(false);

        // rule frame is initialized for the rulecustomization
        JFrame history = new JFrame();

        // history frame details are assigned
        history.setSize(1200, 855);
        history.setLocationRelativeTo(null);
        history.setLayout(null);
        history.setVisible(true);

        // Creating details panel for each game history
        JPanel history1 = new JPanel();

        /*
         * To-do list for GameHistory class:
         ** 
         * getting game details from StartGame class
         ** ciding how many gamehistory panel to show
         ** adding details (colors for each player, final grid, total round number to end
         * the game, gamehistory code) for each gamehistory
         ** building database to store gamehistory
         ** buttons for shown panel going up and down
         */
    }
}
