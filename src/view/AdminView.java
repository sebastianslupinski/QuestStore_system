package src.view;

import src.models.*;

import java.util.*;


public class AdminView extends ViewAbstract {


    public void displayAdminMenu() {
    int optionNumber = 1;
    System.out.println("======= HELLO-ADMIN =======\n");
    System.out.println("Please choose option: ");
    final String[] OPTIONS = {"Create Mentor", "Create Group", "Assign mentor to the group",
                              "Edit Mentor", "Exit"};

    for (String option : OPTIONS) {
        System.out.println(optionNumber + "--->" + option);
        optionNumber ++;
        }
    }
<<<<<<< HEAD
  }
=======

    public static void displayAttributsEditMenu() {
        int optionNumber = 1;
        System.out.println("Choose what atribute you want to edit");
        final String[] OPTIONS = {"Login", "Password", "Name",
        "Lastname", "Email"};

        for (String option : OPTIONS) {
            System.out.println(optionNumber + "--->" + option);
            optionNumber ++;
        }
    }
>>>>>>> 4f83861c0aa25dc6e28690524ad109e55b55245b

    public void displayMentors(ArrayList<MentorModel> mentors) {
        int index = 0;
        for (MentorModel mentor : mentors){
          System.out.println(index + "--->" + mentor.toString());
          index++;
        }
    }
}
