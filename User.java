public abstract class User {

    protected String login;
    protected String password;
    protected String name;
    protected String lastName;
    protected String email;

    protected User(String login, String password, String name, String lastName){
        this.login = login;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.email = createEmail();
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

}