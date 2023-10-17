
import java.util.Random;

public class EnemyCreature  extends Creatures{
    
    private double health;
    private Random random;
    

        EnemyCreature(String name, String type, char family){
            super(name, type, family);
            this.health = 50;
            random = new Random();

           
        }
        

        public double getHealth() {
            return health;
        }

        public void receiveDamageHealth(double damage){
            this.health = this.health - damage;
        }

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
