public class EvolutionResult {
    /**
     * This class represents the result of a creature evolution attempt.
     * Contains information about whether the evolution was successful and the resulting evolved creature, if successful.
     */
    
        private boolean success;
        private Creatures evolvedCreature;
    
    /**
     * Constructs a new object with the specified success status and evolved creature.
     *
     * @param success         A boolean indicating whether the evolution was successful (true) or failed (false).
     * @param evolvedCreature The evolved creature resulting from the evolution, or null if the evolution failed.
     */
    
        public EvolutionResult(boolean success, Creatures evolvedCreature) {
            this.success = success;
            this.evolvedCreature = evolvedCreature;
        }
    
    /**
     * Checks if the evolution process was successful.
     *
     * @return true if the evolution was successful, false if it failed.
     */
    
        public boolean isSuccess() {
            return success;
        }
    
    /**
     * Retrieves the evolved creature after the evolution process.
     *
     * @return The evolved creature, or null if the evolution was not successful.
     */
    
        public Creatures getEvolvedCreature(){
            return evolvedCreature;
        }
    }
    