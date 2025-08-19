package com.ashwini.assignemnt3;

public class Maganize extends Libraryitem {
    private int issueNumber;

    public Maganize(int id, String title, int issueNumber) {
        super(id, title);
        this.issueNumber = issueNumber;
    }

    @Override
    public void displayInfo() {
        System.out.println("Magazine: [ID: " + getId() + ", Title: " + getTitle() + ", Issue: " + issueNumber + "]");
    }

    public int getIssueNumber() {
        return issueNumber;
    }
}


