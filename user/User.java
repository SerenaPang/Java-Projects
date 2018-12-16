package user;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    String firstName;
    String lastName;
    int age;
    private String email;
    private String accountNumber ;
    private double amount;
//    BankAccount bankAccount;
//    private String accountNumber = bankAccount.getAccountNumber();
//    private double amount = bankAccount.getBalance();
//    BankAccount newBankAcount = new BankAccount(accountNumber,amount);

    // TODO ADD A BANK ACCOUNT HERE
    public User() {
    }

    //BankAccount newBankAcount

    User(String firstName, String lastName, int age, String email,String accountNumber, double amount ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.accountNumber =accountNumber;
        this.amount = amount;
       // this.newBankAcount = newBankAcount;
    }

    public void setFirstName(String firstName) {
        System.out.println("User firstName is set to : " + firstName);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        System.out.println("User lastNmae is set to : " + lastName);
        this.lastName = lastName;
    }

    public void setAge(int age) {
        System.out.println("User age is set to : " + age);
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static void printUsers(ArrayList<User> usersList) {
        System.out.println("This method prints out the list of User : ");
        for (int i = 0; i < usersList.size(); i++) {
            System.out.println((i + 1) + ". " + usersList.get(i));
        }
    }

    public String toString() {
        return "First Name:" + getFirstName() + " Last Name:" + lastName + " Age:" + getAge() +
                " Email:" + getEmail() + " Account Number:" + getAccountNumber() + " Amount:" + getAmount();
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<User>();

      //  BankAccount bankAccount = new BankAccount("123", 200);

        User newUser = new User("Kitty", "Ki", 2, "yy@gmail.com","124",200);

        users.add(newUser);

        User.printUsers(users);

        File file = new File("users.txt");
        try {
//writing the user information into the file
            PrintWriter output = new PrintWriter(file);
            for (User c : users) {
                output.append(c.toString());
            }
            output.close();

        } catch (IOException ex) {

            System.out.println("Exception error: " + ex);
        }

        try {
            Scanner inputFile = new Scanner(file);
//            String firstName = inputFile.nextLine();
//            int age  = inputFile.nextInt();

            System.out.println("Reading the contents from the file users right now: ");
            while (inputFile.hasNext()) {
                System.out.println(inputFile.nextLine());
            }

        } catch (FileNotFoundException ex) {
            System.out.println("No such file exsit: " + ex);
        }
    }


}
