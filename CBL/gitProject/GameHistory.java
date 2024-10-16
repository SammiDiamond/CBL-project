package CBL.gitProject;

import java.awt.*;
import java.time.LocalDate;
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


class GameDetails {

    MainMenu mainMenu;
    
    // Declare instance variables
    private LocalDate date;
    private boolean[] rules;
    private int gridSize;
    private int rounds;
    private int winner;
    private Color p1Color;
    private Color p2Color;

    /**
     * GameDetails constructor.
     * 
     * @param rules boolean array: true for each rule that is enabled
     * @param gridSize integer: 7, 8, 9, 10, 11, 12 for the grid size
     * @param rounds integer: the total number of rounds played in a match
     * @param winner integer: 1 if player 1 won, 2 if player 2 won, 0 if it was a draw
     */
    GameDetails(MainMenu mainMenu, boolean[] rules, int gridSize, int rounds, int winner) {

        this.mainMenu = mainMenu;
        this.date = LocalDate.now();
        this.rules = rules;
        this.gridSize = gridSize;
        this.rounds = rounds;
        this.p1Color = mainMenu.p1Color;
        this.p2Color = mainMenu.p2Color;
    }

    // Initialize Getters for all instance variables
    public String getDate() {
        return date.toString();
    }

    public String getRules() {
        return rules.toString();
    }

    public String getGridSize() {
        return Integer.toString(gridSize);
    }

    public String getRounds() {
        return Integer.toString(rounds);
    }

    public String getWinner() {
        return Integer.toString(winner);
    }

    public String getP1Color() {
        return p1Color.toString();
    }

    public String getP2Color() {
        return p2Color.toString();
    }
}