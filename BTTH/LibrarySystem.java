package BTTH;

import java.util.*;
public class LibrarySystem {
    private Set<String> isbnSet = new HashSet<>();
    private Map<String, Integer>  borrowCountMap = new HashMap<>();
    private List<Book> bookList = new ArrayList<>();

    public boolean checkISBN(String isbn){
        if(this.isbnSet.contains(isbn)) return true;
        return false;
    }

    public void borrowBook(String isbn){
        this.borrowCountMap.put(isbn, this.borrowCountMap.get(isbn) + 1);
    }

    public boolean checkAdd(Book product){
        if(checkISBN(product.getISBN())){
            return false;
        }
        else{
            isbnSet.add(product.getISBN());
            bookList.add(product);
            borrowCountMap.put(product.getISBN(), 0);
            return true;
        }
    }
    public void display(){
        int WIDTH = 72;
        String ROW_FORMAT = "| %-14s | %-22s | %-13s | %-13s | %-12s |%n";
        String border = "+" + "=".repeat(WIDTH) + "+";
        String separator = "|" + "-".repeat(16) + "+" + "-".repeat(24) + "+"
                + "-".repeat(15) + "+" + "-".repeat(14) + "|";
        System.out.println(border);
        System.out.printf("|%16s%-56s|%n", "", "DANH SÁCH SÁCH THƯ VIỆN RIKKEI LIBRARY");
        System.out.println(border);
        System.out.printf(ROW_FORMAT, "ISBN", "Tiêu Đề", "Tác Giả","Năm Suất Bản", "Lượt Mượn");
        System.out.println(separator);
        for(var x : this.bookList){
            System.out.printf(ROW_FORMAT, x.getISBN(), x.getTitle(), x.getAuthor(), x.getYear(), borrowCountMap.get(x.getISBN()).toString());
        }
        System.out.println(border);
    }
    public boolean recordBorrowBook(String isbn){
        if(this.isbnSet.contains(isbn)){
            this.borrowCountMap.put(isbn, this.borrowCountMap.get(isbn) + 1);
            return true;
        }
        else return false;
    }

    public void sortBookList(){
        List<Book> list = new ArrayList<>(this.bookList);
        Collections.sort(list, new YearComparator());
        int WIDTH = 72;
        String ROW_FORMAT = "| %-14s | %-22s | %-13s | %-13s | %-12s |%n";
        String border = "+" + "=".repeat(WIDTH) + "+";
        String separator = "|" + "-".repeat(16) + "+" + "-".repeat(24) + "+"
                + "-".repeat(15) + "+" + "-".repeat(14) + "|";
        System.out.println(border);
        System.out.printf("|%16s%-56s|%n", "", "DANH SÁCH SÁCH THƯ VIỆN RIKKEI LIBRARY");
        System.out.println(border);
        System.out.printf(ROW_FORMAT, "ISBN", "Tiêu Đề", "Tác Giả","Năm Suất Bản", "Lượt Mượn");
        System.out.println(separator);
        for(var x : list){
            System.out.printf(ROW_FORMAT, x.getISBN(), x.getTitle(), x.getAuthor(), x.getYear(), borrowCountMap.get(x.getISBN()).toString());
        }
        System.out.println(border);
    }
    public void StatisticBook(){
        int maxn = 0;
        String isbn = "XXXXX";
        List<Map.Entry<String, Integer>> list = new ArrayList<>(this.borrowCountMap.entrySet());
        for(var x : list){
            if(maxn < x.getValue()){
                maxn = x.getValue();
                isbn = x.getKey();
            }
        }
        int WIDTH = 72;
        String ROW_FORMAT = "| %-14s | %-22s | %-13s | %-13s | %-12s |%n";
        String border = "+" + "=".repeat(WIDTH) + "+";
        String separator = "|" + "-".repeat(16) + "+" + "-".repeat(24) + "+"
                + "-".repeat(15) + "+" + "-".repeat(14) + "|";
        System.out.println(border);
        System.out.printf("|%16s%-56s|%n", "", "DANH SÁCH SÁCH THƯ VIỆN RIKKEI LIBRARY ĐƯỢC BÁN NHIỀU NHẤT ");
        System.out.println(border);
        System.out.printf(ROW_FORMAT, "ISBN", "Tiêu Đề", "Tác Giả","Năm Suất Bản", "Lượt Mượn");
        System.out.println(separator);
        if(isbn.equals("XXXXX")){
            System.out.println("HIỆN TẠI CHƯA CÓ SÁCH NÀO ĐƯỢC MƯỢN ");
        }
        else{
            for(var x : this.bookList){
                if(x.getISBN().equals(isbn)){
                    System.out.printf(ROW_FORMAT, x.getISBN(), x.getTitle(), x.getAuthor(), x.getYear(), borrowCountMap.get(x.getISBN()).toString());
                }
            }
        }
        System.out.println(border);
    }
}

