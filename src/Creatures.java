


public class Creatures {
    private String type;
    private String name;
    private String family;
    private int level;
    
    

    public Creatures(int level){
        this.level = level;
    }

     public Creatures(int level,String name, String type, String family){
        this.level = level;
    }
    

   
   public void setType(String type) {
       this.type = type;
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
}
