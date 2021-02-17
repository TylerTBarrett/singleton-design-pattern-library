/**
 * 
 * @author Tyler Barrett
 * 
 */

 import java.util.*;

public class Library {
    private HashMap<String, Integer> books = new HashMap<String, Integer>();
    private static Library library;

    private Library() {}

    public static Library getInstance() {
        if (library == null) {
            System.out.println("Creating our Library. Time to begin reading.");
            library = new Library();
        }
        return library;
    }

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

    public void checkInBook(String bookname, int copies) {
        if (books.containsKey(bookname)) {
            books.replace(bookname, (books.get(bookname) + copies));
            System.out.println("A new copy of " + bookname + " was added to the library");
        } else {
            books.put(bookname, copies);
            System.out.println(bookname + " was added to the library");
        }
    }

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
