// CrossOver2
package com.bon.sand;
import java.io.IOException;
import java.util.*;

public class CrossOver2 {

    static boolean isBalanced(String str) {
        Stack<Character> tagstack = new Stack<Character>();
        boolean isBalanced = false;
        String s = str.trim();
        for(int i = 0; i < s.length(); i++) {
            if(str.charAt(i) == '<')
                tagstack.push('<');
            if(str.charAt(i) == '>') {
                if (tagstack.isEmpty())
                    return isBalanced;
                else
                    tagstack.pop();
            }
        }
        if(tagstack.isEmpty())
            isBalanced = true;
        return isBalanced;
    }

    /**
     * Complete the function below.
     * DO NOT MODIFY anything outside this method.
     */
    static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {
        List<Integer> result = new ArrayList<>();
        if (expressions != null && expressions.length > 0) {
            for (int i = 0; i < expressions.length; i++) {
                int maxRepl = maxReplacements[i];
                String exp = expressions[i];
                if (isBalanced(exp)) {
                    result.add(i, 1);
                } else {
                    // faz tudo aqui dentro
                    String[] exploded = exp.split("");
                    int opens = 0;
                    int maxCount = maxRepl;
                    for (int j = 0; j < exploded.length; j++) {
                        if (exploded[j].equalsIgnoreCase("<")) {
                            opens++;
                        } else if (exploded[j].equalsIgnoreCase(">")) {
                            if (opens > 0) {
                                opens--;
                            } else {
                                if (maxCount > 0) {
                                    maxCount--;
                                    exploded[j] = "<>";
                                } else {
                                    // Nao consegue se tornar balanceada
                                }
                            }
                        }
                    }
                    String join = String.join("", exploded);
                    result.add(isBalanced(join) ? 1 : 0);
                }
            }
        }
        //System.out.println(result);
        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }

    /**
     * DO NOT MODIFY THIS METHOD!
     */
    public static void main(String[] args) throws IOException
    {

        Scanner in = new Scanner(System.in);
        int[] res;

        int _expressions_size = 0;
        _expressions_size = Integer.parseInt(in.nextLine().trim());
        String[] _expressions = new String[_expressions_size];
        String _expressions_item;
        for(int _expressions_i = 0; _expressions_i < _expressions_size; _expressions_i++) {
            try {
                _expressions_item = in.nextLine();
            } catch (Exception e) {
                _expressions_item = null;
            }
            _expressions[_expressions_i] = _expressions_item;
        }


        int _maxReplacements_size = 0;
        _maxReplacements_size = Integer.parseInt(in.nextLine().trim());
        int[] _maxReplacements = new int[_maxReplacements_size];
        int _maxReplacements_item;
        for(int _maxReplacements_i = 0; _maxReplacements_i < _maxReplacements_size; _maxReplacements_i++) {
            _maxReplacements_item = Integer.parseInt(in.nextLine().trim());
            _maxReplacements[_maxReplacements_i] = _maxReplacements_item;
        }

        res = balancedOrNot(_expressions, _maxReplacements);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }
    }


}
