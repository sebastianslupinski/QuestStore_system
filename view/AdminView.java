public class AdminView extends ViewAbstract {

  public void displayGroups(ArrayList groups) {
    int index = 0;
    for (GroupModel group : groups){
      System.out.println(index + "--->" + group.name);
      index++;
    }
  }

  public void displayMentors(ArrayList mentors){
    int index = 0;
    for (MentorModel mentor : mentors){
      System.out.println(index + "--->" + mentor.toString());
      index++;
    }
  }
}
