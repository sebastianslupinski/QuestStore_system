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
            System.out.println(idAndRole[0] + idAndRole[1]);
            if (idAndRole[idColumn] == null || idAndRole[roleColumn] == null) {
                counter--;
                view.displayText("Login or password incorrect, try again!");
            } else {
                process = false;
            }
        }
        return idAndRole;
    }
//    public void insertAllLoginData() {
//        Boolean process = true;
//
//        while (process) {
//            String login = userInput.getString("Please enter user's login");
//            String password = userInput.getString("Please enter user's password");
//            String role = userInput.getString("Please enter user's role");
//            if (login.length() > 15 && )
//        }
//    }
}
