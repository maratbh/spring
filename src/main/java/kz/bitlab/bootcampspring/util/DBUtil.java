package kz.bitlab.bootcampspring.util;

import kz.bitlab.bootcampspring.model.Item;

import java.util.ArrayList;

public class DBUtil {

    private static ArrayList<Item> items = new ArrayList<>();

    private static Long id = 5L;

    static {
        items.add(new Item(1L, "IPhone 13", 400000, 20, "iphone-13-pro"));
        items.add(new Item(2L, "IPhone 12", 300000, 10, "iphone-12-pro-max"));
        items.add(new Item(3L, "IPhone 11", 250000, 30, "iphone-11-middle"));
        items.add(new Item(4L, "IPhone 10", 200000, 50, "iphone-10-simple"));
    }

    public static Item addItem(Item item){
        item.setId(id);
        items.add(item);
        id++;
        return item;
    }

    public static Item getItem(Long id){
        return items.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }

    public static ArrayList<Item> getItems(){
        return items;
    }

}
