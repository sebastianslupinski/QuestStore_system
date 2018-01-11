package models;
import java.security.acl.Group;
import java.util.ArrayList;

public class AdminModel extends UserModel {

    public ArrayList<Group> groups = new ArrayList();
    public ArrayList<MentorModel> mentors = new ArrayList();

    public AdminModel(String login, String password, String name, String lastName){
        super(login, password, name, lastName);
        email = createEmail();
    }

    public createMentor(String login, String password, String name, String lastName){
        MentorModel newMentor = new MentorModel(login, password, name, lastName);
        mentors.add(newMentor);
        AdminView.displayText("Mentor created successfully");
    }

    public createGroup(String name){
        GroupModel newGroup = new GroupModel(name);
        groups.add(newGroup);
    }

    public getGroups(){
        return groups;
    }

    public getGroup(){
        boolean groupNotChosen = true;
        while(groupNotChosen){
            AdminView.displayGroups(getGroups());
            int groupIndex = (Integer) AdminView.getInput("Choose group number");
            if (groupIndex < groups.size()){
                groupNotChosen = true;
                return groups.get(groupIndex);
            }
        }
    }

    public getMentors(){
        return mentors;
    }

    public getMentor(){
        boolean mentorNotChosen = true;
        while(mentorNotChosen){
            AdminView.displayMentors(getMentors());
            int mentorIndex = (Integer) AdminView.getInput("Choose mentor number");
            if (mentorIndex < mentors.size()){
                mentorNotChosen = true;
                return mentors.get(mentorIndex);
            }
        }
    }

    public assignMentorToGroup(){
        GroupModel groupToAssign = getGroup();
        MentorModel mentorToAssign = getMentor();
        groupToAssign.addMentor(mentorToAssign);
        AdminView.displayText("Mentor assigned succesfully");
    }

}