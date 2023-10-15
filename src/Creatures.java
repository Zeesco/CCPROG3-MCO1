

public class Creatures {
   private String type;
   private String name;
   private char family;
   private int level;

   public Creatures(String name, String type, char family) {
      this.level = 1;
      this.name = name;
      this.type = type;
      this.family = family;
   }

   public void setType(String type) {
      this.type = type;
   }

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

   public void setName(String name) {
      this.name = name;
   }

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

   public char getFamily() {
       return family;
   }

   public int getLevel() {
       return level;
   }

   public String getName() {
       return name;
   }

   public String getType() {
       return type;
   }

}
