package dao;

import model.ArtefactModel;
import java.util.List;


public interface ArtefactDAO {

    public List readDataFromFile();
    public void saveDataToFile(List<ArtefactModel> artefactCollection);
    public void addObject(ArtefactModel object);
    public void deleteObject(ArtefactModel object);
}