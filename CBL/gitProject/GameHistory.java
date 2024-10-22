package CBL.gitProject;

import java.awt.*;
import java.awt.event.*;
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

        // Initialize new JPanel and JLabel to state the details of each column
        JPanel colPanel = new JPanel();
        colPanel.setSize(1150, 40);
        JLabel colDetails = new JLabel("Game Count   P1 VS P2    Date   R G              Rules              Winner");
        colDetails.setFont(new Font("Lucida Console", Font.PLAIN, 25));
        colPanel.setLocation(0, 15);

        // total JPanel details
        JPanel total = new JPanel();
        total.setVisible(true);
        total.setSize(1200, 1000);
        total.setLayout(new GridLayout(totalGames.size(), 20, 20, 20));
        total.setBackground(Color.WHITE);

        JPanel[] historyPanels = new JPanel[totalGames.size()];
        String[] ruleName = { "Swap", "Obstacle", "Eliminate", "Protect", "Spread" };

        for (int i = totalGames.size() - 1; i > -1; i--) {
            // Initialize all Labels containing information for each game
            JPanel subPanel = new JPanel();
            // subPanel that will hold all of the game details is initialized for every game
            subPanel.setLayout(new FlowLayout(9));
            subPanel.setSize(700, 50);
            subPanel.setBackground(Color.WHITE);

            JPanel p1Panel = new JPanel();
            // settings for p1Panel
            p1Panel.setLayout(null);
            p1Panel.setPreferredSize(new Dimension(40, 40));

            JPanel p2Panel = new JPanel();
            // settings for p2Panel
            p2Panel.setLayout(null);
            p2Panel.setPreferredSize(new Dimension(40, 40));

            // Initialize all components for the subPanel
            JLabel vs = new JLabel();
            JLabel winLabel = new JLabel();
            String winner = "";
            String r = "";
            String[] ruleStringSplit = totalGames.get(i).getRules().split(" ");
            for (int k = 0; k < ruleStringSplit.length; k++) {
                if (ruleStringSplit[k].equals("true")) {
                    r += ruleName[k] + " ";
                }
            }
            JLabel ruleLabel = new JLabel(String.format("%-" + 39 + "s", r ));
            ruleLabel.setFont(new Font("Lucida Console", Font.PLAIN, 20));
            JLabel gameCount = new JLabel(String.format("%-" + 9 + "s", "Game " +
                Integer.toString(i + 1) + ":"));
            gameCount.setFont(new Font("Lucida Console", Font.PLAIN, 30));
            JLabel datePlayed = new JLabel(" " + totalGames.get(i).getDate() + " ");
            datePlayed.setFont(new Font("Lucida Console", Font.PLAIN, 20));
            JLabel rounds = new JLabel(String.format("%-" + 2 + "s",
                totalGames.get(i).getRounds()));
            rounds.setFont(new Font("Lucida Console", Font.PLAIN, 20));
            JLabel gridSize = new JLabel(String.format("%-" + 3 + "s",
                totalGames.get(i).getGridSize()));
            gridSize.setFont(new Font("Lucida Console", Font.PLAIN, 20));
            Color p1Color = totalGames.get(i).getP1ColorCode();
            p1Panel.setBackground(p1Color);
            Color p2Color = totalGames.get(i).getP2ColorCode();
            p2Panel.setBackground(p2Color);
            winner = totalGames.get(i).getWinner();
            if (winner.equals("1") || winner.equals("2")) {
                winLabel.setText(winner + "  Won");
            } else if (winner.equals("-1")) {
                winLabel.setText("1 Gave Up");
            } else if (winner.equals("-2")) {
                winLabel.setText("2 Gave Up");
            }
            winLabel.setFont(new Font("Lucida Console", Font.PLAIN, 20));
            vs.setText("V.S.");
            vs.setFont(new Font("Lucida Console", Font.PLAIN, 30));

            // Adding every component to a subPanel
            subPanel.add(gameCount);
            subPanel.add(p1Panel);
            subPanel.add(vs);
            subPanel.add(p2Panel);
            subPanel.add(datePlayed);
            subPanel.add(rounds);
            subPanel.add(gridSize);
            subPanel.add(ruleLabel);
            subPanel.add(winLabel);
            subPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            historyPanels[i] = subPanel;
            historyPanels[i].setVisible(true);
            total.add(historyPanels[i]);

        }

        // Initialize buttonPanel and set up its details
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setSize(370, 120);
        buttonPanel.setLocation(400, 730);

        // Event is added to JButton to dispose of previous frames and return to Main
        // Menu
        JButton exitButton = new JButton("Return to Main Menu");
        exitButton.setFont(new Font("Arial", Font.BOLD, 30));
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Main Menu buttons are enabled again
                mainMenu.startGame.setEnabled(true);
                mainMenu.customizeRules.setEnabled(true);
                mainMenu.gameHistory.setEnabled(true);

                history.dispose();
                mainMenu.menuFrame.setState(Frame.NORMAL);
            }
        });

        // exitButton is added to buttonPanel
        buttonPanel.add(exitButton);

        // colDetails is added to colPanel
        colPanel.add(colDetails, SwingConstants.CENTER);

        // Initialize all game history panels
        JScrollPane scrolling = new JScrollPane(total);

        // history frame details are assigned
        scrolling.setBounds(5, 60, 1180, 660);
        scrolling.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrolling.setVisible(true);
        scrolling.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        history.add(colPanel);
        history.getContentPane().add(scrolling);
        history.add(buttonPanel);
    }

    /**
     * Void method that reads all data from the gameHistory.txt and stores it in a GameDetails obj.
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
                    int p2Red = Integer.parseInt(p2Matcher.group(1));
                    int p2Green = Integer.parseInt(p2Matcher.group(2));
                    int p2Blue = Integer.parseInt(p2Matcher.group(3));
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
     * @param rules    boolean array: true for each rule that is enabled
     * @param gridSize integer: 7, 8, 9, 10, 11, 12 for the grid size
     * @param rounds   integer: the total number of rounds played in a match
     * @param winner   integer: 1 if player 1 won, 2 if player 2 won, 0 if it was a draw            
     */
    GameDetails(MainMenu mainMenu, int winner, boolean[] rules, int rounds, int gridSize) {

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
     * GameDetails class stores all details of a game in a singular unit.
     * 
     * @param winner integer: 1 if player 1 one, 2 if player 2 won
     * @param rules boolean array: true for any rule that was enabled, false if any rule was not
     * @param gridSize integer: 5 for 5x5, 6 for 6x6, 7 for 7x7, 8 for 8x8, 9 for 9x9, 10 for 10x10
     * @param rounds integer: stores the number of rounds the game lasted for
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
     * Void method that writes a game that was just played to the gameHistory.txt file.
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