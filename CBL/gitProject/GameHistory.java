package CBL.gitProject;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;

public class GameHistory {

    // Declaration the MainMenu object
    MainMenu mainMenu;
    ArrayList<String> totalGames = new ArrayList<String>();

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
        readFromFile();

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

    /**
     * 
     */
    void readFromFile() {
        try {
            File txtFile = new File("CBL\\gitProject\\gameHistory.txt");
            BufferedReader reader = new BufferedReader(new FileReader(txtFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String data = line;
                totalGames.add(data);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * GameDetails class stores all details of a game.
 */
class GameDetails {

    MainMenu mainMenu;
    
    // Declare instance variables
    private int winner;
    private boolean[] rules;
    private int rounds;
    private int gridSize;
    private LocalDate date;
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
    GameDetails(MainMenu mainMenu, int winner, boolean[] rules, int gridSize, int rounds) {

        this.mainMenu = mainMenu;
        this.winner = winner;
        this.rules = rules;
        this.rounds = rounds;
        this.gridSize = gridSize;
        this.date = LocalDate.now();
        this.p1Color = mainMenu.p1Color;
        this.p2Color = mainMenu.p2Color;
    }

    // Initialize getters that return the variable values in String
    public String getWinner() {
        return Integer.toString(winner);
    }

    public String getRules() {
        String str = "";
        for (int i = 0; i < rules.length; i++) {
            if (rules[i]) {
                str = str + " true";
            } else {
                str = str + " false";
            }
        }
        return str;
    }

    public String getGridSize() {
        return Integer.toString(gridSize);
    }

    public String getRounds() {
        return Integer.toString(rounds);
    }

    public String getDate() {
        return date.toString();
    }

    public String getP1Color() {
        return p1Color.toString();
    }

    public String getP2Color() {
        return p2Color.toString();
    }

    /**
     * 
     */
    public void writeToFile() {
        try {
            File txtFile = new File("CBL\\gitProject\\gameHistory.txt");
            FileWriter writer = new FileWriter("CBL\\gitProject\\gameHistory.txt");
            writer.write(getWinner()
                + " " + getRules()
                + " " + getRounds()
                + " " + getGridSize()
                + " " + getDate()
                + " " + getP1Color()
                + " " + getP2Color() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}