package src.controller;

import java.util.Scanner;

public class InputController{

  public String getString(){
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    return input;
  }

  public int getNumber(){
    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();
    return input;
  }

}
