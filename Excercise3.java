import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Dictionary{
    private Map<String, String> dic = new HashMap<>();
    public void addDictionary(String eng, String vie){
        this.dic.put(eng, vie);
    }
    public String translate(String eng){
        if(this.dic.containsKey(eng)) return this.dic.get(eng);
        return "Từ này chưa tồn tại trong từ điển. ";
    }
    public void deleteWord(String eng){
        this.dic.remove(eng);
    }
}

public class Excercise3{
    private static Scanner sc = new Scanner(System.in);
    private static Dictionary dic = new Dictionary();
    public static void main(String[] args){
        while(true){
            System.out.println("Hệ thống từ điển. ");
            System.out.println("1. Cập nhật thêm từ. ");
            System.out.println("2. Dịch. ");
            System.out.println("3. Xóa bỏ từ. ");
            System.out.println("0. Thoát. ");
            System.out.print("Nhập lựa chọn của bạn: ");
            String option = sc.nextLine();
            switch(option){
                case "1":
                    while(true){
                        System.out.println("Thêm từ vào từ điển. ");
                        System.out.print("Thêm từ: ");
                        String eng = sc.nextLine();
                        System.out.print("Dịch nghĩa: ");
                        String vie = sc.nextLine();
                        dic.addDictionary(eng, vie);
                        System.out.println("Đã thêm thành công. ");
                        String exit;
                        while(true){
                            System.out.print("Nhập continue để tiếp tục hoặc exit để rời đi: ");
                            exit = sc.nextLine();
                            if(exit.equals("continue") || exit.equals("exit")) break;
                            System.out.println("Không đúng định dạng. ");
                        }
                        if(exit.equals("exit")) break;
                    }
                    break;
                case "2":
                    while(true){
                        System.out.print("Nhập từ cần dịch: ");
                        String eng = sc.nextLine();
                        System.out.printf("kết quả: %s\n", dic.translate(eng));
                        String exit;
                        while(true){
                            System.out.print("Nhập continue để tiếp tục hoặc exit để rời đi: ");
                            exit = sc.nextLine();
                            if(exit.equals("continue") || exit.equals("exit")) break;
                            System.out.println("Không đúng định dạng. ");
                        }
                        if(exit.equals("exit")) break;
                    }
                    break;
                case "3":
                    while(true){
                        System.out.print("Nhập từ cần xóa: ");
                        String eng = sc.nextLine();
                         dic.deleteWord(eng);
                        String exit;
                        while(true){
                            System.out.print("Nhập continue để tiếp tục hoặc exit để rời đi: ");
                            exit = sc.nextLine();
                            if(exit.equals("continue") || exit.equals("exit")) break;
                            System.out.println("Không đúng định dạng. ");
                        }
                        if(exit.equals("exit")) break;
                    }
                    break;
                case "0":
                    System.exit(0);
                default:
                    System.out.println("Định dang không đúng. ");
            }
        }
    }
}
