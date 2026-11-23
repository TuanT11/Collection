import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

enum priority{
    ƯU_TIÊN,
    THƯỜNG
}

class CheckNumber{
    public static boolean checkNumber(String value){
        try{
            Double res = Double.parseDouble(value);
            return true;
        } catch(Exception e){
            return false;
        }
    }
}

class Product{
    private String id;
    private String name;
    private double price;
    private priority pr;
    public Product(String id, String name, priority br, double price){
        this.id = id;
        this.name = name;
        this.pr = br;
        this.price = price;
    }
    public String toString(){
        return this.id + "|" + this.name + "|"  + this.price;
    }
    public String getPriority(){
        return pr.toString();
    }
}

class ProductLine{
    private LinkedList<Product> line = new LinkedList<>();
    public void addHighPriority(Product p){
        this.line.addFirst(p);
    }
    public void addMormalPriority(Product p ){
        this.line.addLast(p);
    }
    public void displayProduct(){
        Iterator<Product> it = line.iterator();
        while(it.hasNext()){
            System.out.println(it.toString());
        }
    }
}


public class Excercise4{
    private static Scanner sc = new Scanner(System.in);
    private static ProductLine line = new ProductLine();
    public static void main(String[] args){
        while(true){
            System.out.println("--- QUẢN LÝ DÂY CHUYỀN SẢN XUẤT ---");
            System.out.println("1. Thêm thường. ");
            System.out.println("2. Thêm ưu tiên. ");
            System.out.println("3. Xem danh sách sản phẩm.");
            System.out.println("4. Thoát. ");
            System.out.print("Lựa chọn của bạn: ");
            String option = sc.nextLine();
            switch (option){
                case "1":
                    themThuong();
                    break;
                case "2" :
                    themUuTien();
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.print("Không hợp lệ");
            }
        }
    }
    public static void themThuong(){
        while(true){
            String id, name, price;
            boolean ok = true;
            System.out.println("--- THÊM THƯỜNG ---");
            while(true){
                System.out.println("Mã ( theo: SP-XX, X là số): ");
                id = sc.nextLine();
                if(!id.isEmpty()){
                    String part = id.substring(2);
                    if(CheckNumber.checkNumber(part)) break;
                    System.out.println("Vui lòng đúng kí tự số !");
                }
                else{
                    System.out.println("Mã SP không để trống !");
                }
            }
            while(true){
                System.out.println("Tên: ");
                name = sc.nextLine();
                if(name.isEmpty()){
                    System.out.print("Tên SP không được để trống !");
                    continue;
                }
                break;
            }
            while(true){
                System.out.println("Giá sản phẩm: ");
                price = sc.nextLine();
                if(CheckNumber.checkNumber(price)) break;
                System.out.println("Vui lòng đúng giá sản phẩm !");
            }
            Product prod = new Product(id, name, priority.ƯU_TIÊN, Double.parseDouble(price));
            line.addHighPriority(prod);
            while(true){
                System.out.println("Lệnh continue / exit : ");
                String next = sc.nextLine();
                switch (next){
                    case "continue":
                        break;
                    case "exit":
                        ok = false;
                        break;
                    default:
                        System.out.println("Vui lòng nhập đúng lệnh ! ");
                }
                if(!ok) break;
            }
            if(!ok) break;
        }
    }
    public static void themUuTien(){
        while(true){
            String id, name, price;
            boolean ok = true;
            System.out.println("--- THÊM ƯU TIÊN ---");
            while(true){
                System.out.println("Mã ( theo: SP-XX, X là số): ");
                id = sc.nextLine();
                if(!id.isEmpty()){
                    String part = id.substring(2);
                    if(CheckNumber.checkNumber(part)) break;
                    System.out.println("Vui lòng đúng kí tự số !");
                }
                else{
                    System.out.println("Mã SP không để trống !");
                }
            }
            while(true){
                System.out.println("Tên: ");
                name = sc.nextLine();
                if(name.isEmpty()){
                    System.out.print("Tên SP không được để trống !");
                    continue;
                }
                break;
            }
            while(true){
                System.out.println("Giá sản phẩm: ");
                price = sc.nextLine();
                if(CheckNumber.checkNumber(price)) break;
                System.out.println("Vui lòng đúng giá sản phẩm !");
            }
            Product prod = new Product(id, name, priority.ƯU_TIÊN, Double.parseDouble(price));
            line.addHighPriority(prod);
            while(true){
                System.out.println("Lệnh continue / exit : ");
                String next = sc.nextLine();
                switch (next){
                    case "continue":
                        break;
                    case "exit":
                        ok = false;
                        break;
                    default:
                        System.out.println("Vui lòng nhập đúng lệnh ! ");
                }
                if(!ok) break;
            }
            if(!ok) break;
        }
    }
}

