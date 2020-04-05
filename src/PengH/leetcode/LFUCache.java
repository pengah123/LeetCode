package PengH.leetcode;

import java.util.*;

/*460,LFU缓存*/
public class LFUCache {
    //    存放键值对
    HashMap<Integer, Integer> map = new HashMap<>();
    //存放键所对应的读取次数
    HashMap<Integer, Integer> num = new HashMap<>();
    //    存放最近访问的
    HashMap<Integer, Integer> c = new HashMap<>();

    int cap;
    int count = 0;

    public LFUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
//        如果包含键，则返回值，并且访问次数加一
        if (map.containsKey(key)) {
            int value = num.get(key);
            value++;
//            更新访问次数
            num.put(key, value);
//            记录是第几次访问到
            c.put(key, count++);

            return map.get(key);
        } else return -1;
    }

    public void put(int key, int value) {
        if(cap==0)
            return;
        if(!map.containsKey(key)){
            if (map.size() >= cap) {
//            找到访问次数最少为min次
                int min = Integer.MAX_VALUE;
                for (Integer values : num.values()) {
                    min = min < values ? min : values;
                }
//            找到为min次的键集合
                List<Integer> keymin = new ArrayList<>();
                for (Integer keys : num.keySet()) {
                    if (num.get(keys) == min)
                        keymin.add(keys);
                }
//            如果集合大小为1，删除这个键
                if (keymin.size() == 1) {
                    map.remove(keymin.get(0));
                    num.remove(keymin.get(0));
                    c.remove(keymin.get(0));
                }
//            如果大于1，比较这些键对应的count,删除count最小的键
                else {
                    int countmin = Integer.MAX_VALUE;
                    int currentkey=0;
                    for (Integer integer : keymin) {
                        int valuecount = c.get(integer);
                        if (valuecount < countmin) {
                            countmin = valuecount;
                            currentkey = integer;
                        }
                    }

                    map.remove(currentkey);
                    num.remove(currentkey);
                    c.remove(currentkey);
                }
            }
            map.put(key, value);
            num.put(key, 1);
            c.put(key,count++);
        }
        else{
            map.put(key, value);
            c.put(key,count++);
            int numvalue = num.get(key);
            numvalue++;
//            更新访问次数
            num.put(key, numvalue);
        }
    }
}
