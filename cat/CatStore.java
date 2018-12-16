package cat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


/**
 * This class saves and retrieves the cats from a file.
 */
public class CatStore {
    private File file = new File("cats.txt");

    public void save(ArrayList<Cat> cats) {
        try {
            FileWriter writer = new FileWriter("cats.txt");
            for (Cat cat : cats) {
                writer.write(cat.getName() + ":" + cat.getWeight() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Cat> read() {
        ArrayList<Cat> cats = new ArrayList<Cat>();
        try {
            ///Users/SerenaPang1/Desktop/cs112/intellj-projects/Review for Midterm1/cats.txt
            FileReader reader = new FileReader("cats.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println("Line -> " + line);
                int indexOfcollon = line.indexOf(":");

                String name = line.substring(0, indexOfcollon);
//                System.out.println("Name of the cat: " + name);
//                System.out.println("Weight of the cat: " + line.substring(indexOfcollon + 1));
                int weightOftheCat = Integer.parseInt(line.substring(indexOfcollon + 1));
                cats.add(new Cat(name, weightOftheCat));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("List of cat: ");
//        System.out.println(cats);
        return cats;

    }


    public static void main(String[] args) {
        ArrayList<Cat> cats = new ArrayList<Cat>();
        cats.add(new Cat("Serena", 1));
        cats.add(new Cat("Kitty", 2));
        cats.add(new Cat("Papi", 3));
        cats.add(new Cat("Cute", 4));

        CatStore storeInfo = new CatStore();
        storeInfo.save(cats);//saving all the cats into the file

        System.out.println("Done saving the cat info into the file");

        System.out.println("Now read the file : ");
        storeInfo.read();
    }
}


