
import java.util.Random;

/**
 * The EnemyCreature class represents an enemy creature in the game, extending the base Creatures class. It includes
 * attributes related to the enemy creature's health, type, family, and provides methods to manage its health and
 * generate random enemy creatures.
 */

public class EnemyCreature  extends Creatures{
    
    private double health;
    private Random random;
    
    /**
     * Constructs an EnemyCreature with the specified name, type, and family. The health is set to 50, and a random
     * number generator is initialized.
     *
     * @param name   The name of the enemy creature.
     * @param type   The type of the enemy creature.
     * @param family The family of the enemy creature.
     */

        EnemyCreature(String name, String type, char family){
            super(name, type, family);
            this.health = 50;
            random = new Random();

           
        }

    /**
     * Retrieves the health points of the enemy creature.
     *
     * @return The health points of the enemy creature as a double.
     */

        public double getHealth() {
            return health;
        }

    /**     
     * Reduces the enemy creature's health by a specified amount.
     *
     * @param damage The amount of damage to deduct from the enemy creature's health.
     */

        public void receiveDamageHealth(double damage){
            this.health = this.health - damage;
        }

    /**
     * Generates a random enemy creature based on type and family.
     *
     * @return A randomly generated enemy creature.
     */
    
        public EnemyCreature generateEnemy(){
            int randomType = random.nextInt(1,2);
    
            if(randomType == 1){
                int randomName = random.nextInt(2) + 1;
                if(randomName == 1){
                    return new EnemyCreature("STRAWMANDER", "Fire", 'A');
                }else if (randomName == 2){
                    return new EnemyCreature("CHOCOWOOL", "FIRE", 'B');
                }else{
                    return new EnemyCreature("PARFWIT", "FIRE", 'C');
                }
            }else if (randomType == 2){
                int randomName = random.nextInt(2) + 1;
                if(randomName == 1){
                    return new EnemyCreature("SQUIRPIE", "WATER", 'D');
                }else if (randomName == 2 ){
                    return new EnemyCreature("CHOCOLITE","WATER", 'E');
    
                }else{
                    return new EnemyCreature("OSHACONE", "WATER", 'F');
    
                }
            
            }else{
                int randomName = random.nextInt(2)+1;
                if(randomName == 1){
                    return new EnemyCreature("BROWNISAUR", "LEAF", 'G');
    
                }else if (randomName == 2 ){
                    return new EnemyCreature("PARFWIT", "LEAF", 'H');
    
                }else{
                    return new EnemyCreature("FRUBAT", "LEAF", 'I');
    
                }
    
            }

        }

        

        

        
}
