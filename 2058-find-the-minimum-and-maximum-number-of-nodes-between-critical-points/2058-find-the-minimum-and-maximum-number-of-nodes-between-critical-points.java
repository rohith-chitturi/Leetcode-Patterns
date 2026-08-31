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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] res=new int[2];
        List<Integer> al=new ArrayList<>();
        if(head==null || head.next==null || head.next.next==null){
            return new int[]{-1,-1};
        }
        ListNode first=head;
        ListNode second=first.next;
        ListNode third=second.next;
        int index=1;
        while(third!=null){
            if(second.val>first.val && second.val>third.val || second.val<first.val && second.val<third.val){
                al.add(index);
            }
            first=first.next;
            second=second.next;
            third=third.next;
            index++;
        }
        if (al.size() < 2) {
            return new int[]{-1, -1};
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<al.size();i++){
            min=Math.min(min,al.get(i)-al.get(i-1));
        }
        int max = al.get(al.size() - 1) - al.get(0);
        res[0] = min;
        res[1] = max;
        return res;
    }
}