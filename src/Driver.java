import java.util.Scanner;

/**
 * Welcome to the Pokémon Adventure Game!
 * 
 * Embark on an exciting journey in a world filled with unique creatures known as Pokémon. 
 * 
 * Explore different areas, challenge other creatures, and engage in epic battles to prove your skills.
 * 
 * Get ready to catch 'em all, discover legendary Pokémon!
 */

public class Driver {

    /**
     * The main entry point for the program. This method initializes the game,
     * processes user input, and controls the game flow. It starts with the
     * selection of a starter creature and handles the main menu options.
     *
     * @param args The command-line arguments (not used in this program).
     * @author Sheenery Ashley L. Abendan
     * @author Francisco Butiong
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ActiveCreature starterCreature = new ActiveCreature(null, null, 'n');
        int choice = 0;
        String type = "null", name = "null", back = "null", direction = "null";

        /**
         * Allows the user to choose the type and name of the starter creature for
         * the game. It prompts the user to input the creature's type and name,
         * validates the input, and sets the creature's family. If a starter creature
         * is successfully created, a success message is displayed.
         *
         * @param sc              The Scanner object for user input.
         * @param starterCreature The starter creature to be configured.
         * 
         */
        do {
            displayType();
            type = sc.nextLine().toUpperCase();
            starterCreature.setType(type);
        } while (starterCreature.isType(type) == true);

        do {
            displayName(type);
            name = sc.nextLine().toUpperCase();
            starterCreature.setName(name);
        } while (starterCreature.isName(name) == true);
        starterCreature.setFamily(name, type);
        if (starterCreature != null) {
            System.out.println("\n\nCreature successfully created !");
            System.out.println();
        }

        /**
        * Creates a new player instance (p1) and initializes their inventory with the starter creature.
        *
        * @param starterCreature The starter creature used to initialize the player's inventory.
        */
       

        Player p1 = new Player(new Inventory(starterCreature));
        p1.addToInventory(starterCreature);
        

