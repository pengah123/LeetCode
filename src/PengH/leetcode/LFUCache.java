package PengH.leetcode;

import java.util.*;

/*460,LFU����*/
public class LFUCache {
    //    ��ż�ֵ��
    HashMap<Integer, Integer> map = new HashMap<>();
    //��ż�����Ӧ�Ķ�ȡ����
    HashMap<Integer, Integer> num = new HashMap<>();
    //    ���������ʵ�
    HashMap<Integer, Integer> c = new HashMap<>();

    int cap;
    int count = 0;

    public LFUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
//        ������������򷵻�ֵ�����ҷ��ʴ�����һ
        if (map.containsKey(key)) {
            int value = num.get(key);
            value++;
//            ���·��ʴ���
            num.put(key, value);
//            ��¼�ǵڼ��η��ʵ�
            c.put(key, count++);

            return map.get(key);
        } else return -1;
    }

    public void put(int key, int value) {
        if(cap==0)
            return;
        if(!map.containsKey(key)){
            if (map.size() >= cap) {
//            �ҵ����ʴ�������Ϊmin��
                int min = Integer.MAX_VALUE;
                for (Integer values : num.values()) {
                    min = min < values ? min : values;
                }
//            �ҵ�Ϊmin�εļ�����
                List<Integer> keymin = new ArrayList<>();
                for (Integer keys : num.keySet()) {
                    if (num.get(keys) == min)
                        keymin.add(keys);
                }
//            ������ϴ�СΪ1��ɾ�������
                if (keymin.size() == 1) {
                    map.remove(keymin.get(0));
                    num.remove(keymin.get(0));
                    c.remove(keymin.get(0));
                }
//            �������1���Ƚ���Щ����Ӧ��count,ɾ��count��С�ļ�
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
//            ���·��ʴ���
            num.put(key, numvalue);
        }
    }
}
