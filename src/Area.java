
import java.util.Random;
/**
 * The Area class represents a game area that the player can explore. It contains information about the area's attributes,
 * such as the presence of enemy creatures, the player's active creature, and the area's size. The class also manages
 * interactions with enemy creatures and displays the area to the player.
 */
public class Area {
   
    private int areaOne[];
   
    private Random random;
    EnemyCreature enemyCreature;
    private Player player;
    private double activeDamage;
    
/**
* Constructs an Area object associated with a specific player. The area contains an enemy creature and initialize.
* the game area with a size of 5. It also sets up the random number generator.
*
* @param player The player associated with the area.
*/    
   
    public Area(Player player)
    {
        this.player = player;
        this.enemyCreature = new EnemyCreature(null, null, 'n').generateEnemy();
        areaOne = new int[5];
        random = new Random();
        
    }

/**
* Checks if the area corresponds to the player's choice.
*
* @param choice The choice made by the player.
* @return true if the area matches the player's choice; false otherwise.
*/

    public boolean isArea(int choice){
        if(choice == 1){
            return false;
        }else if(choice == 2){
            return false;
        }else if(choice == 3){
            return false;
        }

        return true;
    }

/**
* Retrieves the enemy creature present in the area.
*
* @return The enemy creature in the area.
*/

    public EnemyCreature getEnemyCreature() {
        return enemyCreature;
    }

/**
* Displays the game area, indicating the player's position with 'U' brackets.
*/

    public void displayAreas(){
         
        for (int i =  0 ; i < areaOne.length ; i++){
            System.out.print(" [");
            if(i == player.getPosition()){
                System.out.print("U");
                
            }
            System.out.print("] ");
        }
        
    }

/**
* Attacked the enemy creature in the area with the specified damage.
*
* @param damage The damage to be inflicted on the enemy creature.
*/

    public void enemyAttacked(double damage)
    {
        enemyCreature.receiveDamageHealth(damage);
    }

/**
* Calculates the damage inflicted by the active creature based on type advantages.
*
* @return The damage inflicted by the active creature.
*/

    public Double getActiveCreatureDamage (){
        if(enemyCreature.getType().equals("FIRE") && player.getInventory().getActiveCreature().getType().equals("WATER")){
            return activeDamage * 1.5;
        }else if(enemyCreature.getType().equals("LEAF") && player.getInventory().getActiveCreature().getType().equals("FIRE")){
            return activeDamage * 1.5;
        }else if(enemyCreature.getType().equals("WATER") && player.getInventory().getActiveCreature().getType().equals("GRASS")){
            return activeDamage * 1.5;
        }else{
            return activeDamage;
        }
    }

/**
* Sets the damage inflicted by the active creature.
*
* @param activeDamage The damage to be set for the active creature.
*/

    public void setActiveCreatureDamage (double activeDamage){
        this.activeDamage = activeDamage;
    }

/**
* Checks if the player encounters an enemy creature in the area, based on a random chance.
*
* @return true if the player encounters an enemy creature; false otherwise.
*/  

    public boolean isEncounterCreature(){
        int randomInRange = random.nextInt(100) + 1;
        for (int i =  0 ; i < areaOne.length ; i++){
                if(randomInRange < 40){
                    return true;
                }
            }

          return false;
        }

/**
* Displays information about the enemy creature present in the area, including its type, name, level, and health.
*/

    public void displayEnemyCreature(){
        System.out.println("\nType: " + enemyCreature.getType() + "\nName: " + enemyCreature.getName() + "\nLevel: " +  enemyCreature.getLevel() + "\nHealth: "+ enemyCreature.getHealth());
    }

       
/**
* Retrieves the size of the game area.
*
* @return The size of the game area as an integer.
*/

    public int getSizeArea() {
        return areaOne.length;
    }

   
}



