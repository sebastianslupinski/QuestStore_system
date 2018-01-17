import java.util.Scanner;

public class InputController{

  public String getString(){
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    return input;
  }
}
