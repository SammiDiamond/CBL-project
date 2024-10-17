package CBL.gitProject;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * Class creates an instance of the game when "Start Game" button is pressed in
 * Main Menu.
 */
public class StartGame {
    // Declaration the MainMenu object
    MainMenu mainMenu;

    // Declaration of a random number generator object
    Random r = new Random();

    // Initialization of a SpreadObj array of size 2 with initial objects being
    // "null"
    SpreadObj[] spreadArr = new SpreadObj[2];

    // Creation of counter to count round number

    // Creation of int[][] to store the action history, which will be passed onto
    // History class
    // for each element in actionHistory:
    // array[0] using number from 0, 1, 2, 3, 4, 5 to indicate applied rules (0 for
    // place, 1 for swap, 2 for Obstacle, 3 for eliminate, 4 for protect, 5 for
    // spread)
    // array[1] and array[2] indicating the coordinates of the square where the rule
    // is used
    // odd array indicating actionhistoiry of player1 and even array for player2
    // the length of the int[] may be longer than size*size so we dont initialize
    // its length
    int[][] actionHistory = {};
    String action = "";
    // Creation of String[] to store the names of the rules, used later in
    // actionHistoryLabel
    String[] rulesName = { "\"Place\"", "\"Swap\"",
            "\"Obstacle\"", "\"Eliminate\"", "\"Protect\"", "\"Spread\"" };

    // Initialization of variables storing game details
    static int rounds = 0;
    static int roundNum = 0;

