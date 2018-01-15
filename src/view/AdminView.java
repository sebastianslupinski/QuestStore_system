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
   System.out.println("Please choose option: ");
   final String[] OPTIONS = {"Create Mentor", "Create Group", "Assign mentor to the group",
                             "Show mentors profile", "Exit"};

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
