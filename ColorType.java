import java.awt.event.*;

/**
 * Class that contains the "Color" game mode
 * @author Jheremy Strom
 * @version 1.0
 *
 */
public class ColorType
{
    /** String variable to keep track of the colors used */
    private String[] colors = {"blue", "red", "yellow", "green"};
    /** int to keep track of whats the correct color */
    private int[] rightAnswer = {1, 0 , 0, 0};  // topLeft, topRight, bottomLeft, bottomRight
    /** GameFrame that will equal the gameFrame*/
    private GameFrame gameFrame;
    /** int to keep track of what button pressed, if pressed, was pressed*/
    private int clicked = -1;  // Checks if any button has been pressed
    /** GameTimer countdown for the game */
    private GameTimer timer;
    /** int that is an index to the position that has the value 1 in rightAnswer*/
    private int index = 0;
    /** int for the topLeftButton */
    private final int topLeftButtonInt = 0;
    /** int for the topRightButton */
    private final int topRightButtonInt = 1;
    /** int for the bottomLeftButton */
    private final int bottomLeftButtonInt = 2;
    /** int for the bottomRightButton */
    private final int bottomRightButtonInt = 3;

    /**
     * A constructer with a GameFrame argument
     */
    public ColorType(GameFrame gameFrame)
    {
        // Prepare objects
        this.gameFrame = gameFrame;
        timer = new GameTimer(3, gameFrame);  // Spawn the 3 second timer
        gameFrame.gameScreen();

        // Make sure the 3 second countdown is done
        while(GameTimer.counter() > -1){}    
        startGame();
    }

    /**
     * Method to start the color game type
     */
    public void startGame()
    {
        // Boolean to keep track of if the player got an answer wrong
        boolean gameNotLost = true;
        // Amount of times the correct color has been guessed
        int numberCorrect = 0;
        // Start the 10 second countdown
        timer.cancel();  // Make sure the 3 second countdown is stopped
        timer = new GameTimer(10, gameFrame);
        // Prepare the buttons and their logic
        setUpButtons();
        // Find the index fo the correct button
        findIndex();
        // Prepare the label for what color to find
        gameFrame.setLabelText(gameFrame.getGameLabel(), colors[index]);

        /* 
         * Loop that runs the main logic of the "Color" game type
         * It will run until "counter" reaches 0 and then displays the score
         */
        while(GameTimer.counter() > 0)
        {            
            // Check if there was any input
            if(clicked == -1)
            {
                continue;  // No input, so restart the loop
            }

            // Handle a button press and check if it was the correct button
            if(clicked == index)
            {
                // Update how many correct the player has got
                numberCorrect++;               
                // Prepare the buttons and their logic
                setUpButtons();
                // Find the index again
                findIndex();
                // Prepare the label for what color to find
                gameFrame.setLabelText(gameFrame.getGameLabel(), colors[index]);  
            }
            else  // Exit out of the game 
            {         
                gameNotLost = false;  // The player got the wrong answer
                break;           
            }

            // Reset clicked
            clicked = -1;
        }

        timer.cancel();
        // Run the game over screen regardless
        gameFrame.gameOverScreen(numberCorrect, gameNotLost);
    }

    /**
     * Method to set up gameFrame to fit the game ColorType
     */
    public void setUpButtons()
    {
        shuffle();  // Reset the order of colors and the right answer

        // topLeftButton
        gameFrame.setButtonBackground(gameFrame.TopLeftBtn(), colors[0]);
        gameFrame.addAction(gameFrame.TopLeftBtn(), new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    setClicked(topLeftButtonInt);
                }
            } );

        // topRightBtn
        gameFrame.setButtonBackground(gameFrame.TopRightBtn(), colors[1]);
        gameFrame.addAction(gameFrame.TopRightBtn(), new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    setClicked(topRightButtonInt);
                }
            } );

        // bottomLeftBtn
        gameFrame.setButtonBackground(gameFrame.BottomLeftBtn(), colors[2]);
        gameFrame.addAction(gameFrame.BottomLeftBtn(), new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    setClicked(bottomLeftButtonInt);
                }
            } );

        // bottomRightBtn
        gameFrame.setButtonBackground(gameFrame.BottomRightBtn(), colors[3]);
        gameFrame.addAction(gameFrame.BottomRightBtn(), new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    setClicked(bottomRightButtonInt);
                }
            } );

    }

    /**
     * Method to shuffle the colors and the correct answer that a button receives
     */
    public void shuffle()
    {
        // Shuffle colors algorithm
        for (int k = colors.length - 1; k > 0; k--) {
            int pos = (int) (Math.random() * (k + 1));  // range 0 to k, inclusive
            String temp = colors[pos];
            colors[pos] = colors[k];
            colors[k] = temp;
        }

        // Shuffle rightAnswer algorithm
        for (int k = rightAnswer.length - 1; k > 0; k--) {
            int pos = (int) (Math.random() * (k + 1));  // range 0 to k, inclusive
            int temp = rightAnswer[pos];
            rightAnswer[pos] = rightAnswer[k];
            rightAnswer[k] = temp;
        }
    }

    /**
     * Method to find what index in rightAnswer has the value 1
     */
    public void findIndex()
    {
        // Find what button is the correct one
        for(int i=0; i<rightAnswer.length; i++)
        {
            if(rightAnswer[i] == 1)
            {
                index = i;
            }
        }
    }

    /**
     * Method to set clicked
     */
    public void setClicked(int clicked)
    {
        this.clicked = clicked;
    }
}
