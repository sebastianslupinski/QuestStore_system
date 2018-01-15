package src.dao;
import src.models.AdminModel;
import java.util.List;

public interface AdminDAO {

    public AdminModel readDataFromFile();
    public void saveDataToFile(List<AdminModel> adminCollection);
    public void addObject(AdminModel object);
    public void deleteObject(AdminModel object);
}
