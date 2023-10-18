import java.util.Random;

/**
 * ActiveCreature represents a type of creature that is active and can participate in battles.
 * It extends the base class Creatures, inheriting properties such as name, type, family, and level,
 * while adding an additional level and randomness functionality for battles.
 */

public class ActiveCreature  extends Creatures{
    
   
    private int level;
    private Random random;
   
/**
* Constructs an ActiveCreature with the specified name, type, and family.
* The level of the creature is initially set based on the getLevel method.
*
* @param name   The name of the active creature.
* @param type   The type of the active creature.
* @param family The family of the active creature.
*/

        ActiveCreature(String name, String type, char family){
            super(name, type, family);
            this.level = getLevel();
            random  = new Random();
           
        }

/**
* Retrieves the attack damage of the active creature, which is calculated based on its level.
* The attack damage is influenced by a random number.
*
* @return The attack damage of the active creature.
*/

        public double getAttackDamage() {
            int randomNumber = random.nextInt(1,10);
            return randomNumber * level;
        }
}
