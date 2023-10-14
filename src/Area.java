public class Area {
    private Player player;
    private int areaOne[];
    private int areaTwo[][];
    private int areaThree[][];





    public Area(Player player){
        this.player = player;
        this.areaOne = new int[5];
        this.areaTwo = new int[3][3];
        this.areaThree = new int[4][4];
    
    }

    public boolean isArea(int choice){
        if(choice == 1){
            return false;
        }else if(choice == 2){
            return false;
        }else if(choice == 3){
            return false;
        }

        return true;
    }

    public void displayAreaOne(int x){
        for (int i = 0 ; i < 5; i ++)
        {
            if(i == x + 1){
            System.out.print("["+ areaOne[x]);
                System.out.print("]");
            }else{
                System.out.print("[]");
            }
        }
    }

    public void displayAreaTwo(int x, int y){
        for (int i = 0 ; i < 3; i ++) {
            for (int j = 0 ;  j < 3; j++ ){
                 System.out.print("[]");
            }
            System.out.println();
        }
    }

    public void displayAreaThree(int x, int y){
        for (int i = 0 ; i < 4; i ++) {
            for (int j = 0 ;  j < 4; j++ ){
                System.out.print("["+areaThree[x][y]);
                System.out.print("]");
            }
            System.out.println();
        }
    }

    


    
    


    
}
