

  public class Creatures {

   /**
   * This class represents the key attributes of a creature, 
   * including its name, type, family, and evolution level.
   */
     
       private String name;
       private String type;
       private char family;
       private int level;
   
   /**
   * Constructs a new creature with the specified name, type, and family.
   *
   * @param name   The name of the creature.
   * @param type   The type of the creature.
   * @param family The family of the creature.
   */
       
        public Creatures(String name, String type, char family) {
           this.level = 1;
           this.name = name;
           this.type = type;
           this.family = family;
        }
      
        /**
   * Constructs a new creature with the specified name, type, family, and level.
   *
   * @param name The name of the creature.
   * @param type The type of the creature.
   * @param family The family (character) of the creature.
   * @param level The level of the creature.
   */

public Creatures(String name, String type, char family, int level) {
   this.level = level;
   this.name = name;
   this.type = type;
   this.family = family;
}
   /**
   * Sets the type of the creature.
   *
   * @param type The new type to assign to the creature.
   */
       
        public void setType(String type) {
           this.type = type;
        }
   
   /**
   * Checks if the given type is valid for the creature.
   *
   * @param type The type to check.
   * @return true if the type is valid, false if it's not valid.
   */
   
        public boolean isType(String type) {
           if (type.equals("FIRE")) {
              return false;
   
           } else if (type.equals("WATER")) {
              return false;
           } else if (type.equals("LEAF")) {
              return false;
           } else {
              return true;
           }
        }
   
   /**
   * Sets the name of the creature.
   *
   * @param name The new name to assign to the creature.
   */
       
        public void setName(String name) {
           this.name = name;
        }
   
   /**
   * Checks if the given name is valid for the creature based on its type.
   *
   * @param name The name to check.
   * @return true if the name is valid for the creature's type, false if it's not valid.
   */
       
        public boolean isName(String name) {
           if (type.equals("FIRE")) {
              if (name.equals("STRAWMANDER")) {
                 return false;
              } else if (name.equals("CHOCOWOOL"))
   
              {
                 return false;
              } else if (name.equals("PARFWIT")) {
                 return false;
              }
           } else if (type.equals("WATER")) {
              if (name.equals("SQUIRPIE")) {
                 return false;
              } else if (name.equals("CHOCOLITE")) {
                 return false;
              } else if (name.equals("OSHACONE")) {
                 return false;
              }
           } else if (type.equals("LEAF")) {
              if (name.equals("BROWNISAUR")) {
                 return false;
              } else if (name.equals("FRUBAT")) {
                 return false;
              } else if (name.equals("MALTS")) {
                 return false;
              }
           }
           return true;
        }
   
   /**
   * Sets the family of the creature based on its name and type.
   *
   * @param name The name of the creature.
   * @param type The type of the creature.
   */
       
        public void setFamily(String name,String type) {
             if (type.equals("FIRE")) {
                 if (name.equals("STRAWMANDER")) {
                     family = 'A';
   
                 } else if (name.equals("CHOCOWOOL")){
                     family = 'B';        
   
                 } else if (name.equals("PARFWIT")){
                     family = 'C';
   
                 }
   
           } else if (type.equals("WATER")) {
              if (name.equals("SQUIRPIE")) {
                     family = 'D';
              } else if (name.equals("CHOCOLITE")) {
                      family = 'E';
              } else if (name.equals("OSHACONE")) {
                      family = 'F';
              }
           } else if (type.equals("LEAF")) {
              if (name.equals("BROWNISAUR")) {
                     family = 'G';
              } else if (name.equals("FRUBAT")) {
                     family = 'H';
              } else if (name.equals("MALTS")) {
                     family = 'I';
   
              }
           }
   
        }
       
   /**
   * Retrieves the name of the creature.
   *
   * @return The name of the creature.
   */
       
       public String getName() {
            return name;
        }
     
   /**
   * Retrieves the type of the creature.
   *
   * @return The type of the creature.
   */
       
       public String getType() {
            return type;
        }
   
   /**
   * Retrieves the family of the creature.
   *
   * @return The family of the creature as a character.
   */
       
        public char getFamily() {
            return family;
        }
   
   /**
   * Retrieves the evolution level (EL) of the creature.
   *
   * @return The evolution level of the creature as an integer.
   */
   
       public int getLevel() {
            return level;
        }
   
     }
   