package view;

import java.util.Scanner;
import java.util.InputMismatchException;


public abstract class AbstractView {

  public void displayText(String text) {
    System.out.println(text);
  }
}