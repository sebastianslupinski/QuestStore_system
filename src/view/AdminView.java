package view;

import model.*;

import java.util.*;


public class AdminView extends AbstractView { 


    public void displayAdminMenu() {
    int optionNumber = 1;
    System.out.println("======= HELLO-ADMIN =======\n");
    System.out.println("Please choose option: ");
    final String[] OPTIONS = {"Display existing mentors", "Create Mentor", "Edit mentor",
                              "IN PROGRESS", "Exit"};

    for (String option : OPTIONS) {
        System.out.println(optionNumber + "--->" + option);
        optionNumber ++;
        }
    }

    public static void displayAttributesEditMenu() {
        int optionNumber = 1;
        System.out.println("Choose what atribute you want to edit");
        final String[] OPTIONS = {"Login", "Password", "Name",
        "Lastname", "Email"};

        for (String option : OPTIONS) {
            System.out.println(optionNumber + "--->" + option);
            optionNumber ++;
        }
    }

    public void displayMentors(ArrayList<MentorModel> mentors) {
        int index = 0;
        for (MentorModel mentor : mentors){
          System.out.println(index + "--->" + mentor.toString());
          index++;
        }
    }
}
