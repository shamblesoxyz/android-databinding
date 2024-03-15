package com.assignment.sqlite;

import java.io.Serializable;

public class NoteModel implements Serializable {
    private int id;
    private String task;

    public NoteModel(int id, String task) {
        this.id = id;
        this.task = task;
    }

    public NoteModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
