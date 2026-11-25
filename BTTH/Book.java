package BTTH;

public class Book{
    private String isbn;
    private String title;
    private String author;
    private int year;
    public Book(String isbn, String title, String author, int year){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
    }
    public String getISBN(){
        return this.isbn;
    }
    public String getAuthor(){
        return this.author;
    }
    public String getTitle(){
        return this.title;
    }
    public int getYear(){
        return this.year;
    }
}
