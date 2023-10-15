
import java.util.Scanner;

public class Driver{

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Creatures startCreatures = new ActiveCreature(0, null, null, null, 100);
        String type = "null";
        do{
            System.out.println("What type of pokemon would you like?");
            System.out.println(" * Fire ");
            System.out.println(" * Water ");
            System.out.println(" * Leaf ");
            System.out.print("Input: ");
            type = sc.nextLine();
            type = type.toUpperCase();
            startCreatures.setType(type);
        }while(startCreatures.isType(type) == true);


        sc.close();
    }
}