package com.example.ahmedakram.luxorguide;

public class Item {
    private int name;
    private int des;
    private String link;
    private int imageID = -1;

    public Item(int name, int des, int imageID, String link) {
        this.name = name;
        this.des = des;
        this.imageID = imageID;
        this.link = link;
    }

    public int getName() {
        return name;
    }

    public int getDes() {
        return des;
    }

    public int getImageID() {
        return imageID;
    }

    public String getLink() {
        return link;
    }

    public boolean hasImage() {
        return imageID != -1;
    }
}
