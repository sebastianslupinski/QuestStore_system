import java.util.ArrayList;

public class Admin extends User{

    //public ArrayList<Group> groups = new ArrayList();

    public Admin(String login, String password, String name, String lastName){
        super(login, password, name, lastName);
        email = createEmail();
    }
}