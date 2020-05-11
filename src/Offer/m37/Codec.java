package Offer.m37;

import Offer.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*你可以将以下二叉树：

    1
   / \
  2   3
     / \
    4   5

序列化为 "[1,2,3,null,null,4,5]"
*/
public class Codec {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode l1=new TreeNode(2);
        TreeNode r1=new TreeNode(3);
        TreeNode l2=new TreeNode(4);
        TreeNode r2=new TreeNode(5);
        root.left=l1;
        root.right=r1;
        r1.left=l2;
        r1.right=r2;
        Codec codec = new Codec();
        String s = codec.serialize(root);
        codec.deserialize(s);
        System.out.println(s);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "[]";
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        StringBuilder sb = new StringBuilder("[");
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = que.poll();
                if (poll != null) {
                    sb.append(poll.val + "").append(",");
                } else {
                    sb.append("null,");
                    continue;
                }
                que.offer(poll.left);
                que.offer(poll.right);
            }
        }
        sb.delete(sb.length()-1,sb.length());
        sb.append("]");
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        String[] strings = data.substring(1, data.length() - 1).split(",");
        int i = 0;
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strings[i++]));
        que.offer(root);
        while (!que.isEmpty()) {
            int size=que.size();
            for (int j = 0; j < size; j++) {
                TreeNode poll = que.poll();
                if (poll == null) {
                    continue;
                }
                if (strings[i].equals("null")) {
                    poll.left = null;
                } else {
                    TreeNode nodeleft = new TreeNode(Integer.parseInt(strings[i]));
                    poll.left = nodeleft;
                    que.offer(nodeleft);
                }
                i++;
                if (strings[i].equals("null")) {
                    poll.right = null;
                } else {
                    TreeNode noderight = new TreeNode(Integer.parseInt(strings[i]));
                    poll.right = noderight;
                    que.offer(noderight);
                }
                i++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
