package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution460 {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache( 0 /* capacity (????????)*/  );
        HashMap<Integer,Integer> map=cache.map;
        HashMap<Integer,Integer> num=cache.num;
        HashMap<Integer,Integer> count=cache.c;
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // ???? 1
        cache.put(3, 3);    // ??? key 2
        cache.get(2);       // ???? -1 (δ???key 2)
        cache.get(3);       // ???? 3
        cache.put(4, 4);    // ??? key 1
        cache.get(1);       // ???? -1 (δ??? key 1)
        cache.get(3);       // ???? 3
        cache.get(4);       // ???? 4

        System.out.println(map);
        System.out.println(num);
        System.out.println(count);

    }
}
