package com.bon.valladolid;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.HashMap;
import java.util.Map;

@Builder
@ToString
public class Intersection {
    @Getter
    @Setter
    private int id;

    @Setter
    private Map<Integer, Integer> next;     // next intersection id -> distance

    public int getNextDistance(int id) {
        return next.get(id);
    }

    public void setNextDistance(int id, int distance) {
        if (next == null) {
            next = new HashMap<>();
        }
        next.put(id, distance);
    }

    public Map<Integer, Integer> getEveryNext() {
        return next != null ? next : new HashMap<>();
    }
}
