package BTONE;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Product{
    private int quantity;
    public Product(int quantity){
        this.quantity = quantity;
    }
    public int quantity(){
        return this.quantity;
    }
    public String toString(){
        return String.format("Số lượng sản phẩm là %d", this.quantity);
    }
}

class CartService{
    public static void removeOutOfStock(List<Product> list){
        Iterator<Product> it = list.iterator();
        while(it.hasNext()){
            if(it.next().quantity() == 0){
                it.remove();
            }
        }
    }
    public static void display(List<Product> list){
        for(var x : list){
           System.out.println( x.toString());
        }
    }
}

public class BTOne{
    public static void main(String[] args){
        Product a = new Product(10);
        Product b = new Product(100);
        Product c = new Product(1000);
        Product d = new Product(0);
        List<Product> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        CartService.removeOutOfStock(list);
        CartService.display(list);
    }
}