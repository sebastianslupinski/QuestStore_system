public class Testy{

    public static void main(String[] args){
        Admin admin = new Admin("admin1", "admin1", "name", "lastName");
        System.out.println(admin.toString());
        Student student = new Student("studenciak", "hasło", "name", "lastname", "A");
        System.out.println(student.toString());
        Mentor mentor = new Mentor("mentor","pass", "name", "lastname");
        System.out.println(student.group);
        System.out.println(mentor.toString());
    }
}