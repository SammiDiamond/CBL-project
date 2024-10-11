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

    // Create a boolean array instead
    boolean obstacleActive = false;
    boolean eliminateActive = false;

    // Initialization of instance variables that can be customized
    // Initial values are stored in all of them so the game can run without
    // requiring any customization
    int gridSize = 8;
    Color p1Color = Color.RED;
    Color p2Color = Color.YELLOW;

    // obtain value from CustomizaRlues class
    boolean swapRule = true;
    boolean obstacleRule = true;
    boolean eliminateRule = true;

    // buttonGrid[][] stores all of the buttons of the grid
    JButton[][] buttonGrid = new JButton[gridSize][gridSize];

    // grid[][] is a parallel array to buttonGrid[][] whose values depend on the
    // button background
    int[][] grid = new int[gridSize][gridSize];

    // Declaration of class objects to call their constructors from within an
    // ActionListener
    StartGame game;
    CustomizeRules rule;

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

        // Add events for when the buttons are pressed

        // Add events for startGame button
        startGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createStartGame();
            }
        });
        // Add events for customizeRules button
        customizeRules.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createCustomizeRules();
            }
        });

        try {
            menuFrame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(
                    new File("CBL/gitProject/ColorBingo.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // buttonPanel size and location are selected
        buttonPanel.setSize(300, 300);
        buttonPanel.setLocation(435, 450);

        // All buttons are added to the buttonPanel
        buttonPanel.add(startGame);
        buttonPanel.add(customizeRules);
        buttonPanel.add(gameHistory);

        // buttonPanel is added to the menuFrame
        menuFrame.add(buttonPanel, BorderLayout.CENTER);

        // menuFrame details are selected
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
     * createCustomizeRules() calls the costructor of the CustomizeRules class
     * //from the same class instance.
     * 
     * The keyword "this" refers to the Main Menu containing this exact
     * //CustomizaRules rule variable.
     */
    public void createCustomizeRules() {
        this.rule = new CustomizeRules(this);
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
