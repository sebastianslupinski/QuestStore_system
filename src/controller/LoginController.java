package src.controller;

import src.dao.LoginDaoImplement;
import src.view.LoginView;
import java.util.ArrayList;

public class LoginController {

    LoginDaoImplement loginDAO = new LoginDaoImplement();
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
        String[] idAndRole = new String[2];
        ArrayList<String[]> loginCollection = loginDAO.readDataFromFile();

        for (int x = 0; x < loginCollection.size(); x++) {
            String[] row = loginCollection.get(x);
            if (row[loginColumn].equals(login) && row[passwordColumn].equals(password)) {
                idAndRole[id] = row[idColumn];
                idAndRole[role] = row[roleColumn];
            }
        }
        return idAndRole;
    }
} 