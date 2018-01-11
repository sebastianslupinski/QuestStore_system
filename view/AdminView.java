public class AdminView extends ViewAbstract {

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

  public void displayMentor(String mentorToDisplay) {
    System.out.println("Mentor: " + mentorToDisplay);
  }

  public void displayGroups(String groupsToDisplay) {
    System.out.println("Groups: " + groupsToDisplay);
  }
}
