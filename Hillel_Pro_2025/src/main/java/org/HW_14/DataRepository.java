package org.HW_14;

import java.util.ArrayList;
import java.util.List;

public class DataRepository {
    public List<String> getData() {
        List<String> list = new ArrayList<>();
        list.add("Alice");
        list.add("Bob");
        list.add("Lucy");
        list.add("Danis");
        list.add("Tom");

        return list;
    }
}
