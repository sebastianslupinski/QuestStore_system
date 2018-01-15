package src.view;

import java.util.Scanner;
import java.util.InputMismatchException;


public abstract class ViewAbstract {

  public void displayText(String text) {
    System.out.println(text);
  }

  public static String getInput(String message) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(message);
    String userInput = scanner.next();
    return userInput;
  }

  public static String pressEnterToContinue(String message){
    System.out.println(message);
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  public static Integer getNumber(String message) {
        Boolean notDone = true;
        Integer output = 0;
        while (notDone) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println(message);
                output = scanner.nextInt();
                return output;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input! Must be '123' format");
            }
        }
        return output;      
    }
}