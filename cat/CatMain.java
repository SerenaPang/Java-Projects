package cat;

import java.util.ArrayList;
import java.util.Scanner;

public class CatMain {

    public static void main(String[] args) {
        CatStatistics catStatistics = new CatStatistics();
        CatService catService = new CatService();
        CatStore catStore = new CatStore();
        ArrayList<Cat> cats = catStore.read();
        Scanner userInput = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println(" Menu of Cats");
        System.out.println(" Choices:");
        System.out.println(" A  Add cat information and write it into a file.");
        System.out.println(" B  Remove cat information.");
        System.out.println(" C  Read the cat information from the file.");
        System.out.println(" D  Find the heaviest cat information.");
        System.out.println(" E  Find the Lightest cat information.");
        System.out.println(" F  Calculate average cat weight.\n");
        System.out.println("========================================");


        System.out.println("Do you want to choose an option in the menu? Enter(Y/N)");
        String again = userInput.next();

        while (!again.equals("Y") && !again.equals("N")) {
            System.out.println("You have to enter Y or N !");
            System.out.println("Do you want to choose an option in the menu?(Y/N)");
            again = userInput.next();

        }

        while (again.equals("Y")) {

            System.out.println("Please enter your choice: ");
            String choices = userInput.next();

            String value = choices;
            switch (value) {
                case "A":
                    System.out.println("Add cat information.");
                    catService.addCats(cats); // adding cats to the list
                    catStore.save(cats);//saving all the cats into the file
                    System.out.println("Done adding and saving the cat info into the file");

                    break;
                case "B":
                    System.out.println("Remove cat information.");
                    catService.removeCats(cats);
                    catStore.save(cats);
                    System.out.println("Done removing and saving the cat info into the file");


                    break;
                case "C":
                    System.out.println("Reading the cat information from the file.");
                    Cat.printCats(cats);
                    break;
                case "D":
                    System.out.println("Find the heaviest cat information.");
                    System.out.println("The heaviest cat weight is: " + catStatistics.findTheHeaviestCatWeight(cats));
                    System.out.println("The heaviest cat is ---> " + catStatistics.findTheHeaviestCat(cats));

                    break;
                case "E":
                    System.out.println("Find the Lightest cat information.");
                    System.out.println("The lightest cat weight is: " + catStatistics.findTheLightestCatWeight(cats));
                    System.out.println("The lightest cat is ---> " + catStatistics.findTheLightestCat(cats));
                    break;
                case "F":
                    System.out.println("Calculate average cat weight.");
                    System.out.println("The average weight of the cat is: " + catStatistics.findAveragePassesList(cats));

                    break;
                default:
                    System.out.println("That is NOT an option!");
            }

            System.out.println("Do you want to return to the menu?(Y/N)");
            again = userInput.next();
        }

    }
}
