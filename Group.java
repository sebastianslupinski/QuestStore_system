import java.util.ArrayList;

public class Group{
    String name;
    ArrayList<Mentor> mentorList;
    ArrayList<Student> studentList;

    public Group(String name){
        this.name = name;
        this.mentorList = new ArrayList<>();
        this.studentList = new ArrayList<>();
    }

    public void addStudent(Student student){
        this.studentList.add(student);
    }

    public void removeStudent(Student student){
        this.studentList.remove()
    }
}