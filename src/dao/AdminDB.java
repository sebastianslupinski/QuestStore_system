package dao;

public interface AdminDB {

    public void findAllDataOfAdmin(int admin_id);
    public void insertAdminData(String name, String lastname, String email);

  
}
