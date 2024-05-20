
/********************************************
 * Name:      Bryan Mellado                  *
 * Course:    CEN 3024C                      *
 * Purpose:   LMS                       *
 * Date:      5 /17 /2024               *
 ********************************************
 * Class Function:
 * Heart of the program, it creates a menu for the user, where the user may intereact with the program to do this programs intended functions.
 * This class also houses the method for actually extracting the .txt files imported by the user.
 *
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
    //Fields
    private Scanner input = new Scanner(System.in);
    private ArrayList<Book> books;
    private Library library;


    /*
    Name: Menu
    Explanation:
    Constructor initializes books and library and runs another method
    Arguments: None
    Return Values: Not even Void
     */
    public Menu() {
        books = new ArrayList<>();
        library = new Library();
        createMenu();
    }//no arg Constructor


    /*
    Name: createMenu
    Explanation:
    This method first creates the variables myOptions of data type int
    from there, the user is presented with a menu that is fully functional and allows the user to
    select from options 1-4 to do the listed any of the 4 listed actions.
    This menu will always run after every option until the menu is closed and should account for bad inputs.
    Arguments: None
    Return Values: Void

     */
    public void createMenu() {
        int myOptions = 0;
        do {
            System.out.println(
                    "[1] Add New Books to Library (from file)\n" +
                            "[2] Remove a Book\n" +
                            "[3] Display all Books\n" +
                            "[4] Exit\n" +
                            "Enter your selection:"
            );


            try {
                myOptions = input.nextInt();
                switch (myOptions) {
                    case 1: // Add Book to Existing Library
                        addBooksFromFile();
                        break;
                    case 2: // Remove Book from Existing Library
                        System.out.print("Enter the ID of the book you would like to remove: ");
                        int bookToRemove = input.nextInt();
                        library.removeBook(bookToRemove);
                        break;
                    case 3: // Display Library
                        if (books.isEmpty()) {
                            System.out.println("Ain't Nobody Here But Us Chickens (Try adding a .txt file to the library!) ");
                            System.out.println();
                        } else
                            library.displayAllBooks();

                        break;
                    case 4:
                        System.out.println("Exiting Program...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option! Let's Try Again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                input.nextLine();
            }

        } while (myOptions != 4);

    }//end method createMenu


    /*
    Name: addBooksFromFile()
    Explanation:
    This method starts by asking the user for the .txt file path they would like to import
    the program then proceeds to use BufferedReader and beings trying to extract
    each line of the text file and stops when a line contains no information.
    Trims whitespaces from each line
    While the lines are being read they are put in String data type line and broken down into
    pieces starting by first breaking down the line into two pieces which are
    ID and author in one piece and author name in the other piece.
    it then breaks down the ID and title into two pieces which are obviously the two.
    The id is then turn into an integer checking if the id already exists in the library.
    Then creates the Book and Author objects to set up their respective fields.
    Add book to a list of books and also to the library with its unique ID.
    The program will tell the user if formatting for the lines is incorrect,
    if the book IDs are already present in the library,
    and general exceptions if the file reading goes wrong for any reason.
    Arguments: None
    Return Values: Void


     */
    private void addBooksFromFile() {
        System.out.print("Enter the path of the text file: ");
        input.nextLine();
        String filePath = input.nextLine();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    String[] idAndTitle = parts[0].split("\\.", 2);
                    if (idAndTitle.length == 2) {
                        int bookId = Integer.parseInt(idAndTitle[0].trim());
                        if (library.checkNewId(bookId)) {
                            String title = idAndTitle[1].trim();
                            String authorName = parts[1].trim();

                            Book newBook = new Book();
                            newBook.setTitle(title);
                            Author author = new Author(authorName);
                            newBook.setAuthor(author);

                            books.add(newBook);
                            library.addBook(newBook, bookId);
                        } else {
                            System.out.println("Book with ID " + bookId + " already exists in the library.");
                        }
                    } else {
                        System.out.println("Invalid format in the file: " + line);
                    }
                } else {
                    System.out.println("Invalid format in the file: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }//end method addBooksFromFile



}

