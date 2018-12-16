package user;

import java.util.ArrayList;
import java.util.Scanner;

public class UserMain {

    public static void main(String[] args) {

        UserStatistics userStatistics = new UserStatistics();
        UserService userService = new UserService();
        UserStore userStore = new UserStore();
        BankAccount bankaccount = new BankAccount();
        UserInput inputValidation = new UserInput();
      //  ArrayList<User> users = new ArrayList<>();
        ArrayList<User> users = userStore.read();
        Scanner userInput = new Scanner(System.in);


        userService.printMenu();
        System.out.println("Do you want to choose an option in the menu? Enter(y/n)");
        String again = userInput.next();


        inputValidation.inputValidationForYandN(again);

        while (inputValidation.inputValidationForYandN(again) == true) {

            System.out.println("Please enter your choice: ");
            String choices = userInput.next();

            String value = choices;
            switch (value) {
                case "A":
                    System.out.println("Add user information.");
                    userService.addUser(users); // adding users to the list
                    userStore.save(users);//saving all the users into the file
                    System.out.println("Done adding and saving the user info into the file");
                    break;

                case "B":
                    System.out.println("Reading the user information from the file.");
                    User.printUsers(users);
                    break;

                case "C":
                    System.out.println("Remove user information.");
                    userService.removeUser(users);
                    userStore.save(users);
                    System.out.println("Done removing and saving the user info into the file");
                    break;

                case "D":
                    System.out.println("Add funds ");
                    System.out.println("Please enter the deposit amount: ");
                    double amountToAdd = userInput.nextDouble();
                    bankaccount.addMoney(amountToAdd);
                    break;

                case "E":
                    System.out.println("Withdraw funds");
                    System.out.println("Please enter the withdraw amount: ");
                    double amountToWithDraw = userInput.nextDouble();
                    bankaccount.addMoney(amountToWithDraw);
                    break;
                case "F":
                    System.out.println("Update user information.");
                    bankaccount.selectAccount(users);
                    break;

                case "G":
                    System.out.println("Print average age and amount.");
                    System.out.println("Average Age of the users: ");
                    System.out.println( userStatistics.findAverageAge(users));
                    break;
                case "H":
                    System.out.println("Print different email domain.");
                    break;

                default:
                    System.out.println("That is NOT an option!");
            }

            System.out.println("Do you want to return to the menu?(y/n)");
            again = userInput.next();
            inputValidation.inputValidationForYandN(again);
        }

    }
}
