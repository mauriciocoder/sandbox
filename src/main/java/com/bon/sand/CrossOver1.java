// CrossOver1
package com.bon.sand;

import java.util.*;

public class CrossOver1 {

    static int[] rearrange(int[] elements) {
        Map<Integer, List<Integer>> maps = new HashMap<>();
        if (elements != null && elements.length > 0) {
            for (int i = 0; i < elements.length; i++) {
                String valBin = Integer.toBinaryString(elements[i]);
                String[] split = valBin.split("");
                int count = 0;
                for (int j = 0; j < split.length; j++) {
                    if (split[j].equalsIgnoreCase("1")) {
                        count++;
                    }
                }
                List<Integer> sameOnes = maps.get(count);
                if (sameOnes == null) {
                    sameOnes = new ArrayList<>();
                }
                sameOnes.add(elements[i]);
                maps.put(count, sameOnes);
            }
        }
        List<Integer> result = new ArrayList<>();
        SortedSet<Integer> keys = new TreeSet<Integer>(maps.keySet());
        for (Integer key : keys) {
            List<Integer> current = maps.get(key);
            Collections.sort(current);
            //Collections.reverse(current);
            for (Integer c : current) {
                result.add(c);
            }
        }

        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }

        return r;

    }



    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int[] res;

        int _elements_size = 0;
        _elements_size = Integer.parseInt(in.nextLine().trim());
        int[] _elements = new int[_elements_size];
        int _elements_item;
        for(int _elements_i = 0; _elements_i < _elements_size; _elements_i++) {
            _elements_item = Integer.parseInt(in.nextLine().trim());
            _elements[_elements_i] = _elements_item;
        }

        res = rearrange(_elements);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }
    }
}
