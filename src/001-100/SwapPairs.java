/**
 * @author: alangong
 * @create: 2020-08-14 11:04
 * @description:
 **/
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode i = head;
        ListNode j = head.next;
        // 虚拟节点
        ListNode pre = new ListNode(-1);
        pre.next = i;
        head = j == null ? i : j;
        while(i != null && j != null) {
            i.next = j.next;
            j.next = i;
            pre.next = j;
            pre = i;
            i = i.next;
            j = i == null ? null : i.next;
        }
        return head;
    }
}
