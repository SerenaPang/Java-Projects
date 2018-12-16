package user;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class UserStore {


    private File file = new File("users.txt");
    BankAccount bankAccount;
 //   bankAccount.getAccountNumber() + ":" + bankAccount.getBalance()

    public void save(ArrayList<User> users) {
        try {
            FileWriter writer = new FileWriter("users.txt");
            for (User user : users) {
                System.out.println("Writing the information to the file now: ");
                writer.write(user.getFirstName() + ":" + user.getLastName()+ ":" + user.getAge() + ":" + user.getEmail() + ":" + user.getAccountNumber() + ":" + user.getAccountNumber() + ":" + user.getAmount() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> read() {
        ArrayList<User> users = new ArrayList<User>();


        try {
            FileReader reader = new FileReader("users.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Line -> " + line);

                int indexOfcollon = line.indexOf(":");

                String []words = line.split(":");
                for (String w : words) {
                    System.out.println(w);

                    String firstName = words[0];
                    String lastName = words[1];
                    String age = words[2];
                    String email = words[3];
                    String accountNumber= words[4];
                    String amount =  words[5];

                  //  bankAccount = new BankAccount(accountNumber,amount);

                    User aNewUser = new User(firstName,lastName,Integer.parseInt(age),email,accountNumber,Double.parseDouble(amount));

                  //  users.add(new User(firstName,lastName,Integer.parseInt(age),email,accountNumber,Double.parseDouble(amount)));
                    users.add(aNewUser);
                }

            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("List of users: ");
//        System.out.println(users);
        return users;

    }


    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<User>();
        User user = new User();
        user.setFirstName("Gatita");
        users.add(user);

        UserStore storeInfo = new UserStore();
        storeInfo.save(users);//saving all the users into the file

        System.out.println("Done saving the user info into the file");

        System.out.println("Now read the file : ");
        storeInfo.read();

        String mystring = "My stri ng sho uld be splitted";
        String []words = mystring.split("s");
        for (String w : words) {
            System.out.println(w);
        }

    }
}
