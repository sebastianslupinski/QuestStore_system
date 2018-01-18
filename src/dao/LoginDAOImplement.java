package src.dao;


import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;


public class LoginDAOImplement implements LoginDAO {

    private ArrayList<String[]> loginCollection;

    public LoginDAOImplement() {
        this.loginCollection = new ArrayList<String[]>();
    }

    public ArrayList<String[]> readDataFromFile() {
        ArrayList<String[]> logins = this.getLoginCollection();
        File homedir = new File(System.getProperty("user.dir"));
        System.out.println(homedir.toString());
        File fileToRead = new File(homedir, "/bin/resources/login.txt");
        BufferedReader br = null;
        String line = "";
        String splitBy = ",";

        try {
            br = new BufferedReader(new FileReader(fileToRead));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy);
                logins.add(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return logins;
    }

    public Boolean saveDataToFile(ArrayList<String[]> loginCollection) {

        int idColumn = 0;
        int loginColumn = 1;
        int passwordColumn = 2;
        int roleColumn = 3;
        BufferedWriter writer = null;

        try {
            File homedir = new File(System.getProperty("user.dir"));
            File fileToWrite = new File(homedir, "/resources/login.txt");
            fileToWrite.createNewFile();
            writer = new BufferedWriter(new FileWriter(fileToWrite, false));
            for (int x = 0; x < loginCollection.size(); x++) {
                String[] line = loginCollection.get(x);
                writer.write(line[idColumn] + "," + line[loginColumn] + ","
                             + line[passwordColumn] + "," + line[roleColumn] + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
        return true;
    }

    public ArrayList<String[]> getLoginCollection() {
      return loginCollection;
    }
}
