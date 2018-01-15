package src.view;
import src.models.*;

import java.util.*;

public class AdminView extends ViewAbstract {

  public void displayGroups(ArrayList<GroupModel> groups) {
    int index = 0;
    for (GroupModel group : groups){
      System.out.println(index + "--->" + group.name);
      index++;
    }
  }

  public void displayMenu(){
   int optionNumber = 1;
   System.out.println("======= HELLO-ADMIN =======");
   System.out.println(" ");
   final String[] OPTIONS = {"Create Mentor", "Create Group", "Assign mentor to the group",
                             "Edit Mentor", "Exit"};

   for (String option : OPTIONS)
   {
       System.out.println(optionNumber + "--->" + option);
       optionNumber ++;
   }
  }

  public static void chooseAtributeToEdit(){
    int optionNumber = 1;
    System.out.println("Choose what atribute you want to edit");
    final String[] OPTIONS = {"Login", "Password", "Name",
    "Lastname", "Email"};

    for (String option : OPTIONS)
    {
        System.out.println(optionNumber + "--->" + option);
        optionNumber ++;
    }


  }

  public void displayMentors(ArrayList<MentorModel> mentors){
    int index = 0;
    for (MentorModel mentor : mentors){
      System.out.println(index + "--->" + mentor.toString());
      index++;
    }
  }
  }
