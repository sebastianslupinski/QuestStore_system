package dao;

import models.AdminModel;
import java.util.List;
import java.util.ArrayList;

public class AdminDAOImplement implements AdminDAO {

    public List<AdminModel> adminCollection = new ArrayList<AdminModel>();

    public List<AdminModel> readDataFromFile() { return adminCollection; }
    public void saveDataToFile(List<AdminModel> adminCollection) {}
    public void addObject(AdminModel object) {}
    public void deleteObject(AdminModel object) {}
}