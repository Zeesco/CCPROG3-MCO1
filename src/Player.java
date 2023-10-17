import java.util.Random;

public class Player {
    private Inventory inventory;
    private int position;
    private ActiveCreature activeCreature;
    private Random random;
    
   
    

        public Player (Inventory inventory){
            this.inventory = inventory;
            this.position = 0;
            this.random = new Random();
        }

    public void addToInventory(Creatures creatures) {
        inventory.addInventory(creatures);
    }

    public void catchCreature(Creatures creatures) {
        inventory.addInventory(creatures);
    }

    public boolean isCatchCreature(EnemyCreature enemyCreature) {
        int randomNumber = random.nextInt(1,100) ;
    
        if (randomNumber < (40 + 50 - enemyCreature.getHealth())) {
            return true;
        }
        return false;
    }

    public Inventory getInventory(){
        return inventory;
    }
    
    public void setActiveCreature(String name){
       setActiveCreature(name);
    }


    public ActiveCreature getActiveCreature(){
        return activeCreature;
    }


    public void displayActiveCreature(ActiveCreature creature)
    {
        System.out.println("Type: " + activeCreature.getType() + ", Name: " + activeCreature.getName() + ", Level: " +  activeCreature.getLevel());
    }

    public void attackEnemyCreature(EnemyCreature enemy)
    {
        enemy.receiveDamageHealth(activeCreature.getAttackDamage());
    }
  
    public void swapCreature (String name) {//fix this part
      inventory.replaceCreature(name);
    }
    
    public boolean isSwap(){
        if(inventory.getNumberOfCreatures() == 1){
            return true;
        }
        return false;
    }
  


    public void moveLeft() {
        if(getPosition() >=1){
            position--;
        }else{
            System.out.println("You are out of bounds");
        }
       
    }

    public void moveRight(Area areaOne) {
        if(getPosition() < areaOne.getSizeArea() - 1){ // clarify this is class relationships
            position++;
        }else{
             System.out.println("You are out of bounds");
        }
    }

    public int getPosition() {
        return position;
    }
 

}