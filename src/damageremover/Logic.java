package damageremover;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Logic {

    private ArrayList<String> fileContent;

    private final String NOWEAR = " wear: 0";
    private final String NODAMAGE = " cargo_damage: 0";

    private final String WEAR = "wear: &";
    private final String DAMAGE = "cargo_damage: &";
    
    private final String JOB = "player_job";

    public Logic() {
        this.fileContent = new ArrayList<String>();
    }

    public void readFile(String url) {

        File file = new File(url);

        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                this.fileContent.add(line);
            }
        } catch (FileNotFoundException ex) {
        }

    }

    public void readAndReplaceInFile(String url) {
        File file = new File(url);

        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (checkForDamageOrWear(line).equals("wear")) {
                    this.fileContent.add(NOWEAR);
                } else if (checkForDamageOrWear(line).equals("damage")) {
                    this.fileContent.add(NODAMAGE);
                } else {
                    this.fileContent.add(line);
                }
            }
        } catch (FileNotFoundException ex) {
        }

    }

    public String checkForDamageOrWear(String line) {
        if (line.contains(WEAR)) {
            return "wear";
        }
        if (line.contains(DAMAGE)) {
            return "damage";
        }
        return "";
    }

    public void readOnlyWearAndDamage(String url) {

        File file = new File(url);

        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.contains("wear: &")) {
                    this.fileContent.add(line);
                }

            }
        } catch (FileNotFoundException ex) {
        }

    }

    public void printWholeFile() {
        for (String line : this.fileContent) {
            System.out.println(line);
        }
    }

    public void printOnlyDamageAndWearLines() {
        for (String line : this.fileContent) {
            if (line.contains(WEAR)) {
                System.out.println(line);
            }
            if (line.contains(DAMAGE)) {
                System.out.println(line);
            }
        }
    }

    public boolean indexOfDamage() {
        boolean noDamage = false;
        for (int i = 0; i < this.fileContent.size(); i++) {
            if (this.fileContent.get(i).contains(DAMAGE)) {
                System.out.println(i);
                noDamage = true;
            }
        }
        return noDamage;
    }

    public boolean indexOfWear() {
        boolean noWear = false;
        for (int i = 0; i < this.fileContent.size(); i++) {
            if (this.fileContent.get(i).contains(WEAR)) {
                System.out.println(i);
                noWear = true;
            }
        }
        return noWear;
    }

    public void writeToFile() {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\Praid\\Desktop\\Java\\DamageRemover\\src\\damageremover\\output\\game.sii");
            for (String line : this.fileContent) {
                writer.append(line + "\n");
            }
            writer.close();
        } catch (IOException ex) {

        }
    }

}
