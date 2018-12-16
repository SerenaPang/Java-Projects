package cat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CatStatistics {

    /**
     * This method finds the heaviest cat in {@code cats}.
     */
    public int findTheHeaviestCatWeight(ArrayList<Cat> cats) {
        int max = cats.get(0).getWeight();

        for (int i = 1; i < cats.size(); i++) {
            if (cats.get(i).getWeight() > max) {
                max = cats.get(i).getWeight();
            }
        }
        return max;
    }

    public Cat findTheHeaviestCat(ArrayList<Cat> cats) {
        Cat maxCat = cats.get(0);
        int max = cats.get(0).getWeight();

        for (int i = 1; i < cats.size(); i++) {
            if (cats.get(i).getWeight() > max) {
                max = cats.get(i).getWeight();
                maxCat = cats.get(i);
            }
        }
        return maxCat;
    }


    public int findTheLightestCatWeight(ArrayList<Cat> cats) {
        int min = cats.get(0).getWeight();

        for (int i = 1; i < cats.size(); i++) {
            if (cats.get(i).getWeight() < min) {
                min = cats.get(i).getWeight();
            }
        }
        return min;
    }

    public Cat findTheLightestCat(ArrayList<Cat> cats) {
        Cat minCat = cats.get(0);
        int min = cats.get(0).getWeight();

        for (int i = 1; i < cats.size(); i++) {
            if (cats.get(i).getWeight() < min) {
                min = cats.get(i).getWeight();
                minCat = cats.get(i);
            }
        }
        return minCat;

    }

    public void removeCat(ArrayList<Cat> cats, String catTobeRemoved) {
        for (int i = 1; i < cats.size(); i++) {
            String name = cats.get(i).getName();
            if(name.equals(catTobeRemoved)){
                System.out.println("found " + name);
                cats.remove(cats.get(i));
                System.out.println("Removing " + name);
            }
        }
    }

    public void averageWeight() {
        // CatStatistics should work only with list of cats, no with files.
        try {
            FileReader reader = new FileReader("cats.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            int sum = 0;
            int count = 0;
            while ((line = bufferedReader.readLine()) != null) {
                int indexOfcollon = line.indexOf(":");
                int weightOftheCat = Integer.parseInt(line.substring(indexOfcollon + 1));

                sum = sum + weightOftheCat;
                count = count + 1;
            }
            System.out.println("The average weight of the cat is:(use file) " + sum / count);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public double findAveragePassesList(ArrayList<Cat> cats) {
        int sum = 0;
        for (Cat cat : cats) {
            sum = sum + cat.getWeight();
        }
        double averageWeight = sum / cats.size();
        //  System.out.println("The average weight of the cat is(use arraylist): " + averageWeight);
        return averageWeight;
    }


    public static void main(String[] args) {

        ArrayList<Cat> cats = new ArrayList<Cat>();
        cats.add(new Cat("Serena", 1));
        cats.add(new Cat("Kitty", 2));
        cats.add(new Cat("Papi", 3));
        cats.add(new Cat("Cute", 4));

        CatStore storeInfo = new CatStore();
        CatStatistics catStatistics = new CatStatistics();
        catStatistics.averageWeight();
        System.out.println("The average weight of the cat is(use arraylist): " + catStatistics.findAveragePassesList(cats));

        System.out.println("The heaviest cat weight is: " +  catStatistics.findTheHeaviestCatWeight(cats));
        System.out.println("The heaviest cat is ---> " +  catStatistics.findTheHeaviestCat(cats));

        System.out.println("The lightest cat weight is: " +  catStatistics.findTheLightestCatWeight(cats));
        System.out.println("The lightest cat is ---> " +  catStatistics.findTheLightestCat(cats));

        System.out.println("Print list of cats before removing Serena");
        System.out.println(cats);
        catStatistics.removeCat(cats,"Serena");
        System.out.println("Print list of cats after removing Serena");
        System.out.println(cats);


    }


}
