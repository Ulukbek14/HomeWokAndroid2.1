package com.example.homewokandroid21;

import java.io.Serializable;

public class TaskModel implements Serializable {
    String title, description;

    public TaskModel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
