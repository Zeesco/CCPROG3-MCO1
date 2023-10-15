import java.util.ArrayList;

public class Inventory{
    private ArrayList <Creatures> creature;
    ActiveCreature activeCreature;
    
    public Inventory (ActiveCreature activeCreature){
        this.creature = new ArrayList<>();
        this.activeCreature = activeCreature;
    }

    public void addInventory(Creatures creature){
        this.creature.add(creature);
    }

    public void setActiveCreature(ActiveCreature activeCreature) {
        this.activeCreature = activeCreature;
    }
    public ActiveCreature getActiveCreature() {
        return activeCreature;
    }

    public boolean isCreatureInsideInventory(String name){
        for(Creatures creature : creature){
            if(creature.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public void replaceCreature(String name){
        for(Creatures creature : creature){
            if(creature.getName().equals(name) ){
                addInventory(activeCreature);
                activeCreature = (ActiveCreature) creature; //downcast
                break;
            }
        }
    }
   
    public void displayCreatures(){
       
        System.out.println("Active Creature: ");
         System.out.println("Type: " + activeCreature.getType() + " Family: "+ activeCreature.getFamily() + ", Name: " + activeCreature.getName() + ", Level: " + activeCreature.getLevel());

        System.out.println("Caught Creatures:");
        for(Creatures creature : creature){
            if(!creature.equals(activeCreature)){
            System.out.println("Type: " + creature.getType() + ", Name: " + creature.getName() + ", Level: " + creature.getLevel());
            }
        }

    }

    

   

    


    
}