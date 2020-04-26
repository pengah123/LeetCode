package Offer;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode AddListNode(int n) {
        ListNode list = this;
        while (list.next != null) {
            list = list.next;
        }
        list.next = new ListNode(n);
        return this;
    }

    @Override
    public String toString() {
        ListNode list = this;
        StringBuilder builder = new StringBuilder("ListNode{" + val);
        while (list.next != null) {
            list = list.next;
            builder.append("," + list.val);
        }
        builder.append("}");
        return builder.toString();
    }
}
