import java.util.Scanner;

public abstract class ViewAbstract {

  public displayText(String text) {
    System.out.println(text);
  }

  public String getInput(String message) {
    Scanner sc = new Scanner(System.in);
    System.out.println(message);
    String userInput = sc.next();
    return userInput;
  }

  public String getInput() {
    Scanner sc = new Scanner(System.in);
    System.out.println(message);
    String userInput = sc.next();
    return userInput;
  }
}
