package org.HW_15;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DataHandler {
    Map<Integer, String> map = new DataRepository().getData();

    public String grtAll() {
        StringBuilder sb = new StringBuilder();
        AtomicInteger count = new AtomicInteger(0);
        map.forEach((id, name) ->
                sb.append(String.format("%d) %d, %s\n", count.incrementAndGet(), id, name)));
        return "\nAll NAMES:\n" + sb;
    }

    public String getById(int id) {
        if (map.containsKey(id)) {
            return "\nNAME: id " + id + ", " + map.get(id);
        } else return "No data!";
    }
}
