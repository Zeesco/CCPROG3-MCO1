import java.util.Random;

/**
 * The Player class represents a player in the game. It manages the player's inventory, position,
 * active creature, and various in-game actions.
 */

public class Player {
    private Inventory inventory;
    private int position;
    private ActiveCreature activeCreature;
    private Random random;
    private int positionY;
    
   
    /**
     * Constructs a new Player instance with the provided inventory.
     *
     * @param inventory The player's inventory used to store and manage creatures.
     */   

        public Player (Inventory inventory){
            this.inventory = inventory;
            this.position = 0;
            this.positionY = 0;
            this.random = new Random();
        }

    /**
     * Adds a creature to the player's inventory.
     *
     * @param creatures The creature to be added to the inventory.
     */

    public void addToInventory(Creatures creatures) {
        inventory.addInventory(creatures);
    }

    /**
     * Attempts to catch a creature. Success depends on random chance and the enemy creature's health.
     *
     * @param creatures The creature to be caught.
     */

    public void catchCreature(Creatures creatures) {
        inventory.addInventory(creatures);
    }

    /**
     * Checks if the player successfully catches an enemy creature based on random chance.
     *
     * @param enemyCreature The enemy creature being encountered.
     * @return true if the catch is successful, false otherwise.
     */

    public boolean isCatchCreature(EnemyCreature enemyCreature) {
        int randomNumber = random.nextInt(1,100) ;
    
        if (randomNumber < (40 + 50 - enemyCreature.getHealth())) {
            return true;
        }
        return false;
    }

    /**
     * Gets the player's inventory.
     *
     * @return The player's inventory.
     */

    public Inventory getInventory(){
        return inventory;
    }
    
    /**
     * Sets the currently active creature by name.
     *
     * @param name The name of the creature to set as active.
     */

    public void setActiveCreature(String name){
       setActiveCreature(name);
    }

    /**
     * Retrieves the currently active creature.
     *
     * @return The currently active creature.
     */

    public ActiveCreature getActiveCreature(){
        return activeCreature;
    }

    /**
     * Displays information about the active creature.
     *
     * @param creature The active creature to display information about.
     */

    public void displayActiveCreature(ActiveCreature creature)
    {
        System.out.println("Type: " + activeCreature.getType() + ", Name: " + activeCreature.getName() + ", Level: " +  activeCreature.getLevel());
    }

     /**
     * Attacks an enemy creature using the active creature's attack damage.
     *
     * @param enemy The enemy creature to attack.
     */

    public void attackEnemyCreature(EnemyCreature enemy)
    {
        enemy.receiveDamageHealth(activeCreature.getAttackDamage());
    }
  
    /**
     * Swaps the active creature in the player's inventory.
     *
     * @param name The name of the creature to set as the new active creature.
     */

    public void swapCreature (String name) {//fix this part
      inventory.replaceCreature(name);
    }
    
     /**
     * Checks if the player can perform a creature swap (i.e., having more than one creature).
     *
     * @return true if the player can swap creatures, false if there's only one creature.
     */

    public boolean isSwap(){
        if(inventory.getNumberOfCreatures() == 1){
            return true;
        }
        return false;
    }

    /**
     * Resets the player's horizontal position to zero.
     */

    public void resetPosition() {
        this.position = 0;
    }

    /**
     * Resets the player's vertical position to zero.
     */

    public void resetPositionY() {
        this.position = 0;
    }
  
    /**
     * Moves the player to the left if within bounds.
     */

    public void moveLeft() {
        if(getPosition() >=1){
            position--;
        }else{
            System.out.println("You are out of bounds");
        }
       
    }

    /**
     * Moves the player to the right if within bounds.
     *
     * @param size The size of the area.
     */

    public void moveRight(int size) {
        if(getPosition() < size - 1){ // clarify this is class relationships
            position++;
        }else{
             System.out.println("You are out of bounds");
        }
    }

    /**
     * Gets the player's horizontal position.
     *
     * @return The player's horizontal position.
     */

    public int getPosition() {
        return position;
    }
    
     /**
     * Moves the player up within the vertical area.
     */

    public void moveUp() {
        if (positionY > 0) positionY--;
    }

    /**
     * Moves the player down within the vertical area.
     *
     * @param size The size of the vertical area.
     */

    public void moveDown(int size) {
        if (positionY < size) positionY++;
    }

    /**
     * Gets the player's vertical position.
     *
     * @return The player's vertical position.
     */
   
    public int getPositionY() {
        return positionY;
    }

}