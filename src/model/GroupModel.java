package model;

import model.StudentModel;

import java.util.ArrayList;

public class GroupModel{

    private String name;
    private int groupId;
    private String mentor_id;
    private ArrayList<StudentModel> students;

    public GroupModel(String name, int groupId, String mentor_id, ArrayList students){
        this.name = name;
        this.groupId = groupId;
        this.mentor_id = mentor_id;
        this.students = students;
    }

    public ArrayList<StudentModel> getStudents() {
        return students;
    }

}