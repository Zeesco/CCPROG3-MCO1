public class AreaTwo extends Area{

    private int areaTwo[][];
    private Player player;

    AreaTwo(Player player){
        super(player);
        this.player = player;
        areaTwo = new int [3][3];
    }


    public void displayAreaTwo() {
        for (int i = 0; i < areaTwo.length; i++) {
            for (int j = 0; j < areaTwo[i].length; j++) {
                if(player.getPosition() == j && player.getPositionY() == i){
                    System.out.print("[U]");
                }else{
                    System.out.print("[ ] ");
                }
                
            }
            System.out.println();
        }
    }
    

    public int getAreaTwoSize() {
        return areaTwo.length;
    }
}