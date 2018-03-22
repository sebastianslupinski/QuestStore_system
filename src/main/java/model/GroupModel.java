package model;

import model.StudentModel;

import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupModel that = (GroupModel) o;
        return groupId == that.groupId &&
                mentor_id == that.mentor_id &&
                Objects.equals(name, that.name) &&
                Objects.equals(students, that.students);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, groupId, mentor_id, students);
    }
}