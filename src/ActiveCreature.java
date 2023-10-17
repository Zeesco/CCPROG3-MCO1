import java.util.Random;

public class ActiveCreature  extends Creatures{
    
   
    private int level;
    private Random random;
   

        ActiveCreature(String name, String type, char family){
            super(name, type, family);
            this.level = getLevel();
            random  = new Random();
           
        }

        public double getAttackDamage() {
            int randomNumber = random.nextInt(1,10);
            return randomNumber * level;
        }
}
