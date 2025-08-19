package com.ashwini.assignemnt3;

public class Libraryitem {
    private int id;
    private String title;

    public Libraryitem(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public void displayInfo() {
        System.out.println("ID: " + id + ", Title: " + title);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}



