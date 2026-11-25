package BTFIVE;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BTfive{
    public static void main(String[] args){
        int max_size = 5;
        Map<String, String> map = new LinkedHashMap<>(max_size, 0.75f){
            @Override
            public boolean removeEldestEntry(Map.Entry<String, String> eldest){
                return size() > max_size;
            }
        };
        map.put("Dau", "123"); // Map bản chăt ở đây là biến tham chiếu đến đối tượng là con của LinkedHashMap
        map.put("Tao", "234");
        map.put("Le", "109");
        map.put("Man", "204");
        map.put("Buoi", "345");

        // thêm phân tử thứ 5 vào
        map.put("Hoa", "000");
        String line = map.get("le");
        System.out.println(map);
    }
}
