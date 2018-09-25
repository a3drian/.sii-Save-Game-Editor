package damageremover;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DamageRemover {

    public static void main(String[] args) {
        String url = "C:\\Users\\Praid\\Desktop\\Java\\DamageRemover\\src\\damageremover\\game.sii";

        Logic damageRemoverLogic = new Logic();
        
        textMenu();
        
        while(true){
            Scanner input = new Scanner(System.in);
            System.out.print("> ");
            String command = input.nextLine();
            if(command.equalsIgnoreCase("x")){
                break;
            }
            if(command.equals("r")){
                damageRemoverLogic.readFile(url);
            }
            if(command.equals("rar")){
                damageRemoverLogic.readAndReplaceInFile(url);
            }
            if(command.equals("ro")){
                damageRemoverLogic.readOnlyWearAndDamage(url);
            }
            if(command.equals("p")){
                damageRemoverLogic.printWholeFile();
            }
            if(command.equals("po")){
                damageRemoverLogic.printOnlyDamageAndWearLines();
            }
            if(command.equals("iod")){
                if(damageRemoverLogic.indexOfDamage() == false){
                    System.out.println("Flag cargo_damage: & not found");
                }
            }
            if(command.equals("iow")){
                if(damageRemoverLogic.indexOfWear() == false){
                    System.out.println("Flag wear: & not found");
                }
            }
            if(command.equals("wf")){
                damageRemoverLogic.writeToFile();
            }
            
            
        }

    }
    
    public static void textMenu(){
        System.out.println("commands available: ");
        System.out.println("r - read game.sii");
        System.out.println("rar - read game.sii and remove damage and wear");
        System.out.println("ro - read only damage and wear from game.sii");
        System.out.println("p - prints what was read from game.sii");
        System.out.println("po - prints only damage and wear lines from game.sii");
        System.out.println("iod - indexes of damage");
        System.out.println("iow - indexes of wear");
        System.out.println("wf - writes to file");
        System.out.println("");
    }

}
