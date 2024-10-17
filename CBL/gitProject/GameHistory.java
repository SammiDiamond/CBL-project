package CBL.gitProject;

import java.awt.*;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class GameHistory {

    // Declaration the MainMenu object
    MainMenu mainMenu;

    // Declare an arrayList to store the total amount of games
    ArrayList<GameDetails> totalGames = new ArrayList<GameDetails>();

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

        // Reading all game data and storing them to the totalGames ArrayList object
        readFromFile();

        // Initialize all game history panels
        JPanel[] historyPanels = new JPanel[totalGames.size()];

        for (int i = 0; i < totalGames.size(); i++) {

            // Initialize all Labels containing information for each game
            JLabel gameCount = new JLabel("Game " + i + ":");
            JLabel datePlayed = new JLabel(totalGames.get(i).getDate());
            JLabel rounds = new JLabel(totalGames.get(i).getRounds());
            JLabel gridSize = new JLabel(totalGames.get(i).getGridSize());
            Color p1Color = totalGames.get(i).getP1ColorCode();
            Color p2Color = totalGames.get(i).getP2ColorCode();
        }
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

                // String array to hold all split data from the data String
                String[] dataSplit = data.split(" ");

                // Initialize variables to call GameDetails constructor
                int winner = Integer.parseInt(dataSplit[0]);
                boolean[] chosenRules = new boolean[5];
                for (int i = 0; i < chosenRules.length; i++) {
                    chosenRules[i] = Boolean.parseBoolean(dataSplit[i + 1]);
                }
                int rounds = Integer.parseInt(dataSplit[6]);
                int gridSize = Integer.parseInt(dataSplit[7]);
                LocalDate date = LocalDate.parse(dataSplit[8],
                    DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                // For the Color, we use a regular expression pattern and matcher objects
                Pattern colorPattern = Pattern
                    .compile("java\\.awt\\.Color\\[r=(\\d+),g=(\\d+),b=(\\d+)\\]");

                Matcher p1Matcher = colorPattern.matcher(dataSplit[9]);
                Color p1Color = Color.WHITE;
                if (p1Matcher.find()) {
                    int p1Red = Integer.parseInt(p1Matcher.group(1));
                    int p1Green = Integer.parseInt(p1Matcher.group(2));
                    int p1Blue = Integer.parseInt(p1Matcher.group(3));
                    p1Color = new Color(p1Red, p1Green, p1Blue);
                }

                Matcher p2Matcher = colorPattern.matcher(dataSplit[10]);
                Color p2Color = Color.WHITE;
                if (p2Matcher.find()) {
                    int p2Red = Integer.parseInt(p1Matcher.group(1));
                    int p2Green = Integer.parseInt(p1Matcher.group(2));
                    int p2Blue = Integer.parseInt(p1Matcher.group(3));
                    p2Color = new Color(p2Red, p2Green, p2Blue);
                }

                // Initialize a new GameDetails object
                GameDetails game = new GameDetails(winner, chosenRules, rounds, gridSize,
                    date, p1Color, p2Color);

                // Add the GameDetails object to the arrayList
                totalGames.add(game);
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
    private boolean[] rules = new boolean[5];
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
    GameDetails(MainMenu mainMenu, int winner, boolean[] rules, int rounds,  int gridSize) {

        this.mainMenu = mainMenu;
        this.winner = winner;
        this.rules = rules;
        this.rounds = rounds;
        this.gridSize = gridSize;
        this.date = LocalDate.now();
        this.p1Color = mainMenu.p1Color;
        this.p2Color = mainMenu.p2Color;
    }

    /**
     * 
     * @param winner
     * @param rules
     * @param gridSize
     * @param rounds
     */
    GameDetails(int winner, boolean[] rules, int rounds, int gridSize,
        LocalDate date, Color p1Color, Color p2Color) {

        this.winner = winner;
        this.rules = rules;
        this.rounds = rounds;
        this.gridSize = gridSize;
        this.date = date;
        this.p1Color = p1Color;
        this.p2Color = p2Color;
    }

    // Initialize getters that return the variable values in String
    public String getWinner() {
        return Integer.toString(winner);
    }

    public String getRules() {
        String str = "";
        for (int i = 0; i < rules.length; i++) {
            if (rules[i]) {
                str = str + "true ";
            } else {
                str = str + "false ";
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

    public Color getP1ColorCode() {
        return p1Color;
    }

    public Color getP2ColorCode() {
        return p2Color;
    }


    /**
     * 
     */
    public void writeToFile() {
        try {
            File txtFile = new File("CBL\\gitProject\\gameHistory.txt");
            FileWriter writer = new FileWriter("CBL\\gitProject\\gameHistory.txt", true);
            writer.write(getWinner()
                + " " + getRules()
                + "" + getRounds()
                + " " + getGridSize()
                + " " + getDate()
                + " " + getP1Color()
                + " " + getP2Color()
                + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}