


public class Creatures {
    private String type;
    private String name;
    private int level;
    
    

    public Creatures(int level){
        this.level = level;
    }

   

    public void setLevel(int level) {
        this.level = level;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public boolean isType(String type){
        if (type.equals("FIRE")){
            return false;
            
        }else if (type.equals("WATER")){ 
             return false;
        }else if (type.equals("LEAF")){
            
            return false;
        }else{
            return true;
        }
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }
    public void displayPokemons(String type){
        if(type.equals("FIRE")){
            System.out.println("Fire type Pokemons");
            System.out.println("-> STRAWMANDER <-");
            System.out.println("-> CHOCOWOOL <-");
            System.out.println("-> PARFWIT <-");
        }else if(type.equals("WATER")){
            System.out.println("Water type Pokemons");
            System.out.println("-> SQUIRPIE <-");
            System.out.println("-> CHOCOLITE <-");
            System.out.println("-> OSHACONE <-");
        }else{
            System.out.println("Leaf type Pokemons");
            System.out.println("-> BROWNISAUR <-");
            System.out.println("-> FRUBAT <-");
            System.out.println("-> MALTS <-");

        }
    }
    public String getName() {
        return name;
    }

    public boolean isName(String type,String name){
        if (type.equals("FIRE"))
        {
            if(name.equals("STRAWMANDER"))
            {
                return false;
            }else if(name.equals("CHOCOWOOL"))
            
            {
                return false;
            }else if(name.equals("PARFWIT"))
            {
                return false;
            }
        }else if(type.equals("WATER"))
        {
            if(name.equals("SQUIRPIE"))
            {
                return false;
             }else if(name.equals("CHOCOLITE"))
             {
               return false;
             }else if(name.equals("OSHACONE"))
             {
               return false;
             }
        }else if(type.equals("LEAF"))
        {
            if(name.equals("BROWNISAUR"))
            {
               return false;
             }else if(name.equals("FRUBAT"))
             {
               return false;
             }else if(name.equals("MALTS"))
             {
               return false;
             }
        }
        return true;
    }


    public int getLevel() {
        return level;
    }
    
   
}
