package controller;

import dao.LoginDBImplement;
import view.LoginView;



public class LoginDBController {

    LoginDBImplement loginDB = new LoginDBImplement();
    LoginView view = new LoginView();
    InputController userInput = new InputController();

    public String[] processValidation() {

        int idColumn = 0;
        int roleColumn = 1;
        int counter = 3;
        int arrayCapacity = 2;
        String[] idAndRole = new String[arrayCapacity];
        Boolean process = true;

        while (process && (counter > 0)) {
            String login = userInput.getString("Please enter your login");
            String password = userInput.getString("Please enter your password");
            idAndRole = loginDB.findUserIdAndRole(login, password);
            if (idAndRole[idColumn] == null || idAndRole[roleColumn] == null) {
                counter--;
                view.displayText("Login or password incorrect, try again!");
            } else {
                process = false;
            }
        }
        return idAndRole;
    }

    public void addUserLoginData() {

        String login = userInput.getString("Please enter user's login");
        String password = userInput.getString("Please enter user's password");
        String role = userInput.getString("Please enter user's role");

        loginDB.insertAllLoginData(login, password, role);
    }
    
    public void updateUserLoginData() {

        String login = userInput.getString("Please enter user's login");
        String password = userInput.getString("Please enter user's password");
        int role = userInput.getNumber("Please enter user's role");

        loginDB.updateUserLoginAndPassword(login, password, role);
    }
}
