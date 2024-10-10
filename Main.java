package CBL.gitProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main {
    static JFrame mainMenu;
    static JButton startGame;
    static JButton customizeRules;
    static JButton gameHistory;
    static boolean playerTurn = true; // true for player 1
    boolean obstacleActive = false;
    boolean eliminateActive = false;

    static int gridSize = 8;
    static Color p1Color = Color.RED;
    static Color p2Color = Color.YELLOW;
    boolean swapRule = true;
    boolean obstacleRule = true;
    boolean eliminateRule = true;
    JButton[][] buttonGrid = new JButton[gridSize][gridSize];
    static int[][] grid = new int[gridSize][gridSize];

    Main() {
        mainMenu = new JFrame();
        startGame = new JButton("Start Game");
        customizeRules = new JButton("Customize Rules");
        gameHistory = new JButton("Game History");
        JPanel buttonPanel = new JPanel();

        startGame.setPreferredSize(new Dimension(270, 60));
        startGame.setFont(new Font("Arial", Font.BOLD, 25));
        startGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenu.setState(JFrame.ICONIFIED);
                startGame.setEnabled(false);
                customizeRules.setEnabled(false);
                gameHistory.setEnabled(false);

                JFrame game = new JFrame();

                JLabel turnLabel = new JLabel("Player 1's turn.");
                turnLabel.setForeground(p1Color);
                turnLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                turnLabel.setFont(new Font("Arial", Font.BOLD, 35));
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
                buttonPanel.setSize(300, 800);
                buttonPanel.setLocation(45, 10);
                JButton place = new JButton("Place");
                JButton swap = new JButton("Swap");
                JButton obstacle = new JButton("Obstacle");
                JButton eliminate = new JButton("Eliminate");

                JPanel gridPanel = new JPanel();
                gridPanel.setSize(800, 800);
                gridPanel.setLocation(350, 10);
                
                place.setAlignmentX(Component.CENTER_ALIGNMENT);
                place.setFont(new Font("Arial", Font.BOLD, 25));
                place.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        place.setEnabled(false);
                        swap.setEnabled(true);
                        obstacle.setEnabled(true);
                        eliminate.setEnabled(true);
                        obstacleActive = false;
                        eliminateActive = false;
                        place(buttonGrid);
                        
                    }
                });

                swap.setAlignmentX(Component.CENTER_ALIGNMENT);
                swap.setFont(new Font("Arial", Font.BOLD, 25));
                if (!swapRule) {
                    swap.setVisible(false);
                }
                swap.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        place.setEnabled(true);
                        swap.setEnabled(false);
                        obstacle.setEnabled(true);
                        eliminate.setEnabled(true);
                        obstacleActive = false;
                        eliminateActive = false;
                        swap(buttonGrid);
                    }
                });
                
                obstacle.setAlignmentX(Component.CENTER_ALIGNMENT);
                obstacle.setFont(new Font("Arial", Font.BOLD, 25));
                if (!obstacleRule) {
                    obstacle.setVisible(false);
                }
                obstacle.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        place.setEnabled(true);
                        swap.setEnabled(true);
                        obstacle.setEnabled(false);
                        eliminate.setEnabled(true);
                        obstacleActive = true;
                        eliminateActive = false;
                        obstacle(buttonGrid);
                    }
                });

                eliminate.setAlignmentX(Component.CENTER_ALIGNMENT);
                eliminate.setFont(new Font("Arial", Font.BOLD, 25));
                if (!eliminateRule) {
                    eliminate.setVisible(false);
                }
                eliminate.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        place.setEnabled(true);
                        swap.setEnabled(true);
                        obstacle.setEnabled(true);
                        eliminate.setEnabled(false);
                        obstacleActive = false;
                        eliminateActive = true;
                        eliminate(buttonGrid);
                    }
                });

                for (int i = 0; i < gridSize; i++) {
                    for (int j = 0; j < gridSize; j++) {
                        buttonGrid[i][j] = new JButton();
                        buttonGrid[i][j].setBackground(Color.WHITE);
                        buttonGrid[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                        buttonGrid[i][j].setPreferredSize(new Dimension(90, 90));
                        buttonGrid[i][j].setEnabled(false);

                        final int row = i;
                        final int col = j;
                        
                        buttonGrid[i][j].addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if (playerTurn) {
                                    turnLabel.setText("Player 2's turn.");
                                    turnLabel.setForeground(p2Color);
                                    if (!obstacleActive && !eliminateActive){
                                        buttonGrid[row][col].setBackground(p1Color);
                                        grid[row][col] = 1;
                                    } else if (obstacleActive && !eliminateActive) {
                                        buttonGrid[row][col].setBackground(Color.DARK_GRAY);
                                        grid[row][col] = - 1;
                                    } else {
                                        buttonGrid[row][col].setBackground(Color.WHITE);
                                        grid[row][col] = 0;
                                    }
                                    
                                } else {
                                    turnLabel.setText("Player 1's turn.");
                                    turnLabel.setForeground(p1Color);
                                    if (!obstacleActive && !eliminateActive) {
                                        buttonGrid[row][col].setBackground(p2Color);
                                        grid[row][col] = 2;
                                    } else if (obstacleActive && !eliminateActive) {
                                        buttonGrid[row][col].setBackground(Color.DARK_GRAY);
                                        grid[row][col] = - 1;
                                    } else {
                                        buttonGrid[row][col].setBackground(Color.WHITE);
                                        grid[row][col] = 0;
                                    }
                                }
                                playerTurn = !playerTurn;

                                for (int i = 0; i < gridSize; i++) {
                                    for (int j = 0; j < gridSize; j++) {
                                        buttonGrid[i][j].setEnabled(false);
                                    }
                                }
                                place.setEnabled(true);
                                swap.setEnabled(true);
                                obstacle.setEnabled(true);
                                eliminate.setEnabled(true);

                                int storeWinNum = checkWin();
                                if (storeWinNum != 0) {
                                    postWin(storeWinNum, game);
                                }
                            }
                        });

                        gridPanel.add(buttonGrid[i][j]);
                    }
                }

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
                game.add(buttonPanel);
                game.add(gridPanel);
                gridPanel.validate();
                game.setSize(1200, 820);
                game.setLocationRelativeTo(null);
                game.setLayout(null);
                game.setVisible(true);            
            }
        });

        customizeRules.setPreferredSize(new Dimension(270, 60));
        customizeRules.setFont(new Font("Arial", Font.BOLD, 25));

        gameHistory.setPreferredSize(new Dimension(270, 60));
        gameHistory.setFont(new Font("Arial", Font.BOLD, 25));

        buttonPanel.setSize(300, 300);
        buttonPanel.setLocation(435, 450);

        try {
            mainMenu.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("CBL/gitProject/ColorBingo.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        buttonPanel.add(startGame);
        buttonPanel.add(customizeRules);
        buttonPanel.add(gameHistory);
        mainMenu.add(buttonPanel, BorderLayout.CENTER);

        mainMenu.setSize(1200, 800);
        mainMenu.setLocationRelativeTo(null);
        mainMenu.setLayout(null);
        mainMenu.setVisible(true);
    }

    public static void place(JButton[][] buttonGrid) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                buttonGrid[i][j].setEnabled(true);
                if (buttonGrid[i][j].getBackground() == p1Color
                    || buttonGrid[i][j].getBackground() == p2Color
                    || buttonGrid[i][j].getBackground() == Color.DARK_GRAY) {
                    buttonGrid[i][j].setEnabled(false);
                }
            }
        }
    }

    public static void swap(JButton[][] buttonGrid) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                buttonGrid[i][j].setEnabled(false);
                if (!playerTurn && buttonGrid[i][j].getBackground() == p1Color) {
                    buttonGrid[i][j].setEnabled(true);
                } else if (playerTurn && buttonGrid[i][j].getBackground() == p2Color) {
                    buttonGrid[i][j].setEnabled(true);
                }
            }
        }
    }

    public static void obstacle(JButton[][] buttonGrid) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                buttonGrid[i][j].setEnabled(true);
                if (buttonGrid[i][j].getBackground() == p1Color
                    || buttonGrid[i][j].getBackground() == p2Color
                    || buttonGrid[i][j].getBackground() == Color.DARK_GRAY) {
                    buttonGrid[i][j].setEnabled(false);
                }
            }
        }
    }

    public static void eliminate(JButton[][] buttonGrid) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                buttonGrid[i][j].setEnabled(false);
                if ((buttonGrid[i][j].getBackground() == p1Color && !playerTurn)
                    || (buttonGrid[i][j].getBackground() == p2Color && playerTurn)) {
                    buttonGrid[i][j].setEnabled(true);
                }
            }
        }
    }

    public static int checkWin() {
        if (horizontalWin() != 0) {
            return horizontalWin();
        } else if (verticalWin() != 0) {
            return verticalWin();
        } else if (diagonalWin() != 0) {
            return diagonalWin();
        }
        return 0;
    }

    public static int horizontalWin() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize - 3; j++) {
                if (grid[i][j] == grid[i][j + 1] && grid[i][j + 1] == grid[i][j + 2]
                    && grid[i][j + 2] == grid[i][j + 3] && grid[i][j] != 0 && grid[i][j] != - 1) {
                    return grid[i][j];
                }
            }
        }
        return 0;
    }

    public static int verticalWin() {
        for (int j = 0; j < gridSize; j++) {
            for (int i = 0; i < gridSize - 3; i++) {
                if (grid[i][j] == grid[i + 1][j] && grid[i + 1][j] == grid[i + 2][j]
                    && grid[i + 2][j] == grid[i + 3][j] && grid[i][j] != 0 && grid[i][j] != - 1) {
                    return grid[i][j];
                }
            }
        }
        return 0;
    }

    public static int diagonalWin() {
        for (int i = 0; i < gridSize - 3; i++) {
            for (int j = 0; j < gridSize - 3; j++) {
                if (grid[i][j] == grid[i + 1][j + 1] && grid[i + 1][j + 1]
                    == grid[i + 2][j + 2] && grid[i + 2][j + 2] == grid[i + 3][j + 3]
                    && grid[i][j] != 0 && grid[i][j] != - 1) {
                    return grid[i][j];
                } else if (grid[i + 3][j] == grid[i + 2][j + 1] && grid[i + 2][j + 1]
                    == grid[i + 1][j + 2] && grid[i + 1][j + 2] == grid[i][j + 3]
                    && grid[i + 3][j] != 0 && grid[i][j] != - 1) {
                    return grid[i + 3][j];
                }
            }
        }
        return 0;
    }

    public static void postWin(int winner, JFrame game) {
        JFrame winFrame = new JFrame();
        JLabel winnerLabel;
        if (winner == 1) {
            winnerLabel = new JLabel("Player 1 won");
            winnerLabel.setForeground(p1Color);
            
        } else {
            winnerLabel = new JLabel("Player 2 won");
            winnerLabel.setForeground(p2Color);
        }
        winnerLabel.setFont(new Font("Arial", Font.BOLD, 25));

        JButton exitButton = new JButton("Return to Main Menu");
        exitButton.setFont(new Font("Arial", Font.BOLD, 25));
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame.setEnabled(true);
                customizeRules.setEnabled(true);
                gameHistory.setEnabled(true);

                winFrame.dispose();
                game.dispose();
                mainMenu.setState(Frame.NORMAL);
            }
        });

        JPanel winPanel = new JPanel();
        winPanel.setSize(300, 250);
        winPanel.setLocation(100, 0);
        winPanel.add(winnerLabel);
        winPanel.add(Box.createRigidArea(new Dimension(0, 140)));
        winPanel.add(exitButton);
        winFrame.add(winPanel);
        winFrame.setSize(500, 250);
        winFrame.setLocationRelativeTo(null);
        winFrame.setLayout(null);
        winFrame.setVisible(true);

    }

    public static void main(String[] args) {
        new Main();
    }
}
