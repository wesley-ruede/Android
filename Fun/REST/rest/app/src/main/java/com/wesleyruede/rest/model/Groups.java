package com.wesleyruede.rest.model;

public class Groups {
    private int id;
    private String groupDay;
    private String groupName;
    private String groupStartTime;
    private String groupEndTime;

    public Groups(int id, String groupDay, String groupName, String groupStartTime, String groupEndTime) {
        this.id = id;
        this.groupDay = groupDay;
        this.groupName = groupName;
        this.groupStartTime = groupStartTime;
        this.groupEndTime = groupEndTime;
    }

    public Groups() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupDay() {
        return groupDay;
    }

    public void setGroupDay(String groupDay) {
        this.groupDay = groupDay;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupStartTime() {
        return groupStartTime;
    }

    public void setGroupStartTime(String groupStartTime) {
        this.groupStartTime = groupStartTime;
    }

    public String getGroupEndTime() {
        return groupEndTime;
    }

    public void setGroupEndTime(String groupEndTime) {
        this.groupEndTime = groupEndTime;
    }
}