import java.util.ArrayList;
import java.util.List;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
/*Facebook onsite.*/
public class MergeKSortedLists {

  public ListNode mergeKLists(ListNode[] lists) {
          var dummy = new ListNode();
          var cur = dummy;
          if (lists == null || lists.length <1) {
              return dummy.next;
          }
          var minHeap = new PriorityQueue<ListNode>(lists.length, (a, b)->{return a.val-b.val;});
          for(ListNode ln : lists) {
              if (ln != null) {
                  minHeap.offer(ln);
              }
          }
          while (minHeap.peek() != null) {
              var temp = minHeap.poll();
              if (temp.next != null) {
                  minHeap.offer(temp.next);
              }
              cur.next = temp;
              cur = cur.next;
          }
          return dummy.next;
      }

    // Merge two by two, it is pretty much like merge sort!
    // public ListNode mergeKLists(ListNode[] lists) {
    //     if (lists == null || lists.length == 0) {
    //         return null;
    //     }
    //     List<ListNode> res = new ArrayList<>();
    //     for (ListNode node : lists) {
    //         res.add(node);
    //     }
    //     while (res.size()>1) {
    //         List<ListNode> level = new ArrayList<>();
    //         for (int i=0; i+1<res.size(); i+=2) {
    //             ListNode merge = merge(res.get(i), res.get(i+1));
    //             level.add(merge);
    //         }
    //         if (res.size()%2 == 1) {
    //             level.add(res.get(res.size()-1));
    //         }
    //         res = level;
    //     }
    //     return res.get(0);
    // }
    //
    // private ListNode merge(ListNode n1, ListNode n2) {
    //     ListNode dummy = new ListNode(0);
    //     ListNode cur = dummy;
    //     while (n1!=null && n2!=null) {
    //         if (n1.val < n2.val) {
    //             cur.next = n1;
    //             n1 = n1.next;
    //         } else {
    //             cur.next = n2;
    //             n2 = n2.next;
    //         }
    //         cur = cur.next;
    //     }
    //     if (n1 == null) {
    //         cur.next = n2;
    //     } else {
    //         cur.next = n1;
    //     }
    //     return dummy.next;
    // }

    /* // Heap approach, put everything into a heap, and pop it to build a new list.
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, listComparator);
        for (ListNode n : lists) {
            while (n!=null) {
                heap.offer(n);
                n = n.next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            cur.next = node;
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }

    private Comparator<ListNode> listComparator = new Comparator<ListNode>(){
        public int compare(ListNode n1, ListNode n2) {
            if (n1 == null) {
                return 1;
            }
            if (n2 == null) {
                return -1;
            }
            return n1.val - n2.val;
        }
    };
    */
}
