import java.util.ArrayList;

public class Inventory{
  
/**
* This class maintains a list of creatures and tracks the active creature.
* The list of creatures is stored in an ArrayList of Creatures, and the active creature
* is represented by an instance of the ActiveCreature class.
*/
  
    private ArrayList <Creatures> creature;
    private ActiveCreature activeCreature;

  

/**
* Constructs an Inventory with the given active creature.
*
* @param activeCreature The active creature that the inventory is associated with.
* 
The active creature is the one used for various in-game actions.
*/
  
    public Inventory (ActiveCreature activeCreature){
        this.creature = new ArrayList<>();
        this.activeCreature = activeCreature;
    }
  
/**
* Adds a creature to the inventory.
*
* @param creature The creature to be added to the inventory.
*/
  
    public void addInventory(Creatures creature){
        this.creature.add(creature);
    }
  
/**
* Sets the active creature in the inventory.
*
* @param activeCreature The active creature to be set as the active creature in the inventory.
*/
  
    public void setActiveCreature(Creatures creature) {
        this.activeCreature = (ActiveCreature) creature;
    }

/**
* Retrieves the currently active creature in the inventory.
*
* @return The active creature currently set in the inventory.
*/
  
  public ActiveCreature getActiveCreature() {
      return activeCreature;
  }

/**
* Checks if a creature with the specified name is inside the inventory.
*
* @param name The name of the creature to check for.
* @return true if a creature with the given name is found in the inventory, false otherwise.
*/
  
  public boolean isCreatureInsideInventory(String name){
      for(Creatures creature : creature){
          if(creature.getName().equals(name)){
              return true;
          }
      }
      return false;
  }

/**
* Replaces the active creature with another creature from the inventory with the specified name.
*
* @param name The name of the creature to be set as the active creature.
*/
  
public void replaceCreature(String name){
    for(Creatures creature : creature){
        if(creature.getName().equals(name) && creature instanceof ActiveCreature ){
            addInventory(activeCreature);
            activeCreature = (ActiveCreature) creature;//downcast
            System.out.println();
            System.out.println("Successfull swapped");
            break;
        }else{
            System.out.println("not successful bro");
        }
    }
}



/**
* Deletes  the  creature with another creature from the inventory with the specified name.
*
* @param name The name of the creature to be set as the active creature.
*/
  public void  deleteCreature(String name){
    Creatures deleteCreature = null;
      for(Creatures creature : creature){
          if(creature.getName().equals(name) && creature instanceof ActiveCreature ){
              deleteCreature  = creature;
              break;
          }
      }
      if(deleteCreature != null){
        creature.remove(deleteCreature);
      }
  }

  /**
* Verifies if  the user deletes the active creature this condition prohibits them from deleting the active creatur
*
* @param name The name of the creature to be set as the active creature.
*/

  public boolean isDeleteCreature(String name){

          if(activeCreature.getName().equals(name) ){
              return false;
          }
      return true;
    
  }




/**
* Displays information about active and caught creatures in the inventory.
* This method prints details about the currently active creature and all other caught creatures,
* including their type, name, and level.
*/
  
    public void displayCreatures(){
    System.out.println("Active Creature: ");
    System.out.println("Type: " + activeCreature.getType() + " Family: "+ activeCreature.getFamily() + ", Name: " +  activeCreature.getName() + ", Level: " + activeCreature.getLevel());

    System.out.println("Caught Creatures:");
      for(Creatures creature : creature){
        if(!creature.equals(activeCreature)){
          System.out.println("Type: " + creature.getType() + ", Name: " + creature.getName() + ", Level: " +  creature.getLevel());
        }
      }
    }

    public int getNumberOfCreatures() {
        return creature.size();
    }
  }  