package cat;

import cat.Cat;

import java.util.ArrayList;
import java.util.Scanner;

public class CatService {

    private Scanner userInput;
    public CatService() {
        userInput = new Scanner(System.in);
    }

    public void addCats(ArrayList<Cat> cats){
        System.out.println("Do you want to add a cat?(Y/N)");
        String again = userInput.next();
        while (again.equals("Y")) {
            System.out.println("Adding another cat...");

            System.out.println("Please enter the name then the weight of the cat: ");
            String name = userInput.next();
            int weight = userInput.nextInt();

            cats.add(new Cat(name, weight));
            System.out.println("Done adding cat.");
            System.out.println("Do you want to add another cat?(Y/N)");
            again = userInput.next();
        }

    }

    public void removeCats(ArrayList<Cat> cats){
        System.out.println("Do you want to remove a cat?(Y/N)");
        String again = userInput.next();
        while (again.equals("Y")) {
            System.out.println("Removing cat...");

            System.out.println("Please enter the name of the cat that you want to remove: ");
            String name = userInput.next();
            for (int i = 0; i < cats.size();i++){
                if( cats.get(i).getName().equals(name)){ //find the cat name
                    cats.remove(cats.get(i)); //then remove it
                }
            }
            System.out.println("Done removing cat.");
            System.out.println("Do you want to remove another cat?(Y/N)");
            again = userInput.next();
        }

    }




}
