package src.dao;

import src.models.ArtefactModel;
import java.util.List;

public interface ArtefactDAO {

    public List<ArtefactModel> readDataFromFile();
    public void saveDataToFile(List<Artefact> artefactCollection);
    public void addObject(ArtefactModel object);
    public void deleteObject(ArtefactModel object);
}