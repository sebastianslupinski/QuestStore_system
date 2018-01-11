import java.util.Scanner;

public abstract class ViewAbstract {

  public displayUserData(String userData) {
    System.out.println(userData);
  }

  public String userInput(String message) {
    Scanner sc = new Scanner(System.in);
    System.out.println(message);
    String userInput = sc.next();
    return userInput;
  }
}
