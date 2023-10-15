public class Player {
    private Inventory inventory;
    private ActiveCreature activeCreature;
    

        public Player (Inventory inventory){
            this.inventory = inventory;
        }

    

    public void addToInventory(Creatures creatures) {
        inventory.addInventory(creatures);
    }

    public void catchCreature(Creatures creatures) {
        inventory.addInventory(creatures);
    }

    public Inventory getInventory(){
        return inventory;
    }

    public void attackCreature (EnemyCreature creature) {
    
    }
  
    public void swapCreature (String name) {//fix this part
      inventory.replaceCreature(name);
    }
  
 

}
