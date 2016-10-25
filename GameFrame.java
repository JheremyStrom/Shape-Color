import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * THINGS TO IMPLEMENT:
 * Center the text for the labels
 * Make the elements in the GUI -- labels and buttons -- a more user friendly size
 * 
 */

/**
 * Class that holds the game and displays it using a JFrame
 * 
 * @author Jheremy Strom
 */
public class GameFrame
{

    /**
     * fields
     */

    /** String variable to tell GameLoop what to do */
    private static String control = "";

    /** Main window used as the frame */
    private JFrame frame = new JFrame("Shape Color");    

    ///////////////// STARTING PANEL GUI ////////////////////

    /** Button to start the game */
    private JButton startButton = new JButton("Start Game");

    /** Button to exit out of the game */ 
    private JButton quitButton = new JButton("Quit Game");

    /** Label to show the title of the game */
    private JLabel startLabel = new JLabel("Shape Color");

    /** Panel that contains the objects for the start menu */
    private JPanel startPanel = new JPanel();

    ///////////////// GAME CHOOSE GUI ///////////////////

    /** Button to start the game */
    private JButton colorButton = new JButton("Color");

    /** Label to show the title of the game */
    private JLabel gameChooseLabel = new JLabel("Choose the game mode");

    /** Panel that contains the objects for the start menu */
    private JPanel gameChoosePanel = new JPanel();

    ///////////////// GAME PANEL GUI ////////////////////

    /** Panel that contains the objects for the game board */
    private JPanel gamePanel = new JPanel();

    /** Sub Panel that contains the buttons for the game board */
    private JPanel subGamePanel = new JPanel();

    /** Label to show the color/shape to choose */
    private JLabel gameLabel = new JLabel("Ready?");

    /** Label to show the time */
    private JLabel timeLabel = new JLabel("");

    /** Button for the top left corner */
    private JButton topLeftBtn = new JButton();

    /** Button for the top right corner */
    private JButton topRightBtn = new JButton();

    /** Button for the bottom left corner */
    private JButton bottomLeftBtn = new JButton();

    /** Button for the bottom right corner */
    private JButton bottomRightBtn = new JButton();

    ///////////////// CONSTRUCTORS ////////////////////////
    /**
     * A constructer with no arguments.
     */
    public GameFrame()
    {
        frame.setVisible(true);

        // Set the frame size
        frame.setSize(500,500);
    }

    ///////////////////////// METHODS ///////////////////////////////

