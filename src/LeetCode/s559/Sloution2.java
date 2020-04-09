package LeetCode.s559;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*广度优先遍历*/
public class Sloution2 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        int layer = 1;
        while (!que.isEmpty()) {
            layer++;
            int size = que.size();
            for(int i=0;i<size;i++){
                Node croot = que.poll();
                for (Node child : croot.children) {
                    que.offer(child);
                }
            }
        }
        return layer;
    }
}
