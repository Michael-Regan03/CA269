/** 
 * @author reganm25
*/

enum BookMedium {
    EBook, AudioBook, PhysicalBook, Softback;
}
enum BookGenre {
    Fiction, NonFiction, Horror, SciFi, Romance;
}
enum BookRating {
    Rating1, Rating2, Rating3, Rating4, Rating5;
}

/** 
 * Class Book is the parent class of PublishedBook and the ancestor of ReadBook
*/
class Book{
    /** 
    *The Title the book
    */
    private String title;
    /** 
    *The person who wrote the book
    */
    private String author;
    /** 
    *The genre of the book
    */
    private BookGenre bookGenre;

    /** 
    *constructor for generic book
    *@param title,author,bookGenre
    */
    Book(String title, String author, BookGenre bookGenre){
        setTitle(title);
        setAuthor(author);
        setBookGenre(bookGenre);
    }
    /** 
    *sets the title of the book
    *@param title
    */
    public void setTitle(String title){
        this.title = title;
    }
    /**
    * gets the Title of the book
    *@return The title of the book
    */
    public String getTitle(){
        return this.title;
    }
    /**
    * sets the author of the book
    *@param author 
    */
    public void setAuthor(String author){
        this.author = author;
    }
    /**
     * gets the author of the book
    *@return the author of the book
    */
    public String getAuthor(){
        return this.author;
    }
    /**
     * sets the books genre
     * @param bookGenre
     */
    public void setBookGenre(BookGenre bookGenre){
        this.bookGenre = bookGenre;
    }

    /**
     * gets the genre of the book
     * @return the genre of the book
     */
    public String getGenre(){
        if(this.bookGenre == BookGenre.Fiction){
            return "Fiction";
        }else if(this.bookGenre == BookGenre.NonFiction){
            return "NonFiction";
        }else if(this.bookGenre == BookGenre.SciFi){
            return "Sci-fi";
        }else{
            return "Romance";
        }
        
    }

    /**
     * @returns "Title" by "Author"
     */
    public String toString(){
        String message = getTitle() + " by " + getAuthor() ;
        return message;
    }   


    public static void main(String[] args) {
        Book b1 = new Book("Children of Time", "Adrian Tchaikovsky", BookGenre.Fiction);
        System.out.println(b1);
        Book b2 = new PublishedBook("The Fifth Season", "N. K. Jemesin", BookGenre.Fiction, 2015);
        System.out.println(b2);
        Book b3 = new ReadBook("Perdido Street Station", "China Mieville", BookGenre.Fiction, 2000, 2020, BookMedium.EBook, BookRating.Rating5);
        System.out.println(b3);
    }

}

/** 
 * Class PublishedBook is the child class of Book
*/
class PublishedBook extends Book{
    /** 
    *The date the book was published
    */
    private String publishedDate;
    /** 
    *The median the book is read on
    */
    private BookMedium bookMedian;

    /** 
    *Constructor for published book
    *  @parma title,author,bookGenre,publicationDate
    */
    PublishedBook(String title, String author, BookGenre bookGenre, int publicationDate){
        super(title,author,bookGenre);
        setPublishedDate(publicationDate);
    }

    /**
     * gets the date the book was published
     * @return the date the book was published 
     */
    public String getPublishedDate(){
        return this.publishedDate;
    }

    /**
     * sets the date the book is published
     */
    public void setPublishedDate(int publishedDate){
        this.publishedDate = String.format("%04d", publishedDate);
    }
    
    /**
     * sets the date the median of the book
     */
    public void setBookMedium(BookMedium bookMedium){
        this.bookMedian = bookMedium;
    }

     /**
      * Gets the median of the book
     * @return the median of the book
     */
    public String getMedium(){
        if(this.bookMedian==BookMedium.EBook){
            return"EBook";
        }else if(this.bookMedian==BookMedium.AudioBook){
            return"AudioBook";
        }else if(this.bookMedian==BookMedium.Softback){
            return"Softback";
        }else{
            return"Physical book";
        }
    }

     /**
     * @return "Title" by "Author"("Published date")
     */
    public String toString(){
        String message = getTitle() + " by " + getAuthor() + " (" + getPublishedDate()+ ")" ;
        return message;
    }

    
}

/** 
 * Class PublishedBook is the child class PublishedClass and the ancestor of Book
*/
class ReadBook extends PublishedBook{
    /**
     * The date the book was read
     */
    private String readDate;
    /**
     * The rating of the book
     */
    private BookRating bookRating;

     /**
     * A constructor for ReadBook
     * @param title,author,bookGenre, publicationDate, readBate, bookMedium, bookRating
     */
    ReadBook(String title, String author, BookGenre bookGenre, int publicationDate,int readDate,BookMedium bookMedium, BookRating bookRating){
        super(title,author,bookGenre, publicationDate);
        setReadDate(readDate);
        setBookMedium(bookMedium);
        setBookRating(bookRating);
    }
    
    /**
     * gets the date the book was read
     * @return the date the book was read
     */
    public String getReadDate(){
        return this.readDate;
    }
    /**
     * sets the date the book was read
     */
    public void setReadDate(int readDate){
        this.readDate = String.format("%04d", readDate);
    }

    /**
     * sets the rating of the book 
     * @param bookRating
     */
    public void setBookRating(BookRating bookRating){
        this.bookRating = bookRating;
    }

    /**
     * Converts the rating of the book into the form X/5
     * @return X/5
     */
    public String getR(){
        if(this.bookRating == BookRating.Rating1){
            return "1/5";
        }else if(this.bookRating == BookRating.Rating2){
            return "2/5";
        }else if(this.bookRating == BookRating.Rating3){
            return "3/5";
        }else if(this.bookRating == BookRating.Rating4){
            return "4/5";
        }else if(this.bookRating == BookRating.Rating5) {
            return "5/5";
        }else return "";
        
    }

    /**
     * Gets the rating of the book
     * @return the rating of the book
     */
    public BookRating getRating(){
        return this.bookRating;
    }
    
    /**
     * @return "Title" by "Author"("published date") - read in "Read date", rated "Rating"
     */
    public String toString(){
        String message = getTitle() + " by " + getAuthor() + " (" + getPublishedDate()+ ") - read in " + getReadDate() + ", rated " + getR();
        return message;
    }

}
