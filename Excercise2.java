import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class KeywordCollector{
    private Set<String> se = new HashSet<>();
    public boolean addKeyWord(String keyWord){
        if(this.se.contains(keyWord)) return false;
        this.se.add(keyWord);
        return true;
    }
    public void displayAll(){
        int cnt = this.se.size();
        System.out.println("-> DANH SÁCH TỪ KHÓA DUY NHẤT (" + cnt + " từ):");
        StringBuilder sb = new StringBuilder();
        for (String keyword : this.se) {
            sb.append("- ").append(keyword).append(" | ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 3);
        }
        System.out.println(sb.toString());
    }
}

public class Excercise2{
    private static Scanner sc = new Scanner(System.in);
    private static KeywordCollector kc = new KeywordCollector();
    public static void main(String[] args){
        System.out.println("--Hệ thống từ điển HashSet--");
        while(true){
            System.out.print("Nhập từ : ");
            String word = sc.nextLine();
            if(kc.addKeyWord(word)){
                System.out.printf("[Thêm %s] -> Thành công. \n", word);
            }
            else{
                System.out.printf("[Thêm %s] -> Bỏ qua vì từ này đã tồn tại. \n", word);
            }
            String option;
            while(true){
                System.out.print("Nhập continue để tiếp tục hoặc exit để rời đi. ");
                option = sc.nextLine();
                if(option.equals("continue") || option.equals("exit")) break;
                System.out.println("Không đúng định dạng. ");
            }
            if(option.equals("exit")) break;
        }
        kc.displayAll();
    }
}
