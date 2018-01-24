package model;


public abstract class UserModel {

    protected String id;
    protected String login;
    protected String password;
    protected String name;
    protected String lastName;
    protected String email; 

    protected UserModel(String id, String login, String password,
                        String name, String lastName) {
        int newId = Integer.parseInt(id);
        String finalId = Integer.valueOf(++newId).toString();
        this.id = finalId;
        this.login = login;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.email = createEmail();
    }


    protected UserModel(String id, String login, String password,
                        String name, String lastName, String email) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        
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
        return String.format("%03d | %s | %s %s | %s", id, login, name, lastName, email);
    }

    public String getId(){
        return this.id;
    }
}