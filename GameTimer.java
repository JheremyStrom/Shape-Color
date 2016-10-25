import java.util.Timer;
import java.util.TimerTask;

/**
 * Class that is controls the countdown timer for the different game types
 * @author Jheremy Strom
 * @version 1.0
 *
 */
public class GameTimer
{

    /** Timer that will run the different time sensitive functions*/
    private Timer timer;
    /** int that will keep track of the "seconds"*/
    private static int counter;
    /** GameFrame that will equal the gameFrame*/
    private GameFrame gameFrame;

    public GameTimer(int time, GameFrame gameFrame)
    {
        // Objects that need to be set up
        timer = new Timer();
        this.gameFrame = gameFrame;

        // Countdown related set up
        counter = time;   
        timer.schedule(new countDown(), 0);  // Spawn the countdown
    }

    /*
     * HOW THE TIMER WORKS:
     * IT IS A RECURSIVE DEFINITION THAT CHECKS IF THE STATIC
     * VARIABLE "counter" IS 0, IF NOT, THEN IT REDUCES COUNTER
     * AND THEN CALLS UPON ITS SELF AGAIN. THIS PRODUCES A COUNTDOWN
     * RECURSION HAPPENS UNTIL "counter" REACHES 0
     */
    /**
     * A class that has a countdown measured in seconds
     */
    class countDown extends TimerTask
    { 
        public void run()
        {
            // See if the counter has reached 0 seconds
            if(counter < 0)
            {
                counter = 0;
            }
            else
            {
                // Update the label, reduce the countdown timer, and set up the new time
                gameFrame.setLabelText(gameFrame.gettimeLabel(),String.valueOf(counter));                
                counter--;
                timer.schedule(new countDown(), 1000);
            }
        }
    }

    /**
     * Method to return counter
     */
    public static int counter()
    {
        return counter;
    }

    /**
     * Method to cancel the timer
     */
    public void cancel()
    {
        timer.cancel();
    }
}