    /**
     * Method to populate game frame with the start screen
     */
    public void startScreen()
    {

        // Adjust the elements in startPanel
        startButton.setPreferredSize(new Dimension(500, 100));
        quitButton.setPreferredSize(new Dimension(500, 150));
        startLabel.setPreferredSize(new Dimension(500, 150));
        startPanel.setLayout(new GridLayout(3,0));

        //Process the quitButton 
        quitButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){                  
                    close();      
                    control = "quit";
                }
            });

        //Process the startButton
        startButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    startPanel.setVisible(false);
                    gameChooseScreen();
                }
            });

        // Add the elements to startPane
        startPanel.add(startLabel);
        startPanel.add(startButton);
        startPanel.add(quitButton);

        // Set up the frame
        frame.remove(frame.getContentPane());
        frame.setContentPane(startPanel);
        frame.validate();
    }

    /**
     * Method to populate game frame with the game choosing screen
     */
    public void gameChooseScreen()
    {
        // Adjust the elements in gameChoosePanel
        colorButton.setPreferredSize(new Dimension(500, 250));
        gameChooseLabel.setPreferredSize(new Dimension(500, 250));
        gameChoosePanel.setLayout(new GridLayout(2,0));

        //Process the colorButton
        colorButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    control = "colorType";  // Create a new colorType game
                }
            });

        // Add the elements to gameChoosePanel
        gameChoosePanel.add(gameChooseLabel);
        gameChoosePanel.add(colorButton);

        // Set up the frame
        frame.remove(frame.getContentPane());
        frame.setContentPane(gameChoosePanel);
        frame.validate();
    }

    /**
     * Method to populate game frame with the game screen
     */
    public void gameScreen()
    {
        // Adjust the elements in gamePanel and subGamePanel
        topLeftBtn.setPreferredSize(new Dimension(250, 200));
        topRightBtn.setPreferredSize(new Dimension(250, 200));
        bottomLeftBtn.setPreferredSize(new Dimension(250, 200));
        bottomRightBtn.setPreferredSize(new Dimension(250, 200));        
        gameLabel.setPreferredSize(new Dimension(250, 100));
        timeLabel.setPreferredSize(new Dimension(250, 100));        

        gamePanel.setLayout(new GridLayout(2,0));
        gamePanel.setPreferredSize(new Dimension(500, 100));
        subGamePanel.setLayout(new GridLayout(2,2));
        subGamePanel.setPreferredSize(new Dimension(500, 400));

        // Add the elements to subGamePanel
        subGamePanel.add(topLeftBtn);
        subGamePanel.add(topRightBtn);
        subGamePanel.add(bottomLeftBtn);
        subGamePanel.add(bottomRightBtn);

        // Add the elements to gamePanel
        JPanel tempPanel = new JPanel(new GridLayout(0,2));  // Temporary panel because I didn't want to deal with adding an instane variable
        tempPanel.add(gameLabel);
        tempPanel.add(timeLabel);
        gamePanel.add(tempPanel);
        gamePanel.add(subGamePanel);

        // Set up the frame
        frame.remove(frame.getContentPane());
        frame.setContentPane(gamePanel);
        frame.validate();
    }

    /**
     * Method to populate game frame with the game over screen
     */
    public void gameOverScreen(int numberCorrect, boolean gameNotLost)
    {
        //Button to restart the game
        JButton againOverButton = new JButton("Again");
        againOverButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    control = "colorType";  // Create a new colorType game
                }
            });

        // Button to exit out of the current game
        JButton quitOverButton = new JButton("Quit");
        quitOverButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    close();      
                    control = "quit";
                }
            });

        JLabel startOverLabel;
        // Label to show the result
        if(gameNotLost)
        {
            startOverLabel = new JLabel("Congradulations! You got " + numberCorrect + " right"); 
        }
        else
        {
            startOverLabel = new JLabel("Incorrect. You got " + numberCorrect + " right");
        }

        // Panel that contains the objects for the gameOverScreen
        JPanel gameOverPanel = new JPanel();
        gameOverPanel.setLayout(new GridLayout(3,0));
        gameOverPanel.setPreferredSize(new Dimension(500, 500));

        // Adjust the elements in gameOverPanel
        againOverButton.setPreferredSize(new Dimension(500,100));
        quitOverButton.setPreferredSize(new Dimension(500, 200));
        startOverLabel.setPreferredSize(new Dimension(500, 200));

        // Add the elements to gameOverPanel
        gameOverPanel.add(startOverLabel);
        gameOverPanel.add(againOverButton);
        gameOverPanel.add(quitOverButton);

        // Makes sure a button press from the game doesn't prematurely press one of these buttons
        try 
        {
            Thread.sleep(1000);
        } 
        catch(InterruptedException exception)
        {
            Thread.currentThread().interrupt();
        }

        // Set up the frame
        frame.remove(frame.getContentPane());
        frame.setContentPane(gameOverPanel);
        frame.validate();
    }

    /**
     * Method that adds an action listener to a button
     */
    public void addAction(JButton button, ActionListener action)
    {
        button.addActionListener(action);
    }

    ///////////////////////////// BUTTON RELATED METHODS ///////////////////////////
    /**
     * Method to update the background of a label
     */
    public void setButtonBackground(JButton button, String color)
    {
        if(color.equals("blue"))
        {
            button.setBackground(Color.blue);
        }
        else if(color.equals("red"))
        {
            button.setBackground(Color.red);
        }
        else if(color.equals("green"))
        {
            button.setBackground(Color.green);
        }
        else
        {
            button.setBackground(Color.yellow);
        }
    }

    /**
     * @return topLeftBtn
     */
    public JButton TopLeftBtn()
    {
        return topLeftBtn;
    }

    /**
     * @return topRightBtn
     */
    public JButton TopRightBtn()
    {
        return topRightBtn;
    }

    /**
     * @return bottomLeftBtn
     */
    public JButton BottomLeftBtn()
    {
        return bottomLeftBtn;
    }

    /**
     * @return bottomRightBtn
     */
    public JButton BottomRightBtn()
    {
        return bottomRightBtn;
    }

    ///////////////////////////// LABEL RELATED METHODS ////////////////////////////
    /**
     * @return timeLabel
     */
    public JLabel gettimeLabel()
    {
        return timeLabel;
    }

    /**
     * @return gameLabel
     */
    public JLabel getGameLabel()
    {
        return gameLabel;
    }

    /**
     * Method to update the text of a label
     */
    public void setLabelText(JLabel label, String text)
    {
        label.setText(text);
    }

    /**
     * A method to close a picture frame
     */
    public void close()
    {
        frame.setVisible(false);
        frame.dispose();
    }

    /**
     * @return control
     */
    public String getControl()
    {
        return control;
    }

    /**
     * Set control
     */
    public void setControl(String s)
    {
        control = s;
    }
}
