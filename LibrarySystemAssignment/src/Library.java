
/********************************************
 * Name:      Bryan Mellado                  *
 * Course:    CEN 3024C                      *
 * Purpose:   LMS                       *
 * Date:      5 /17 /2024               *
 ********************************************
 * Class Function:
 * This class houses every function when accounting for multiple books, it accounts for duplicate IDs.
 * Removing books,
 * Displaying Books,
 * and of course Adding Books.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;

class Library {
    //Fields
    private ArrayList<Book> books;
    private Set<Integer> usedIds;


    /*
    Name: Library()
    Explanation:
    Constructor initializes books and usedIds
    Arguments: None
    Return Values: Not even Void
     */
    public Library() {
        books = new ArrayList<>();
        usedIds = new HashSet<>();
    }


    /*
    Name: displayAllBooks()
    Explanation:
    Uses a for loop that Prints out all the books in the library.
    Arguments: None
    Return Values: Void
     */
    public void displayAllBooks() {
        System.out.println("Books in the library:");
        for (Book book : books)
            System.out.println(book);


    }


    /*
    Name: removeBook
    Explanation:
    We have a collection of books, an iterator is needed to retrieve the next book in the collection to
    check if the passed user input variable bookId matches any of the IDs of a Book object in the arrayList of Books.
    Creates the removed variable removed of the boolean data type to keep track of whether the users inputted id was actually able to remove the book.
    If it isn't successful, the user will be told so, if the iterator successfully matches the bookId with a Books Identification
    it is removed, the removed variable is changed to true, as well as the deleted book's id is removed from the hashset of usedIds.

    Arguments: int
    Return Values: Void
     */
    public void removeBook(int bookId) {
        Iterator<Book> iterator = books.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getIdentification() == bookId) {
                iterator.remove();
                removed = true;
                usedIds.remove(bookId);
                System.out.println("Book " + bookId + " has been removed.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Book with ID " + bookId + " is not found in the library.");
        }
    }


    /*
    Name: addBook
    Explanation:
    Sets the id variable for a book object.
    Adds that book object to the books arrayList.
    Adds id variable to a hashset that keeps track of every new ID and tells the user that the implementation of this book was successful and includes the ID of that book.
    Arguments: Object Book and wrapper class Integer
    Return Values: Void
     */
    public void addBook(Book book, Integer newID) {
        book.setIdentification(newID);
        books.add(book);
        usedIds.add(newID);
        System.out.println("Book added successfully with ID " + newID + ".");
    }


    /*
    Name: checkNewId
    Explanation:
    Checks the hashset usedIds for any duplicate IDs
    Arguments: int
    Return Values: boolean
     */
    public boolean checkNewId(int id) {
        return !usedIds.contains(id);
    }


}//end class Library

