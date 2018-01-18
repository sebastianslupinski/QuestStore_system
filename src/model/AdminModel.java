package src.model;

import src.view.*;

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

    public void addGroup(GroupModel newGroup){
        this.groups.add(newGroup);
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
        Integer mentorIndex = 0;
        while(mentorNotChosen){
            view.displayMentors(getMentors());
            mentorIndex = AdminView.getNumber("Please enter a mentor number");
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
