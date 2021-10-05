package com.example.alarmsoundview.model;

public class Sound {
    private int id = 0;
    private String uri = "";
    private String soundName = "";
    private boolean isPersonal = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getSoundName() {
        return soundName;
    }

    public void setSoundName(String soundName) {
        this.soundName = soundName;
    }

    public void setPersonal(boolean personal) {
        isPersonal = personal;
    }

    public String getName() {
        return soundName;
    }

    public String getUri() {
        return uri;
    }

    public boolean isPersonal() {
        return isPersonal;
    }
}
