package com.example.alarmsoundview.activity.selectsound;

public class BuiltInSound {
    private boolean checked = false;
    private String name;
    private int id;

    public BuiltInSound(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
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