        while (true) {
            displayMainMenu();

            choice = 0;
            choice = sc.nextInt();
            sc.nextLine();

        /**
         * This block of code represents the main logic of the Pokémon Adventure Game.
         * It contains various game options, including viewing the player's inventory, exploring different areas,
         * evolving creatures, and exiting the game.
         *
         * The player's actions are processed, including encounters with creatures, battles, and creature evolution.
         * The player's choices are continually checked and processed until the player decides to exit the game.
         *
         * @param choice The user's input choice, determining the course of action in the game.
         * @param sc     The Scanner object used for user input.
         * @param p1     The player object representing the game character.
         */

            if (choice == 1) {
                while (true) {
                    System.out.println("\n\n[1]View Inventory");
                    while (true) {
                        p1.getInventory().displayCreatures();
                        System.out.println(
                                "\n\nIf you want to change your creature you have to type its name. If not type [N]");
                        System.out.print("Input:");
                        back = sc.nextLine().toUpperCase();
                        System.out.println(back);

                        if (p1.getInventory().isCreatureInsideInventory(back)) {
                            System.out.println("\n\nThe creature is inside the inventory");
                            p1.getInventory().replaceCreature(back);
                        } else {
                            System.out.println("\n\nThe creature is not inside the inventory");
                        }

                        if (back.equals("N")) {
                            break;
                        }
                    }

                    if (choice == 1) {
                        break;
                    }
                }
            } else if (choice == 2) {
                System.out.println("\n\n[2] Explore An Area");
                while (true) {
                    displayAreas();
                    choice = sc.nextInt();
                    sc.nextLine();
                    if (choice == 1) {

                       
                        p1.resetPosition();
                        while (true) {

                            Area areaOne = new Area(p1);
                            
                            System.out.println("Area One ");
                            areaOne.displayAreas();
                            System.out.println();
                            System.out.println("\nType [E] to escape");
                            System.out.print("Input: ");
                            direction = sc.nextLine().toUpperCase();
                            if (areaOne.isEncounterCreature() == true) {
                                System.out.println("\n\nYou have encountered a creature !");
                                
                                int ctr = 0;
                                while (true) {
                                    areaOne.displayEnemyCreature();
                                    System.out.println("--------------------");
                                    System.out.println("[1] Attack the Creature");
                                    System.out.println("[2] Swap an Active Creature");
                                    System.out.println("[3] Catch the Creature");
                                    System.out.println("[4] Run Away");
                                    System.out.println("--------------------");
                                    System.out.print("Input: ");
                                    choice = sc.nextInt();
                                    sc.nextLine();

                                    if (choice == 1) {
                                        System.out.print(p1.getInventory().getActiveCreature().getName());
                                        System.out.print(" attacked -> ");
                                        areaOne.setActiveCreatureDamage(p1.getInventory().getActiveCreature().getAttackDamage() );
                                        areaOne.enemyAttacked(areaOne.getActiveCreatureDamage());    
                                        System.out.print(" and dealt : "+ areaOne.getActiveCreatureDamage());
                                        
        
                                    } else if (choice == 2) {
                                        while (true) {
                                            if(p1.isSwap() == true){
                                                System.out.println("\nYou only have one pokemon in the inventory !");
                                                break;
                                            }
                                            p1.getInventory().displayCreatures();
                                            System.out.println("\nIf you want to change your creature you have to type its name. If not type [N]");
                                            System.out.print("Input:");
                                            back = sc.nextLine().toUpperCase();

                                            if (p1.getInventory().isCreatureInsideInventory(back)) {
                                                System.out.println("\nThe creature is inside the inventory");
                                                p1.getInventory().replaceCreature(back);
                                            } else {
                                                System.out.println("\nThe creature is not inside the inventory");
                                            }
                                            if (back.equals("N")) {
                                                break;
                                            }
                                        }
                                    } else if (choice == 3) {
                                        System.out.println("\nCatch a creature !");
                                        if(p1.isCatchCreature(areaOne.getEnemyCreature())){
                                            System.out.println("\nYou caught a creature!");
                                            p1.catchCreature(new ActiveCreature(areaOne.getEnemyCreature().getName(), areaOne.getEnemyCreature().getType(), areaOne.getEnemyCreature().getFamily()));
                                            break;
                                        }
                                       
                                    } else if (choice == 4) {
                                        System.out.println("\nuser running away");
                                        break;
                                    }else{
                                        System.out.println("\nInvalid Output !");
                                    }

                                    if (ctr == 2) {
                                        System.out.println("\nenemy creature ran away!");
                                        break;
                                    }
                                    ctr++;
                                }

                            }
                            movePlayer(direction, areaOne, p1);
                            if (direction.equals("E")) {
                                break;
                            }

                        }
                    } else if (choice == 2) {
                        AreaTwo areaTwo = new AreaTwo(p1);
                        p1.resetPosition();
                        p1.resetPositionY();

                        while (true){
                        
                        areaTwo.displayAreaTwo();
                        System.out.println();
                        System.out.println("Type [E] to escape");
                        System.out.print("Input: ");
                        direction = sc.nextLine().toUpperCase();
                         if (direction.equals("L")) {
                            System.out.println("The user went left");
                                p1.moveLeft();
                        } else if (direction.equals("R")) {
                                System.out.println("The  user went right");
                                    p1.moveRight(areaTwo.getAreaTwoSize());
                        } else if (direction.equals("U")) {
                            System.out.println("user moved up");
                            p1.moveUp();
            
                         }else if (direction.equals("D")) {
                            System.out.println("user moved down");
                            p1.moveDown(areaTwo.getAreaTwoSize());
                         }else if (direction.equals("E")){
                            break;
                         }else{
                            System.out.println("invalid output");
                         }
                    }

                    } else if (choice == 3) {
                        AreaThree areaThree = new AreaThree(p1);
                        p1.resetPosition();
                        p1.resetPositionY();

                        while (true){
                        
                        areaThree.displayAreaTwo();
                        System.out.println();
                        System.out.println("Type [E] to escape");
                        System.out.print("Input: ");
                        direction = sc.nextLine().toUpperCase();
                         if (direction.equals("L")) {
                            System.out.println("The user went left");
                                p1.moveLeft();
                        } else if (direction.equals("R")) {
                                System.out.println("The  user went right");
                                    p1.moveRight(areaThree.getAreaThreeSize());
                        } else if (direction.equals("U")) {
                            System.out.println("user moved up");
                            p1.moveUp();
            
                         }else if (direction.equals("D")) {
                            System.out.println("user moved down");
                            p1.moveDown(areaThree.getAreaThreeSize());
                         }else if (direction.equals("E")){
                            break;
                         }else{
                            System.out.println("invalid output");
                         }
                        }


                    } else if (choice == 4) {
                        break;
                    }

                }

            } else if (choice == 3) {
                System.out.println("\n\n[3] Evolve A Creature");
                Inventory creatureInventory = p1.getInventory();
                creatureInventory.displayCreatures();
                System.out.print("\n\nInput Creature 1 name: ");
                String creature1Name = sc.nextLine();
                System.out.print("Input Creature 2 name: ");
                String creature2Name = sc.nextLine();

                Creatures creature1 = creatureInventory.getCreatureByName(creature1Name);
                Creatures creature2 = creatureInventory.getCreatureByName(creature2Name);

                if (creature1 != null && creature2 != null) {
                    Evolution evolution = new Evolution(creatureInventory);
                    EvolutionResult result = evolution.evolveCreatures(creature1, creature2);

                    if (result.isSuccess()) {
                        System.out.println("\n\nEvolution was successful. Evolved creature: " + result.getEvolvedCreature().getName());
                    } else {
                        System.out.println("\n\nEvolution failed.");
                    }
                } else {
                    System.out.println("\n\nOne or both of the specified creatures were not found in the inventory.");
                }



            } else if (choice == 4) {
                System.out.println("\n\nThank you for playing the game!");
                break;
            } else {
                System.out.println("\n\nWrong Input Try Again !");
            }
        }

