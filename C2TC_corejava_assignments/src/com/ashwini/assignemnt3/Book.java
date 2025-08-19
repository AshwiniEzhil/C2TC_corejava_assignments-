package com.ashwini.assignemnt3;

public class Book extends Libraryitem {
    private String author;

    public Book(int id, String title, String author) {
        super(id, title);
        this.author = author;
    }

    @Override
    public void displayInfo() {
        System.out.println("Book: [ID: " + getId() + ", Title: " + getTitle() + ", Author: " + author + "]");
    }

    public String getAuthor() {
        return author;
    }
}


