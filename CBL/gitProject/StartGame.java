package CBL.gitProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Class creates an instance of the game when "Start Game" button is pressed in
 * Main Menu.
 */
public class StartGame {

    // Declaration the MainMenu object
    MainMenu mainMenu;

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
        JLabel historyLabel = new JLabel();
        historyLabel.setForeground(mainMenu.p1Color);
        // JLabel details are assigned
        historyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        historyLabel.setFont(new Font("Arial", Font.BOLD, 35));

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
                final int row = i;
                final int col = j;

                mainMenu.buttonGrid[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        // When player 1 presses a button the below code is executed
                        if (mainMenu.playerTurn) {

                            // JLabel states the next player's turn
                            turnLabel.setText("Player 2's turn.");
                            turnLabel.setForeground(mainMenu.p2Color);

                            if (mainMenu.buttonActive[0] || mainMenu.buttonActive[1]) {
                                mainMenu.buttonGrid[row][col].setBackground(mainMenu.p1Color);
                                mainMenu.grid[row][col] = 1; // Value for player 1 occupied cell
                            } else if (mainMenu.buttonActive[2]) {
                                mainMenu.buttonGrid[row][col].setBackground(Color.DARK_GRAY);
                                mainMenu.grid[row][col] = -1; // Value for obstacle occupied cell
                            } else if (mainMenu.buttonActive[3]) {
                                mainMenu.buttonGrid[row][col].setBackground(Color.WHITE);
                                mainMenu.grid[row][col] = 0; // Value for empty cell
                            } else if (mainMenu.buttonActive[4]) {
                                mainMenu.buttonGrid[row][col]
                                        .setBorder(BorderFactory.createLineBorder(mainMenu.p2Color, 4));
                                mainMenu.grid[row][col] = 3; // Value for player 1 protected cell
                            } else {
                                // Add spread function
                            }

                        } else { // When player 2 presses a button the below code is executed

                            // JLabel states the next player's turn
                            turnLabel.setText("Player 1's turn.");
                            turnLabel.setForeground(mainMenu.p1Color);

                            if (mainMenu.buttonActive[0] || mainMenu.buttonActive[1]) {
                                mainMenu.buttonGrid[row][col].setBackground(mainMenu.p2Color);
                                mainMenu.grid[row][col] = 2; // Value for player 2 occupied cell
                            } else if (mainMenu.buttonActive[2]) {
                                mainMenu.buttonGrid[row][col].setBackground(Color.DARK_GRAY);
                                mainMenu.grid[row][col] = -1; // Value for obstacle cell
                            } else if (mainMenu.buttonActive[3]) {
                                mainMenu.buttonGrid[row][col].setBackground(Color.WHITE);
                                mainMenu.grid[row][col] = 0; // Value for empty cell
                            } else if (mainMenu.buttonActive[4]) {
                                mainMenu.buttonGrid[row][col]
                                        .setBorder(BorderFactory.createLineBorder(mainMenu.p1Color, 4));
                                mainMenu.grid[row][col] = 4; // Value for player 2 protected cell
                            } else {
                                // Add spread function
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
                        int storeWinNum = checkWin(mainMenu);
                        if (storeWinNum != 0) {
                            postWin(storeWinNum, game, mainMenu);
                        }
                    }
                });
            }
        }

        // region All player action buttons are added to the buttonPanel with a gap in
        // between
        // each one
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        buttonPanel.add(turnLabel);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        buttonPanel.add(place);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        buttonPanel.add(swap);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        buttonPanel.add(obstacle);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        buttonPanel.add(eliminate);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        buttonPanel.add(protect);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        buttonPanel.add(spread);
        buttonPanel.add(historyLabel);
        // endregion

        // The two panels are added to the game fram
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
                if (mainMenu.grid[i][j] == 0) {
                    buttonGrid[i][j].setEnabled(true);
                }
            }
        }
    }

    /**
     * Method that enables all buttons of the color of the opposite player.
     * 
     * @param buttonGrid JButton[][] that stores all of the JButtons in the grid
     * @param mainMenu   MainMenu object needed to access some instance variables
     */
    public static void enableOpp(JButton[][] buttonGrid, MainMenu mainMenu) {
        for (int i = 0; i < mainMenu.gridSize; i++) {
            for (int j = 0; j < mainMenu.gridSize; j++) {
                buttonGrid[i][j].setEnabled(false);
                if (!mainMenu.playerTurn & mainMenu.grid[i][j] == 1) {
                    buttonGrid[i][j].setEnabled(true);
                } else if (mainMenu.playerTurn
                        && mainMenu.grid[i][j] == 2) {
                    buttonGrid[i][j].setEnabled(true);
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
                if (mainMenu.playerTurn && mainMenu.grid[i][j] == 1) {
                    buttonGrid[i][j].setEnabled(true);
                } else if (!mainMenu.playerTurn
                        && mainMenu.grid[i][j] == 2) {
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
    public static int checkWin(MainMenu mainMenu) {
        if (horizontalWin(mainMenu) != 0) {
            return horizontalWin(mainMenu);
        } else if (verticalWin(mainMenu) != 0) {
            return verticalWin(mainMenu);
        } else if (diagonalWin(mainMenu) != 0) {
            return diagonalWin(mainMenu);
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
    public static int horizontalWin(MainMenu mainMenu) {
        for (int i = 0; i < mainMenu.gridSize; i++) {
            for (int j = 0; j < mainMenu.gridSize - 3; j++) {
                if (mainMenu.grid[i][j] == mainMenu.grid[i][j + 1]
                        && mainMenu.grid[i][j + 1] == mainMenu.grid[i][j + 2]
                        && mainMenu.grid[i][j + 2] == mainMenu.grid[i][j + 3]
                        && mainMenu.grid[i][j] != 0 && mainMenu.grid[i][j] != -1) {
                    return mainMenu.grid[i][j];
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
    public static int verticalWin(MainMenu mainMenu) {
        for (int j = 0; j < mainMenu.gridSize; j++) {
            for (int i = 0; i < mainMenu.gridSize - 3; i++) {
                if (mainMenu.grid[i][j] == mainMenu.grid[i + 1][j]
                        && mainMenu.grid[i + 1][j] == mainMenu.grid[i + 2][j]
                        && mainMenu.grid[i + 2][j] == mainMenu.grid[i + 3][j]
                        && mainMenu.grid[i][j] != 0 && mainMenu.grid[i][j] != -1) {
                    return mainMenu.grid[i][j];
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
    public static int diagonalWin(MainMenu mainMenu) {
        for (int i = 0; i < mainMenu.gridSize - 3; i++) {
            for (int j = 0; j < mainMenu.gridSize - 3; j++) {

                // Condition for an increasing diagonal
                if (mainMenu.grid[i][j] == mainMenu.grid[i + 1][j + 1]
                        && mainMenu.grid[i + 1][j + 1] == mainMenu.grid[i + 2][j + 2]
                        && mainMenu.grid[i + 2][j + 2] == mainMenu.grid[i + 3][j + 3]
                        && mainMenu.grid[i][j] != 0 && mainMenu.grid[i][j] != -1) {
                    return mainMenu.grid[i][j];

                    // Condition for a decreasing diagonal
                } else if (mainMenu.grid[i + 3][j] == mainMenu.grid[i + 2][j + 1]
                        && mainMenu.grid[i + 2][j + 1] == mainMenu.grid[i + 1][j + 2]
                        && mainMenu.grid[i + 1][j + 2] == mainMenu.grid[i][j + 3]
                        && mainMenu.grid[i + 3][j] != 0 && mainMenu.grid[i][j] != -1) {
                    return mainMenu.grid[i + 3][j];
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
