package PengH.leetcode;

/*
*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
* */
//注意：ListNode节点的next不为空时，很容易发生空指针异常，解决办法就是新建一个节点加上去，而不是直接对节点赋值
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode result = new ListNode(0);
        ListNode curr = result;
        int sum = 0;
        while (p != null || q != null) {
            int x = 0;
            int y = 0;
            x = p != null ? p.val : 0;
            y = q != null ? q.val : 0;
            sum = sum+x + y;
            ListNode ne = new ListNode(sum % 10);
            curr.next = ne;
            curr=curr.next;
            sum /= 10;
            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;
        }
        if (sum != 0) {
            ListNode ne = new ListNode(sum);
            curr.next = ne;
        }
        return result.next;
    }
}

