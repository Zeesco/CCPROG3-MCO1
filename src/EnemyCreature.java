public class EnemyCreature  extends Creatures{
    
    private double health;
    

        EnemyCreature(String name, String type, char family,double health){
            super(name, type, family);
            this.health = 100.0;
        }

        public double getHealth() {
            return health;
        }
}
