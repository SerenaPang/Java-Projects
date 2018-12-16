package cat;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Cat {
    String name;
    int weight;

   public Cat(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

   public Cat(){
    }

    public void setName(String catName) {
        System.out.println("Cat name is set to : " + catName);
        this.name = catName;
    }

    public void setWeight(int catWeigt) {
        System.out.println("Cat weight is set to : " + catWeigt);
        this.weight = catWeigt;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public static void printCats(ArrayList<Cat> catsList) {
        System.out.println("This method prints out the list of cats: ");
        for (int i = 0; i < catsList.size(); i++) {
            System.out.println((i + 1) + ". " + catsList.get(i));
        }
    }

    public String toString() {
        return String.format("%s: %s  %s: %d\n", "Name", getName(), " Weight", getWeight());
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        ArrayList<String> catNames = new ArrayList<String>();
        ArrayList<Integer> catWeights = new ArrayList<Integer>();
        ArrayList<Cat> cats = new ArrayList<Cat>();
//
//        for (int i = 0; i < 3; i++) {
//
//            System.out.println("Please enter the name of the cat: ");
//            String name = userInput.nextLine();
//            System.out.println("You entered " + name);
//            catNames.add(i, name);
//            System.out.println("===================");
//        }
//
//        for (int i = 0; i < 3; i++) {
//            System.out.println("Please enter the weight of the cat: ");
//            int weight = userInput.nextInt();
//            System.out.println("You entered" + weight);
//            catWeights.add(i, weight);
//        }


//        System.out.println("Do you want to add a cat?(y/n)");
//        String again = userInput.next();
//        while (again.equals("y")) {
//            System.out.println("Adding another cat...");
//
//            System.out.println("Please enter the name then the weight of the cat: ");
//            String name = userInput.next();
//            int weight = userInput.nextInt();
//
//            cats.add(new Cat(name, weight));
//            System.out.println("Done adding cat.");
//            System.out.println("Do you want to add another cat?(y/n)");
//            again = userInput.next();
//        }



//        cats.add(new Cat("Serena", 1));
//        cats.add(new Cat("Fiona", 2));
//        cats.add(new Cat("Papi", 3));
//        System.out.println("Names: ");
//        System.out.println(catNames);
//        System.out.println("Weigths: ");
//        System.out.println(catWeights);
//        System.out.println("The whole array list of cats: ");
//        System.out.println(cats);
        Cat.printCats(cats);

        File file = new File("/tmp/cats.txt");
        try {
//writing the cat information into the file
            PrintWriter output = new PrintWriter(file);
            for (Cat c : cats) {
                output.append(c.toString());
            }
            output.close();

        } catch (IOException ex) {

            System.out.println("Exception error: " + ex);
        }

        try {
            Scanner inputFile = new Scanner(file);
//            String name = inputFile.nextLine();
//            int weight  = inputFile.nextInt();

            System.out.println("Reading the contents from the file Cat right now: ");
            while (inputFile.hasNext()) {
                System.out.println(inputFile.nextLine());
            }

        } catch (FileNotFoundException ex) {
            System.out.println("No such file exsit: " + ex);
        }
    }
}
