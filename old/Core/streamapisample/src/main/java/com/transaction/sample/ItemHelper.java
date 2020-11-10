package com.transaction.sample;

import java.util.ArrayList;
import java.util.List;

public class ItemHelper {

    public static List<Item> buildItemsList(){
        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            itemList.add(new Item(i));
        }

        return  itemList;
    }

    public static  List<Item> removeAllTest(List<Item> itemList){
        List<Item> operatedList = new ArrayList<>();

        itemList.stream()
                .filter(item -> item.isQualified())
                .forEach(item -> {
                    item.operate();
                    operatedList.add(item);
                });

        itemList.removeAll(operatedList);

        return itemList;
    }

}
