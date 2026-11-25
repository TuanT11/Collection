package BTTH;

import java.util.Comparator;

public class YearComparator implements Comparator<Book> {
    @Override
    public int compare(Book a, Book b){
        return a.getYear() - b.getYear();
    }
}
