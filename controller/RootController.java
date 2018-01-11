package controller;
import view.*;

public class RootController{
  AdminView adminView = new AdminView();
  RootView rootView = new RootView();
  MentorView mentorView = new MentorView();

  public void startApplication(){
    rootView.displayText("Weclome in QUESTSTORE");
    rootView.displayMenu();

    String option = rootView.getInput();

    switch (option) {
      case "1":
        adminView.displayMenu();
        break;
      case "2":
        mentorView.displayMenu();
        break;
      case "3":
        System.out.println("..........");
        break;


    }


  }
}
