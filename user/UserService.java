package user;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {

    private Scanner userInput;
    public UserService() {
        userInput = new Scanner(System.in);
    }
    BankAccount bankAccount;
    User user;

    public void addUser(ArrayList<User> users){
        System.out.println("Do you want to add a user?(y/n)");
        String again = userInput.next();
        while (again.equals("y")) {
            System.out.println("Adding another user...");

            System.out.println("Please enter the user's \n First name\n Last name\n Age\n Email\n Account number\n Amount in account\n: ");
            String firstName = userInput.next();
            String lastName = userInput.next();
            int age = userInput.nextInt();
            String email = userInput.next();
            String accountNumber = userInput.next();
            double amount = userInput.nextDouble();

          //  bankAccount = new BankAccount(accountNumber,amount);

            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setAge(age);
            user.setEmail(email);
            user.setAccountNumber(accountNumber);
            user.setAmount(amount);

            users.add(new User(firstName,lastName,age,email,accountNumber,amount));

            System.out.println("Done adding user.");
            System.out.println("Do you want to add another user?(y/n)");
            again = userInput.next();
        }

    }

    public void removeUser(ArrayList<User> users){
        System.out.println("Do you want to remove a u?(y/n)");
        String again = userInput.next();
        while (again.equals("y")) {
            System.out.println("Removing user...");

            System.out.println("Please enter the account number of the user that you want to remove: ");
            String accountNumber = userInput.next();
            for (int i = 0; i < users.size();i++){
                if( users.get(i).getAccountNumber().equals(accountNumber)){ //find the user
                    users.remove(users.get(i)); //then remove it
                }
            }
            System.out.println("Done removing user.");
            System.out.println("Do you want to remove another user?(y/n)");
            again = userInput.next();
        }

    }

    public void printMenu(){

        System.out.println("========================================");
        System.out.println(" ============== User Menu ==============");
        System.out.println(" Choices:");
        System.out.println(" A  Add user information and write it into a file.");
        System.out.println(" B  See all users.");
        System.out.println(" C  Remove user information");
        System.out.println(" D  Add funds.");
        System.out.println(" E  Withdraw funds");
        System.out.println(" F  Update user information.");
        System.out.println(" G  Print average age and amount.");
        System.out.println(" H  Print different email domain.\n");
        System.out.println("========================================");

    }
}
