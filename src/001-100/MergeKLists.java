import java.util.ArrayList;
import java.util.List;

/**
 * @author: alangong
 * @create: 2020-08-14 09:24
 * @description:
 **/
public class MergeKLists {
    private ListNode head = null;
    private boolean first  = true;
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        mergeKLists(null, lists);
        return head;
    }

    private void mergeKLists(ListNode cur, ListNode[] lists) {
        int minIndex = -1;
        for (int i = 0; i < lists.length; i++) {
            if (minIndex == -1 && lists[i] != null) {
                minIndex = i;
            }
            if (lists[i] != null && lists[i].val < lists[minIndex].val) {
                minIndex = i;
            }
        }
        if (minIndex == -1) return;
        if (first) {
            head = lists[minIndex];
            first = false;
        } else {
            cur.next = lists[minIndex];
        }
        cur = lists[minIndex];
        lists[minIndex] = lists[minIndex].next;
        mergeKLists(cur, lists);
    }

    public static void main(String[] args) {
        MergeKLists mergeKLists = new MergeKLists();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l3.next = l4;
        ListNode[] lists = new ListNode[]{l1, l3};
        mergeKLists.mergeKLists(lists);
    }
}
