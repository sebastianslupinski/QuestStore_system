package src.view;

import java.util.Scanner;


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

  public static String getInput() {
    Scanner sc = new Scanner(System.in);
    String userInput = sc.next();
    return userInput;
  }

  public static String pressEnterToContinue(String message){
    System.out.println(message);
    Scanner input = new Scanner(System.in);
    return input.nextLine();
  }

  public static Integer getNumber(String message) {
    try{
    System.out.println(message);
    return Integer.parseInt((String)getInput());
    }
    catch(NumberFormatException e){
        System.out.println("It should be a number, please enter again");
    }
    return Integer.parseInt((String)getInput());
    }
}