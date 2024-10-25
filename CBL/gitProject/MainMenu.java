package CBL.gitProject;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * MainMenu class creates an instance of the Main Menu of the game.
 */
public class MainMenu {

    // Declaration of all instance variables used outside of the class
    JFrame menuFrame;
    JButton startGame;
    JButton customizeRules;
    JButton gameHistory;
    boolean playerTurn = true; // true for player 1

    // Initialziation of array that states whether a player action button has been
    // pressed.
    boolean[] buttonActive = new boolean[6];

    // Initialization of instance variables that can be customized
    // Initial values are stored in all of them so the game can run without
    // requiring any customization
    int gridSize = 8;
    Color p1Color = Color.RED;
    Color p2Color = Color.YELLOW;

    // Obtains value from CustomizeRlues class
    boolean[] rules = {true, true, true, true, true};

    // Declaration of class objects to call their constructors from within an
    // ActionListener
    StartGame game;
    CustomizeRules rule;
    GameHistory history;

    /**
     * MainMenu() is the constructor of the MainMenu class. It is ran once an
     * instance of the class
     * is created. The Main Menu connects the rest of the classes with each other
     * (StartGame, CustomizeRules, GameHistory).
     */
    MainMenu() {

        // Initialization of all components in the menuFrame
        menuFrame = new JFrame();
        startGame = new JButton("Start Game");
        customizeRules = new JButton("Customize Rules");
        gameHistory = new JButton("Game History");
        JPanel buttonPanel = new JPanel();

        // Size and font for the buttons selected
        startGame.setPreferredSize(new Dimension(270, 60));
        startGame.setFont(new Font("Arial", Font.BOLD, 25));

        customizeRules.setPreferredSize(new Dimension(270, 60));
        customizeRules.setFont(new Font("Arial", Font.BOLD, 25));

        gameHistory.setPreferredSize(new Dimension(270, 60));
        gameHistory.setFont(new Font("Arial", Font.BOLD, 25));

        // Add event for startGame button
        startGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createStartGame();
            }
        });

        // Add event for customizeRules button
        customizeRules.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createCustomizeRules();
            }
        });

        // Add ecent for gameHistory button
        gameHistory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createGameHistory();
            }
        });

        JLabel background = new JLabel();
        background.setBackground(Color.WHITE);
        try {
            background = new JLabel(new ImageIcon(ImageIO.read(
                    new File("CBL\\gitProject\\ColorBingo.png"))));
            background.setSize(1200, 800);
        } catch (IOException e) {
            e.printStackTrace();
        }
        menuFrame.setContentPane(background);

        // buttonPanel size and location are selected
        buttonPanel.setBackground(new Color(0, 0, 0, 0));
        buttonPanel.setSize(300, 300);
        buttonPanel.setLocation(435, 450);

        // All buttons are added to the buttonPanel
        buttonPanel.add(startGame);
        buttonPanel.add(customizeRules);
        buttonPanel.add(gameHistory);

        // buttonPanel is added to the menuFrame
        menuFrame.add(buttonPanel, BorderLayout.CENTER);

        // menuFrame details are selected
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
        menuFrame.setSize(1200, 800);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setLayout(null);
        menuFrame.setVisible(true);
    }

    /**
     * createStartGame() calls the costructor of the StartGame class from the same
     * class instance.
     * The keyword "this" refers to the Main Menu containing this exact StartGame
     * game variable.
     */
    public void createStartGame() {
        this.game = new StartGame(this);
    }

    /**
     * createCustomizeRules() calls the constructor of the CustomizeRules class
     * from the same class instance.
     * 
     * The keyword "this" refers to the Main Menu containing this exact
     * CustomizaRules rule variable.
     */
    public void createCustomizeRules() {
        this.rule = new CustomizeRules(this);
    }

    /**
     * createGameHistory() calls the constructor of the GameHistory class
     * //from the same class instance.
     * 
     * The keyword "this" refers to the Main Menu containing this exact
     * //GameHistory rule variable.
     */
    public void createGameHistory() {
        this.history = new GameHistory(this);
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
