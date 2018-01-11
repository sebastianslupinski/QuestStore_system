package dao;
import models.AdminModel;
import java.util.List;

public interface AdminDAO {

    public List<AdminModel> readDataFromFile();
    public void saveDataToFile(List<AdminModel> adminCollection);
    public void addObject(AdminModel object);
    public void deleteObject(AdminModel object);
}