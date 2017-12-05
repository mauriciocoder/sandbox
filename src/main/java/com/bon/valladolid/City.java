package com.bon.valladolid;

import javafx.util.Pair;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.*;
import java.util.stream.IntStream;

@Builder
@ToString
public class City {
    @Getter
    private List<Intersection> map;

    public void addToMap(int[] street, int distance) {
        if (map == null) {
            clearMap();
        }
        boolean exists0 = false, exists1 = false;
        int inter0 = street[0], inter1 = street[1];
        for (Intersection i : map) {
            if (inter0 == i.getId()) {
                i.setNextDistance(street[1], distance);
                exists0 = true;
            } else if (inter1 == i.getId()) {
                i.setNextDistance(street[0], distance);
                exists1 = true;
            }
        }
        if (!exists0) {
            Intersection i = Intersection.builder().id(inter0).build();
            i.setNextDistance(inter1, distance);
            map.add(i);
        }
        if (!exists1) {
            Intersection i = Intersection.builder().id(inter1).build();
            i.setNextDistance(inter0, distance);
            map.add(i);
        }
    }

    public void clearMap() {
        map = new ArrayList<>();
    }

    public Intersection getIntersection(int id) {
       Objects.requireNonNull(map);
       for (Intersection i : map) {
            if (i.getId() == id) {
                return i;
            }
       }
       throw new RuntimeException("Intersection not found");
    }

    private int findShortestDistance(Intersection current, int destinyId, Set<Integer> traversedIntersections) {
        if (current.getId() == destinyId) {
            return 0;
        }
        HashSet<Integer> traversed = new HashSet<>(traversedIntersections);
        traversed.add(current.getId());
        Map<Integer, Integer> everyNext = current.getEveryNext();
        List<Integer> distances = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : everyNext.entrySet()) {
            int nextId = entry.getKey();
            int nextDistance = entry.getValue();
            if (!traversed.contains(nextId)) {
                int nextShortestDistance = findShortestDistance(getIntersection(nextId), destinyId, traversed);
                if (nextShortestDistance == -1) {
                    continue;
                }
                int d = nextDistance + nextShortestDistance;
                distances.add(d);
            }
        }
        return distances.size() > 0 ? Collections.min(distances) : -1;  // -1 all next already traversed
    }

    public int findShortestDistance(int idSource, int idDestiny) {
        Intersection source = getIntersection(idSource);
        return findShortestDistance(source, idDestiny, new HashSet<>());
    }

    public int findLongestFromShortestDistances(int intersectionsQty) {
        List<Pair<Integer, Integer>> allPossiblePairs = new ArrayList<>();
        for (int i = 0; i < intersectionsQty; i++) {
            for (int j = 0; j < intersectionsQty; j++) {
                boolean exists = false;
                for (Pair<Integer, Integer> p : allPossiblePairs) {
                    if (p.getKey() == j && p.getValue() == i) {
                        exists = true;
                        break;
                    }
                }
                if (exists) {
                    continue;
                }
                allPossiblePairs.add(new Pair<>(i, j));
            }
        }
        List<Integer> distances = new ArrayList<>();
        for (Pair<Integer, Integer> p : allPossiblePairs) {
            int d = findShortestDistance(p.getKey(), p.getValue());
            distances.add(d);
        }
        return Collections.max(distances);
    }
}
