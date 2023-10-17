
import java.util.Random;

public class Area {
   
    private int areaOne[];
   
    private Random random;
    EnemyCreature enemyCreature;
    private Player player;
    private double activeDamage;
    
    
   

    public Area(Player player)
    {
        this.player = player;
        this.enemyCreature = new EnemyCreature(null, null, 'n').generateEnemy();
        areaOne = new int[5];
        random = new Random();
        
        
    }

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


    public EnemyCreature getEnemyCreature() {
        return enemyCreature;
    }

    public void displayAreas(){
        
         
        for (int i =  0 ; i < areaOne.length ; i++){
            System.out.print(" [");
            if(i == player.getPosition()){
                System.out.print("U");
                
            }
            System.out.print("] ");
        }
        
    }

    public void enemyAttacked(double damage)
    {
        enemyCreature.receiveDamageHealth(damage);
    }

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
    public void setActiveCreatureDamage (double activeDamage){
        this.activeDamage = activeDamage;
    }

   

    public boolean isEncounterCreature(){
        int randomInRange = random.nextInt(100) + 1;
        for (int i =  0 ; i < areaOne.length ; i++){
                if(randomInRange < 40){
                    return true;
                }
            }

          return false;
        }


       

        public void displayEnemyCreature(){
            System.out.println("Type: " + enemyCreature.getType() + ", Name: " + enemyCreature.getName() + ", Level: " +  enemyCreature.getLevel() + " health: "+ enemyCreature.getHealth());
        }

       
    

    public int getSizeArea() {
        return areaOne.length;
    }

   
}


