package com.example.alarmsoundview.activity.selectsound;

public class BuiltInSound {
    private boolean checked = false;
    private String name;
    private int id;

    public BuiltInSound(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void setChecked() {
        checked = true;
    }
    public void setUnchecked() {
        checked = false;
    }

    public boolean isChecked() {
        return checked;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
