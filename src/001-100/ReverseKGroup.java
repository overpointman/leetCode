/**
 * @author: alangong
 * @create: 2020-08-14 11:27
 * @description:
 **/
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 虚拟节点
        ListNode pre = new ListNode(-1);
        pre.next = head;
        if (k > 1) {
            reverse(head, pre, k);
        }
        return pre.next;
    }

    private void reverse(ListNode head, ListNode pre, int k) {
        // 有足够的元素才翻转
        if (isOk(head, k)) {
            ListNode i = head;
            ListNode j = i.next;
            for (int n = 1; n < k; n++) {
                ListNode temp = j.next;
                j.next = i;
                i = j;
                j = temp;
            }
            head.next = j;
            pre.next = i;
            reverse(j, head, k);
        }
    }

    private boolean isOk(ListNode head, int k) {
        int count = 0;
        while (head != null) {
            count++;
            if (count >= k) return true;
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        System.out.println(reverseKGroup.reverseKGroup(l1, 2));
    }
}
