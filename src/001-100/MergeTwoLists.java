/**
 * @author: alangong
 * @create: 2020-08-14 00:26
 * @description:
 **/
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        // 谁第一个元素小以谁为基准
        ListNode ans = null;
        ListNode p = null;
        boolean first = true;
        while (l1 != null && l2 != null) {
            if (first) {
                if (l1.val <= l2.val) {
                    ans = l1;
                    l1 = l1.next;
                } else {
                    ans = l2;
                    l2 = l2.next;
                }
                p = ans;
                first = false;
            } else {
                if (l1.val <= l2.val) {
                    p.next = l1;
                    p = p.next;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    p = p.next;
                    l2 = l2.next;
                }
            }
        }
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return ans;
    }
}
