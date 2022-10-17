import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ZooProcessing {
    ArrayList<Flora> floraList = new ArrayList<>();
    ArrayList<Fauna> faunaList = new ArrayList<>();

    public void processFile(String fileName) {
        try {            
            Scanner scnr = new Scanner(new File(fileName));
            scnr.nextLine();
            while(scnr.hasNextLine()) {
                String organismLine = scnr.nextLine();
                
                addOrganism(organismLine);
            }

            scnr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void interact() {
        System.out.println("CSV File has been loaded, Flora and Fauna lists have been populated!");
        printSelections();
        Scanner scnr = new Scanner(System.in);

        String input = scnr.nextLine();
        while(!input.equalsIgnoreCase("X")) {
            if(input.equalsIgnoreCase("D")) {
                randFact();
            }
            else if(input.equalsIgnoreCase("L")) {
                listCounts();
            }
            else {
                System.out.println("Unrecognized command.");
            }

            printSelections();
            input = scnr.nextLine();
        }

        scnr.close();
    }

    /** Self-Explanation
     * 
     *
     * 
     */
    public void addOrganism(String organismLine) {
        //TODO: Student
    }
    
    public void randFact() {
        Random rand = new Random();
        if(rand.nextInt(1) == 0) {
            Fauna randFauna = faunaList.get(rand.nextInt(faunaList.size()-1));
            System.out.println(randFauna.species + " fact: " + randFauna.fact);
        }
        else {
            Flora randFlora = floraList.get(rand.nextInt(floraList.size()-1));
            System.out.println(randFlora.species + " fact: " + randFlora.fact);
        }
    }
    
    /** Self-Explanation
     * 
     * 
     * 
     */
    public void listCounts() {
        //TODO: Student
    }
    
    public void printSelections() {
        System.out.println("What would you like to do?");
        System.out.println("[D]isplay a random fact?");
        System.out.println("[L]ist current organism type counts?");
        System.out.println("[X] to exit out of the Zoo DB?");
    }
}