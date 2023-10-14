import java.util.ArrayList;

public class Inventory{
    private ArrayList <Creatures> creature;
    private Creatures activeCreature;
    
    public Inventory (){
        this.creature = new ArrayList<>();
    }

    public void addInventory(Creatures creature){
        this.creature.add(creature);
    }

    public void setActiveCreature(Creatures creature) {
        this.activeCreature = creature;
    }
    public Creatures getActiveCreature() {
        return activeCreature;
    }
    public void displayCreatures(){
        System.out.println("Inventory ");
        System.out.println("Active Creature: ");
         System.out.println("Type: " + activeCreature.getType() + ", Name: " + activeCreature.getName() + ", Level: " + activeCreature.getLevel());

        System.out.println("Caught Creatures:");
        for(Creatures creature : creature){
            if(!creature.equals(activeCreature)){
            System.out.println("Type: " + creature.getType() + ", Name: " + creature.getName() + ", Level: " + creature.getLevel());
            }
        }

    }

    

   

    


    
}