import java.util.ArrayList;

public class MentorModel extends UserModel{

    public ArrayList<Group> guidedGroups = new ArrayList();

    public MentorModel(String login, String password, String name, String lastName){
        super(login, password, name, lastName);
    }

    public createStudent(String login, String password, String name, String lastName){
        boolean studentNotAdded = true;
        while(studentNotAdded){
            String groupName = MentorView.getInput("Please enter name of group to add student")
            for (Group group : guidedGroups){
                if group.name == groupName{
                    group = group.name;
                    studentNotAdded = false;
                }
                else{
                    MentorView.displayText("There is no group like this.");
                }
            }
        StudentModel newStudent = new StudentModel(login, password, name, lastName, group);
        group.addStudent(newStudent);
        MentorView.displayText("Student added succesfully.")
    }

    public getGroupByName(String name){
        for (Group group : guidedGroups){
            if(group.name == name){
                return group;
            }
        }
        return null;
    }

}