package model;

import model.StudentModel;

import java.util.ArrayList;

public class GroupModel{

    private String name;
    private int groupId;
    private int mentor_id;
    private ArrayList<StudentModel> students;

    public GroupModel(String name, int groupId, int mentor_id, ArrayList students){
        this.name = name;
        this.groupId = groupId;
        this.mentor_id = mentor_id;
        this.students = students;
    }

    public ArrayList<StudentModel> getStudents() {
        return students;
    }

    public int getGroupId(){
        return this.groupId;
    }

}