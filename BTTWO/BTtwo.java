package BTTWO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class FindBarCodeException extends RuntimeException{
    public FindBarCodeException(String context){
        super(context);
    }
}

class Product{
    private String name;
    private String barCode;
    public Product(String name, String barCode){
        this.name = name;
        this.barCode = barCode;
    }
    public String getName(){
        return this.name;
    }
    public String getBarCode(){
        return this.barCode;
    }
}

class ProductCache{
    private HashMap<String, Product> productMap = new HashMap<>(16);
    public void loadData(List<Product> list){
        for(var x : list){
            this.productMap.put(x.getBarCode(), x);
        }
    }
    public Product findByBarCode(String barCode){
        try{
            if(this.productMap.containsKey(barCode)){
                return this.productMap.get(barCode);
            }
            throw new FindBarCodeException(String.format("Mã sản phẩm không tồn tại ", barCode));
        } catch (FindBarCodeException e) {
            e.
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            return null;
        }
    }
}

public class BTtwo {
    private static ProductCache cache = new ProductCache();
    public static void main(String[] args) {
        Product a = new Product("123", "Dau");
        Product b = new Product("234", "Muoi");
        Product c = new Product("345", "Sua");
        List<Product> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        cache.loadData(list);
        cache.findByBarCode("789");
    }
}
