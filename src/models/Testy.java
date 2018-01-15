public class Testy {

    public static void main(String[] args) {
        AdminModel admin = new AdminModel("admin1", "admin1", "name", "lastName");
        System.out.println(admin.toString());
        StudentModel student = new StudentModel("studenciak", "hasło", "name", "lastname", "A");
        StudentModel student2 = new StudentModel("studenciak2", "hasło2", "name", "lastname", "A");
        StudentModel student3 = new StudentModel("studenciak3", "hasło2", "name", "lastname", "A");
        System.out.println(student.toString());
        MentorModel mentor = new MentorModel("mentor","pass", "name", "lastname");
        System.out.println(student.group);
        System.out.println(mentor.toString());
        GroupModel grupa = new GroupModel("nowa grupa");
        grupa.addStudent(student);
        grupa.addStudent(student2);
        grupa.addStudent(student3);
        grupa.addMentor(mentor);
        Quest quest = new Quest("quescik", "opis", 12, "basic");
        grupa.printStudents();
        grupa.removeStudentById(003);
        System.out.println("USUWAM STUDENCIAKA");
        grupa.printStudents();
    }
}