package src.controller;

import src.dao.LoginDAOImplement;
import src.view.LoginView;
import java.util.ArrayList;

public class LoginController {

    LoginDAOImplement loginDAO = new LoginDAOImplement();
    LoginView view = new LoginView();
    InputController userInput = new InputController();

    public String getUserLogin() {
        view.displayText("Please type your login: ");
        return userInput.getString();
    }

    public String getUserPassword() {
        view.displayText("Please type your password: ");
        return userInput.getString();
    }

    public String[] validateLoginData(String login, String password) {
        
        int idColumn = 0;
        int loginColumn = 1;
        int passwordColumn = 2;
        int roleColumn = 3;
        int id = 0;
        int role = 1;
        int arrayCapacity = 2;
        String[] idAndRole = new String[arrayCapacity];
        ArrayList<String[]> loginCollection = loginDAO.readDataFromFile();

        for (int x = 0; x < loginCollection.size(); x++) {
            String[] row = loginCollection.get(x);
            if (login.equals(row[loginColumn]) && password.equals(row[passwordColumn])) {
                idAndRole[id] = row[idColumn];
                idAndRole[role] = row[roleColumn];
            }
        }
        System.out.println(idAndRole[0] + idAndRole[1]);
        return idAndRole;
    }

    public String[] processValidation() {

        int counter = 3;
        int arrayCapacity = 2;
        String[] idAndRole = {"wrong", "wrong"};
        Boolean process = true;


        while (process && (counter > 0)) {
            String login = this.getUserLogin();
            String password = this.getUserPassword();
            idAndRole = this.validateLoginData(login, password);
            System.out.println(idAndRole.length);
            
            if (idAndRole[0] == null || idAndRole[1] == null) {
                counter--;
                view.displayText("Login or password incorrect, try again!");
            } else {
                process = false;
            }
        }
        return idAndRole;
    }
}