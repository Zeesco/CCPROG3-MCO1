/**
 * The Evolution class handles the evolution of creatures in the game. It checks the eligibility of creatures for evolution
 * and generates evolved creatures, updating the player's inventory accordingly.
 */

public class Evolution {

   private Inventory creatureInventory;

    /**
    * Constructs an Evolution instance with the provided creature inventory.
    *
    * @param creatureInventory The inventory where creatures are stored and managed.
    */

   public Evolution(Inventory creatureInventory) {
       this.creatureInventory = creatureInventory;
   }

   /**
    * Attempts to evolve two creatures. If eligible, it calculates the evolved creature's name and properties,
    * updates the inventory, and returns the result of the evolution.
    *
    * @param creature1 The first creature to evolve.
    * @param creature2 The second creature to evolve.
    * @return An EvolutionResult object containing the result of the evolution attempt.
    */

   public EvolutionResult evolveCreatures(Creatures creature1, Creatures creature2) {
       if (isEligibleForEvolution(creature1, creature2)) {
           String name = calculateEvolvedName(creature1);
           Creatures evolvedCreature = new Creatures(name, creature1.getType(), creature1.getFamily(), creature1.getLevel() + 1);

           creatureInventory.deleteCreature(creature1);
           creatureInventory.deleteCreature(creature2);
           creatureInventory.addInventory(evolvedCreature);

           return new EvolutionResult(true, evolvedCreature);
       } else {
           return new EvolutionResult(false, null);
       }
   }

   /**
    * Checks if two creatures are eligible for evolution based on their properties such as level and family.
    *
    * @param creature1 The first creature to evolve.
    * @param creature2 The second creature to evolve.
    * @return true if the creatures are eligible for evolution, false otherwise.
    */

   private boolean isEligibleForEvolution(Creatures creature1, Creatures creature2) {
       return creature1.getLevel() == creature2.getLevel() &&
              creature1.getFamily() == creature2.getFamily() &&
              creature1.getLevel() < 3 &&
              creature2.getLevel() < 3;
   }

   /**
    * Calculates the name of the evolved creature based on the type, family, and level of the creature.
    *
    * @param creature The creature to be evolved.
    * @return The name of the evolved creature, or null if the evolution is not possible.
    */
    
   private String calculateEvolvedName(Creatures creature) {
       String type = creature.getType();
       char family = creature.getFamily();
       int level = creature.getLevel() + 1;

       if (family == 'A') {
         if (type.equals("FIRE")) {
             if (level == 2) {
                 return "STRAWLEON";
             } else {
                 return "STRAWIZARD";
             }
         }
     } else if (family == 'B') {
         if (type.equals("FIRE")) {
             if (level == 2) {
                 return "CHOCOFLUFF";
             } else {
                 return "CANDROS";
             }
         }
     } else if (family == 'C') {
         if (type.equals("FIRE")) {
             if (level == 2) {
                 return "PARFURE";
             } else {
                 return "PARFELURE";
             }
         }
     } else if (family == 'D') {
         if (type.equals("LEAF")) {
             if (level == 2) {
                 return "CHOCOSAUR";
             } else {
                 return "FUDGASAUR";
             }
         }
     } else if (family == 'E') {
         if (type.equals("LEAF")) {
             if (level == 2) {
                 return "GOLBERRY";
             } else {
                 return "CROBERRY";
             }
         }
     } else if (family == 'F') {
         if (type.equals("LEAF")) {
             if (level == 2) {
                 return "KIRLICAKE";
             } else {
                 return "VELVEVOIR";
             }
         }
     } else if (family == 'G') {
         if (type.equals("WATER")) {
             if (level == 2) {
                 return "TARTORTLE";
             } else {
                 return "PIESTOISE";
             }
         }
     } else if (family == 'H') {
         if (type.equals("WATER")) {
             if (level == 2) {
                 return "CHOCOLISH";
             } else {
                 return "ICESUNDAE";
             }
         }
     } else if (family == 'I') {
         if (type.equals("WATER")) {
             if (level == 2) {
                 return "DEWICE";
             } else {
                 return "SAMURCONE";
             }
         }
     }
 
     return null;
   }

}
