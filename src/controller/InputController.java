package src.controller;

import java.util.Scanner;

public class InputController{

  public String getString(){
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    return input;
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
