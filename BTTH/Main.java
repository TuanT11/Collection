package BTTH;

import java.lang.runtime.SwitchBootstraps;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main{
    private static Scanner sc = new Scanner(System.in);
    private static LibrarySystem ls = new LibrarySystem();
    public static void main(String[] args){
        while(true){
            System.out.println("  HỆ THỐNG QUẢN LÝ THƯ VIỆN ĐA CẤU TRÚC - RIKKEI LIBRARY ");
            System.out.println(" 1. Thêm sách mới vào thư viện ");
            System.out.println(" 2. Hiển thị danh sách toàn bộ sách ");
            System.out.println(" 3. Ghi nhận mượn sách theo ISBN ");
            System.out.println(" 4. Sắp xếp danh sách sách theo Năm xuất bản giảm dần ");
            System.out.println(" 5. Thống kê Sách có lượt mượn nhiều nhất ");
            System.out.println(" 6. Thoát chương trình ");
            System.out.print(" Lựa chọn của bạn: ");
            String option = sc.nextLine();
            switch (option){
                case "1":
                    addBook();
                    break;
                case "2":
                    ls.display();
                    break;
                case "3":
                    break;
                case "4":
                    System.out.println(" Danh sách đã được sắp xếp");
                    ls.sortBookList();
                    break;
                case "5":
                    ls.StatisticBook();
                    break;
                case "6":
                    System.exit(0);
                    break;
                default:
                    System.out.println(" Giá trị không hợp lệ ");
            }
        }
    }

    public static void addBook(){
        while(true){
            String isbn, title, author;
            int year;
            while (true) {
                System.out.print("Nhập ISBN: ");
                isbn = sc.nextLine().trim();
                if (!isbn.isEmpty()) {
                    break;
                }
                System.out.println("ISBN không được để trống, nhập lại!");
            }

            while (true) {
                System.out.print("Nhập tiêu đề: ");
                title = sc.nextLine().trim();
                if (!title.isEmpty()) {
                    break;
                }
                System.out.println("Tiêu đề không được để trống, nhập lại!");
            }

            while (true) {
                System.out.print("Nhập tác giả: ");
                author = sc.nextLine().trim();
                if (!author.isEmpty()) {
                    break;
                }
                System.out.println("Tác giả không được để trống, nhập lại!");
            }

            while (true) {
                System.out.print("Nhập năm xuất bản: ");
                try {
                    year = Integer.parseInt(sc.nextLine().trim());
                    if (year >= 1000 && year <= LocalDate.now().getYear()) {
                        break;
                    }
                    System.out.println("Năm phải nằm trong khoảng 1000 đến năm hiện tại, nhập lại!");
                } catch (NumberFormatException e) {
                    System.out.println("Năm phải là số nguyên, nhập lại!");
                }
            }
            Book book = new Book(isbn, title, author, year);
            if(ls.checkAdd(book)){
                System.out.println("Thêm sách thành công!");
            }
            else{
                System.out.println("Thêm sách không thành công do mã đã tồn tại!");
            }
            String choice;
            while (true) {
                System.out.print("Nhập 'continue' để thêm tiếp, 'exit' để thoát: ");
                choice = sc.nextLine().trim().toLowerCase();
                if (choice.equals("continue") || choice.equals("exit")) {
                    break;
                }
                System.out.println("Chỉ được nhập continue hoặc exit!");
            }

            if (choice.equals("exit")) {
                break;
            }
        }
    }
    public static void recordBorrow(){
        while(true){
            String isbn;
            while (true) {
                System.out.print("Nhập ISBN: ");
                isbn = sc.nextLine().trim();
                if (!isbn.isEmpty()) {
                    break;
                }
                System.out.println("ISBN không được để trống, nhập lại!");
            }
            if(ls.checkISBN(isbn)){
                ls.borrowBook(isbn);
                System.out.println("Mượn thành công !");
            }
            else{
                System.out.println("Mã sản phẩm không tồn tại !");
            }
            String choice;
            while (true) {
                System.out.print("Nhập 'continue' để thêm tiếp, 'exit' để thoát: ");
                choice = sc.nextLine().trim().toLowerCase();
                if (choice.equals("continue") || choice.equals("exit")) {
                    break;
                }
                System.out.println("Chỉ được nhập continue hoặc exit!");
            }

            if (choice.equals("exit")) {
                break;
            }
        }
    }
}
