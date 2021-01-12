package com.gitlab.johnjvester.jpaspec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ProgramBase {

    public static void main(String[] args) {

        ObservableList.Listener listener = new ObservableList.Listener() {
            @Override
            public void onItemsAdded(ObservableList source, Collection items) {
                System.out.println("add");
            }

            @Override
            public void onItemsRemoved(ObservableList source, Collection items) {
                System.out.println("added.");
            }

            @Override
            public void onStracturalChange(ObservableList source) {
                System.out.println("onStracturalChange");
            }
        };

        List<String> list = new ArrayList<>();
        list.add("1");

        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        list2.add("3");

        ObservableList observableList = new ObservableList(list);
        observableList.addListener(listener);

        observableList.add(list2);





    }
}
