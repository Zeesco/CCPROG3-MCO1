import java.util.Scanner;

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
            System.out.println("Creature successfully created !");
            System.out.println();
        }
       

        Player p1 = new Player(new Inventory(starterCreature));
        p1.addToInventory(starterCreature);
        p1.addToInventory(new ActiveCreature("JONARD", "HELLO", 'h'));
        p1.addToInventory(new ActiveCreature("YES", "HELLO", 'h'));
        

        while (true) {
            displayMainMenu();

            choice = 0;
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                while (true) {
                    System.out.println("View Inventory");
                    while (true) {
                        p1.getInventory().displayCreatures();
                        System.out.println(
                                "If you want to change your creature you have to type its name. If not type [N]");
                        System.out.print("Input:");
                        back = sc.nextLine().toUpperCase();
                        System.out.println(back);

                        if (p1.getInventory().isCreatureInsideInventory(back)) {
                            System.out.println("The creature is inside the inventory");
                            p1.getInventory().replaceCreature(back);
                        } else {
                            System.out.println("The creature is not inside the inventory");
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
                System.out.println("Explore An Area");
                while (true) {
                    displayAreas();
                    choice = sc.nextInt();
                    sc.nextLine();
                    if (choice == 1) {

                        while (true) {

                            Area areaOne = new Area(p1);
                        
                            System.out.println("Area One ");
                            areaOne.displayAreas();
                            System.out.println();
                            System.out.println("Type [E] to escape");
                            System.out.print("Input: ");
                            direction = sc.nextLine().toUpperCase();
                            if (areaOne.isEncounterCreature() == true) {
                                System.out.println("You have encountered a creature !");
                                
                                int ctr = 0;
                                while (true) {
                                    areaOne.displayEnemyCreature();
                                    System.out.println("[1] Attack the Creature");
                                    System.out.println("[2] Swap an Active Creature");
                                    System.out.println("[3] Catch the Creature");
                                    System.out.println("[4] Run Away");
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
                                                System.out.println("You only have one pokemon in the inventory !");
                                                break;
                                            }
                                            p1.getInventory().displayCreatures();
                                            System.out.println("If you want to change your creature you have to type its name. If not type [N]");
                                            System.out.print("Input:");
                                            back = sc.nextLine().toUpperCase();

                                            if (p1.getInventory().isCreatureInsideInventory(back)) {
                                                System.out.println("The creature is inside the inventory");
                                                p1.getInventory().replaceCreature(back);
                                            } else {
                                                System.out.println("The creature is not inside the inventory");
                                            }
                                            if (back.equals("N")) {
                                                break;
                                            }
                                        }
                                    } else if (choice == 3) {
                                        System.out.println("Catch a creature !");
                                        if(p1.isCatchCreature(areaOne.getEnemyCreature())){
                                            System.out.println("You caught a creature!");
                                            p1.catchCreature(new ActiveCreature(areaOne.getEnemyCreature().getName(), areaOne.getEnemyCreature().getType(), areaOne.getEnemyCreature().getFamily()));
                                            break;
                                        }
                                       
                                    } else if (choice == 4) {
                                        System.out.println("user running away");
                                        break;
                                    }else{
                                        System.out.println("Invalid Output !");
                                    }

                                    if (ctr == 2) {
                                        System.out.println("enemy creature ran away!");
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

                    } else if (choice == 3) {

                    } else if (choice == 4) {
                        break;
                    }

                }

            } else if (choice == 3) {
                System.out.println("Evolve A Creature");
            } else if (choice == 4) {
                System.out.println("Thank you for playing the game!");
                break;
            } else {
                System.out.println("Wrong Input Try Again !");
            }
        }

        sc.close();
    }

    private static void movePlayer(String direction, Area areaOne, Player p1) {
        if (direction.equals("L")) {
            System.out.println("The user went left");
            p1.moveLeft();
        } else if (direction.equals("R")) {
            System.out.println("The  user went right");
            p1.moveRight(areaOne);
        } else if (!direction.equals("E")) {
            System.out.println("Invalid Input");
        }
    }

    private static void displayAreas() {
        System.out.println("[1] Area One");
        System.out.println("[2] Area Two");
        System.out.println("[3] Area Three");
        System.out.println("[4] Exit ");
        System.out.print("Input: ");
    }

    private static void displayType() {
        System.out.println("What type of pokemon would you like?");
        System.out.println(" * Fire ");
        System.out.println(" * Water ");
        System.out.println(" * Leaf ");
        System.out.print("Input: ");
    }

    private static void displayName(String type) {

        System.out.println("Choose a Pokemon ! ");
        if (type.equals("FIRE")) {
            System.out.println("Fire type Pokemons");
            System.out.println("-> STRAWMANDER <-");
            System.out.println("-> CHOCOWOOL <-");
            System.out.println("-> PARFWIT <-");
            System.out.print("Input: ");
        } else if (type.equals("WATER")) {
            System.out.println("Water type Pokemons");
            System.out.println("-> SQUIRPIE <-");
            System.out.println("-> CHOCOLITE <-");
            System.out.println("-> OSHACONE <-");
            System.out.print("Input: ");
        } else {
            System.out.println("Leaf type Pokemons");
            System.out.println("-> BROWNISAUR <-");
            System.out.println("-> FRUBAT <-");
            System.out.println("-> MALTS <-");
            System.out.print("Input: ");

        }
    }

    private static void displayMainMenu() {
        System.out.println("POKEMON GAME");
        System.out.println("[1] View Inventory");
        System.out.println("[2] Explore an Area");
        System.out.println("[3] Evolve a Creature");
        System.out.println("[4] Exit");
        System.out.print("Input: ");
    }
}
