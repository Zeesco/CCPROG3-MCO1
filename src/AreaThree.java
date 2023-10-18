/**
 * The AreaThree class represents a specific game area within the game, which extends the base Area class. It contains
 * information about the layout of the area, the player's position, and provides methods for displaying the area.
 */

public class AreaThree extends Area{
    private int areaThree[][];
    private Player player;

    /**
     * Constructs an AreaThree object associated with a specific player. The area contains a 2D layout and initializes
     * the game area with a size of 4x4. It also sets up the player's position and the player object.
     *
     * @param player The player associated with the area.
     */

    AreaThree(Player player){
        super(player);
        this.player = player;
        areaThree = new int [4][4];
    }

    /**
     * Displays the 2D layout of the game area, indicating the player's position with 'U' brackets.
     */


    public void displayAreaTwo() {
        for (int i = 0; i < areaThree.length; i++) {
            for (int j = 0; j < areaThree[i].length; j++) {
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
     * Retrieves the size of the 2D game area (4x4).
     *
     * @return The size of the game area as an integer (4x4).
     */

    public int getAreaThreeSize() {
        return areaThree.length;
    }
}
