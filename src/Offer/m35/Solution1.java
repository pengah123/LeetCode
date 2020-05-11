package Offer.m35;

import Offer.Node;

/*请实现 copyRandomList 函数，复制一个复杂链表。
在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
还有一个 random 指针指向链表中的任意节点或者 null。

输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
*/
public class Solution1 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node orign = head;
        generate(orign);
        add(orign);
        Node copy = getCopy(orign);
        return copy;
    }

    public void generate(Node head) {
        Node orign = head;
        while (orign != null) {
            Node copy = new Node(orign.val);
            copy.next = orign.next;
            copy.random = null;
            orign.next = copy;
            orign = copy.next;
        }
    }

    public void add(Node head) {
        Node orign = head;
        while (orign != null) {
            Node cloneNode = orign.next;
            if (orign.random != null) {
                cloneNode.random = orign.random.next;
            }
            orign = cloneNode.next;
        }
    }

    public Node getCopy(Node head) {
        Node orign = head;
        Node copy = orign.next;
        orign.next=copy.next;
        orign=orign.next;
        Node result = copy;
        while (orign != null) {
            copy.next = orign.next;
            orign.next = orign.next.next;
            orign = orign.next;
            copy = copy.next;
        }
        return result;
    }
}
