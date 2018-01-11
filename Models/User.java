public abstract class UserModel {

    protected String login;
    protected String password;
    protected String name;
    protected String lastName;
    protected String email;
    protected final int id;
    protected static int lastId = 0;

    protected UserModel(String login, String password, String name, String lastName){
        this.login = login;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.email = createEmail();
        this.id = ++lastId;
    }

    protected String createEmail(){
        return String.format("%s.%s@codecool.com", name, lastName);
    }

    public String getLogin(){
        return this.login; 
    }

    public String getPassword(){
        return this.password;
    }

    public String getName(){
        return this.name;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getEmail(){
        return this.email;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setEmail(String newEmail){
        this.email = newEmail;
    }

    public String toString(){
        return String.format("%i | %s | %s %s | %s", id, login, name, lastName, email);
    }

    public int getId(){
        return this.id;
    }
}