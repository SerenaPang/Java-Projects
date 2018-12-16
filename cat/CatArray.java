package cat;

import cat.Cat;

import java.util.Scanner;

public class CatArray {
    String name;
    int weight;
    Scanner userInput = new Scanner(System.in);

    //String name, int weight

    CatArray(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {

        return name;
    }

    public int getWeight() {

        return weight;
    }

    public String toString() {

        return String.format("%s : %s %s : %d", "Name", getName(), "Weight", getWeight());
    }


    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("How many cats' information do you want to put?");
        int catNumber = userInput.nextInt();
        Cat[] cats = new Cat[catNumber];

        for (int i = 0; i < cats.length; i++) {

            System.out.println("Please enter the name of cat and then enter the weight of the cat: ");
            String name = userInput.next();
            int weight = userInput.nextInt();

            Cat cat = new Cat(name, weight);
            cats[i] = cat;


        }


        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i]);

        }


    }

}