        sc.close();
    }

    private static void movePlayer(String direction, Area areaOne, Player p1) {
        if (direction.equals("L")) {
            System.out.println("\n\nThe user went left");
            p1.moveLeft();
        } else if (direction.equals("R")) {
            System.out.println("\n\nThe  user went right");
            p1.moveRight(areaOne.getSizeArea());
        } else if (!direction.equals("E")) {
            System.out.println("\n\nInvalid Input");
        }
    }

    private static void displayAreas() {
        System.out.println("--------------------");
        System.out.println("[1] Area One");
        System.out.println("[2] Area Two");
        System.out.println("[3] Area Three");
        System.out.println("[4] Exit ");
        System.out.println("--------------------");
        System.out.print("Input: ");
    }

    private static void displayType() {
        System.out.println("What type of pokemon would you like?");
        System.out.println("--------------------");
        System.out.println(" * Fire ");
        System.out.println(" * Water ");
        System.out.println(" * Leaf ");
        System.out.println("--------------------");
        System.out.print("Input: ");
    }

    private static void displayName(String type) {

        System.out.println("\n\nChoose a Pokemon ! ");
        if (type.equals("FIRE")) {
            System.out.println("\n\nFire type Pokemons");
            System.out.println("--------------------");
            System.out.println("-> STRAWMANDER <-");
            System.out.println("-> CHOCOWOOL <-");
            System.out.println("-> PARFWIT <-");
            System.out.println("--------------------");
            System.out.print("Input: ");
        } else if (type.equals("WATER")) {
            System.out.println("\n\nWater type Pokemons");
            System.out.println("--------------------");
            System.out.println("-> SQUIRPIE <-");
            System.out.println("-> CHOCOLITE <-");
            System.out.println("-> OSHACONE <-");
            System.out.println("--------------------");
            System.out.print("Input: ");
        } else {
            System.out.println("\n\nLeaf type Pokemons");
            System.out.println("--------------------");
            System.out.println("-> BROWNISAUR <-");
            System.out.println("-> FRUBAT <-");
            System.out.println("-> MALTS <-");
            System.out.println("--------------------");
            System.out.print("Input: ");

        }
    }

    private static void displayMainMenu() {
        System.out.println("\n\nPOKEMON GAME");
        System.out.println("--------------------");
        System.out.println("[1] View Inventory");
        System.out.println("[2] Explore an Area");
        System.out.println("[3] Evolve a Creature");
        System.out.println("[4] Exit");
        System.out.println("--------------------");
        System.out.print("Input: ");
    }
}
