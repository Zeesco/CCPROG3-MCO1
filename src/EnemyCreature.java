public class EnemyCreature  extends Creatures{
    
    private double health;
    private String name;
    private String type;
    private String family;
    private int level;
    
        EnemyCreature(int level,String name, String type, String family,double health){
            super(level,name, type, family);
            this.health = 100.0;
        }
}
