package com.ashwini.assignemnt3;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Libraryitem> items;

    public Library() {
        items = new ArrayList<>();
    }

    public void addItem(Libraryitem item) {
        items.add(item);
    }

    public void showAllItems() {
        System.out.println("Library contains:");
        for (Libraryitem item : items) {
            if (item instanceof Book) {
                Book b = (Book) item;
                System.out.println("- " + b.getTitle() + " by " + b.getAuthor());
            } else if (item instanceof Maganize) {
                Maganize m = (Maganize) item;
                System.out.println("- " + m.getTitle() + " Issue " + m.getIssueNumber());
            }
        }
    }
}

