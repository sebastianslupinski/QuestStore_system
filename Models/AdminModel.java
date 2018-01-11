import java.util.ArrayList;

public class AdminModel extends User{

    //public ArrayList<Group> groups = new ArrayList();

    public AdminModel(String login, String password, String name, String lastName){
        super(login, password, name, lastName);
        email = createEmail();
    }
}