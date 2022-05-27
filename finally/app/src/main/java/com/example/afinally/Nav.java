package com.example.afinally;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import io.realm.RealmObject;

public class Nav extends RealmObject {

    String title;
    String description;
    long creationTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }


}