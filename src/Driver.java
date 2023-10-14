
import java.util.Scanner;

/**
 * Issues in the code:
 * 1. do while loop when choosing the pokemons are fucked
 * 2. Scanner not closed and I dont know how to close it
 */

public class Driver {
    public static void main(String[] args)  {
       

/**
 * This class demonstrates a simple game setup that involves user input and player creation.
 * It initializes a Scanner for user input, creates a starter creature, and a player character.
 * Additionally, it initializes variables for type, name, back, and menu options.
 */

      Scanner sc = new Scanner(System.in);
      Creatures starterCreature = new Creatures(1);
      Player player = new Player(starterCreature);
      String type ="null", name = "null"; 
      String back = "null"; 
      int menu = 0;
      
/**
 * Asks the user to input their chosen type of pokemon.
 * Do while serves as error-handling when the users input is invalid.
 */
        do{
            System.out.println("What type of pokemon would you like?");
            System.out.println(" * Fire ");
            System.out.println(" * Water ");
            System.out.println(" * Leaf ");
            System.out.print("Input: ");
            type = sc.nextLine();
            type = type.toUpperCase();
            starterCreature.setType(type);
            if(starterCreature.isType(type) == true )
            {
                System.out.println("Invalid type ! Please try again.");
            }
        }while(starterCreature.isType(type));
/**
 * Displays the pokemons from the chosen type inputted by the user.
 * Asks the user to input the chosen pokemon.
 * Do while serves as error-handling when the users input is invalid.
 */
        do {
            starterCreature.displayPokemons(type);
            System.out.print("Input:");
            name = sc.nextLine();
            starterCreature.setName(name);
            if(starterCreature.isName(type,name.toUpperCase()))
            {
                System.out.println("Invalid name ! Please try again.");
            }

        } while (starterCreature.isName(type,name.toUpperCase()));
        player.setActiveCreature(starterCreature);
        player.addCreatureToInventory(starterCreature);

        
        do {
            int choice = 0;
            int posX = 0, posY = 0;
            System.out.println("POKEMON GAME");
            System.out.println("[1] View Inventory");
            System.out.println("[2] Explore an Area");
            System.out.println("[3] Evolve a Creature");
            System.out.println("[4] Exit"); 

            if(sc.hasNextInt()) {
                menu = sc.nextInt();
                sc.nextLine(); 
                if(menu >= 1 && menu <=4) {
                    if(menu == 1){
                        while (true){
                            System.out.println("User's Inventory...");
                            player.getInventory().displayCreatures();
                            break;
                        }

                    }else if(menu == 2){
                        while (true){
                            System.out.println("Explore An Area");
                            System.out.println("Choose an Area !");

                            
                            System.out.println("[1] Area One");
                            System.out.println("[2] Area Two");
                            System.out.println("[3] Area Three");
                            System.out.println("[4] Main menu");

                            
                            System.out.print("Input:");
                            choice = sc.nextInt();

                            if (choice == 1){
                                Area areaOne = new Area(player);
                                while(true){
                                
                                    areaOne.displayAreaOne(posX);
                                    System.out.println("X:");
                                    System.out.println("Type [-1] to go back");
                                    posX = sc.nextInt();
                                        if(posX == -1){
                                            break;
                                        }
                                
                                }

                            }else if(choice == 2){
                                Area areaTwo = new Area(player);
                                areaTwo.displayAreaTwo(posX,posY);
                            }else if (choice == 3){
                                Area areaThree = new Area (player);
                                areaThree.displayAreaThree(posX, posY);
                            }else if(choice == 4){
                                break;
                            }else{
                                System.out.println("Invalid choice!");
                            }
                         
                        }

                    }else if(menu == 3) {
                        while (true) {
                            System.out.println("Evolve a Creature");
                            System.out.println("Input [B] to go back to the main menu.");
                            System.out.print("Input: ");
                            back = sc.nextLine();
                            
                            

                            if (back.equalsIgnoreCase("B")) {
                                System.out.println("Going back to the main menu.");
                                break;  

                            } else {
                                System.out.println("Invalid input. Please try again.");
                                
                            } 
                        }

                    }else {
                        System.out.println("Exiting....Thank you for playing the game!");
                        System.exit(0);
                    }
                }else {
                    System.out.println("You can only input values (1-4) only.");
                }

            }else {
                System.out.println("Invalid input try again !");
            }

     
        }while(true);



    
    }
}