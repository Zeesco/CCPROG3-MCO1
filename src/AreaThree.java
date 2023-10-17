public class AreaThree extends Area{
    private int areaThree[][];
    private Player player;

    AreaThree(Player player){
        super(player);
        this.player = player;
        areaThree = new int [4][4];
    }


    public void displayAreaTwo() {
        for (int i = 0; i < areaThree.length; i++) {
            for (int j = 0; j < areaThree[i].length; j++) {
                if(player.getPosition() == j && player.getPositionY() == i){
                    System.out.print("[U]");
                }else{
                    System.out.print("[ ] ");
                }
                
            }
            System.out.println();
        }
    }
    

    public int getAreaThreeSize() {
        return areaThree.length;
    }
}
