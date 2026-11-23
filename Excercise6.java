import java.util.*;


class WordCounter{
    private HashMap<String, Integer> map = new HashMap<>();
    public void counter(String s){
        String[] str = s.split("\s+");
        for(var x : str){
            if(!map.containsKey(x)) map.put(x, 1);
            else map.put(x, map.get(x) + 1);
        }
    }
    public void display(){
        List<Map.Entry<String, Integer>> list = new ArrayList<>(this.map.entrySet());
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             BẢNG THỐNG KÊ TẦN SUẤT TỪ NGỮ             |");
        System.out.println("+-------------------------------------------------------+");
        System.out.printf("| %-20s | %-31s |%n", "Từ khóa", "Số lần xuất hiện");
        System.out.println("+---------------------+---------------------------------+");

        for (var x : list) {
            System.out.printf("| %-20s | %-31s |%n",
                    x.getKey(),
                    x.getValue() + " lần");
        }

        System.out.println("+---------------------+---------------------------------+");
    }
}

public class Excercise6 {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int test = Integer.parseInt(sc.nextLine());
        while(test > 0){
            String line = sc.nextLine();
            WordCounter wc = new WordCounter();
            wc.counter(line);
            wc.display();
            test--;
        }
    }
}
