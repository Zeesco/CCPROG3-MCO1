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
  
public void replaceCreature(String name) {
    
    
    for (Creatures creature : creature) {
        if (creature.getName().equals(name) && creature instanceof ActiveCreature) {
            // Remove the current active creature from the inventory
            

            // Set the new active creature
            this.activeCreature = (ActiveCreature) creature;

            // Add the new active creature back to the inventory
           

            System.out.println();
            System.out.println("Successfully swapped");
            break;
        }
    }
}



/**
* Deletes  the  creature with another creature from the inventory with the specified name.
*
* @param name The name of the creature to be set as the active creature.
*/
  public void deleteCreature(Creatures name){
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
 * Retrieves a creature from the inventory by its name.
 *
 * @param name The name of the creature to retrieve.
 * @return The Creatures object with the specified name, or null if not found.
 */

  public Creatures getCreatureByName(String name) {
    for (Creatures creature : creature) {
        if (creature.getName().equals(name)) {
            return creature;
        }
    }
    return null;
  }

/**
* Displays information about active and caught creatures in the inventory.
* This method prints details about the currently active creature and all other caught creatures,
* including their type, name, and level.
*/
  
    public void displayCreatures(){
    System.out.println("\n\nACTIVE CREATURE");
    System.out.println("--------------------");
    System.out.println("Type: " + activeCreature.getType() + "\nFamily: "+ activeCreature.getFamily() + "\nName: " +  activeCreature.getName() + "\nLevel: " + activeCreature.getLevel());
    System.out.println("--------------------");

    System.out.println("\n\nCAUGHT CREATURES");
      for(Creatures creature : creature){
        if(!creature.equals(activeCreature)){
          System.out.println("--------------------");
          System.out.println("Type: " + creature.getType() + "\nName: " + creature.getName() + "\nLevel: " +  creature.getLevel());
          System.out.println("--------------------");
        }
      }
    }

    public int getNumberOfCreatures() {
        return creature.size();
    }
  }  