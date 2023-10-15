public class ActiveCreature  extends Creatures{
    
    private double attackDamage;

        ActiveCreature(String name, String type, char family){
            super(name, type, family);
            this.attackDamage = 100.0;
        }

        public double getAttackDamage() {
            return attackDamage;
        }
}
