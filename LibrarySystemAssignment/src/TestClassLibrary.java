import java.awt.*;
import java.util.ArrayList;

/********************************************
 * Name:      Bryan Mellado                  *
 * Course:    CEN 3024C                      *
 * Purpose:   LMS                       *
 * Date:      5 /17 /2024               *
 ********************************************
 * Class Function:
 * Creates object Menu which in turn creates the proper arrayLists and starts up the menu for the user to interact with.
 *
 * Project Function:
 * This Java program
 *This Java program's intended function is to present the user with a menu.
 * From this menu, they are given 4 options: add a text file with proper formatting for the creation of books (ID.Title.AuthorName) that are to be loaded into a library.
 * The second option is to remove books from the library via each book's unique ID, while also letting the user know if that ID is present in the library.
 * The third option is to display every book in the library that was extracted from the text file, while also taking into account whether there are books in the library or not.
 * Finally, the fourth option allows the user to exit the program.
 * This program doesn't shut down until the user exits the program themselves, and the user will always be taken back to the menu until the fourth option is chosen.
 * This program should take into account runtime errors, so crashes should not be present and should prevent duplicate IDs and invalid file formats when extracting .txt files.
 *


 AI Citation:
 I had problems with getting the IDs of Books into the library because I wanted to keep OOP, as in I wanted to associate
 the books object class as singular thing and have any functions or interactions that devel into relationships of more than one book in the library class.
 This conviction was seriously test when it came to the ids because every book has an id
 but, I also needed a way to make the book Ids unique and actually compare them which, was this weird grey area of both the library and book classes.

 As such lines 143-153 in the Menu were assisted with the use of AI.
 Technically, you could argue that a lot of the lines that work off the book or the library arrayList are also AI assisted
 because I will inform you now that didn't intend to make more than one arrayList and have functions for more than one arrayList but,
 regardless on how that effects my grade it's certainly better than explusion.
 */
public class TestClassLibrary {

    /*
    Name: main
    Explanation:
    creates the Menu object and fires up the Menu() method
    Arguments: None
    Return Values: Void
     */
    public static void main(String[] args) {
        Menu myMenu = new Menu();
    }// end method Main


}//end class TestClassLibrary
