package dao;

import models.ArtefactModel;

import java.util.List;
import java.util.ArrayList;


public class ArtefactDAOImplement implements ArtefactDAO {

    public List<ArtefactModel> artefactCollection = new ArrayList<ArtefactModel>();

    public List<ArtefactModel> readDataFromFile() { return artefactCollection; }
    public void saveDataToFile(List<ArtefactModel> artefactCollection) {}
    public void addObject(ArtefactModel object) {}
    public void deleteObject(ArtefactModel object) {}
}
