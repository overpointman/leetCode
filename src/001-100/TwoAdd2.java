/**
 * @author: alangong
 * @create: 2020-08-05 21:25
 * @description:
 **/
public class TwoAdd2 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode pre = null;
        boolean init = true;
        int addFlag = 0;
        while (l1 != null || l2 != null || addFlag != 0) {
            ListNode cur = new ListNode((getValue(l1) + getValue(l2) + addFlag) % 10);
            if (init) {
                head = cur;
                init = false;
            }
            addFlag = (getValue(l1) + getValue(l2) + addFlag) / 10;
            if (pre != null) {
                pre.next = cur;
            }
            pre = cur;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head;
    }

    private int getValue(ListNode node) {
        if (node == null) {
            return 0;
        }
        return node.val;
    }
}


