package user;
import java.util.ArrayList;

public class UserStatistics {

    public double findAverageAge(ArrayList<User> users) {
        int sum = 0;
        for (User user : users) {
            sum = sum + user.getAge();
        }
        double averageAge = sum / users.size();
        return averageAge;
    }


    public static void main(String[] args){



    }
}
