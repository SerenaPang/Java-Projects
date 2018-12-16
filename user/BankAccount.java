package user;
import java.util.Scanner;
import java.util.ArrayList;

public class BankAccount {
    User user ; //= new User()
    Scanner userInput = new Scanner(System.in);


    String accountNumber;
//    double balance = user.getAmount();
    double balance;
    double amountToWithDraw;

//String accountNumber, double balance
    BankAccount( ){

        this.accountNumber = accountNumber;
    }


    public double getBalance(){
        return balance;
    }

    public void setBalance(){
        this.balance =balance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }

    public void setAccountNumber(){
        this.accountNumber = accountNumber;
    }



    public void selectAccount(ArrayList<User> users) {

        User user;

        System.out.println("Do you modified the information for the account?(y/n)");
        String again = userInput.next();
        while (again.equals("y")) {
            System.out.println("Please enter the accountNumber of the user that you want to modified: ");
            String name = userInput.next();
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getAccountNumber().equals(accountNumber)) { //find the person's account number
                    System.out.println("Information of the account owner: ");
                    System.out.println(users.get(i));
                    user = users.get(i);
                    UserService serivices;

                    int selectedFiled = userInput.nextInt();
                    System.out.println("Which field do you want to change? ");
                    System.out.println(" 1.First name.\n 2.Last name\n 3.Age\n 4.Email\n 5.Account Number\n 6.Amount\n");

                    if (selectedFiled == 1) {
                        System.out.println("change first name");
                        String newFirstName = userInput.next();
                        user.setFirstName(newFirstName);


                    } else if (selectedFiled == 2) {
                        System.out.println("change last name");
                        String newLastName = userInput.next();
                        user.setLastName(newLastName);

                    } else if (selectedFiled == 3) {
                        System.out.println("change age");
                        int newAge = userInput.nextInt();
                        user.setAge(newAge);

                    } else if (selectedFiled == 4) {
                        System.out.println("change email");
                        String newEmail = userInput.next();
                        user.setEmail(newEmail);
                    }

                }
            }

            System.out.println("Do you want to modified another user?(y/n)");
            again = userInput.next();
        }

    }



    public double withdarwMoney( double amountToWithDraw){

        if(amountToWithDraw < balance ){
            System.out.println("You don't have enough money in your bank account.");
            System.out.println("Amount you can withdraw: " + balance);
        }else { balance = balance - amountToWithDraw;}

       return balance = balance - amountToWithDraw;
    }

    public double addMoney( double amountToAdd){

        if(amountToWithDraw  < 0 ){
            System.out.println("You didn't add any money in your bank account.");
        }else { balance = balance + amountToWithDraw;}

        return balance = balance + amountToWithDraw;
    }

    public static void main(String[] args){



    }


}
