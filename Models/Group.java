import java.util.ArrayList;
import java.uti.Iterator;

public class GroupModel{
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

    public void removeStudent(int index){
        this.studentList.remove(index);
    }

    public void addMentor(Mentor mentor){
        this.mentorList.add(mentor);
    }

    public void removeMentor(int index){
        this,mentorList.remove(index);
    }

    public Iterator createStudentsIterator(){

        return studentList.iterator();
    }

    public Iterator createMentorsIterator(){

        return mentorList.iterator();
    }
}