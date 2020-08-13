/**
 * @author: alangong
 * @create: 2020-08-13 22:59
 * @description:
 **/
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = null;
        int step = 0;
        while (fast != null) {
            step++;
            fast = fast.next;
            if (step == n + 1) slow = head;
            if (step > n + 1) slow = slow.next;
        }
        if (slow == null) {
            head = head.next;
            return head;
        }
        slow.next = slow.next.next;
        return head;
    }
}
