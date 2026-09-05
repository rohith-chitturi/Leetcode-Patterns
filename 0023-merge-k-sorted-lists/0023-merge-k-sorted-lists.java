/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    static class Compare implements Comparator<ListNode>{
    public int compare(ListNode a,ListNode b){
        return a.val-b.val;
    }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>(new Compare());
        //firstnode of every list inserting into pq
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while(!pq.isEmpty()){
            ListNode curr=pq.poll();
            tail.next=curr;
            tail=tail.next;
            if(curr.next!=null){
                pq.add(curr.next);
            }
        }
        return dummy.next;
    }
}