    /**
     * Constructor responsible for the GUI for the gameplay.
     * 
     * @param menu Specific MainMenu object whose instance variables are used within
     *             StartGame.
     */
    StartGame(MainMenu menu) {

        // Contents of menu are stored into the mainMenu instance variable
        this.mainMenu = menu;

        // Buttons in the previous window are disabled and window is minimized
        mainMenu.menuFrame.setState(JFrame.ICONIFIED);
        mainMenu.startGame.setEnabled(false);
        mainMenu.customizeRules.setEnabled(false);
        mainMenu.gameHistory.setEnabled(false);

        // JFrame is initialized for the gameplay
        JFrame game = new JFrame();

        // Creation of JLabel that tells whose player's turn it is (initially player 1)
        JLabel turnLabel = new JLabel("Player 1's turn.");
        turnLabel.setForeground(mainMenu.p1Color);
        // JLabel details are assigned
        turnLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        turnLabel.setFont(new Font("Arial", Font.BOLD, 35));

        // Creation of JLabel tells the action made in last round
        JLabel actionHistoryLabel = new JLabel("No action yet");
        actionHistoryLabel.setForeground(mainMenu.p1Color);
        // JLabel details are assigned
        actionHistoryLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        actionHistoryLabel.setFont(new Font("Arial", Font.BOLD, 35));

        // JPanel that will hold all of the player action buttons is initialized
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        buttonPanel.setSize(300, 800);
        buttonPanel.setLocation(45, 10);

        // Player action buttons are initialized
        JButton place = new JButton("Place");
        JButton swap = new JButton("Swap");
        JButton obstacle = new JButton("Obstacle");
        JButton eliminate = new JButton("Eliminate");
        JButton protect = new JButton("Protect");
        JButton spread = new JButton("Spread");

        // JPanel that will hold all of the grid buttons in the game is initialized
        JPanel gridPanel = new JPanel();
        gridPanel.setSize(800, 800);
        gridPanel.setLocation(350, 10);

        // Player action button details are selected
        // Visibility is also assigned based on selected rules
        place.setAlignmentX(Component.CENTER_ALIGNMENT);
        place.setFont(new Font("Arial", Font.BOLD, 25));

        swap.setAlignmentX(Component.CENTER_ALIGNMENT);
        swap.setFont(new Font("Arial", Font.BOLD, 25));
        if (!mainMenu.swapRule) {
            swap.setVisible(false);
        }

        obstacle.setAlignmentX(Component.CENTER_ALIGNMENT);
        obstacle.setFont(new Font("Arial", Font.BOLD, 25));
        if (!mainMenu.obstacleRule) {
            obstacle.setVisible(false);
        }

        eliminate.setAlignmentX(Component.CENTER_ALIGNMENT);
        eliminate.setFont(new Font("Arial", Font.BOLD, 25));
        if (!mainMenu.eliminateRule) {
            eliminate.setVisible(false);
        }

        protect.setAlignmentX(Component.CENTER_ALIGNMENT);
        protect.setFont(new Font("Arial", Font.BOLD, 25));
        if (!mainMenu.protectRule) {
            protect.setVisible(false);
        }

        spread.setAlignmentX(Component.CENTER_ALIGNMENT);
        spread.setFont(new Font("Arial", Font.BOLD, 25));
        if (!mainMenu.spreadRule) {
            spread.setVisible(false);
        }

        // Events are assigned to player action buttons
        place.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                place.setEnabled(false);
                swap.setEnabled(true);
                obstacle.setEnabled(true);
                eliminate.setEnabled(true);
                protect.setEnabled(true);
                spread.setEnabled(true);
                action = rulesName[0];
                // Sets Place button to active and sets the rest of the buttons to deactive
                for (int i = 1; i < mainMenu.buttonActive.length; i++) {
                    mainMenu.buttonActive[i] = false;
                }
                mainMenu.buttonActive[0] = true;

                enableEmpty(mainMenu.buttonGrid, mainMenu);
            }
        });

        swap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                place.setEnabled(true);
                swap.setEnabled(false);
                obstacle.setEnabled(true);
                eliminate.setEnabled(true);
                protect.setEnabled(true);
                spread.setEnabled(true);
                action = rulesName[1];
                // Sets Swap button to active and sets the rest of the buttons to deactive
                for (int i = 0; i < mainMenu.buttonActive.length; i++) {
                    mainMenu.buttonActive[i] = false;
                }
                mainMenu.buttonActive[1] = true;

                enableOpp(mainMenu.buttonGrid, mainMenu);
            }
        });

        obstacle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                place.setEnabled(true);
                swap.setEnabled(true);
                obstacle.setEnabled(false);
                eliminate.setEnabled(true);
                protect.setEnabled(true);
                spread.setEnabled(true);
                action = rulesName[2];
                // Sets Obstacle button to active and sets the rest of the buttons to deactive
                for (int i = 0; i < mainMenu.buttonActive.length; i++) {
                    mainMenu.buttonActive[i] = false;
                }
                mainMenu.buttonActive[2] = true;

                enableEmpty(mainMenu.buttonGrid, mainMenu);
            }
        });

        eliminate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                place.setEnabled(true);
                swap.setEnabled(true);
                obstacle.setEnabled(true);
                eliminate.setEnabled(false);
                protect.setEnabled(true);
                spread.setEnabled(true);
                action = rulesName[3];
                // Sets Eliminate button to active and sets the rest of the buttons to deactive
                for (int i = 0; i < mainMenu.buttonActive.length; i++) {
                    mainMenu.buttonActive[i] = false;
                }
                mainMenu.buttonActive[3] = true;

                enableOpp(mainMenu.buttonGrid, mainMenu);
            }
        });

        protect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                place.setEnabled(true);
                swap.setEnabled(true);
                obstacle.setEnabled(true);
                eliminate.setEnabled(true);
                protect.setEnabled(false);
                spread.setEnabled(true);
                action = rulesName[4];
                // Sets Protect button to active and sets the rest of the buttons to deactive
                for (int i = 0; i < mainMenu.buttonActive.length; i++) {
                    mainMenu.buttonActive[i] = false;
                }
                mainMenu.buttonActive[4] = true;

                enableSame(mainMenu.buttonGrid, mainMenu);
            }
        });

        spread.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                place.setEnabled(true);
                swap.setEnabled(true);
                obstacle.setEnabled(true);
                eliminate.setEnabled(true);
                protect.setEnabled(true);
                spread.setEnabled(false);
                action = rulesName[5];
                // Sets Spread button to active and sets the rest of the buttons to deactive
                for (int i = 0; i < mainMenu.buttonActive.length; i++) {
                    mainMenu.buttonActive[i] = false;
                }
                mainMenu.buttonActive[5] = true;

                enableEmpty(mainMenu.buttonGrid, mainMenu);
            }
        });

        // Initialization of all all JButtons in the grid
        for (int i = 0; i < mainMenu.gridSize; i++) {
            for (int j = 0; j < mainMenu.gridSize; j++) {
                mainMenu.buttonGrid[i][j] = new JButton();
                mainMenu.buttonGrid[i][j].setBackground(Color.WHITE);
                mainMenu.buttonGrid[i][j].setBorder(
                        BorderFactory.createLineBorder(Color.DARK_GRAY));
                mainMenu.buttonGrid[i][j].setPreferredSize(new Dimension(90, 90));
                mainMenu.buttonGrid[i][j].setEnabled(false);

                // All grid buttons are added to the panel
                gridPanel.add(mainMenu.buttonGrid[i][j]);

                // Row and Column variables are initialized to reach ActionEvent scope
                int row = i;
                int col = j;

                mainMenu.buttonGrid[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Round is incremented
                        actionHistory[roundNum][1] = row;
                        actionHistory[roundNum][2] = col;
                        roundNum++;
                        rounds++;

                        // When player 1 presses a button the below code is executed
                        if (mainMenu.playerTurn) {
                            // JLabel states the next player's turn
                            turnLabel.setText("Player 2's turn.");
                            turnLabel.setForeground(mainMenu.p2Color);

                            // change actionhistory
                            actionHistoryLabel.setText("Player1 used" + action + "on("
                                    + Integer.toString(actionHistory[roundNum][1]) + ", "
                                    + Integer.toString(actionHistory[roundNum][2]) + ")");

                            if (mainMenu.buttonActive[0] || mainMenu.buttonActive[1]) {
                                mainMenu.buttonGrid[row][col].setBackground(mainMenu.p1Color);
                            } else if (mainMenu.buttonActive[2]) {
                                mainMenu.buttonGrid[row][col].setBackground(Color.DARK_GRAY);
                            } else if (mainMenu.buttonActive[3]) {
                                mainMenu.buttonGrid[row][col].setBackground(Color.WHITE);
                            } else if (mainMenu.buttonActive[4]) {
                                mainMenu.buttonGrid[row][col].setBorder(BorderFactory
                                        .createLineBorder(mainMenu.p2Color, 4));
                            } else {
                                mainMenu.buttonGrid[row][col].setBackground(mainMenu.p1Color);
                                SpreadObj p1Spread = new SpreadObj(row, col);
                                spreadArr[0] = p1Spread;
                            }

                            // Check whether Spread was used by player 1
                            if (spreadArr[0] != null) {
                                if (spreadArr[0].getDelay() == 0) {
                                    boolean nearbyEmpty = false;

                                    int rowMin = -1;
                                    int rowMax = 2;
                                    int colMin = -1;
                                    int colMax = 2;

                                    // Check edges of the grid
                                    if (spreadArr[0].getRow() == 0) {
                                        rowMin = 0; // Can't go up
                                    }
                                    if (spreadArr[0].getRow() == mainMenu.gridSize - 1) {
                                        rowMax = 1; // Can't go down
                                    }
                                    if (spreadArr[0].getCol() == 0) {
                                        colMin = 0; // Can't go left
                                    }
                                    if (spreadArr[0].getCol() == mainMenu.gridSize - 1) {
                                        colMax = 1; // Can't go right
                                    }

                                    // Check for empty cells
                                    for (int i = rowMin; i < rowMax; i++) {
                                        for (int j = colMin; j < colMax; j++) {
                                            if (mainMenu.buttonGrid[spreadArr[0]
                                                    .getRow() + i][spreadArr[0].getCol()
                                                            + j]
                                                    .getBackground() == Color.WHITE) {
                                                nearbyEmpty = true;
                                            }
                                        }
                                    }

                                    if (nearbyEmpty) {
                                        boolean found = false;
                                        while (!found) {
                                            int randomRow = r.nextInt(rowMax - rowMin) + rowMin;
                                            int randomCol = r.nextInt(colMax - colMin) + colMin;

                                            if (mainMenu.buttonGrid[spreadArr[0]
                                                    .getRow() + randomRow][spreadArr[0]
                                                            .getCol() + randomCol]
                                                    .getBackground() == Color.WHITE) {
                                                mainMenu.buttonGrid[spreadArr[0]
                                                        .getRow() + randomRow][spreadArr[0]
                                                                .getCol() + randomCol]
                                                        .setBackground(mainMenu.p1Color);
                                                found = true;
                                            }
                                        }
                                    }
                                    spreadArr[0] = null;
                                } else {
                                    spreadArr[0].setDelay(spreadArr[0].getDelay() - 1);
                                }
                            }

                        } else { // When player 2 presses a button the below code is executed

                            // JLabel states the next player's turn
                            turnLabel.setText("Player 1's turn.");
                            turnLabel.setForeground(mainMenu.p1Color);
                            // change actionhistory
                            actionHistoryLabel.setText("Player2 used" + action + "on("
                                    + Integer.toString(actionHistory[roundNum][1]) + ", "
                                    + Integer.toString(actionHistory[roundNum][2]) + ")");

                            if (mainMenu.buttonActive[0] || mainMenu.buttonActive[1]) {
                                mainMenu.buttonGrid[row][col].setBackground(mainMenu.p2Color);
                            } else if (mainMenu.buttonActive[2]) {
                                mainMenu.buttonGrid[row][col].setBackground(Color.DARK_GRAY);
                            } else if (mainMenu.buttonActive[3]) {
                                mainMenu.buttonGrid[row][col].setBackground(Color.WHITE);
                            } else if (mainMenu.buttonActive[4]) {
                                mainMenu.buttonGrid[row][col].setBorder(BorderFactory
                                        .createLineBorder(mainMenu.p1Color, 4));
                            } else {
                                mainMenu.buttonGrid[row][col].setBackground(mainMenu.p2Color);
                                SpreadObj p2Spread = new SpreadObj(row, col);
                                spreadArr[1] = p2Spread;
                            }

                            // Check whether Spread was used by player 2
                            if (spreadArr[1] != null) {
                                if (spreadArr[1].getDelay() == 0) {
                                    boolean nearbyEmpty = false;

                                    int rowMin = -1;
                                    int rowMax = 2;
                                    int colMin = -1;
                                    int colMax = 2;

                                    // Check edges of the grid
                                    if (spreadArr[1].getRow() == 0) {
                                        rowMin = 0; // Can't go up
                                    }
                                    if (spreadArr[1].getRow() == mainMenu.gridSize - 1) {
                                        rowMax = 1; // Can't go down
                                    }
                                    if (spreadArr[1].getCol() == 0) {
                                        colMin = 0; // Can't go left
                                    }
                                    if (spreadArr[1].getCol() == mainMenu.gridSize - 1) {
                                        colMax = 1; // Can't go right
                                    }

                                    // Check for empty cells
                                    for (int i = rowMin; i < rowMax; i++) {
                                        for (int j = colMin; j < colMax; j++) {
                                            if (mainMenu.buttonGrid[spreadArr[1]
                                                    .getRow() + i][spreadArr[1].getCol()
                                                            + j]
                                                    .getBackground() == Color.WHITE) {
                                                nearbyEmpty = true;
                                            }
                                        }
                                    }

                                    if (nearbyEmpty) {
                                        boolean found = false;
                                        while (!found) {
                                            int randomRow = r.nextInt(rowMax - rowMin) + rowMin;
                                            int randomCol = r.nextInt(colMax - colMin) + colMin;

                                            if (mainMenu.buttonGrid[spreadArr[1].getRow()
                                                    + randomRow][spreadArr[1]
                                                            .getCol() + randomCol]
                                                    .getBackground() == Color.WHITE) {
                                                mainMenu.buttonGrid[spreadArr[1]
                                                        .getRow() + randomRow][spreadArr[1]
                                                                .getCol() + randomCol]
                                                        .setBackground(mainMenu.p2Color);
                                                found = true;
                                            }
                                        }
                                    }
                                    spreadArr[1] = null;
                                } else {
                                    spreadArr[1].setDelay(spreadArr[1].getDelay() - 1);
                                }
                            }

                        }

                        // playerTurn changes for the next player's turn
                        mainMenu.playerTurn = !mainMenu.playerTurn;

                        // All buttons become disabled until a player action button is pressed
                        for (int i = 0; i < mainMenu.gridSize; i++) {
                            for (int j = 0; j < mainMenu.gridSize; j++) {
                                mainMenu.buttonGrid[i][j].setEnabled(false);
                            }
                        }

                        // Player action buttons are enabled again
                        place.setEnabled(true);
                        swap.setEnabled(true);
                        obstacle.setEnabled(true);
                        eliminate.setEnabled(true);
                        protect.setEnabled(true);
                        spread.setEnabled(true);
                        // Checks if anyone has won
                        int storeWinNum = checkWin(mainMenu, mainMenu.buttonGrid);
                        if (storeWinNum != 0) {
                            postWin(storeWinNum, game, mainMenu);
                        }
                        System.out.println(roundNum);
                    }
                });
            }
        }

        // All player action buttons are added to the buttonPanel with a gap between
        // them
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        buttonPanel.add(turnLabel);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        buttonPanel.add(place);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        buttonPanel.add(swap);
        if (mainMenu.swapRule) {
            buttonPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        }
        buttonPanel.add(obstacle);
        if (mainMenu.obstacleRule) {
            buttonPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        }
        buttonPanel.add(eliminate);
        if (mainMenu.eliminateRule) {
            buttonPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        }
        buttonPanel.add(protect);
        if (mainMenu.protectRule) {
            buttonPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        }
        buttonPanel.add(spread);
        if (mainMenu.spreadRule) {
            buttonPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        }
        buttonPanel.add(actionHistoryLabel);

        // The two panels are added to the game frame
        game.add(buttonPanel);
        game.add(gridPanel);

        // gridPanel updates itself
        gridPanel.validate();

        // game frame details are assigned
        game.setSize(1200, 820);
        game.setLocationRelativeTo(null);
        game.setLayout(null);
        game.setVisible(true);
    }

    /**
     * Method that enables all buttons that correspond to an empty cell.
     * 
     * @param buttonGrid JButton[][] that stores all of the JButtons in the grid
     * @param mainMenu   MainMenu object needed to access some instance variables
     */
    public static void enableEmpty(JButton[][] buttonGrid, MainMenu mainMenu) {
        for (int i = 0; i < mainMenu.gridSize; i++) {
            for (int j = 0; j < mainMenu.gridSize; j++) {
                if (buttonGrid[i][j].getBackground() == Color.WHITE) {
                    buttonGrid[i][j].setEnabled(true);
                }
            }
        }
    }

    /**
     * Method that enables all non-protected buttons of the color of the opposite
     * player.
     * 
     * @param buttonGrid JButton[][] that stores all of the JButtons in the grid
     * @param mainMenu   MainMenu object needed to access some instance variables
     */
    public static void enableOpp(JButton[][] buttonGrid, MainMenu mainMenu) {
        for (int i = 0; i < mainMenu.gridSize; i++) {
            for (int j = 0; j < mainMenu.gridSize; j++) {
                buttonGrid[i][j].setEnabled(false);

                // Check for player 1's turn
                if (!mainMenu.playerTurn
                        && buttonGrid[i][j].getBackground() == mainMenu.p1Color) {

                    Border border = buttonGrid[i][j].getBorder();
                    if (border instanceof LineBorder) {
                        LineBorder lineBorder = (LineBorder) border;
                        if (lineBorder.getLineColor()
                                .equals(Color.BLACK)) {
                            buttonGrid[i][j].setEnabled(true);
                        }
                    } else {
                        buttonGrid[i][j].setEnabled(true); // If the border is not colored black
                    }

                    // Check for player 2's turn
                } else if (mainMenu.playerTurn
                        && buttonGrid[i][j].getBackground() == mainMenu.p2Color) {

                    Border border = buttonGrid[i][j].getBorder();
                    if (border instanceof LineBorder) {
                        LineBorder lineBorder = (LineBorder) border;
                        if (lineBorder.getLineColor()
                                .equals(Color.BLACK)) {
                            buttonGrid[i][j].setEnabled(true);
                        }
                    } else {
                        buttonGrid[i][j].setEnabled(true); // If the border is not colored black
                    }
                }
            }
        }
    }

    /**
     * Method that enables all buttons of the color of the same player.
     * 
     * @param buttonGrid JButton[][] that stores all of the JButtons in the grid
     * @param mainMenu   MainMenu object needed to access some instance variables
     */
    public static void enableSame(JButton[][] buttonGrid, MainMenu mainMenu) {
        for (int i = 0; i < mainMenu.gridSize; i++) {
            for (int j = 0; j < mainMenu.gridSize; j++) {
                buttonGrid[i][j].setEnabled(false);
                if (mainMenu.playerTurn && buttonGrid[i][j].getBackground() == mainMenu.p1Color) {
                    buttonGrid[i][j].setEnabled(true);
                } else if (!mainMenu.playerTurn
                        && buttonGrid[i][j].getBackground() == mainMenu.p2Color) {
                    buttonGrid[i][j].setEnabled(true);
                }
            }
        }
    }

    /**
     * Method that checks whether anyone has won.
     * 
     * @param mainMenu MainMenu object needed to access some instance variables
     * @return integer: 1 if player 1 wins; 2 if player 2 wins; else 0;
     */
    public static int checkWin(MainMenu mainMenu, JButton[][] buttonGrid) {
        if (horizontalWin(mainMenu, buttonGrid) != 0) {
            return horizontalWin(mainMenu, buttonGrid);
        } else if (verticalWin(mainMenu, buttonGrid) != 0) {
            return verticalWin(mainMenu, buttonGrid);
        } else if (diagonalWin(mainMenu, buttonGrid) != 0) {
            return diagonalWin(mainMenu, buttonGrid);
        }
        return 0;
    }

    /**
     * Method that checks if a player has 4 cells in a row of the same color
     * horizontally.
     * 
     * @param mainMenu MainMenu object needed to access some instance variables
     * @return integer: 1 if player 1 fulfils condition; 2 if player 2 fulfils
     *         condition; else 0;
     */
    public static int horizontalWin(MainMenu mainMenu, JButton[][] buttonGrid) {
        for (int i = 0; i < mainMenu.gridSize; i++) {
            for (int j = 0; j < mainMenu.gridSize - 3; j++) {
                if (buttonGrid[i][j].getBackground() == buttonGrid[i][j + 1].getBackground()
                        && buttonGrid[i][j + 1].getBackground() == buttonGrid[i][j + 2].getBackground()
                        && buttonGrid[i][j + 2].getBackground() == buttonGrid[i][j + 3].getBackground()
                        && buttonGrid[i][j].getBackground() != Color.DARK_GRAY
                        && buttonGrid[i][j].getBackground() != Color.WHITE) {
                    if (buttonGrid[i][j].getBackground() == mainMenu.p1Color) {
                        return 1;
                    } else if (buttonGrid[i][j].getBackground() == mainMenu.p2Color) {
                        return 2;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * Method that checks if a player has 4 cells in a row of the same color
     * vertically.
     * 
     * @param mainMenu MainMenu object needed to access some instance variables
     * @return integer: 1 if player 1 fulfils condition; 2 if player 2 fulfils
     *         condition; else 0;
     */
    public static int verticalWin(MainMenu mainMenu, JButton[][] buttonGrid) {
        for (int j = 0; j < mainMenu.gridSize; j++) {
            for (int i = 0; i < mainMenu.gridSize - 3; i++) {
                if (buttonGrid[i][j].getBackground() == buttonGrid[i + 1][j].getBackground()
                        && buttonGrid[i + 1][j].getBackground() == buttonGrid[i + 2][j].getBackground()
                        && buttonGrid[i + 2][j].getBackground() == buttonGrid[i + 3][j].getBackground()
                        && buttonGrid[i][j].getBackground() != Color.DARK_GRAY
                        && buttonGrid[i][j].getBackground() != Color.WHITE) {
                    if (buttonGrid[i][j].getBackground() == mainMenu.p1Color) {
                        return 1;
                    } else if (buttonGrid[i][j].getBackground() == mainMenu.p2Color) {
                        return 2;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * Method that checks if a player has 4 cells in a row of the same color
     * diagonally.
     * 
     * @param mainMenu MainMenu object needed to access some instance variables
     * @return integer: 1 if player 1 fulfils condition; 2 if player 2 fulfils
     *         condition; else 0;
     */
    public static int diagonalWin(MainMenu mainMenu, JButton[][] buttonGrid) {
        for (int i = 0; i < mainMenu.gridSize - 3; i++) {
            for (int j = 0; j < mainMenu.gridSize - 3; j++) {

                // Condition for an increasing diagonal
                if (buttonGrid[i][j].getBackground() == buttonGrid[i + 1][j + 1].getBackground()
                        && buttonGrid[i + 1][j + 1].getBackground() == buttonGrid[i + 2][j + 2].getBackground()
                        && buttonGrid[i + 2][j + 2].getBackground() == buttonGrid[i + 3][j + 3].getBackground()
                        && buttonGrid[i][j].getBackground() != Color.DARK_GRAY
                        && buttonGrid[i][j].getBackground() != Color.WHITE) {
                    if (buttonGrid[i][j].getBackground() == mainMenu.p1Color) {
                        return 1;
                    } else if (buttonGrid[i][j + 3].getBackground() == mainMenu.p2Color) {
                        return 2;
                    }
                    // Condition for a decreasing diagonal
                } else if (buttonGrid[i + 3][j].getBackground() == buttonGrid[i + 2][j + 1].getBackground()
                        && buttonGrid[i + 2][j + 1].getBackground() == buttonGrid[i + 1][j + 2].getBackground()
                        && buttonGrid[i + 1][j + 2].getBackground() == buttonGrid[i][j + 3].getBackground()
                        && buttonGrid[i + 3][j].getBackground() != Color.DARK_GRAY
                        && buttonGrid[i + 3][j].getBackground() != Color.WHITE) {
                    if (buttonGrid[i + 3][j].getBackground() == mainMenu.p1Color) {
                        return 1;
                    } else if (buttonGrid[i + 3][j].getBackground() == mainMenu.p2Color) {
                        return 2;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * Method that is ran after a player has won.
     * 
     * @param winner   integer: 1 for player 1; 2 for player 2;
     * @param game     JFrame needed to dispose itself
     * @param mainMenu MainMenu object needed to access some instance variables and
     *                 maximize itself
     */
    public static void postWin(int winner, JFrame game, MainMenu mainMenu) {

        // JFrame is initialized
        JFrame winFrame = new JFrame();

        GameDetails details = new GameDetails(mainMenu, winner, mainMenu.buttonActive,
                mainMenu.gridSize, rounds);

        details.writeToFile();
        // JLabel is initialize stating the player who won
        JLabel winnerLabel;
        if (winner == 1) {
            winnerLabel = new JLabel("Player 1 won");
            winnerLabel.setForeground(mainMenu.p1Color);
        } else {
            winnerLabel = new JLabel("Player 2 won");
            winnerLabel.setForeground(mainMenu.p2Color);
        }
        winnerLabel.setFont(new Font("Arial", Font.BOLD, 25));

        // JButton is initialized among other details
        JButton exitButton = new JButton("Return to Main Menu");
        exitButton.setFont(new Font("Arial", Font.BOLD, 25));

        // Event is added to JButton to dispose of previous frames and return to Main
        // Menu
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Main Menu buttons are enabled again
                mainMenu.startGame.setEnabled(true);
                mainMenu.customizeRules.setEnabled(true);
                mainMenu.gameHistory.setEnabled(true);

                winFrame.dispose();
                game.dispose();
                mainMenu.menuFrame.setState(Frame.NORMAL);
            }
        });

        // JPanel is initialized among other details
        JPanel winPanel = new JPanel();
        winPanel.setSize(300, 250);
        winPanel.setLocation(100, 0);

        // JLabel and JButton are added to the panel
        winPanel.add(winnerLabel);
        winPanel.add(Box.createRigidArea(new Dimension(0, 140)));
        winPanel.add(exitButton);

        // JPanel is added to the frame
        winFrame.add(winPanel);

        // JFrame details are assigned
        winFrame.setSize(500, 250);
        winFrame.setLocationRelativeTo(null);
        winFrame.setLayout(null);
        winFrame.setVisible(true);
    }
}

/**
 * Class used to create SpreadObj objects when the spread player action is used.
 */
class SpreadObj {
    // Initialization of all SpreadObj instance variables
    private int delay = 1;
    private int row = -1;
    private int col = -1;

    /**
     * SpreadObj constructor that initializes the object's instance variables
     * excluding the delay.
     * 
     * @param row integer: Passes the row number of the spread cell to the spreadObj
     * @param col integer: Passes the col number of the spread cell to the spreadObj
     */
    SpreadObj(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // Initalization of all Setters of the SpreadObj class
    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    // Initialization of all Getters of the SpreadObj class
    public int getDelay() {
        return delay;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
