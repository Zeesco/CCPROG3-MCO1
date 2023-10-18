/**
 * The AreaTwo class represents a specific game area within the game, which extends the base Area class. It contains
 * information about the layout of the area, the player's position, and provides methods for displaying the area and
 * getting its size.
 */

public class AreaTwo extends Area{

    private int areaTwo[][];
    private Player player;

     /**
     * Constructs an AreaTwo object associated with a specific player. The area contains a 2D layout and initializes
     * the game area with a size of 3x3. It also sets up the player's position and the player object.
     *
     * @param player The player associated with the area.
     */

    AreaTwo(Player player){
        super(player);
        this.player = player;
        areaTwo = new int [3][3];
    }

    /**
     * Displays the 2D layout of the game area, indicating the player's position with 'U' brackets.
     */
    public void displayAreaTwo() {
        for (int i = 0; i < areaTwo.length; i++) {
            for (int j = 0; j < areaTwo[i].length; j++) {
                if(player.getPosition() == j && player.getPositionY() == i){
                    System.out.print("[U]");
                }else{
                    System.out.print("[ ] ");
                }
                
            }
            System.out.println();
        }
    }
    
    /**
     * Retrieves the size of the 2D game area (3x3).
     *
     * @return The size of the game area as an integer (3x3).
     */
    public int getAreaTwoSize() {
        return areaTwo.length;
    }
}