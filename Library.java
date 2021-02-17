/**
 * A data structure representing a library of books, of which there can be only one
 * @author Tyler Barrett
 * 
 */

 import java.util.*;

public class Library {
    private HashMap<String, Integer> books = new HashMap<String, Integer>();
    private static Library library;

    /**
     * Constructs Library, part of the singleton design pattern
     */
    private Library() {}

    /**
     * Checks if any instance of Library exists and returns that if so, otherwise constructs a new Library
     * @return Library returns the singular instance of Library that exists
     */
    public static Library getInstance() {
        if (library == null) {
            System.out.println("Creating our Library. Time to begin reading.");
            library = new Library();
        }
        return library;
    }

    /**
     * Will check to see if the library has the inputted name of a book in stock and 
     * checks it out if so.
     * @return boolean denoting whether the book is in stock or not
     */
    public boolean checkoutBook(String bookname) {
        boolean inStock = false;
      //  int numcopies = library.get(bookname);
        if (books.containsKey(bookname) && books.get(bookname) > 0) {
            inStock = true;
            System.out.println(bookname + " was successfully checked out");
            books.replace(bookname, (books.get(bookname) - 1));
        } else {
            System.out.println(bookname + " is not in stock");
        }
        return inStock;
    }

    /**
     * Checks in a book, adding it to the library based on the passed parameters.
     * @param String indicating the name of the book to be input
     * @param integer indicating the number of copies to be input into the library
     */
    public void checkInBook(String bookname, int copies) {
        if (books.containsKey(bookname)) {
            books.replace(bookname, (books.get(bookname) + copies));
            System.out.println("A new copy of " + bookname + " was added to the library");
        } else {
            books.put(bookname, copies);
            System.out.println(bookname + " was added to the library");
        }
    }

    /**
     * Displays all the books currently in the library along with the number of 
     * copies there are
     */
    public void displayBooks() {
        System.out.println("Inventory:");
        Iterator iterator = books.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry tempelement = (Map.Entry)iterator.next();
            String tempstr = (String)tempelement.getKey();
            int tempint = (int)tempelement.getValue();
            System.out.println("  - " + tempstr + ", copies: " + tempint);
        }
    }
}
