enum BookMedium {
    EBook, AudioBook, PhysicalBook, Softback;
}
enum BookGenre {
    Fiction, NonFiction, Horror, SciFi, Romance;
}
enum BookRating {
    Rating1, Rating2, Rating3, Rating4, Rating5;
}



class Book{
    private String title;
    private String author;
    private String publishedDate;
    private String readDate;
    private BookMedium bookMedian;
    private BookGenre bookGenre;
    private BookRating bookRating;

    Book(String title, String author, BookGenre bookGenre){
        setTitle(title);
        setAuthor(author);
        setBookGenre(bookGenre);
    }

    Book(String title, String author, BookGenre bookGenre, int publicationDate){
        setTitle(title);
        setAuthor(author);
        setBookGenre(bookGenre);
        setPublishedDate(publicationDate);
    }

    Book(String title, String author, BookGenre bookGenre, int publicationDate,int readDate,BookMedium bookMedium, BookRating bookRating){
        setTitle(title);
        setAuthor(author);
        setBookGenre(bookGenre);
        setPublishedDate(publicationDate);
        setReadDate(readDate);
        setBookMedium(bookMedium);
        setBookRating(bookRating);
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }
    
    public void setAuthor(String author){
        this.author = author;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getPublishedDate(){
        return this.publishedDate;
    }
    public void setPublishedDate(int publishedDate){
        this.publishedDate = String.format("%04d", publishedDate);
    }

    public String getReadDate(){
        return this.readDate;
    }
    public void setReadDate(int readDate){
        this.readDate = String.format("%04d", readDate);
    }

    public String getPublishDate(){
        return this.publishedDate;
    }

    public void setBookMedium(BookMedium bookMedium){
        this.bookMedian = bookMedium;
    }

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

    public void setBookGenre(BookGenre bookGenre){
        this.bookGenre = bookGenre;
    }

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

    public void setBookRating(BookRating bookRating){
        this.bookRating = bookRating;
    }

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

    public BookRating getRating(){
        return this.bookRating;
    }

    public String toString(){
        String message;
        if(this.getReadDate() != null && this.getMedium() != null && this.bookRating != null && this.publishedDate != null){
            message = getTitle() + " by " + getAuthor() + " (" + getPublishDate()+ ") - read in " + getReadDate() + ", rated " + getR();  ;
        }else if(this.publishedDate != null){
            message = getTitle() + " by " + getAuthor() + " (" + getPublishDate()+ ")" ;
        }else{
            message = getTitle() + " by " + getAuthor() ;
        }
        return message;
    }   


    public static void main(String[] args) {
Book b1 = new Book("Children of Time", "Adrian Tchaikovsky", BookGenre.Fiction);
System.out.println(b1);
Book b2 = new Book("The Fifth Season", "N. K. Jemesin", BookGenre.Fiction, 2015);
System.out.println(b2);
Book b3 = new Book("Perdido Street Station", "China Mieville", BookGenre.Fiction, 2000, 2020, BookMedium.EBook, BookRating.Rating5);
System.out.println(b3);
    }

}