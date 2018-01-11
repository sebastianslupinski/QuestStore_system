public class Testy{

    public static void main(String[] args){
        AdminModel admin = new AdminModel("admin1", "admin1", "name", "lastName");
        System.out.println(admin.toString());
        StudentModel student = new StudentModel("studenciak", "hasło", "name", "lastname", "A");
        System.out.println(student.toString());
        MentorModel mentor = new MentorModel("mentor","pass", "name", "lastname");
        System.out.println(student.group);
        System.out.println(mentor.toString());
        GroupModel grupa = new GroupModel("nowa grupa");
        grupa.addStudent(student);
    }
}