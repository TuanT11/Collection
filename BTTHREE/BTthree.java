package BTTHREE;

import java.util.LinkedList;
import java.util.Scanner;

class SearchHistoryManager{
    private LinkedList<String> list = new LinkedList<>();
    public void addSearchKeyword(String keyword){
        if(list.size() == 5){
            list.removeLast();
        }
        else{
            if(!list.contains(keyword)){
                list.addFirst(keyword);
            }
            else{
                int idx = list.indexOf(keyword);
                for(int i = list.indexOf(keyword); i < list.size(); i++){
                    if(list.get(i) == keyword){
                        idx = i;
                    }
                }
                String tmp = list.remove(idx);
                list.addFirst(tmp);
            }
        }
    }
    public void display(){
        for(var x : list){
            System.out.println(x);
        }
    }
}

public class BTthree {
    private static Scanner sc = new Scanner(System.in);
    private static SearchHistoryManager shm = new SearchHistoryManager();
    public static void main(String[] args) {
        int ts = Integer.parseInt(sc.nextLine());
        while(ts > 0){
            String line = sc.nextLine();
            shm.addSearchKeyword(line);
            ts--;
        }
        shm.display();
    }
}
