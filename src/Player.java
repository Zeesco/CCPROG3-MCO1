public class Player {
    private Inventory inventory;
    private Creatures activeCreature;
    

        public Player (){
            this.inventory = new Inventory(); 

        }

    public void setActiveCreature(Creatures creature){
            this.inventory.setActiveCreature(creature);
    }
    public Creatures getActiveCreature() {
        return activeCreature;
    }

    public void addCreatureToInventory(Creatures creatures) {
        inventory.addInventory(creatures);
    }

    public Inventory getInventory(){
        return inventory;
    }

    

}
