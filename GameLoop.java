/**
 * Overall Program Issues Or Things to Implement Software Wise:
 * AFTER THE THIRD PRESS OF "againOverButton" THE COUNTDOWN
 * RUNS BUT STOPS AT 0 ------- Quick Fix is to quit the game and rerun the program
 *
 * FOR SOME OF THE NEW PANELS, THE LOCATION OF THE FRAME DEFAULTS BACK
 * TO POSITION (0,0) ON THE SCREEN. MAKE IT SO IT DOESN'T SHIFT
 * 
 * CREATE AN INTERFACE IN ORDER FOR NEW GAME TYPES TO BE ADDED IN EASIER
 * AND HAVE AN OUTLINE OF WHAT TO FOLLOW
 * 
 * ADD A HELP MENU TO EXPLAIN THE DIFFERENT GAME MODES
 */

/**
 * Things to Add to the Game:
 * HAVE MULTIPLE LEVELS OF INCREASING DIFFICULTY TO EACH GAME TYPE
 * 
 * ADD IN THE DIFFERENT GAME TYPES: LIKE SHAPES
 * 
 * CREATE ACTUAL IMAGES FOR THE THINGS TO FIND
 */

/**
 * Class that controls the main game loop; the control center for the game
 * 
 * @author Jheremy Strom
 * @version 1.0
 */
public class GameLoop
{      
    public static void main(String[] args){
        GameFrame gameFrame = new GameFrame();
        gameFrame.startScreen();
        
        // Continue the program until "control" == 'quit'
        while(!gameFrame.getControl().equals("quit"))
        {
            if(gameFrame.getControl().equals(""))
            {                
                // Do nothing if "control" == ''
            }
            else if(gameFrame.getControl().equals("colorType"))  // The "Color" game mode wants to be spawned
            {
                gameFrame.close();  // Close out of the old frame
                gameFrame = new GameFrame();  // Create the old frame
                gameFrame.setControl("");  // Reset "control"
                ColorType colorType = new ColorType(gameFrame);  // Create the new 
            }
        }
    }
}
