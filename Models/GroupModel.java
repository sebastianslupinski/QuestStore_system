import java.util.ArrayList;
import java.util.Iterator;

public class GroupModel{
    String name;
    ArrayList<MentorModel> mentorList;
    ArrayList<StudentModel> studentList;

    public GroupModel(String name){
        this.name = name;
        this.mentorList = new ArrayList<>();
        this.studentList = new ArrayList<>();
    }

    public void addStudent(StudentModel student){
        this.studentList.add(student);
    }

    public void removeStudent(int index){
        this.studentList.remove(index);
    }

    public void addMentor(MentorModel mentor){
        this.mentorList.add(mentor);
    }

    public void removeMentor(int index){
        this.mentorList.remove(index);
    }

    public Iterator createStudentsIterator(){

        return studentList.iterator();
    }

    public Iterator createMentorsIterator(){

        return mentorList.iterator();
    }
}