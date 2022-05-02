package com.example.personaproject;

import android.os.Parcel;
import android.os.Parcelable;

public class Task implements Parcelable {

    private int code;
    private String name;
    private String description;
    private int points;
    private String section;

    public Task(){

    }

    public Task(String namep, String descriptionp, int pointsp, String sectionp){
        name = namep;
        description = descriptionp;
        points = pointsp;
        section = sectionp;
    }

    protected Task(Parcel in) {
        code = in.readInt();
        name = in.readString();
        description = in.readString();
        points = in.readInt();
        section = in.readString();
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(code);
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeInt(points);
        parcel.writeString(section);
    }
}
