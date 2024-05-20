
/********************************************
 * Name:      Bryan Mellado                  *
 * Course:    CEN 3024C                      *
 * Purpose:   LMS                       *
 * Date:      5 /17 /2024               *
 ********************************************
 * Class Function:
 * Author object class, its function to merely keep track of the author's name
 * As well as, for displaying purposes during the displayAllBooks() method.
 *
 */

public class Author {
    //Fields
    private String authorName;


    public Author(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String toString() {
        return authorName;
    }


}//end class Author
