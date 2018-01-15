package src.view;

import java.util.Scanner;
import java.util.InputMismatchException;


public abstract class ViewAbstract {

  public static void displayText(String text) {
    System.out.println(text);
  }

  public static String getInput(String message) {
    Scanner sc = new Scanner(System.in);
    System.out.println(message);
    String userInput = sc.next();
    return userInput;
  }

  public static String pressEnterToContinue(String message){
    System.out.println(message);
    Scanner input = new Scanner(System.in);
    return input.nextLine();
  }

  public static Integer getNumber(String message) {
        Boolean notDone = true;
        Integer output = 0;
        while (notDone) {
            try {
                Scanner newScanner = new Scanner(System.in);
                System.out.println(message);
                output = newScanner.nextInt();
                return output;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input! Must be '123' format");
            }
        }
        return output;      
    }
}