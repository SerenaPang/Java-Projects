package user;

import java.util.Scanner;

public class UserInput {
    UserService userService;
    Scanner userInput = new Scanner(System.in);
    UserInput(){
    }

    public boolean inputValidationForYandN(String again){

        boolean anotherTime;

        while (!again.equals("y") && !again.equals("n")) {
            System.out.println("You have to enter y or n !");
            System.out.println("Do you want to choose an option in the menu?(y/n)");
            userService.printMenu();
            again = userInput.next();
            inputValidationForYandN(again);
            anotherTime = false;

        }

        return true;

    }





}
