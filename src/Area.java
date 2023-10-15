public class Area {
   private int moveLeft;
   private int moveRight;
   private int [] areaOne;
   private Player player;
   private static final int defaultSize = 5;
   private static final int defaulRight = 0;
   private static final int defaultLeft = 0;




    public Area(Player player){
        areaOne = new int [defaultSize];
        this.moveLeft = defaultLeft;
        this.moveRight = defaulRight;
        this.player = player;
    }
    
    public void displayAreaOne(){
        for(int i = 0 ; i < areaOne.length ; i++)
        {
            System.out.print("[] ");
        }
    }

    public int getMoveLeft() {
        return moveLeft--;
    }

    public int getMoveRight() {
        return moveRight++;
    }


    


    
    


    
}