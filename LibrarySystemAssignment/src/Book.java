
/********************************************
 * Name:      Bryan Mellado                  *
 * Course:    CEN 3024C                      *
 * Purpose:   LMS                       *
 * Date:      5 /17 /2024               *
 ********************************************
 * Class Function:
 * Book object class as far as function goes this merely houses every aspect of a book.
 * A book has a title, author and id.
 * This is also used for display purposes during the method displayAllBooks().
 *
 */
class Book {
    //Fields
    private String title;
    private Author author;
    private int identification;

    public int getIdentification() {
        return identification;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String toString() {
        return identification + "." + title + "," + author.toString();
    }

    public void setIdentification(int newId) {
        this.identification = newId;
    }
}
