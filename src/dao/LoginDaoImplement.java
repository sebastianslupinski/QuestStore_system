package src.dao;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class LoginDaoImplement implements LoginDao {

    public static List<String> loginCollection = new ArrayList<>();

    public List<String> readDataFromFile() {
      try{
      File file = new File("login.csv");
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line = null;
       while ((line = reader.readLine()) != null){
         loginCollection.add(line);
       }
     }
     catch (Exception ex){
     System.out.println("File not found");
     }
     /*Testowanie czy informacje z pliku się ładuja do listy*/
     System.out.println(loginCollection);
   }
    // public static void main(String[] args) {
    //   loginCollection();
    // }
}
