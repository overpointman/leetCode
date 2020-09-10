/**
 * @author: alangong
 * @create: 2020-08-25 15:27
 * @description:
 **/
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head.next, slow = head;
        while (fast != null && slow != null) {
            if (fast == slow) return true;
            fast = fast.next == null ? null : fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
