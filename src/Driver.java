import java.util.Scanner;

public class Driver{

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        ActiveCreature starterCreature = new ActiveCreature( null, null,'n');
        int choice = 0;
        String type = "null", name = "null",back = "null";

        do{
            displayType();
            type = sc.nextLine().toUpperCase();
            starterCreature.setType(type);
        }while(starterCreature.isType(type) == true);

         do{
            displayName(type);
            name = sc.nextLine().toUpperCase();
            starterCreature.setName(name);
        }while(starterCreature.isName(name) == true);
        starterCreature.setFamily(name, type);
        if(starterCreature != null){
            System.out.println("Creature successfully created !");
            System.out.println();
        }

        Player p1 = new Player(new Inventory(starterCreature));
        p1.catchCreature(new ActiveCreature("JONARD","hello" , 'v'));

        while(true){
            displayMainMenu();
            choice = 0;
            choice = sc.nextInt();
            sc.nextLine();
            

            if(choice == 1){
    
                    while(true){
                        System.out.println("View Inventory");
                        System.out.println();
                        p1.getInventory().displayCreatures();
                        System.out.println();
                        
                        System.out.println("If you want to change your creature you have to type its name. If not type [N]");
                        System.out.print("Input: ");
                        back = sc.nextLine().toUpperCase();
                            
                            if(p1.getInventory().isCreatureInsideInventory(back)){
                                System.out.println("The creature is inside the inventory");
                                p1.getInventory().replaceCreature(back);
                            }else if (back.equals("N")){
                                break;
                            }else{
                                System.out.println("Invalid Creature Please Try Again!");
                            }
                        }
                
            }else if ( choice == 2){
                System.out.println("Explore An Area");
                    while(true){
                        displayArea();
                        choice = sc.nextInt();
                        if(choice == 1){
                            while(true){
                                choice = 0;
                                Area one = new Area(p1);  
                                one.displayAreaOne();
                                System.out.println();
                                System.out.print("Input: ");
                                choice = sc.nextInt();

                                if(choice == -1){
                                    break;
                                }
                            }

                        }else if(choice == 2){

                        }else if(choice == 3){

                        }else{
                            System.out.println("Invalid area!");
                        }

                    }
                
                
            }else if (choice == 3){
                System.out.println("Evolve A Creature");
            }else if (choice == 4){
                System.out.println("Thank you for playing the game!");
                break;
            }else{
                System.out.println("Wrong Input Try Again !");
            }
        }
        
        sc.close();
    }

    private static void displayWarningArea(){
        System.out.println("Input an array that is not out of bounds");
    }

    private static void displayArea(){
        System.out.println("Which area would you like to go? ");
        System.out.println("[1] Area 1 (Evolution 1 Pokemon are only allowed here !)");
        System.out.println("[2] Area 2 (Evolution 1 & 2 Pokemon are only allowed here !)");
        System.out.println("[3] Area 3 (Evolution 1-3 Pokemon are only allowed here !)");
        System.out.print("Input: ");
    }



    private static void displayType(){
        System.out.println("What type of pokemon would you like?");
            System.out.println(" * Fire ");
            System.out.println(" * Water ");
            System.out.println(" * Leaf ");
            System.out.print("Input: ");
    }
    private static void displayName(String type){

        System.out.println("Choose a Pokemon ! ");
        if(type.equals("FIRE")){
            System.out.println("Fire type Pokemons");
            System.out.println("-> STRAWMANDER <-");
            System.out.println("-> CHOCOWOOL <-");
            System.out.println("-> PARFWIT <-");
            System.out.print("Input: ");
        }else if(type.equals("WATER")){
            System.out.println("Water type Pokemons");
            System.out.println("-> SQUIRPIE <-");
            System.out.println("-> CHOCOLITE <-");
            System.out.println("-> OSHACONE <-");
            System.out.print("Input: ");
        }else{
            System.out.println("Leaf type Pokemons");
            System.out.println("-> BROWNISAUR <-");
            System.out.println("-> FRUBAT <-");
            System.out.println("-> MALTS <-");
            System.out.print("Input: ");

        }
    }

    private static void displayMainMenu(){
            System.out.println("POKEMON GAME");
            System.out.println("[1] View Inventory");
            System.out.println("[2] Explore an Area");
            System.out.println("[3] Evolve a Creature");
            System.out.println("[4] Exit"); 
            System.out.print("Input: ");
    }


}