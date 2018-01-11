public class MentorView extends ViewAbstract {

  public void displayMenu(){
   System,out.println("Hello Mentor")
   final String[] OPTIONS = {"1. Create student"};

   for (String option : OPTIONS)
    {
       System.out.println(optionNumber + "--->" + option);
       optionNumber ++;
     }
   }

  public void displayStudentWallet(String studentWallet) {
    System.out.println("Wallet: " + studentWallet);
  }

  public void displayStudentData(String studentData) {
    System.out.println("Student's info: " + studentData);
  }

  public void displayGroup(String groupToDisplay) {
    System.out.println("Group: " + groupToDisplay);
  }

}
