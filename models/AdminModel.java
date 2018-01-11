package models;
import view.*;

import java.security.acl.Group;
import java.util.ArrayList;

public class AdminModel extends UserModel {

    private ArrayList<GroupModel> groups = new ArrayList();
    private ArrayList<MentorModel> mentors = new ArrayList();
    public AdminView view = new AdminView();

    public AdminModel(String login, String password, String name, String lastName){
        super(login, password, name, lastName);
        email = createEmail();
    }

    // public void createMentor(String login, String password, String name, String lastName){
    //     MentorModel newMentor = new MentorModel(login, password, name, lastName);
    //     mentors.add(newMentor);
    //     AdminView.displayText("Mentor created successfully");
    // }

    public void createGroup(String name){
        GroupModel newGroup = new GroupModel(name);
        groups.add(newGroup);
    }

    public ArrayList<GroupModel> getGroups(){
        return groups;
    }

    public GroupModel getGroup(){
        boolean groupNotChosen = true;
        Integer groupIndex = 0;
        while(groupNotChosen){
            view.displayGroups(getGroups());
            String userInput = view.getInput("Choose group number");
            groupIndex = Integer.parseInt(userInput);
            if (groupIndex < groups.size()) {
                groupNotChosen = false;
            }
        }
        return groups.get(groupIndex);
    }

    public ArrayList<MentorModel> getMentors(){
        return mentors;
    }

    public MentorModel getMentor(){
        boolean mentorNotChosen = true;
        String mentorIndex;
        while(mentorNotChosen){
            view.displayMentors(getMentors());
            mentorIndex = view.getInput("Choose mentor number");
            if (mentorIndex.equals(mentors.size())){
                mentorNotChosen = false;
            }
        }
        return mentors.get(Integer.valueOf(mentorIndex));
    }

    public void assignMentorToGroup(){
        GroupModel groupToAssign = getGroup();
        MentorModel mentorToAssign = getMentor();
        groupToAssign.addMentor(mentorToAssign);
        view.displayText("Mentor assigned succesfully");
    }

}
