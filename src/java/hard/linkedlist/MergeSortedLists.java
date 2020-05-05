package src.java.hard.linkedlist;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)
            return null;
        PriorityQueue<ListNode> pQueue = new PriorityQueue<>((n1, n2) -> (n1.val-n2.val));
        for(int i=0; i<lists.length; i++){
            if (lists[i]==null)
                continue;
            pQueue.offer(lists[i]);
            
        }
        
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        
        while(!pQueue.isEmpty()){
            ListNode temp = pQueue.poll();
            node.next = temp;
            node = node.next;
            if(temp.next!=null)
                pQueue.offer(temp.next);
        }
        return dummy.next;
    }
}

