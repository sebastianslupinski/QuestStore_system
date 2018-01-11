package view;
import java.util.Scanner;


public class RootView{

  public void displayText(String text){
    System.out.println(text);
  }

  public void displayMenu(){

    int optionNumber = 1;
    System.out.println("=======WELCOME IN QUESTSTORY SYSTEM=======");
    System.out.println(" ");
    System.out.println("Please choose your role: ");
    final String[] OPTIONS = {"Admin", "Mentor", "Student"};

    for (String option : OPTIONS)
    {
        System.out.println(optionNumber + "--->" + option);
        optionNumber ++;
    }
  }
  public String getInput(){
    Scanner scanner = new Scanner(system.in);
    String input = scanner.nextLine();
    return input;
  }

}
