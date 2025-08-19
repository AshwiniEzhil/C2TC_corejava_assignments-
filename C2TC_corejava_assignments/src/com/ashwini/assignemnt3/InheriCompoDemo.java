package com.ashwini.assignemnt3;

public class InheriCompoDemo {
    public static void main(String[] args) {
        // Inheritance demo
        Book book1 = new Book(101, "Java Basics", "James Gosling");
        Maganize mag1 = new Maganize(201, "Tech Today", 45);

        book1.displayInfo();
        mag1.displayInfo();

        // Composition demo
        Library library = new Library();
        library.addItem(book1);
        library.addItem(mag1);

        library.showAllItems();
    }
}



	

