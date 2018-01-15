package src.dao;

import src.models.AdminModel;
import java.util.List;
import java.util.ArrayList;

public class AdminDAOImplement implements AdminDAO {

    public List<AdminModel> adminCollection = new ArrayList<AdminModel>();

    public AdminModel readDataFromFile() {
        AdminModel newAdmin = new AdminModel("admin1", "password", "Jerzy", "Mardaus");
        return newAdmin;
    }
    public void saveDataToFile(List<AdminModel> adminCollection) {}
    public void addObject(AdminModel object) {}
    public void deleteObject(AdminModel object) {}
}
